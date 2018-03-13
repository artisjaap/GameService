package be.qnh.gameservice.gameservice.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerGameProvider {

    @Autowired
    private CustomerGameRepository customerGameRepository;

    @Autowired
    private GameProvider gameProvider;

    @Autowired
    private CustomerGameProvider customerGameProvider;

    public CustomerGameMother initNewCustomerGame(Customer customer, Game game){
        return new CustomerGameMother()
                .withCustomer(customer)
                .withGame(game);

    }



    public class CustomerGameMother {
        private Game game;
        private Customer customer;


        public CustomerGameMother withGame(Game val){
            this.game = val;
            return this;
        }

        public CustomerGameMother withCustomer(Customer val){
            this.customer = val;
            return this;
        }

        public CustomerGame getEntity() {
            return customerGameRepository.save(CustomerGame.newBuilder()
                    .withGame(game)
                    .withCustomer(customer)
                    .build());
        }

    }
}
