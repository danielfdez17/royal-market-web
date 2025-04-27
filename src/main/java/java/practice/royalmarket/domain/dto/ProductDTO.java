package java.practice.royalmarket.domain.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private long id;
    private String name;
    private double price;
    private int stock;
    private boolean active;
    private long warehouseId;
}
