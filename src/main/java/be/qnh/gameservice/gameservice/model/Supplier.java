package be.qnh.gameservice.gameservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SUPPLIER")
public class Supplier extends AbstractEntity {

    @Column(name = "NAME")
    private String name;

    private Supplier(Builder builder) {
        name = builder.name;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    protected Supplier(){}

    public static final class Builder {
        private String name;

        private Builder() {
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Supplier build() {
            return new Supplier(this);
        }
    }
}
