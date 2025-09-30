package out.persistence;

import java.util.HashMap;
import java.util.Map;

import model.Order;
import model.OrderNotFoundException;
import port.out.OrderRepository;

public class InMemoryOrderRepository implements OrderRepository {
	private static final Map<String, Order> ORDERS = new HashMap<>();
	@Override
	public void save(Order order) {
		ORDERS.put(order.getId(), order);
	}

	@Override
	public void delete(String orderId) throws OrderNotFoundException {
		Order order = ORDERS.remove(orderId);
		if (order == null) {
			throw new OrderNotFoundException(orderId);
		}
	}

	@Override
	public void update(String orderId, Order order) throws OrderNotFoundException {
		Order orderTempOut = ORDERS.get(orderId);
		if (orderTempOut == null) {
			throw new OrderNotFoundException(orderId);
		}
		orderTempOut.setProduct(order.getProduct());
	}

	@Override
	public Order find(String orderId) throws OrderNotFoundException {
		Order order = ORDERS.get(orderId);
		if (order == null) {
			throw new OrderNotFoundException(orderId);
		}
		return order;
	}
}
