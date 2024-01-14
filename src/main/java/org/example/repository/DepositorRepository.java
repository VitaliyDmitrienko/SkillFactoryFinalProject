package org.example.repository;

import lombok.NoArgsConstructor;
import org.example.entity.Depositor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
//@NoArgsConstructor
public interface DepositorRepository extends JpaRepository <Depositor, Long> {
//    @Override
//    Optional<Users> findById(Long aLong);
}
