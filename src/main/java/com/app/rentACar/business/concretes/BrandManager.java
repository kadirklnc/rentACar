package com.app.rentACar.business.concretes;

import com.app.rentACar.business.abstracts.BrandService;
import com.app.rentACar.business.requests.CreateBrandRequest;
import com.app.rentACar.business.requests.UpdateBrandRequest;
import com.app.rentACar.business.responses.GetAllBrandsResponse;
import com.app.rentACar.business.responses.GetByIdBrandResponse;
import com.app.rentACar.business.rules.BrandBusinessRules;
import com.app.rentACar.core.utilities.mappers.ModelMapperService;
import com.app.rentACar.dataAccess.abstracts.BrandRepository;
import com.app.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;



    @Override
    public List<GetAllBrandsResponse> getAll() {
       List<Brand> brands = brandRepository.findAll();
       List<GetAllBrandsResponse> brandsResponses = brands.stream().map(brand -> this.modelMapperService.forResponse().map(brand,GetAllBrandsResponse.class)).collect(Collectors.toList());
        return brandsResponses;
    }


    @Override
    public void add(@NotNull CreateBrandRequest createBrandRequest) {

        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());

        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);

        this.brandRepository.save(brand);
    }
    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();

        GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand , GetByIdBrandResponse.class);
        return response;
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);

        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }

}
