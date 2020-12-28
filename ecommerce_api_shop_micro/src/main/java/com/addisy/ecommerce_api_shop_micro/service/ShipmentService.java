package com.addisy.ecommerce_api_shop_micro.service;

import com.addisy.ecommerce_api_shop_micro.domian.Shipment;

import java.util.List;
import java.util.Optional;

public interface ShipmentService {

	List<Shipment> findAll();

	Optional<Shipment> findById(Long id);

	Shipment save(Shipment item);

	void removeOne(Long id);
}
