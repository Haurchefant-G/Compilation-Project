package util;

import parser.CParser;
import parser.CParserBaseVisitor;

import java.io.*;
// 重载CParserBaseVisitor中的函数
public class Parser extends CParserBaseVisitor<Integer> {
    File f;
    FileOutputStream fop;
    OutputStreamWriter writer;

    @Override
    public Integer visitTranslationUnit(CParser.TranslationUnitContext ctx) {
            try {
                f = new File("results.txt");
                fop = new FileOutputStream(f);
                writer = new OutputStreamWriter(fop, "UTF-8");
                ctx.declarationseq().accept(this);
                writer.append("main();\n");
                writer.close();
                fop.close();
            }catch (IOException e) {
                System.out.print("Exception");
            }

        return 0;
    }

    @Override
    public Integer visitDeclarationseq(CParser.DeclarationseqContext ctx) {
        for (CParser.DeclarationContext i: ctx.declaration()) {
            i.accept(this);
        }
        return 0;
    }

    @Override
    public Integer visitDeclaration(CParser.DeclarationContext ctx) {
        if (ctx.simpleDeclaration() != null)
        {
            ctx.simpleDeclaration().accept(this);
        }
        else if (ctx.functionDefinition() != null)
        {
            ctx.functionDefinition().accept(this);
        }
        else if (ctx.emptyDeclaration() != null)
        {
            ctx.emptyDeclaration().accept(this);
        }
        return 0;
    }

    @Override
    public Integer visitEmptyDeclaration(CParser.EmptyDeclarationContext ctx) {
        return 0;
    }

    @Override
    public Integer visitSimpleDeclaration(CParser.SimpleDeclarationContext ctx) {
        try {
            // --------------------所有的simpleTypeSpecifier都转为let------------------
            if (ctx.simpleTypeSpecifier() != null)
            {
                writer.append("let ");
            }
            if (ctx.initDeclaratorList() != null)
            {
                ctx.initDeclaratorList().accept(this);
            }
            writer.append(";\n");
        }catch (IOException e){
            System.out.print("Exception about SimpleDeclaration");
        }
        return 0;
    }

    @Override
    public Integer visitInitDeclaratorList(CParser.InitDeclaratorListContext ctx) {
        for (CParser.InitDeclaratorContext i: ctx.initDeclarator())
        {
            if (ctx.initDeclarator().indexOf(i) != 0)
            {
                try {
                    writer.append(", ");
                }catch (IOException e){
                    System.out.print("Exception about InitDeclaratorList");
                }
            }
            i.accept(this);
        }
        return 0;
    }

    @Override
    public Integer visitInitDeclarator(CParser.InitDeclaratorContext ctx) {
        ctx.declarator().accept(this);
        if( ctx.initializer() != null)
        {
           ctx.initializer().accept(this);
        }
        return 0;
    }

    @Override
    public Integer visitDeclarator(CParser.DeclaratorContext ctx) {
        for (CParser.PointerOperatorContext i: ctx.pointerOperator())
        {
            i.accept(this);
        }
        ctx.noPointerDeclarator().accept(this);
        return 0;
    }

    @Override
    public Integer visitNoPointerDeclarator(CParser.NoPointerDeclaratorContext ctx) {
        if (ctx.declaratorid() != null)
        {
            ctx.declaratorid().accept(this);
        }
        else
        {
            ctx.noPointerDeclarator().accept(this);
            if (ctx.parametersAndQualifiers() != null)
            {
                ctx.parametersAndQualifiers().accept(this);
            }
            else
            {
                try {
//                    writer.append("[");
//                    if (ctx.constantExpression() != null)
//                    {
//                        ctx.constantExpression().accept(this);
//                    }
//                    writer.append("] ");
                    writer.append(" = new Array()");
                }catch (IOException e){
                    System.out.print("Exception about noPointerOperator");
                }
            }
        }
        return 0;
    }

    @Override
    public Integer visitPointerOperator(CParser.PointerOperatorContext ctx) {
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
        return 0;
    }

    @Override
    public Integer visitDeclaratorid(CParser.DeclaratoridContext ctx) {
        try {
            if(ctx.Identifier().getText().equals("printf"))
            {
                writer.append("alert");
            }
            else if (ctx.Identifier().getText().equals("scanf"))
            {
                writer.append("prompt");
            }
            else
            {
                writer.append(ctx.Identifier().getText());
            }
        }catch (IOException e){
            System.out.print("Exception about Declaratorid");
        }
        return 0;
    }

