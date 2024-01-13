package testOrder.testProcessOrder.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import testOrder.testProcessOrder.Model.Entity.orderEntity;
import testOrder.testProcessOrder.Model.Entity.productEntity;
import testOrder.testProcessOrder.Model.Request.orderRequest;
import testOrder.testProcessOrder.Model.Request.productRequest;
import testOrder.testProcessOrder.Repo.orderRepo;

@Service
public class orderService {

	private final orderRepo orderRepository;
    @Autowired
	public orderService(orderRepo orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}
	
    public orderEntity create(orderRequest req) {
    	orderEntity orEn = req.reqOrder();
    	
    	Integer total = 0;
    	ArrayList<productEntity> prod = new ArrayList<productEntity>();
    	
    	for(productRequest prodReq : req.getProduct()) {
    		total += prodReq.getPrice() * prodReq.getQty();
    		
    		productEntity prodNew = new productEntity();
    		prodNew.setProdName(prodReq.getProdName());
    		prodNew.setPrice(prodReq.getPrice());
    		prodNew.setQty(prodReq.getQty());
    		prodNew.setOrder(orEn);
    		prod.add(prodNew);
    		
    	}
    	orEn.setTotal(total);
    	orEn.setProduct(prod);
    	
    	return this.orderRepository.save(orEn);
    }
    
    public orderEntity updateDataCreate(Long id, orderRequest reqUpdate) throws Exception {
    	orderEntity updateEn = this.orderRepository.findById(id).orElseThrow(() -> new Exception());
    	
    	Integer total = 0;
    	ArrayList<productEntity> prod = new ArrayList<productEntity>();
    	for(productRequest prodReq : reqUpdate.getProduct()) {
    		total += prodReq.getPrice() * prodReq.getQty();
    		productEntity prodNew = new productEntity();
    		prodNew.setProdName(prodReq.getProdName());
    		prodNew.setPrice(prodReq.getPrice());
    		prodNew.setQty(prodReq.getQty());
    		prodNew.setOrder(updateEn);
    		prod.add(prodNew);
    	}
    	updateEn.setTotal(total);
    	updateEn.setProduct(prod);
    	updateEn.setName(reqUpdate.getName());
    	
    	 
    	return this.orderRepository.save(updateEn);
    }
	
    public List<orderEntity> listAll(){
    	List<orderEntity> listAllData = this.orderRepository.findAll();
    	return listAllData;
    }
    
    public orderEntity findOne(Long id) throws Exception {
    	orderEntity find = this.orderRepository.findById(id).orElseThrow(() -> new Exception());
    	try {
			this.orderRepository.save(find);
		} catch (Exception e) {
		   throw new Exception(e);
		}
    	return find;
    }
    public orderEntity delete(Long id) throws Exception {
    	orderEntity dele = this.orderRepository.findById(id).orElseThrow(() -> new Exception());
    	 this.orderRepository.deleteById(dele.getId());
    	 return dele;
    }
}
