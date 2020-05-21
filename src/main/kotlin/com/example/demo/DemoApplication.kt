package com.example.demo

import com.example.demo.repositories.ContractRepository
import com.example.demo.repositories.CustomerRepository
import com.example.demo.repositories.Repository
import com.example.demo.services.ContractService
import com.example.demo.services.CustomerService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoApplication {

    private final val customerRepository: CustomerRepository
    private final val contractRepository: ContractRepository
    private final val customerService: CustomerService
    private final val contractService: ContractService

    init {
        val envVars = System.getenv()
        val repository = Repository(
                envVars["DB_URLS"]!!,
                envVars["DB_USERNAME"]!!,
                envVars["DB_PASSWORD"]!!
        )

        customerRepository = CustomerRepository(repository)
        contractRepository = ContractRepository(repository)

        customerService = CustomerService(customerRepository)
        contractService = ContractService(contractRepository)
    }
}

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
