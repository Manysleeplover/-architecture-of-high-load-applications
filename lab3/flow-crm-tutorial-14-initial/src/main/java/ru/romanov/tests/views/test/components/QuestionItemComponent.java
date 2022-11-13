package ru.romanov.tests.views.test.components;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.spring.annotation.UIScope;
import ru.romanov.tests.dto.Question;


@UIScope
public class QuestionItemComponent extends VerticalLayout {

    /**
     * Непосредтсвенно вопрос, по которому собираем форму
     */
    private final Question question;
    /**
     * Номер вопроса
     */
    private final Integer numberOfQuestion;
    /**
     * Поле с вопросом
     */
    private final TextArea questionText = new TextArea();

    private final Image image = new Image();
    /**
     * Поле с вариантами ответов
     */
    private final RadioButtonGroup<String> answerOptionsRadioButton = new RadioButtonGroup<>();

    private final VerticalLayout questionItemLayout = new VerticalLayout();

    public QuestionItemComponent(Question question, Integer numberOfQuestion) {
        this.question = question;
        this.numberOfQuestion = numberOfQuestion;
    }

    /**
     * Метод, возвращающий кол-во очков за вопрос
     */
    public Long getPontForTheAnswer() {
        return question.getWeight();
    }

    /**
     * Метод, проверяющий ответ на правильность
     */
    public boolean isCorrectAnswer() {
        return answerOptionsRadioButton.getValue().equals(question.getCorrectAnswer());
    }

    /**
     * Метод, проверяющий ответил ли пользователь на вопрос
     */
    public boolean isTestWillPass() {
        return answerOptionsRadioButton.getValue() != null;
    }

    /**
     * Метод, возвращающий компонент вопроса
     */
    public VerticalLayout getQuestionItem() {
        removeAll();
        configureItemForm();
        return questionItemLayout;
    }

    /**
     * Метод, конфигурирующий компонент вопроса
     */
    private void configureItemForm() {
        questionText.setLabel("Вопрос №" + numberOfQuestion);
        questionText.setValue(question.getQuestion());
        questionText.setReadOnly(true);
        image.setSrc(question.getImagePath());
        image.setWidth("300px");
        image.setHeight("300px");

        answerOptionsRadioButton.setItems(question.getAnswerOptions());
        answerOptionsRadioButton.setLabel("Варианты ответов");
        if (!question.getImagePath().equals(""))
            questionItemLayout.add(questionText, image, answerOptionsRadioButton);
        else
            questionItemLayout.add(questionText, answerOptionsRadioButton);
    }

}
