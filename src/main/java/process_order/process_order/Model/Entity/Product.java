package process_order.process_order.Model.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="Product Name", length = 20, nullable = false)
	private String proName;
	@Column(name="Product Price")
	private Integer proPrice;
	@Column(name="Product Quantity")
	private Integer ProQty;
	
	@ManyToOne(fetch =  FetchType.LAZY)
	private OrderProduct order;
	
	
	
	public OrderProduct getOrder() {
		return order;
	}
	public void setOrder(OrderProduct order) {
		this.order = order;
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
