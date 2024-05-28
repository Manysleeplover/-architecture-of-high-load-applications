package ru.romanov.tests.views;


import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.details.DetailsVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.Theme;
import ru.romanov.tests.security.SecurityService;
import ru.romanov.tests.views.lecture.LectureView;
import ru.romanov.tests.views.test.TestsView;


@Theme(themeFolder = "flowcrmtutorial")
public class MainLayout extends AppLayout {

    private final SecurityService securityService;

    public MainLayout(SecurityService securityService) {
        this.securityService = securityService;
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        H1 logo = new H1("Образовательная платформа StankinSmart");
        logo.addClassNames("text-l", "m-m");

        Button logout = new Button("Log out", e -> securityService.logout());

        HorizontalLayout header = new HorizontalLayout(
                new DrawerToggle(),
                logo,
                logout
        );

        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.expand(logo);
        header.setWidth("100%");
        header.addClassNames("py-0", "px-m");

        addToNavbar(header);

    }

    private void createDrawer() {
        Accordion menuAccordion = new Accordion();
        VerticalLayout mathLayout = new VerticalLayout();
        mathLayout.add(new RouterLink("Лекции", LectureView.class));
        mathLayout.add(new RouterLink("Семинары", TestsView.class));
        mathLayout.add(new RouterLink("Тесты", TestsView.class));
        AccordionPanel lectureAccordionPanel = menuAccordion.add("Математика", mathLayout);
        lectureAccordionPanel.addThemeVariants(DetailsVariant.REVERSE, DetailsVariant.SMALL, DetailsVariant.FILLED);

        addToDrawer(new VerticalLayout(
                lectureAccordionPanel
        ));
    }
}