package com.learn.jetpack.mytemperatureconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.learn.jetpack.mytemperatureconverter.ui.theme.MyTemperatureConverterTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTemperatureConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        StatefulTemperatureInput()
                        ConverterApp()
                        TwoWayConverterApp()
                    }
                }
            }
        }
    }
}

@Composable
fun StatefulTemperatureInput(
    modifier: Modifier = Modifier,
) {
    var input by remember { mutableStateOf("") }
    var output by remember { mutableStateOf("") }

    Column(modifier.padding(16.dp)) {
        Text(
            text = stringResource(id = R.string.stateful_converter),
            style = MaterialTheme.typography.headlineSmall
        )
        OutlinedTextField(
            value = input,
            label = { Text(stringResource(id = R.string.enter_celsius)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = {
                input = it
                output = if (it.isNotBlank()) convertToFahrenheit(input) else ""
            }
        )
        Text(text = stringResource(id = R.string.temperature_fahrenheit, output))
    }
}

@Composable
fun StatelessTemperatureInput(
    input: String,
    output: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier.padding(16.dp)) {
        Text(
            text = stringResource(id = R.string.stateless_converter),
            style = MaterialTheme.typography.headlineSmall
        )
        OutlinedTextField(
            value = input,
            label = { Text(stringResource(id = R.string.enter_celsius)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = onValueChange
        )
        Text(text = stringResource(id = R.string.temperature_fahrenheit, output))
    }
}

@Composable
private fun ConverterApp(
    modifier: Modifier = Modifier,
) {
    var input by remember { mutableStateOf("") }
    var output by remember { mutableStateOf("") }
    Column(modifier) {
        StatelessTemperatureInput(
            input = input,
            output = output,
            onValueChange = {
                input = it
                output = if (it.isNotBlank()) convertToFahrenheit(input) else ""
            }
        )

    }
}

@Composable
fun GeneralTemperatureInput(
    scale: Scale,
    input: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier) {
        OutlinedTextField(
            value = input,
            label = { Text(text = stringResource(R.string.enter_temperature, scale.scaleName)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = onValueChange,
        )
    }
}

@Composable
private fun TwoWayConverterApp(
    modifier: Modifier = Modifier
) {
    var celsius by remember { mutableStateOf("") }
    var fahrenheit by remember { mutableStateOf("") }

    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = stringResource(id = R.string.two_way_converter),
            style = MaterialTheme.typography.headlineSmall
        )
        GeneralTemperatureInput(scale = Scale.CELSIUS, input = celsius, onValueChange = {
            celsius = it
            fahrenheit = if (it.isNotBlank()) convertToFahrenheit(it) else ""
        })
        GeneralTemperatureInput(scale = Scale.FAHRENHEIT, input = fahrenheit, onValueChange = {
            fahrenheit = it
            celsius = if (it.isNotBlank()) convertToCelsius(it) else ""
        })
    }

}

fun convertToCelsius(fahrenheit: String): String {
    return fahrenheit.toDoubleOrNull()?.let {
        (it - 32) * 5 / 9
    }.toString()
}

fun convertToFahrenheit(celsius: String): String {
    return celsius.toDoubleOrNull()?.let {
        (it * 9 / 5) + 32
    }.toString()
}

enum class Scale(val scaleName: String) {
    CELSIUS("Celsius"),
    FAHRENHEIT("Fahrenheit")
}
