package com.vvalitsky.config

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsRuntimeWiring
import graphql.scalars.ExtendedScalars
import graphql.schema.idl.RuntimeWiring

/**
 * Scalars registration config.
 *
 * @author Vladislav Valitsky
 */
@DgsComponent
class ScalarsRegistrationConfiguration {

    /**
     * DateTime scalar add.
     */
    @DgsRuntimeWiring
    fun addLocalDateTimeScalar(builder: RuntimeWiring.Builder): RuntimeWiring.Builder? {
        return builder.scalar(ExtendedScalars.DateTime)
    }
}
