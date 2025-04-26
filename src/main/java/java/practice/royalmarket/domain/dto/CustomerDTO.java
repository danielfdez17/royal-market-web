package java.practice.royalmarket.domain.dto;

import lombok.Data;

@Data
public class CustomerDTO {

    private long id;
    private int phoneNumber;
    private String name;
    private String address;
    private boolean active;

}
