package com.peaga.webservice.config;

import com.peaga.webservice.entities.*;
import com.peaga.webservice.enums.OrderStatus;
import com.peaga.webservice.repositories.CategoryRepository;
import com.peaga.webservice.repositories.OrderRepository;
import com.peaga.webservice.repositories.ProductRepository;
import com.peaga.webservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User user2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "");
        userRepository.saveAll(List.of(user1,user2));
        //padrao MMM d yyyy hh:mm a z
        Order o1 = new Order(null,Instant.parse("2019-06-20T19:53:07Z"),user1, OrderStatus.PAID);
        Order o2 = new Order(null,Instant.parse("2019-07-21T03:42:10Z"),user2,OrderStatus.PAID);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), user1,OrderStatus.SHIPPED);
        orderRepository.saveAll(List.of(o1,o2,o3));

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");
        categoryRepository.saveAll(List.of(cat1,cat2,cat3));

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        productRepository.saveAll(List.of(p1,p2,p3,p4,p5));
    }
}
