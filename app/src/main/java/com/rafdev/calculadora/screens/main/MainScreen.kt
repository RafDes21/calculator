package com.rafdev.calculadora.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rafdev.calculadora.R
import com.rafdev.calculadora.components.ItemButton
import com.rafdev.calculadora.domain.model.ButtonModel
import com.rafdev.calculadora.ui.theme.CalculatorPalette
import com.rafdev.calculadora.util.CalculatorAction.ALL_CLEAR
import com.rafdev.calculadora.util.CalculatorAction.BACKSPACE
import com.rafdev.calculadora.util.CalculatorAction.EQUALS

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel(),
) {

    val rows = viewModel.uiButtonState.data
    var expression by remember { mutableStateOf(TextFieldValue(" ")) }
    var result by remember { mutableStateOf<String?>(null) }

    val keyboardController = LocalSoftwareKeyboardController.current
    keyboardController?.hide()

    Box(
        modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        CalculatorPalette.lightBlue,
                        CalculatorPalette.darkBlue,
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Spacer(modifier = Modifier.weight(1f))

            BasicTextField(
                value = expression,
                onValueChange = {
                    expression = it
                },
                modifier = Modifier
                    .wrapContentWidth()
                    .align(Alignment.End)
                    .width(IntrinsicSize.Min)
                    .onFocusChanged {
                        if (it.isFocused) {
                            keyboardController?.hide()
                        }
                    },
                textStyle = TextStyle(
                    fontSize = 55.sp,
                    color = CalculatorPalette.white
                ),
                cursorBrush = SolidColor(Color.White),
                singleLine = true,
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                contentAlignment = Alignment.BottomEnd
            ) {
                result?.let {
                    Text(
                        text = it,
                        fontSize = 50.sp,
                        color = CalculatorPalette.lightSkyBlue,
                        modifier = Modifier
                    )
                }
            }

            rows.forEach { row ->
                ButtonRow(row, onButtonClick = { symbol ->
                    val cursorPosition = expression.selection.end
                    when (symbol) {
                        ALL_CLEAR -> {
                            result = null
                            expression = TextFieldValue(" ", TextRange.Zero)
                        }

                        BACKSPACE -> {
                            if (cursorPosition > 0) {
                                val newText =
                                    expression.text.removeRange(cursorPosition - 1, cursorPosition)
                                expression = TextFieldValue(
                                    newText,
                                    TextRange(cursorPosition - 1)
                                )
                            }
                        }

                        EQUALS -> {
                            try {
                                val expressionString = expression.text.trim()
                                if (expressionString.isNotEmpty()) {
                                    val expr =
                                        net.objecthunter.exp4j.ExpressionBuilder(expressionString)
                                            .build()
                                    val calculatedResult = expr.evaluate()
                                    result = calculatedResult.toString()
                                }
                            } catch (e: IllegalArgumentException) {
                                result = "Error de sintaxis"
                            } catch (e: ArithmeticException) {
                                result = "Error aritmético"
                            } catch (e: Exception) {
                                result = "Error desconocido"
                            }
                        }

                        else -> {
                            val textBeforeCursor =
                                expression.text.substring(0, cursorPosition).trimEnd()
                            val lastChar = textBeforeCursor.lastOrNull()

                            val newText = buildString {
                                append(expression.text.substring(0, cursorPosition))

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
                                append(expression.text.substring(cursorPosition))
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

                            expression = TextFieldValue(
                                newText,
                                TextRange(newCursorPosition)
                            )

                        }
                    }
                })
            }
        }
    }
}

@Composable
fun ButtonRow(
    buttons: List<ButtonModel>,
    onButtonClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        buttons.forEach { btn ->
            when (btn.symbol) {
                EQUALS -> {
                    ItemButton(
                        symbol = btn.symbol,
                        symColor = btn.color,
                        modifier = Modifier
                            .background(CalculatorPalette.lightGolden)
                            .height(82.dp)
                            .weight(1f)
                    ) {
                        onButtonClick(btn.symbol)
                    }
                }

                BACKSPACE -> {
                    ItemButton(
                        symbol = "",
                        symColor = btn.color,
                        onClick = { onButtonClick(btn.symbol) },
                        modifier = Modifier
                            .weight(1f)
                            .size(82.dp),
                        iconResourceId = R.drawable.ic_backspace
                    )
                }

                else -> {
                    ItemButton(
                        symbol = btn.symbol,
                        symColor = btn.color,
                        modifier = Modifier
                            .weight(1f)
                            .size(82.dp)
                    ) {
                        onButtonClick(btn.symbol)
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MainScreenPreview(modifier: Modifier = Modifier) {
    MainScreen()
}
