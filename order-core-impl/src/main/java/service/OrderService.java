package service;

import java.util.ServiceLoader;

import model.Order;
import port.in.CreateOrderUseCase;
import port.in.DeleteOrderUseCase;
import port.in.FindOrderUseCase;
import model.OrderNotFoundException;
import port.in.UpdateOrderUseCase;
import port.out.OrderRepository;

public class OrderService implements CreateOrderUseCase, DeleteOrderUseCase, FindOrderUseCase, UpdateOrderUseCase {
	private final OrderRepository orderRepository;
	public OrderService() {
		this.orderRepository = ServiceLoader.load(OrderRepository.class).findFirst().orElseThrow(IllegalStateException::new);
	}

	@Override
	public void createOrder(String id, String product) {
		Order order = new Order();
		order.setId(id);
		order.setProduct(product);
		orderRepository.save(order);
	}

	@Override
	public void deleteOrder(String orderId) throws OrderNotFoundException {
		orderRepository.delete(orderId);
	}

	@Override
	public String findOrder(String orderId) throws OrderNotFoundException {
		Order order = orderRepository.find(orderId);
		return order.getProduct();
	}

	@Override
	public void updateOrder(String id, String product) throws OrderNotFoundException {
		Order order = new Order();
		order.setId(id);
		order.setProduct(product);
		orderRepository.update(id, order);
	}
}
