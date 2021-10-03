package com.example.demoapi.easyrule.rule;

import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.support.composite.UnitRuleGroup;

/**
 * @Author mubi
 * @Date 2021/5/23 11:58
 */
@Rule
public class FizzBuzzRule extends UnitRuleGroup {

    public FizzBuzzRule(Object... rules) {
        for (Object rule : rules) {
            addRule(rule);
        }
    }

    @Override
    public int getPriority() {
        return 0;
    }
}
