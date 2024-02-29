package com.atenea.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atenea.exceptions.AreaCustomException;
import com.atenea.model.Area;
import com.atenea.repository.AreaRepository;
import com.atenea.service.AreaService;

@Service
public class AreaServiceImpl  implements AreaService{
	@Autowired
	private AreaRepository areasRepository;
	
	/**
	 * Gets the all areas.
	 *
	 * @return the all areas
	 */
	@Override
	public List<Area> getAllAreas() throws AreaCustomException{
		return areasRepository.findAll();
	}
}
