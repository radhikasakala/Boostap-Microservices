package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Currency;
import com.example.demo.repository.CurrencyRepository;

@RestController
@RequestMapping(value="/currency")
public class CurrencyController {

	@Autowired
	private CurrencyRepository currencyRepository;


	@PostMapping("/create")
	public ResponseEntity<Currency> createCurrencyConv(@Valid @RequestBody Currency currency) {
		final Currency newCurrency = currencyRepository.save(currency);
		System.out.println("new currency..."+newCurrency);
		return ResponseEntity.ok().body(newCurrency);
		//return

	}

	@GetMapping("/getcur/{country}")
	public ResponseEntity<Currency> getCurrencyConv(@PathVariable(value = "country") String country) {
		System.out.println("country m1 service name.."+country);
		//String str=null;
		Currency cur=null;
		try {
			cur = currencyRepository.findByCountry(country);
			//	str= currencyRepository.findByCountry(country).getConversionfactor();
		}catch(Exception e) {
			System.out.println("exception occured.."+"Country not exists");
			return new ResponseEntity<Currency>(cur,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Currency>(cur,HttpStatus.OK);
	}


	@PutMapping("/updatecur/{country}")
	public ResponseEntity<Currency> updateCurrencyConv(@PathVariable(value = "country") String country,
			@Valid @RequestBody Currency currencyDetails){
		Currency updateCur=null;
		try {
			Currency cur = currencyRepository.findByCountry(country);
			cur.setConversionfactor(currencyDetails.getConversionfactor());
			cur.setCountry(currencyDetails.getCountry());
			updateCur = currencyRepository.save(cur);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return ResponseEntity.ok(updateCur);
	}
	/*
	 * @PutMapping("/updatecur") public ResponseEntity<Currency>
	 * updateCurrencyConv(@Valid @RequestBody Currency currency){ try {
	 * currencyRepository.save(currency); }catch(Exception e) {
	 * System.out.println(e.getMessage()); } return new
	 * ResponseEntity<Currency>(currency,HttpStatus.OK); }
	 */
}
