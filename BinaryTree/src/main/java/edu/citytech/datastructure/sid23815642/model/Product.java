package edu.citytech.datastructure.sid23815642.model;

import com.jbbwebsolutions.bst.INumber;

public class Product implements Comparable<Product>, INumber {
    private String name;
    private float price;

    public Product(float price) {
        super();
        this.price = price;
    }

    public Product(String name, float price) {
        super();
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product [name=" + name + ", price=" + price + "]";
    }

    @Override
    public int compareTo(Product o) {
        return Float.compare(this.price, o.price);
    }

    @Override
    public Double getNumber() {
        return (double) this.price;
    }
}

