package de.upb.lina.lll.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalExpressionsLexer extends Lexer {
    public static final int RULE_BOOLEAN=5;
    public static final int RULE_ID=7;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=9;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__19=19;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__33=33;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=4;
    public static final int RULE_WS=10;

    // delegates
    // delegators

    public InternalExpressionsLexer() {;} 
    public InternalExpressionsLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalExpressionsLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g"; }

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:11:7: ( 'equiv' )
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:11:9: 'equiv'
            {
            match("equiv"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:12:7: ( 'imply' )
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:12:9: 'imply'
            {
            match("imply"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:13:7: ( 'or' )
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:13:9: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:14:7: ( 'xor' )
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:14:9: 'xor'
            {
            match("xor"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:15:7: ( 'and' )
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:15:9: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:16:7: ( 'not' )
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:16:9: 'not'
            {
            match("not"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:17:7: ( '(' )
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:17:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:18:7: ( ')' )
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:18:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:19:7: ( '<=' )
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:19:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:20:7: ( '<' )
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:20:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:21:7: ( '>=' )
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:21:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:22:7: ( '>' )
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:22:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:23:7: ( '=' )
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:23:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:24:7: ( '!=' )
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:24:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:25:7: ( '~' )
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:25:9: '~'
            {
            match('~'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:26:7: ( '+' )
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:26:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:27:7: ( '-' )
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:27:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:28:7: ( '*' )
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:28:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:29:7: ( '/' )
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:29:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:30:7: ( '%' )
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:30:9: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:31:7: ( '^' )
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:31:9: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:32:7: ( '.' )
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:32:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "RULE_BOOLEAN"
    public final void mRULE_BOOLEAN() throws RecognitionException {
        try {
            int _type = RULE_BOOLEAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1386:14: ( ( 'true' | 'false' ) )
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1386:16: ( 'true' | 'false' )
            {
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1386:16: ( 'true' | 'false' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='t') ) {
                alt1=1;
            }
            else if ( (LA1_0=='f') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1386:17: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1386:24: 'false'
                    {
                    match("false"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BOOLEAN"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1388:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1388:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1388:11: ( '^' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='^') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1388:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1388:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1390:10: ( ( '0' .. '9' )+ )
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1390:12: ( '0' .. '9' )+
            {
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1390:12: ( '0' .. '9' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1390:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1392:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1392:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1392:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='\"') ) {
                alt7=1;
            }
            else if ( (LA7_0=='\'') ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1392:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1392:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop5:
                    do {
                        int alt5=3;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='\\') ) {
                            alt5=1;
                        }
                        else if ( ((LA5_0>='\u0000' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                            alt5=2;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1392:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1392:66: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1392:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1392:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop6:
                    do {
                        int alt6=3;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0=='\\') ) {
                            alt6=1;
                        }
                        else if ( ((LA6_0>='\u0000' && LA6_0<='&')||(LA6_0>='(' && LA6_0<='[')||(LA6_0>=']' && LA6_0<='\uFFFF')) ) {
                            alt6=2;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1392:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1392:137: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1394:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1394:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1394:24: ( options {greedy=false; } : . )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='*') ) {
                    int LA8_1 = input.LA(2);

                    if ( (LA8_1=='/') ) {
                        alt8=2;
                    }
                    else if ( ((LA8_1>='\u0000' && LA8_1<='.')||(LA8_1>='0' && LA8_1<='\uFFFF')) ) {
                        alt8=1;
                    }


                }
                else if ( ((LA8_0>='\u0000' && LA8_0<=')')||(LA8_0>='+' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1394:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1396:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1396:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1396:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='\u0000' && LA9_0<='\t')||(LA9_0>='\u000B' && LA9_0<='\f')||(LA9_0>='\u000E' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1396:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1396:40: ( ( '\\r' )? '\\n' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\n'||LA11_0=='\r') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1396:41: ( '\\r' )? '\\n'
                    {
                    // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1396:41: ( '\\r' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='\r') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1396:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1398:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1398:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1398:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1400:16: ( . )
            // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1400:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1:8: ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | RULE_BOOLEAN | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt13=30;
        alt13 = dfa13.predict(input);
        switch (alt13) {
            case 1 :
                // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1:10: T__12
                {
                mT__12(); 

                }
                break;
            case 2 :
                // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1:16: T__13
                {
                mT__13(); 

                }
                break;
            case 3 :
                // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1:22: T__14
                {
                mT__14(); 

                }
                break;
            case 4 :
                // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1:28: T__15
                {
                mT__15(); 

                }
                break;
            case 5 :
                // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1:34: T__16
                {
                mT__16(); 

                }
                break;
            case 6 :
                // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1:40: T__17
                {
                mT__17(); 

                }
                break;
            case 7 :
                // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1:46: T__18
                {
                mT__18(); 

                }
                break;
            case 8 :
                // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1:52: T__19
                {
                mT__19(); 

                }
                break;
            case 9 :
                // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1:58: T__20
                {
                mT__20(); 

                }
                break;
            case 10 :
                // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1:64: T__21
                {
                mT__21(); 

                }
                break;
            case 11 :
                // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1:70: T__22
                {
                mT__22(); 

                }
                break;
            case 12 :
                // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1:76: T__23
                {
                mT__23(); 

                }
                break;
            case 13 :
                // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1:82: T__24
                {
                mT__24(); 

                }
                break;
            case 14 :
                // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1:88: T__25
                {
                mT__25(); 

                }
                break;
            case 15 :
                // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1:94: T__26
                {
                mT__26(); 

                }
                break;
            case 16 :
                // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1:100: T__27
                {
                mT__27(); 

                }
                break;
            case 17 :
                // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1:106: T__28
                {
                mT__28(); 

                }
                break;
            case 18 :
                // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1:112: T__29
                {
                mT__29(); 

                }
                break;
            case 19 :
                // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1:118: T__30
                {
                mT__30(); 

                }
                break;
            case 20 :
                // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1:124: T__31
                {
                mT__31(); 

                }
                break;
            case 21 :
                // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1:130: T__32
                {
                mT__32(); 

                }
                break;
            case 22 :
                // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1:136: T__33
                {
                mT__33(); 

                }
                break;
            case 23 :
                // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1:142: RULE_BOOLEAN
                {
                mRULE_BOOLEAN(); 

                }
                break;
            case 24 :
                // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1:155: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 25 :
                // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1:163: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 26 :
                // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1:172: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 27 :
                // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1:184: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 28 :
                // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1:200: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 29 :
                // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1:216: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 30 :
                // ../de.upb.lina.lll.expressions/src-gen/de/upb/lina/lll/parser/antlr/internal/InternalExpressions.g:1:224: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA13_eotS =
        "\1\uffff\6\36\2\uffff\1\47\1\51\1\uffff\1\34\4\uffff\1\62\1\uffff"+
        "\1\64\1\uffff\2\36\2\uffff\2\34\2\uffff\1\36\1\uffff\1\36\1\75\3"+
        "\36\22\uffff\2\36\3\uffff\2\36\1\uffff\1\105\1\106\1\107\4\36\3"+
        "\uffff\1\114\1\36\1\116\1\117\1\uffff\1\114\2\uffff";
    static final String DFA13_eofS =
        "\120\uffff";
    static final String DFA13_minS =
        "\1\0\1\161\1\155\1\162\1\157\1\156\1\157\2\uffff\2\75\1\uffff\1"+
        "\75\4\uffff\1\52\1\uffff\1\101\1\uffff\1\162\1\141\2\uffff\2\0\2"+
        "\uffff\1\165\1\uffff\1\160\1\60\1\162\1\144\1\164\22\uffff\1\165"+
        "\1\154\3\uffff\1\151\1\154\1\uffff\3\60\1\145\1\163\1\166\1\171"+
        "\3\uffff\1\60\1\145\2\60\1\uffff\1\60\2\uffff";
    static final String DFA13_maxS =
        "\1\uffff\1\161\1\155\1\162\1\157\1\156\1\157\2\uffff\2\75\1\uffff"+
        "\1\75\4\uffff\1\57\1\uffff\1\172\1\uffff\1\162\1\141\2\uffff\2\uffff"+
        "\2\uffff\1\165\1\uffff\1\160\1\172\1\162\1\144\1\164\22\uffff\1"+
        "\165\1\154\3\uffff\1\151\1\154\1\uffff\3\172\1\145\1\163\1\166\1"+
        "\171\3\uffff\1\172\1\145\2\172\1\uffff\1\172\2\uffff";
    static final String DFA13_acceptS =
        "\7\uffff\1\7\1\10\2\uffff\1\15\1\uffff\1\17\1\20\1\21\1\22\1\uffff"+
        "\1\24\1\uffff\1\26\2\uffff\1\30\1\31\2\uffff\1\35\1\36\1\uffff\1"+
        "\30\5\uffff\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21"+
        "\1\22\1\33\1\34\1\23\1\24\1\25\1\26\2\uffff\1\31\1\32\1\35\2\uffff"+
        "\1\3\7\uffff\1\4\1\5\1\6\4\uffff\1\27\1\uffff\1\1\1\2";
    static final String DFA13_specialS =
        "\1\0\30\uffff\1\1\1\2\65\uffff}>";
    static final String[] DFA13_transitionS = {
            "\11\34\2\33\2\34\1\33\22\34\1\33\1\14\1\31\2\34\1\22\1\34\1"+
            "\32\1\7\1\10\1\20\1\16\1\34\1\17\1\24\1\21\12\30\2\34\1\11\1"+
            "\13\1\12\2\34\32\27\3\34\1\23\1\27\1\34\1\5\3\27\1\1\1\26\2"+
            "\27\1\2\4\27\1\6\1\3\4\27\1\25\3\27\1\4\2\27\3\34\1\15\uff81"+
            "\34",
            "\1\35",
            "\1\37",
            "\1\40",
            "\1\41",
            "\1\42",
            "\1\43",
            "",
            "",
            "\1\46",
            "\1\50",
            "",
            "\1\53",
            "",
            "",
            "",
            "",
            "\1\60\4\uffff\1\61",
            "",
            "\32\36\4\uffff\1\36\1\uffff\32\36",
            "",
            "\1\66",
            "\1\67",
            "",
            "",
            "\0\71",
            "\0\71",
            "",
            "",
            "\1\73",
            "",
            "\1\74",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\76",
            "\1\77",
            "\1\100",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\101",
            "\1\102",
            "",
            "",
            "",
            "\1\103",
            "\1\104",
            "",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "",
            "",
            "",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\115",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | RULE_BOOLEAN | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA13_0 = input.LA(1);

                        s = -1;
                        if ( (LA13_0=='e') ) {s = 1;}

                        else if ( (LA13_0=='i') ) {s = 2;}

                        else if ( (LA13_0=='o') ) {s = 3;}

                        else if ( (LA13_0=='x') ) {s = 4;}

                        else if ( (LA13_0=='a') ) {s = 5;}

                        else if ( (LA13_0=='n') ) {s = 6;}

                        else if ( (LA13_0=='(') ) {s = 7;}

                        else if ( (LA13_0==')') ) {s = 8;}

                        else if ( (LA13_0=='<') ) {s = 9;}

                        else if ( (LA13_0=='>') ) {s = 10;}

                        else if ( (LA13_0=='=') ) {s = 11;}

                        else if ( (LA13_0=='!') ) {s = 12;}

                        else if ( (LA13_0=='~') ) {s = 13;}

                        else if ( (LA13_0=='+') ) {s = 14;}

                        else if ( (LA13_0=='-') ) {s = 15;}

                        else if ( (LA13_0=='*') ) {s = 16;}

                        else if ( (LA13_0=='/') ) {s = 17;}

                        else if ( (LA13_0=='%') ) {s = 18;}

                        else if ( (LA13_0=='^') ) {s = 19;}

                        else if ( (LA13_0=='.') ) {s = 20;}

                        else if ( (LA13_0=='t') ) {s = 21;}

                        else if ( (LA13_0=='f') ) {s = 22;}

                        else if ( ((LA13_0>='A' && LA13_0<='Z')||LA13_0=='_'||(LA13_0>='b' && LA13_0<='d')||(LA13_0>='g' && LA13_0<='h')||(LA13_0>='j' && LA13_0<='m')||(LA13_0>='p' && LA13_0<='s')||(LA13_0>='u' && LA13_0<='w')||(LA13_0>='y' && LA13_0<='z')) ) {s = 23;}

                        else if ( ((LA13_0>='0' && LA13_0<='9')) ) {s = 24;}

                        else if ( (LA13_0=='\"') ) {s = 25;}

                        else if ( (LA13_0=='\'') ) {s = 26;}

                        else if ( ((LA13_0>='\t' && LA13_0<='\n')||LA13_0=='\r'||LA13_0==' ') ) {s = 27;}

                        else if ( ((LA13_0>='\u0000' && LA13_0<='\b')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\u001F')||(LA13_0>='#' && LA13_0<='$')||LA13_0=='&'||LA13_0==','||(LA13_0>=':' && LA13_0<=';')||(LA13_0>='?' && LA13_0<='@')||(LA13_0>='[' && LA13_0<=']')||LA13_0=='`'||(LA13_0>='{' && LA13_0<='}')||(LA13_0>='\u007F' && LA13_0<='\uFFFF')) ) {s = 28;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA13_25 = input.LA(1);

                        s = -1;
                        if ( ((LA13_25>='\u0000' && LA13_25<='\uFFFF')) ) {s = 57;}

                        else s = 28;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA13_26 = input.LA(1);

                        s = -1;
                        if ( ((LA13_26>='\u0000' && LA13_26<='\uFFFF')) ) {s = 57;}

                        else s = 28;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 13, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}