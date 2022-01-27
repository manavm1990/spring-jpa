package tech.codefinity.customer;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

// Extends another interface that takes the type of Entity and type of ID to use as generic
// parameters
// The extension allows CustomerRepository to inherit methods for CRUD operations - SPRING WRITES ✍️
// THESE METHODS FOR US 🦄
public interface CustomerRepository extends CrudRepository<Customer, Long> {

  //    Add some additional query methods beyond the inherited ones 👆🏾
  List<Customer> findByLastName(String lastName);

  Customer findById(long id);
}
