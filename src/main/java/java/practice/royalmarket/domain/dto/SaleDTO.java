package java.practice.royalmarket.domain.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SaleDTO {

    private long id;
    private double total;
    private LocalDateTime creationDateTime;
    private boolean active;

}
