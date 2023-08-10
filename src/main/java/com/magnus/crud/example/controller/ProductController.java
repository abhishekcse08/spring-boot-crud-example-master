package com.magnus.crud.example.controller;

import com.magnus.crud.example.entity.Product;
import com.magnus.crud.example.exception.MyCustomException;
import com.magnus.crud.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

  //  @Value("${spring.welcome}")
   // private String name;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        if(product.getQuantity()==1){
            throw new MyCustomException("This is not correc=t data","This sis s s");
        }
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {


        return service.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts() {
       // System.out.println(name);
        return service.getProducts();
    }

   /* @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }*/

    @GetMapping("/productById/{id}")
    public ResponseEntity<Product> customQuery(@PathVariable int id) throws Exception {
        System.out.println("Hello Data");
        //Product p = service.findByProdId(id).
      return   new ResponseEntity<>(service.getProductById(id), HttpStatus.OK);
       // return service.findByProdId(id);
    }

    @GetMapping("/product/{name}")
    public Product findProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
}
