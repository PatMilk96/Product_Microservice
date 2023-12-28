package ie.atu.product_microservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    private RepositoryService repositoryService;
    @Autowired
    public ProductController(RepositoryService repositoryService){
        this.repositoryService = repositoryService;
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestBody ProductDetails productDetails){
        String response = repositoryService.addProduct(productDetails);
        return response;
    }
}
