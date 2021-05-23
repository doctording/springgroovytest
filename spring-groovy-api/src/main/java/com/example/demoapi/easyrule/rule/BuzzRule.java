package com.example.demoapi.easyrule.rule;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

/**
 * @Author mubi
 * @Date 2021/5/23 11:50
 */
@Rule(priority = 2)
public class BuzzRule {

    @Condition
    public boolean isBuzz(@Fact("number") Integer number) {
        return number % 7 == 0;
    }

    @Action
    public void printBuzz() {
        System.out.print("buzz");
    }
}
