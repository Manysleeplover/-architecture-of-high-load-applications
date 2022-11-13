package ru.romanov.tests.services;

import ru.romanov.tests.dto.Question;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static ru.romanov.tests.utils.JsonUtils.getJson;

@Component
public class TestService {

    /**
     * Метод, получающий из json список вопросов
     *
     * @return - лист с вопросами
     */
    public List<Question> getQuestionList() {

        List<Question> questions = new ArrayList<>();

        JSONObject mainJson = new JSONObject(getJson("src/main/resources/test.json"));
        JSONArray jsonArray = mainJson.getJSONArray("questions");

        //Пробегамеся по массиву вопросов и сетим в POJO данные из json
        for (int i = 0; i < jsonArray.length(); i++) {
            Question question = new Question();
            JSONObject jsonQuestObject = jsonArray.getJSONObject(i);

            question.setQuestion(jsonQuestObject.getString("question"));
            question.setCorrectAnswer(jsonQuestObject.getString("correct_answer"));
            question.setWeight(jsonQuestObject.getLong("weight"));
            question.setImagePath(jsonQuestObject.getString("image_path"));

            //Пробегаемся по вложенному массиву и сетим в pojo варианты ответов
            List<String> answerOptions = new ArrayList<>();
            JSONArray options = jsonQuestObject.getJSONArray("answer_options");
            for (int j = 0; j < options.length(); j++) {
                answerOptions.add(options.getString(j));
            }
            question.setAnswerOptions(answerOptions);

            questions.add(question);
        }

        return questions;
    }

}
