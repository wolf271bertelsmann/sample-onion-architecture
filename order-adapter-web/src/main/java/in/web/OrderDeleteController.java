package in.web;

import java.util.ServiceLoader;

import model.OrderNotFoundException;
import port.in.DeleteOrderUseCase;

public class OrderDeleteController {
    private final DeleteOrderUseCase deleteOrderUseCase;
    public OrderDeleteController() {
        this.deleteOrderUseCase = ServiceLoader.load(DeleteOrderUseCase.class).findFirst().orElseThrow(IllegalStateException::new);
    }

    public String handleRequest(String orderId) {
		try {
			deleteOrderUseCase.deleteOrder(orderId);
			return "Order deleted";
		} catch (OrderNotFoundException e) {
			return e.getMessage();
		}
	}
}

