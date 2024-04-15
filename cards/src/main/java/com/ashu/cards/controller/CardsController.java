package com.ashu.cards.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashu.cards.dto.CardsDto;
import com.ashu.cards.dto.ErrorResponseDto;
import com.ashu.cards.service.ICardsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "CRUD REST APIs for Cards in EazyBank", description = "CRUD REST APIs in EazyBank to CREATE, UPDATE, FETCH AND DELETE card details")
@Validated
@AllArgsConstructor
@RestController
@RequestMapping(path = "/cards", produces = { MediaType.APPLICATION_JSON_VALUE })
public class CardsController {
	private ICardsService cardsService;

	@Operation(summary = "Fetch the cards details", description = "Fetch api for cards")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
			@ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))) })

	@GetMapping("/fetch")
	public ResponseEntity<CardsDto> fetchCardDetails() {
		CardsDto cardsDto = null;
		return ResponseEntity.status(HttpStatus.OK).body(cardsDto);
	}

	@Operation(description = "Creates a new Card", summary = "Api to create a new cards")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "HTTP Status CREATED"),
			@ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))) })
	@PostMapping("/create")
	public ResponseEntity<CardsDto> createCard() {
		CardsDto cardsDto = null;
		return ResponseEntity.status(HttpStatus.CREATED).body(cardsDto);
	}

	@Operation(description = "Updates the existing cards details", summary = "Updates the existing card")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
			@ApiResponse(responseCode = "417", description = "Expectation Failed"),
			@ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))) })
	@PutMapping("/update")
	public ResponseEntity<CardsDto> updateCard() {
		CardsDto cardsDto = null;
		return ResponseEntity.status(HttpStatus.OK).body(cardsDto);
	}

	@Operation(description = "Deletes the existing cards", summary = "Deletes the existing cards")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
			@ApiResponse(responseCode = "417", description = "Expectation Failed"),
			@ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))) })
	@DeleteMapping("/delete")
	public ResponseEntity<CardsDto> deleteCard() {
		CardsDto cardsDto = null;
		return ResponseEntity.status(HttpStatus.OK).body(cardsDto);
	}

}
