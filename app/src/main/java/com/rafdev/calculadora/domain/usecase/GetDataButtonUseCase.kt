package com.rafdev.calculadora.domain.usecase

import com.rafdev.calculadora.domain.model.ButtonModel
import com.rafdev.calculadora.domain.repository.ButtonRepository
import javax.inject.Inject

class GetDataButtonUseCase @Inject constructor(private val repository: ButtonRepository) {

    operator fun invoke(): List<List<ButtonModel>>  = repository.getDataButtons()

}