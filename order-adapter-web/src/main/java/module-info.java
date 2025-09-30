module order.adapter.web {
	exports in.web;
	uses port.in.CreateOrderUseCase;
	uses port.in.FindOrderUseCase;
	uses port.in.DeleteOrderUseCase;
	uses port.in.UpdateOrderUseCase;
	requires order.core.api;
}