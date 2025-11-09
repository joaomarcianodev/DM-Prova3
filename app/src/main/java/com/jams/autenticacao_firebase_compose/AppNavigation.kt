package com.jams.autenticacao_firebase_compose

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation(startDestination: String) {

    // O NavController é o cérebro da navegação
    val navController = rememberNavController()

    // O NavHost é o "container" que troca as telas
    NavHost(navController = navController, startDestination = startDestination) {

        // Rota para a Tela de Login
        composable("login") {
            LoginScreen(
                onLoginSuccess = {
                    // Navega para "home" e limpa a pilha de login
                    navController.navigate("home") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                onNavigateToSignUp = {
                    // Navega para a tela de registro
                    navController.navigate("signup")
                }
            )
        }

        // Rota para a Tela de Registro
        composable("signup") {
            SignUpScreen(
                onSignUpSuccess = {
                    // Volta para a tela anterior (Login)
                    navController.popBackStack()
                },
                onNavigateToLogin = {
                    // Volta para a tela anterior (Login)
                    navController.popBackStack()
                }
            )
        }

        // Rota para a Tela Principal (Home)
        composable("home") {
            HomeScreen(
                onSignOut = {
                    // Navega para login e limpa a pilha
                    navController.navigate("login") {
                        popUpTo("home") { inclusive = true }
                    }
                }
            )
        }
    }
}