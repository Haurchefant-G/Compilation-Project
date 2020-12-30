package util;

import parser.CParser;
import parser.CParserBaseVisitor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

// 重载CParserBaseVisitor中的函数
public class Parser extends CParserBaseVisitor<String> {
	File f;
	FileOutputStream fop;
	OutputStreamWriter writer;
	int tabnum = 0;
	Vector<Set> variable = new Vector<Set>();


	@Override
	public String visitTranslationUnit(CParser.TranslationUnitContext ctx) {
		try {
			f = new File("results.js");
			fop = new FileOutputStream(f);
			writer = new OutputStreamWriter(fop, StandardCharsets.UTF_8);
			Set tmp = new HashSet();
			variable.add(tmp);
			variable.get(tabnum).add("alert");
			variable.get(tabnum).add("prompt");

			String translatedText = ctx.declarationseq().accept(this);
			writer.append(translatedText);

			variable.remove(tabnum);
			writer.append("main();\n");
			writer.close();
			fop.close();
		} catch (IOException e) {
			System.out.print("Exception");
		}
		return "";
	}

	@Override
	public String visitDeclarationseq(CParser.DeclarationseqContext ctx) {
		StringBuilder result = new StringBuilder();
		for (CParser.DeclarationContext i : ctx.declaration()) {
			result.append(i.accept(this));
		}
		return result.toString();
	}

	@Override
	public String visitDeclaration(CParser.DeclarationContext ctx) {
		StringBuilder result = new StringBuilder();
		if (ctx.simpleDeclaration() != null) {
			result.append(ctx.simpleDeclaration().accept(this));
		} else if (ctx.functionDefinition() != null) {
			result.append(ctx.functionDefinition().accept(this));
		} else if (ctx.emptyDeclaration() != null) {
			result.append(ctx.emptyDeclaration().accept(this));
		}
		return result.toString();
	}

	@Override
	public String visitEmptyDeclaration(CParser.EmptyDeclarationContext ctx) {
		return "";
	}

	@Override
	public String visitSimpleDeclaration(CParser.SimpleDeclarationContext ctx) {
		StringBuilder result = new StringBuilder();
		// JavaScript中没有函数声明
		CParser.NoPointerDeclaratorContext tempContext = ctx.initDeclaratorList().initDeclarator(0).declarator().noPointerDeclarator();
		if (tempContext.noPointerDeclarator() != null) {
			tempContext = tempContext.noPointerDeclarator();
			String identifierText = tempContext.declaratorid().Identifier().getText();
			if (identifierText.equals("printf") || identifierText.equals("strlen")) {
				return "";
			}
		}
		// --------------------所有的simpleTypeSpecifier都转为let------------------
		if (ctx.simpleTypeSpecifier() != null) {
			result.append("let ");
		}
		if (ctx.initDeclaratorList() != null) {
			result.append(ctx.initDeclaratorList().accept(this));
		}
		result.append(";\n");
		return result.toString();
	}

	@Override
	public String visitInitDeclaratorList(CParser.InitDeclaratorListContext ctx) {
		StringBuilder result = new StringBuilder();
		for (CParser.InitDeclaratorContext i : ctx.initDeclarator()) {
			if (ctx.initDeclarator().indexOf(i) != 0) {
				result.append(", ");
			}
			result.append(i.accept(this));
		}
		return result.toString();
	}

	@Override
	public String visitInitDeclarator(CParser.InitDeclaratorContext ctx) {
		StringBuilder result = new StringBuilder();
		result.append(ctx.declarator().accept(this));
		if (ctx.initializer() != null) {
			result.append(ctx.initializer().accept(this));
		}
		return result.toString();
	}

	@Override
	public String visitDeclarator(CParser.DeclaratorContext ctx) {
		StringBuilder result = new StringBuilder();
		for (CParser.PointerOperatorContext i : ctx.pointerOperator()) {
			result.append(i.accept(this));
		}
		result.append(ctx.noPointerDeclarator().accept(this));
		return result.toString();
	}

