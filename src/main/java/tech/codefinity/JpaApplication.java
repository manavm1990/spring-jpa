package tech.codefinity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tech.codefinity.customer.Customer;
import tech.codefinity.customer.CustomerRepository;

@SpringBootApplication
public class JpaApplication {

  private static final Logger log = LoggerFactory.getLogger(JpaApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(JpaApplication.class, args);
  }

  @Bean
  public CommandLineRunner init(CustomerRepository repository) {
    return args -> {
      // save a few customers
      repository.save(new Customer("Jack", "Bauer"));
      repository.save(new Customer("Chloe", "O'Brian"));
      repository.save(new Customer("Kim", "Bauer"));
      repository.save(new Customer("David", "Palmer"));
      repository.save(new Customer("Michelle", "Dessler"));

      log.info("Fetching customer(s)...");
      log.info("---------------------");
      repository.findAll().forEach(customer -> log.info(customer.toString()));
      log.info("---------------------");

      log.info("Fetching customer(s) with last name 'Bauer':");
      log.info("--------------------------------------------");
      repository
          .findByLastName("Bauer")
          .forEach(foundCustomer -> log.info(foundCustomer.toString()));

      log.info("--------------------------------------------");
    };
  }
}
