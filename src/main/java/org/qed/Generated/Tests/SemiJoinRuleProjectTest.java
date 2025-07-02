package org.qed.Generated.Tests;

import kala.collection.Seq;
import kala.tuple.Tuple;
import org.apache.calcite.rel.core.JoinRelType;
import org.qed.Generated.CalciteTester;
import org.qed.RRuleInstance;
import org.qed.RelType;
import org.qed.Generated.RRuleInstances.SemiJoinRuleProject;
import org.qed.RuleBuilder;

public class SemiJoinRuleProjectTest {

    static final String genPath = "src/main/java/org/qed/Generated";
    
    public static void runTest() {
        var tester = new CalciteTester();
        var builder = RuleBuilder.create();
        var rule = new SemiJoinRuleProject();
        
        var leftTable = builder.createQedTable(Seq.of(Tuple.of(RelType.fromString("INTEGER", true), false)));
        var rightTable = builder.createQedTable(Seq.of(Tuple.of(RelType.fromString("INTEGER", false), true)));
        builder.addTable(leftTable);
        builder.addTable(rightTable);
        
        builder.scan(rightTable.getName()).aggregate(builder.groupKey(0));
        var rightAgg = builder.build();
        var leftScan = builder.scan(leftTable.getName()).build();

        builder.push(leftScan).push(rightAgg);
        var joinCond = builder.equals(builder.field(2, 0, 0), builder.field(2, 1, 0));
        var before = builder.join(JoinRelType.INNER, joinCond).project(builder.field(0)).build();

        var after = builder.push(leftScan)
                        .push(rightAgg)
                        .join(JoinRelType.SEMI, joinCond)
                        .project(builder.field(0))
                        .build();
        
        // tester.serialize(rule, genPath);
        var runner = CalciteTester.loadRule(org.qed.Generated.SemiJoinRuleProject.Config.DEFAULT.toRule());
        tester.verify(runner, before, after);
    }

    public static void main(String[] args) {
        System.out.println("Running SemiJoinRuleProject test...");
        runTest();
    }
}