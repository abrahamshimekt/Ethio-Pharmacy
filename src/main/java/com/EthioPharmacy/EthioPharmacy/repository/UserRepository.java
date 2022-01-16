package com.EthioPharmacy.EthioPharmacy.repository;

import com.EthioPharmacy.EthioPharmacy.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    
}
