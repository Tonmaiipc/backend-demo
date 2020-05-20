package com.example.demo

import com.example.demo.repositories.ContractRepository
import com.example.demo.repositories.CustomerRepository
import com.example.demo.repositories.Repository
import com.example.demo.services.ContractService
import com.example.demo.services.CustomerService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoApplication

fun instantiates() {

    val envVars = System.getenv()
    val repository = Repository(
            envVars["DB_URLS"]!!,
            envVars["DB_USERNAME"]!!,
            envVars["DB_PASSWORD"]!!
    )

    val customerRepository = CustomerRepository(repository)
    val contractRepository = ContractRepository(repository)

    val customerService = CustomerService(customerRepository)
    val contractService = ContractService(contractRepository)
}

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
