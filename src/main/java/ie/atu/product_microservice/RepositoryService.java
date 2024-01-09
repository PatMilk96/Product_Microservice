package ie.atu.product_microservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "repository-service", url = "http://localhost:8081")
public interface RepositoryService {
    @PostMapping("/add")
    String addProduct(@RequestBody ProductDetails productDetails);

    @GetMapping("/remove/{productId}")
    String removeProduct(@PathVariable Long productId);

    @GetMapping("/find/{productId}")
    ProductDetails findProduct(@PathVariable Long productId);

    @PutMapping("/buy/{productId}/{amountWanted}")
    String updateProduct(@PathVariable Long productId, @PathVariable int amountWanted);
}
