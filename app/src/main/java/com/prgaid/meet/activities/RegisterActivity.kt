package com.prgaid.meet.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prgaid.meet.MainActivity
import com.prgaid.meet.ui.theme.MeetTheme

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        enableEdgeToEdge()
        setContent {
            var text by remember { mutableStateOf(TextFieldValue("")) }
            var motDePasse by remember { mutableStateOf("") }
            var passwordVisible by remember { mutableStateOf(false) }
            val context = LocalContext.current
            MeetTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // Champ pour le Nom
                        TextField(
                            value = text,
                            onValueChange = {
                                text = it
                            },
                            label = { Text(text = "name") },
                            placeholder = { Text(text = "DOSOUTO") },
                        )
                        Spacer(Modifier.padding(6.dp))
                        TextField(
                            value = text,
                            onValueChange = {
                                text = it
                            },
                            label = { Text(text = "surename") },
                            placeholder = { Text(text = "Antoinin") },
                        )
                        Spacer(Modifier.padding(6.dp))
                        TextField(
                            value = text,
                            onValueChange = {
                                text = it
                            },
                            label = { Text(text = "Email") },
                            placeholder = { Text(text = "exemle@gmail.com") },
                        )
                        Spacer(Modifier.padding(6.dp))
                        OutlinedTextField(
                            value = motDePasse,
                            onValueChange = { motDePasse = it },
                            label = { Text("Mot de passe") },
                            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            trailingIcon = {
                                val icon =
                                    if (passwordVisible) "🙈" else "👁️"  // icône pour afficher/masquer le mot de passe
                                Text(
                                    icon,
                                    Modifier.clickable { passwordVisible = !passwordVisible })

                            }
                        )
                        Button(
                            onClick = {

                                val intent = Intent(context, MainActivity::class.java)
                                context.startActivity(intent)
                            },
                            modifier = Modifier.padding(6.dp),
                            colors = ButtonDefaults.buttonColors(Color.Cyan)
                        ) {
                            Text(text = "RETURN", fontSize = 18.sp)
                        }

                    }

                }

            }
        }
    }

}