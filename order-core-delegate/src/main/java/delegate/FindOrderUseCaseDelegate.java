package delegate;

import java.util.Objects;
import java.util.ServiceLoader;

import model.OrderNotFoundException;
import port.in.FindOrderUseCase;


public class FindOrderUseCaseDelegate implements FindOrderUseCase {
	private final FindOrderUseCase delegate;
	public FindOrderUseCaseDelegate() {
		delegate = ServiceLoader.load(FindOrderUseCase.class).stream()
				.filter(provider -> !Objects.equals(getClass(), provider.type()))
				.map(ServiceLoader.Provider::get)
				.findFirst().orElseThrow(IllegalStateException::new);
	}
	@Override
	public String findOrder(String orderId) throws OrderNotFoundException {
		return String.format("Call from delegate %s", delegate.findOrder(orderId));
	}
}
