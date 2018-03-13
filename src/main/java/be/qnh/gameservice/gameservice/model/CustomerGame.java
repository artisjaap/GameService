package be.qnh.gameservice.gameservice.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER_GAME")
public class CustomerGame extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "GAME_ID")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    protected CustomerGame(){}

    private CustomerGame(Builder builder) {
        game = builder.game;
        customer = builder.customer;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private Game game;
        private Customer customer;

        private Builder() {
        }

        public Builder withGame(Game val) {
            game = val;
            return this;
        }

        public Builder withCustomer(Customer val) {
            customer = val;
            return this;
        }

        public CustomerGame build() {
            return new CustomerGame(this);
        }
    }
}
