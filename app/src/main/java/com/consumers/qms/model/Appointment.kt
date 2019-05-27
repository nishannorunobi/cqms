package com.consumers.qms.model

data class Appointment(
    val id:Int,
    val userId : User,
    val serviceProviderId : ServiceProvider,
    val tokenNo : String,
    val serialNo : String

)
