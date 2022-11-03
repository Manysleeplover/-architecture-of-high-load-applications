package ru.romanov.MyCopyOnWriteArrayList;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.*;


@NoArgsConstructor
@AllArgsConstructor
public class MyCopyOnWriteArrayList<T> {

    /**
     * Поле для синхронизации объекта, не сериализуется
     */
    final transient Object lock = new Object();

    /**
     * Вложенный лист, с которого будем снимать копии
     */
    private List<T> innerArrayList = new ArrayList<>();

    /**
     * Вставка элемента в конец. Мониторим объект, модифицируем коллекцию.
     *
     * @param object - целевой объект
     */
    public void add(T object) {
        synchronized (this.lock) {
            this.innerArrayList.add(object);
        }
    }

    /**
     * Вставляем элемент по индексу с монитором.
     *
     * @param index  - целевой индекс
     * @param object - целевой элемент
     */
    public void add(int index, T object) {
        synchronized (this.lock) {
            this.innerArrayList.add(index, object);
        }
    }

    public T remove(int index) {
        synchronized (this.lock) {
            return this.innerArrayList.remove(index);
        }
    }

    public boolean remove(T object) {
        synchronized (this.lock) {
            return this.innerArrayList.remove(object);
        }
    }

    public long size() {
        List<T> cloneList = getList();
        return cloneList.size();
    }

    /**
     * Получаем итератор снимка вложенной коллекции
     */
    public Iterator<T> iterator() {
        List<T> cloneList = getList();
        return cloneList.iterator();
    }

    /**
     * Получаем снимок вложенной коллекции
     */
    private List<T> getList() {
        synchronized (lock) {
            List<T> clone = new ArrayList<>(this.innerArrayList);
            return clone;
        }
    }

    @Override
    public String toString() {
        List<T> cloneList = getList();
        return "MyCopyOnWriteArrayList{" +
                "innerArrayList=" + cloneList +
                '}';
    }
}
