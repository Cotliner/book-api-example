package com.khaled.bookapi.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.UUID

@Document data class User(
  @Id var id: UUID,
  var username: String,
  var password: String,
  val readBook: MutableSet<String> = mutableSetOf()
)
