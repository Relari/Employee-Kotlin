package com.pe.relari.employeekotlin.business.service

import com.pe.relari.employeekotlin.business.model.domain.Employee
import io.reactivex.Completable
import io.reactivex.Observable

interface EmployeeService {

    fun findAll() : List<Employee>

    fun findAllRx() : Observable<Employee>

    fun save(employee: Employee) : Completable

}