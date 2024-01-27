package org.example.repository;

import org.example.entity.Depositor;
import org.example.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface DepositorRepository extends JpaRepository <Depositor, Long> {
//    @Transactional(readOnly = true) Depositor findById (long id);

}
