package com.pro.sicovenpro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pro.sicovenpro.model.Departamento;

public interface DepartamentoRepo  extends JpaRepository<Departamento, Integer> {
	
	//LISTAR con filtro
	@Query(
		value = " select * from departamentos where estado between :xest1 and :xest2 ",
	    nativeQuery = true)
	public List<Departamento> listaDeparFiltro(@Param("xest1") int xest1, @Param("xest2") int xest2);
	
	//INSERT
	@Modifying
	@Query(value = 
	    "insert into departamentos(nombre, estado) values (:xnombre, :xestado)",nativeQuery = true)
	public int addDepar(@Param("xnombre") String xnombre, @Param("xestado") int xestado);

	//UPDATE 
	@Modifying
	@Query(value = 
	    "update departamentos set nombre=:xnombre where codd = :xcodd ",nativeQuery = true)
	public int modDepar(@Param("xcodd") int xcodd, @Param("xnombre") String xnombre);
	
	//DELETE is logic delete
	@Modifying
	@Query(value =
			"update departamentos set estado = 0  where codd = :xcodd", nativeQuery = true)
	int delDepar(@Param("xcodd") int xcodd);

	//HABILITAR 
	@Modifying
	@Query(value =
			"update departamentos set estado = 1  where codd = :xcodd", nativeQuery = true)
	int habDepar(@Param("xcodd") int xcodd);
			
}
