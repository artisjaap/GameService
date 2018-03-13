package be.qnh.gameservice.gameservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer extends AbstractEntity{

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "FIRST_LAST")
    private String lastName;

    protected Customer() {}

    private Customer(Builder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private String firstName;
        private String lastName;

        private Builder() {
        }

        public Builder withFirstName(String val) {
            firstName = val;
            return this;
        }

        public Builder withLastName(String val) {
            lastName = val;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
