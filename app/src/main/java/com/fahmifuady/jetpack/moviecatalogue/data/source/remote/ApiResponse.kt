package com.fahmifuady.jetpack.moviecatalogue.data.source.remote

import com.fahmifuady.jetpack.moviecatalogue.data.source.remote.StatusResponse.*

class ApiResponse<T> (val status: StatusResponse, val body: T, val message: String?) {

    companion object {
        fun <T> success(body: T): ApiResponse<T> = ApiResponse(SUCCESS, body, null)

        fun <T> empty(body: T, msg: String): ApiResponse<T> = ApiResponse(EMPTY, body, msg)

        fun <T> error(body: T, msg: String): ApiResponse<T> = ApiResponse(ERROR, body, msg)
    }
}