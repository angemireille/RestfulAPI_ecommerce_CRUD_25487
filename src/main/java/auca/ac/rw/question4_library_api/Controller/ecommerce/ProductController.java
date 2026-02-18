package auca.ac.rw.question4_library_api.Controller.ecommerce;

import auca.ac.rw.question4_library_api.Model.ecommerce.Product;
import auca.ac.rw.question4_library_api.Service.ecommerce.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int limit) {
        return ResponseEntity.ok(service.getAllProducts(page, limit));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        return service.getProductById(productId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category) {
        return ResponseEntity.ok(service.getProductsByCategory(category));
    }

    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<Product>> getProductsByBrand(@PathVariable String brand) {
        return ResponseEntity.ok(service.getProductsByBrand(brand));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword) {
        return ResponseEntity.ok(service.searchProducts(keyword));
    }

    @GetMapping("/price-range")
    public ResponseEntity<List<Product>> getProductsByPriceRange(
            @RequestParam Double min, @RequestParam Double max) {
        return ResponseEntity.ok(service.getProductsByPriceRange(min, max));
    }

    @GetMapping("/in-stock")
    public ResponseEntity<List<Product>> getInStockProducts() {
        return ResponseEntity.ok(service.getInStockProducts());
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return new ResponseEntity<>(service.addProduct(product), HttpStatus.CREATED);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long productId, @RequestBody Product product) {
        return service.updateProduct(productId, product)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{productId}/stock")
    public ResponseEntity<Product> updateStockQuantity(@PathVariable Long productId, @RequestParam int quantity) {
        return service.updateStockQuantity(productId, quantity)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        return service.deleteProduct(productId) 
                ? ResponseEntity.noContent().build() 
                : ResponseEntity.notFound().build();
    }
}