package com.vvalitsky.config

import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.core.io.ResourceLoader
import org.springframework.jdbc.datasource.init.ScriptUtils
import org.springframework.stereotype.Component
import javax.sql.DataSource

/**
 * Database schema configurator, based on [BeanPostProcessor].
 *
 * @property databaseSchemaConfiguration - database schema configuration [DatabaseSchemaConfiguration]
 * @property resourceLoader - resource loader [ResourceLoader]
 * @constructor - create empty Database schema configurator [DatabaseSchemaConfigurator]
 *
 * @author Vladislav Valitsky
 */
@Component
@EnableConfigurationProperties(DatabaseSchemaConfiguration::class)
class DatabaseSchemaConfigurator(
    private val databaseSchemaConfiguration: DatabaseSchemaConfiguration,
    private val resourceLoader: ResourceLoader
) : BeanPostProcessor {

    /**
     * Common place for execute sql on concrete datasource.
     *
     * @param bean - any bean [Any]
     * @param beanName - bean name [String]
     *
     * @return - will return [Any]
     */
    override fun postProcessAfterInitialization(bean: Any, beanName: String): Any? {
        if (bean is DataSource) {
            val jdbcUrl = (bean as HikariDataSource).jdbcUrl
            databaseSchemaConfiguration.datasources.forEach { datasource ->
                if (datasource.datasourceUrl == jdbcUrl) {
                    ScriptUtils.executeSqlScript(bean.connection, resourceLoader.getResource(datasource.sqlInitFile))
                }
            }
        }
        return super.postProcessAfterInitialization(bean, beanName)
    }
}
