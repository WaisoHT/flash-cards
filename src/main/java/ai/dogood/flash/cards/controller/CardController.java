package ai.dogood.flash.cards.controller;

import ai.dogood.flash.cards.domain.bo.CardBO;
import ai.dogood.flash.cards.domain.entity.Card;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Api
@RestController
@RequestMapping("/api/v1/cards")
public class CardController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
	private CardBO cardBO;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> selectAllCards() {
		logger.info("Select all");
		Collection<Card> cards = cardBO.selectAllCards();
		if (ObjectUtils.isEmpty(cards)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(cards, HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> selectCardById(@PathVariable String id) {
    	logger.info("Id to return {}", id);
		Card card = cardBO.selectCardById(id);
		if (ObjectUtils.isEmpty(card)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(card, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> saveCard(@RequestBody Card card) {
		logger.info("Payload to save {}", card);
		cardBO.saveCard(card);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> updateCard(@RequestBody Card card, @PathVariable String id) {
		logger.info("Payload to update {} and id {}", card, id);
		cardBO.updateCard(card, id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<?> removeCardById(@PathVariable String id) {
    	logger.info("Id to remove {}", id);
		cardBO.removeCardById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<?> removeAllCards() {
		logger.info("Remove all");
		cardBO.removeAllCards();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}