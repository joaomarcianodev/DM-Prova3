package com.jams.autenticacao_firebase_compose

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jams.autenticacao_firebase_compose.ui.theme.AutentiçãoFirebaseComposeTheme

@Composable
fun HomeScreen(
    onSignOut: () -> Unit,
    viewModel: AuthViewModel = viewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Text "Bem-vindo!"
        Text(
            text = "Bem-vindo!",
            fontSize = 24.sp,
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Text do email do usuário
        Text(
            // Obtém o email do ViewModel, de forma segura
            text = viewModel.userEmail ?: "Email não encontrado",
            fontSize = 20.sp,
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Botão Sair
        Button(
            onClick = {
                // Lógica de logout do MainActivity.kt original
                viewModel.signOut()
                onSignOut() // Chama a navegação
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        ) {
            Text(text = "Sair", fontSize = 18.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    AutentiçãoFirebaseComposeTheme {
        // A correção é passar uma função vazia para o onSignOut
        // apenas para o preview funcionar.
        HomeScreen(onSignOut = {})
    }
}