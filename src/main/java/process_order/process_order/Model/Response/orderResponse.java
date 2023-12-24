package process_order.process_order.Model.Response;

import java.io.Serializable;
import java.util.List;

import process_order.process_order.Model.Entity.OrderProduct;

public class orderResponse implements Serializable {
	
	private Long id;
	private String name;
	private Double total;

	private List<productResponse> product;
	
	public orderResponse(Long id, String name, Double total, List<productResponse> product) {
		super();
		this.id = id;
		this.name = name;
		this.total = total;
		this.product = product;
	}
	
	public static orderResponse orderBack(OrderProduct or) {
		return new orderResponse(
				or.getId(),
				or.getName(),
				or.getTotal(), 
				or.getProduct().stream().map(productResponse::proResponse).toList()
				);
	}
	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
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
