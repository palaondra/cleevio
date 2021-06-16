package com.pala.cleevio.demo.service.api;

import com.pala.cleevio.demo.dto.WatchDto;
import com.pala.cleevio.demo.exception.WatchAlreadyExistsException;
import com.pala.cleevio.demo.exception.WatchNotFoundException;

/**
 * Service for managing watches.
 */
public interface IWatchesService {
	
	/**
	 * Validate and create incoming WatchDto entity. If it is everything OK, maps WatchDto to Watch and store it in DB.
	 * 
	 * @param watchDto Incoming WatchDto entity.
	 * @throws WatchAlreadyExistsException When incoming watch has same <code>title</code> as some already stored watch.
	 */
	public void createWatch(WatchDto watchDto) throws WatchAlreadyExistsException;
	
	/**
	 * Return watch with incoming ID.
	 * 
	 * @param id Incoming ID of searched watches.
	 * @return WatchDto entity with searched ID.
	 * @throws WatchNotFoundException When watches with incoming ID doesn't exists in DB.
	 */
	public WatchDto getWatchById(Long id) throws WatchNotFoundException;
	
}
