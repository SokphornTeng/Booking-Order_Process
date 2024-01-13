package testOrder.testProcessOrder.Model.Request;

import java.io.Serializable;

import testOrder.testProcessOrder.Model.Entity.productEntity;

public class productRequest implements Serializable {

	private String prodName;
	private Integer price;
	private Integer qty;
	public productRequest(String prodName, Integer price, Integer qty) {
		super();
		this.prodName = prodName;
		this.price = price;
		this.qty = qty;
	
	}
	
	public productEntity reqProd() {
		productEntity newProd = new productEntity();
		newProd.setProdName(this.prodName);
		newProd.setPrice(this.price);
		newProd.setQty(this.qty);
		return newProd;
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
