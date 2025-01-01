package com.rafdev.calculadora.data.buttonData

import com.rafdev.calculadora.domain.model.ButtonModel
import com.rafdev.calculadora.ui.theme.CalculatorPalette
import com.rafdev.calculadora.util.CalculatorAction.ALL_CLEAR
import com.rafdev.calculadora.util.CalculatorAction.BACKSPACE
import com.rafdev.calculadora.util.CalculatorAction.EQUALS

object ButtonData {

    val buttonRows: List<List<ButtonModel>> = listOf(
        listOf(
            ButtonModel(ALL_CLEAR, CalculatorPalette.golden),
            ButtonModel("()", CalculatorPalette.golden),
            ButtonModel("%", CalculatorPalette.golden),
            ButtonModel("/", CalculatorPalette.golden)
        ),
        listOf(
            ButtonModel("1", CalculatorPalette.lightSkyBlue),
            ButtonModel("2", CalculatorPalette.lightSkyBlue),
            ButtonModel("3", CalculatorPalette.lightSkyBlue),
            ButtonModel("+", CalculatorPalette.golden)
        ),
        listOf(
            ButtonModel("4", CalculatorPalette.lightSkyBlue),
            ButtonModel("5", CalculatorPalette.lightSkyBlue),
            ButtonModel("6", CalculatorPalette.lightSkyBlue),
            ButtonModel("-", CalculatorPalette.golden)
        ),
        listOf(
            ButtonModel("7", CalculatorPalette.lightSkyBlue),
            ButtonModel("8", CalculatorPalette.lightSkyBlue),
            ButtonModel("9", CalculatorPalette.lightSkyBlue),
            ButtonModel("*", CalculatorPalette.golden)
        ),
        listOf(
            ButtonModel("0", CalculatorPalette.lightSkyBlue),
            ButtonModel(".", CalculatorPalette.lightSkyBlue),
            ButtonModel(BACKSPACE, CalculatorPalette.lightSkyBlue),
            ButtonModel(EQUALS, CalculatorPalette.white)
        )
    )
}