package com.dslegal.data.mappers

import com.dslegal.domain.models.User
import com.dslegal.network.services.auth.model.ForgotPasswordRequestBody
import com.dslegal.network.services.auth.model.LoginRequestBody
import com.dslegal.network.services.auth.model.RegisterRequestBody
import com.dslegal.network.services.auth.model.ResetPasswordRequestBody

internal fun String.toForgotPasswordRequestBody(): ForgotPasswordRequestBody {
    return ForgotPasswordRequestBody(
        email = this
    )
}

internal fun String.toResetPasswordRequestBody(): ResetPasswordRequestBody {
    return ResetPasswordRequestBody(
        newPassword = this
    )
}
internal fun User.toRegisterBody(): RegisterRequestBody {
    return RegisterRequestBody(
        firstName = firstName,
        lastName = lastName,
        email = email,
        password = password,
        role = role
    )
}

internal fun User.toLoginBody(): LoginRequestBody {
    return LoginRequestBody(
        email = email,
        password = password
    )
}