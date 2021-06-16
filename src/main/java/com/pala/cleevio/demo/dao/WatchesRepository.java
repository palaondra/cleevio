package com.pala.cleevio.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pala.cleevio.demo.dao.entity.Watch;

public interface WatchesRepository extends JpaRepository<Watch, Long>{
	
	/**
	 * Return Watch entity by input <code>title</code>.
	 * 
	 * @param title Input searching parameter - <code>title</code>.
	 * @return Watch entity with input <code>title</code>.
	 */
	public Watch findByTitleLike(String title);
	
}
