package com.dslegal.data

import com.dslegal.data.repositories.models.User
import com.dslegal.network.services.auth.model.UserDTO

internal fun UserDTO.toDomain(): User {
    return User(
        email = email,
        password = ""
    )
}
