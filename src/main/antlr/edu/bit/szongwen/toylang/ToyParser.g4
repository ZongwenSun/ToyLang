parser grammar ToyParser;
options {
	tokenVocab = ToyLexer;
}
program: lines = line+;
line: expression (EOF | NEWLINE) # print;
expression:
	expression PERCENT									# Percent
	| expression op = (ASTERISK | DIVISION) expression	# MulDiv
	| expression op = (PLUS | MINUS) expression			# AddMinus
	| LPAREN expression RPAREN							# Parens
	| MINUS expression									# Minux
	| NUM												# Num;
