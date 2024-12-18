package com.fruitastic.data.remote.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("token")
	val token: String?,

	@field:SerializedName("user")
	val user: User
)
