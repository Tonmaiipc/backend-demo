package com.example.demo.repositories

import com.example.demo.models.Customer
import org.springframework.jdbc.core.RowMapper

class CustomerRepository(private val repository: Repository) {
    fun getCustomer(id: String): Customer {
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