package ai.dogood.flash.cards.domain.bo;

import ai.dogood.flash.cards.repository.CardRepository;
import ai.dogood.flash.cards.domain.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.UUID;

@Component
public class CardBO {

    @Autowired
    private CardRepository cardRepository;
    
	@Transactional(propagation = Propagation.REQUIRED)
    public Collection<Card> selectAllCards() {
        return cardRepository.findAll();
    }

	@Transactional(propagation = Propagation.REQUIRED)
    public Card selectCardById(String id) {
        return cardRepository.findOne(id);
    }

	@Transactional(propagation = Propagation.REQUIRED)
    public void saveCard(Card card) {
        String uuid = UUID.randomUUID().toString();
        card.setUuid(uuid);
		cardRepository.save(card);
    }

	@Transactional(propagation = Propagation.REQUIRED)
    public void updateCard(Card card, String id) {
		Card usr = selectCardById(id);
		cardRepository.save(usr);
    }

	@Transactional(propagation = Propagation.REQUIRED)
    public void removeCardById(String id) {
    	cardRepository.delete(id);
    }

	@Transactional(propagation = Propagation.REQUIRED)
    public void removeAllCards() {
    	cardRepository.deleteAll();
    }
	
}