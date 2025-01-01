package com.rafdev.calculadora.screens.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.rafdev.calculadora.domain.model.ButtonModel
import com.rafdev.calculadora.domain.usecase.GetDataButtonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getDataButtonUseCase: GetDataButtonUseCase) :
    ViewModel() {

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


}

data class DataButtonState(
    val data: List<List<ButtonModel>> = emptyList()
)