package com.example.demo.services

import com.example.demo.repositories.ContractRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ContractService {

    @Autowired
    private lateinit var contractRepository: ContractRepository

    fun getContract(customerId: String) = contractRepository.getContract(customerId)
}