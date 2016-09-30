package com.lancefallon.boot.spring_boot_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lancefallon.boot.spring_boot_demo.model.Shipwreck;

public interface ShipwreckRepository extends JpaRepository<Shipwreck, Long> {

}
