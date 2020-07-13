package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.Currency;
import com.demo.model.GetCurrency;

@Transactional
@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {

	@Query("select rate from Currency c where c.currency = ?1 and c.base = ?2")
	abstract double getConvertedAmount(String toCurrency, String baseCcy);

	@Query("select new com.demo.model.GetCurrency(currency,rate,base) from Currency c where c.base = ?1")
	abstract List<GetCurrency> findAllCurrencies(String baseCcy);

}
