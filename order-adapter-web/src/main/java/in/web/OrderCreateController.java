package in.web;

import java.util.ServiceLoader;

import port.in.CreateOrderUseCase;

public class OrderCreateController {
	private final CreateOrderUseCase createOrderUseCase;
	public  OrderCreateController() {
		this.createOrderUseCase = ServiceLoader.load(CreateOrderUseCase.class).findFirst().orElseThrow(IllegalStateException::new);
	}

	public String handleRequest(String id, String product) {
		createOrderUseCase.createOrder(id, product);
		return "Order created";
	}
}
