package com.vvalitsky.entities

import com.vvalitsky.entities.generated.types.EmployeeCar
import org.hibernate.Hibernate
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
    var id: Int = 0,

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
    var employeeId: Int,

) {
    fun toDto(): EmployeeCar {

        return EmployeeCar(
            this.id,
            this.model,
            this.brand,
            this.releaseDate
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as EmployeeCar

        return id == other.id
    }

    override fun hashCode(): Int = id.hashCode()

    @Override
    override fun toString(): String {
        return "(id = $id , model = $model , brand = $brand , releaseDate = $releaseDate , employeeId = $employeeId )"
    }
}
