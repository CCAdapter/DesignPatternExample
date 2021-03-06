package memento.game;

import java.util.ArrayList;

public class Memento {
    int money;
    ArrayList<String> fruits;

    // narrow interface
    public int getMoney() {
        return money;
    }

    // wide interface
    Memento(int money) {
        this.money = money;
        this.fruits = new ArrayList<>();
    }

    // wide interface
    void addFruit(String fruit) {
        fruits.add(fruit);
    }

    // wide interface
    ArrayList<String> getFruits() {
        return (ArrayList<String>) fruits.clone();
    }
}

