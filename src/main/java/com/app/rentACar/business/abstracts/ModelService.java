package com.app.rentACar.business.abstracts;

import com.app.rentACar.business.requests.CreateModelRequest;
import com.app.rentACar.business.responses.GetAllBrandsResponse;
import com.app.rentACar.business.responses.GetAllModelsRepsonse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsRepsonse> getAll();
    void add(CreateModelRequest createModelRequest);
}
