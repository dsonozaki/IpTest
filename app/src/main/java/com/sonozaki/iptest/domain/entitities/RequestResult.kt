package com.sonozaki.iptest.domain.entitities

import com.sonozaki.iptest.core.ui.UIText

/**
 * Class for request results representation
 */
sealed class RequestResult<T> {
    data class Data<T>(val data: T) : RequestResult<T>()
    data class Error<T>(val errorDescription: UIText) : RequestResult<T>()
}