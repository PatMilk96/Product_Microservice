package ie.atu.product_microservice;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product name cannot be blank")
    private String name;

    @NotNull(message = "price cannot be empty")
    @Min(1)
    private Double price;

    @NotNull(message = "Product Code cannot be empty")
    private Long productCode;

    @NotNull(message = "Product amount cannot be empty")
    @Min(0)
    private Integer amount;
}
