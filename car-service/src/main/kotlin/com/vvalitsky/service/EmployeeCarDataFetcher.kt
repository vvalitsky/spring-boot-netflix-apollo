package com.vvalitsky.service

import com.netflix.graphql.dgs.DgsDataFetchingEnvironment
import com.vvalitsky.entities.generated.types.Car
import com.vvalitsky.entities.generated.types.Employee

/**
 * Interface of the component for resolving employee car info.
 *
 * @author Vladislav Valitsky
 */
interface EmployeeCarDataFetcher {

    /**
     * Employee cars fetcher.
     *
     * @param employeeId - employee id [Int]
     * @return - will return list [List] of employee cars [Car]
     */
    fun getEmployeeCarsByEmployeeId(employeeId: Int): List<Car>

    /**
     * Employee context filler.
     *
     * @param values - employee context fields [Map]
     * @return - will return employee context [Employee]
     */
    fun employee(values: Map<String?, Any?>): Employee

    /**
     * Employee car info fetcher.
     *
     * @param dataFetchingEnvironment - data fetching environment [DgsDataFetchingEnvironment]
     * @return - will return employee car info [List] [Car]
     */
    fun employeeCarsFetcher(dataFetchingEnvironment: DgsDataFetchingEnvironment): List<Car>
}
