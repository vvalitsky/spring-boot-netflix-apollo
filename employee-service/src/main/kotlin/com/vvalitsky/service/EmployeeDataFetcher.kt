package com.vvalitsky.service

import com.vvalitsky.entities.generated.types.Employee

/**
 * Interface of employee data fetcher.
 *
 * @author Vladislav Valitsky
 */
interface EmployeeDataFetcher {

    /**
     * Get employee info.
     *
     * @param employeeId - employee id [Long]
     * @return return [Employee]
     */
    fun getEmployeeInfo(employeeId: Long): Employee?

    /**
     * Get employees info.
     *
     * @param employeesIds - employees ids [List] [Long]
     * @return return [List] [Employee]
     */
    fun getEmployeesInfo(employeesIds: List<Long>): List<Employee>?
}
