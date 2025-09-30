package in.web;

import java.util.ServiceLoader;

import port.in.UpdateOrderUseCase;

public class OrderUpdateController {
    private final UpdateOrderUseCase updateOrderUseCase;
    public OrderUpdateController() {
        this.updateOrderUseCase = ServiceLoader.load(UpdateOrderUseCase.class).findFirst().orElseThrow(IllegalStateException::new);
    }

    public void handleRequest(String id, String product) throws Exception {
        updateOrderUseCase.updateOrder(id, product);
    }
}

