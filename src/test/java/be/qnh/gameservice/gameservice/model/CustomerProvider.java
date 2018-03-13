package be.qnh.gameservice.gameservice.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Component
public class CustomerProvider {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerMother initNewCustomer(){
        return new CustomerMother()
                .withFirstName("Firstname")
                .withLastName("Lastname");
    }


    public class CustomerMother {
        private String firstName;
        private String lastName;

        public CustomerMother withFirstName(String val) {
            this.firstName = val;
            return this;
        }

        public CustomerMother withLastName(String val) {
            this.lastName = val;
            return this;
        }


        public Customer getEntity() {
            return customerRepository.save(Customer.newBuilder()
                    .withFirstName(firstName)
                    .withLastName(lastName)
                    .build());
        }
    }
}
