package com.rafdev.calculadora.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rafdev.calculadora.ui.theme.CalculatorPalette

@Composable
fun ItemButton(
    modifier: Modifier = Modifier,
    symbol: String,
    symColor: Color,
    iconResourceId: Int? = null,
    onClick: () -> Unit,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(CircleShape)
            .background(CalculatorPalette.lightBlack)
            .clickable { onClick() }
            .then(modifier)
    ) {
        iconResourceId?.let {
            Image(
                painter = painterResource(id = it),
                contentDescription = "delete number",
                modifier = Modifier.size(40.dp)
            )
        } ?: run {
            Text(
                text = symbol,
                fontSize = 35.sp,
                color = symColor,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ItemButtonPreview() {
    ItemButton(symbol = "0", symColor = CalculatorPalette.golden, onClick = {})
}