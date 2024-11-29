package org.example.springcommerce;

import org.example.springcommerce.Model.*;
import org.example.springcommerce.Repository.*;
import org.example.springcommerce.Service.ProductServiceImpl;
import org.example.springcommerce.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCommerceApplication implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ShoppingCartRepository shoppingCartRepository;
    @Autowired
    BrandRepository brandRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    private ProductServiceImpl productServiceImpl;
    @Autowired
    private UserServiceImpl userService;

    public static void main(String[] args) {
        SpringApplication.run(SpringCommerceApplication.class, args);
    }

    public void run(String... args) throws Exception {
        User user1 = new User("canh", "canh123", "canh123", "customer", "0123456789", "Gia kiệm, Thống Nhất, Đồng Nai");
        User user2 = new User("vu", "vu123", "vu123", "manager", "0101010102", "Dầu Giây, Thống Nhất, Đồng Nai");

        ShoppingCart cart1 = new ShoppingCart(user1);
        ShoppingCart cart2 = new ShoppingCart(user2);

        Brand brand1 = new Brand("Nike");
        Brand brand2 = new Brand("Adidas");
        Brand brand3 = new Brand("Uniqlo");
        Brand brand4 = new Brand("H&M");
        Brand brand5 = new Brand("Levi's");
        Brand brand6 = new Brand("Zara");
        Brand brand7 = new Brand("Puma");
        Brand brand8 = new Brand("Ray-Ban");
        Brand brand9 = new Brand("Fossil");

        Category category1 = new Category("T-Shirt");
        Category category2 = new Category("Pants");
        Category category3 = new Category("Dress");
        Category category4 = new Category("Shoes");
        Category category5 = new Category("Accessories");

        Product product1 = new Product("Basic T-Shirt", 15.99, brand1, "White", 50, "/img/product/Tshirt-1.webp", category1, 1.3, "M", "A classic white T-shirt made from 100% cotton, offering unmatched comfort and style. Perfect for everyday wear or layering with your favorite outfits.");
        Product product2 = new Product("Graphic T-Shirt", 20.99, brand2, "Black", 60, "/img/product/Tshirt-2.jpg", category1, 1.4, "L", "A trendy graphic T-shirt featuring bold and vibrant designs. Crafted from premium fabric for durability and all-day comfort.");
        Product product3 = new Product("V-Neck T-Shirt", 12.99, brand3, "Blue", 40, "/img/product/Tshirt-3.jpg", category1, 1.2, "S", "A lightweight and breathable V-neck T-shirt in a stunning blue shade. Ideal for casual outings or lounging at home.");
        Product product4 = new Product("Plain T-Shirt", 10.99, brand4, "Gray", 80, "/img/product/Tshirt-5.jpg", category1, 1.1, "XL", "A simple and versatile plain T-shirt in neutral gray. Pairs well with any wardrobe staple for a clean and casual look.");
        Product product5 = new Product("Round Neck T-Shirt", 14.99, brand5, "Red", 20, "/img/product/Tshirt-4.png", category1, 1.3, "M", "Stylish round-neck T-shirt with a sleek fit, designed to provide maximum comfort while showcasing a bold red hue.");

        Product product6 = new Product("Slim Fit Pants", 25.99, brand5, "Blue", 40, "/img/product/Pants-1.webp", category2, 2.0, "L", "Modern slim-fit pants tailored for a sharp and refined look. Made with a blend of cotton and stretchable fabric for comfort and style.");
        Product product7 = new Product("Chinos", 30.99, brand3, "Black", 50, "/img/product/Pants-2.jpg", category2, 2.2, "M", "Timeless chinos in classic black, perfect for both casual and formal settings. Features a tailored fit with durable material.");
        Product product8 = new Product("Cotton Pants", 22.99, brand6, "Gray", 30, "/img/product/Pants-3.webp", category2, 2.1, "XL", "Soft and breathable cotton pants in a versatile gray tone. Designed for all-day comfort with a relaxed fit.");
        Product product9 = new Product("Cargo Pants", 28.99, brand7, "Green", 25, "/img/product/Pants-4.webp", category2, 2.5, "S", "Utility cargo pants with multiple pockets for practicality. Crafted with durable material, suitable for outdoor activities.");
        Product product10 = new Product("Jogger Pants", 20.99, brand1, "Gray", 60, "/img/product/Pants-5.jpg", category2, 2.3, "L", "Comfortable jogger pants with elastic waist and cuffs. Made for active lifestyles or casual lounging.");

        Product product11 = new Product("Evening Dress", 50.99, brand6, "Red", 20, "/img/product/Dress-1.jpg", category3, 1.8, "M", "Elegant evening dress in a vibrant red. Features intricate detailing and a flattering silhouette, ideal for special occasions.");
        Product product12 = new Product("Maxi Dress", 45.99, brand4, "Blue", 30, "/img/product/Dress-2.jpg", category3, 2.0, "L", "A flowing maxi dress with a classy design, made with lightweight fabric for ultimate comfort and elegance.");
        Product product13 = new Product("Cocktail Dress", 55.99, brand3, "Black", 25, "/img/product/Dress-3.webp", category3, 1.7, "S", "A chic cocktail dress with a modern cut. Perfect for parties and formal events, this dress combines style and sophistication.");
        Product product14 = new Product("Casual Dress", 38.99, brand2, "Yellow", 40, "/img/product/Dress-4.jpg", category3, 1.5, "M", "A cheerful casual dress in bright yellow, designed for comfort and ease of movement. Great for day outings.");
        Product product15 = new Product("Bodycon Dress", 42.99, brand1, "Black", 30, "/img/product/Dress-5.webp", category3, 1.6, "XL", "A sleek bodycon dress with a flattering fit, crafted to accentuate your figure. Suitable for both casual and formal settings.");

        Product product16 = new Product("Running Shoes", 70.99, brand1, "White", 40, "/img/product/Shoes-1.jpg", category4, 1.4, "L", "High-performance running shoes designed for athletes. Features lightweight material and a durable sole for maximum support.");
        Product product17 = new Product("Sneakers", 65.99, brand2, "Black", 50, "/img/product/Shoes-2.webp", category4, 1.5, "M", "Trendy black sneakers that combine comfort and style. Perfect for casual wear or light activities.");
        Product product18 = new Product("Loafers", 55.99, brand6, "Brown", 30, "/img/product/Shoes-3.webp", category4, 1.6, "S", "Classic loafers made from high-quality material. Offers a sophisticated look suitable for formal or semi-formal occasions.");
        Product product19 = new Product("Formal Shoes", 80.99, brand7, "Black", 25, "/img/product/Shoes-4.webp", category4, 1.8, "XL", "Polished formal shoes with a sleek design, perfect for business meetings or events. Crafted for elegance and durability.");
        Product product20 = new Product("Casual Shoes", 60.99, brand4, "Blue", 20, "/img/product/Shoes-5.webp", category4, 1.7, "M", "Comfortable casual shoes with a stylish blue finish. Great for everyday use.");

        Product product21 = new Product("Baseball Cap", 15.99, brand1, "Black", 60, "/img/product/Accessories-1.webp", category5, 0.5, "M", "A sporty baseball cap with an adjustable strap. Perfect for outdoor activities or casual wear.");
        Product product22 = new Product("Leather Belt", 25.99, brand5, "Brown", 50, "/img/product/Accessories-2.jpg", category5, 0.8, "L", "High-quality leather belt with a classic buckle. A versatile accessory for both casual and formal outfits.");
        Product product23 = new Product("Sunglasses", 30.99, brand8, "Black", 40, "/img/product/Accessories-3.jpg", category5, 0.4, "S", "Sleek and modern sunglasses designed to protect your eyes. Features UV protection and a stylish frame.");
        Product product24 = new Product("Wristwatch", 120.99, brand9, "Black", 25, "/img/product/Accessories-4.jpg", category5, 1.0, "M", "Luxury wristwatch crafted with precision. Offers a timeless design and high durability.");
        Product product25 = new Product("Scarf", 18.99, brand6, "Red", 35, "/img/product/Accessories-5.jpg", category5, 0.3, "L", "Soft and cozy scarf in a bold red color. Perfect for staying warm while adding a stylish touch.");


        userService.saveUser(user1);
        userService.saveUser(user2);

        brandRepository.save(brand1);
        brandRepository.save(brand2);
        brandRepository.save(brand3);
        brandRepository.save(brand4);
        brandRepository.save(brand5);
        brandRepository.save(brand6);
        brandRepository.save(brand7);
        brandRepository.save(brand8);
        brandRepository.save(brand9);

        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);
        categoryRepository.save(category4);
        categoryRepository.save(category5);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
        productRepository.save(product5);
        productRepository.save(product6);
        productRepository.save(product7);
        productRepository.save(product8);
        productRepository.save(product9);
        productRepository.save(product10);
        productRepository.save(product11);
        productRepository.save(product12);
        productRepository.save(product13);
        productRepository.save(product14);
        productRepository.save(product15);
        productRepository.save(product16);
        productRepository.save(product17);
        productRepository.save(product18);
        productRepository.save(product19);
        productRepository.save(product20);
        productRepository.save(product21);
        productRepository.save(product22);
        productRepository.save(product23);
        productRepository.save(product24);
        productRepository.save(product25);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
        productRepository.save(product5);
        productRepository.save(product6);
        productRepository.save(product7);
        productRepository.save(product8);
        productRepository.save(product9);
        productRepository.save(product10);
        productRepository.save(product11);
        productRepository.save(product12);
        productRepository.save(product13);
        productRepository.save(product14);
        productRepository.save(product15);
        productRepository.save(product16);
        productRepository.save(product17);
        productRepository.save(product18);
        productRepository.save(product19);
        productRepository.save(product20);
        productRepository.save(product21);
        productRepository.save(product22);
        productRepository.save(product23);
        productRepository.save(product24);
        productRepository.save(product25);

    }
}
