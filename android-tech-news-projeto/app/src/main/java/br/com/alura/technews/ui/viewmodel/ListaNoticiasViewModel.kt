package br.com.alura.technews.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel

class ListaNoticiasViewModel : ViewModel() {

    // executado durante a construção do objeto
    init {
        Log.i("viewmodel", "criando viewmodel")
    }

    // chamado quando viewmodel é destruído
    override fun onCleared() {
        super.onCleared()
        Log.i("viewmodel", "destruindo viewmodel")
    }
}