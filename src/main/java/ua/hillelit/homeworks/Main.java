package ua.hillelit.homeworks;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import ua.hillelit.homeworks.api.CartService;
import ua.hillelit.homeworks.entity.Cart;
import ua.hillelit.homeworks.entity.ProductRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String configPath = "src/main/resources/ApplicationContext.xml";
        ApplicationContext context = new FileSystemXmlApplicationContext(configPath);
        ProductRepository productRepository = context.getBean("productRepository", ProductRepository.class);
        CartService cartService = context.getBean("cartService", CartService.class);
        showRepository(context);
        Cart cart = createCart(context);
        buyStage(cart, productRepository, cartService, context);


    }

    public static boolean buyStage(Cart cart, ProductRepository productRepository,
                                CartService cartService, ApplicationContext context) {
        Scanner scanner = new Scanner(System.in);
        int answer;
        System.out.println("Enter 1 to add product or 2 to remove product");
        answer = scanner.nextInt();
        if (answer == 1) {
            int id;
            System.out.println("Enter id of product");
            id = scanner.nextInt();
            addProductToCart(cart, productRepository, cartService, id);
        }
        if (answer == 2) {
            int id;
            System.out.println("Enter id of product");
            id = scanner.nextInt();
            removeProductFromCart(cart, productRepository, cartService, id);
        }
        showCart(cart);
        System.out.println("Enter 1 to finish, 2 to resume or 3 to create new cart");
        answer = scanner.nextInt();
        if (answer == 1) {
            return true;
        }
        if (answer == 2) {
            buyStage(cart, productRepository, cartService, context);
        }
        if (answer == 3) {
            Cart newCart = createCart(context);
            buyStage(newCart, productRepository, cartService, context);
        }
        return true;
    }

    public static void showRepository(ApplicationContext context) {
        ProductRepository productRepository =
                context.getBean("productRepository", ProductRepository.class);
        productRepository.printAllProducts();
    }

    public static Cart createCart(ApplicationContext context) {
        Cart cart = context.getBean("cart", Cart.class);
        return cart;
    }

    public static void showCart(Cart cart) {
        cart.printCartList();
    }

    public static void addProductToCart(Cart cart, ProductRepository productRepository,
                                        CartService cartService, Integer id) {
        cartService.addProductById(productRepository, cart, id);
    }

    public static void removeProductFromCart(Cart cart, ProductRepository productRepository,
                                             CartService cartService, Integer id) {
        cartService.removeProductById(productRepository, cart, id);
    }
}
