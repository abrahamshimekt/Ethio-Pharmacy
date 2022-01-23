package com.EthioPharmacy.EthioPharmacy.repository;

import com.EthioPharmacy.EthioPharmacy.models.CartItem;
import com.EthioPharmacy.EthioPharmacy.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.EthioPharmacy.EthioPharmacy.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Integer> {
}

