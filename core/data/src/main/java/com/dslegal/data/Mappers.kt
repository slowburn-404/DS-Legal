package com.dslegal.data


import com.dslegal.domain.models.User
import com.dslegal.network.services.auth.model.LoginRequestBody
import com.dslegal.network.services.auth.model.RegisterRequestBody
import com.dslegal.network.services.auth.model.UserDTO

internal fun UserDTO.toDomain(): User {
    return User(
        email = email,
        firstName = firstName,
        lastName = lastName,
        password = "",
        role = role
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
