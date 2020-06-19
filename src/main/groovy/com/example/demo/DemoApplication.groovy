package com.example.demo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class DemoApplication {
    @RequestMapping("/")
     String home(){
         "bonjour"
    }
    static void main(String[] args) {
        SpringApplication.run(DemoApplication, args)
    }

}
