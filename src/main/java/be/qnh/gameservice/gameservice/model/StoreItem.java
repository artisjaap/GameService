package be.qnh.gameservice.gameservice.model;

import javax.persistence.*;

@Entity
@Table(name = "STORE_ITEM")
public class StoreItem extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "GAME_ID", nullable = false)
    private Game game;

    @ManyToOne
    @JoinColumn(name = "SUPPLIER_ID", nullable = false)
    private Supplier supplier;

    @Column(name = "PRICE", nullable = false)
    private Integer priceInEurocent;

    protected StoreItem(){}

    private StoreItem(Builder builder) {
        game = builder.game;
        supplier = builder.supplier;
        priceInEurocent = builder.priceInEurocent;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private Game game;
        private Supplier supplier;
        private Integer priceInEurocent;

        private Builder() {
        }

        public Builder withGame(Game val) {
            game = val;
            return this;
        }

        public Builder withSupplier(Supplier val) {
            supplier = val;
            return this;
        }

        public Builder withPriceInEurocent(Integer val) {
            priceInEurocent = val;
            return this;
        }

        public StoreItem build() {
            return new StoreItem(this);
        }
    }
}
