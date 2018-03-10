package sk.matusko.ecs.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.matusko.ecs.customer.dao.Customer;
import sk.matusko.ecs.customer.dao.CustomerRepository;

import java.util.Arrays;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository repository;

    @RequestMapping("/save")
    public String process(){
        // save a single Customer
        repository.save(new Customer("Jack", "Smith"));

        return "Done";
    }

}
