package testOrder.testProcessOrder.Model.Request;

import java.io.Serializable;
import java.util.List;

import testOrder.testProcessOrder.Model.Entity.orderEntity;

public class orderRequest implements Serializable {

	private String name;
	private List<productRequest> product;
	
	public orderRequest(String name, List<productRequest> product) {
		super();
		this.name = name;
		this.product = product;
	}

	public orderEntity reqOrder() {
		orderEntity newOrder = new orderEntity();
		newOrder.setName(this.name);
		newOrder.getProduct();
		return newOrder;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<productRequest> getProduct() {
		return product;
	}

	public void setProduct(List<productRequest> product) {
		this.product = product;
	}
	
	
	
}
