package ie.atu.product_microservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "Repository-Service", url = "http://localhost:8081")
public interface RepositoryService {
    @PostMapping("/add")
    String addProduct(@RequestBody ProductDetails productDetails);

    @GetMapping("/remove/{productId}")
    String removeProduct(@PathVariable Long productId);

    @GetMapping("/find/{productId}")
    String findProduct(@PathVariable Long productId);
}
