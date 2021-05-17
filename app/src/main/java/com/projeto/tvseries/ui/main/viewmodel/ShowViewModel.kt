package com.projeto.tvseries.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projeto.tvseries.data.model.ShowItem
import com.projeto.tvseries.data.repository.ShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowViewModel
@Inject
constructor(private val repository: ShowRepository) : ViewModel() {

    private val _response = MutableLiveData<List<ShowItem>>()

    val responseShow: LiveData<List<ShowItem>>
        get() = _response

    init{
        getAllShows()
    }

    private fun getAllShows() = viewModelScope.launch{
        try {
            repository.getShows().let { response ->
                if (response.isSuccessful) {
                    _response.postValue(response.body())
                } else {
                    Log.d("TAG", "getAllShows Error: ${response.code()}")
                }
            }
        } catch (e: Exception){
            e.printStackTrace()
        }
    }
}