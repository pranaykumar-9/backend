package com.dell.shopping.ShoppingCart.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.Table;

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

import com.dell.shopping.ShoppingCart.repository.ProductGroupRepository;
import com.dell.shopping.ShoppingCart.model.Admin;
import com.dell.shopping.ShoppingCart.model.ProductGroup;

@RestController
@RequestMapping("/shoppingcart/api")
public class ProductGroupController {
    @Autowired
	ProductGroupRepository prodRepo;
    
    @GetMapping("/productgroup")
    public List<ProductGroup> getAllProductGroup()
    {
		return prodRepo.findAll();
    	
    }
    @PostMapping("/productgroup")
    public ProductGroup addProductGroup(@RequestBody ProductGroup pg)
    {
   	 return prodRepo.save(pg);
		    	 
    }
    @PutMapping("/productgroup")
    public ProductGroup updateAdmin(@RequestBody ProductGroup pg)
    {
   	 //Find Operation
     Optional<ProductGroup> opProdGrp =prodRepo.findById(pg.getProductgroupId()); 
   	 //update operation
     ProductGroup 	fetchedProdGrp=opProdGrp.get();
     fetchedProdGrp.setProductgroupName(pg.getProductgroupName());
   	 return prodRepo.save(fetchedProdGrp);
   	 
    }
    
    @GetMapping("/productgroup/{id}")
    public ProductGroup getOneProductGroup(@PathVariable(value="id") Long adminId)
    {
   	 //Find Operation
   	 Optional<ProductGroup> opProdGrp =prodRepo.findById(adminId);  
		 return opProdGrp.get();
   	 
    }
    
    @DeleteMapping("/productgroup/{id}")
    public ResponseEntity<?> deleteOneProductGroup(@PathVariable(value="id") Long pgId)
    {
    	prodRepo.deleteById(pgId);
   	    return ResponseEntity.ok().build();
   	 
    }
}
