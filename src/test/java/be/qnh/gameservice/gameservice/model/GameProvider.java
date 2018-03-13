package be.qnh.gameservice.gameservice.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameProvider {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PublisherProvider publisherProvider;

    public GameMother initNewGame(){
        return new GameMother()
                .withTitle("GAME")
                .withPublisher(publisherProvider.initNewPublisher().getEntity());
    }

    public GameMother initNewGame(Publisher publisher){
        return new GameMother()
                .withTitle("GAME")
                .withPublisher(publisher);
    }

    public class GameMother {
        private String title;
        private Publisher publisher;

        public GameMother withTitle(String val) {
            this.title = val;
            return this;
        }

        public GameMother withPublisher(Publisher val) {
            this.publisher = val;
            return this;
        }

        public Game getEntity() {
            return gameRepository.save(Game.newBuilder()
                    .withTitle(title)
                    .withPublisher(publisher)
                    .build());
        }
    }
}
