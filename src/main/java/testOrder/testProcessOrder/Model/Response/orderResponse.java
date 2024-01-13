package testOrder.testProcessOrder.Model.Response;

import java.io.Serializable;
import java.util.List;

import testOrder.testProcessOrder.Model.Entity.orderEntity;

public class orderResponse implements Serializable{

	private Long id;
	private String name;
	private List<productResponse> product;
	public orderResponse(Long id, String name, List<productResponse> product) {
		super();
		this.id = id;
		this.name = name;
		this.product = product;
	}
	
	public static orderResponse orderMethodResp(orderEntity orderEn) {
		return new orderResponse(
				orderEn.getId(),
				orderEn.getName(),
				orderEn.getProduct().stream().map(productResponse::prodMethodResp).toList()
				);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<productResponse> getProduct() {
		return product;
	}
	public void setProduct(List<productResponse> product) {
		this.product = product;
	}
	
	
}