    @Override
    public Integer visitParametersAndQualifiers(CParser.ParametersAndQualifiersContext ctx) {
        try {
            writer.append("(");
            if (ctx.parameterDeclarationClause() != null)
            {
                ctx.parameterDeclarationClause().accept(this);
            }
            writer.append(")");
        }catch (IOException e){
            System.out.print("Exception about Declaratorid");
        }
        return 0;
    }

    @Override
    public Integer visitParameterDeclarationClause(CParser.ParameterDeclarationClauseContext ctx) {
        ctx.parameterDeclarationList().accept(this);
        try {
            if (ctx.Comma() != null)
            {
                writer.append(",");
            }
            else if (ctx.Ellipsis() != null)
            {
                writer.append("...");
            }
        }catch (IOException e){
            System.out.print("Exception about parameterDeclarationClause");
        }
        return 0;
    }

    @Override
    public Integer visitParameterDeclarationList(CParser.ParameterDeclarationListContext ctx) {
        for (CParser.ParameterDeclarationContext i: ctx.parameterDeclaration())
        {
            if (ctx.parameterDeclaration().indexOf(i) != 0)
            {
                try {
                    writer.append(", ");
                }catch (IOException e){
                    System.out.print("Exception about parameterDeclarationList");
                }
            }
            i.accept(this);
        }
        return 0;
    }

    @Override
    public Integer visitParameterDeclaration(CParser.ParameterDeclarationContext ctx) {
        ctx.simpleTypeSpecifier().accept(this);
        ctx.declarator().accept(this);
        if (ctx.Assign() != null)
        {
            try {
                writer.append("= ");
                ctx.initializerClause().accept(this);
            }catch (IOException e){
                System.out.print("Exception about parameterDeclaration");
            }
        }
        return 0;
    }

    @Override
    public Integer visitInitializer(CParser.InitializerContext ctx) {
        try {
            writer.append("= ");
            ctx.initializerClause().accept(this);
        }catch (IOException e){
            System.out.print("Exception about Initilalizer");
        }
        return 0;
    }

    @Override
    public Integer visitInitializerClause(CParser.InitializerClauseContext ctx) {
        if (ctx.assignmentExpression() != null)
        {
            ctx.assignmentExpression().accept(this);
        }
        else if (ctx.bracedInitList() != null)
        {
            ctx.bracedInitList().accept(this);
        }
        return 0;
    }

    @Override
    public Integer visitInitializerList(CParser.InitializerListContext ctx) {
        for (CParser.InitializerClauseContext i: ctx.initializerClause())
        {
            if (ctx.initializerClause().indexOf(i) != 0)
            {
                try {
                    writer.append(", ");
                }catch (IOException e){
                    System.out.print("Exception about InitializerList");
                }
            }
            i.accept(this);
        }
        return 0;
    }

    @Override
    public Integer visitBracedInitList(CParser.BracedInitListContext ctx) {
        try {
            writer.append("{");
            if (ctx.initializerList() != null)
            {
                ctx.initializerList().accept(this);
            }
            writer.append("}");
        }catch (IOException e){
            System.out.print("Exception about bracedInitList");
        }
        return 0;
    }

    @Override
    public Integer visitPrimaryExpression(CParser.PrimaryExpressionContext ctx) {
        if (ctx.literal() != null)
        {
            ctx.literal().accept(this);
        }
        else if (ctx.LeftParen() != null)
        {
            try {
                writer.append("(");
                ctx.expression().accept(this);
                writer.append(")");
            }catch (IOException e){
                System.out.print("Exception about primaryExpression");
            }
        }
        else if (ctx.Identifier() != null)
        {
            try {
                if(ctx.Identifier().getText().equals("printf"))
                {
                    writer.append("alert");
                }
                else if (ctx.Identifier().getText().equals("scanf"))
                {
                    writer.append("prompt");
                }
                else
                {
                    writer.append(ctx.Identifier().getText());
                }
            }catch (IOException e){
                System.out.print("Exception about Declaratorid");
            }
        }
        return 0;
    }

    @Override
    public Integer visitPostfixExpression(CParser.PostfixExpressionContext ctx) {
        if (ctx.primaryExpression() != null)
        {
            ctx.primaryExpression().accept(this);
        }
        else
        {
            ctx.postfixExpression().accept(this);
            try {
                if (ctx.LeftBracket() != null)
                {
                    writer.append("[");
                    ctx.expression().accept(this);
                    writer.append("] ");
                }
                else if (ctx.LeftParen() != null)
                {
                    writer.append("(");
                    if (ctx.expressionList() != null)
                    {
                        ctx.expressionList().accept(this);
                    }
                    writer.append(")");
                }
                else if (ctx.PlusPlus() != null)
                {
                    writer.append("++");
                }
                else if (ctx.MinusMinus() != null)
                {
                    writer.append("--");
                }
            }catch (IOException e){
                System.out.print("Exception about postfixExpression");
            }
        }
        return 0;
    }

