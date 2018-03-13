package be.qnh.gameservice.gameservice.model;

import javax.persistence.*;

@Entity
@Table(name = "GAME")
public class Game extends AbstractEntity{

    @Column(name = "TITLE")
    private String title;

    @ManyToOne
    @JoinColumn(name = "PUBLISHER_ID")
    private Publisher publisher;

    protected Game(){}

    private Game(Builder builder) {
        title = builder.title;
        publisher = builder.publisher;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private String title;
        private Publisher publisher;

        private Builder() {
        }

        public Builder withTitle(String val) {
            title = val;
            return this;
        }

        public Builder withPublisher(Publisher val) {
            publisher = val;
            return this;
        }

        public Game build() {
            return new Game(this);
        }
    }
}
