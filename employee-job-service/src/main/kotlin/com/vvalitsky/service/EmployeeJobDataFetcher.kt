package com.vvalitsky.service

import com.netflix.graphql.dgs.DgsDataFetchingEnvironment
import com.vvalitsky.entities.generated.types.Employee
import com.vvalitsky.entities.generated.types.EmployeeJob

/**
 * Interface of the component for resolving employee job info.
 *
 * @author Vladislav Valitsky
 */
interface EmployeeJobDataFetcher {

    /**
     * Employee context filler.
     *
     * @param values - employee context fields [Map]
     * @return - will return employee context [Employee]
     */
    fun employee(values: Map<String?, Any?>): Employee

    /**
     * Employee job info fetcher.
     *
     * @param dataFetchingEnvironment - data fetching environment [DgsDataFetchingEnvironment]
     * @return - will return employee job info [EmployeeJob]
     */
    fun employeeJobFetcher(dataFetchingEnvironment: DgsDataFetchingEnvironment): EmployeeJob?
}
