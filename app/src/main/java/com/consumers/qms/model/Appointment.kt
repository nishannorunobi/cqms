package com.consumers.qms.model

data class Appointment(
    val id:Int,
    val consumerUserId : ConsumerUser,
    val serviceProviderUserId : ServiceProviderUser,
    val tokenNo : String,
    val serialNo : Int

)
