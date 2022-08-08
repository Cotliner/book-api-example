package com.khaled.bookapi.repository

import com.khaled.bookapi.document.User
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository interface UserRepository : CoroutineCrudRepository<User, UUID> {

  suspend fun findByUsername(username: String): User?

  suspend fun countByReadBookIn(vararg nameOfTheBook: String): Int
}