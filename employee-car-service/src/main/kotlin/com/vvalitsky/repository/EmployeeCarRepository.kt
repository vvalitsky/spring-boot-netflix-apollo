package com.vvalitsky.repository

import com.vvalitsky.entities.EmployeeCar
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Employee job [EmployeeCar] JPA repository.
 *
 * @author Vladislav Valitsky
 */
interface EmployeeCarRepository : JpaRepository<EmployeeCar, Int> {
    fun findByEmployeeId(employeeId: Int): List<EmployeeCar>
}
