package com.pe.relari.employeekotlin.business.service.impl

import com.pe.relari.employeekotlin.business.dao.EmployeeDao
import com.pe.relari.employeekotlin.business.model.domain.Employee
import com.pe.relari.employeekotlin.business.service.EmployeeService
import io.reactivex.Completable
import io.reactivex.Observable
import org.springframework.stereotype.Service

@Service
class EmployeeServiceImpl(val employeeDao: EmployeeDao) : EmployeeService {

    override fun findAll(): List<Employee> {
        return employeeDao.findAll()
    }

    override fun findAllRx(): Observable<Employee> {
        return employeeDao.findAllRx()
    }

    override fun save(employee: Employee): Completable {
        return employeeDao.save(employee)
    }

}