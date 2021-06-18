package com.vvalitsky.entities

import com.vvalitsky.entities.generated.types.Employee
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

/**
 * Employee info.
 *
 * @author Vladislav Valitsky
 */
@Entity
@Table(name = "employee", schema = "employee")
data class Employee(

    /**
     * Employee id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    /**
     * Employee first name.
     */
    @Column(name = "first_name")
    var firstName: String,

    /**
     * Employee middle name.
     */
    @Column(name = "middle_name")
    var middleName: String,

    /**
     * Employee last name.
     */
    @Column(name = "last_name")
    var lastName: String,

) {
    fun toDto(): Employee {
        return Employee(
            id = this.id,
            firstName = this.firstName,
            middleName = this.middleName,
            lastName = this.lastName
        )
    }
}
