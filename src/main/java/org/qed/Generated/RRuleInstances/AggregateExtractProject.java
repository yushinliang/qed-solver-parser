package org.qed.Generated.RRuleInstances;

import kala.collection.Map;
import kala.collection.Seq;
import org.apache.calcite.rel.core.JoinRelType;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
import org.qed.RelRN;
import org.qed.RelType;
import org.qed.RexRN;
import org.qed.RRule;
import org.qed.RuleBuilder;

// public record AggregateExtractProject() implements RRule {
//     static final RelRN source = RelRN.scan("Source", "Source_Type");
//     static final RexRN group = source.proj("Group", "Group_Type");
//     static final RexRN agg = source.proj("Agg", "Agg_Type");
//     static final RelType.VarType aggType = new RelType.VarType("Agg_Type", true);
//     static final RelRN aggCall = new RelRN.AggCall("AggCall", false, aggType, Seq.of(agg));


//     @Override
//     public RelRN before() {
//         return source.aggregate(Seq.of(group), Seq.of(aggCall));
        
//     }
    
//     @Override
//     public RelRN after() {
//         // first project the fields actually used
//         var newSource = source.project(group).project(agg);
//         // TODO: what is newGroup and new aggCall after projection?
//         return newSource.aggregate(Seq.of(newGroup), Seq.of(newAggCall));
//     }
// }
