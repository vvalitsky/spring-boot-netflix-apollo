package com.vvalitsky.service

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment
import com.netflix.graphql.dgs.DgsEntityFetcher
import com.vvalitsky.entities.generated.types.Employee
import com.vvalitsky.entities.generated.types.EmployeeJob
import com.vvalitsky.repository.EmployeeJobRepository

/**
 * Main component for resolving employee job info.
 *
 * @author Vladislav Valitsky
 */
@DgsComponent
class EmployeeJobDataFetcherImpl(
    private val employeeJobRepository: EmployeeJobRepository
) : EmployeeJobDataFetcher {

    /**
     * Employee context filler.
     *
     * @param values - employee context fields [Map]
     * @return - will return employee context [Employee]
     */
    @DgsEntityFetcher(name = "Employee")
    override fun employee(values: Map<String?, Any?>): Employee {

        return Employee(
            values["id"] as Int,
            null
        )
    }

    /**
     * Employee job info fetcher.
     *
     * @param dataFetchingEnvironment - data fetching environment [DgsDataFetchingEnvironment]
     * @return - will return employee job info [EmployeeJob]
     */
    @DgsData(parentType = "Employee", field = "employeeJob")
    override fun employeeJobFetcher(dataFetchingEnvironment: DgsDataFetchingEnvironment): EmployeeJob? {
        // Filled employee context
        val employee: Employee = dataFetchingEnvironment.getSource()

        return employeeJobRepository.findByEmployeeId(employeeId = employee.id)?.toDto()
    }
}
