package com.app.rentACar.business.concretes;

import com.app.rentACar.business.abstracts.ModelService;
import com.app.rentACar.business.requests.CreateModelRequest;
import com.app.rentACar.business.responses.GetAllModelsRepsonse;
import com.app.rentACar.core.utilities.mappers.ModelMapperService;
import com.app.rentACar.dataAccess.abstracts.ModelReposityory;
import com.app.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private ModelMapperService modelMapperService;
    private ModelReposityory modelRepository;
    @Override
    public List<GetAllModelsRepsonse> getAll() {
        List<Model> models = modelRepository.findAll();
        List<GetAllModelsRepsonse> modelsResponses = models.stream().map(model -> this.modelMapperService.forResponse().map(model,GetAllModelsRepsonse.class)).collect(Collectors.toList());
        return modelsResponses;


    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = this.modelMapperService.forRequest().map(createModelRequest,Model.class);

        this.modelRepository.save(model);
    }
}
