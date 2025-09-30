package port.exceptions;

public class OrderNotFoundException extends Exception {
	public OrderNotFoundException(String orderId) {
		super(String.format("Order with id %s not found", orderId));
	}
}
