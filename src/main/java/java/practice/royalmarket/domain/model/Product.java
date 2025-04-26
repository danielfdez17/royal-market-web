package java.practice.royalmarket.domain.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    private double price;
    
    private int stock;

    @Column(columnDefinition = "boolean default true")
    private boolean active;

    @ManyToOne(fetch = FetchType.EAGER)
    private Warehouse warehouses;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    private Set<SaleProduct> saleProducts;

    @ManyToMany(mappedBy = "products", fetch = FetchType.EAGER)
    private Set<Supplier> suppliers;
}
