package com.example.demo.repositories

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Component

@Component
class BaseRepository {

    @Autowired
    private lateinit var jdbcTemplate: JdbcTemplate

    internal fun <T> queryForObject(entityBuilder: RowMapper<T>, query: String, vararg parameters: String): T {
        val results = jdbcTemplate.query<T>(query, entityBuilder, *parameters)
        return if (results.isNotEmpty()) {
            results.first()
        } else {
            throw Exception()
        }
    }
}