    @Override
    public Integer visitExpressionList(CParser.ExpressionListContext ctx) {
        ctx.initializerList().accept(this);
        return 0;
    }

    @Override
    public Integer visitUnaryExpression(CParser.UnaryExpressionContext ctx) {
        if (ctx.postfixExpression() != null)
        {
            ctx.postfixExpression().accept(this);
        }
        else
        {
            try {
                if(ctx.PlusPlus() != null)
                {
                    writer.append("++");
                }
                else if (ctx.MinusMinus() != null)
                {
                    writer.append("--");
                }
                else if (ctx.Sizeof() != null)
                {
                    // -----------------------sizeof对应什么？---------------------
                }
                else if (ctx.unaryOperator() != null)
                {
                    ctx.unaryOperator().accept(this);
                }
                ctx.unaryExpression().accept(this);
            }catch (IOException e){
                System.out.print("Exception about unaryExpression");
            }
        }
        return 0;
    }

    @Override
    public Integer visitUnaryOperator(CParser.UnaryOperatorContext ctx) {
        try {
            if(ctx.Or() != null)
            {
                writer.append("|");
            }
            else if (ctx.Star() != null)
            {
                writer.append("*");
            }
            else if (ctx.And() != null)
            {
                writer.append("&");
            }
            else if (ctx.Plus() != null)
            {
                writer.append("+");
            }
            else if (ctx.Tilde() != null)
            {
                writer.append("~");
            }
            else if (ctx.Minus() != null)
            {
                writer.append("-");
            }
            else if (ctx.Not() != null)
            {
                writer.append("!");
            }
        }catch (IOException e){
            System.out.print("Exception about unaryOperator");
        }
        return 0;
    }

    @Override
    public Integer visitMultiplicativeExpression(CParser.MultiplicativeExpressionContext ctx) {
        for (CParser.UnaryExpressionContext i: ctx.unaryExpression())
        {
            if (ctx.unaryExpression().indexOf(i) != 0)
            {
                try {
                    if(ctx.Star() != null)
                    {
                        writer.append("*");
                    }
                    else if (ctx.Div() != null)
                    {
                        writer.append("/");
                    }
                    else if (ctx.Mod() != null)
                    {
                        writer.append("%");
                    }
                }catch (IOException e){
                    System.out.print("Exception about multiplicativeExpression");
                }
            }
            i.accept(this);
        }
        return 0;
    }

    @Override
    public Integer visitAdditiveExpression(CParser.AdditiveExpressionContext ctx) {
        for (CParser.MultiplicativeExpressionContext i: ctx.multiplicativeExpression())
        {
            if (ctx.multiplicativeExpression().indexOf(i) != 0)
            {
                try {
                    if(ctx.Plus() != null)
                    {
                        writer.append("+");
                    }
                    else if (ctx.Minus() != null)
                    {
                        writer.append("-");
                    }
                }catch (IOException e){
                    System.out.print("Exception about additiveExpression");
                }
            }
            i.accept(this);
        }
        return 0;
    }

    @Override
    public Integer visitShiftExpression(CParser.ShiftExpressionContext ctx) {
        for (CParser.AdditiveExpressionContext i: ctx.additiveExpression())
        {
            if (ctx.additiveExpression().indexOf(i) != 0)
            {
                for (CParser.ShiftOperatorContext j: ctx.shiftOperator())
                {
                    j.getChild(0).accept(this);
                }
            }
            i.accept(this);
        }
        return 0;
    }

    @Override
    public Integer visitShiftOperator(CParser.ShiftOperatorContext ctx) {
        try {
            if(ctx.Greater() != null)
            {
                writer.append(">> ");
            }
            else if (ctx.Less() != null)
            {
                writer.append("<< ");
            }
        }catch (IOException e){
            System.out.print("Exception about shiftOperator");
        }
        return 0;
    }

    @Override
    public Integer visitRelationalExpression(CParser.RelationalExpressionContext ctx) {
        for (CParser.ShiftExpressionContext i: ctx.shiftExpression())
        {
            if (ctx.shiftExpression().indexOf(i) != 0)
            {
                try {
                    if(ctx.Less() != null)
                    {
                        writer.append("< ");
                    }
                    else if (ctx.Greater() != null)
                    {
                        writer.append("> ");
                    }
                    else if (ctx.LessEqual() != null)
                    {
                        writer.append("<= ");
                    }
                    else if (ctx.GreaterEqual() != null)
                    {
                        writer.append(">= ");
                    }
                }catch (IOException e){
                    System.out.print("Exception about equalityExpression");
                }
            }
            i.accept(this);
        }
        return 0;
    }

