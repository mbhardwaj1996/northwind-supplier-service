package supplier_service.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import supplier_service.dto.SupplierDto;
import supplier_service.entity.Supplier;
import supplier_service.model.CustomResponseModel;
import supplier_service.model.MetaData;
import supplier_service.model.ResourceData;
import supplier_service.service.SupplierService;

import java.util.List;

@RestController
@RequestMapping(value = "/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;
    @PostMapping(value = "/create")
    public ResponseEntity<CustomResponseModel> createSupplier(@RequestBody SupplierDto supplierDto){
        Supplier supplierEntity = supplierService.createSupplier(supplierDto);
        MetaData metaData = MetaData.builder().code("200").status("Success").message("user created").version("1.0").build();
        ResourceData resourceData = ResourceData.builder().data(supplierEntity).build();
        CustomResponseModel customResponseModel = CustomResponseModel.builder().metaData(metaData).resourceData(resourceData).build();
        return new ResponseEntity<>(customResponseModel, HttpStatus.CREATED);
    }
    @GetMapping(value = "/all")
    public ResponseEntity<CustomResponseModel> getSuppliers(){
        List<Supplier> supplierEntity = supplierService.getSuppliers();
        MetaData metaData = MetaData.builder().code("500").status("get users").message("getting users successfully").version("1.0").build();
        ResourceData resourceData = ResourceData.builder().data(supplierEntity).build();
        CustomResponseModel customResponseModel = CustomResponseModel.builder().metaData(metaData).resourceData(resourceData).build();

        return new ResponseEntity<>(customResponseModel,HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<CustomResponseModel> updateSupplier(@PathVariable(name = "id") Long id, @RequestBody @Valid SupplierDto supplierDto){
        Supplier supplierEntity = supplierService.updateSupplier(id, supplierDto);
        MetaData metaData = MetaData.builder().code("400").status("update user successfully").message("update user by company name").version("1.0").build();
        ResourceData<Object> resourceData = ResourceData.builder().data(supplierEntity).build();
        CustomResponseModel customResponseModel = CustomResponseModel.builder().metaData(metaData).resourceData(resourceData).build();
        return new ResponseEntity<>(customResponseModel, HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping(value = "/deleteByid/{id}")
    public ResponseEntity<CustomResponseModel> deleteById(@PathVariable(name = "id") Long supplierId) {
        supplierService.deleteById(supplierId);
        MetaData metaDate = MetaData.builder().code("200").status("Success").message("Deleted Successfully").version("1.0").build();
        CustomResponseModel customResponseModel = CustomResponseModel.builder().metaData(metaDate).build();
        return new ResponseEntity<>(customResponseModel, HttpStatus.OK);
    }
}
