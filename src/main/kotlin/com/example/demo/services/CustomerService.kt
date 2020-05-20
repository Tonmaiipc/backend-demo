package com.example.demo.services

import com.example.demo.models.Customer
import com.example.demo.repositories.ContractRepository
import com.example.demo.repositories.CustomerRepository

class CustomerService {

    private val customerRepository: CustomerRepository

    init {
        val envVars = System.getenv()
        customerRepository = CustomerRepository(
                envVars["DB_URLS"]!!,
                envVars["DB_USERNAME"]!!,
                envVars["DB_PASSWORD"]!!
        )
    }

    fun getCustomer(id: String): Customer = customerRepository.getCustomer(id)
}