package ai.dogood.flash.cards.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Value("${spring.application.name}")
	private String api;

	@RequestMapping(value = "status", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> ping() {
		logger.info("ping api");
		return new ResponseEntity<>("A api [" + api + "] está funcionando!", HttpStatus.OK);
	}

}