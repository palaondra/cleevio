package com.pala.cleevio.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.pala.cleevio.demo.dao.WatchesRepository;
import com.pala.cleevio.demo.dao.entity.Watch;
import com.pala.cleevio.demo.dto.WatchDto;
import com.pala.cleevio.demo.exception.WatchAlreadyExistsException;
import com.pala.cleevio.demo.exception.WatchNotFoundException;
import com.pala.cleevio.demo.mapper.WatchesMapper;
import com.pala.cleevio.demo.service.api.IWatchesService;

@Service
public class WatchesService implements IWatchesService {
	
	@Autowired
	private WatchesRepository watchesRepository;
	
	/**
	 * @see IWatchesService#createWatch(WatchDto)
	 */
	@Override
	public void createWatch(WatchDto watchDto) throws WatchAlreadyExistsException {
		Watch findingWatch = watchesRepository.findByTitleLike(watchDto.getTitle());
		
		
		if (!ObjectUtils.isEmpty(findingWatch)) {
			System.out.println(findingWatch.toString());    
			throw new WatchAlreadyExistsException("Watch with " + watchDto.getTitle() + " already exists");
		}
		
		// mapping from DTO to DB entities
		Watch watch = WatchesMapper.INSTANCE.watchDtoToWatch(watchDto);
		
		// save to H2 DB
		Watch savedWatch = watchesRepository.save(watch);
		
		// set ID of new watches to DTO
		watchDto.setId(savedWatch.getId());
	}
	
	/**
	 * @see IWatchesService#getWatchById(Long)
	 */
	@Override
	public WatchDto getWatchById(Long id) throws WatchNotFoundException {
		Optional<Watch> findingWatchOptional = watchesRepository.findById(id);
		
		if (!findingWatchOptional.isPresent()) {
			throw new WatchNotFoundException("Watch with id: " + id + " not found");
		}
		
		return WatchesMapper.INSTANCE.watchToWatchDto(findingWatchOptional.get());
	}

}
