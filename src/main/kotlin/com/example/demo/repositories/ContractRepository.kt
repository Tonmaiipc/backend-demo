package com.example.demo.repositories

import com.example.demo.models.Contract
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository

@Repository
class ContractRepository(@Autowired private val repository: BaseRepository) {
    fun getByCustomerId(customerId: String): Contract {
        return repository.queryForObject(
                RowMapper { r, _: Int ->
                    Contract(
                            r.getString("id"),
                            r.getString("customer_id"),
                            r.getString("details")
                    )
                },
                "SELECT id, customer_id, details FROM contract WHERE customer_id = ?", customerId
        )
    }
}