	@Override
	public String visitNoPointerDeclarator(CParser.NoPointerDeclaratorContext ctx) {
		StringBuilder result = new StringBuilder();
		if (ctx.declaratorid() != null) {
			result.append(ctx.declaratorid().accept(this));
		} else {
			result.append(ctx.noPointerDeclarator().accept(this));
			if (ctx.parametersAndQualifiers() != null) {
				result.append(ctx.parametersAndQualifiers().accept(this));
			} else {
//                writer.append("[");
//                if (ctx.constantExpression() != null)
//                {
//                    ctx.constantExpression().accept(this);
//                }
//                writer.append("] ");
				result.append(" = []");
			}
		}
		return result.toString();
	}

	@Override
	public String visitPointerOperator(CParser.PointerOperatorContext ctx) {
		StringBuilder result = new StringBuilder();
//        try {
//            if (ctx.And() != null)
//            {
//                writer.append("&");
//            }
//            else if (ctx.Star() != null)
//            {
//                writer.append("*");
//            }
//        }catch (IOException e){
//            System.out.print("Exception about pointerOperator");
//        }
		return result.toString();
	}

	@Override
	public String visitDeclaratorid(CParser.DeclaratoridContext ctx) {
		StringBuilder result = new StringBuilder();
		if (ctx.Identifier().getText().equals("printf")) {
			result.append("alert");
		} else if (ctx.Identifier().getText().equals("scanf")) {
			result.append("prompt");
		} else {
			variable.get(tabnum).add(ctx.Identifier().getText());
			result.append(ctx.Identifier().getText());
		}
		return result.toString();
	}

	@Override
	public String visitParametersAndQualifiers(CParser.ParametersAndQualifiersContext ctx) {
		StringBuilder result = new StringBuilder();
		result.append("(");
		if (ctx.parameterDeclarationClause() != null) {
			result.append(ctx.parameterDeclarationClause().accept(this));
		}
		result.append(")");
		return result.toString();
	}

	@Override
	public String visitParameterDeclarationClause(CParser.ParameterDeclarationClauseContext ctx) {
		StringBuilder result = new StringBuilder();
		result.append(ctx.parameterDeclarationList().accept(this));
		if (ctx.Comma() != null && ctx.Ellipsis() == null) {
			// 对于printf的声明，不处理逗号及其后的省略号这一特殊语法
			result.append(",");
		}
		return result.toString();
	}

	@Override
	public String visitParameterDeclarationList(CParser.ParameterDeclarationListContext ctx) {
		StringBuilder result = new StringBuilder();
		for (CParser.ParameterDeclarationContext i : ctx.parameterDeclaration()) {
			if (ctx.parameterDeclaration().indexOf(i) != 0) {
				result.append(", ");
			}
			result.append(i.accept(this));
		}
		return result.toString();
	}

	@Override
	public String visitParameterDeclaration(CParser.ParameterDeclarationContext ctx) {
		StringBuilder result = new StringBuilder();
		// JavaScript中不需要指定函数参数的类型
		ctx.simpleTypeSpecifier().accept(this);
		result.append(ctx.declarator().accept(this));
		if (ctx.Assign() != null) {
			result.append(" = ");
			result.append(ctx.initializerClause().accept(this));
		}
		return result.toString();
	}

	@Override
	public String visitInitializer(CParser.InitializerContext ctx) {
		StringBuilder result = new StringBuilder();
		result.append(" = ");
		result.append(ctx.initializerClause().accept(this));
		return result.toString();
	}

	@Override
	public String visitInitializerClause(CParser.InitializerClauseContext ctx) {
		StringBuilder result = new StringBuilder();
		if (ctx.assignmentExpression() != null) {
			result.append(ctx.assignmentExpression().accept(this));
		} else if (ctx.bracedInitList() != null) {
			result.append(ctx.bracedInitList().accept(this));
		}
		return result.toString();
	}

	@Override
	public String visitInitializerList(CParser.InitializerListContext ctx) {
		StringBuilder result = new StringBuilder();
		for (CParser.InitializerClauseContext i : ctx.initializerClause()) {
			try {
				if (ctx.initializerClause().indexOf(i) != 0) {
					String firstLiteral = ctx.initializerClause().get(0).assignmentExpression().conditionalExpression()
							.logicalOrExpression().logicalAndExpression(0).equalityExpression(0)
							.relationalExpression(0).shiftExpression(0).additiveExpression(0)
							.multiplicativeExpression(0).unaryExpression(0).postfixExpression()
							.primaryExpression().literal().getText();
					if (!firstLiteral.equals("\"%d\\n\"")) {
						result.append(", ");
					}
				}
				result.append(i.accept(this));
			} catch (NullPointerException ignored) {
				result.append(", ");
				result.append(i.accept(this));
			}
		}
		return result.toString();
	}

