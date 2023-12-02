package org.food.service;


import org.food.model.OrderDetails;
import org.springframework.stereotype.Service;

@Service
public interface IOrderService {
	public OrderDetails addOrder(OrderDetails order);
	public OrderDetails findOrderById(Integer orderId);
//	public OrderDetails updateOrder(OrderDetails order);
//	public OrderDetails removeOrder(OrderDetails order);
//	public OrderDetails viewOrder(OrderDetails order);
//	public List<OrderDetails> viewAllOrders(Restaurant res);
//	public List<OrderDetails> viewAllOrders(Customer customer);

}
