package com.example.demo.repositories

import com.example.demo.models.Customer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository

@Repository
class CustomerRepository(@Autowired private val repository: BaseRepository) {
    fun get(id: String): Customer {
        return repository.queryForObject(
                RowMapper { r, _ ->
                    Customer(
                            r.getString("id"),
                            r.getString("name")
                    )
                },
                "SELECT id, name FROM customers WHERE id = ?", id
        )
    }
}