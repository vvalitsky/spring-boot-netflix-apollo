package com.vvalitsky.entities

import com.vvalitsky.entities.generated.types.Employee
import org.hibernate.Hibernate
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
    var id: Int = 0,

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
            this.id,
            this.firstName,
            this.middleName,
            this.lastName
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Employee

        return id == other.id
    }

    override fun hashCode(): Int = id.hashCode()

    @Override
    override fun toString(): String {
        return "(id = $id , firstName = $firstName , middleName = $middleName , lastName = $lastName )"
    }
}
