package ai.dogood.flash.cards.Repository;

import ai.dogood.flash.cards.domain.entity.Card;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends MongoRepository<Card, String> {

}