package com.cyberconnnect.link3

import android.text.TextUtils
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.ApolloRequest
import com.apollographql.apollo3.api.ApolloResponse
import com.apollographql.apollo3.api.Operation
import com.apollographql.apollo3.cache.normalized.FetchPolicy
import com.apollographql.apollo3.cache.normalized.api.MemoryCacheFactory
import com.apollographql.apollo3.cache.normalized.fetchPolicy
import com.apollographql.apollo3.cache.normalized.normalizedCache
import com.apollographql.apollo3.interceptor.ApolloInterceptor
import com.apollographql.apollo3.interceptor.ApolloInterceptorChain
import kotlinx.coroutines.flow.Flow
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import timber.log.Timber

object ApolloClient {
    val debug = false

    val host = if (debug) "https://api.stg.cyberconnect.dev/profile/" else "https://api.cyberconnect.dev/profile/"

    var accessToken: String = ""
        set(value) {
            apolloClient = if (!TextUtils.isEmpty(value)) {
                ApolloClient.Builder()
                    .serverUrl(host)
                    .addInterceptor(RequestInterceptor(value))
                    .fetchPolicy(FetchPolicy.NetworkOnly)
                    .normalizedCache(cacheFactory)
                    .build()
            } else {
                ApolloClient.Builder()
                    .serverUrl(host)
                    .addInterceptor(NotLoginRequestInterceptor)
                    .fetchPolicy(FetchPolicy.NetworkOnly)
                    .normalizedCache(cacheFactory)
                    .build()
            }
        }

    val cacheFactory = MemoryCacheFactory(maxSizeBytes = 10 * 1024 * 1024)

    var apolloClient = ApolloClient.Builder()
        .serverUrl(host)
        .addInterceptor(NotLoginRequestInterceptor)
        .fetchPolicy(FetchPolicy.NetworkOnly)
        .normalizedCache(cacheFactory)
        .build()

    var okHttpClient = OkHttpClient()

}

class RequestInterceptor(val accessToken: String) : ApolloInterceptor {
    override fun <D : Operation.Data> intercept(
        request: ApolloRequest<D>,
        chain: ApolloInterceptorChain
    ): Flow<ApolloResponse<D>> {
        Timber.tag("hercule").i("Outgoing request ${request.operation} | header:${request.httpHeaders}")
        return chain.proceed(request.newBuilder().addHttpHeader("Authorization", accessToken).addHttpHeader("Platform", "Android").build())
    }
}
object NotLoginRequestInterceptor: ApolloInterceptor {
    override fun <D : Operation.Data> intercept(
        request: ApolloRequest<D>,
        chain: ApolloInterceptorChain
    ): Flow<ApolloResponse<D>> {
        Timber.tag("hercule").i("Outgoing request ${request.operation} | header:${request.httpHeaders}")
        return chain.proceed(request)
    }
}