package org.example.springcommerce.Repository;

import org.example.springcommerce.Model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
