package com.cognizant.stock;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.stock.model.Stock;
import com.cognizant.stock.repository.StockRepository;



@SpringBootApplication
public class stockApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(stockApplication.class);
	
	private static StockRepository stockRepository;
  public static void main(String[] args) {
	  LOGGER.info("Inside main");
		ApplicationContext con = SpringApplication.run(stockApplication.class,args);
		stockRepository=con.getBean(StockRepository.class);
		getFBstockSep();
		getGooglestock1250();
		getTop3Volume();
		getByCodeStockLow();
		
	}
  private static void getFBstockSep() {
	  LOGGER.info("*****start fb sep 2019 *****");
	  List<Stock> fbList=stockRepository.findbyCodeandMonth();
	  LOGGER.debug("stock ={}",fbList);
	  LOGGER.info("*****End  fb sep 2019 ******");
  }
  private static void getGooglestock1250() {
	  LOGGER.info("*****start get google stock>1250 *****");
	  List<Stock> googleList=stockRepository.findByStCodeAndStCloseGreaterThan("GOOGL",1250.0);
	  LOGGER.debug("stock ={}",googleList);
	  LOGGER.info("*****End  get google stock>1250 ******");
  }
  
  private static void getTop3Volume() {
	  LOGGER.info("*****start get top 3 stock *****");
	  List<Stock> topVolume=stockRepository.findTop3ByOrderByStVolumeDesc();
	  LOGGER.debug("stock = {}",topVolume);
	  LOGGER.info("*****End  get top 3 stock ******");
	  
  }
  private static void  getByCodeStockLow() {
	  LOGGER.info("*****start get netflix bottom 3 stock *****");
	  List<Stock> stockLow=stockRepository.findTop3ByStCodeOrderByStClose("NFLX");
	  LOGGER.debug("stock = {}",stockLow);
	  LOGGER.info("*****End  get get netflix bottom 3 stock ******");
	  
  }
  
  
}
