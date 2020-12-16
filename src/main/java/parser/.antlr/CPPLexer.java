// Generated from d:\repository\Compilation-Project\src\main\java\parser\CPPLexer.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CPPLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Asm=1, Auto=2, Bool=3, Break=4, Case=5, Char=6, Char16=7, Char32=8, Const=9, 
		Continue=10, Default=11, Delete=12, Do=13, Double=14, Else=15, False_=16, 
		Float=17, For=18, If=19, Int=20, Long=21, New=22, Nullptr=23, Operator=24, 
		Public=25, Return=26, Short=27, Signed=28, Sizeof=29, Struct=30, Switch=31, 
		This=32, True_=33, Typedef=34, Unsigned=35, Void=36, Volatile=37, Wchar=38, 
		While=39, LeftParen=40, RightParen=41, LeftBracket=42, RightBracket=43, 
		LeftBrace=44, RightBrace=45, Plus=46, Minus=47, Star=48, Div=49, Mod=50, 
		Caret=51, And=52, Or=53, Tilde=54, Not=55, Assign=56, Less=57, Greater=58, 
		PlusAssign=59, MinusAssign=60, StarAssign=61, DivAssign=62, ModAssign=63, 
		XorAssign=64, AndAssign=65, OrAssign=66, LeftShiftAssign=67, RightShiftAssign=68, 
		Equal=69, NotEqual=70, LessEqual=71, GreaterEqual=72, AndAnd=73, OrOr=74, 
		PlusPlus=75, MinusMinus=76, Comma=77, Arrow=78, Question=79, Colon=80, 
		Doublecolon=81, Semi=82, Dot=83, IntegerLiteral=84, CharacterLiteral=85, 
		FloatingLiteral=86, StringLiteral=87, BooleanLiteral=88, PointerLiteral=89, 
		MultiLineMacro=90, Directive=91, Identifier=92, DecimalLiteral=93, OctalLiteral=94, 
		HexadecimalLiteral=95, BinaryLiteral=96, Whitespace=97, Newline=98, BlockComment=99, 
		LineComment=100;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"Asm", "Auto", "Bool", "Break", "Case", "Char", "Char16", "Char32", "Const", 
			"Continue", "Default", "Delete", "Do", "Double", "Else", "False_", "Float", 
			"For", "If", "Int", "Long", "New", "Nullptr", "Operator", "Public", "Return", 
			"Short", "Signed", "Sizeof", "Struct", "Switch", "This", "True_", "Typedef", 
			"Unsigned", "Void", "Volatile", "Wchar", "While", "LeftParen", "RightParen", 
			"LeftBracket", "RightBracket", "LeftBrace", "RightBrace", "Plus", "Minus", 
			"Star", "Div", "Mod", "Caret", "And", "Or", "Tilde", "Not", "Assign", 
			"Less", "Greater", "PlusAssign", "MinusAssign", "StarAssign", "DivAssign", 
			"ModAssign", "XorAssign", "AndAssign", "OrAssign", "LeftShiftAssign", 
			"RightShiftAssign", "Equal", "NotEqual", "LessEqual", "GreaterEqual", 
			"AndAnd", "OrOr", "PlusPlus", "MinusMinus", "Comma", "Arrow", "Question", 
			"Colon", "Doublecolon", "Semi", "Dot", "IntegerLiteral", "CharacterLiteral", 
			"FloatingLiteral", "StringLiteral", "BooleanLiteral", "PointerLiteral", 
			"MultiLineMacro", "Directive", "Hexquad", "Universalcharactername", "Identifier", 
			"Identifiernondigit", "NONDIGIT", "DIGIT", "DecimalLiteral", "OctalLiteral", 
			"HexadecimalLiteral", "BinaryLiteral", "NONZERODIGIT", "OCTALDIGIT", 
			"HEXADECIMALDIGIT", "BINARYDIGIT", "Cchar", "Escapesequence", "Simpleescapesequence", 
			"Octalescapesequence", "Hexadecimalescapesequence", "Fractionalconstant", 
			"Exponentpart", "SIGN", "Digitsequence", "Schar", "Whitespace", "Newline", 
			"BlockComment", "LineComment"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'asm'", "'auto'", "'bool'", "'break'", "'case'", "'char'", "'char16_t'", 
			"'char32_t'", "'const'", "'continue'", "'default'", "'delete'", "'do'", 
			"'double'", "'else'", "'false'", "'float'", "'for'", "'if'", "'int'", 
			"'long'", "'new'", "'nullptr'", "'operator'", "'public'", "'return'", 
			"'short'", "'signed'", "'sizeof'", "'struct'", "'switch'", "'this'", 
			"'true'", "'typedef'", "'unsigned'", "'void'", "'volatile'", "'wchar_t'", 
			"'while'", "'('", "')'", "'['", "']'", "'{'", "'}'", "'+'", "'-'", "'*'", 
			"'/'", "'%'", "'^'", "'&'", "'|'", "'~'", null, "'='", "'<'", "'>'", 
			"'+='", "'-='", "'*='", "'/='", "'%='", "'^='", "'&='", "'|='", "'<<='", 
			"'>>='", "'=='", "'!='", "'<='", "'>='", null, null, "'++'", "'--'", 
			"','", "'->'", "'?'", "':'", "'::'", "';'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Asm", "Auto", "Bool", "Break", "Case", "Char", "Char16", "Char32", 
			"Const", "Continue", "Default", "Delete", "Do", "Double", "Else", "False_", 
			"Float", "For", "If", "Int", "Long", "New", "Nullptr", "Operator", "Public", 
			"Return", "Short", "Signed", "Sizeof", "Struct", "Switch", "This", "True_", 
			"Typedef", "Unsigned", "Void", "Volatile", "Wchar", "While", "LeftParen", 
			"RightParen", "LeftBracket", "RightBracket", "LeftBrace", "RightBrace", 
			"Plus", "Minus", "Star", "Div", "Mod", "Caret", "And", "Or", "Tilde", 
			"Not", "Assign", "Less", "Greater", "PlusAssign", "MinusAssign", "StarAssign", 
			"DivAssign", "ModAssign", "XorAssign", "AndAssign", "OrAssign", "LeftShiftAssign", 
			"RightShiftAssign", "Equal", "NotEqual", "LessEqual", "GreaterEqual", 
			"AndAnd", "OrOr", "PlusPlus", "MinusMinus", "Comma", "Arrow", "Question", 
			"Colon", "Doublecolon", "Semi", "Dot", "IntegerLiteral", "CharacterLiteral", 
			"FloatingLiteral", "StringLiteral", "BooleanLiteral", "PointerLiteral", 
			"MultiLineMacro", "Directive", "Identifier", "DecimalLiteral", "OctalLiteral", 
			"HexadecimalLiteral", "BinaryLiteral", "Whitespace", "Newline", "BlockComment", 
			"LineComment"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public CPPLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CPPLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2f\u0391\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu\4v\tv\4"+
		"w\tw\4x\tx\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3"+
		"\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3"+
		"\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3"+
		"\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\""+
		"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3"+
		"%\3&\3&\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3("+
		"\3(\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61"+
		"\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\38"+
		"\38\58\u0209\n8\39\39\3:\3:\3;\3;\3<\3<\3<\3=\3=\3=\3>\3>\3>\3?\3?\3?"+
		"\3@\3@\3@\3A\3A\3A\3B\3B\3B\3C\3C\3C\3D\3D\3D\3D\3E\3E\3E\3E\3F\3F\3F"+
		"\3G\3G\3G\3H\3H\3H\3I\3I\3I\3J\3J\3J\3J\3J\5J\u0242\nJ\3K\3K\3K\3K\5K"+
		"\u0248\nK\3L\3L\3L\3M\3M\3M\3N\3N\3O\3O\3O\3P\3P\3Q\3Q\3R\3R\3R\3S\3S"+
		"\3T\3T\3U\3U\3U\3U\5U\u0264\nU\3V\3V\6V\u0268\nV\rV\16V\u0269\3V\3V\3"+
		"W\3W\5W\u0270\nW\3W\3W\3W\5W\u0275\nW\3X\3X\7X\u0279\nX\fX\16X\u027c\13"+
		"X\3X\3X\3Y\3Y\5Y\u0282\nY\3Z\3Z\3[\3[\7[\u0288\n[\f[\16[\u028b\13[\3["+
		"\3[\5[\u028f\n[\3[\6[\u0292\n[\r[\16[\u0293\3[\6[\u0297\n[\r[\16[\u0298"+
		"\3[\3[\3\\\3\\\7\\\u029f\n\\\f\\\16\\\u02a2\13\\\3\\\3\\\3]\3]\3]\3]\3"+
		"]\3^\3^\3^\3^\3^\3^\3^\3^\3^\3^\5^\u02b5\n^\3_\3_\3_\7_\u02ba\n_\f_\16"+
		"_\u02bd\13_\3`\3`\5`\u02c1\n`\3a\3a\3b\3b\3c\3c\5c\u02c9\nc\3c\7c\u02cc"+
		"\nc\fc\16c\u02cf\13c\3d\3d\5d\u02d3\nd\3d\7d\u02d6\nd\fd\16d\u02d9\13"+
		"d\3e\3e\3e\3e\5e\u02df\ne\3e\3e\5e\u02e3\ne\3e\7e\u02e6\ne\fe\16e\u02e9"+
		"\13e\3f\3f\3f\3f\5f\u02ef\nf\3f\3f\5f\u02f3\nf\3f\7f\u02f6\nf\ff\16f\u02f9"+
		"\13f\3g\3g\3h\3h\3i\3i\3j\3j\3k\3k\3k\5k\u0306\nk\3l\3l\3l\5l\u030b\n"+
		"l\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\3m\5m\u0322"+
		"\nm\3m\5m\u0325\nm\3m\3m\3m\3m\5m\u032b\nm\3n\3n\3n\3n\3n\3n\3n\3n\3n"+
		"\3n\3n\5n\u0338\nn\3o\3o\3o\3o\6o\u033e\no\ro\16o\u033f\3p\5p\u0343\n"+
		"p\3p\3p\3p\3p\3p\5p\u034a\np\3q\3q\5q\u034e\nq\3q\3q\3q\5q\u0353\nq\3"+
		"q\5q\u0356\nq\3r\3r\3s\3s\5s\u035c\ns\3s\7s\u035f\ns\fs\16s\u0362\13s"+
		"\3t\3t\3t\5t\u0367\nt\3u\6u\u036a\nu\ru\16u\u036b\3u\3u\3v\3v\5v\u0372"+
		"\nv\3v\5v\u0375\nv\3v\3v\3w\3w\3w\3w\7w\u037d\nw\fw\16w\u0380\13w\3w\3"+
		"w\3w\3w\3w\3x\3x\3x\3x\7x\u038b\nx\fx\16x\u038e\13x\3x\3x\4\u0289\u037e"+
		"\2y\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67"+
		"m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085D\u0087E\u0089F\u008bG\u008d"+
		"H\u008fI\u0091J\u0093K\u0095L\u0097M\u0099N\u009bO\u009dP\u009fQ\u00a1"+
		"R\u00a3S\u00a5T\u00a7U\u00a9V\u00abW\u00adX\u00afY\u00b1Z\u00b3[\u00b5"+
		"\\\u00b7]\u00b9\2\u00bb\2\u00bd^\u00bf\2\u00c1\2\u00c3\2\u00c5_\u00c7"+
		"`\u00c9a\u00cbb\u00cd\2\u00cf\2\u00d1\2\u00d3\2\u00d5\2\u00d7\2\u00d9"+
		"\2\u00db\2\u00dd\2\u00df\2\u00e1\2\u00e3\2\u00e5\2\u00e7\2\u00e9c\u00eb"+
		"d\u00ede\u00eff\3\2\16\3\2\f\f\5\2C\\aac|\3\2\62;\3\2\63;\3\2\629\5\2"+
		"\62;CHch\3\2\62\63\6\2\f\f\17\17))^^\4\2--//\6\2\f\f\17\17$$^^\4\2\13"+
		"\13\"\"\4\2\f\f\17\17\2\u03bd\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2"+
		"+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2"+
		"\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2"+
		"C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3"+
		"\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2"+
		"\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2"+
		"i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3"+
		"\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081"+
		"\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2"+
		"\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093"+
		"\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2"+
		"\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5"+
		"\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9\3\2\2\2\2\u00ab\3\2\2\2\2\u00ad\3\2\2"+
		"\2\2\u00af\3\2\2\2\2\u00b1\3\2\2\2\2\u00b3\3\2\2\2\2\u00b5\3\2\2\2\2\u00b7"+
		"\3\2\2\2\2\u00bd\3\2\2\2\2\u00c5\3\2\2\2\2\u00c7\3\2\2\2\2\u00c9\3\2\2"+
		"\2\2\u00cb\3\2\2\2\2\u00e9\3\2\2\2\2\u00eb\3\2\2\2\2\u00ed\3\2\2\2\2\u00ef"+
		"\3\2\2\2\3\u00f1\3\2\2\2\5\u00f5\3\2\2\2\7\u00fa\3\2\2\2\t\u00ff\3\2\2"+
		"\2\13\u0105\3\2\2\2\r\u010a\3\2\2\2\17\u010f\3\2\2\2\21\u0118\3\2\2\2"+
		"\23\u0121\3\2\2\2\25\u0127\3\2\2\2\27\u0130\3\2\2\2\31\u0138\3\2\2\2\33"+
		"\u013f\3\2\2\2\35\u0142\3\2\2\2\37\u0149\3\2\2\2!\u014e\3\2\2\2#\u0154"+
		"\3\2\2\2%\u015a\3\2\2\2\'\u015e\3\2\2\2)\u0161\3\2\2\2+\u0165\3\2\2\2"+
		"-\u016a\3\2\2\2/\u016e\3\2\2\2\61\u0176\3\2\2\2\63\u017f\3\2\2\2\65\u0186"+
		"\3\2\2\2\67\u018d\3\2\2\29\u0193\3\2\2\2;\u019a\3\2\2\2=\u01a1\3\2\2\2"+
		"?\u01a8\3\2\2\2A\u01af\3\2\2\2C\u01b4\3\2\2\2E\u01b9\3\2\2\2G\u01c1\3"+
		"\2\2\2I\u01ca\3\2\2\2K\u01cf\3\2\2\2M\u01d8\3\2\2\2O\u01e0\3\2\2\2Q\u01e6"+
		"\3\2\2\2S\u01e8\3\2\2\2U\u01ea\3\2\2\2W\u01ec\3\2\2\2Y\u01ee\3\2\2\2["+
		"\u01f0\3\2\2\2]\u01f2\3\2\2\2_\u01f4\3\2\2\2a\u01f6\3\2\2\2c\u01f8\3\2"+
		"\2\2e\u01fa\3\2\2\2g\u01fc\3\2\2\2i\u01fe\3\2\2\2k\u0200\3\2\2\2m\u0202"+
		"\3\2\2\2o\u0208\3\2\2\2q\u020a\3\2\2\2s\u020c\3\2\2\2u\u020e\3\2\2\2w"+
		"\u0210\3\2\2\2y\u0213\3\2\2\2{\u0216\3\2\2\2}\u0219\3\2\2\2\177\u021c"+
		"\3\2\2\2\u0081\u021f\3\2\2\2\u0083\u0222\3\2\2\2\u0085\u0225\3\2\2\2\u0087"+
		"\u0228\3\2\2\2\u0089\u022c\3\2\2\2\u008b\u0230\3\2\2\2\u008d\u0233\3\2"+
		"\2\2\u008f\u0236\3\2\2\2\u0091\u0239\3\2\2\2\u0093\u0241\3\2\2\2\u0095"+
		"\u0247\3\2\2\2\u0097\u0249\3\2\2\2\u0099\u024c\3\2\2\2\u009b\u024f\3\2"+
		"\2\2\u009d\u0251\3\2\2\2\u009f\u0254\3\2\2\2\u00a1\u0256\3\2\2\2\u00a3"+
		"\u0258\3\2\2\2\u00a5\u025b\3\2\2\2\u00a7\u025d\3\2\2\2\u00a9\u0263\3\2"+
		"\2\2\u00ab\u0265\3\2\2\2\u00ad\u0274\3\2\2\2\u00af\u0276\3\2\2\2\u00b1"+
		"\u0281\3\2\2\2\u00b3\u0283\3\2\2\2\u00b5\u0285\3\2\2\2\u00b7\u029c\3\2"+
		"\2\2\u00b9\u02a5\3\2\2\2\u00bb\u02b4\3\2\2\2\u00bd\u02b6\3\2\2\2\u00bf"+
		"\u02c0\3\2\2\2\u00c1\u02c2\3\2\2\2\u00c3\u02c4\3\2\2\2\u00c5\u02c6\3\2"+
		"\2\2\u00c7\u02d0\3\2\2\2\u00c9\u02de\3\2\2\2\u00cb\u02ee\3\2\2\2\u00cd"+
		"\u02fa\3\2\2\2\u00cf\u02fc\3\2\2\2\u00d1\u02fe\3\2\2\2\u00d3\u0300\3\2"+
		"\2\2\u00d5\u0305\3\2\2\2\u00d7\u030a\3\2\2\2\u00d9\u032a\3\2\2\2\u00db"+
		"\u0337\3\2\2\2\u00dd\u0339\3\2\2\2\u00df\u0349\3\2\2\2\u00e1\u0355\3\2"+
		"\2\2\u00e3\u0357\3\2\2\2\u00e5\u0359\3\2\2\2\u00e7\u0366\3\2\2\2\u00e9"+
		"\u0369\3\2\2\2\u00eb\u0374\3\2\2\2\u00ed\u0378\3\2\2\2\u00ef\u0386\3\2"+
		"\2\2\u00f1\u00f2\7c\2\2\u00f2\u00f3\7u\2\2\u00f3\u00f4\7o\2\2\u00f4\4"+
		"\3\2\2\2\u00f5\u00f6\7c\2\2\u00f6\u00f7\7w\2\2\u00f7\u00f8\7v\2\2\u00f8"+
		"\u00f9\7q\2\2\u00f9\6\3\2\2\2\u00fa\u00fb\7d\2\2\u00fb\u00fc\7q\2\2\u00fc"+
		"\u00fd\7q\2\2\u00fd\u00fe\7n\2\2\u00fe\b\3\2\2\2\u00ff\u0100\7d\2\2\u0100"+
		"\u0101\7t\2\2\u0101\u0102\7g\2\2\u0102\u0103\7c\2\2\u0103\u0104\7m\2\2"+
		"\u0104\n\3\2\2\2\u0105\u0106\7e\2\2\u0106\u0107\7c\2\2\u0107\u0108\7u"+
		"\2\2\u0108\u0109\7g\2\2\u0109\f\3\2\2\2\u010a\u010b\7e\2\2\u010b\u010c"+
		"\7j\2\2\u010c\u010d\7c\2\2\u010d\u010e\7t\2\2\u010e\16\3\2\2\2\u010f\u0110"+
		"\7e\2\2\u0110\u0111\7j\2\2\u0111\u0112\7c\2\2\u0112\u0113\7t\2\2\u0113"+
		"\u0114\7\63\2\2\u0114\u0115\78\2\2\u0115\u0116\7a\2\2\u0116\u0117\7v\2"+
		"\2\u0117\20\3\2\2\2\u0118\u0119\7e\2\2\u0119\u011a\7j\2\2\u011a\u011b"+
		"\7c\2\2\u011b\u011c\7t\2\2\u011c\u011d\7\65\2\2\u011d\u011e\7\64\2\2\u011e"+
		"\u011f\7a\2\2\u011f\u0120\7v\2\2\u0120\22\3\2\2\2\u0121\u0122\7e\2\2\u0122"+
		"\u0123\7q\2\2\u0123\u0124\7p\2\2\u0124\u0125\7u\2\2\u0125\u0126\7v\2\2"+
		"\u0126\24\3\2\2\2\u0127\u0128\7e\2\2\u0128\u0129\7q\2\2\u0129\u012a\7"+
		"p\2\2\u012a\u012b\7v\2\2\u012b\u012c\7k\2\2\u012c\u012d\7p\2\2\u012d\u012e"+
		"\7w\2\2\u012e\u012f\7g\2\2\u012f\26\3\2\2\2\u0130\u0131\7f\2\2\u0131\u0132"+
		"\7g\2\2\u0132\u0133\7h\2\2\u0133\u0134\7c\2\2\u0134\u0135\7w\2\2\u0135"+
		"\u0136\7n\2\2\u0136\u0137\7v\2\2\u0137\30\3\2\2\2\u0138\u0139\7f\2\2\u0139"+
		"\u013a\7g\2\2\u013a\u013b\7n\2\2\u013b\u013c\7g\2\2\u013c\u013d\7v\2\2"+
		"\u013d\u013e\7g\2\2\u013e\32\3\2\2\2\u013f\u0140\7f\2\2\u0140\u0141\7"+
		"q\2\2\u0141\34\3\2\2\2\u0142\u0143\7f\2\2\u0143\u0144\7q\2\2\u0144\u0145"+
		"\7w\2\2\u0145\u0146\7d\2\2\u0146\u0147\7n\2\2\u0147\u0148\7g\2\2\u0148"+
		"\36\3\2\2\2\u0149\u014a\7g\2\2\u014a\u014b\7n\2\2\u014b\u014c\7u\2\2\u014c"+
		"\u014d\7g\2\2\u014d \3\2\2\2\u014e\u014f\7h\2\2\u014f\u0150\7c\2\2\u0150"+
		"\u0151\7n\2\2\u0151\u0152\7u\2\2\u0152\u0153\7g\2\2\u0153\"\3\2\2\2\u0154"+
		"\u0155\7h\2\2\u0155\u0156\7n\2\2\u0156\u0157\7q\2\2\u0157\u0158\7c\2\2"+
		"\u0158\u0159\7v\2\2\u0159$\3\2\2\2\u015a\u015b\7h\2\2\u015b\u015c\7q\2"+
		"\2\u015c\u015d\7t\2\2\u015d&\3\2\2\2\u015e\u015f\7k\2\2\u015f\u0160\7"+
		"h\2\2\u0160(\3\2\2\2\u0161\u0162\7k\2\2\u0162\u0163\7p\2\2\u0163\u0164"+
		"\7v\2\2\u0164*\3\2\2\2\u0165\u0166\7n\2\2\u0166\u0167\7q\2\2\u0167\u0168"+
		"\7p\2\2\u0168\u0169\7i\2\2\u0169,\3\2\2\2\u016a\u016b\7p\2\2\u016b\u016c"+
		"\7g\2\2\u016c\u016d\7y\2\2\u016d.\3\2\2\2\u016e\u016f\7p\2\2\u016f\u0170"+
		"\7w\2\2\u0170\u0171\7n\2\2\u0171\u0172\7n\2\2\u0172\u0173\7r\2\2\u0173"+
		"\u0174\7v\2\2\u0174\u0175\7t\2\2\u0175\60\3\2\2\2\u0176\u0177\7q\2\2\u0177"+
		"\u0178\7r\2\2\u0178\u0179\7g\2\2\u0179\u017a\7t\2\2\u017a\u017b\7c\2\2"+
		"\u017b\u017c\7v\2\2\u017c\u017d\7q\2\2\u017d\u017e\7t\2\2\u017e\62\3\2"+
		"\2\2\u017f\u0180\7r\2\2\u0180\u0181\7w\2\2\u0181\u0182\7d\2\2\u0182\u0183"+
		"\7n\2\2\u0183\u0184\7k\2\2\u0184\u0185\7e\2\2\u0185\64\3\2\2\2\u0186\u0187"+
		"\7t\2\2\u0187\u0188\7g\2\2\u0188\u0189\7v\2\2\u0189\u018a\7w\2\2\u018a"+
		"\u018b\7t\2\2\u018b\u018c\7p\2\2\u018c\66\3\2\2\2\u018d\u018e\7u\2\2\u018e"+
		"\u018f\7j\2\2\u018f\u0190\7q\2\2\u0190\u0191\7t\2\2\u0191\u0192\7v\2\2"+
		"\u01928\3\2\2\2\u0193\u0194\7u\2\2\u0194\u0195\7k\2\2\u0195\u0196\7i\2"+
		"\2\u0196\u0197\7p\2\2\u0197\u0198\7g\2\2\u0198\u0199\7f\2\2\u0199:\3\2"+
		"\2\2\u019a\u019b\7u\2\2\u019b\u019c\7k\2\2\u019c\u019d\7|\2\2\u019d\u019e"+
		"\7g\2\2\u019e\u019f\7q\2\2\u019f\u01a0\7h\2\2\u01a0<\3\2\2\2\u01a1\u01a2"+
		"\7u\2\2\u01a2\u01a3\7v\2\2\u01a3\u01a4\7t\2\2\u01a4\u01a5\7w\2\2\u01a5"+
		"\u01a6\7e\2\2\u01a6\u01a7\7v\2\2\u01a7>\3\2\2\2\u01a8\u01a9\7u\2\2\u01a9"+
		"\u01aa\7y\2\2\u01aa\u01ab\7k\2\2\u01ab\u01ac\7v\2\2\u01ac\u01ad\7e\2\2"+
		"\u01ad\u01ae\7j\2\2\u01ae@\3\2\2\2\u01af\u01b0\7v\2\2\u01b0\u01b1\7j\2"+
		"\2\u01b1\u01b2\7k\2\2\u01b2\u01b3\7u\2\2\u01b3B\3\2\2\2\u01b4\u01b5\7"+
		"v\2\2\u01b5\u01b6\7t\2\2\u01b6\u01b7\7w\2\2\u01b7\u01b8\7g\2\2\u01b8D"+
		"\3\2\2\2\u01b9\u01ba\7v\2\2\u01ba\u01bb\7{\2\2\u01bb\u01bc\7r\2\2\u01bc"+
		"\u01bd\7g\2\2\u01bd\u01be\7f\2\2\u01be\u01bf\7g\2\2\u01bf\u01c0\7h\2\2"+
		"\u01c0F\3\2\2\2\u01c1\u01c2\7w\2\2\u01c2\u01c3\7p\2\2\u01c3\u01c4\7u\2"+
		"\2\u01c4\u01c5\7k\2\2\u01c5\u01c6\7i\2\2\u01c6\u01c7\7p\2\2\u01c7\u01c8"+
		"\7g\2\2\u01c8\u01c9\7f\2\2\u01c9H\3\2\2\2\u01ca\u01cb\7x\2\2\u01cb\u01cc"+
		"\7q\2\2\u01cc\u01cd\7k\2\2\u01cd\u01ce\7f\2\2\u01ceJ\3\2\2\2\u01cf\u01d0"+
		"\7x\2\2\u01d0\u01d1\7q\2\2\u01d1\u01d2\7n\2\2\u01d2\u01d3\7c\2\2\u01d3"+
		"\u01d4\7v\2\2\u01d4\u01d5\7k\2\2\u01d5\u01d6\7n\2\2\u01d6\u01d7\7g\2\2"+
		"\u01d7L\3\2\2\2\u01d8\u01d9\7y\2\2\u01d9\u01da\7e\2\2\u01da\u01db\7j\2"+
		"\2\u01db\u01dc\7c\2\2\u01dc\u01dd\7t\2\2\u01dd\u01de\7a\2\2\u01de\u01df"+
		"\7v\2\2\u01dfN\3\2\2\2\u01e0\u01e1\7y\2\2\u01e1\u01e2\7j\2\2\u01e2\u01e3"+
		"\7k\2\2\u01e3\u01e4\7n\2\2\u01e4\u01e5\7g\2\2\u01e5P\3\2\2\2\u01e6\u01e7"+
		"\7*\2\2\u01e7R\3\2\2\2\u01e8\u01e9\7+\2\2\u01e9T\3\2\2\2\u01ea\u01eb\7"+
		"]\2\2\u01ebV\3\2\2\2\u01ec\u01ed\7_\2\2\u01edX\3\2\2\2\u01ee\u01ef\7}"+
		"\2\2\u01efZ\3\2\2\2\u01f0\u01f1\7\177\2\2\u01f1\\\3\2\2\2\u01f2\u01f3"+
		"\7-\2\2\u01f3^\3\2\2\2\u01f4\u01f5\7/\2\2\u01f5`\3\2\2\2\u01f6\u01f7\7"+
		",\2\2\u01f7b\3\2\2\2\u01f8\u01f9\7\61\2\2\u01f9d\3\2\2\2\u01fa\u01fb\7"+
		"\'\2\2\u01fbf\3\2\2\2\u01fc\u01fd\7`\2\2\u01fdh\3\2\2\2\u01fe\u01ff\7"+
		"(\2\2\u01ffj\3\2\2\2\u0200\u0201\7~\2\2\u0201l\3\2\2\2\u0202\u0203\7\u0080"+
		"\2\2\u0203n\3\2\2\2\u0204\u0209\7#\2\2\u0205\u0206\7p\2\2\u0206\u0207"+
		"\7q\2\2\u0207\u0209\7v\2\2\u0208\u0204\3\2\2\2\u0208\u0205\3\2\2\2\u0209"+
		"p\3\2\2\2\u020a\u020b\7?\2\2\u020br\3\2\2\2\u020c\u020d\7>\2\2\u020dt"+
		"\3\2\2\2\u020e\u020f\7@\2\2\u020fv\3\2\2\2\u0210\u0211\7-\2\2\u0211\u0212"+
		"\7?\2\2\u0212x\3\2\2\2\u0213\u0214\7/\2\2\u0214\u0215\7?\2\2\u0215z\3"+
		"\2\2\2\u0216\u0217\7,\2\2\u0217\u0218\7?\2\2\u0218|\3\2\2\2\u0219\u021a"+
		"\7\61\2\2\u021a\u021b\7?\2\2\u021b~\3\2\2\2\u021c\u021d\7\'\2\2\u021d"+
		"\u021e\7?\2\2\u021e\u0080\3\2\2\2\u021f\u0220\7`\2\2\u0220\u0221\7?\2"+
		"\2\u0221\u0082\3\2\2\2\u0222\u0223\7(\2\2\u0223\u0224\7?\2\2\u0224\u0084"+
		"\3\2\2\2\u0225\u0226\7~\2\2\u0226\u0227\7?\2\2\u0227\u0086\3\2\2\2\u0228"+
		"\u0229\7>\2\2\u0229\u022a\7>\2\2\u022a\u022b\7?\2\2\u022b\u0088\3\2\2"+
		"\2\u022c\u022d\7@\2\2\u022d\u022e\7@\2\2\u022e\u022f\7?\2\2\u022f\u008a"+
		"\3\2\2\2\u0230\u0231\7?\2\2\u0231\u0232\7?\2\2\u0232\u008c\3\2\2\2\u0233"+
		"\u0234\7#\2\2\u0234\u0235\7?\2\2\u0235\u008e\3\2\2\2\u0236\u0237\7>\2"+
		"\2\u0237\u0238\7?\2\2\u0238\u0090\3\2\2\2\u0239\u023a\7@\2\2\u023a\u023b"+
		"\7?\2\2\u023b\u0092\3\2\2\2\u023c\u023d\7(\2\2\u023d\u0242\7(\2\2\u023e"+
		"\u023f\7c\2\2\u023f\u0240\7p\2\2\u0240\u0242\7f\2\2\u0241\u023c\3\2\2"+
		"\2\u0241\u023e\3\2\2\2\u0242\u0094\3\2\2\2\u0243\u0244\7~\2\2\u0244\u0248"+
		"\7~\2\2\u0245\u0246\7q\2\2\u0246\u0248\7t\2\2\u0247\u0243\3\2\2\2\u0247"+
		"\u0245\3\2\2\2\u0248\u0096\3\2\2\2\u0249\u024a\7-\2\2\u024a\u024b\7-\2"+
		"\2\u024b\u0098\3\2\2\2\u024c\u024d\7/\2\2\u024d\u024e\7/\2\2\u024e\u009a"+
		"\3\2\2\2\u024f\u0250\7.\2\2\u0250\u009c\3\2\2\2\u0251\u0252\7/\2\2\u0252"+
		"\u0253\7@\2\2\u0253\u009e\3\2\2\2\u0254\u0255\7A\2\2\u0255\u00a0\3\2\2"+
		"\2\u0256\u0257\7<\2\2\u0257\u00a2\3\2\2\2\u0258\u0259\7<\2\2\u0259\u025a"+
		"\7<\2\2\u025a\u00a4\3\2\2\2\u025b\u025c\7=\2\2\u025c\u00a6\3\2\2\2\u025d"+
		"\u025e\7\60\2\2\u025e\u00a8\3\2\2\2\u025f\u0264\5\u00c5c\2\u0260\u0264"+
		"\5\u00c7d\2\u0261\u0264\5\u00c9e\2\u0262\u0264\5\u00cbf\2\u0263\u025f"+
		"\3\2\2\2\u0263\u0260\3\2\2\2\u0263\u0261\3\2\2\2\u0263\u0262\3\2\2\2\u0264"+
		"\u00aa\3\2\2\2\u0265\u0267\7)\2\2\u0266\u0268\5\u00d5k\2\u0267\u0266\3"+
		"\2\2\2\u0268\u0269\3\2\2\2\u0269\u0267\3\2\2\2\u0269\u026a\3\2\2\2\u026a"+
		"\u026b\3\2\2\2\u026b\u026c\7)\2\2\u026c\u00ac\3\2\2\2\u026d\u026f\5\u00df"+
		"p\2\u026e\u0270\5\u00e1q\2\u026f\u026e\3\2\2\2\u026f\u0270\3\2\2\2\u0270"+
		"\u0275\3\2\2\2\u0271\u0272\5\u00e5s\2\u0272\u0273\5\u00e1q\2\u0273\u0275"+
		"\3\2\2\2\u0274\u026d\3\2\2\2\u0274\u0271\3\2\2\2\u0275\u00ae\3\2\2\2\u0276"+
		"\u027a\7$\2\2\u0277\u0279\5\u00e7t\2\u0278\u0277\3\2\2\2\u0279\u027c\3"+
		"\2\2\2\u027a\u0278\3\2\2\2\u027a\u027b\3\2\2\2\u027b\u027d\3\2\2\2\u027c"+
		"\u027a\3\2\2\2\u027d\u027e\7$\2\2\u027e\u00b0\3\2\2\2\u027f\u0282\5!\21"+
		"\2\u0280\u0282\5C\"\2\u0281\u027f\3\2\2\2\u0281\u0280\3\2\2\2\u0282\u00b2"+
		"\3\2\2\2\u0283\u0284\5/\30\2\u0284\u00b4\3\2\2\2\u0285\u0291\7%\2\2\u0286"+
		"\u0288\n\2\2\2\u0287\u0286\3\2\2\2\u0288\u028b\3\2\2\2\u0289\u028a\3\2"+
		"\2\2\u0289\u0287\3\2\2\2\u028a\u028c\3\2\2\2\u028b\u0289\3\2\2\2\u028c"+
		"\u028e\7^\2\2\u028d\u028f\7\17\2\2\u028e\u028d\3\2\2\2\u028e\u028f\3\2"+
		"\2\2\u028f\u0290\3\2\2\2\u0290\u0292\7\f\2\2\u0291\u0289\3\2\2\2\u0292"+
		"\u0293\3\2\2\2\u0293\u0291\3\2\2\2\u0293\u0294\3\2\2\2\u0294\u0296\3\2"+
		"\2\2\u0295\u0297\n\2\2\2\u0296\u0295\3\2\2\2\u0297\u0298\3\2\2\2\u0298"+
		"\u0296\3\2\2\2\u0298\u0299\3\2\2\2\u0299\u029a\3\2\2\2\u029a\u029b\b["+
		"\2\2\u029b\u00b6\3\2\2\2\u029c\u02a0\7%\2\2\u029d\u029f\n\2\2\2\u029e"+
		"\u029d\3\2\2\2\u029f\u02a2\3\2\2\2\u02a0\u029e\3\2\2\2\u02a0\u02a1\3\2"+
		"\2\2\u02a1\u02a3\3\2\2\2\u02a2\u02a0\3\2\2\2\u02a3\u02a4\b\\\2\2\u02a4"+
		"\u00b8\3\2\2\2\u02a5\u02a6\5\u00d1i\2\u02a6\u02a7\5\u00d1i\2\u02a7\u02a8"+
		"\5\u00d1i\2\u02a8\u02a9\5\u00d1i\2\u02a9\u00ba\3\2\2\2\u02aa\u02ab\7^"+
		"\2\2\u02ab\u02ac\7w\2\2\u02ac\u02ad\3\2\2\2\u02ad\u02b5\5\u00b9]\2\u02ae"+
		"\u02af\7^\2\2\u02af\u02b0\7W\2\2\u02b0\u02b1\3\2\2\2\u02b1\u02b2\5\u00b9"+
		"]\2\u02b2\u02b3\5\u00b9]\2\u02b3\u02b5\3\2\2\2\u02b4\u02aa\3\2\2\2\u02b4"+
		"\u02ae\3\2\2\2\u02b5\u00bc\3\2\2\2\u02b6\u02bb\5\u00bf`\2\u02b7\u02ba"+
		"\5\u00bf`\2\u02b8\u02ba\5\u00c3b\2\u02b9\u02b7\3\2\2\2\u02b9\u02b8\3\2"+
		"\2\2\u02ba\u02bd\3\2\2\2\u02bb\u02b9\3\2\2\2\u02bb\u02bc\3\2\2\2\u02bc"+
		"\u00be\3\2\2\2\u02bd\u02bb\3\2\2\2\u02be\u02c1\5\u00c1a\2\u02bf\u02c1"+
		"\5\u00bb^\2\u02c0\u02be\3\2\2\2\u02c0\u02bf\3\2\2\2\u02c1\u00c0\3\2\2"+
		"\2\u02c2\u02c3\t\3\2\2\u02c3\u00c2\3\2\2\2\u02c4\u02c5\t\4\2\2\u02c5\u00c4"+
		"\3\2\2\2\u02c6\u02cd\5\u00cdg\2\u02c7\u02c9\7)\2\2\u02c8\u02c7\3\2\2\2"+
		"\u02c8\u02c9\3\2\2\2\u02c9\u02ca\3\2\2\2\u02ca\u02cc\5\u00c3b\2\u02cb"+
		"\u02c8\3\2\2\2\u02cc\u02cf\3\2\2\2\u02cd\u02cb\3\2\2\2\u02cd\u02ce\3\2"+
		"\2\2\u02ce\u00c6\3\2\2\2\u02cf\u02cd\3\2\2\2\u02d0\u02d7\7\62\2\2\u02d1"+
		"\u02d3\7)\2\2\u02d2\u02d1\3\2\2\2\u02d2\u02d3\3\2\2\2\u02d3\u02d4\3\2"+
		"\2\2\u02d4\u02d6\5\u00cfh\2\u02d5\u02d2\3\2\2\2\u02d6\u02d9\3\2\2\2\u02d7"+
		"\u02d5\3\2\2\2\u02d7\u02d8\3\2\2\2\u02d8\u00c8\3\2\2\2\u02d9\u02d7\3\2"+
		"\2\2\u02da\u02db\7\62\2\2\u02db\u02df\7z\2\2\u02dc\u02dd\7\62\2\2\u02dd"+
		"\u02df\7Z\2\2\u02de\u02da\3\2\2\2\u02de\u02dc\3\2\2\2\u02df\u02e0\3\2"+
		"\2\2\u02e0\u02e7\5\u00d1i\2\u02e1\u02e3\7)\2\2\u02e2\u02e1\3\2\2\2\u02e2"+
		"\u02e3\3\2\2\2\u02e3\u02e4\3\2\2\2\u02e4\u02e6\5\u00d1i\2\u02e5\u02e2"+
		"\3\2\2\2\u02e6\u02e9\3\2\2\2\u02e7\u02e5\3\2\2\2\u02e7\u02e8\3\2\2\2\u02e8"+
		"\u00ca\3\2\2\2\u02e9\u02e7\3\2\2\2\u02ea\u02eb\7\62\2\2\u02eb\u02ef\7"+
		"d\2\2\u02ec\u02ed\7\62\2\2\u02ed\u02ef\7D\2\2\u02ee\u02ea\3\2\2\2\u02ee"+
		"\u02ec\3\2\2\2\u02ef\u02f0\3\2\2\2\u02f0\u02f7\5\u00d3j\2\u02f1\u02f3"+
		"\7)\2\2\u02f2\u02f1\3\2\2\2\u02f2\u02f3\3\2\2\2\u02f3\u02f4\3\2\2\2\u02f4"+
		"\u02f6\5\u00d3j\2\u02f5\u02f2\3\2\2\2\u02f6\u02f9\3\2\2\2\u02f7\u02f5"+
		"\3\2\2\2\u02f7\u02f8\3\2\2\2\u02f8\u00cc\3\2\2\2\u02f9\u02f7\3\2\2\2\u02fa"+
		"\u02fb\t\5\2\2\u02fb\u00ce\3\2\2\2\u02fc\u02fd\t\6\2\2\u02fd\u00d0\3\2"+
		"\2\2\u02fe\u02ff\t\7\2\2\u02ff\u00d2\3\2\2\2\u0300\u0301\t\b\2\2\u0301"+
		"\u00d4\3\2\2\2\u0302\u0306\n\t\2\2\u0303\u0306\5\u00d7l\2\u0304\u0306"+
		"\5\u00bb^\2\u0305\u0302\3\2\2\2\u0305\u0303\3\2\2\2\u0305\u0304\3\2\2"+
		"\2\u0306\u00d6\3\2\2\2\u0307\u030b\5\u00d9m\2\u0308\u030b\5\u00dbn\2\u0309"+
		"\u030b\5\u00ddo\2\u030a\u0307\3\2\2\2\u030a\u0308\3\2\2\2\u030a\u0309"+
		"\3\2\2\2\u030b\u00d8\3\2\2\2\u030c\u030d\7^\2\2\u030d\u032b\7)\2\2\u030e"+
		"\u030f\7^\2\2\u030f\u032b\7$\2\2\u0310\u0311\7^\2\2\u0311\u032b\7A\2\2"+
		"\u0312\u0313\7^\2\2\u0313\u032b\7^\2\2\u0314\u0315\7^\2\2\u0315\u032b"+
		"\7c\2\2\u0316\u0317\7^\2\2\u0317\u032b\7d\2\2\u0318\u0319\7^\2\2\u0319"+
		"\u032b\7h\2\2\u031a\u031b\7^\2\2\u031b\u032b\7p\2\2\u031c\u031d\7^\2\2"+
		"\u031d\u032b\7t\2\2\u031e\u0324\7^\2\2\u031f\u0321\7\17\2\2\u0320\u0322"+
		"\7\f\2\2\u0321\u0320\3\2\2\2\u0321\u0322\3\2\2\2\u0322\u0325\3\2\2\2\u0323"+
		"\u0325\7\f\2\2\u0324\u031f\3\2\2\2\u0324\u0323\3\2\2\2\u0325\u032b\3\2"+
		"\2\2\u0326\u0327\7^\2\2\u0327\u032b\7v\2\2\u0328\u0329\7^\2\2\u0329\u032b"+
		"\7x\2\2\u032a\u030c\3\2\2\2\u032a\u030e\3\2\2\2\u032a\u0310\3\2\2\2\u032a"+
		"\u0312\3\2\2\2\u032a\u0314\3\2\2\2\u032a\u0316\3\2\2\2\u032a\u0318\3\2"+
		"\2\2\u032a\u031a\3\2\2\2\u032a\u031c\3\2\2\2\u032a\u031e\3\2\2\2\u032a"+
		"\u0326\3\2\2\2\u032a\u0328\3\2\2\2\u032b\u00da\3\2\2\2\u032c\u032d\7^"+
		"\2\2\u032d\u0338\5\u00cfh\2\u032e\u032f\7^\2\2\u032f\u0330\5\u00cfh\2"+
		"\u0330\u0331\5\u00cfh\2\u0331\u0338\3\2\2\2\u0332\u0333\7^\2\2\u0333\u0334"+
		"\5\u00cfh\2\u0334\u0335\5\u00cfh\2\u0335\u0336\5\u00cfh\2\u0336\u0338"+
		"\3\2\2\2\u0337\u032c\3\2\2\2\u0337\u032e\3\2\2\2\u0337\u0332\3\2\2\2\u0338"+
		"\u00dc\3\2\2\2\u0339\u033a\7^\2\2\u033a\u033b\7z\2\2\u033b\u033d\3\2\2"+
		"\2\u033c\u033e\5\u00d1i\2\u033d\u033c\3\2\2\2\u033e\u033f\3\2\2\2\u033f"+
		"\u033d\3\2\2\2\u033f\u0340\3\2\2\2\u0340\u00de\3\2\2\2\u0341\u0343\5\u00e5"+
		"s\2\u0342\u0341\3\2\2\2\u0342\u0343\3\2\2\2\u0343\u0344\3\2\2\2\u0344"+
		"\u0345\7\60\2\2\u0345\u034a\5\u00e5s\2\u0346\u0347\5\u00e5s\2\u0347\u0348"+
		"\7\60\2\2\u0348\u034a\3\2\2\2\u0349\u0342\3\2\2\2\u0349\u0346\3\2\2\2"+
		"\u034a\u00e0\3\2\2\2\u034b\u034d\7g\2\2\u034c\u034e\5\u00e3r\2\u034d\u034c"+
		"\3\2\2\2\u034d\u034e\3\2\2\2\u034e\u034f\3\2\2\2\u034f\u0356\5\u00e5s"+
		"\2\u0350\u0352\7G\2\2\u0351\u0353\5\u00e3r\2\u0352\u0351\3\2\2\2\u0352"+
		"\u0353\3\2\2\2\u0353\u0354\3\2\2\2\u0354\u0356\5\u00e5s\2\u0355\u034b"+
		"\3\2\2\2\u0355\u0350\3\2\2\2\u0356\u00e2\3\2\2\2\u0357\u0358\t\n\2\2\u0358"+
		"\u00e4\3\2\2\2\u0359\u0360\5\u00c3b\2\u035a\u035c\7)\2\2\u035b\u035a\3"+
		"\2\2\2\u035b\u035c\3\2\2\2\u035c\u035d\3\2\2\2\u035d\u035f\5\u00c3b\2"+
		"\u035e\u035b\3\2\2\2\u035f\u0362\3\2\2\2\u0360\u035e\3\2\2\2\u0360\u0361"+
		"\3\2\2\2\u0361\u00e6\3\2\2\2\u0362\u0360\3\2\2\2\u0363\u0367\n\13\2\2"+
		"\u0364\u0367\5\u00d7l\2\u0365\u0367\5\u00bb^\2\u0366\u0363\3\2\2\2\u0366"+
		"\u0364\3\2\2\2\u0366\u0365\3\2\2\2\u0367\u00e8\3\2\2\2\u0368\u036a\t\f"+
		"\2\2\u0369\u0368\3\2\2\2\u036a\u036b\3\2\2\2\u036b\u0369\3\2\2\2\u036b"+
		"\u036c\3\2\2\2\u036c\u036d\3\2\2\2\u036d\u036e\bu\3\2\u036e\u00ea\3\2"+
		"\2\2\u036f\u0371\7\17\2\2\u0370\u0372\7\f\2\2\u0371\u0370\3\2\2\2\u0371"+
		"\u0372\3\2\2\2\u0372\u0375\3\2\2\2\u0373\u0375\7\f\2\2\u0374\u036f\3\2"+
		"\2\2\u0374\u0373\3\2\2\2\u0375\u0376\3\2\2\2\u0376\u0377\bv\3\2\u0377"+
		"\u00ec\3\2\2\2\u0378\u0379\7\61\2\2\u0379\u037a\7,\2\2\u037a\u037e\3\2"+
		"\2\2\u037b\u037d\13\2\2\2\u037c\u037b\3\2\2\2\u037d\u0380\3\2\2\2\u037e"+
		"\u037f\3\2\2\2\u037e\u037c\3\2\2\2\u037f\u0381\3\2\2\2\u0380\u037e\3\2"+
		"\2\2\u0381\u0382\7,\2\2\u0382\u0383\7\61\2\2\u0383\u0384\3\2\2\2\u0384"+
		"\u0385\bw\3\2\u0385\u00ee\3\2\2\2\u0386\u0387\7\61\2\2\u0387\u0388\7\61"+
		"\2\2\u0388\u038c\3\2\2\2\u0389\u038b\n\r\2\2\u038a\u0389\3\2\2\2\u038b"+
		"\u038e\3\2\2\2\u038c\u038a\3\2\2\2\u038c\u038d\3\2\2\2\u038d\u038f\3\2"+
		"\2\2\u038e\u038c\3\2\2\2\u038f\u0390\bx\3\2\u0390\u00f0\3\2\2\2\63\2\u0208"+
		"\u0241\u0247\u0263\u0269\u026f\u0274\u027a\u0281\u0289\u028e\u0293\u0298"+
		"\u02a0\u02b4\u02b9\u02bb\u02c0\u02c8\u02cd\u02d2\u02d7\u02de\u02e2\u02e7"+
		"\u02ee\u02f2\u02f7\u0305\u030a\u0321\u0324\u032a\u0337\u033f\u0342\u0349"+
		"\u034d\u0352\u0355\u035b\u0360\u0366\u036b\u0371\u0374\u037e\u038c\4\2"+
		"\3\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}