package com.rafdev.calculadora.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rafdev.calculadora.BuildConfig
import com.rafdev.calculadora.R
import com.rafdev.calculadora.ui.theme.CalculatorPalette
import com.rafdev.calculadora.util.Constants

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                CalculatorPalette.darkBlue,
            ),
    ) {
        Image(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .align(Alignment.Center) ,
            painter = painterResource(id = R.drawable.logo_splash),
            contentDescription = "logo"
        )

        CircularProgressIndicator(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 170.dp),
            color = CalculatorPalette.golden
        )

        Text(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 60.dp),
            color = CalculatorPalette.golden,
            text = "V ${Constants.APP_VERSION}"
        )

    }
}

@Preview(showSystemUi = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}