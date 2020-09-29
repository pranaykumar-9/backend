package com.dell.shopping.ShoppingCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dell.shopping.ShoppingCart.model.User;

@Repository
public interface UserRepository extends JpaRepository<User ,Long> {

}
