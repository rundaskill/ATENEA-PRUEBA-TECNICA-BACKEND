package com.atenea.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atenea.model.Area;
import com.atenea.service.AreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Áreas")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/area")
public class AreasController {
	@Autowired
	private AreaService areaService;

	  /**
  	 * Gets the all areas.
  	 *
  	 * @return the all areas
  	 */
	@ApiOperation("Obtener todas las áreas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista de áreas obtenida con éxito"),
            @ApiResponse(code = 500, message = "Error interno del servidor")
    })  		  
	@GetMapping
	public ResponseEntity<List<Area>> getAllAreas(){
		return ResponseEntity.ok(areaService.getAllAreas());
	}
}
