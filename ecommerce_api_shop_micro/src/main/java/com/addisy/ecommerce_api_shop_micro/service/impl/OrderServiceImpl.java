package com.addisy.ecommerce_api_shop_micro.service.impl;

import com.addisy.ecommerce_api_shop_micro.domian.*;
import com.addisy.ecommerce_api_shop_micro.repository.OrderPaymentRepository;
import com.addisy.ecommerce_api_shop_micro.repository.OrderRepository;
import com.addisy.ecommerce_api_shop_micro.repository.OrderShippingAddressRepository;
import com.addisy.ecommerce_api_shop_micro.service.CartItemService;
import com.addisy.ecommerce_api_shop_micro.service.OrderService;
import com.addisy.ecommerce_api_shop_micro.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CartItemService cartItemService;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private OrderShippingAddressRepository orderShippingAddressRepository;

	@Autowired
	private ShipmentService shipmentService;


	@Autowired
	private OrderPaymentRepository orderPaymentRepository;

	public Order createOrder(ShoppingCart shoppingCart, UserShippingAddress userShippingAddress, PaymentCard paymentCard, User user){

		Order order = new Order();
		OrderShippingAddress orderShippingAddress = new OrderShippingAddress();
		OrderPayment orderPayment = new OrderPayment();
		Shipment shipment =new Shipment();

		List<CartItem> cartItemList = cartItemService.findCartItemsByShoppingCart(shoppingCart);

		for (CartItem cartItem : cartItemList) {
			cartItem.setOrder(order);
			Item item = restTemplate.getForObject("http://localhost:8083/item/"+cartItem.getItemId(), Item.class);
			item.setQntInStock(item.getQntInStock()-cartItem.getQuantity());
			restTemplate.postForEntity("http://localhost:8083/item/update",item, Item.class);
		}

		orderShippingAddress.setUserShippingAddressId(userShippingAddress.getId());

		orderPayment.setPaymentCardId(paymentCard.getId());
		orderPayment.setOrder(order);
		order.setOrderPayment(orderPayment);

		shipment.setOrderShippingAddress(orderShippingAddress);
		shipment.setDepartureDate(Calendar.getInstance().getTime());
		shipment.setShippingStatus("Active");
		shipment.setOrder(order);

		order.setCartItemList(cartItemList);
		order.setTotalPrice(shoppingCart.getTotalPrice());
		order.setUser(user);
		order.setShipment(shipment);
		order = orderRepository.save(order);

		shipmentService.save(shipment);

		return order;
	}

	public Optional<Order> findOrderById(Long id) {
		return orderRepository.findById(id);
	}

	public Order saveOrder(Order order){
		return orderRepository.save(order);
	}

}

