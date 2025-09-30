package wolf271bertelsmann;

import java.util.Scanner;

import in.web.OrderCreateController;
import in.web.OrderDeleteController;
import in.web.OrderFindController;
import in.web.OrderUpdateController;

/**
 * Hello world!
 *
 */
public class App {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		String command;
		System.out.println("Ender Command (create, find, update, delete) or leave empty to close");
		while (!(command = sc.nextLine()).isEmpty()) {
			switch (command) {
				case "create":
					createOrder();
					break;
				case "find":
					findOrder();
					break;
				case "update":
					updateOrder();
					break;
				case "delete":
					deleteOrder();
					break;
				default:
					unknownCommand();
					break;
			}
		}
	}

	private static void createOrder() {
		System.out.println("Enter order ID");
		String orderID = sc.nextLine();
		System.out.println("Enter order name");
		String orderName = sc.nextLine();
		OrderCreateController orderCreateController = new OrderCreateController();
		System.out.println(orderCreateController.handleRequest(orderID, orderName));
	}

	private static void findOrder() {
		System.out.println("Enter order ID");
		String orderID = sc.nextLine();
		OrderFindController orderFindController = new OrderFindController();
		System.out.println(orderFindController.handleRequest(orderID));
	}

	private static void updateOrder() {
		System.out.println("Enter order ID");
		String orderID = sc.nextLine();
		System.out.println("Enter order name");
		String orderName = sc.nextLine();
		OrderUpdateController orderUpdateController = new OrderUpdateController();
		System.out.println(orderUpdateController.handleRequest(orderID, orderName));
	}

	private static void deleteOrder() {
		System.out.println("Enter order ID");
		String orderId = sc.nextLine();
		OrderDeleteController orderDeleteController = new OrderDeleteController();
		System.out.println(orderDeleteController.handleRequest(orderId));
	}

	private static void unknownCommand() {
		System.out.println("Invalid command");
	}
}
