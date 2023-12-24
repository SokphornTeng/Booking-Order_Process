package process_order.process_order.order_Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import process_order.process_order.Model.Entity.OrderProduct;
import process_order.process_order.Model.Request.orderRequest;
import process_order.process_order.Model.Response.orderResponse;
import process_order.process_order.Service.proService;

@RestController
@RequestMapping("/api/product")
public class OrderController {

	private proService productService;
    @Autowired
	public OrderController(proService productService) {
		super();
		this.productService = productService;
	}
    
    @PostMapping
    public ResponseEntity<orderResponse> create(@RequestBody orderRequest orReq){
    	OrderProduct orderP = this.productService.addData(orReq);
    	return ResponseEntity.ok(orderResponse.orderBack(orderP));
    }
    @PutMapping("/{id}")
    public ResponseEntity<orderResponse> update(@PathVariable Long id, @RequestBody orderRequest orReq){
    	OrderProduct updateP = this.productService.updateData(id, orReq);
    	return ResponseEntity.ok(orderResponse.orderBack(updateP));
    }
	
    @GetMapping
    public ResponseEntity<List<orderResponse>> listAllData(){
    	List<orderResponse> listMe = this.productService.listAll().stream().map(orderResponse::orderBack).toList();
    	return ResponseEntity.ok(listMe);
    }
    @GetMapping("/{id}")
    public ResponseEntity<orderResponse> findById(@PathVariable Long id) throws Exception{
    	OrderProduct findWithId = this.productService.findProById(id);
    	return ResponseEntity.ok(orderResponse.orderBack(findWithId));
    }
}
