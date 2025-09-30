package port.out;

import model.Order;
import port.exceptions.OrderNotFoundException;

public interface OrderRepository {
	void save(Order order);
	void delete(String orderId) throws OrderNotFoundException;
	void update(String orderId, Order order) throws OrderNotFoundException;
	Order find(String orderId) throws OrderNotFoundException;
}
