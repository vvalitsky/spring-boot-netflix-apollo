package com.vvalitsky.entities

import com.vvalitsky.entities.generated.types.Car
import org.hibernate.Hibernate
import java.time.OffsetDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

/**
 * Car info.
 *
 * @author Vladislav Valitsky
 */
@Entity
@Table(name = "car", schema = "car")
class Car(

    /**
     * Car id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0,

    /**
     * Car model.
     */
    @Column(name = "model")
    var model: String,

    /**
     * Car brand.
     */
    @Column(name = "brand")
    var brand: String,

    /**
     * Car release date.
     */
    @Column(name = "release_date")
    var releaseDate: OffsetDateTime,

) {
    fun toDto(): Car {

        return Car(
            this.id,
            this.model,
            this.brand,
            this.releaseDate
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Car

        return id == other.id
    }

    override fun hashCode(): Int = id.hashCode()

    @Override
    override fun toString(): String {
        return "(id = $id , model = $model , brand = $brand , releaseDate = $releaseDate)"
    }
}
