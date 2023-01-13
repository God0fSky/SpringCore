package ua.hillelit.homeworks.api;

import ua.hillelit.homeworks.entity.Cart;
import ua.hillelit.homeworks.entity.Product;
import ua.hillelit.homeworks.entity.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CartService {
    private Cart cart;
    private ProductRepository productRepository;

    public CartService(Cart cart, ProductRepository productRepository) {
        this.cart = cart;
        this.productRepository = productRepository;
    }

    public Cart addProductById(ProductRepository productRepository, Cart cart, Integer id) {
        if(productRepository == null || cart == null || id == null) {
            System.out.println("Class CartService, method addProductById, nullPointerException");
            return cart;
        }
        for (Product product : productRepository.getProductList()) {
            if(id.equals(product.getId())) {
                cart.getCartList().add(product);
            }
        }
        return cart;
    }

    public Cart removeProductById(ProductRepository productRepository, Cart cart, Integer id) {
        if(productRepository == null || cart == null || id == null) {
            System.out.println("Class CartService, method removeProductById, nullPointerException");
            return null;
        }
        for (Product product : productRepository.getProductList()) {
            if(id.equals(product.getId())) {
                cart.getCartList().remove(product);
            }
        }
        return cart;
    }
}
