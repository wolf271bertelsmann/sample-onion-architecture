package in.web;

import java.util.ServiceLoader;

import model.OrderNotFoundException;
import port.in.FindOrderUseCase;

public class OrderFindController {
    private final FindOrderUseCase findOrderUseCase;
    public OrderFindController() {
        this.findOrderUseCase = ServiceLoader.load(FindOrderUseCase.class).findFirst().orElseThrow(IllegalStateException::new);
    }

    public String handleRequest(String orderId) {
		try {
			return findOrderUseCase.findOrder(orderId);
		} catch (OrderNotFoundException e) {
			return e.getMessage();
		}
	}
}

