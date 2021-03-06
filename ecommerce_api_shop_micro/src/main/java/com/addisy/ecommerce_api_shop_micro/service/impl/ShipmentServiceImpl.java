package com.addisy.ecommerce_api_shop_micro.service.impl;

import com.addisy.ecommerce_api_shop_micro.domian.Shipment;
import com.addisy.ecommerce_api_shop_micro.repository.ShipmentRepository;
import com.addisy.ecommerce_api_shop_micro.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipmentServiceImpl implements ShipmentService {

	@Autowired
	private ShipmentRepository shipmentRepository;

	@Override
	public List<Shipment> findAll() {

		List<Shipment> shipmentList = (List<Shipment>) shipmentRepository.findAll();

		return shipmentList;	}

	@Override
	public Optional<Shipment> findById(Long id) {
		return shipmentRepository.findById(id);
	}

	@Override
	public Shipment save(Shipment shipment) {
		return shipmentRepository.save(shipment);
	}

	@Override
	public void removeOne(Long id) {
		shipmentRepository.deleteById(id);
	}
}
