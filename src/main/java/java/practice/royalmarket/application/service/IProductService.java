package java.practice.royalmarket.application.service;

import java.practice.royalmarket.domain.dto.ProductDTO;
import java.util.List;

public interface IProductService {

    ProductDTO createProduct(ProductDTO productDTO);

    ProductDTO getProduct(long productId);

    List<ProductDTO> getAllProducts(long productId);

    ProductDTO modifyProduct(ProductDTO productDTO);

    void deleteProduct(long productId);
}
