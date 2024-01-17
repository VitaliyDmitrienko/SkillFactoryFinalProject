package org.example.repository;

import org.example.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface OperationRepository extends JpaRepository <Operation, Long> {

//    @Transactional(readOnly = true)
//    @Query("select op from Operation op where op.depositor_id")
//    List<Operation> findByDepositorIdAndBetweenDates
//            (long depositor_id, LocalDateTime begin_date, LocalDateTime finish_date);

    @Transactional(readOnly = true)
    @Query(nativeQuery = true,
            value = "Select * from Operation op where op.depositor_id=:depositor_id")
//    @Query("select op from Operation op where op.depositor_id=:depositor_id")
//    List<Operation> findByDepositorId (@Param(depositor_id) long depositor_id);
    List<Operation> findByDepositorId (long depositor_id);

}
