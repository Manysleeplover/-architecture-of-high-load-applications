package ru.romanov.tests.services;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import ru.romanov.tests.dto.Question;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {

    /**
     * Метод, получающий из json список вопросов
     *
     * @return - лист с вопросами
     */
    public List<Question> getQuestionList() {

        List<Question> questions = new ArrayList<>();

        JSONObject mainJson = new JSONObject("{\n" +
                "  \"questions\": [\n" +
                "    {\n" +
                "      \"question\": \"Дан прямоугольный треугольник MBC. Определи ∠B, если ∠С = 75°\",\n" +
                "      \"answer_options\": [\n" +
                "        \"15\",\n" +
                "        \"20\",\n" +
                "        \"10\",\n" +
                "        \"5\"\n" +
                "      ],\n" +
                "      \"correct_answer\": \"15\",\n" +
                "      \"image_path\": \"images/1.PNG\",\n" +
                "      \"weight\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"question\": \"Прямоугольным называется треугольник, у которого\",\n" +
                "      \"answer_options\": [\n" +
                "        \"все углы прямые\",\n" +
                "        \"два угла прямые\",\n" +
                "        \"один прямой угол\"\n" +
                "      ],\n" +
                "      \"correct_answer\": \"один прямой угол\",\n" +
                "      \"image_path\": \"\",\n" +
                "      \"weight\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"question\": \"В прямоугольном треугольнике всегда\",\n" +
                "      \"answer_options\": [\n" +
                "        \"два угла острых и один прямой\",\n" +
                "        \"один острый угол, один прямой угол и один тупой угол\",\n" +
                "        \"все углы прямые\"\n" +
                "      ],\n" +
                "      \"correct_answer\": \"два угла острых и один прямой\",\n" +
                "      \"image_path\": \"\",\n" +
                "      \"weight\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"question\": \"Стороны прямоугольного треугольника, образующие прямой угол, называются:\",\n" +
                "      \"answer_options\": [\n" +
                "        \"сторонами треугольника\",\n" +
                "        \"катетами треугольника\",\n" +
                "        \"гипотенузами треугольника\"\n" +
                "      ],\n" +
                "      \"correct_answer\": \"катетами треугольника\",\n" +
                "      \"image_path\": \"\",\n" +
                "      \"weight\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"question\": \"Сторона прямоугольного треугольника, противолежащая прямому углу, называется\",\n" +
                "      \"answer_options\": [\n" +
                "        \"стороной треугольника\",\n" +
                "        \"катетом треугольника\",\n" +
                "        \"гипотенузой треугольника\"\n" +
                "      ],\n" +
                "      \"correct_answer\": \"гипотенузой треугольника\",\n" +
                "      \"image_path\": \"\",\n" +
                "      \"weight\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"question\": \"Сумма острых углов прямоугольного треугольника равна \",\n" +
                "      \"answer_options\": [\n" +
                "        \"180°\",\n" +
                "        \"100°\",\n" +
                "        \"90°\"\n" +
                "      ],\n" +
                "      \"correct_answer\": \"90°\",\n" +
                "      \"image_path\": \"\",\n" +
                "      \"weight\": 1\n" +
                "    }\n" +
                "  ]\n" +
                "}");
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
