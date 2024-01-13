package testOrder.testProcessOrder.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import testOrder.testProcessOrder.Model.Entity.orderEntity;

@Repository
public interface orderRepo extends JpaRepository<orderEntity, Long> {

}
