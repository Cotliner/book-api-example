package com.khaled.bookapi.service

import com.khaled.bookapi.document.SearchUser
import com.khaled.bookapi.document.User
import com.khaled.bookapi.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service
import java.util.UUID.randomUUID

@Service class UserService(
  private val userRepository: UserRepository
) {
  suspend fun create(
    username: String,
    password: String
  ): User {
    val existingUser = userRepository.findByUsername(username) != null

    if (existingUser) throw Exception("The user with the username $username already exist")

    val user = User(randomUUID(), username, password, mutableSetOf("Harry Poter"))

    return userRepository.save(user)
  }

  suspend fun search(searchUser: SearchUser): Int = userRepository.countByReadBookIn(searchUser.readBook)
}
