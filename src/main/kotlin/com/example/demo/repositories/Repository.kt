package com.example.demo.repositories

import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper

open class Repository(url: String, username: String, password: String) {

    private val jdbcTemplate: JdbcTemplate = JdbcTemplate()

    init {
        jdbcTemplate.dataSource = DataSourceBuilder.create()
                .driverClassName("mysql")
                .url(url)
                .username(username)
                .password(password)
                .build()
    }



    internal fun <T> queryForObject(entityBuilder: RowMapper<T>, query: String, vararg parameters: String): T {
        val results = jdbcTemplate.query<T>(query, entityBuilder, *parameters)
        return if (results.isNotEmpty()) {
            results.first()
        } else {
            throw Exception()
        }
    }
}