package org.example.springcommerce.Service;

import org.example.springcommerce.Model.Brand;
import org.example.springcommerce.Repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Brand> showBrands() {
        return brandRepository.findAll();
    }
}
