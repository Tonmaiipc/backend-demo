package com.example.demo

import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class Repository {

    private val jdbcTemplate: JdbcTemplate = JdbcTemplate()

    init {
        jdbcTemplate.dataSource = DataSourceBuilder.create()
                .driverClassName("mysql")
                .url("url")
                .username("username")
                .password("password")
                .build()
    }

    fun getCustomer(id: String): Customer {
        return queryForObject(
                RowMapper { r, _ ->
                    Customer(
                            r.getString("id"),
                            r.getString("name")
                    )
                },
                "SELECT id, name FROM customers WHERE id = ?", id
        )
    }

    fun getContract(customerId: String): Contract {
        return queryForObject(
                RowMapper { rs: ResultSet, _: Int ->
                    Contract(
                            rs.getString("id"),
                            rs.getString("customer_id"),
                            rs.getString("details")
                    )
                },
                "SELECT id, customer_id, details FROM contract WHERE customer_id = ?", customerId
        )
    }

    private fun <T> queryForObject(entityBuilder: RowMapper<T>, query: String, vararg parameters: String): T {
        val results = jdbcTemplate.query<T>(query, entityBuilder, *parameters)
        return if (results.isNotEmpty()) {
            results.first()
        } else {
            throw Exception()
        }
    }
}