package java.practice.royalmarket.application.service;

import java.practice.royalmarket.domain.dto.SupplierDTO;
import java.util.List;

public interface ISupplierService {

    SupplierDTO createSupplier(SupplierDTO supplierDTO);

    SupplierDTO getSupplier(long supplierId);

    List<SupplierDTO> getAllSuppliers();

    SupplierDTO modifySupplier(SupplierDTO supplierDTO);

    void deleteSupplier(long supplierId);

}
