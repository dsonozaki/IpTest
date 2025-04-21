package com.sonozaki.iptest.core.network

import com.google.gson.JsonParseException
import com.google.gson.stream.MalformedJsonException
import com.sonozaki.iptest.R
import com.sonozaki.iptest.core.ui.UIText
import com.sonozaki.iptest.domain.Mapper
import com.sonozaki.iptest.domain.entitities.RequestResult
import retrofit2.HttpException
import java.io.IOException

/**
 * Function for mapping network request results into [RequestResult]
 */
suspend fun <T, S> safeApiCallWithMapper(
    mapper: Mapper<T, S>,
    apiCall: suspend () -> T
): RequestResult<S> {
    try {
        val result = mapper.map(apiCall())
        return RequestResult.Data(result)
    } catch (_: JsonParseException) {
        return RequestResult.Error(UIText(R.string.cant_parse_result))
    } catch (_: MalformedJsonException) {
        return RequestResult.Error(UIText(R.string.cant_parse_result))
    } catch (e: HttpException) {
        return RequestResult.Error(UIText(R.string.server_error, e.code(), e.message ?: ""))
    } catch (_: IOException) {
        return RequestResult.Error(UIText(R.string.no_internet_connection))
    } catch (e: Exception) {
        return RequestResult.Error(UIText(R.string.unknown_error, e.message?: ""))
    }
}