package com.example.demo.controllers

import com.example.demo.models.Customer
import com.example.demo.services.CustomerService
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController(private val customerService: CustomerService) {

    @GetMapping("/customer")
    fun customer(@RequestHeader headers: HttpHeaders): Customer {
        val id = headers["customerId"]?.first() ?: throw Exception()
        return customerService.get(id)
    }
}