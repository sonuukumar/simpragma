package com.simpragma.trades.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simpragma.trades.exception.StockException;
import com.simpragma.trades.model.Stock;
import com.simpragma.trades.service.StockService;

@RestController
public class StockController {

	@Autowired
	StockService service;
	/**
	 * 
	 * 
	 * @return
	 */
	@GetMapping("/trades")
	public ResponseEntity<List<Stock>> stocksList() {
		
		List<Stock> list = service.stocksList();
		
		return new ResponseEntity(list, HttpStatus.OK);
	}
	/**
	 * 
	 * 
	 * @param stock
	 * @return
	 */
	@PostMapping("/trade")
	public ResponseEntity<String> newStock(@RequestBody Stock stock){
		service.newStock(stock);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	/**
	 * 
	 * 
	 * @return
	 */
	@DeleteMapping("/trade")
    public ResponseEntity<String> removeStocks(){
	    service.removeStocks();	
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	/**
	 * 
	 * 
	 * @param userId
	 * @return
	 * @throws StockException 
	 */
	@GetMapping("/trades/user/{userId}")
	public ResponseEntity<List<Stock>> stocksByUserId(@PathVariable int userId) throws StockException {
		List<Stock> list = service.stocksByUserId(userId);
		return new ResponseEntity(list, HttpStatus.OK);
	}
	/**
	 * 
	 * @param stocksymbol
	 * @param type
	 * @param start
	 * @param end
	 * @return
	 * @throws StockException 
	 */
	@GetMapping("/stocks/{stocksymbol}/trades")
	public ResponseEntity<List<Stock>> filterByStockAndTradeType(@PathVariable String stocksymbol,
			@RequestParam String type, @RequestParam String start,@RequestParam String end) throws StockException{
		List <Stock> list = service.filterByStockAndTrade(stocksymbol, type, start, end);
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	
}
