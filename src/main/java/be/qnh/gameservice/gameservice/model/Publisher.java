package be.qnh.gameservice.gameservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PUBLISHER")
public class Publisher extends AbstractEntity {
    @Column(name = "NAME")
    private String name;

    private Publisher(Builder builder) {
        name = builder.name;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    protected Publisher(){}

    public static final class Builder {
        private String name;

        private Builder() {
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Publisher build() {
            return new Publisher(this);
        }
    }
}
