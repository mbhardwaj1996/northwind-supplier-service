package supplier_service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomResponseModel<T> {
    private MetaData metaData;
    private ResourceData<T> resourceData;
}
