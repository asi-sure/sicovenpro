package com.pro.sicovenpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pro.sicovenpro.model.Sucursal;

public interface SucursalRepo extends JpaRepository<Sucursal, Integer> {
	
	//INSERT a Personal
		@Modifying
		@Query(value = 
		    "insert into sucursales(nombre,direcc, dirweb, estado,lugar,logo,dirlogo) values (:nombres, :direcc, :dirweb, :estado, :lugar, :logo, :dirlogo)",nativeQuery = true)
		public int addSucursal(@Param("nombres") String xnombres, @Param("direcc") String xdirecc,
						 @Param("dirweb") String xdirweb, @Param("estado") int xestado, @Param("lugar") String xlugar,
						 @Param("logo") String xlogo, @Param("dirlogo") String xdirlogo);

	//DELETE is logic delete
		@Modifying
		@Query(value =
				"update sucursales   set estado = 0  where cods = :xcods", nativeQuery = true)
		int eliminarSucursal(@Param("xcods") int xcods);

	//HABILITAR 
		@Modifying
		@Query(value =
				"update sucursales   set estado = 1  where cods = :xcods", nativeQuery = true)
		int habilitarSucursal(@Param("xcods") int xcods);
		
	//UPDATE 
		@Modifying
		@Query(value = 
		    "update sucursales   set nombre=:nombres, direcc=:direcc, dirweb=:dirweb, lugar=:lugar  where cods = :xcods ",nativeQuery = true)
		public int modSucursal(@Param("xcods") int xcods, @Param("nombres") String xnombres, @Param("direcc") String xdirecc,
						 @Param("dirweb") String xdirweb,@Param("lugar") String xlugar);
}
