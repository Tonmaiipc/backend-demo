package com.example.demo

import com.example.demo.models.Customer

class Service {

    private val repository: Repository

    init {
        val envVars = System.getenv()
        repository = Repository(
                envVars["DB_URLS"]!!,
                envVars["DB_USERNAME"]!!,
                envVars["DB_PASSWORD"]!!
        )
    }

    fun getCustomer(id: String): Customer = repository.getCustomer(id)

    fun getContract(customerId: String) = repository.getContract(customerId)
}