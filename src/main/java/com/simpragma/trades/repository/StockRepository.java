package com.simpragma.trades.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.simpragma.trades.model.Stock;
import com.simpragma.trades.model.User;


@Repository
public interface StockRepository extends JpaRepository<Stock, Integer>{

	@Query(value = "SELECT * from stocks s where s.userid = :id ORDER BY s.id ASC", nativeQuery = true)
	public List<Stock> findByUserId(@Param("id") Integer id);

	@Query(value = "SELECT * from stocks s where s.symbol= :symbol and s.type =:type and timestamp >= :start "
			+ "and timestamp <= :end ORDER BY s.id ASC", nativeQuery = true)
	public List<Stock> filterByStockAndTrade(@Param("symbol") String symbol, @Param("type") String type,
			@Param("start") String start, @Param("end") String end);
}
