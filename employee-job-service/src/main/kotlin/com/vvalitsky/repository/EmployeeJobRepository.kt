package com.vvalitsky.repository

import com.vvalitsky.entities.EmployeeJob
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Employee job [EmployeeJob] JPA repository.
 *
 * @author Vladislav Valitsky
 */
interface EmployeeJobRepository : JpaRepository<EmployeeJob, Int> {
    fun findByEmployeeId(employeeId: Int): EmployeeJob?
}
