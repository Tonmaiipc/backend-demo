package com.example.demo.services

import com.example.demo.models.Customer
import com.example.demo.repositories.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerService {

    @Autowired
    private lateinit var customerRepository: CustomerRepository

    fun get(id: String): Customer = customerRepository.get(id)
}