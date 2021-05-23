package com.example.demoapi.easyrule.rule;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Priority;
import org.jeasy.rules.annotation.Rule;

/**
 * @Author mubi
 * @Date 2021/5/23 11:59
 */
@Rule(priority = 3)
public class NonFizzBuzzRule {

    @Condition
    public boolean isNotFizzNorBuzz(@Fact("number") Integer number) {
        // can return true, because this is the latest rule to trigger according to assigned priorities
        // and in which case, the number is not fizz nor buzz
        return number % 5 != 0 || number % 7 != 0;
    }

    @Action
    public void printInput(@Fact("number") Integer number) {
        System.out.print(number);
    }

}
