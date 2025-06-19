package org.qed.Generated.Tests;

import kala.collection.Seq;
import kala.tuple.Tuple;
import org.apache.calcite.rel.core.JoinRelType;
import org.qed.Generated.CalciteTester;
import org.qed.RRuleInstance;
import org.qed.RelType;
import org.qed.Generated.RRuleInstances.SemiJoinRuleUnique;
import org.qed.RuleBuilder;

public class SemiJoinRuleUniqueTest {

    static final String genPath = "src/main/java/org/qed/Generated";
    
    public static void runTest() {
        var tester = new CalciteTester();
        var builder = RuleBuilder.create();
        var rule = new SemiJoinRuleUnique();
        
        var leftTable = builder.createQedTable(Seq.of(Tuple.of(RelType.fromString("INTEGER", true), false)));
        var rightTable = builder.createQedTable(Seq.of(Tuple.of(RelType.fromString("INTEGER", true), true)));
        builder.addTable(leftTable);
        builder.addTable(rightTable);
        
        var leftScan = builder.scan(leftTable.getName()).build();
        var rightScan = builder.scan(rightTable.getName()).build();

        builder.push(leftScan);
        builder.push(rightScan);
        var cond = builder.equals(builder.field(2,0,0), builder.field(2,1,0));
        var before = builder.join(JoinRelType.INNER, cond)
                            .project(builder.field(0))
                            .build();
        builder.clear();
        
        leftScan = builder.scan(leftTable.getName()).build();
        rightScan = builder.scan(rightTable.getName()).build();
        var after = builder.push(leftScan)
                           .push(rightScan)
                           .join(JoinRelType.SEMI, cond)
                           .project(builder.field(0))
                           .build();

        // tester.serialize(rule, genPath);
        var runner = CalciteTester.loadRule(org.qed.Generated.SemiJoinRuleUnique.Config.DEFAULT.toRule());
        tester.verify(runner, before, after);
    }

    public static void main(String[] args) {
        System.out.println("Running SemiJoinRuleUnique test...");
        runTest();
    }
}
