package com.EthioPharmacy.EthioPharmacy.models.data;

import com.EthioPharmacy.EthioPharmacy.models.Medicine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

// this interface will allow us to interact with the database
// we will tell it will store Medicine objects or the class of our entity
// the keys of this objects are integers
// @Repository annotation will tell spring this interface is a repository

@Repository
@Transactional
public interface MedicineRepository extends CrudRepository<Medicine, Integer> {

}
