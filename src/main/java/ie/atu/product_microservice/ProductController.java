package ie.atu.product_microservice;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

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
}
