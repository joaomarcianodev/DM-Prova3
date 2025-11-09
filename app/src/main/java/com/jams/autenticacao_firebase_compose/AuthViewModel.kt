package com.jams.autenticacao_firebase_compose

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class AuthViewModel : ViewModel() {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    // Expõe o email do usuário atual
    val userEmail: String?
        get() = auth.currentUser?.email

    // Função de logout
    fun signOut() {
        auth.signOut()
    }
}