	@Override
	public String visitBracedInitList(CParser.BracedInitListContext ctx) {
		StringBuilder result = new StringBuilder();
		result.append("{");
		if (ctx.initializerList() != null) {
			result.append(ctx.initializerList().accept(this));
		}
		result.append("}");
		return result.toString();
	}

	@Override
	public String visitPrimaryExpression(CParser.PrimaryExpressionContext ctx) {
		StringBuilder result = new StringBuilder();
		if (ctx.literal() != null) {
			result.append(ctx.literal().accept(this));
		} else if (ctx.LeftParen() != null) {
			result.append("(");
			result.append(ctx.expression().accept(this));
			result.append(")");
		} else if (ctx.Identifier() != null) {
			String functionName = ctx.Identifier().getText();
			switch (functionName) {
				case "printf":
					result.append("alert");
					break;
				case "scanf":
					result.append("prompt");
					break;
				case "strlen":
					// todo: 考虑如何变为后置.length的形式？
					result.append(functionName);
					break;
				default:
					try{
						boolean declared = false;
						for(int i = 0; i <= tabnum; i++)
						{
							if(variable.get(i).contains(functionName))
							{
								declared = true;
								result.append(functionName);
								break;
							}
						}
						if(!declared)
						{
							ArrayIndexOutOfBoundsException  exception = new ArrayIndexOutOfBoundsException();
							throw exception;
						}
					}catch(ArrayIndexOutOfBoundsException e){
						System.out.println("错误！未定义的变量使用。\n");
					}
					break;
			}
		}
		return result.toString();
	}

	@Override
	public String visitPostfixExpression(CParser.PostfixExpressionContext ctx) {
		StringBuilder result = new StringBuilder();
		if (ctx.primaryExpression() != null) {
			result.append(ctx.primaryExpression().accept(this));
		} else {
			result.append(ctx.postfixExpression().accept(this));
			if (ctx.LeftBracket() != null) {
				result.append("[");
				result.append(ctx.expression().accept(this));
				result.append("]");
			} else if (ctx.LeftParen() != null) {
				result.append("(");
				if (ctx.expressionList() != null) {
					result.append(ctx.expressionList().accept(this));
				}
				result.append(")");
			} else if (ctx.PlusPlus() != null) {
				result.append("++");
			} else if (ctx.MinusMinus() != null) {
				result.append("--");
			}
		}
		return result.toString();
	}

	@Override
	public String visitExpressionList(CParser.ExpressionListContext ctx) {
		StringBuilder result = new StringBuilder();
		result.append(ctx.initializerList().accept(this));
		return result.toString();
	}

	@Override
	public String visitUnaryExpression(CParser.UnaryExpressionContext ctx) {
		StringBuilder result = new StringBuilder();
		if (ctx.postfixExpression() != null) {
			result.append(ctx.postfixExpression().accept(this));
		} else {
			if (ctx.PlusPlus() != null) {
				result.append("++");
			} else if (ctx.MinusMinus() != null) {
				result.append("--");
			} else if (ctx.Sizeof() != null) {
				// -----------------------sizeof对应什么？---------------------
			} else if (ctx.unaryOperator() != null) {
				result.append(ctx.unaryOperator().accept(this));
			}
			result.append(ctx.unaryExpression().accept(this));
		}
		return result.toString();
	}

	@Override
	public String visitUnaryOperator(CParser.UnaryOperatorContext ctx) {
		StringBuilder result = new StringBuilder();
		if (ctx.Or() != null) {
			result.append("|");
		} else if (ctx.Star() != null) {
			result.append("*");
		} else if (ctx.And() != null) {
			result.append("&");
		} else if (ctx.Plus() != null) {
			result.append("+");
		} else if (ctx.Tilde() != null) {
			result.append("~");
		} else if (ctx.Minus() != null) {
			result.append("-");
		} else if (ctx.Not() != null) {
			result.append("!");
		}
		return result.toString();
	}

