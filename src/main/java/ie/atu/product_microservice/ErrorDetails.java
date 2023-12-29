package ie.atu.product_microservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
    private String errorStatus;
    private String errorMessage;
}
