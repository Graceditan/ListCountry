package binar.and.lima.listcountry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import binar.and.lima.listcountry.adapter.AdapterCountry
import binar.and.lima.listcountry.model.GetAllCountryResponseItem
import binar.and.lima.listcountry.network.ApiClientCountry
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getDataCountry()

    }

    fun getDataCountry(){
        ApiClientCountry.instance.getAllCountry()
            .enqueue(object : retrofit2.Callback<List<GetAllCountryResponseItem>>{
                override fun onResponse(
                    call: Call<List<GetAllCountryResponseItem>>,
                    response: Response<List<GetAllCountryResponseItem>>
                ) {
                    if(response.isSuccessful){
                        val dataCountry = response.body()
                        val adapterFilm  = AdapterCountry(dataCountry!!)
                        val lm = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL,false)
                        rv_country.layoutManager = lm
                        rv_country.adapter = adapterFilm

                    }
                    Log.i("datacountry", response.body().toString())

                //else{
                        //Toast.makeText(this@MainActivity, response.message(), Toast.LENGTH_LONG).show()

                    //}

                }

                override fun onFailure(call: Call<List<GetAllCountryResponseItem>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.message , Toast.LENGTH_LONG).show()
                }


            })
    }
}