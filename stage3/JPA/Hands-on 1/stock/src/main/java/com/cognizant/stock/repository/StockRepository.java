package com.cognizant.stock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.stock.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock,Integer>{

	@Query(value="select * from stock where st_code='FB' and month(st_date)=09 and year(st_date)=2019")
	public List<Stock> findbyCodeandMonth();
	
	public List<Stock> findByStCodeAndStCloseGreaterThan(String stCode,double stClose);

	
	public List<Stock> findTop3ByStCodeOrderByStClose(String stCode);

	public List<Stock> findTop3ByOrderByStVolumeDesc();
	
}
