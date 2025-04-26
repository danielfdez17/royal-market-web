package java.practice.royalmarket.application.service;

import java.practice.royalmarket.domain.dto.SaleProductDTO;

public interface ISaleProductService {

    SaleProductDTO createSaleProduct(SaleProductDTO saleProductDTO);

    SaleProductDTO getSaleProductBySaleAndProduct(long saleId, long productId);

    SaleProductDTO modifySaleProduct(SaleProductDTO saleProductDTO);

    void deleteSaleProduct(long saleId, long productId);

}
