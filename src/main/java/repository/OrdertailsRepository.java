package repository;

import entity.OrderDetails;
import entity.Orders;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrdertailsRepository extends CrudRepository<OrderDetails,Integer> {
    List<OrderDetails> findByUnitPriceGreaterThan(double unitPrice);

    List<OrderDetails> findByProductNameContaining(String productName);

}
