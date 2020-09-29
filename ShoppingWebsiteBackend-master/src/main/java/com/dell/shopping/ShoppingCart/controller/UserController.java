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

import com.dell.shopping.ShoppingCart.model.User;
import com.dell.shopping.ShoppingCart.repository.UserRepository;



@RestController
@RequestMapping("/shoppingcart/api")
public class UserController {
	@Autowired
	UserRepository userRepo;
	
    @GetMapping("/user")
	 public List<User> getAllAdmin()
	 {
		return  userRepo.findAll();
		 
	 }
   @PostMapping("/user")
   public User addAdmin(@RequestBody User user)
   {
  	 return userRepo.save(user);
		    	 
   }
   
   @PutMapping("/user")
   public User updateUser(@RequestBody User user)
   {
  	 //Find Operation
     Optional<User> opUser =userRepo.findById(user.getID()); 
  	 //update operation
  	 User fetchedUser=opUser.get();
  	 fetchedUser.setFirstName(user.getFirstName());
  	 fetchedUser.setLastName(user.getLastName());
  	 fetchedUser.setPassword(user.getPassword());
  	 fetchedUser.setAddress(user.getAddress());
  	 fetchedUser.setEmailId(user.getEmailId());
  	 return userRepo.save(fetchedUser);
  	 
   }
   
   @GetMapping("/user/{id}")
   public User getOneAdmin(@PathVariable(value="id") Long userId)
   {
  	 //Find Operation
  	 Optional<User> opUser =userRepo.findById(userId);  
	 return opUser.get();
  	 
   }
   @DeleteMapping("/user/{id}")
   public ResponseEntity<?> deleteOneUser(@PathVariable(value="id") Long userId)
   {
	 userRepo.deleteById(userId);
  	 return ResponseEntity.ok().build();
  	 
   }
}
