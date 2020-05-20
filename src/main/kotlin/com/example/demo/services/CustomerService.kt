package com.example.demo.services

import com.example.demo.models.Customer
import com.example.demo.repositories.CustomerRepository

class CustomerService(private val customerRepository: CustomerRepository) {

    fun getCustomer(id: String): Customer = customerRepository.getCustomer(id)
}