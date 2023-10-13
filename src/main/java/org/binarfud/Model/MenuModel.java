package org.binarfud.Model;

import java.util.Optional;

public class MenuModel {

    private int id;
    private String name;
    private int price;
    private int amount;

    public MenuModel(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        Optional<Integer> amountOptional = Optional.ofNullable(amount);
        return amountOptional.orElse(0);
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTotalPrice(){
        return amount * price;
    }
}


