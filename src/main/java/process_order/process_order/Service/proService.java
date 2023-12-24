package process_order.process_order.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import process_order.process_order.Model.Entity.OrderProduct;
import process_order.process_order.Model.Entity.Product;
import process_order.process_order.Model.Request.orderRequest;
import process_order.process_order.Model.Request.productRequest;
import process_order.process_order.Repo.orderRepo;

@Service
public class proService {

	private final orderRepo orderRepository;
    @Autowired
	public proService(orderRepo orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}
	
    public OrderProduct addData(orderRequest reqOr) {
    	OrderProduct orderPro = reqOr.orderPro();
    	
    	Double total = 0.0;
    	ArrayList<Product> proList = new ArrayList<Product>();
    	
    	for(productRequest reqProd : reqOr.getProduct()) {
    		
    		total += (reqProd.getProPrice()*reqProd.getProQty());
    		
    		Product prods = new Product();
    		prods.setProName(reqProd.getProName());
    		prods.setProPrice(reqProd.getProPrice());
    		prods.setProQty(reqProd.getProQty());
    		prods.setOrder(orderPro);
    		
    		proList.add(prods);
    	}
    	
    	orderPro.setTotal(total);
    	orderPro.setProduct(proList);
    	
    	return this.orderRepository.save(orderPro);
    	
    }
    
    
    public OrderProduct updateData(Long id, orderRequest reqOr) {
    	OrderProduct updatePro = reqOr.orderPro();
    	
    	Double total = 0.0;
    	ArrayList<Product> proList = new ArrayList<Product>();
    	
    	for(productRequest reqProd : reqOr.getProduct()) {
    		
    		total += (reqProd.getProPrice()*reqProd.getProQty());
    		
    		Product prods = new Product();
    		prods.setProName(reqProd.getProName());
    		prods.setProPrice(reqProd.getProPrice());
    		prods.setProQty(reqProd.getProQty());
    		prods.setOrder(updatePro);
    		
    		proList.add(prods);
    	}
    	
    	updatePro.setTotal(total);
    	updatePro.setProduct(proList);
    	
    	return this.orderRepository.save(updatePro);
    }
    
    public List<OrderProduct> listAll() {
    	List<OrderProduct> listData = this.orderRepository.findAll();
    	return listData;
    }
    public OrderProduct findProById(Long id) throws Exception {
    	OrderProduct findMe = this.orderRepository.findById(id).orElseThrow(() -> new Exception());
    	return findMe;
    }
    public OrderProduct deleteData(Long id) throws Exception {
    	OrderProduct dele = this.orderRepository.findById(id).orElseThrow(() -> new Exception());
    	
    	try {
    		this.orderRepository.deleteById(dele.getId());
		} catch (Exception e) {
		   throw new Exception(e);
		}
    	return dele;
    }
}
