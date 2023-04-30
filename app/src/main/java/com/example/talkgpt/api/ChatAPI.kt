package com.example.talkgpt.api

import okhttp3.*
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import java.io.IOException

class ChatAPI{
    companion object{
        private const val API_URL = ""
    }
    private val client = OkHttpClient()

    fun sendMessage(text:String,apiKey:String):String{
        val json = JSONObject().apply {
            put("message",text)
            put("apikey",apiKey)
        }

        val body = json.toString().toRequestBody()
        val request = Request.Builder()
            .url(API_URL)
            .post(body)
            .build()

        try {
            val response = client.newCall(request).execute()
            if(response.isSuccessful){
                val responseBody = response.body?.string()
                val json = JSONObject(responseBody)
                return json.getString("response")
            }
        }catch (e:IOException){
            e.printStackTrace()
        }
        return ""
    }
}