package com.pe.relari.employeekotlin.business.dao.repository

import com.pe.relari.employeekotlin.business.model.entity.EmployeeEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepository : JpaRepository<EmployeeEntity, Int>