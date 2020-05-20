package com.example.demo.services

import com.example.demo.repositories.ContractRepository

class ContractService(private val contractRepository: ContractRepository) {

    fun getContract(customerId: String) = contractRepository.getContract(customerId)
}