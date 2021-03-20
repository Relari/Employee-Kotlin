package com.pe.relari.employeekotlin.business.dao.impl

import com.pe.relari.employeekotlin.business.dao.EmployeeDao
import com.pe.relari.employeekotlin.business.dao.repository.EmployeeRepository
import com.pe.relari.employeekotlin.business.model.entity.EmployeeEntity
import com.pe.relari.employeekotlin.business.model.domain.Employee
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.springframework.stereotype.Component
import java.util.logging.Logger
import java.util.stream.Collectors

@Component
class EmployeeDaoImpl(val employeeRepository: EmployeeRepository) : EmployeeDao {

    val log: Logger = Logger.getLogger(EmployeeDaoImpl::class.java.name)

    override fun findAll(): List<Employee> {

        return employeeRepository.findAll().stream()
                .peek { log.info(it.toString()) }
                .map { mapEmployee(it) }
                .collect(Collectors.toList())
    }

    override fun findAllRx(): Observable<Employee> {
        return Observable.fromCallable { employeeRepository.findAll() }
                .subscribeOn(Schedulers.io())
                .flatMapIterable { it }
                .map { mapEmployee(it) }

    }

    private fun mapEmployee(employeeEntity: EmployeeEntity) : Employee {

        return Employee()
                .idEmployee(employeeEntity.id)
                .firstName(employeeEntity.firstName)
                .fatherLastName(employeeEntity.fatherLastName)
                .motherLastName(employeeEntity.motherLastName)
                .sex(employeeEntity.sex)
                .position(employeeEntity.position)
                .salary(employeeEntity.salary)
                .isActive(employeeEntity.isActive)
    }

    override fun save(employee: Employee): Completable {
        return Single.fromCallable { mapEmployeeEntity(employee) }
                .map { employeeRepository.save(it) }
                .subscribeOn(Schedulers.io())
                .ignoreElement()
    }

    private fun mapEmployeeEntity(employee: Employee) : EmployeeEntity {

        return EmployeeEntity(
                employee.fatherLastName,
                employee.motherLastName,
                employee.firstName,
                employee.position,
                employee.sex,
                employee.salary,
                employee.isActive)
    }
}