package com.dell.shopping.ShoppingCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dell.shopping.ShoppingCart.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository <Admin ,Long> {

}
