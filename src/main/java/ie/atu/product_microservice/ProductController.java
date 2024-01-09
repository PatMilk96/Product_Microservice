package ie.atu.product_microservice;
import feign.FeignException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<String> addProduct(@RequestBody @Valid ProductDetails productDetails){
        try{
            repositoryService.addProduct(productDetails);
            return ResponseEntity.ok("Product " + productDetails.getName() + " added successfully");
        } catch (FeignException.Conflict ex){
            ErrorDetails errorDetails = new ErrorDetails("Error", "A product with the same product code already exists");
            return ResponseEntity.status(HttpStatus.OK).body(errorDetails.toString());
        }
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
