package testOrder.testProcessOrder.Model.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Orders")
public class orderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="Customer Name", length = 30, nullable = false)
	private String name;
	@Column(name="Tatol Price")
	private Integer total;
	
	@OneToMany(mappedBy = "order")
	private List<productEntity> product;

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

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<productEntity> getProduct() {
		return product;
	}

	public void setProduct(List<productEntity> product) {
		this.product = product;
	}
	
	
}
