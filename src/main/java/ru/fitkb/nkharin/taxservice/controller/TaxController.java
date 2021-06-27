package ru.fitkb.nkharin.taxservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.fitkb.nkharin.taxservice.model.CanCreditRs;
import ru.fitkb.nkharin.taxservice.model.PersonSaveRq;
import ru.fitkb.nkharin.taxservice.service.TaxesService;

@RestController
@RequiredArgsConstructor
public class TaxController {

	private final TaxesService taxesService;

	@GetMapping("/checkTax/{inn}")
	public CanCreditRs getTaxPersonInfo(@PathVariable String inn) {

		return taxesService.takePersonInfoTaxesByInn(inn);
	}

	@PostMapping("/getTaxPerson")
	public ResponseEntity<HttpStatus> savePersonInfo(@RequestBody PersonSaveRq personInfo){
		
		taxesService.saveNewPerson(personInfo);
		return ResponseEntity.ok(HttpStatus.OK);
	}
}
