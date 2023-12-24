package process_order.process_order.Model.Response;

import java.io.Serializable;

import process_order.process_order.Model.Entity.Product;

public class productResponse implements Serializable {

	private Long id;
	private String proName;
	private Integer proPrice;
	private Integer ProQty;
	
	public productResponse(Long id, String proName, Integer proPrice, Integer proQty) {
		super();
		this.id = id;
		this.proName = proName;
		this.proPrice = proPrice;
		ProQty = proQty;
	}
	
	public static productResponse  proResponse(Product pro) {
		return new productResponse(
				pro.getId(),
				pro.getProName(),
				pro.getProPrice(), 
				pro.getProQty()
				);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public Integer getProPrice() {
		return proPrice;
	}
	public void setProPrice(Integer proPrice) {
		this.proPrice = proPrice;
	}
	public Integer getProQty() {
		return ProQty;
	}
	public void setProQty(Integer proQty) {
		ProQty = proQty;
	}
	
}
