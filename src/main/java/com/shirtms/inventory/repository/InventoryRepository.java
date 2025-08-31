package com.shirtms.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shirtms.inventory.entity.InventoryItem;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryItem, Long> {

    List<InventoryItem> findByItemName(String itemName);

    List<InventoryItem> findByProductType(String productType);

    List<InventoryItem> findByItemNameAndProductType(String itemName, String productType);
}
