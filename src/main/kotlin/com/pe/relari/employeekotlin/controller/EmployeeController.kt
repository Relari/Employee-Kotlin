package com.pe.relari.employeekotlin.controller

import com.pe.relari.employeekotlin.business.model.api.EmployeeRequest
import com.pe.relari.employeekotlin.business.model.api.EmployeeResponse
import com.pe.relari.employeekotlin.business.model.domain.Employee
import com.pe.relari.employeekotlin.business.service.EmployeeService
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.stream.Collectors

@RestController
@RequestMapping("\${application.api.path}")
class EmployeeController(val employeeService: EmployeeService) {

    @GetMapping
    fun findAll(): List<EmployeeResponse> {
        return employeeService.findAll().stream()
                .map { mapEmployeeResponse(it) }
                .collect(Collectors.toList())
    }

    @GetMapping("/rx")
    fun findAllRx(): Observable<EmployeeResponse> {
        return employeeService.findAllRx()
                .map { mapEmployeeResponse(it) }
    }

    private fun mapEmployeeResponse(employee: Employee) = EmployeeResponse(
                employee.idEmployee,
                employee.fatherLastName,
                employee.motherLastName,
                employee.firstName,
                employee.position,
                employee.sex,
                employee.salary,
                employee.isActive)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveRx(@RequestBody employeeRequest: EmployeeRequest) : Completable {
        return Single.fromCallable { mapEmployee(employeeRequest) }
                .flatMapCompletable { employeeService.save(it) }
    }

    private fun mapEmployee(employeeRequest: EmployeeRequest) : Employee {
        return Employee()
                .fatherLastName(employeeRequest.fatherLastName)
                .motherLastName(employeeRequest.motherLastName)
                .firstName(employeeRequest.firstName)
                .isActive(true)
                .position(employeeRequest.position)
                .salary(employeeRequest.salary)
                .sex(employeeRequest.sex)
    }

}