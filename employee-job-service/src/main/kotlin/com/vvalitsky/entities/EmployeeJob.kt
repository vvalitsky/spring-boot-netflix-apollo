package com.vvalitsky.entities

import com.vvalitsky.entities.generated.types.EmployeeJob
import org.hibernate.Hibernate
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
    var id: Int = 0,

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
    var employeeId: Int,

) {
    fun toDto(): EmployeeJob {

        return EmployeeJob(
            this.id,
            this.address,
            this.name,
            this.experience
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as EmployeeJob

        return id == other.id
    }

    override fun hashCode(): Int = id.hashCode()

    @Override
    override fun toString(): String {
        return "(id = $id , address = $address , name = $name , experience = $experience , employeeId = $employeeId )"
    }
}
