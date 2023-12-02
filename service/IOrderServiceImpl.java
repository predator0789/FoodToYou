package org.food.service;


import java.util.Optional;

import org.food.model.OrderDetails;
import org.food.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IOrderServiceImpl implements IOrderService{

	@Autowired
    private OrderDetailsRepository orderDetailsRepository;

	@Override
	public OrderDetails addOrder(OrderDetails order) {
		// TODO Auto-generated method stub
		return orderDetailsRepository.save(order);
	}

	@Override
	public OrderDetails findOrderById(Integer orderId) {
		// TODO Auto-generated method stub
		Optional<OrderDetails> opt=orderDetailsRepository.findById(orderId);
		if(opt.isPresent())
			return opt.get();
		return null;
	}

}
