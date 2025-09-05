package com.mypossystem.my.pos.project.repo;

import com.mypossystem.my.pos.project.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories

public interface CustomerRepo extends JpaRepository<Customer,Long> {

}
