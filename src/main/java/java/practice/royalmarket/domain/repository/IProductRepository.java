package java.practice.royalmarket.domain.repository;

import java.practice.royalmarket.domain.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductRepository extends JpaRepository<Product, Long> {

    @Query("""
            select p from Product p where p.name = :name
            """)
    Product findByName(@Param("name") String name);

    @Query("""
            update Product p set p.active = false where p.id = :id
            """)
    void deleteProductById(@Param("id") long id);

}
