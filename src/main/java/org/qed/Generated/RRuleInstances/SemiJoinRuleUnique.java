package org.qed.Generated.RRuleInstances;

import kala.collection.Map;
import kala.collection.Seq;
import org.apache.calcite.rel.core.JoinRelType;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
import org.qed.RelRN;
import org.qed.RexRN;
import org.qed.RRule;
import org.qed.RelType;
import org.qed.RuleBuilder;

public record SemiJoinRuleUnique() implements RRule {
    static final RelRN left = RelRN.scan("Left", "Left_Type");
    static final RelType.VarType rightType = new RelType.VarType("INTEGER", true);
    static final RelRN right = RelRN.scan("Right", rightType, true);       // unique on join key
    static final RexRN joinCond = left.joinPred("join", right);
    static final RexRN allCols = left.proj("identity", "Left_Type");

    @Override
    public RelRN before() {
        RelRN inner = left.join(JoinRelType.INNER, joinCond, right);
        return inner.project(allCols);
    }

    @Override
    public RelRN after() {
        RelRN semi = left.join(JoinRelType.SEMI, joinCond, right);
        return semi.project(allCols);
    }
}
