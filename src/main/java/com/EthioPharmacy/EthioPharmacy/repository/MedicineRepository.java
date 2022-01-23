package com.EthioPharmacy.EthioPharmacy.repository;

import com.EthioPharmacy.EthioPharmacy.models.Medicine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MedicineRepository extends CrudRepository<Medicine, Integer> {

}
