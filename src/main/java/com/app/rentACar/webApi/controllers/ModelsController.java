package com.app.rentACar.webApi.controllers;

import com.app.rentACar.business.abstracts.ModelService;
import com.app.rentACar.business.requests.CreateModelRequest;
import com.app.rentACar.business.responses.GetAllModelsRepsonse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/models")
@RestController
@AllArgsConstructor
public class ModelsController {

    private ModelService modelService;

    @GetMapping()
    public List<GetAllModelsRepsonse> getAll(){
        return modelService.getAll();
    }
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateModelRequest createModelRequest){
        this.modelService.add(createModelRequest);
    }
}
