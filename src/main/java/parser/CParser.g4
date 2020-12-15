parser grammar CParser;
options {
	tokenVocab = CPPLexer;
}

translationUnit: declarationseq? EOF;

declarationseq: declaration+;

declaration:
	simpleDeclaration
	| functionDefinition
	| emptyDeclaration;

emptyDeclaration: Semi;

simpleDeclaration:
	simpleTypeSpecifier? initDeclaratorList? Semi;

simpleTypeSpecifier:
	Char
	| Char16
	| Char32
	| Wchar
	| Bool
	| Short
	| Int
	| Long
	| Signed
	| Unsigned
	| Float
	| Double
	| Void
	| Auto;

declSpecifierSeq:
	simpleTypeSpecifier;

initDeclaratorList: initDeclarator (Comma initDeclarator)*;

initDeclarator: declarator initializer?;

declarator:
	(pointerOperator)* noPointerDeclarator;
    // pointerDeclarator | noPointerDeclarator parametersAndQualifiers;

// pointerDeclarator: (pointerOperator)* noPointerDeclarator;

noPointerDeclarator:
	declaratorid
	| noPointerDeclarator (
		parametersAndQualifiers
		| LeftBracket constantExpression? RightBracket
	);
	// | LeftParen pointerDeclarator RightParen;

pointerOperator:
	And | Star;

declaratorid: idExpression;

parametersAndQualifiers:
	LeftParen parameterDeclarationList? RightParen;

parameterDeclarationList:
	parameterDeclaration (Comma parameterDeclaration)*;

parameterDeclaration:
	simpleTypeSpecifier declarator (Assign initializerClause)?;

initializer:
	equalInitializer;
	// | LeftParen expressionList RightParen;

equalInitializer:
	Assign initializerClause;

initializerClause: assignmentExpression | bracedInitList;

initializerList:
	initializerClause (
		Comma initializerClause
	)*;

bracedInitList: LeftBrace (initializerList Comma?)? RightBrace;


primaryExpression:
	literal
	| LeftParen expression RightParen
	| idExpression;

idExpression: unqualifiedId;

unqualifiedId: Identifier;

postfixExpression:
	primaryExpression
	| postfixExpression LeftBracket expression RightBracket
	| postfixExpression LeftParen expressionList? RightParen
	| postfixExpression (PlusPlus | MinusMinus);

expressionList: initializerList;

unaryExpression:
	postfixExpression
	| (PlusPlus | MinusMinus | unaryOperator | Sizeof) unaryExpression;

unaryOperator: Or | Star | And | Plus | Tilde | Minus | Not;

// castExpression:
// 	unaryExpression
// 	| LeftParen theTypeId RightParen castExpression;

multiplicativeExpression:
	unaryExpression (
		(Star | Div | Mod) unaryExpression
	)*;

additiveExpression:
	multiplicativeExpression (
		(Plus | Minus) multiplicativeExpression
	)*;

shiftExpression:
	additiveExpression (shiftOperator additiveExpression)*;

shiftOperator: Greater Greater | Less Less;

relationalExpression:
	shiftExpression (
		(Less | Greater | LessEqual | GreaterEqual) shiftExpression
	)?;

equalityExpression:
	relationalExpression (
		(Equal | NotEqual) relationalExpression
	)*;

// andExpression: equalityExpression (And equalityExpression)*;

// exclusiveOrExpression: andExpression (Caret andExpression)*;

// inclusiveOrExpression:
// 	exclusiveOrExpression (Or exclusiveOrExpression)*;

// logicalAndExpression:
// 	inclusiveOrExpression (AndAnd inclusiveOrExpression)*;

logicalAndExpression:
	equalityExpression (AndAnd equalityExpression)*;

logicalOrExpression:
	logicalAndExpression (OrOr logicalAndExpression)*;

conditionalExpression:
	logicalOrExpression (
		Question expression Colon assignmentExpression
	)?;

assignmentExpression:
	conditionalExpression
	| logicalOrExpression assignmentOperator initializerClause;

assignmentOperator:
	Assign
	| StarAssign
	| DivAssign
	| ModAssign
	| PlusAssign
	| MinusAssign
	| RightShiftAssign
	| LeftShiftAssign
	| AndAssign
	| XorAssign
	| OrAssign;

expression: assignmentExpression (Comma assignmentExpression)*;

constantExpression: conditionalExpression;

functionDefinition: 
	declSpecifierSeq declarator compoundStatement;

statementSeq: statement+;

statement:
	labeledStatement
	| (
		expressionStatement
		| compoundStatement
		| selectionStatement
		| iterationStatement
		| jumpStatement
	)
	| declarationStatement;

labeledStatement:
	(Identifier | Case constantExpression | Default) Colon statement;

expressionStatement: expression? Semi;

compoundStatement: LeftBrace statementSeq? RightBrace;

selectionStatement:
	If LeftParen condition RightParen statement (Else statement)?
	| Switch LeftParen condition RightParen statement;

iterationStatement:
	While LeftParen condition RightParen statement
	| Do statement While LeftParen expression RightParen Semi
	| For LeftParen forInitStatement condition? Semi expression? RightParen statement;

forInitStatement: expressionStatement | simpleDeclaration;

jumpStatement:
	(Break | Continue | Return (expression | bracedInitList)?) Semi;

declarationStatement: simpleDeclaration;

condition:
	expression;
	// | declSpecifierSeq declarator (
	// 	Assign initializerClause
	// 	| bracedInitList
	// );

literal:
	IntegerLiteral
	| CharacterLiteral
	| FloatingLiteral
	| StringLiteral
	| BooleanLiteral
	| PointerLiteral;