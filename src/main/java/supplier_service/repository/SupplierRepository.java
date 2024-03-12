package supplier_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import supplier_service.entity.Supplier;

import java.util.Optional;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long >{
   /* @Override
    Optional<Supplier> findById(Long supplierId);

    @Override
    void deleteById(Long supplierId);
*/

}
