package hive;

import java.util.ArrayList;

public class OrderHandler {
	
	private ArrayList<Order> orders;	
	
	
	public OrderHandler() {
		super();
		orders = new ArrayList<Order>();
	}
	
	/*
	 * find creatures for orders and make them execute them
	 */
	public void handle_orders() {
		//TODO
	}
	
	public void new_order(Order order) {
		orders.add(order);
	}
	public void cancle_order(Order order) {
		if (orders.contains(order)) {
			orders.remove(order);
		}
	}	
	
	//getters and setters
	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
}
