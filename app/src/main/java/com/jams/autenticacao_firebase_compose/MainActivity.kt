package com.jams.autenticacao_firebase_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.google.firebase.auth.FirebaseAuth
import com.jams.autenticacao_firebase_compose.ui.theme.AutentiçãoFirebaseComposeTheme

class MainActivity : ComponentActivity() {

    private val auth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AutentiçãoFirebaseComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Verifica se o usuário está logado para definir a rota inicial
                    val startDestination = if (auth.currentUser != null) {
                        "home" // Rota para a tela principal
                    } else {
                        "login" // Rota para a tela de login
                    }

                    AppNavigation(startDestination = startDestination)
                }
            }
        }
    }
}