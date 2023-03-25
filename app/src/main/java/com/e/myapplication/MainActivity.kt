package com.e.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerview: RecyclerView
    private lateinit var adapter:CharacterAdapter
    private lateinit var listFragment:ListFragment
    private  var listofcharacters= mutableListOf<CharacterClass>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview=findViewById(R.id.recyclerview)
        recyclerview.layoutManager=LinearLayoutManager(this)
        adapter=CharacterAdapter()
        recyclerview.adapter=adapter

        getRetrofit()
        listofCharacters()
        listFragment=supportFragmentManager.findFragmentById(R.id.fragmentcontainerList) as ListFragment

    }

    private fun listofCharacters() {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(ApiService::class.java).getListOfCharacters()
            val response = call.body()
            runOnUiThread {
                if (call.isSuccessful) {
                    listofcharacters =
                        response?.results?.map { character -> character.MaptoCharacter() }
                                as MutableList<CharacterClass>
                    adapter.submitList(listofcharacters)
                    adapter.OnItemSelectedListener={
                        val b= Bundle()
                        b.putString("gender", it.gender)
                        b.putString("image",it.image)
                        b.putString("type",it.type)
                        b.putString("species",it.species)
                        listFragment.arguments=b

                    }
                } else {
                    adapter.submitList(listOf())

                }
            }
        }
    }
    private fun getRetrofit():Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }


    companion object{
        const val BASE_URL="https://rickandmortyapi.com/api/"
    }
}