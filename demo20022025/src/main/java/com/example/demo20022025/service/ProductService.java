package com.example.demo20022025.service;

import com.example.demo20022025.model.Product;
import com.example.demo20022025.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Page<Product> findAllProducts(int page, int size){
        return productRepository.findAll(PageRequest.of(page, size));
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public Product findProductById(Long id){
        return productRepository.findById(id).orElse(null);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    public void deleteAllProducts(){
        productRepository.deleteAll();
    }

    public List<Product> searchProducts(String name, Long price, Long categoryId){
        if(name != null && price != null && categoryId != null){
            return productRepository.findByNameContainingAndPriceAndCategoryId(name, price, categoryId);
        }
        if(name != null){
            return productRepository.findByNameContaining(name);
        }
        if(price != null){
            return productRepository.findByPrice(price);
        }
        if(categoryId != null){
            return productRepository.findByCategoryId(categoryId);
        }
        return null;
    }
}
