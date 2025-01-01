package com.rafdev.calculadora.util

import com.rafdev.calculadora.BuildConfig

object Constants{
    const val APP_VERSION = BuildConfig.VERSION_NAME

}

object CalculatorAction{
    const val ALL_CLEAR = "AC"
    const val BACKSPACE = "backspace"
    const val EQUALS = "="
}

object CalculatorErrors {
    const val SYNTAX_ERROR = "Error de sintaxis"
    const val ARITHMETIC_ERROR = "Error aritmético"
    const val UNKNOWN_ERROR = "Error desconocido"
}