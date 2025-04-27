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

import jakarta.transaction.Transactional;
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
    @Transactional
    public ProductDTO createProduct(ProductDTO productDTO) {

        Warehouse warehouse = warehouseRepository.findById(productDTO.getWarehouseId()).orElseThrow(
                () -> new RuntimeException(
                        String.format("Non existent warehouse with id %d", productDTO.getWarehouseId())));

        if (!warehouse.isActive())
            throw new RuntimeException(
                    String.format("Warehouse with id %d is not active", productDTO.getWarehouseId()));

        Product existingProduct = productRepository.findByName(productDTO.getName());

        if (existingProduct == null) {

            Product product = Product.builder()
                    .name(productDTO.getName())
                    .price(productDTO.getPrice())
                    .stock(productDTO.getStock())
                    .warehouse(warehouse)
                    .active(true)
                    .build();

            return this.entityToDTO(this.productRepository.save(product));
        }

        existingProduct.setName(productDTO.getName());
        existingProduct.setPrice(productDTO.getPrice());
        existingProduct.setStock(productDTO.getStock());
        existingProduct.setWarehouse(warehouse);
        existingProduct.setActive(true);

        return this.entityToDTO(existingProduct);
    }

    @Override
    public ProductDTO getProduct(long productId) {
        return this.entityToDTO(this.productRepository.findById(productId).orElse(null));
    }

    @Override
    public List<ProductDTO> getAllProducts(long productId) {
        return this.productRepository.findAll().stream().map(this::entityToDTO).toList();
    }

    @Override
    @Transactional
    public ProductDTO modifyProduct(ProductDTO productDTO) {

        Warehouse warehouse = warehouseRepository.findById(productDTO.getWarehouseId()).orElseThrow(
                () -> new RuntimeException(
                        String.format("Non existent warehouse with id %d", productDTO.getWarehouseId())));

        if (!warehouse.isActive())
            throw new RuntimeException(
                    String.format("Warehouse with id %d is not active", productDTO.getWarehouseId()));

        Product existingProduct = productRepository.findById(productDTO.getId()).orElseThrow(
                () -> new RuntimeException(String.format("Non existent product with id %d", productDTO.getId())));

        existingProduct.setName(productDTO.getName());
        existingProduct.setPrice(productDTO.getPrice());
        existingProduct.setStock(productDTO.getStock());
        existingProduct.setWarehouse(warehouse);
        existingProduct.setActive(true);

        return this.entityToDTO(existingProduct);

    }

    @Override
    public void deleteProduct(long productId) {
        this.productRepository.deleteProductById(productId);
    }

}
