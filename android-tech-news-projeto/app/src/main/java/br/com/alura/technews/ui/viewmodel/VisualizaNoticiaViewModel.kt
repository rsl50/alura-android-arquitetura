package br.com.alura.technews.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.alura.technews.repository.NoticiaRepository
import br.com.alura.technews.repository.Resource

class VisualizaNoticiaViewModel (
    private val id: Long,
    private val repository: NoticiaRepository
) : ViewModel(){

    private val noticiaEncontrada = buscaPorId()

    // este valor é retornado pela activity, mantendo a coerência com o ciclo de vida
    // permitindo assim o envio do retorno para property 'noticiaEncontrada'
    fun buscaPorId() = repository.buscaPorId(id)

    fun remove(): LiveData<Resource<Void?>> {
        return noticiaEncontrada.value?.run {
            //caso o value não seja nulo, o retorno será o abaixo
            repository.remove(this)
        } ?: MutableLiveData<Resource<Void?>>().also {
            //caso o value seja nulo, então o então o retorno será MutableLiveData<Resource<Void?>> aqui referenciado como 'it'
            it.value = Resource(null, "Notícia não encontrada")
        }
    }
}