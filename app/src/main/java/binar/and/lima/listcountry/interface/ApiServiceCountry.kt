package binar.and.lima.listcountry.`interface`

import binar.and.lima.listcountry.model.GetAllCountryResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiServiceCountry {

    @GET("country")
    fun getAllCountry() : Call<List<GetAllCountryResponseItem>>
}