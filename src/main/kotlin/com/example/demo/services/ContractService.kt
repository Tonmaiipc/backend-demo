package com.example.demo.services

import com.example.demo.models.Customer
import com.example.demo.repositories.ContractRepository
import com.example.demo.repositories.Repository

class ContractService {

    private val contractRepository: ContractRepository

    init {
        val envVars = System.getenv()
        contractRepository = ContractRepository(
                envVars["DB_URLS"]!!,
                envVars["DB_USERNAME"]!!,
                envVars["DB_PASSWORD"]!!
        )
    }


    fun getContract(customerId: String) = contractRepository.getContract(customerId)
}