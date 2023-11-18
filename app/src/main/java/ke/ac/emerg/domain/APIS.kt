package ke.ac.emerg.domain

import ke.ac.emerg.domain.model.remote.Consultation
import ke.ac.emerg.domain.model.remote.LoginResponse
import ke.ac.emerg.util.CONSTANTS.API
import ke.ac.emerg.util.CONSTANTS.AUTH_API
import ke.ac.emerg.util.DataWrapper
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import javax.inject.Singleton

@Singleton
interface ConsultationsAPI{

    @GET("/consultations")
    @Headers(
        "Bearer token :" +
                "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NTNmYTFlYjZjOGZmN2ZhNjc5MmZlMmYiLCJpYXQiOjE3MDAyOTExODZ9.NRR4_0X8saEjIVpE38rzJXfwzaKpt_5aJFyLQtTLSTs"
    )
    suspend fun getConsultations() : ArrayList<Consultation>

}

@Singleton
interface AUTHApi{

    @POST("/auth/login")
    suspend fun Login(@Body registrationNumber : String) : LoginResponse
}