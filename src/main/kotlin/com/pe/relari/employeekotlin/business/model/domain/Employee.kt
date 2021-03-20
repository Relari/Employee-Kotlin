package com.pe.relari.employeekotlin.business.model.domain

class Employee {

    var idEmployee: Int = 0
    var fatherLastName: String = ""
    var motherLastName: String = ""
    var firstName: String = ""
    var position: String = ""
    var sex: String = ""
    var salary: Double = 0.0
    var isActive: Boolean = true

    fun idEmployee(idEmployee: Int): Employee {
        this.idEmployee = idEmployee
        return this
    }

    fun fatherLastName(fatherLastName: String): Employee {
        this.fatherLastName = fatherLastName
        return this
    }

    fun motherLastName(motherLastName: String): Employee {
        this.motherLastName = motherLastName
        return this
    }

    fun firstName(firstName: String): Employee {
        this.firstName = firstName
        return this
    }

    fun position(position: String): Employee {
        this.position = position
        return this
    }

    fun sex(sex: String): Employee {
        this.sex = sex
        return this
    }

    fun salary(salary: Double): Employee {
        this.salary = salary
        return this
    }

    fun isActive(isActive: Boolean): Employee {
        this.isActive = isActive
        return this
    }

    override fun toString(): String {
        return "Employee(idEmployee=$idEmployee, fatherLastName='$fatherLastName', motherLastName='$motherLastName', firstName='$firstName', position='$position', sex='$sex', salary=$salary, isActive=$isActive)"
    }

}