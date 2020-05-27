package com.fy.seata.storage.repository;

import com.fy.seata.storage.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface StorageRepository extends JpaRepository<Storage, Long> {

    @Modifying
    @Query("update Storage s set s.userd = s.userd + :amount, s.residue = s.residue - :amount where s.productId = :productId")
    void updateStorage(@Param("productId") Long productId, @Param("amount") Integer amount);
}
