package com.addisy.ecommerce_api_shop_micro.controller;

import com.addisy.ecommerce_api_shop_micro.domian.Shipment;
import com.addisy.ecommerce_api_shop_micro.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {

	@Autowired
	private ShipmentService shipmentService;

	@RequestMapping("/shipmentList")
	public List<Shipment> getShipmentList() {

		return shipmentService.findAll();
	}

	@RequestMapping("/{id}")
	public Optional<Shipment> getShipment(@PathVariable("id") Long id){
		Optional<Shipment> shipment = shipmentService.findById(id);
		return shipment;
	}

	@RequestMapping(value="/update", method=RequestMethod.POST)
	public Map<String,Object> updateShipmentPost(@RequestBody HashMap<String, Object> mapper) {

		String shipmentId = String.valueOf(mapper.get("id"));

		Shipment shipment = shipmentService.findById(Long.parseLong(shipmentId)).orElse(null);

		shipment.setShippingStatus((String) mapper.get("shippingStatus"));
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
		try{

		shipment.setArrivalDate(formatter.parse(String.valueOf(mapper.get("arrivalDate"))));
		} catch (Exception ex){
			System.out.println(ex);
		}

		Shipment shipment1 = shipmentService.save(shipment);

		Map<String,Object> response = new HashMap<>();

		response.put("message", "update successful!");
		response.put("shipment", shipment1);

		return response;
	}

}
