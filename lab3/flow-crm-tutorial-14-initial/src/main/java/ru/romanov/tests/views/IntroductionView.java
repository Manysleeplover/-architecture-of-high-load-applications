package ru.romanov.tests.views;


import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteParameters;
import org.springframework.beans.factory.annotation.Autowired;
import ru.romanov.tests.services.TestService;

import javax.swing.text.ComponentView;

@PageTitle("Вступление")
@Route(value = "/", layout = MainLayout.class)
public class IntroductionView extends VerticalLayout {


    public IntroductionView(@Autowired TestService testService) {

        add(new H1("Вступление"));
    }

}
