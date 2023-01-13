package ua.hillelit.homeworks.entity;

import java.util.List;
import java.util.stream.Collectors;

public class Cart {
    private List<Product> cartList;

    public Cart(List<Product> cartList) {
        this.cartList = cartList;
        cartList.clear();
    }

    public void printCartList() {
        System.out.println("Cart");
        cartList.stream()
                .peek(p -> System.out.println(p))
                .collect(Collectors.toList());
    }

    public List<Product> getCartList() {
        return cartList;
    }

    public void setCartList(List<Product> cartList) {
        this.cartList = cartList;
    }
}
