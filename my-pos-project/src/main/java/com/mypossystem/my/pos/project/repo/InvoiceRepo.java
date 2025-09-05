package com.mypossystem.my.pos.project.repo;

import com.mypossystem.my.pos.project.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface InvoiceRepo extends JpaRepository<Invoice,Long> {
}
