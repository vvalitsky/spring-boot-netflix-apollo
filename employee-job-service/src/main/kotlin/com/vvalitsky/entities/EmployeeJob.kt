package com.vvalitsky.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

/**
 * Employee job info.
 *
 * @author Vladislav Valitsky
 */
@Entity
@Table(name = "employee_job", schema = "employee_job")
data class EmployeeJob(

    /**
     * Employee job id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    /**
     * Employee job address.
     */
    @Column(name = "address")
    var address: String,

    /**
     * Employee job name.
     */
    @Column(name = "name")
    var name: String,

    /**
     * Employee job experience.
     */
    @Column(name = "experience")
    var experience: Int,

    /**
     * Employee id.
     */
    @Column(name = "employee_id")
    var employeeId: Long,

) {
    fun toDto(): com.vvalitsky.entities.generated.types.EmployeeJob {
        return com.vvalitsky.entities.generated.types.EmployeeJob(
            id = this.id,
            address = this.address,
            name = this.name,
            experience = this.experience
        )
    }
}
