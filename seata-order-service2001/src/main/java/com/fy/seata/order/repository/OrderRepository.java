package com.fy.seata.order.repository;

import com.fy.seata.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Modifying
    @Query("update Order o set o.status = :status where o.userId = :userId")
    void updateStaus(@Param("userId") Long userId, @Param("status") Integer status);
}
