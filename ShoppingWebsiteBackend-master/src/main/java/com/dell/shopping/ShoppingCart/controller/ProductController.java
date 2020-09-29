package com.dell.shopping.ShoppingCart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dell.shopping.ShoppingCart.model.Product;
import com.dell.shopping.ShoppingCart.repository.ProductRepository;

@RestController
@RequestMapping("/shoppingcart/api")
public class ProductController {

	@Autowired
	ProductRepository prodRepo;
	
    @GetMapping("/product")
	 public List<Product> getAllProduct()
	 {
		return  prodRepo.findAll();
		 
	 }
   @PostMapping("/product")
   public Product addProduct(@RequestBody Product product)
   {
  	 return prodRepo.save(product);
		    	 
   }
   
   @PutMapping("/product")
   public Product updateUser(@RequestBody Product product)
   {
  	 //Find Operation
     Optional<Product> opProd =prodRepo.findById(product.getProductId()); 
  	 //update operation
     Product fetchedProd=opProd.get();
  	fetchedProd.setProductName(product.getProductName());
  	fetchedProd.setDateAdded(product.getDateAdded());
  	fetchedProd.setPrice(product.getPrice());
  	return prodRepo.save(fetchedProd); 
  	
   }
   
   @GetMapping("/product/{id}")
   public Product  getOneProduct(@PathVariable(value="id") Long productId)
   {
  	 //Find Operation
  	 Optional<Product> opProd =prodRepo.findById(productId);  
	 return opProd.get();
  	 
   }
   @DeleteMapping("/product/{id}")
   public ResponseEntity<?> deleteOneProduct(@PathVariable(value="id") Long productId)
   {
	   prodRepo.deleteById(productId);
  	   return ResponseEntity.ok().build();
  	 
   }
}
