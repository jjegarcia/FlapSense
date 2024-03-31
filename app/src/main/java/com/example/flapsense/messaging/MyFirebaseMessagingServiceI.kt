package com.example.flapsense.messaging

interface MyFirebaseMessagingServiceI {
    fun getMyToken(): String
    fun setMessage()
}