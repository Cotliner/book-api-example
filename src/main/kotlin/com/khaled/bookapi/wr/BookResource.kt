package com.khaled.bookapi.wr

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping(value = [ "/api/v1/books" ], produces = [ MediaType.APPLICATION_JSON_VALUE ])
@RestController class BookResource {
}