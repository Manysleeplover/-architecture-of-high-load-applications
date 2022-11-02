package ru.romanov.MyCopyOnWriteArrayList;


import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class МногопоточноеДемо {

    public static void main(String[] args) throws InterruptedException {
        MyCopyOnWriteArrayList<String> myCopyOnWriteArrayList = new MyCopyOnWriteArrayList<>(
                Stream.of("1", "2", "3", "4", "5", "9", "8", "7", "6").collect(Collectors.toList()));

        System.out.println("<=== размер листа до запуска потоков ===> " + myCopyOnWriteArrayList.size());


        Thread addThread = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(300l);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                myCopyOnWriteArrayList.add(Integer.toString(i));
                System.out.println("AddThread: добавляю " + i );
            }
            Thread.currentThread().interrupt();
        });

        Thread removeThread = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(300l);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("RemoveThread: " + myCopyOnWriteArrayList.remove(Integer.toString(i)) + " удаляю " + i);
            }
            Thread.currentThread().interrupt();
        });

        Thread readThread = new Thread(() -> {
            Iterator<String> iterator = myCopyOnWriteArrayList.iterator();
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(300l);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("ReadThread: размер листа " + myCopyOnWriteArrayList.size());
            }
            Thread.currentThread().interrupt();
        });


        addThread.start();
        removeThread.start();
        readThread.start();

        Thread.sleep(4000l);
        System.out.println("<=== размер листа после запуска потоков ===> " + myCopyOnWriteArrayList.size());
    }
}
