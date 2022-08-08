package com.khaled.bookapi.wr

import com.khaled.bookapi.document.SearchUser
import com.khaled.bookapi.document.User
import com.khaled.bookapi.document.UserCreateDto
import com.khaled.bookapi.service.UserService
import kotlinx.coroutines.reactor.mono
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RequestMapping(value = [ "/api/v1/users" ], produces = [ MediaType.APPLICATION_JSON_VALUE ])
@RestController class UserResource(
  private val userService: UserService
) {
  /* TODO POST, PUT, GET, DELETE */

  @PostMapping
  fun create(
    @RequestBody userCreate: UserCreateDto
  ): Mono<User> = mono {
    userService.create(userCreate.username, userCreate.password)
  }

  @PostMapping("search")
  fun search(@RequestBody searchUser: SearchUser): Mono<Int> = mono { userService.search(searchUser) }
}