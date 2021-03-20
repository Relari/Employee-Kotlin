package com.pe.relari.employeekotlin.business.model.api

data class EmployeeRequest(
     val fatherLastName: String,
     val motherLastName: String,
     val firstName: String,
     val position: String,
     val sex: String,
     val salary: Double)