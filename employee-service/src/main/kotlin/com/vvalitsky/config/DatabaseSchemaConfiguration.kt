package com.vvalitsky.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

/**
 * Database schema configuration.
 *
 * @property datasources - list of application datasources with config [List] [Datasource]
 * @constructor - will create [DatabaseSchemaConfiguration]
 *
 * @author Vladislav Valitsky
 */
@ConstructorBinding
@ConfigurationProperties(prefix = "application")
class DatabaseSchemaConfiguration(
    val datasources: List<Datasource>
)

/**
 * Datasource config.
 *
 * @property sqlInitFile - sql init file full path [String]
 * @property datasourceUrl - concrete datasource jdbc url for performing sql init file [String]
 *
 * @constructor - will create [Datasource]
 *
 * @author Vladislav Valitsky
 */
class Datasource(
    val sqlInitFile: String,
    val datasourceUrl: String
)
