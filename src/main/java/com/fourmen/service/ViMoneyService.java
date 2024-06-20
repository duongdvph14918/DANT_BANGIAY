package com.fourmen.service;

import java.util.List;

import com.fourmen.entity.ViMoney;

public interface ViMoneyService {

	List<ViMoney> findAll();

	<S extends ViMoney> S save(S entity);

}
