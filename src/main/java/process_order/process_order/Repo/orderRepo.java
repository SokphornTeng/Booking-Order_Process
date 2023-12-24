package process_order.process_order.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import process_order.process_order.Model.Entity.OrderProduct;

@Repository
public interface orderRepo extends JpaRepository<OrderProduct, Long> {

}
