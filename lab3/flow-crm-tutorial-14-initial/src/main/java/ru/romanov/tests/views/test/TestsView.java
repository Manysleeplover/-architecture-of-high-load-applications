package ru.romanov.tests.views.test;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Paragraph;
import ru.romanov.tests.dto.Question;
import ru.romanov.tests.services.TestService;
import ru.romanov.tests.views.user.UserLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@PageTitle("Прохождение тестов")
@Route(value = "/test", layout = UserLayout.class)
public class TestsView extends VerticalLayout {

    private final TestService testService;
    private final Button validateButton = new Button();

    private Long score = 0L;

    private final List<QuestionItemComponent> questionItemComponents = new ArrayList<>();

    public TestsView(@Autowired TestService testService) {
        this.testService = testService;
        configureValidateButton();
        add(addQuestionItem(), validateButton);
    }

    public VerticalLayout addQuestionItem() {
        VerticalLayout verticalLayout = new VerticalLayout();
        List<Question> questions = testService.getQuestionList();
        for (int i = 0; i < questions.size(); i++) {
            QuestionItemComponent questionItemComponent = new QuestionItemComponent(questions.get(i), i + 1);
            questionItemComponents.add(questionItemComponent);
            verticalLayout.add(questionItemComponent.getQuestionItem());
        }
        return verticalLayout;
    }

    private void configureValidateButton() {
        validateButton.setText("Проверить");
        validateButton.addClickListener(event -> {
            Dialog dialog = new Dialog();
            if (questionItemComponents.size() == questionItemComponents.stream().filter(QuestionItemComponent::isTestWillPass).count()) {
                score = questionItemComponents.stream().filter(QuestionItemComponent::isCorrectAnswer).
                        mapToLong(QuestionItemComponent::getPontForTheAnswer).sum();
                if (score == 0) {
                    dialog.add(new Paragraph("Кажется, когда вы родились - что-то пошло не так"));
                } else if (score == 1) {
                    dialog.add(new Paragraph("Поздравляем, вы чего-то добились в жизни"));
                } else if (score <=2) {
                    dialog.add(new Paragraph("Неплохо, продолжайте в том же духе"));
                } else if (score >= 4 && score <= 5) {
                    dialog.add(new Paragraph("Круто, у вас почти получилось"));
                } else if (score == 6) {
                    dialog.add(new Paragraph("Вы - настоящий пельмень"));
                }
                dialog.add(new Paragraph("Ваш балл: " + score));
                Button reloadButton = new Button("Попробовать ещё");
                reloadButton.addClickListener(x -> getUI().get().getPage().reload());
                dialog.add(reloadButton);
                dialog.open();
            } else {
                dialog.add("Пройдите тест полностью");
                dialog.open();
            }
        });
    }


}
