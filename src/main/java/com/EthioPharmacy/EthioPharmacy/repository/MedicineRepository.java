package com.EthioPharmacy.EthioPharmacy.repository;

import com.EthioPharmacy.EthioPharmacy.models.Medicine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends CrudRepository<Medicine, Integer> {

}
