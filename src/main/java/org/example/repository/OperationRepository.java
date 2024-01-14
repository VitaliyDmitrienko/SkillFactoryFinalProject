package org.example.repository;

import org.example.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository <Operation, Long> {
}
