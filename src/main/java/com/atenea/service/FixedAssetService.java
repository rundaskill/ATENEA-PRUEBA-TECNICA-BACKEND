package com.atenea.service;
import java.util.Date;
import java.util.List;

import com.atenea.model.FixedAsset;
public interface FixedAssetService {

	List<FixedAsset> getAllAsset();
	
	 List<FixedAsset> findByTypeOrPurchaseDateOrSerial(FixedAsset.TypeAsset type, Date purchaseDate, String serial);
	 
	 FixedAsset createAsset(FixedAsset asset);
	 
	 FixedAsset updateAsset(Long id, FixedAsset updateAsset);
}
