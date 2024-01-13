package testOrder.testProcessOrder.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import testOrder.testProcessOrder.Model.Entity.orderEntity;
import testOrder.testProcessOrder.Model.Request.orderRequest;
import testOrder.testProcessOrder.Model.Response.orderResponse;
import testOrder.testProcessOrder.Service.orderService;

@RestController
@RequestMapping("/api/test")
public class Controller {

	private final orderService serviceOrder;
    @Autowired
	public Controller(orderService serviceOrder) {
		super();
		this.serviceOrder = serviceOrder;
	}
	@PostMapping
    public ResponseEntity<orderResponse> createData(@RequestBody orderRequest reqOr){
    	orderEntity newOrder = this.serviceOrder.create(reqOr);
    	return ResponseEntity.ok(orderResponse.orderMethodResp(newOrder));
    }
    @PutMapping("/{id}")
    public ResponseEntity<orderResponse> updateData(@PathVariable Long id, @RequestBody orderRequest reqOr) throws Exception{
    	orderEntity updateOr = this.serviceOrder.updateDataCreate(id, reqOr);
    	return ResponseEntity.ok(orderResponse.orderMethodResp(updateOr));
    }
    @GetMapping
    public ResponseEntity<List<orderResponse>> listDataAll(){
    	List<orderResponse> list = this.serviceOrder.listAll().stream().map(orderResponse::orderMethodResp).toList();
    	return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<orderResponse> findOne(@PathVariable Long id) throws Exception{
    	orderEntity findMeOne = this.serviceOrder.findOne(id);
    	return ResponseEntity.ok(orderResponse.orderMethodResp(findMeOne));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<orderResponse> deleteData(@PathVariable Long id) throws Exception{
    	orderEntity dele = this.serviceOrder.delete(id);
    	return ResponseEntity.ok(orderResponse.orderMethodResp(dele));
    }
}