	@Override
	public String visitMultiplicativeExpression(CParser.MultiplicativeExpressionContext ctx) {
		StringBuilder result = new StringBuilder();
		for (CParser.UnaryExpressionContext i : ctx.unaryExpression()) {
			if (ctx.unaryExpression().indexOf(i) != 0) {
				if (!ctx.Star().isEmpty()) {
					result.append("*");
				} else if (!ctx.Div().isEmpty()) {
					result.append("/");
				} else if (!ctx.Mod().isEmpty()) {
					result.append("%");
				}
			}
			result.append(i.accept(this));
		}
		return result.toString();
	}

	@Override
	public String visitAdditiveExpression(CParser.AdditiveExpressionContext ctx) {
		StringBuilder result = new StringBuilder();
		for (CParser.MultiplicativeExpressionContext i : ctx.multiplicativeExpression()) {
			if (ctx.multiplicativeExpression().indexOf(i) != 0) {
				if (!ctx.Plus().isEmpty()) {
					result.append(" + ");
				} else if (!ctx.Minus().isEmpty()) {
					result.append(" - ");
				}
			}
			result.append(i.accept(this));
		}
		return result.toString();
	}

	@Override
	public String visitShiftExpression(CParser.ShiftExpressionContext ctx) {
		StringBuilder result = new StringBuilder();
		for (CParser.AdditiveExpressionContext i : ctx.additiveExpression()) {
			if (ctx.additiveExpression().indexOf(i) != 0) {
				for (CParser.ShiftOperatorContext j : ctx.shiftOperator()) {
					result.append(j.getChild(0).accept(this));
				}
			}
			result.append(i.accept(this));
		}
		return result.toString();
	}

	@Override
	public String visitShiftOperator(CParser.ShiftOperatorContext ctx) {
		StringBuilder result = new StringBuilder();
		if (ctx.Greater() != null) {
			result.append(" >> ");
		} else if (ctx.Less() != null) {
			result.append(" << ");
		}
		return result.toString();
	}

	@Override
	public String visitRelationalExpression(CParser.RelationalExpressionContext ctx) {
		StringBuilder result = new StringBuilder();
		for (CParser.ShiftExpressionContext i : ctx.shiftExpression()) {
			if (ctx.shiftExpression().indexOf(i) != 0) {
				if (ctx.Less() != null) {
					result.append(" < ");
				} else if (ctx.Greater() != null) {
					result.append(" > ");
				} else if (ctx.LessEqual() != null) {
					result.append(" <= ");
				} else if (ctx.GreaterEqual() != null) {
					result.append(" >= ");
				}
			}
			result.append(i.accept(this));
		}
		return result.toString();
	}

	@Override
	public String visitEqualityExpression(CParser.EqualityExpressionContext ctx) {
		StringBuilder result = new StringBuilder();
		for (CParser.RelationalExpressionContext i : ctx.relationalExpression()) {
			if (ctx.relationalExpression().indexOf(i) != 0) {
				if (!ctx.Equal().isEmpty()) {
					result.append(" == ");
				} else if (!ctx.NotEqual().isEmpty()) {
					result.append(" != ");
				}
			}
			result.append(i.accept(this));
		}
		return result.toString();
	}

	@Override
	public String visitLogicalAndExpression(CParser.LogicalAndExpressionContext ctx) {
		StringBuilder result = new StringBuilder();
		for (CParser.EqualityExpressionContext i : ctx.equalityExpression()) {
			if (ctx.equalityExpression().indexOf(i) != 0) {
				result.append(" && ");
			}
			result.append(i.accept(this));
		}
		return result.toString();
	}

	@Override
	public String visitLogicalOrExpression(CParser.LogicalOrExpressionContext ctx) {
		StringBuilder result = new StringBuilder();
		for (CParser.LogicalAndExpressionContext i : ctx.logicalAndExpression()) {
			if (ctx.logicalAndExpression().indexOf(i) != 0) {
				result.append(" || ");
			}
			result.append(i.accept(this));
		}
		return result.toString();
	}

	@Override
	public String visitConditionalExpression(CParser.ConditionalExpressionContext ctx) {
		StringBuilder result = new StringBuilder();
		result.append(ctx.logicalOrExpression().accept(this));
		if (ctx.Question() != null) {
			// ------------------三元表达式--------------------
			result.append(" ? ");
			result.append(ctx.expression().accept(this));
			result.append(" : ");
			result.append(ctx.assignmentExpression().accept(this));
		}
		return result.toString();
	}

