package process_order.process_order.Model.Request;

import java.io.Serializable;
import java.util.List;

import process_order.process_order.Model.Entity.OrderProduct;

public class orderRequest implements Serializable {

	private String name;
	private List<productRequest> product;
	
	public orderRequest(String name, List<productRequest> product) {
		super();
		this.name = name;
		this.product = product;
	}
	
	public OrderProduct orderPro() {
		OrderProduct ordPro = new OrderProduct();
		ordPro.setName(this.name);
		return ordPro;
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
