package com.vvalitsky.entities

import java.time.OffsetDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

/**
 * Employee car info.
 *
 * @author Vladislav Valitsky
 */
@Entity
@Table(name = "employee_car", schema = "employee_car")
data class EmployeeCar(

    /**
     * Employee job id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    /**
     * Employee car model.
     */
    @Column(name = "model")
    var model: String,

    /**
     * Employee car brand.
     */
    @Column(name = "brand")
    var brand: String,

    /**
     * Employee car release date.
     */
    @Column(name = "release_date")
    var releaseDate: OffsetDateTime,

    /**
     * Employee id.
     */
    @Column(name = "employee_id")
    var employeeId: Long,

) {
    fun toDto(): com.vvalitsky.entities.generated.types.EmployeeCar {
        return com.vvalitsky.entities.generated.types.EmployeeCar(
            id = this.id,
            model = this.model,
            brand = this.brand,
            releaseDate = this.releaseDate
        )
    }
}
