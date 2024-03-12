package supplier_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import supplier_service.dto.SupplierDto;
import supplier_service.entity.Supplier;
import supplier_service.repository.SupplierRepository;

import java.util.List;
import java.util.Optional;

@Service

public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    public Supplier createSupplier(SupplierDto supplierDto) {
        Supplier supplierEntity = new Supplier();
        supplierEntity.setSupplierId(supplierEntity.getSupplierId());
        supplierEntity.setCompanyName(supplierDto.getCompanyName());
        supplierEntity.setCompanyName(supplierDto.getCompanyName());
        supplierEntity.setContactName(supplierDto.getContactName());
        supplierEntity.setContactTitle(supplierDto.getContactTitle());
        supplierEntity.setAddress(supplierDto.getAddress());
        supplierEntity.setCity(supplierDto.getCity());
        supplierEntity.setRegion(supplierDto.getRegion());
        supplierEntity.setPostalCode(supplierDto.getPostalCode());
        supplierEntity.setCountry(supplierDto.getCountry());
        supplierEntity.setPhone(supplierDto.getPhone());
        supplierEntity.setFax(supplierDto.getFax());
        supplierEntity.setHomePage(supplierDto.getHomePage());
        return supplierRepository.save(supplierEntity);
    }
    public List<Supplier> getSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier updateSupplier(Long id, SupplierDto supplierDto) {
        Optional<Supplier> optionalUserEntity = supplierRepository.findById(id);
        if(optionalUserEntity.isPresent()){
            Supplier userEntity = optionalUserEntity.get();
            userEntity.setCompanyName(supplierDto.getCompanyName());
            userEntity.setCity(supplierDto.getCity());
            return supplierRepository.save(userEntity);
        }
        return null;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteById(Long supplierId) {
        supplierRepository.deleteById(supplierId);
    }
}
