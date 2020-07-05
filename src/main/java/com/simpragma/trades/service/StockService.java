package com.simpragma.trades.service;

import java.util.List;

import com.simpragma.trades.exception.StockException;
import com.simpragma.trades.model.Stock;

public interface StockService {

	public void removeStocks();
	
	public void newStock(Stock stock);
	
	public List<Stock> stocksList();
	
	public List<Stock> stocksByUserId(int id) throws StockException;
	
	public List<Stock> filterByStockAndTrade(String sybol, String type, String start, String end) throws StockException;
}
