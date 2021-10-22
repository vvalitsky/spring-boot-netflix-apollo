package com.vvalitsky.service

import com.netflix.graphql.dgs.DgsDataFetchingEnvironment
import com.vvalitsky.entities.generated.types.Employee
import com.vvalitsky.entities.generated.types.EmployeeCar

/**
 * Interface of the component for resolving employee car info.
 *
 * @author Vladislav Valitsky
 */
interface EmployeeCarDataFetcher {

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
     * @return - will return employee car info [List] [EmployeeCar]
     */
    fun employeeCarsFetcher(dataFetchingEnvironment: DgsDataFetchingEnvironment): List<EmployeeCar>
}
