package com.jorgearceruiz97.ejercicio_1_5_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jorgearceruiz97.ejercicio_1_5_compose.ui.theme.Ejercicio_1_5_ComposeTheme
import com.jorgearceruiz97.ejercicio_1_5_compose.screens.Actividad1
import com.jorgearceruiz97.ejercicio_1_5_compose.screens.Actividad3
import com.jorgearceruiz97.ejercicio_1_5_compose.screens.Actividad4
import com.jorgearceruiz97.ejercicio_1_5_compose.screens.Actividad5

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        //llama a todas las actividades
        super.onCreate(savedInstanceState)
        setContent {
            Ejercicio_1_5_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                    Actividad5()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ejercicio_1_5_ComposeTheme {
        Greeting("Android")
    }
}