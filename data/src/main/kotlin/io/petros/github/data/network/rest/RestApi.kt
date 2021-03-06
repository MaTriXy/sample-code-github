package io.petros.github.data.network.rest

import io.petros.github.data.network.rest.response.repository.RepoDetails
import io.petros.github.data.network.rest.response.repository.RepositoryResultsResponse
import io.petros.github.data.network.rest.response.subscriber.Sub
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RestApi {

    @GET("search/repositories")
    fun searchRepositories(
        @Query("q") searchTerm: String
    ): Single<RepositoryResultsResponse>

    @GET("repos/{login}/{name}")
    fun repositoryDetails(
        @Path("login") login: String,
        @Path("name") name: String
    ): Single<RepoDetails>

    @GET("repos/{login}/{name}/subscribers")
    fun subscribers(
        @Path("login") login: String,
        @Path("name") name: String
    ): Single<Array<Sub>>

}
