package com.dell.shopping.ShoppingCart.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dell.shopping.ShoppingCart.repository.AdminRepository;
import com.dell.shopping.ShoppingCart.model.Admin;


@RestController
@RequestMapping("/shoppingcart/api")
public class AdminController {
	@Autowired
	AdminRepository adminRepo;
   
	
	
    @GetMapping("/admin")
	 public List<Admin> getAllAdmin()
	 {
		return  adminRepo.findAll();
		 
	 }
    @PostMapping("/admin")
    public Admin addAdmin(@RequestBody Admin emp)
    {
   	 return adminRepo.save(emp);
		    	 
    }
    
    @PutMapping("/admin")
    public Admin updateAdmin(@RequestBody Admin admin)
    {
   	 //Find Operation
     Optional<Admin> opAdmin =adminRepo.findById(admin.getAdminId()); 
   	 //update operation
   	 Admin 	fetchedAdmin=opAdmin.get();
   	 fetchedAdmin.setAdminName(admin.getAdminName());
   	 fetchedAdmin.setAdminPass(admin.getAdminPass());
   	 return adminRepo.save(fetchedAdmin);
   	 
    }
    
    @GetMapping("/admin/{id}")
    public Admin getOneAdmin(@PathVariable(value="id") Long adminId)
    {
   	 //Find Operation
   	 Optional<Admin> opAdmin =adminRepo.findById(adminId);  
		 return opAdmin.get();
   	 
    }
    @DeleteMapping("/admin/{id}")
    public ResponseEntity<?> deleteOneAdmin(@PathVariable(value="id") Long adminId)
    {
		 adminRepo.deleteById(adminId);
   	 return ResponseEntity.ok().build();
   	 
    }
}
