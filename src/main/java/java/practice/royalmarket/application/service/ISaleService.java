package java.practice.royalmarket.application.service;

import java.practice.royalmarket.domain.dto.SaleDTO;
import java.util.List;

public interface ISaleService {

    SaleDTO createSale(SaleDTO saleDTO);

    SaleDTO getSale(long saleId);

    List<SaleDTO> getAllSales();

    SaleDTO modifySale(SaleDTO saleDTO);

    void deleteSale(long saleId);

}
