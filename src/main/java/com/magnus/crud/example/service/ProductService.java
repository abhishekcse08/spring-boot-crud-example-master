package com.magnus.crud.example.service;

import com.magnus.crud.example.entity.Product;
import com.magnus.crud.example.exception.MyCustomException;
import com.magnus.crud.example.exception.ResourceNotFoundException;
import com.magnus.crud.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProductById(int id) throws Exception {
        //return repository.findById(id).orElseThrow(null);
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("There is no data present"));
   //return  repository.findById(id).orElseThrow(()->new Exception("DSADADADAD"));
    }

    public Product getProductByName(String name) {
        return repository.findByName(name);
    }

    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    public Product updateProduct(Product product) {
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }

    public Product findByProdId(int  id) {
        Product prod = repository.findByProdId(id);

        return prod;
    }

}
