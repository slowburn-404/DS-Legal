package com.dslegal.data.mappers


import com.dslegal.domain.models.User
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


