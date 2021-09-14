package hotel.service;

import hotel.dao.CustomerDao;

import hotel.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// code operations for CRUD
@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;

    //Constructor
    public CustomerService(CustomerDao customerDao) {  //CrudRepository
        this.customerDao = customerDao;
    }

    //add new customer to DB
    public Customer addCostumer(Customer customer){
        return customerDao.save(customer);
    }
    //retorn a customer, for verify login in frontend
    public Optional<Customer> findCustomerById(Long id) {
        return customerDao.findCustomerById(id);
             //   .orElseThrow(()-> new UserNotFoundException("<x<"));
    }
    public void verifyCustomerById(Customer customer){
        if(findCustomerById(customer.getId())==null){
            addCostumer(customer);
        }else{
            System.out.println("ID is already in the DB");
        }
    }

}
