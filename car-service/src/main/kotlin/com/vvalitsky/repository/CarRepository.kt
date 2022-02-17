package com.vvalitsky.repository

import com.vvalitsky.entities.Car
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

/**
 * [Car] JPA repository.
 *
 * @author Vladislav Valitsky
 */
interface CarRepository : JpaRepository<Car, Int> {
    @Query(
        nativeQuery = true,
        value = "select * from car.car " +
            "where id in (select car_id from car.employee_car where employee_id = :employeeId)"
    )
    fun findByEmployeeId(@Param("employeeId") employeeId: Int): List<Car>
}
