package com.example.demoapi.easyrule.rule;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

/**
 * @Author mubi
 * @Date 2021/5/23 11:49
 */
@Rule(priority = 1)
public class FizzRule {
    @Condition
    public boolean isFizz(@Fact("number") Integer number) {
        return number % 5 == 0;
    }

    @Action
    public void printFizz() {
        System.out.print("fizz");
    }

}
