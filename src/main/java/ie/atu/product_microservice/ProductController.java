package ie.atu.product_microservice;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final RepositoryService repositoryService;

    public ProductController(RepositoryService repositoryService){
        this.repositoryService = repositoryService;
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestBody @Valid ProductDetails productDetails){
        return repositoryService.addProduct(productDetails);
    }

    @GetMapping("/removeProduct/{productId}")
    public String removeById(@PathVariable Long productId){
        return repositoryService.removeProduct(productId);
    }

    @GetMapping("/findProduct/{productId}")
    public ResponseEntity<ProductDetails> findById(@PathVariable Long productId) {
        Optional<ProductDetails> optionalProductDetails = Optional.ofNullable(repositoryService.findProduct(productId));
        if (optionalProductDetails.isPresent()) {
            ProductDetails productDetails = optionalProductDetails.get();
            return ResponseEntity.ok(productDetails);
        } else {
            throw new RuntimeException();
        }
    }

    @PutMapping("/buy/{productId}/{amountWanted}")
    public String buyProduct(@PathVariable Long productId, @PathVariable int amountWanted){
        Optional<ProductDetails> optionalProductDetails = Optional.ofNullable(repositoryService.findProduct(productId));
        if (optionalProductDetails.isPresent()) {
            return repositoryService.updateProduct(productId, amountWanted);
        }
        else {
            return "Product not found";
        }
    }
}
