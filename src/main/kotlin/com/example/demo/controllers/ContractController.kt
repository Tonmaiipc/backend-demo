package com.example.demo.controllers

import com.example.demo.models.Contract
import com.example.demo.services.ContractService
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class ContractController(private val contractService: ContractService) {

    @GetMapping("/contract")
    fun contract(@RequestHeader headers: HttpHeaders): Contract {
        val id = headers["customerId"]?.first() ?: throw Exception()
        return contractService.getByCustomerId(id)
    }
}