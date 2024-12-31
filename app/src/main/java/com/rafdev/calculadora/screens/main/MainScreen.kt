package com.rafdev.calculadora.screens.main

import android.content.res.Resources.Theme
import android.util.Log
import android.widget.EditText
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rafdev.calculadora.components.ItemButton
import com.rafdev.calculadora.domain.buttonData.ButtonData
import com.rafdev.calculadora.domain.model.ButtonModel
import com.rafdev.calculadora.ui.theme.CalculatorPalette

@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    val rows = ButtonData.buttonRows
    var expression by remember { mutableStateOf(TextFieldValue("")) }
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
                    .fillMaxWidth()
                    .onFocusChanged {},
                textStyle = TextStyle(
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ),
                cursorBrush = SolidColor(Color.White),
                singleLine = true
            )
            result?.let {
                Text(text = it)
            }

            rows.forEach { row ->
                ButtonRow(row, onButtonClick = { symbol ->
                    when (symbol) {
                        "AC" -> {
                            expression = TextFieldValue("")
                        }

                        else -> {
                            expression = TextFieldValue(expression.text + symbol)
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
            if (btn.symbol == "=") {
                ItemButton(
                    symbol = btn.symbol,
                    symColor = btn.color,
                    modifier = Modifier
                        .background(CalculatorPalette.golden)
                        .height(80.dp)
                        .weight(2f)
                ) {
                    onButtonClick(btn.symbol)
                }
            } else {
                ItemButton(
                    symbol = btn.symbol,
                    symColor = btn.color,
                    modifier = Modifier
                        .weight(1f)
                        .size(80.dp)
                ) {
                    onButtonClick(btn.symbol)
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
