package com.vvalitsky.service

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsQuery
import com.netflix.graphql.dgs.InputArgument
import com.vvalitsky.entities.generated.types.Employee
import com.vvalitsky.repository.EmployeeRepository
import org.springframework.data.repository.findByIdOrNull

/**
 * Implementation of [EmployeeDataFetcher].
 *
 * @author Vladislav Valitsky
 */
@DgsComponent
class EmployeeDataFetcherImpl(
    private val employeeRepository: EmployeeRepository
) : EmployeeDataFetcher {

    /**
     * Get employee info.
     *
     * @param employeeId - employee id [Int]
     * @return return [Employee]
     */
    @DgsQuery
    override fun getEmployeeInfo(@InputArgument employeeId: Int): Employee? {
        return employeeRepository.findByIdOrNull(employeeId)?.toDto()
    }

    /**
     * Get employees info.
     *
     * @param employeesIds - employees ids [List] [Int]
     * @return return [List] [Employee]
     */
    @DgsQuery
    override fun getEmployeesInfo(employeesIds: List<Int>): List<Employee>? {
        return employeeRepository.findAllByIdIn(employeesIds).map { it.toDto() }
    }
}
