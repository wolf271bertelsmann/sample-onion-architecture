package port.in;

import model.OrderNotFoundException;

public interface UpdateOrderUseCase {
	void updateOrder(String id, String product) throws OrderNotFoundException;
}
