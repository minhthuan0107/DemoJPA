package repository;

import entity.Orders;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface OrdersRepository extends CrudRepository<Orders,Integer> {
    List<Orders> findByOrderDateBetween(LocalDate startOfMonth, LocalDate endOfMonth);

    Orders findById(int id);
}



