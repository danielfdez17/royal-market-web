package java.practice.royalmarket.domain.repository;

import java.practice.royalmarket.domain.model.Warehouse;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IWarehouseRepository extends JpaRepository<Warehouse, Long> {
    
}
