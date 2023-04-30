package com.example.talkgpt.viewmodel

import androidx.lifecycle.ViewModel
import com.example.talkgpt.api.ChatAPI
import com.example.talkgpt.model.ChatMessage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel(){
    private val chatAPI = ChatAPI()
    val messageList = mutableListOf<ChatMessage>()

    fun sendMessage(text:String){
        val message = ChatMessage(text,true)
        messageList.add(message)
        GlobalScope.launch(Dispatchers.IO) {
            val response = chatAPI.sendMessage(text, API_KEY)
            val chatMessage = ChatMessage(response,false)
            messageList.add(chatMessage)
        }
    }
    companion object{
        private const val API_KEY = "apikey"
    }
}