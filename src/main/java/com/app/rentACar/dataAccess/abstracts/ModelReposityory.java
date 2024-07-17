package com.app.rentACar.dataAccess.abstracts;

import com.app.rentACar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ModelReposityory extends JpaRepository<Model,Integer> {



}
