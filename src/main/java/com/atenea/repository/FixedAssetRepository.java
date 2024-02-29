package com.atenea.repository;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.atenea.model.FixedAsset;
public interface FixedAssetRepository extends JpaRepository<FixedAsset, Long>{

	  /**
     * Find by type or purchaseDate or serial.
     *
     * @param type the type of the asset
     * @param purchaseDate the purchase date of the asset
     * @param serial the serial number of the asset
     * @return the list of FixedAsset
     */
    List<FixedAsset> findByTypeOrPurchaseDateOrSerial(FixedAsset.TypeAsset type, Date purchaseDate, String serial);
}
