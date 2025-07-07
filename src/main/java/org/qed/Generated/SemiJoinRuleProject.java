package org.qed.Generated;

import org.apache.calcite.plan.RelOptRuleCall;
import org.apache.calcite.plan.RelRule;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.rel.core.JoinRelType;
import org.apache.calcite.rel.logical.*;

public class SemiJoinRuleProject extends RelRule<SemiJoinRuleProject.Config> {
	protected SemiJoinRuleProject(Config config) {
		super(config);
	}

	@Override
	public void onMatch(RelOptRuleCall call) {
		var var_4 = call.builder();
		call.transformTo(var_4.push(call.rel(2)).push(call.rel(3)).join(JoinRelType.SEMI, var_4.equals(var_4.field(2, 0, 0), var_4.field(2, 1, 0))).project(((LogicalProject) call.rel(0)).getProjects()).build());
	}

	public interface Config extends EmptyConfig {
		Config DEFAULT = new Config() {};

		@Override
		default SemiJoinRuleProject toRule() {
			return new SemiJoinRuleProject(this);
		}

		@Override
		default String description() {
			return "SemiJoinRuleProject";
		}

		@Override
		default RelRule.OperandTransform operandSupplier() {
			return s_3 -> s_3.operand(LogicalProject.class).oneInput(s_2 -> s_2.operand(LogicalJoin.class).inputs(s_0 -> s_0.operand(RelNode.class).anyInputs(), s_1 -> s_1.operand(RelNode.class).anyInputs()));
		}

	}
}
