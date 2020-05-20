package com.example.demo.repositories

import com.example.demo.models.Customer
import org.springframework.jdbc.core.RowMapper

class CustomerRepository(url: String, username: String, password: String) : Repository(url, username, password) {
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
}