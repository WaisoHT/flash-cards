package ai.dogood.flash.cards.repository;

import ai.dogood.flash.cards.domain.entity.Card;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends MongoRepository<Card, String> {

    @Query("{ 'uuid' : ?0 }")
    Card findCardByUuid(String uuid);

}