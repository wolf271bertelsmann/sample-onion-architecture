package port.in;

import model.OrderNotFoundException;

public interface DeleteOrderUseCase {
	void deleteOrder(String orderId) throws OrderNotFoundException;
}
