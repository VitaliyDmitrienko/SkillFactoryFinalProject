package org.example.repository;

import org.example.entity.Depositor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepositorRepository extends JpaRepository <Depositor, Long> {
}
