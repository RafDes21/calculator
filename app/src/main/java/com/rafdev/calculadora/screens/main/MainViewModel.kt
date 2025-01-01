package com.rafdev.calculadora.screens.main

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import com.rafdev.calculadora.domain.model.ButtonModel
import com.rafdev.calculadora.domain.usecase.GetDataButtonUseCase
import com.rafdev.calculadora.util.CalculatorAction
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getDataButtonUseCase: GetDataButtonUseCase) :
    ViewModel() {

    private val _expression = mutableStateOf(TextFieldValue(" "))
    val expression: State<TextFieldValue> = _expression

    private val _result = mutableStateOf<String?>(null)
    val result: State<String?> = _result

    var uiButtonState by mutableStateOf(DataButtonState())
        private set

    init {
        loadButtons()
    }

    private fun loadButtons() {
        val dataBtn = getDataButtonUseCase()
        uiButtonState = uiButtonState.copy(
            data = dataBtn
        )
    }

    fun onExpressionChanged(newText: String, cursorPosition: Int) {
        _expression.value = TextFieldValue(newText, TextRange(cursorPosition))
    }
    fun onButtonClicked(symbol: String) {
        val cursorPosition = _expression.value.selection.end
        when (symbol) {
            CalculatorAction.ALL_CLEAR -> {
                _result.value = null
                _expression.value = TextFieldValue(" ", TextRange.Zero)
            }

            CalculatorAction.BACKSPACE -> {
                if (cursorPosition > 0) {
                    val newText =
                        _expression.value.text.removeRange(cursorPosition - 1, cursorPosition)
                    _expression.value = TextFieldValue(
                        newText,
                        TextRange(cursorPosition - 1)
                    )
                }
            }

            CalculatorAction.EQUALS -> {
                try {
                    val expressionString = _expression.value.text.trim()
                    if (expressionString.isNotEmpty()) {
                        val expr =
                            net.objecthunter.exp4j.ExpressionBuilder(expressionString)
                                .build()
                        val calculatedResult = expr.evaluate()
                        _result.value = calculatedResult.toString()
                    }
                } catch (e: IllegalArgumentException) {
                    _result.value = "Error de sintaxis"
                } catch (e: ArithmeticException) {
                    _result.value = "Error aritmético"
                } catch (e: Exception) {
                    _result.value = "Error desconocido"
                }
            }

            else -> {
                val textBeforeCursor =
                    _expression.value.text.substring(0, cursorPosition).trimEnd()
                val lastChar = textBeforeCursor.lastOrNull()

                val newText = buildString {
                    append(_expression.value.text.substring(0, cursorPosition))

                    if (lastChar in listOf('+', '-', '*', '/', '%') && symbol in listOf(
                            "+",
                            "-",
                            "*",
                            "/",
                            "%"
                        )
                    ) {
                        delete(length - 1, length)
                    }

                    append(symbol)
                    append(_expression.value.text.substring(cursorPosition))
                }

                val newCursorPosition =
                    if (lastChar in listOf('+', '-', '*', '/', '%') && symbol in listOf(
                            "+",
                            "-",
                            "*",
                            "/",
                            "%"
                        )
                    ) {
                        cursorPosition
                    } else {
                        cursorPosition + symbol.length
                    }

                _expression.value = TextFieldValue(
                    newText,
                    TextRange(newCursorPosition)
                )

            }
        }
    }


}

data class DataButtonState(
    val data: List<List<ButtonModel>> = emptyList()
)