package org.example.springcommerce.Repository;

import org.example.springcommerce.Model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p " +
            "where (:categoryId is null or p.category.id= :categoryId)" +
            "and (:brandId is null or p.brand.id = :brandId) " +
            "and (:minPrice is null or p.price >= :minPrice)" +
            "and (:maxPrice is null or p.price <= :maxPrice)" +
            "and (:color is null or p.color = :color)")
    Page<Product> findProductByCriteria(@Param("categoryId") Long categoryId,
                                        @Param("brandId") Long brandId,
                                        @Param("minPrice") Double minPrice,
                                        @Param("maxPrice") Double maxPrice,
                                        @Param("color") String color,
                                        Pageable pageable);

    @Query("select p from Product p where p.name like concat('%', lower(:keyword), '%')")
    Page<Product> findAll(@Param("keyword") String keyword, Pageable pageable);
}