    @Override
    public Integer visitEqualityExpression(CParser.EqualityExpressionContext ctx) {
        for (CParser.RelationalExpressionContext i: ctx.relationalExpression())
        {
            if (ctx.relationalExpression().indexOf(i) != 0)
            {
                try {
                    if(ctx.Equal() != null)
                    {
                        writer.append("== ");
                    }
                    else if (ctx.NotEqual() != null)
                    {
                        writer.append("!= ");
                    }
                }catch (IOException e){
                    System.out.print("Exception about equalityExpression");
                }
            }
            i.accept(this);
        }
        return 0;
    }

    @Override
    public Integer visitLogicalAndExpression(CParser.LogicalAndExpressionContext ctx) {
        for (CParser.EqualityExpressionContext i: ctx.equalityExpression())
        {
            if (ctx.equalityExpression().indexOf(i) != 0)
            {
                try {
                    writer.append("&& ");
                }catch (IOException e){
                    System.out.print("Exception about logicalAndExpression");
                }
            }
            i.accept(this);
        }
        return 0;
    }

    @Override
    public Integer visitLogicalOrExpression(CParser.LogicalOrExpressionContext ctx) {
        for (CParser.LogicalAndExpressionContext i: ctx.logicalAndExpression())
        {
            if (ctx.logicalAndExpression().indexOf(i) != 0)
            {
                try {
                    writer.append("|| ");
                }catch (IOException e){
                    System.out.print("Exception about logicalOrExpression");
                }
            }
            i.accept(this);
        }
        return 0;
    }

    @Override
    public Integer visitConditionalExpression(CParser.ConditionalExpressionContext ctx) {
        ctx.logicalOrExpression().accept(this);
        if (ctx.Question() != null)
        {
            // ------------------三元表达式--------------------
            try {
                writer.append("? ");
                ctx.expression().accept(this);
                writer.append(": ");
                ctx.assignmentExpression().accept(this);
            }catch (IOException e){
                System.out.print("Exception about logicalOrExpression");
            }
        }
        return 0;
    }

    @Override
    public Integer visitAssignmentExpression(CParser.AssignmentExpressionContext ctx) {
        if (ctx.conditionalExpression() != null)
        {
            ctx.conditionalExpression().accept(this);
        }
        else
        {
            ctx.logicalOrExpression().accept(this);
            ctx.assignmentOperator().accept(this);
            ctx.initializerClause().accept(this);
        }
        return 0;
    }

    @Override
    public Integer visitAssignmentOperator(CParser.AssignmentOperatorContext ctx) {
        try {
            if (ctx.Assign() != null)
            {
                writer.append("=");
            }
            else if (ctx.StarAssign() != null)
            {
                writer.append("*=");
            }
            else if (ctx.DivAssign() != null)
            {
                writer.append("/=");
            }
            else if (ctx.ModAssign() != null)
            {
                writer.append("&=");
            }
            else  if (ctx.PlusAssign() != null)
            {
                writer.append("+=");
            }
            else if (ctx.MinusAssign() != null)
            {
                writer.append("-=");
            }
            else if (ctx.RightShiftAssign() != null)
            {
                writer.append(">>=");
            }
            else if (ctx.LeftShiftAssign() != null)
            {
                writer.append("<<=");
            }
            else if (ctx.AndAssign() != null)
            {
                writer.append("&=");
            }
            else if (ctx.XorAssign() != null)
            {
                writer.append("^=");
            }
            else if (ctx.OrAssign() != null)
            {
                writer.append("|=");
            }
        }catch (IOException e){
            System.out.print("Exception about primaryExpression");
        }
        return 0;
    }

    @Override
    public Integer visitExpression(CParser.ExpressionContext ctx) {
        for (CParser.AssignmentExpressionContext i: ctx.assignmentExpression())
        {
            if (ctx.assignmentExpression().indexOf(i) != 0)
            {
                try {
                    writer.append(", ");
                }catch (IOException e){
                    System.out.print("Exception about visitExpression");
                }
            }
            i.accept(this);
        }
        return 0;
    }

    @Override
    public Integer visitConstantExpression(CParser.ConstantExpressionContext ctx) {
        ctx.conditionalExpression().accept(this);
        return 0;
    }

