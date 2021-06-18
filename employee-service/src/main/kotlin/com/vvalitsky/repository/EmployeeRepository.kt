package com.vvalitsky.repository

import com.vvalitsky.entities.Employee
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Employee [Employee] JPA repository.
 *
 * @author Vladislav Valitsky
 */
interface EmployeeRepository : JpaRepository<Employee, Long> {
    fun findAllByIdIn(employeesIds: List<Long>): List<Employee>
}
