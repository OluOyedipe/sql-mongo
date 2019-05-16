package com.example.sqlmongo;

import com.example.sqlmongo.mongo.Customer;
import com.example.sqlmongo.mongo.CustomerRepository;
import com.example.sqlmongo.sqlserver.User;
import com.example.sqlmongo.sqlserver.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "com.example.sqlmongo.mongo")
@EnableJpaRepositories(basePackages = "com.example.sqlmongo.sqlserver")
@SpringBootApplication
public class SqlmongoApplication implements CommandLineRunner {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SqlmongoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("getting data from Mongo");
        repository.deleteAll();

        // save a couple of customers
        repository.save(new Customer("Alice", "Smith"));
        repository.save(new Customer("Bob", "Smith"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByFirstName("Alice"));

        System.out.println("Customers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (Customer customer : repository.findByLastName("Smith")) {
            System.out.println(customer);
        }

        System.out.println("getting data from SQL SERVER");
        userRepository.deleteAll();

        // save a couple of customers
        userRepository.save(new User("Alice", "Alice@Smith.com"));
        userRepository.save(new User("Bob", "Bob@Smith.com"));

        // fetch all customers
        System.out.println("Users found with findAll():");
        System.out.println("-------------------------------");

        for (User user : userRepository.findAll()) {
            System.out.println(user);
        }

    }
}
