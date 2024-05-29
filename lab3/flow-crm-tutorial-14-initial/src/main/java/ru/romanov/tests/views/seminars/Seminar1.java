package ru.romanov.tests.views.seminars;

import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import ru.romanov.tests.views.MainLayout;

@PageTitle("Семинар №1 - Нахождение площади прямоугольного треугольника")
@Route(value = "/math-seminar-1", layout = MainLayout.class)
public class Seminar1 extends VerticalLayout {

    public Seminar1() {
        add(new H1("Семинар 1 - Способы нахождения площади прямоугольного треугольника"));
        add(new H2("Нахождение площади"));
        add(new H4("Площадь прямоугольного треугольника равна:"));
        UnorderedList trianglePropertiesList = new UnorderedList();
        trianglePropertiesList.add(new ListItem("половине произведения катетов треугольника: S = 0,5 ab (a, b - катеты треугольника);"));
        trianglePropertiesList.add(new ListItem("Формула Герона S = (p * (p-a) * (p-b) * (p-c))1/2"));
        add(trianglePropertiesList);
        add(new H2("Теорема пифагора"));
        add(new Image("images/sem_1_pif.PNG", "Прямоугольный треугольник"));
        add(new H4("что и требовалось доказать."));
        add(new H4("Приведенное доказательство имеет алгебраический характер: вычисление показывает, что сумма квадратов длин катетов равны квадрату длины гипотенузы.\n"));
        add(new Image("images/sem_sin_cos_1.PNG", "Прямоугольный треугольник"));


    }
}
