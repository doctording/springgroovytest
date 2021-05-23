package com.example.demoapi.easyrule;

import com.example.demoapi.easyrule.rule.BuzzRule;
import com.example.demoapi.easyrule.rule.FizzBuzzRule;
import com.example.demoapi.easyrule.rule.FizzRule;
import com.example.demoapi.easyrule.rule.NonFizzBuzzRule;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.api.RulesEngineParameters;
import org.jeasy.rules.core.DefaultRulesEngine;

/**
 * https://github.com/j-easy/easy-rules/wiki/fizz-buzz
 * @Author mubi
 * @Date 2021/5/23 12:03
 */
public class FizzBuzzWithEasyRules {

    static void test1(){
        RulesEngine rulesEngine = new DefaultRulesEngine();

        Rules rules = new Rules();
        rules.register(new FizzRule());

        Facts facts = new Facts();
        facts.put("number", 5);
        rulesEngine.fire(rules, facts);
        System.out.println();
    }

    public static void main(String[] args) {
        if(1 == 1){
            test1();
            return;
        }
        // create a rules engine
        RulesEngineParameters parameters = new RulesEngineParameters().skipOnFirstAppliedRule(true);
        RulesEngine fizzBuzzEngine = new DefaultRulesEngine(parameters);

        // create rules
        Rules rules = new Rules();
        rules.register(new FizzRule());
        rules.register(new BuzzRule());
        rules.register(new FizzBuzzRule(new FizzRule(), new BuzzRule()));
        rules.register(new NonFizzBuzzRule());

        // fire rules
        Facts facts = new Facts();
        for (int i = 1; i <= 35; i++) {
            facts.put("number", i);
            fizzBuzzEngine.fire(rules, facts);
            System.out.println();
        }
    }

}

