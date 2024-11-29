package org.example.springcommerce.Controller;

import org.example.springcommerce.Model.Brand;
import org.example.springcommerce.Model.Category;
import org.example.springcommerce.Model.Product;
import org.example.springcommerce.Service.BrandService;
import org.example.springcommerce.Service.CategoryService;
import org.example.springcommerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BrandService brandService;

    @GetMapping("/products/show")
    public String getProducts(Model model,
                              @RequestParam(value = "keyword" , required = false) String keyword,
                              @RequestParam(value = "page", defaultValue = "0") int page,
                              @RequestParam(value = "size", defaultValue = "9") int size) {
        Page<Product> products;
        if (keyword != null) {
            products = productService.showProducts(keyword, PageRequest.of(page, size));
        } else {
            products = productService.showProducts(PageRequest.of(page, size));
        }
        model.addAttribute("products", products.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", products.getTotalPages());
        model.addAttribute("size", size);

        List<Category> category = categoryService.showCategory();
        List<Brand> brand = brandService.showBrands();
        model.addAttribute("category", category);
        model.addAttribute("brand", brand);
        return "shop";
    }


    @GetMapping("/products/filter")
    public String filterProducts(Model model,
                           @RequestParam(value = "category", required = false) Long categoryId,
                           @RequestParam(value = "brand", required = false) Long brandId,
                           @RequestParam(value = "minPrice", required = false) Double minPrice,
                           @RequestParam(value = "maxPrice", required = false) Double maxPrice,
                           @RequestParam(value = "color", required = false) String color,
                           @RequestParam(value = "page", defaultValue = "0") int page,
                           @RequestParam(value = "size", defaultValue = "9") int size) {

        Page<Product> products = productService.filterProducts(categoryId, brandId, minPrice, maxPrice, color, PageRequest.of(page, size));
        model.addAttribute("products", products.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", products.getTotalPages());
        model.addAttribute("size", size);

        List<Category> category = categoryService.showCategory();
        List<Brand> brand = brandService.showBrands();
        model.addAttribute("category", category);
        model.addAttribute("brand", brand);
        return "shop";
    }

    @GetMapping("/products/detail")
    public String viewProductDetail(Model model, @RequestParam("id") Long id) {
        Product product = productService.getProduct(id);
        model.addAttribute("product", product);
        return "product-detail";
    }
}
