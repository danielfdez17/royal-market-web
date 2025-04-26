package java.practice.royalmarket.application.service;

import java.practice.royalmarket.domain.dto.ProductDTO;
import java.practice.royalmarket.domain.model.Product;
import java.util.List;

public interface IProductService {

    ProductDTO entityToDTO(Product product);
    
    ProductDTO createProduct(ProductDTO productDTO);

    ProductDTO getProduct(long productId);

    List<ProductDTO> getAllProducts(long productId);

    ProductDTO modifyProduct(ProductDTO productDTO);

    void deleteProduct(long productId);
}
