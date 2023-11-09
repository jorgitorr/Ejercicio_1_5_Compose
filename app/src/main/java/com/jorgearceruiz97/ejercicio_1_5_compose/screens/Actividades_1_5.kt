package com.jorgearceruiz97.ejercicio_1_5_compose.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/*
Actividad 1:
Hacer que el texto del botón muestre "Cargar perfil", pero cambie a "Cancelar"
cuando se muestre la línea de progreso... Cuando pulsemos "Cancelar" vuelve al texto por defecto.
*/
//@Preview(showBackground = true)
@Composable
fun Actividad1() {
    var showLoading by rememberSaveable { mutableStateOf(false) }
    var txtButton by rememberSaveable {
        mutableStateOf("Cargar perfil")
    }

    var tamanioPadding by rememberSaveable {
        mutableStateOf(0)
    }

    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (showLoading) {
            txtButton = "Cancelar"
            tamanioPadding = 30
            CircularProgressIndicator(
                color = Color.Red,
                strokeWidth = 10.dp
            )
            LinearProgressIndicator(
                modifier = Modifier.padding(top = 32.dp),
                color = Color.Red,
                trackColor = Color.LightGray
            )
        }else{
            txtButton = "Cargar perfil"
            tamanioPadding = 30
        }

        Button(
            onClick = { showLoading = !showLoading } //evento
        , modifier = Modifier.padding(top = tamanioPadding.dp)) {

            Text(text = txtButton)
        }
    }
}

/*
Actividad 2:
Modifica ahora también que se separe el botón de la línea de progreso 30 dp,
pero usando un estado... es decir, cuando no sea visible no quiero que tenga la separación
aunque no se vea.
*/

/*creamos una variable rememberSaveable con un tamaño de cero,
* si no está cargando cambiamos el tamaño a 30
* y en el boton ponemos un modifier.padding(que tenga un tamaño de top que sea el del padding)
* */


/*
Actividad 3:
- Separar los botones entre ellos 10 dp, del indicador de progreso 15 dp y centrarlos horizontalmente.
- Cuando se clique el botón Incrementar, debe añadir 0.1 a la propiedad progress
y quitar 0.1 cuando se pulse el botón Decrementar.
- Evitar que nos pasemos de los márgenes de su propiedad progressStatus (0-1)
*/
//@Preview(showBackground = true)
@Composable
fun Actividad3() {

    var progress by rememberSaveable {
        mutableStateOf(0f)
    }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if(progress>1.0f)
            progress = 1.0f
        else if(progress<0f)
            progress = 0f

        LinearProgressIndicator(progress = progress)

        Row(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.CenterHorizontally),//centra horizontalmente la fila con el contenido
            horizontalArrangement = Arrangement.Center // centra horizontalmente el contenido
        ) {
            Button(onClick = {progress += 0.1f}, modifier = Modifier.padding(end = 10.dp, top = 15.dp)) {
                Text(text = "Incrementar")
            }
            Button(onClick = {progress -= 0.1f}, modifier = Modifier.padding(top = 15.dp)) {
                Text(text = "Reducir")
            }
        }
    }
}


/*
Actividad 4:
Sitúa el TextField en el centro de la pantalla y haz que reemplace el valor de una coma por un punto
y que no deje escribir más de un punto decimal...
*/
@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Actividad4() {
    var myVal by rememberSaveable { mutableStateOf("") }

    TextField(
        value = myVal,
        onValueChange = { var newValue = it
            if(newValue.contains(',')){
                newValue = newValue.replace(',','.')
            }
            if(newValue.count{ c:Char -> c == '.'} <= 1){
                myVal= newValue
            }
        },
        label = { Text(text = "Importe") }
    )
}


/*
Actividad 5:
Haz lo mismo, pero elevando el estado a una función superior y usando un componente OutlinedTextField
al que debes añadir un padding alrededor de 15 dp y establecer colores diferentes en los bordes
cuando tenga el foco y no lo tenga.
A nivel funcional no permitas que se introduzcan caracteres que invaliden un número decimal.
*/
//@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Actividad5() {
    var myVal by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier.padding(15.dp),
        value = myVal,
        onValueChange = { myVal = it },
        label = { Text(text = "Importe") }
    )
}
