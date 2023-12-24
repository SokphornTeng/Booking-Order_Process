package process_order.process_order.Model.Request;

import java.io.Serializable;

import process_order.process_order.Model.Entity.Product;

public class productRequest implements Serializable {

	private String proName;
	private Integer proPrice;
	private Integer ProQty;
	
	public Product reqPro() {
		Product pro = new Product();
		pro.setProName(this.proName);
		pro.setProPrice(this.proPrice);
		pro.setProQty(this.ProQty);
		return pro;
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
