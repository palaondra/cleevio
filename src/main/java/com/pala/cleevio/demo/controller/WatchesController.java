package com.pala.cleevio.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.pala.cleevio.demo.dto.WatchDto;
import com.pala.cleevio.demo.exception.WatchAlreadyExistsException;
import com.pala.cleevio.demo.exception.WatchNotFoundException;
import com.pala.cleevio.demo.service.api.IWatchesService;

@RestController
public class WatchesController {
	
	@Autowired
	private IWatchesService watchesService;
	
	/**
	 * Create new Watch entity from incoming request. 
	 * 
	 * @param watchDto Incoming WatchDto entity - request body.
	 * @param uriComponentsBuilder
	 * @return
	 * @throws WatchAlreadyExistsException When incoming watch has same <code>title</code> as some already stored watch.
	 */
	@PostMapping("/watches")
	public ResponseEntity<Void> createWatch(@Valid @RequestBody WatchDto watchDto, UriComponentsBuilder uriComponentsBuilder) throws WatchAlreadyExistsException {
		try {
			watchesService.createWatch(watchDto);
		} catch (WatchAlreadyExistsException ex) {
			throw ex;
		}
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(
				uriComponentsBuilder
					.path("/watches/{id}")
					.buildAndExpand(watchDto.getId())
					.toUri()
				);
		
		return new ResponseEntity<Void>(httpHeaders, HttpStatus.CREATED);
	}
	
	/**
	 * 
	 * 
	 * @param id
	 * @return
	 * @throws WatchNotFoundException
	 */
	@GetMapping("/watches/{id}")
	public ResponseEntity<WatchDto> getWatchById(@PathVariable("id") Long id) throws WatchNotFoundException {
		try {
			WatchDto watchDto = watchesService.getWatchById(id);
			return new ResponseEntity<WatchDto>(watchDto, HttpStatus.OK);
		} catch (WatchNotFoundException e) {
			throw e;
		}
	}
	
}
