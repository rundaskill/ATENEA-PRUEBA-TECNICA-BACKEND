package com.atenea.controller;
import java.time.Instant;
import java.time.ZoneId;
import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atenea.exceptions.ApiResponseMessage;
import com.atenea.model.FixedAsset;
import com.atenea.service.FixedAssetService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api(tags = "FixedAssetController")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/asset")
public class FixedAssetController {
	@Autowired
	private FixedAssetService fixedAssetService;
	
	@ApiOperation("Obtener todos los activos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de activos obtenida con éxito"),
			@ApiResponse(code = 500, message = "Error interno del servidor") })
	@GetMapping
	public ResponseEntity<List<FixedAsset>> getAllActivos() {
		return ResponseEntity.ok(fixedAssetService.getAllAsset());
	}
	@ApiOperation("Actualizar un activo por su ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Activo actualizado con éxito"),
			@ApiResponse(code = 400, message = "Datos faltantes al actualizar el activo"),
			@ApiResponse(code = 404, message = "Activo no encontrado"),
			@ApiResponse(code = 500, message = "Error interno del servidor") })
	@PutMapping("/{id}")
	public FixedAsset updateAsset(@PathVariable Long id, @RequestBody FixedAsset updatedAsset){
		return fixedAssetService.updateAsset(id, updatedAsset);
	}
	
	@ApiOperation("Crear un nuevo activo")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Activo creado con éxito"),
			@ApiResponse(code = 400, message = "Datos faltantes al crear el activo"),
			@ApiResponse(code = 500, message = "Error interno del servidor") })
	@PostMapping
	public ResponseEntity<FixedAsset> createAsset(@RequestBody FixedAsset asset) {
		return ResponseEntity.status(HttpStatus.CREATED).body(fixedAssetService.createAsset(asset));
	}
	
	@ApiOperation("Buscar activos por parámetros")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de activos encontrada con éxito"),
			@ApiResponse(code = 400, message = "Datos faltantes al realizar la búsqueda"),
			@ApiResponse(code = 404, message = "No se encontraron activos"),
			@ApiResponse(code = 500, message = "Error interno del servidor") })
	
	@GetMapping("/buscar")
	public ResponseEntity<Object> findByTypeOrPurchaseDateOrSerial(
			@RequestParam(required = false) FixedAsset.TypeAsset type,
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date purchaseDate,
			@RequestParam(required = false) String serial) {

		if (purchaseDate != null) {
			Instant instant = purchaseDate.toInstant();
			purchaseDate = Date.from(instant.atZone(ZoneId.of("UTC")).toInstant());
		}
		
	    List<FixedAsset> activos = fixedAssetService.findByTypeOrPurchaseDateOrSerial(type, purchaseDate, serial);

	    if (activos.isEmpty()) {
	        ApiResponseMessage responseMessage = new ApiResponseMessage(404, "No se encontraron activos");
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMessage);
	    }

	    return ResponseEntity.ok(activos);
	}
	
	
}
