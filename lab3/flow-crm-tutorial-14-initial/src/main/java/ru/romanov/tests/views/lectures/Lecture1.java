package ru.romanov.tests.views.lectures;

import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import ru.romanov.tests.views.MainLayout;

@PageTitle("Лекция №1 - Прямоугольный треугольник")
@Route(value = "/math-lecture-1", layout = MainLayout.class)
public class Lecture1 extends VerticalLayout {
    public Lecture1() {
        add(new H1("Лекция №1 - Прямоугольный треугольник"));
        add(new Image("images/Lecture1.прямоугольный треугольник.png", "Прямоугольный треугольник"));
        add(new H2("Определение: "));
        add(new H4("Треугольник называют прямоугольным, если у него есть прямой угол.\n" +
                "Прямоугольный треугольник имеет две взаимно перпендикулярные стороны, называемые катетами; третья его сторона называется гипотенузой.Угол ABC=90∘ , АC  - гипотенуза, AB  и ВC  - катеты.\n" +
                "Прямоугольный треугольник, имеющий равные катеты, называется равнобедренным прямоугольным треугольником. В равнобедренном прямоугольном треугольнике острые углы равны (каждый из них равен 45∘)."));

        add(new H2("Свойства: "));
        UnorderedList trianglePropertiesList = new UnorderedList();
        trianglePropertiesList.add(new ListItem("По свойствам перпендикуляра и наклонных гипотенуза длиннее каждого из катетов (но меньше их суммы)."));
        trianglePropertiesList.add(new ListItem("Сумма двух острых углов прямоугольного треугольника равна прямому углу."));
        trianglePropertiesList.add(new ListItem("Две высоты прямоугольного треугольника совпадают с его катетами. Поэтому одна из четырех замечательных точек попадает в вершины прямого угла треугольника."));
        trianglePropertiesList.add(new ListItem("Центр описанной окружности прямоугольного треугольника лежит в середине гипотенузы."));
        trianglePropertiesList.add(new ListItem("Медиана прямоугольного треугольника, проведенная из вершины прямого угла на гипотенузу, является радиусом описанной около этого треугольника окружности."));
        trianglePropertiesList.add(new ListItem("В прямоугольном треугольнике катет, лежащий против угла 30 градусов, равен половине гипотенузы."));
        trianglePropertiesList.add(new ListItem("Высота прямоугольного треугольника, опущенная из вершины прямого угла, делит этот треугольник на два треугольника, подобных исходному."));
        trianglePropertiesList.add(new ListItem("Биссектриса прямого угла в прямоугольном треугольнике лежит между медианой и высотой и делит угол между ними пополам. "));
        add(trianglePropertiesList);

        add(new H2("Признаки равенства прямоугольных треугольников: "));
        add(new Image("images/Признаки равенства 1.png", "Признаки равенства 1"));
        add(new Image("images/Признаки равенства 2.png", "Признаки равенства 2"));
    }

}
