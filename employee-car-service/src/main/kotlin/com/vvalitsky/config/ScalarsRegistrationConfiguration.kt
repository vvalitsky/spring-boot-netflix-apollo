package com.vvalitsky.config

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsRuntimeWiring
import graphql.Scalars
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
     * Long scalar add.
     */
    @DgsRuntimeWiring
    fun addLongScalar(builder: RuntimeWiring.Builder): RuntimeWiring.Builder? {
        // TODO Solve this deprecation
        // This represents the "Long" type which is a representation of java.lang.Long
        // The is a non standard scalar and is difficult for clients
        // (such as browser and mobile code) to cope with the exact semantics.
        // These will be removed in the future version and moved to another library.
        return builder.scalar(Scalars.GraphQLLong)
    }
    /**
     * DateTime scalar add.
     */
    @DgsRuntimeWiring
    fun addLocalDateTimeScalar(builder: RuntimeWiring.Builder): RuntimeWiring.Builder? {
        // TODO Solve this deprecation
        // This represents the "Long" type which is a representation of java.lang.Long
        // The is a non standard scalar and is difficult for clients
        // (such as browser and mobile code) to cope with the exact semantics.
        // These will be removed in the future version and moved to another library.
        return builder.scalar(ExtendedScalars.DateTime)
    }
}
