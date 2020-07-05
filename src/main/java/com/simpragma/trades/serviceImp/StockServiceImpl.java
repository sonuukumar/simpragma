package com.simpragma.trades.serviceImp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simpragma.trades.exception.StockException;
import com.simpragma.trades.model.Stock;
import com.simpragma.trades.model.User;
import com.simpragma.trades.repository.StockRepository;
import com.simpragma.trades.repository.UserRepository;
import com.simpragma.trades.service.StockService;

@Component
public class StockServiceImpl implements StockService	{

	
	@Autowired
	StockRepository repo;
	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public void removeStocks() {
		repo.deleteAll();		
	}

	@Override
	public void newStock(Stock stock) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		stock.setTimestamp(new String(formatter.format(date)));
		User user = userRepo.findByName(stock.getUser().getName());
		if(user != null) {
			stock.setUser(user);
		}
		repo.save(stock);	
	}

	@Override
	public List<Stock> stocksList() {     
		List<Stock> list = repo.findAll();
		return list;
		
	}

	@Override
	public List<Stock> stocksByUserId(int id) throws StockException {
		List<Stock> list = repo.findByUserId(id);
		if(list.isEmpty()) {
			throw new StockException("No Stock For given user");
		}
		return list;
	}

	@Override
	public List<Stock> filterByStockAndTrade(String symbol, String type, String start, String end)
			throws StockException {
		start = start+" 00:00:00";
		end = end+" 23:59:59";
		List<Stock> list = repo.filterByStockAndTrade(symbol, type, start, end);
		if(list.isEmpty()) {
			throw new StockException("No Stock For given filters");
		}
		return list;
	}

}
