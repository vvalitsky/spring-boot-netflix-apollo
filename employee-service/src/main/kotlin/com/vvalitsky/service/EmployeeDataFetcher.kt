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
     * @param employeeId - employee id [Int]
     * @return return [Employee]
     */
    fun getEmployeeInfo(employeeId: Int): Employee?

    /**
     * Get employees info.
     *
     * @param employeesIds - employees ids [List] [Int]
     * @return return [List] [Employee]
     */
    fun getEmployeesInfo(employeesIds: List<Int>): List<Employee>?
}
