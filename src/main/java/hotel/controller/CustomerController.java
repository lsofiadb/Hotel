package hotel.controller;


import hotel.model.Customer;
import hotel.service.CustomerService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private  CustomerService customerService;

    //public CustomerController(CustomerService customerService) {
        //this.customerService = customerService;
   // }


    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody String newCustomer){
        JSONObject json = new JSONObject(newCustomer);
        Customer customer=new Customer();
        System.out.println("---------PRUEBAAAAAAAAA---"+newCustomer);

        customer.setName(json.getString("name"));
        customer.setEmail(json.getString("email"));
        customer.setPassword(json.getString("password"));
        return customerService.addCostumer(customer);
    }

    }


