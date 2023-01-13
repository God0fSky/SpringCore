package ua.hillelit.homeworks.entity;

import java.util.List;
import java.util.stream.Collectors;

public class ProductRepository {
    private List<Product> productList;

    public ProductRepository(List<Product> productList) {
        this.productList = productList;
    }

    public void printAllProducts() {
        System.out.println("Available products");
        productList.stream()
                .peek(p -> System.out.println(p))
                .collect(Collectors.toList());
    }

    public void printProductById(int id) {
        System.out.println("Selected product");
        productList.stream()
                .filter(p -> (p.getId() == id))
                .peek(p -> System.out.println(p))
                .collect(Collectors.toList());
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
