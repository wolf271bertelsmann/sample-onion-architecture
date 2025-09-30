package in.web;

import java.util.ServiceLoader;

import model.OrderNotFoundException;
import port.in.UpdateOrderUseCase;

public class OrderUpdateController {
    private final UpdateOrderUseCase updateOrderUseCase;
    public OrderUpdateController() {
        this.updateOrderUseCase = ServiceLoader.load(UpdateOrderUseCase.class).findFirst().orElseThrow(IllegalStateException::new);
    }

    public String handleRequest(String id, String product) {
		try {
			updateOrderUseCase.updateOrder(id, product);
			return "Order updated";
		} catch (OrderNotFoundException e) {
			return  e.getMessage();
		}
	}
}

