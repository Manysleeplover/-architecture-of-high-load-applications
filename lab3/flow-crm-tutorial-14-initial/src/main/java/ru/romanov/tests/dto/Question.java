package ru.romanov.tests.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    private String question;
    private List<String> answerOptions;
    private String correctAnswer;
    private Long weight;
}