	@Override
	public String visitAssignmentExpression(CParser.AssignmentExpressionContext ctx) {
		StringBuilder result = new StringBuilder();
		if (ctx.conditionalExpression() != null) {
			result.append(ctx.conditionalExpression().accept(this));
		} else {
			result.append(ctx.logicalOrExpression().accept(this));
			result.append(ctx.assignmentOperator().accept(this));
			result.append(ctx.initializerClause().accept(this));
		}
		return result.toString();
	}

	@Override
	public String visitAssignmentOperator(CParser.AssignmentOperatorContext ctx) {
		StringBuilder result = new StringBuilder();
		if (ctx.Assign() != null) {
			result.append("=");
		} else if (ctx.StarAssign() != null) {
			result.append("*=");
		} else if (ctx.DivAssign() != null) {
			result.append("/=");
		} else if (ctx.ModAssign() != null) {
			result.append("&=");
		} else if (ctx.PlusAssign() != null) {
			result.append("+=");
		} else if (ctx.MinusAssign() != null) {
			result.append("-=");
		} else if (ctx.RightShiftAssign() != null) {
			result.append(">>=");
		} else if (ctx.LeftShiftAssign() != null) {
			result.append("<<=");
		} else if (ctx.AndAssign() != null) {
			result.append("&=");
		} else if (ctx.XorAssign() != null) {
			result.append("^=");
		} else if (ctx.OrAssign() != null) {
			result.append("|=");
		}
		return result.toString();
	}

	@Override
	public String visitExpression(CParser.ExpressionContext ctx) {
		StringBuilder result = new StringBuilder();
		for (CParser.AssignmentExpressionContext i : ctx.assignmentExpression()) {
			if (ctx.assignmentExpression().indexOf(i) != 0) {
				result.append(", ");
			}
			result.append(i.accept(this));
		}
		return result.toString();
	}

	@Override
	public String visitConstantExpression(CParser.ConstantExpressionContext ctx) {
		StringBuilder result = new StringBuilder();
		result.append(ctx.conditionalExpression().accept(this));
		return result.toString();
	}

	@Override
	public String visitFunctionDefinition(CParser.FunctionDefinitionContext ctx) {
		StringBuilder result = new StringBuilder();
		result.append("function ");
		result.append(ctx.declarator().accept(this));
		result.append(" {\n");
		tabnum++;
		if(variable.size() < tabnum+1)
		{
			Set tmp = new HashSet();
			variable.add(tmp);
		}
		result.append(ctx.compoundStatement().accept(this));
		if(variable.size() < tabnum+1)
		{
			variable.remove(tabnum);
		}
		tabnum--;
		result.append("}\n");
		return result.toString();
	}

	@Override
	public String visitStatementSeq(CParser.StatementSeqContext ctx) {
		StringBuilder result = new StringBuilder();
		for (CParser.StatementContext i : ctx.statement()) {
			for(int j = 0; j < tabnum; j++)	result.append("\t");
			result.append(i.accept(this));
		}
		return result.toString();
	}

	// 不用vistStatement函数去手动分发，其子类会自动调用重写函数

	@Override
	public String visitLabeledStatement(CParser.LabeledStatementContext ctx) {
		StringBuilder result = new StringBuilder();
		return result.toString();
	}

	@Override
	public String visitExpressionStatement(CParser.ExpressionStatementContext ctx) {
		StringBuilder result = new StringBuilder();
		if (ctx.expression() != null) {
			result.append(ctx.expression().accept(this));
		}
		result.append(";\n");
		return result.toString();
	}

	@Override
	public String visitCompoundStatement(CParser.CompoundStatementContext ctx) {
		StringBuilder result = new StringBuilder();
		if (ctx.statementSeq() != null) {
			result.append(ctx.statementSeq().accept(this));
		}
		return result.toString();
	}

