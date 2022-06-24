package com.example.vbot;

public class QuestionAnswer {
    public static String question[]=
        {
            "Do you think your worry is excessive?",
            "Do you worry more days than not?",
            "Have you been worrying like this for the past 6 months?",
            "Is it hard for you to control your worrying?",
            "Have you noticed any physical symptoms such as restlessness, feeling tired easily, trouble concentrating, irritability, muscle tension, or trouble sleeping?",
            "Does your worrying negatively impact your ability to function, like at school, work, with friends, with family, or in other areas that are important to you?"

        };
    public static String choices[][]=
            {
                    {"0", "1", "2", "3", "4", "5"},
                    {"0", "1", "2", "3", "4", "5"},
                    {"0", "1", "2", "3", "4", "5"},
                    {"0", "1", "2", "3", "4", "5"},
                    {"0", "1", "2", "3", "4", "5"},
                    {"0", "1", "2", "3", "4", "5"}
            };


    public static String correctAnswers[]=
            {
                    "2","3","5","3","4","5"
    };
}
