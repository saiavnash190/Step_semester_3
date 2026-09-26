package session_8.class_problems;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class M4_ExaminationQuestionGrader {

    static abstract class Question {

        protected String questionText;
        protected String correctAnswer;
        protected String studentAnswer;
        protected double points;

        Question(
                String questionText,
                String correctAnswer,
                String studentAnswer,
                double points) {

            this.questionText = questionText;
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        abstract double grade();
    }

    static class MCQ extends Question {

        MCQ(
                String questionText,
                String correctAnswer,
                String studentAnswer,
                double points) {

            super(
                questionText,
                correctAnswer,
                studentAnswer,
                points
            );
        }

        @Override
        double grade() {

            if (studentAnswer.equals(correctAnswer)) {
                return points;
            }

            return 0;
        }
    }

    static class TF extends Question {

        TF(
                String questionText,
                String correctAnswer,
                String studentAnswer,
                double points) {

            super(
                questionText,
                correctAnswer,
                studentAnswer,
                points
            );
        }

        @Override
        double grade() {

            if (studentAnswer.equals(correctAnswer)) {
                return points;
            }

            return 0;
        }
    }

    static class Essay extends Question {

        Essay(
                String questionText,
                String correctAnswer,
                String studentAnswer,
                double points) {

            super(
                questionText,
                correctAnswer,
                studentAnswer,
                points
            );
        }

        @Override
        double grade() {

            String[] keywords =
                correctAnswer.split(",");

            int matches = 0;

            String answer =
                studentAnswer.toLowerCase();

            for (String keyword : keywords) {

                if (answer.contains(
                    keyword.trim().toLowerCase()
                )) {
                    matches++;
                }
            }

            if (matches >= 2) {
                return points * 0.75;
            }

            if (matches == 1) {
                return points * 0.50;
            }

            return 0;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        double totalScore = 0;

        Pattern pattern = Pattern.compile(
            "^(\\w+)\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+(\\d+)$"
        );

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            Matcher matcher =
                pattern.matcher(line);

            if (!matcher.matches()) {
                continue;
            }

            String type = matcher.group(1);
            String question = matcher.group(2);
            String correct = matcher.group(3);
            String student = matcher.group(4);
            double points =
                Double.parseDouble(matcher.group(5));

            Question q;

            if (type.equals("MCQ")) {

                q = new MCQ(
                    question,
                    correct,
                    student,
                    points
                );
            }
            else if (type.equals("TF")) {

                q = new TF(
                    question,
                    correct,
                    student,
                    points
                );
            }
            else {

                q = new Essay(
                    question,
                    correct,
                    student,
                    points
                );
            }

            double score = q.grade();

            System.out.printf(
                "%s: %.2f%n",
                type,
                score
            );

            totalScore += score;
        }

        System.out.printf(
            "Total Score: %.2f%n",
            totalScore
        );
    }
}
