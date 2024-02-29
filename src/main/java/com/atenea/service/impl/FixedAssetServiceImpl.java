package com.atenea.service.impl;





import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atenea.exceptions.FixedAssetNotFoundException;
import com.atenea.exceptions.InvalidDatesException;
import com.atenea.model.FixedAsset;
import com.atenea.repository.FixedAssetRepository;
import com.atenea.service.FixedAssetService;

import lombok.extern.log4j.Log4j2;

@Service

@Log4j2
public class FixedAssetServiceImpl implements FixedAssetService{
	@Autowired
	private FixedAssetRepository fixedAssetRepository;

	@Override
	public List<FixedAsset> getAllAsset() {
		return fixedAssetRepository.findAll();
	}
	
	@Override
	public List<FixedAsset> findByTypeOrPurchaseDateOrSerial(FixedAsset.TypeAsset type, Date purchaseDate, String serial) {
        return fixedAssetRepository.findByTypeOrPurchaseDateOrSerial(type, purchaseDate, serial);
    }
	
	@Transactional
	@Override
	public FixedAsset createAsset(FixedAsset asset) throws InvalidDatesException {
		if (!validDate(asset)) {
		//	log.error("Las fechas no son válidas");
			throw new InvalidDatesException("Las fechas no son válidas para el activo: " + asset.getName());
		}
		return fixedAssetRepository.save(asset);
	}
	
	@Override
	public FixedAsset updateAsset(Long id, FixedAsset updateAsset) {
		if (updateAsset == null || id == null) {
			throw new IllegalArgumentException("El Activo o el ID no pueden ser nulos");
		}

		if (!validDate(updateAsset)) {

		//	log.error("Las fechas no son válidas");
			throw new InvalidDatesException("Las fechas no son válidas para el activo: " + id);
		}
		// Buscar el alumno a editar
		FixedAsset activoEncontrado = fixedAssetRepository.findById(id)
				.orElseThrow(() -> new FixedAssetNotFoundException(updateAsset.getId()));

		activoEncontrado.setPurchaseDate(updateAsset.getPurchaseDate());
		activoEncontrado.setSerial(updateAsset.getSerial());

		return fixedAssetRepository.save(activoEncontrado);
	}
	private boolean validDate(FixedAsset asset) {
		Date fechaCompra = asset.getPurchaseDate();
		Date fechaBaja = asset.getDisposalDate();

		// Verificar que la fecha de baja sea anterior o igual a la fecha de compra
		return fechaBaja == null || !fechaBaja.after(fechaCompra);
	
	}
	
}
