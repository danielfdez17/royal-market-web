package java.practice.royalmarket.domain.dto;

import lombok.Data;

@Data
public class SaleProductDTO {

    private long saleId;
    private long productId;
    private int productQuantity;
    private double productPrice;
    private boolean active;

}
