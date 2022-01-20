package com.EthioPharmacy.EthioPharmacy.Repositories;

import org.springframework.data.repository.CrudRepository;
import com.EthioPharmacy.EthioPharmacy.models.Medicine;

public interface MedicineRepository extends CrudRepository<Medicine,String>{
    
}
