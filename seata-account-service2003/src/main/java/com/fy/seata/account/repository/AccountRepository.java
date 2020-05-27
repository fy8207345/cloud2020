package com.fy.seata.account.repository;

import com.fy.seata.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Transactional
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Modifying
    @Query("update Account s set s.used = s.used + :amount, s.residue = s.residue - :amount where s.userId = :productId")
    void updateStorage(@Param("productId") Long userId, @Param("amount") BigDecimal amount);
}
