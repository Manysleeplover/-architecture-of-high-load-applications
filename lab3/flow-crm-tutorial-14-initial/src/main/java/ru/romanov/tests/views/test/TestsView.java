package ru.romanov.tests.views.test;

import ru.romanov.tests.services.TestService;
import ru.romanov.tests.views.user.UserLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Прохождение тестов")
@Route(value = "/test", layout = UserLayout.class)
public class TestsView extends VerticalLayout {

    private TestService testServie;

    public TestsView(@Autowired TestService testServie) {
        this.testServie = testServie;
        testServie.getQuestionList();
    }


}
