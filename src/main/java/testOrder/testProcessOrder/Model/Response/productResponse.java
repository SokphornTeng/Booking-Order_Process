package testOrder.testProcessOrder.Model.Response;

import java.io.Serializable;

import testOrder.testProcessOrder.Model.Entity.productEntity;

public class productResponse implements Serializable {

	private Long id;
	private String prodName;
	private Integer price;
	private Integer qty;
	public productResponse(Long id, String prodName, Integer price, Integer qty) {
		super();
		this.id = id;
		this.prodName = prodName;
		this.price = price;
		this.qty = qty;
	}
	
	public static productResponse prodMethodResp(productEntity prod) {
		return new productResponse(
				prod.getId(),
				prod.getProdName(),
				prod.getPrice(),
				prod.getQty()
				);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	
	
}
