package java.practice.royalmarket.application.service;

import java.practice.royalmarket.domain.dto.WarehouseDTO;
import java.practice.royalmarket.domain.model.Warehouse;
import java.util.List;

public interface IWarehouseService {

    WarehouseDTO entityToDTO(Warehouse warehouse);

    WarehouseDTO createWarehouse(WarehouseDTO warehouseDTO);

    WarehouseDTO getWarehouse(long warehouseId);

    List<WarehouseDTO> getAllWarehouses();

    WarehouseDTO modifyWarehouse(WarehouseDTO warehouseDTO);

    void deleteWarehouse(long warehouseId);

}
