package be.qnh.gameservice.gameservice.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StoreItemProvider {

    @Autowired
    private StoreItemRepository storeItemRepository;

    @Autowired
    private GameProvider gameProvider;

    @Autowired
    private SupplierProvider supplierProvider;

    public StoreItemMother initNewStoreItem(){
        return new StoreItemMother()
                .withGame(gameProvider.initNewGame().getEntity())
                .withSupplier(supplierProvider.initNewSupplier().getEntity())
                .withPriceInEurocent(1500);

    }

    public StoreItemMother initNewStoreItem(Game game, Supplier supplier){
        return new StoreItemMother()
                .withGame(game)
                .withSupplier(supplier)
                .withPriceInEurocent(1500);

    }

    public class StoreItemMother {
        private Game game;
        private Supplier supplier;
        private Integer priceInEurocent;

        public StoreItemMother withGame(Game val){
            this.game = val;
            return this;
        }

        public StoreItemMother withSupplier(Supplier val){
            this.supplier = val;
            return this;
        }

        public StoreItemMother withPriceInEurocent(Integer val){
            this.priceInEurocent = val;
            return this;
        }

        public StoreItem getEntity() {
            return storeItemRepository.save(StoreItem.newBuilder()
                    .withGame(game)
                    .withSupplier(supplier)
                    .withPriceInEurocent(priceInEurocent)
                    .build());
        }

    }
}
