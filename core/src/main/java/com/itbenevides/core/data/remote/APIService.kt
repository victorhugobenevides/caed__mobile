package com.itbenevides.core.data.remote

import com.itbenevides.core.data.model.Packages
import com.itbenevides.core.data.model.ResponseLogin
import com.itbenevides.core.data.model.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Interface para comunicação com a API usando Retrofit.
 */
interface APIService {

    /**
     * Realiza o login do usuário.
     *
     * @param user Objeto contendo as credenciais do usuário.
     * @return Resposta do login como [ResponseLogin].
     */
    @POST("login")
    suspend fun login(
        @Body user: User
    ): ResponseLogin

    /**
     * Obtém a lista de pacotes.
     *
     * @return Lista de pacotes como [Packages].
     */
    @GET("packages")
    suspend fun getPackages(): Packages
}
