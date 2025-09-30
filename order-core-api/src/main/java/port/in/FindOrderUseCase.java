package port.in;

import model.OrderNotFoundException;

public interface FindOrderUseCase {
	String  findOrder(String orderId) throws OrderNotFoundException;
}
