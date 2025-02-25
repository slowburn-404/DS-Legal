package com.dslegal.network.services.auth.mappers

import com.dslegal.network.model.ErrorBody
import java.lang.Exception

internal fun Exception.toErrorBody(): ErrorBody {
    return ErrorBody(
        status = "",
        statusCode = 0,
        message = "Unexpected error: ${this.localizedMessage}"
    )
}
