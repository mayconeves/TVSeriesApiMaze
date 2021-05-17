package com.projeto.tvseries.data.repository

import com.projeto.tvseries.data.api.ApiService
import javax.inject.Inject

class ShowRepository

@Inject
constructor(private val apiService: ApiService){

    suspend fun getShows() = apiService.getAllShows()

}

