package com.pe.relari.employeekotlin.example

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.logging.Logger
import java.util.stream.Collectors

const val FIRST_NUMBER: Int = 1

@RestController
@RequestMapping("/api/v1/peoples")
class PersonController {

  val log: Logger = Logger.getLogger(PersonController::class.java.name)

  @GetMapping("/{id}")
  fun getPerson(@PathVariable("id") id: Int): PersonResponse {
    return PersonResponse(id, "Person $id")
  }

  @GetMapping
  fun findAll(): List<PersonResponse> {
    return peoples().stream()
            .peek { log.info(it.toString()) }
            .collect(Collectors.toList())
  }

  private fun peoples(): List<PersonResponse> {
    val personList = ArrayList<PersonResponse>()

    for (id in 1..10) {
      personList.add(PersonResponse(id, "Person $id"))
    }
    return personList;
  }
}

data class PersonResponse(var id: Int, var name: String)
