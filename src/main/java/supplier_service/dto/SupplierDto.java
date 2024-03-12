package supplier_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SupplierDto {
    @NotBlank(message = "company name should not be null or empty")
    private String companyName;
    @NotBlank(message = "contact name should not be null or empty")
    private String contactName;
    @NotBlank(message = "contact title should not be null or empty")
    private String contactTitle;
    @NotBlank(message = "address should not be null or empty")
    private String address;
    @NotBlank(message = "city should not be null or empty")
    private String city;
    @NotBlank(message = "region should not be null or empty")
    private String region;
    @NotBlank(message = "postal code should not be null or empty")
    private String postalCode;
    @NotBlank(message = "country name should not be null or empty")
    private String country;
    @NotBlank(message = "phone should not be null or empty")
    private String phone;
    @NotNull(message = "fax no should not be null")
    private String fax;
    private String homePage;
}
