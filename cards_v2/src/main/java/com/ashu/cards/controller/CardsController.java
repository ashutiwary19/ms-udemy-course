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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashu.cards.constants.CardsConstant;
import com.ashu.cards.dto.CardsDto;
import com.ashu.cards.dto.ErrorResponseDto;
import com.ashu.cards.dto.ResponseDto;
import com.ashu.cards.service.ICardsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;

@Tag(name = "CRUD REST APIs for Cards in Ashu's ms card setup", description = "CRUD REST APIs in EazyBank to CREATE, UPDATE, FETCH AND DELETE card details")
@Validated
@AllArgsConstructor
@RestController
@RequestMapping(path = "/cards", produces = { MediaType.APPLICATION_JSON_VALUE })
public class CardsController {
	private ICardsService cardsService;

	@Operation(description = "Creates a new Card", summary = "Api to create a new cards")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "HTTP Status CREATED"),
			@ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))) })
	@PostMapping("/create")
	public ResponseEntity<ResponseDto> createCard(
			@RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits") String mobileNumber) {
		cardsService.createCard(mobileNumber);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseDto(CardsConstant.MESSAGE_200, CardsConstant.MESSAGE_200));
	}

	@Operation(summary = "Fetch the cards details", description = "Fetch api for cards")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
			@ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))) })
	@GetMapping("/fetch")
	public ResponseEntity<CardsDto> fetchCardDetails(
			@RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits") String mobileNumber) {
		CardsDto cardsDto = cardsService.fetchCard(mobileNumber);
		return ResponseEntity.status(HttpStatus.OK).body(cardsDto);
	}

	@Operation(description = "Updates the existing cards details", summary = "Updates the existing card")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
			@ApiResponse(responseCode = "417", description = "Expectation Failed"),
			@ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))) })
	@PutMapping("/update")
	public ResponseEntity<ResponseDto> updateCard(@Valid @RequestBody CardsDto cardsDto) {
		boolean isUpdated = cardsService.updateCard(cardsDto);
		if (isUpdated) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto(CardsConstant.STATUS_200, CardsConstant.MESSAGE_200));
		} else {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto(CardsConstant.STATUS_417, CardsConstant.MESSAGE_417_UPDATE));

		}

	}

	@Operation(description = "Deletes the existing cards", summary = "Deletes the existing cards")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
			@ApiResponse(responseCode = "417", description = "Expectation Failed"),
			@ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))) })
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseDto> deleteCard(
			@RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number should be of 10 digits") String mobileNumber) {
		boolean isDeleted = cardsService.deleteCard(mobileNumber);
		if (isDeleted) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto(CardsConstant.STATUS_200, CardsConstant.MESSAGE_200));
		} else {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto(CardsConstant.STATUS_417, CardsConstant.MESSAGE_417_DELETE));
		}
	}

}
