package ru.romanov.MyCopyOnWriteArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ОднопоточноеДемо {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        MyCopyOnWriteArrayList<String> myCopyOnWriteArrayList = new MyCopyOnWriteArrayList<>(strings);
        myCopyOnWriteArrayList.add("1");
        myCopyOnWriteArrayList.add("2");
        myCopyOnWriteArrayList.add("3");
        Iterator<String> iterator1 = myCopyOnWriteArrayList.iterator();
        System.out.println("<=============== Первый итератор создан  ===============>");
        myCopyOnWriteArrayList.add(0,"4");
        System.out.println("<=============== Добавлен новый элемент '4', исключение не выбросилось  ===============>");
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        System.out.println("<=============== Второй итератор ===============>");
        Iterator<String> iterator2 = myCopyOnWriteArrayList.iterator();
        System.out.println("<=============== Пытаемся удалить элемент '4', исключение не выбросилось===============>");
        myCopyOnWriteArrayList.remove("4");
        System.out.println("<=============== Пытаемся удалить элемент третий элемент, исключение снова не выбросилось===============>");

        myCopyOnWriteArrayList.remove(2);

        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }
        System.out.println("<==============================>");
        System.out.println(myCopyOnWriteArrayList);
    }
}
