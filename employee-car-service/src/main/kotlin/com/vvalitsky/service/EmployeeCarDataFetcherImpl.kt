package com.vvalitsky.service

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment
import com.netflix.graphql.dgs.DgsEntityFetcher
import com.vvalitsky.entities.generated.types.Employee
import com.vvalitsky.entities.generated.types.EmployeeCar
import com.vvalitsky.repository.EmployeeCarRepository

/**
 * Main component for resolving employee car info.
 *
 * @author Vladislav Valitsky
 */
@DgsComponent
class EmployeeCarDataFetcherImpl(
    private val employeeCarRepository: EmployeeCarRepository
) : EmployeeCarDataFetcher {

    /**
     * Employee context filler.
     *
     * @param values - employee context fields [Map]
     * @return - will return employee context [Employee]
     */
    @DgsEntityFetcher(name = "Employee")
    override fun employee(values: Map<String?, Any?>): Employee {
        return Employee(
            id = (values["id"] as Int).toLong(),
            cars = listOf()
        )
    }

    /**
     * Employee car info fetcher.
     *
     * @param dataFetchingEnvironment - data fetching environment [DgsDataFetchingEnvironment]
     * @return - will return employee car info [List] [EmployeeCar]
     */
    @DgsData(parentType = "Employee", field = "cars")
    override fun employeeCarsFetcher(dataFetchingEnvironment: DgsDataFetchingEnvironment): List<EmployeeCar> {
        // Filled employee context
        val employee: Employee = dataFetchingEnvironment.getSource()
        return employeeCarRepository.findByEmployeeId(employeeId = employee.id).map { it.toDto() }
    }
}