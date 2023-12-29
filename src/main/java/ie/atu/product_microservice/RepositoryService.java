package ie.atu.product_microservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "Repository-Service", url = "http://Repository-Service:8081")
public interface RepositoryService {
    @PostMapping("/add")
    String addProduct(@RequestBody ProductDetails productDetails);
}
