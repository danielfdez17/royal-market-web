package java.practice.royalmarket.application.service.impl;

import java.practice.royalmarket.application.service.IProductService;
import java.practice.royalmarket.domain.dto.ProductDTO;
import java.practice.royalmarket.domain.model.Product;
import java.practice.royalmarket.domain.model.Warehouse;
import java.practice.royalmarket.domain.repository.IProductRepository;
import java.practice.royalmarket.domain.repository.IWarehouseRepository;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final ModelMapper modelMapper;
    private final IProductRepository productRepository;
    private final IWarehouseRepository warehouseRepository;

    @Override
    public ProductDTO entityToDTO(Product product) {
        return this.modelMapper.map(product, ProductDTO.class);
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {

        Warehouse warehouse = warehouseRepository.findById(productDTO.getWarehouseId()).orElseThrow(
                () -> new RuntimeException(String.format("Non existent warehouse with id %d", productDTO.getWarehouseId())));

        if (!warehouse.isActive()) 
            throw new RuntimeException(String.format("Warehouse with id %d is not active", productDTO.getWarehouseId()));

        

        Product existingProduct = productRepository.findByName(productDTO.getName());

        if (existingProduct == null) {

        }

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createProduct'");
    }

    @Override
    public ProductDTO getProduct(long productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProduct'");
    }

    @Override
    public List<ProductDTO> getAllProducts(long productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllProducts'");
    }

    @Override
    public ProductDTO modifyProduct(ProductDTO productDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modifyProduct'");
    }

    @Override
    public void deleteProduct(long productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProduct'");
    }

}