	@Override
	public String visitSelectionStatement(CParser.SelectionStatementContext ctx) {
		StringBuilder result = new StringBuilder();
		if (ctx.If() != null) {
			// if
			tabnum++;
			if(variable.size() < tabnum+1)
			{
				Set tmp = new HashSet();
				variable.add(tmp);
			}
			result.append("if (");
			result.append(ctx.condition().accept(this));
			result.append(")\n");
			for(int i = 0; i < tabnum-1; i++)	result.append("\t");
			result.append("{\n");
			result.append(ctx.statement(0).accept(this));
			for(int i = 0; i < tabnum-1; i++)	result.append("\t");
			result.append("}\n");
			if (ctx.Else() != null) {
				for(int i = 0; i < tabnum-1; i++)	result.append("\t");
				result.append("else\n");
				for(int i = 0; i < tabnum-1; i++)	result.append("\t");
				result.append("{\n");
				result.append(ctx.statement(1).accept(this));
				for(int i = 0; i < tabnum-1; i++)	result.append("\t");
				result.append("}\n");
			}
			if(variable.size() < tabnum+1)
			{
				variable.remove(tabnum);
			}
			tabnum--;
		} else {
			// switch
		}
		return result.toString();
	}

	@Override
	public String visitIterationStatement(CParser.IterationStatementContext ctx) {
		StringBuilder result = new StringBuilder();
		if (ctx.Do() != null) {
			// do while
		} else if (ctx.For() != null) {
			// for
			tabnum++;
			if(variable.size() < tabnum+1)
			{
				Set tmp = new HashSet();
				variable.add(tmp);
			}
			result.append("for (");
			result.append(ctx.forInitStatement().accept(this));
			result.deleteCharAt(result.length()-1);
			result.append(" ");
			result.append(ctx.condition().accept(this));
			result.append("; ");
			result.append(ctx.expression().accept(this));
			result.append(")\n");
			for(int i = 0; i < tabnum-1; i++)	result.append("\t");
			result.append("{\n");
			result.append(ctx.statement().accept(this));
			for(int i = 0; i < tabnum-1; i++)	result.append("\t");
			result.append("}\n");
			if(variable.size() < tabnum+1)
			{
				variable.remove(tabnum);
			}
			tabnum--;
		} else {
			// while
			tabnum++;
			if(variable.size() < tabnum+1)
			{
				Set tmp = new HashSet();
				variable.add(tmp);
			}
			result.append("while (");
			result.append(ctx.condition().accept(this));
			result.append(")\n");
			for(int i = 0; i < tabnum-1; i++)	result.append("\t");
			result.append("{\n");
			result.append(ctx.statement().accept(this));
			for(int i = 0; i < tabnum-1; i++)	result.append("\t");
			result.append("}\n");
			if(variable.size() < tabnum+1)
			{
				variable.remove(tabnum);
			}
			tabnum--;
		}
		return result.toString();
	}

	@Override
	public String visitForInitStatement(CParser.ForInitStatementContext ctx) {
		StringBuilder result = new StringBuilder();
		if (ctx.expressionStatement() != null) {
			result.append(ctx.expressionStatement().accept(this));
		} else if (ctx.simpleDeclaration() != null) {
			result.append(ctx.simpleDeclaration().accept(this));
		}
		return result.toString();
	}

	@Override
	public String visitJumpStatement(CParser.JumpStatementContext ctx) {
		StringBuilder result = new StringBuilder();
		if (ctx.Break() != null) {
			// break;
			result.append("break;\n");
		} else if (ctx.Continue() != null) {
			// continue
			result.append("continue;\n");
		} else if (ctx.Return() != null) {
			// return
			result.append("return ");
			if (ctx.expression() != null) result.append(ctx.expression().accept(this));
			else if (ctx.bracedInitList() != null) result.append(ctx.bracedInitList().accept(this));
			result.append(";\n");
		}
		return result.toString();
	}

	@Override
	public String visitDeclarationStatement(CParser.DeclarationStatementContext ctx) {
		StringBuilder result = new StringBuilder();
		result.append(ctx.simpleDeclaration().accept(this));
		return result.toString();
	}

	@Override
	public String visitCondition(CParser.ConditionContext ctx) {
		StringBuilder result = new StringBuilder();
		result.append(ctx.expression().accept(this));
		return result.toString();
	}

	@Override
	public String visitLiteral(CParser.LiteralContext ctx) {
		StringBuilder result = new StringBuilder();
		if (!ctx.getText().equals("\"%d\\n\"")) {
			// 删除流控制符
			result.append(ctx.getText());
		}
		return result.toString();
	}
}
