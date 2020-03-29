lexer grammar ToyLexer;

// WhiteSpace
NEWLINE: '\r\n' | '\r' | '\n';
WS: [ \t]+ -> skip;

// Literals
NUM: '0' | [1-9][0-9]* | [1-9][0-9]* '.' [0-9]+;

// Operators
PLUS: '+';
MINUS: '-';
ASTERISK: '*';
DIVISION: '/';
LPAREN: '(';
RPAREN: ')';
PERCENT: '%';