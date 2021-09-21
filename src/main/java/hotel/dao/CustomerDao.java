package hotel.dao;

import hotel.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerDao extends CrudRepository<Customer,Long> {
    Optional<Customer> findCustomerById(Long id);
    Optional<Customer> findCustomerByName(String name);
}
