package com.temple.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.temple.model.Temple;
@Repository
public interface TempleRepository extends JpaRepository<Temple, Integer>{

	boolean existsByTempleName(String templeName);

	List<Temple> findByTempleName(String templeName);
	
	
//	@Query(value = "select * from temple inner join place on temple.placeId = place.placeId where place.city = ?",nativeQuery = true)
//	boolean existsByCity(String city);

	@Query(value = "select * from temple inner join place on temple.place_id = place.place_id where place.city = ?",nativeQuery = true)
	List<Temple> findByCity(String city);

//	@Query(value = "select * from temple inner join place on temple.placeId = place.placeId where place.area = ?",nativeQuery = true)
//	boolean existsByArea(String area);

	@Query(value = "select * from temple inner join place on temple.place_id = place.place_id where place.area = ?",nativeQuery = true)
	List<Temple> findByArea(String area);

	
//	@Query(value = "select * from temple inner join place on temple.placeId = place.placeId where place.state = ?",nativeQuery = true)
//	boolean existsByState(String state);
    
	
	@Query(value = "select * from temple inner join place on temple.place_id = place.place_id where place.state = ?",nativeQuery = true)
	List<Temple> findByState(String state);
    
	
//	@Query(value = "select * from temple inner join place on temple.placeId = place.placeId where place.state = ? and place.city = ? and place.area = ?",nativeQuery = true)
//	boolean existsByStateAndCityAndArea(String state, String city, String area);

	
	@Query(value = "select * from temple inner join place on temple.place_id = place.place_id where place.state = ? and place.city = ? and place.area = ?",nativeQuery = true)
	List<Temple> findByStateAndCityAndArea(String state, String city, String area);

	
}




//@Query("SELECT * FROM temple t INNER JOIN place p on t.PLACE_PLACE_ID = p.PLACE_ID WHERE p.city LIKE ?1")

//@Query("select t from temple t inner join t.place p where p.city=?")

//@Query("SELECT * FROM temple t INNER JOIN place p WHERE p.city LIKE ?1")