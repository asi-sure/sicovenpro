package com.pro.sicovenpro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pro.sicovenpro.model.Generales;

public interface GeneralRepo  extends JpaRepository<Generales, Integer> {
	
	//VERIFICA si el dato existe
	@Query(value=
			"SELECT count(c.cods) FROM generales c WHERE c.cods = ?1 ",nativeQuery = true)
	public int verificarExistencia(int xcods);
	
	//INSERT a Datos Generales
	@Modifying
	@Query(value = 
	    "insert into generales(cods,codven,codpag) values (:xcods,:xcodven,:xcodpag)",nativeQuery = true)
	public int addGenerales(@Param("xcods") int xcods, @Param("xcodven") int xcodven,
					 @Param("xcodpag") int xcodpag);
	
	//UPDATE datos Generales 
	@Modifying
	@Query(value =
			"update generales set codven = :xcodven, codpag=:xcodpag  where cods = :xcods", nativeQuery = true)
	int modGenerales(@Param("xcods") int xcods, @Param("xcodven") int xcodven,
			 @Param("xcodpag") int xcodpag);
	
}
