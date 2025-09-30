package port.in;

import port.exceptions.OrderNotFoundException;

public interface UpdateOrderUseCase {
	void updateOrder(String id, String product) throws OrderNotFoundException;
}