    @Override
    public Integer visitFunctionDefinition(CParser.FunctionDefinitionContext ctx) {
        try {
            writer.append("function ");
            ctx.declarator().accept(this);
            writer.append(" {\n");
            ctx.compoundStatement().accept(this);
            writer.append("}\n");
        }catch (IOException e){
            System.out.print("Exception about FunctionDefinition");
        }
        return 0;
    }

    @Override
    public Integer visitStatementSeq(CParser.StatementSeqContext ctx) {
        for (CParser.StatementContext i: ctx.statement())
        {
            i.accept(this);
        }
        return 0;
    }

    // 不用vistStatement函数去手动分发，其子类会自动调用重写函数

    // ----------------------------------待完成------------------------------------
    @Override
    public Integer visitLabeledStatement(CParser.LabeledStatementContext ctx) {
        return 0;
    }

    @Override
    public Integer visitExpressionStatement(CParser.ExpressionStatementContext ctx) {
        if (ctx.expression() != null)
        {
            ctx.expression().accept(this);
        }
        try {
            writer.append(";\n");
        } catch (IOException e){
            System.out.print("Exception about expressionStatement");
        }
        return 0;
    }

    @Override
    public Integer visitCompoundStatement(CParser.CompoundStatementContext ctx) {
        if (ctx.statementSeq() != null) {
            ctx.statementSeq().accept(this);
        }
        return 0;
    }

    @Override
    public Integer visitSelectionStatement(CParser.SelectionStatementContext ctx) {
        if (ctx.If() != null)
        {
            try {
                writer.append("if (");
                ctx.condition().accept(this);
                writer.append(")\n");
                writer.append("{\n");
                ctx.statement(0).accept(this);
                writer.append("}\n");
                if (ctx.Else() != null)
                {
                    writer.append("else\n");
                    writer.append("{\n");
                    ctx.statement(1).accept(this);
                    writer.append("}\n");
                }
            }catch (IOException e){
                System.out.print("Exception about visitSelectionStatement");
            }
            // if
        }
        else
        {
            // switch
        }
        return 0;
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
            try {
                writer.append("for (");
                ctx.forInitStatement().accept(this);
                writer.append(";\n");
                ctx.condition().accept(this);
                writer.append(";\n");
                ctx.expression().accept(this);
                writer.append(")\n");
                writer.append("{\n");
                ctx.statement().accept(this);
                writer.append("}\n");
            }catch (IOException e){
                System.out.print("Exception about visitIterationStatement");
            }
        }
        else
        {
            // while
            try {
                writer.append("while (");
                ctx.condition().accept(this);
                writer.append(")\n");
                writer.append("{\n");
                ctx.statement().accept(this);
                writer.append("}\n");
            }catch (IOException e){
                System.out.print("Exception about visitIterationStatement");
            }
        }
        return 0;
    }

    @Override
    public Integer visitForInitStatement(CParser.ForInitStatementContext ctx) {
        if (ctx.expressionStatement() != null)
        {
            ctx.expressionStatement().accept(this);
        }
        else if (ctx.simpleDeclaration() != null)
        {
            ctx.simpleDeclaration().accept(this);
        }
        return 0;
    }

    @Override
    public Integer visitJumpStatement(CParser.JumpStatementContext ctx) {
        if (ctx.Break() != null)
        {
            // break;
            try {
                writer.append("break;\n");
            }catch (IOException e){
                System.out.print("Exception about visitJumpStatement");
            }
        }
        else if (ctx.Continue() != null)
        {
            // continue
            try {
                writer.append("continue;\n");
            }catch (IOException e){
                System.out.print("Exception about visitJumpStatement");
            }
        }
        else if (ctx.Return() != null)
        {
            // return
            try {
                writer.append("return ");
                if (ctx.expression() != null)   ctx.expression().accept(this);
                else if (ctx.bracedInitList() != null)   ctx.bracedInitList().accept(this);
                writer.append(";\n");
            }catch (IOException e){
                System.out.print("Exception about visitJumpStatement");
            }
        }
        return 0;
    }

    @Override
    public Integer visitDeclarationStatement(CParser.DeclarationStatementContext ctx) {
        ctx.simpleDeclaration().accept(this);
        return 0;
    }

    @Override
    public Integer visitCondition(CParser.ConditionContext ctx) {
        ctx.expression().accept(this);
        return 0;
    }

    @Override
    public Integer visitLiteral(CParser.LiteralContext ctx) {
        try {
            writer.append(ctx.getText());
        } catch (IOException e)
        {
            System.out.print("Exception about literal");
        }
        return 0;
    }
}
s
