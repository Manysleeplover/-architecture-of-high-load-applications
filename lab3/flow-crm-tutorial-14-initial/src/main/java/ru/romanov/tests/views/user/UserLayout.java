package ru.romanov.tests.views.user;


import ru.romanov.tests.bean.UserSessionInfo;
import ru.romanov.tests.views.LoginPage;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.Theme;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import ru.romanov.tests.views.test.TestsView;

import javax.servlet.ServletException;

@Theme(themeFolder = "flowcrmtutorial")
public class UserLayout extends AppLayout {

    public UserLayout() {
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        H1 logo = new H1("СмениПароль");
        logo.addClassNames("text-l", "m-m");

        HorizontalLayout header = new HorizontalLayout(
                new DrawerToggle(),
                logo
        );

        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.setWidth("100%");
        header.addClassNames("py-0", "px-m");

        Button logout = new Button("Выйти", e -> {
            try {
                (((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest()).logout();
                UserSessionInfo.getInstance().cleanCurrentUser();
                getUI().get().getSession().close();
                getUI().get().navigate(LoginPage.class);
            } catch (ServletException ex) {
                throw new RuntimeException(ex);
            }
        });
        logout.getStyle().set("margin-right", "15px").set("margin-left", "15px");
        logout.setWidth("150px");

        addToNavbar(header, logout);

    }

    private void createDrawer() {
        RouterLink changePasswordLink = new RouterLink("Смена пароля", UserView.class);
        RouterLink testLink = new RouterLink("Тесты", TestsView.class);
        changePasswordLink.setHighlightCondition(HighlightConditions.sameLocation());

        addToDrawer(new VerticalLayout(
                testLink, changePasswordLink
        ));
    }
}