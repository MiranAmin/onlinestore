package onlineshop.entities.impl;

import onlineshop.entities.Cart;
import onlineshop.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class DefaultCart implements Cart {

    List<Product> products;

    {
        products = new ArrayList<>();
    }

    @Override
    public boolean isEmpty() {
        return products.isEmpty();
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public void clear() {
        products.clear();
    }
}

