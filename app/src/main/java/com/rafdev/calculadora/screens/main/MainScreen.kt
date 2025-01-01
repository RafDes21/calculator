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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rafdev.calculadora.screens.main.components.ButtonRow
import com.rafdev.calculadora.ui.theme.CalculatorPalette

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel(),
) {

    val rows = viewModel.uiButtonState.data
    val expression by viewModel.expression
    val result by viewModel.result

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
                    val cursorPosition = it.selection.end
                    viewModel.onExpressionChanged(it.text, cursorPosition)                },
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
                    viewModel.onButtonClicked(symbol)
                })
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun MainScreenPreview(modifier: Modifier = Modifier) {
    MainScreen()
}
