package ru.romanov.tests.views.test;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.spring.annotation.UIScope;
import ru.romanov.tests.dto.Question;


@UIScope
public class QuestionItemComponent extends VerticalLayout {

    /**
     * Непосредтсвенно вопрос, по которому собираем форму
     */
    private Question question;
    private Integer numberOfQuestion;
    /**
     * Поле с вопросом
     */
    private TextField questionText = new TextField();
    /**
     * Поле с вариантами ответов
     */
    private RadioButtonGroup<String> answerOptionsRadioButton = new RadioButtonGroup<>();

    private VerticalLayout questionItemLayout = new VerticalLayout();

    public QuestionItemComponent(Question question, Integer numberOfQuestion) {
        this.question = question;
        this.numberOfQuestion = numberOfQuestion;
    }

    private void configureItemForm() {
        questionText.setLabel("Вопрос №" + numberOfQuestion);
        questionText.setValue(question.getQuestion());
        questionText.setReadOnly(true);

        answerOptionsRadioButton.setItems(question.getAnswerOptions());
        answerOptionsRadioButton.setLabel("Варианты ответов");

        questionItemLayout.add(questionText, answerOptionsRadioButton);
    }

    public boolean isCorrectAnswer() {
        return answerOptionsRadioButton.getValue().equals(question.getCorrectAnswer());
    }

    public Long getPontForTheAnswer(){
        return question.getWeight();
    }

    public VerticalLayout getQuestionItem() {
        removeAll();
        configureItemForm();
        return questionItemLayout;
    }

    public boolean isTestWillPass() {
        return answerOptionsRadioButton.getValue() != null;
    }

}
