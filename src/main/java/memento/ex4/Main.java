package memento.ex4;

import memento.ex4.game.Gamer;
import memento.ex4.game.Memento;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("game.dat");
        Gamer gamer = new Gamer(100);
        if (file.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            try {
                Memento memento = (Memento) objectInputStream.readObject();
                gamer.restoreMemento(memento);
            } finally {
                objectInputStream.close();
            }
        }
        // 保存最初的状态
        Memento memento = gamer.createMemento();
        for (int i = 0; i < 20; i++) {
            System.out.println("==== " + i);
            System.out.println(" 当前状态：" + gamer);

            gamer.bet();

            System.out.println(" 所持有金钱为" + gamer.getMoney() + "元。");
            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("  （所持金钱增加了，因此保存当前的状态）");
                memento = gamer.createMemento();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
                try {
                    objectOutputStream.writeObject(memento);
                } finally {
                    objectOutputStream.close();
                }
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("   （所持金钱减少了许多，因此恢复至以前的状态）");
                gamer.restoreMemento(memento);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("");
        }
    }
}
