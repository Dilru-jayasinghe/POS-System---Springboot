package com.mypossystem.my.pos.project.repo;

import com.mypossystem.my.pos.project.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ItemRepo extends JpaRepository<Item,Long> {
    List<Item> findAllByItemNameEqualsAndActiveStateEquals(String itemName, boolean b);
}
