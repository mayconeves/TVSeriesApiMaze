package com.projeto.tvseries.data.api

import com.projeto.tvseries.data.model.ShowResponse
import retrofit2.http.GET
import com.projeto.tvseries.utils.Constants
import retrofit2.Response

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getAllShows(): Response<ShowResponse>

}
