package com.example.wms.wms.repositories;

import com.example.wms.wms.entities.PalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PalletRepository extends JpaRepository<PalletEntity, Long> {
}
