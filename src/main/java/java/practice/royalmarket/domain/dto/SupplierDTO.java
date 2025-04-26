package java.practice.royalmarket.domain.dto;

import lombok.Data;

@Data
public class SupplierDTO {

    private long id;
    private String name;
    private String mail;
    private boolean active;

}
