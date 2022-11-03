package ru.romanov.MyCopyOnWriteArrayList;


import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class МногопоточноеДемо {

    public static void main(String[] args) throws InterruptedException {
        MyCopyOnWriteArrayList<String> myCopyOnWriteArrayList = new MyCopyOnWriteArrayList<>(
                Stream.of("1", "1", "1", "1", "1", "1", "1", "1", "1").collect(Collectors.toList()));

        System.out.println("<=== размер листа до запуска потоков ===> " + myCopyOnWriteArrayList.size());


        Thread addThread = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(1000l);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                myCopyOnWriteArrayList.add(Integer.toString(0));
                System.out.println("AddThread: добавляю " + i );
            }
            Thread.currentThread().interrupt();
        });

        Thread removeThread = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(1000l);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("RemoveThread: " + myCopyOnWriteArrayList.remove(0) + " удаляю " + i);
            }
            Thread.currentThread().interrupt();
        });

        Thread readThread = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(450l);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Iterator<String> iterator = myCopyOnWriteArrayList.iterator();
                while (iterator.hasNext()){
                    System.out.print(iterator.next() + " ");
                }
                System.out.println("\n");
            }
            Thread.currentThread().interrupt();
        });


        addThread.start();
        removeThread.start();
        readThread.start();

        Thread.sleep(4000l);
        System.out.println("<=== размер листа после запуска потоков ===> " + myCopyOnWriteArrayList.size());
        Iterator<String> iterator = myCopyOnWriteArrayList.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
    }
}
