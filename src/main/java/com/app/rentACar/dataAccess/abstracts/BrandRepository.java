package com.app.rentACar.dataAccess.abstracts;

import com.app.rentACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;



public interface BrandRepository extends JpaRepository<Brand,Integer> {
    boolean existsByName(String name);


}
