package port.in;

import port.exceptions.OrderNotFoundException;

public interface FindOrderUseCase {
	String  findOrder(String orderId) throws OrderNotFoundException;
}
