package com.example.demo.repositories

import com.example.demo.models.Contract
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class ContractRepository(private val repository: Repository) {

    fun getContract(customerId: String): Contract {
        return repository.queryForObject(
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
}