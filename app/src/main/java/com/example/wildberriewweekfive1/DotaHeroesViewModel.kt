package com.example.wildberriewweekfive1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import java.lang.reflect.Type

open class DotaHeroesViewModel : ViewModel() {

    val itemsDotaHeroes = MutableLiveData<List<DotaHeroesJSON>>()
    private val client = OkHttpClient()
    private val moshi = Moshi.Builder().build()
    var listMyData: Type = Types.newParameterizedType(
        MutableList::class.java,
        DotaHeroesJSON::class.java
    )
    var jsonAdapter: JsonAdapter<List<DotaHeroesJSON>> = moshi.adapter<List<DotaHeroesJSON>>(listMyData)

    private var job: Job? = null

    fun request() {
        job?.cancel()
        job = viewModelScope.launch(Dispatchers.IO) {


            val request = Request.Builder()
                .url("https://api.opendota.com/api/heroStats")
                .build()

            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) throw IOException("Unexpected code $response")

                val dotaHeroes = jsonAdapter.fromJson(response.body!!.source())

                itemsDotaHeroes.postValue(dotaHeroes!!)
            }


        }

    }

}