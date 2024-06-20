package com.fourmen.service;

import java.util.List;
import java.util.Optional;

import com.fourmen.entity.OrderDetail;

public interface OrderDetailService {

	OrderDetail getById(Integer id);

	void delete(OrderDetail entity);

	void deleteById(Integer id);

	Optional<OrderDetail> findById(Integer id);

	List<OrderDetail> findAll();

	<S extends OrderDetail> S save(S entity);

}
