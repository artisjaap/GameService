package be.qnh.gameservice.gameservice.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PublisherProvider {
    @Autowired
    private PublisherRepository publisherRepository;

    public PublisherMother initNewPublisher(){
        return new PublisherMother();
    }

    public class PublisherMother {
        private String name = "Publisher";

        public PublisherMother withName(String val) {
            this.name = val;
            return this;
        }

        public Publisher getEntity() {
            return publisherRepository.save(Publisher.newBuilder()
                    .withName(name)
                    .build());
        }
    }
}
