package com.rafdev.calculadora.domain.repository

import com.rafdev.calculadora.domain.model.ButtonModel

interface ButtonRepository {
    fun getDataButtons(): List<List<ButtonModel>>
}