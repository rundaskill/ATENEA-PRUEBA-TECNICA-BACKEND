package com.atenea.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.atenea.model.Area;
@Repository
public interface AreaRepository extends JpaRepository<Area, Long>{

}
