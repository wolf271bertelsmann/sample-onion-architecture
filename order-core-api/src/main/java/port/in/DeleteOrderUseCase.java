package port.in;

import port.exceptions.OrderNotFoundException;

public interface DeleteOrderUseCase {
	void deleteOrder(String orderId) throws OrderNotFoundException;
}
