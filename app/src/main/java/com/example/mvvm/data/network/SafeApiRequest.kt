package com.example.mvvm.data.network

import com.example.mvvm.util.ApiException
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import java.lang.StringBuilder

abstract class SafeApiRequest {
    suspend fun<T: Any> apiRequest(call: suspend () -> Response<T>): T{
        val response = call.invoke()
        if (response.isSuccessful) return response.body()!!
        else{
            val message = StringBuilder()
            response.errorBody()?.string().let {
                try {
                    message.append(JSONObject(it).getString("message"))
                }
                catch (e: JSONException){}
                message.append("\n")
            }
            message.append("Error code: ${response.code()}")
            throw ApiException(message.toString())
        }
    }
}