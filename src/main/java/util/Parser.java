package util;

import parser.CParser;
import parser.CParserBaseVisitor;

// 重载CParserBaseVisitor中的函数
public class Parser extends CParserBaseVisitor<Integer> {

    @Override
    public Integer visitTranslationUnit(CParser.TranslationUnitContext ctx) {
        ctx.declarationseq().accept(this);
        return super.visitTranslationUnit(ctx);
    }

    @Override
    public Integer visitDeclarationseq(CParser.DeclarationseqContext ctx) {
        for (CParser.DeclarationContext i:ctx.declaration()) {
            i.getChild(0).accept(this);
        }
        return super.visitDeclarationseq(ctx);
    }

    @Override
    public Integer visitSimpleDeclaration(CParser.SimpleDeclarationContext ctx) {
        ctx.simpleTypeSpecifier().getText();
        return super.visitSimpleDeclaration(ctx);
    }

    @Override
    public Integer visitFunctionDefinition(CParser.FunctionDefinitionContext ctx) {
        return super.visitFunctionDefinition(ctx);
    }

    @Override
    public Integer visitStatementSeq(CParser.StatementSeqContext ctx) {
        for (CParser.StatementContext i: ctx.statement())
        {
            i.getChild(0).accept(this);
        }
        return super.visitStatementSeq(ctx);
    }

    @Override
    public Integer visitLabeledStatement(CParser.LabeledStatementContext ctx) {
        return super.visitLabeledStatement(ctx);
    }

    @Override
    public Integer visitExpression(CParser.ExpressionContext ctx) {
        return super.visitExpression(ctx);
    }

    @Override
    public Integer visitCompoundStatement(CParser.CompoundStatementContext ctx) {
        return super.visitCompoundStatement(ctx);
    }

    @Override
    public Integer visitSelectionStatement(CParser.SelectionStatementContext ctx) {
        if (ctx.If() != null)
        {
            // if
        }
        else
        {
            // switch
        }
        return super.visitSelectionStatement(ctx);
    }

    @Override
    public Integer visitIterationStatement(CParser.IterationStatementContext ctx) {
        if (ctx.Do() != null)
        {
            // do while
        }
        else if (ctx.For() != null)
        {
            // for
        }
        else
        {
            // while
        }
        return super.visitIterationStatement(ctx);
    }

    @Override
    public Integer visitJumpStatement(CParser.JumpStatementContext ctx) {
        if (ctx.Break() != null)
        {
            // break;
        }
        else if (ctx.Continue() != null)
        {
            // continue
        }
        else if (ctx.Return() != null)
        {
            // return
        }
        return super.visitJumpStatement(ctx);
    }

    @Override
    public Integer visitDeclarationStatement(CParser.DeclarationStatementContext ctx) {
        return super.visitDeclarationStatement(ctx);
    }

}
