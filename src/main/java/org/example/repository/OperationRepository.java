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

    @Transactional(readOnly = true)
//    @Query("select op from Operation op where op.depositorDonorId=:depositorDonorId " +
//            "and op.operationDate between :beginDate and :finishDate")
    List<Operation> findByDepositorDonorIdAndOperationDateBetween
            (long depositorDonorId, LocalDateTime beginDate, LocalDateTime finishDate);

    @Transactional(readOnly = true)
//    @Query(nativeQuery = true,
//            value = "Select * from Operation op where op.depositor_donor_id=:depositor_donor_id")
//    @Query("select op from Operation op where op.depositor_donor_id=:depositor_donor_id")
//    List<Operation> findByDepositorId (@Param(depositor_id) long depositor_id);
//        List<Operation> findByDepositorId (long depositor_donor_id);
        List<Operation> findByDepositorDonorId (long depositorDonorId);

    @Transactional(readOnly = true) Operation findById (long id);


}
