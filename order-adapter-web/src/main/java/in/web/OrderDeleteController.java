package in.web;

import java.util.ServiceLoader;

import port.in.DeleteOrderUseCase;

public class OrderDeleteController {
    private final DeleteOrderUseCase deleteOrderUseCase;
    public OrderDeleteController() {
        this.deleteOrderUseCase = ServiceLoader.load(DeleteOrderUseCase.class).findFirst().orElseThrow(IllegalStateException::new);
    }

    public void handleRequest(String orderId) throws Exception {
        deleteOrderUseCase.deleteOrder(orderId);
    }
}

