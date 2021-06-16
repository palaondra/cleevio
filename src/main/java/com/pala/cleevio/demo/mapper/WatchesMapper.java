package com.pala.cleevio.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.pala.cleevio.demo.dao.entity.Watch;
import com.pala.cleevio.demo.dto.WatchDto;

/**
 * Mapper for mapping WatchDto entities to Watch entities and for mapping Watch entities to WatchDto entities.
 */
@Mapper
public interface WatchesMapper {
	
	WatchesMapper INSTANCE = Mappers.getMapper( WatchesMapper.class );
	 
    @Mapping(source = "title", target = "title")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "fountain", target = "base64Image")
    Watch watchDtoToWatch(WatchDto watchDto);
    
    @Mapping(source = "title", target = "title")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "base64Image", target = "fountain")
    WatchDto watchToWatchDto(Watch watch);
    
    
	
}
