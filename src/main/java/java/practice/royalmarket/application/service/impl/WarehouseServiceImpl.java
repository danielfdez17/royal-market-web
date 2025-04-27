package java.practice.royalmarket.application.service.impl;

import java.practice.royalmarket.application.service.IWarehouseService;
import java.practice.royalmarket.domain.dto.WarehouseDTO;
import java.practice.royalmarket.domain.model.Warehouse;
import java.practice.royalmarket.domain.repository.IWarehouseRepository;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements IWarehouseService {

    private final ModelMapper modelMapper;
    private final IWarehouseRepository warehouseRepository;

    @Override
    public WarehouseDTO entityToDTO(Warehouse warehouse) {
        return this.modelMapper.map(warehouse, WarehouseDTO.class);
    }

    @Override
    public WarehouseDTO createWarehouse(WarehouseDTO warehouseDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createWarehouse'");
    }

    @Override
    public WarehouseDTO getWarehouse(long warehouseId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getWarehouse'");
    }

    @Override
    public List<WarehouseDTO> getAllWarehouses() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllWarehouses'");
    }

    @Override
    public WarehouseDTO modifyWarehouse(WarehouseDTO warehouseDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modifyWarehouse'");
    }

    @Override
    public void deleteWarehouse(long warehouseId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteWarehouse'");
    }

}
