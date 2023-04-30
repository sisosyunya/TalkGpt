package com.example.talkgpt.viewmodel

import androidx.lifecycle.ViewModel
import com.example.talkgpt.api.ChatAPI
import com.example.talkgpt.model.ChatMessage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel(){
    private val ChatAPI = ChatAPI()
    val messageList = mutableListOf<ChatMessage>()

    fun sendMessage(text:String){
        val message = ChatMessage(text,true)
        messageList.add(message)

        GlobalScope.launch(Dispatchers.IO) {

        }
    }
}