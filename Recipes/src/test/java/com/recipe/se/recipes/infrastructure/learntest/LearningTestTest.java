package com.recipe.se.recipes.infrastructure.learntest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LearningTestTest {
    @Test
    void addTwoNumbers() {
        //given
        int firstNumber = 10;
        int secondNumber = 20;
        int expectedValue = 30;

        //when

        int actualValue = new LearningTest().add(firstNumber, secondNumber);

        //then

        assertEquals(expectedValue, actualValue);

    }

    @Test
    void multiplyTwoNmbers() {
        // given

        int firstNumber = 10;
        int secondNumber = 20;
        int expectedValue = 200;


        //when

         int actualValue = new LearningTest().multiply( firstNumber, secondNumber);

        // then

        assertEquals(expectedValue,actualValue);

    }
}
