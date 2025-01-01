package com.rafdev.calculadora.data.repository

import com.rafdev.calculadora.data.buttonData.ButtonData
import com.rafdev.calculadora.domain.model.ButtonModel
import com.rafdev.calculadora.domain.repository.ButtonRepository
import javax.inject.Inject

class ButtonRepositoryImpl @Inject constructor() : ButtonRepository {
    override fun getDataButtons():List<List<ButtonModel>>  {
        return ButtonData.buttonRows
    }
}