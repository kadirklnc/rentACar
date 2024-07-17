package com.app.rentACar.business.abstracts;

import com.app.rentACar.business.requests.CreateBrandRequest;
import com.app.rentACar.business.requests.UpdateBrandRequest;
import com.app.rentACar.business.responses.GetAllBrandsResponse;
import com.app.rentACar.business.responses.GetByIdBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    GetByIdBrandResponse getById(int id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);


}
