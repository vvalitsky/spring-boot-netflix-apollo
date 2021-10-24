package com.vvalitsky.repository

import com.vvalitsky.entities.Employee
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Employee [Employee] JPA repository.
 *
 * @author Vladislav Valitsky
 */
interface EmployeeRepository : JpaRepository<Employee, Int> {
    fun findAllByIdIn(employeesIds: List<Int>): List<Employee>
}
