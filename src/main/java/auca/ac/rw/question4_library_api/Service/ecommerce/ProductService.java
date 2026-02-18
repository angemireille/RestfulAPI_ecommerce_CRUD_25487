package auca.ac.rw.question4_library_api.Service.ecommerce;

import auca.ac.rw.question4_library_api.Model.ecommerce.Product;
import auca.ac.rw.question4_library_api.Repository.ecommerce.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts(int page, int limit) {
        return repository.findAll(PageRequest.of(page - 1, limit)).getContent();
    }

    public Optional<Product> getProductById(Long id) {
        return repository.findById(id);
    }

    public List<Product> getProductsByCategory(String category) {
        return repository.findByCategory(category);
    }

    public List<Product> getProductsByBrand(String brand) {
        return repository.findByBrand(brand);
    }

    public List<Product> searchProducts(String keyword) {
        return repository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(keyword, keyword);
    }

    public List<Product> getProductsByPriceRange(Double min, Double max) {
        return repository.findByPriceBetween(min, max);
    }

    public List<Product> getInStockProducts() {
        return repository.findByStockQuantityGreaterThan(0);
    }

    public Product addProduct(Product product) {
        return repository.save(product);
    }

    public Optional<Product> updateProduct(Long id, Product updatedProduct) {
        return repository.findById(id).map(p -> {
            p.setName(updatedProduct.getName());
            p.setDescription(updatedProduct.getDescription());
            p.setPrice(updatedProduct.getPrice());
            p.setCategory(updatedProduct.getCategory());
            p.setStockQuantity(updatedProduct.getStockQuantity());
            p.setBrand(updatedProduct.getBrand());
            return repository.save(p);
        });
    }

    public Optional<Product> updateStockQuantity(Long id, int quantity) {
        return repository.findById(id).map(p -> {
            p.setStockQuantity(quantity);
            return repository.save(p);
        });
    }

    public boolean deleteProduct(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
