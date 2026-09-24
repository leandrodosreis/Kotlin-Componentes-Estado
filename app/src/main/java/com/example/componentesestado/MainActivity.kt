package com.example.componentesestado

import android.R
import android.R.attr.text
import android.os.Bundle
import android.util.Log
import android.util.Log.i
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentesestado.ui.theme.ComponentesEstadoTheme
import com.example.componentesestado.ui.theme.Righteous

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComponentesEstadoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BasicComponentsScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BasicComponentsScreen (modifier: Modifier = Modifier) {

    var textoInput by remember { mutableStateOf("") }

    val quantidade = remember { mutableStateOf("") }

    var email by remember {
        mutableStateOf("")
    }

    var kotlin by remember {
        mutableStateOf(false)
    }

    var androidStudio by remember {
        mutableStateOf(false)
    }

    var jetpackCompose by remember {
        mutableStateOf(false)
    }

    var serounaoser by remember {
        mutableStateOf(0)
    }

    var corFundo by remember {
        mutableStateOf(Color(239, 247, 207))
    }

    var favoritado by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(corFundo)
    ) {
        Text(
            text = "Aulas android",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color =  Color(0xff3ddc84),
            fontFamily = FontFamily.Serif,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.End,
            letterSpacing = 4.sp
        )
        Text(
            text = "com Jetpack Compose",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color =  Color(66,133,244),
            fontFamily = Righteous,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = textoInput,
            onValueChange = { novoValor ->
                Log.i("teste" , novoValor)
                textoInput = novoValor
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences
            ),
            label = {
                Text("Nome e sobrenome")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Pessoa",
                    tint = Color(66,133,244)
                )
           }
        //            ,
//
//            trailingIcon = {
//                Icon(
//                    imageVector = Icons.Default.Person,
//                    contentDescription = "Pessoa",
//                    tint = Color(66,133,244)
//                )
//            }

        )

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = quantidade.value,
            onValueChange = { novoValor ->
                Log.i("teste" , novoValor)
                quantidade.value= novoValor
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Uri
            ),
            placeholder = {
                Text("Qual a quantidade")
            },
            colors = TextFieldDefaults.colors(
                unfocusedTextColor = Color.Red,
                focusedTextColor = Color.Green,
                unfocusedPlaceholderColor = Color.Magenta
            )
        )

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(
                    text = "Email"
                )
            },
            placeholder = {
                Text(
                    text = "Insira aqui seu email"
                )
            },
            shape = RoundedCornerShape(
                topStart = 32.dp,
                bottomEnd = 32.dp
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Cyan,
                unfocusedBorderColor = Color.Red
            )
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = kotlin,
                onCheckedChange = {kotlin = it},
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Red
                )
            )

            Text(
                text = "Kotlin"
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = androidStudio,
                onCheckedChange = { androidStudio = it},
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Red
                )
            )

            Text(
                text = "Android Studio"
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = jetpackCompose ,
                onCheckedChange = {jetpackCompose =it},
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Red
                )
            )

            Text(
                text = "Jetpack Compose"
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = serounaoser == 0,
                onClick = {serounaoser = 0}
            )
            Text(
                text = "Ser"
            )
        }

        Text("ou")

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = serounaoser == 1,
                onClick = {serounaoser = 1}
            )
            Text(
                text = "Não ser"
            )
        }

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround) {

            Button(
                onClick = {
                    corFundo = Color.White
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.Gray,
                ),
                border = BorderStroke(4.dp, Color.Red),
                shape = RoundedCornerShape(topEnd = 12.dp, bottomEnd = 12.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {

                    Icon(imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Arrow")

                    Text(
                        text = "Play"
                    )
                }
            }

            OutlinedButton(
                onClick = {
                    corFundo = Color(212,67,67)
                }
            ) {
                Text("Clique")
            }
        }

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {

            if (favoritado) {
                Icon(
                    modifier = Modifier.size(40.dp).clickable{
                        favoritado = false
                    },
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite"
                )
            }else {
                Icon(
                    modifier = Modifier.size(40.dp).clickable{
                        favoritado = true
                    },
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Favorite Border"
                )
            }
        }

        AndroidEnemy(
            modifier = Modifier.size(100.dp),
            color = Color.Black
        )
        AndroidEnemy(
            modifier = Modifier.size(100.dp),
            color = Color.Red
        )
    }
}

@Composable
fun AndroidEnemy(
    color: Color,
    modifier: Modifier = Modifier) {

    Image(
        modifier = modifier,
        painter = painterResource(com.example.componentesestado.R.drawable.ic_launcher_foreground),
        colorFilter = ColorFilter.tint(color = color),
        contentDescription = "Android Enemy"
    )
}
