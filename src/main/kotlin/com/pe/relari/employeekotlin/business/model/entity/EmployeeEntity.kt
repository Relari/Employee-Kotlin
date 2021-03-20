package com.pe.relari.employeekotlin.business.model.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "EMPLOYEE")
data class EmployeeEntity(
        @Column(name = "fatherLastName", length = 50, nullable = false)
        val fatherLastName: String = "",
        @Column(name = "motherLastName", length = 50, nullable = false)
        val motherLastName: String = "",
        @Column(name = "firstName", length = 50, nullable = false)
        val firstName: String = "",
        @Column(name = "position", length = 50, nullable = false)
        val position: String = "",
        @Column(name = "sex", length = 1, nullable = false)
        val sex: String = "",
        @Column(name = "salary", nullable = false)
        val salary: Double = 0.0,
        @Column(name = "isActive", nullable = false)
        val isActive: Boolean = true) {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int = 0
}