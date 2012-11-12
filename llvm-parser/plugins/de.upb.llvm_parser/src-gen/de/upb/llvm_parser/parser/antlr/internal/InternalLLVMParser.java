package de.upb.llvm_parser.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import de.upb.llvm_parser.services.LLVMGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalLLVMParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SL_COMMENT", "RULE_STRING", "RULE_VAR_TYPE", "RULE_INTEGER", "RULE_INT", "RULE_NOBRACKET", "RULE_POINT", "RULE_ID", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'module'", "'asm'", "'target'", "'datalayout'", "'triple'", "'='", "'deplibs'", "'['", "','", "']'", "'define'", "'unnamed_addr'", "'section '", "'declare'", "'(...)'", "'('", "')'", "'{'", "'}'", "'type'", "'alias'", "'<'", "'>'", "'void'", "'null'", "'label'", "'undef'", "'half'", "'float'", "'double'", "'x86_fp80'", "'fp128'", "'ppc_fp128'", "'getelementptr'", "'inbounds'", "'extractvalue'", "'insertvalue'", "'fence'", "'singlethread'", "'unordered'", "'monotonic'", "'aquire'", "'release'", "'acq_rel'", "'seq_cst'", "'cmpxchg'", "'volatile'", "'atomicrmw'", "'xchg'", "'add'", "'sub'", "'and'", "'nand'", "'or'", "'xor'", "'max'", "'min'", "'umax'", "'umin'", "'load'", "'!nontemporal'", "'!'", "'atomic'", "'align'", "'store'", "'tail'", "'call'", "'zeroext'", "'signext'", "'inreg'", "'byval'", "'sret'", "'noalias'", "'nocapture'", "'nest'", "'alloca'", "'ccc'", "'fastcc'", "'coldcc'", "'x86_stdcallcc'", "'x86_fastcallcc'", "'x86_thiscallcc'", "'arm_apcscc'", "'arm_aapcscc'", "'arm_aapcs_vfpcc'", "'msp430_intrcc'", "'ptx_kernel'", "'ptx_device'", "'spir_func'", "'spir_kernel'", "'cc'", "'address_safety'", "'alignstack'", "'alwaysinline'", "'nonlazybind'", "'inlinehint'", "'naked'", "'noimplicitfloat'", "'noinline'", "'noredzone'", "'noreturn'", "'nounwind'", "'optsize'", "'readnone'", "'readonly'", "'returns_twice'", "'ssp'", "'sspreq'", "'uwtable'", "'phi'", "'landingpad'", "'personality'", "'cleanup'", "'(...)*'", "'to'", "'catch'", "'filter'", "'select'", "'va_arg'", "'extractelement'", "'insertelement'", "'shufflevector'", "'trunc'", "'zext'", "'sext'", "'fptrunc'", "'fpext'", "'fptoui'", "'fptosi'", "'uitofp'", "'sitofp'", "'ptrtoint'", "'inttoptr'", "'bitcast'", "'icmp'", "'fcmp'", "'eq'", "'ne'", "'ugt'", "'uge'", "'ult'", "'ule'", "'sgt'", "'sge'", "'slt'", "'sle'", "'false'", "'oeq'", "'ogt'", "'oge'", "'olt'", "'ole'", "'one'", "'ord'", "'ueq'", "'une'", "'uno'", "'true'", "'fadd'", "'fsub'", "'mul'", "'fmul'", "'udiv'", "'sdiv'", "'fdiv'", "'urem'", "'srem'", "'frem'", "'shl'", "'lshr'", "'ashr'", "'indirectbr'", "'switch'", "'invoke'", "'unwind'", "'resume'", "'ret'", "'!dbg'", "'br'", "':'", "'default'", "'hidden'", "'protected'", "'private'", "'linker_private'", "'linker_private_weak'", "'available_externally'", "'linkonce'", "'common'", "'appending'", "'extern_weak'", "'linkonce_odr'", "'linkonce_odr_auto_hide'", "'dllimport'", "'dllexport'", "'external'", "'internal'", "'weak'", "'weak_odr'"
    };
    public static final int RULE_ID=11;
    public static final int RULE_VAR_TYPE=6;
    public static final int T__159=159;
    public static final int T__158=158;
    public static final int RULE_ANY_OTHER=14;
    public static final int T__160=160;
    public static final int T__167=167;
    public static final int EOF=-1;
    public static final int T__168=168;
    public static final int T__165=165;
    public static final int T__166=166;
    public static final int T__163=163;
    public static final int T__164=164;
    public static final int T__161=161;
    public static final int T__162=162;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__148=148;
    public static final int T__90=90;
    public static final int T__147=147;
    public static final int T__149=149;
    public static final int T__154=154;
    public static final int T__155=155;
    public static final int T__156=156;
    public static final int T__99=99;
    public static final int T__157=157;
    public static final int T__98=98;
    public static final int T__150=150;
    public static final int T__97=97;
    public static final int T__151=151;
    public static final int T__96=96;
    public static final int T__152=152;
    public static final int T__95=95;
    public static final int T__153=153;
    public static final int T__139=139;
    public static final int T__138=138;
    public static final int T__137=137;
    public static final int T__136=136;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int T__85=85;
    public static final int T__141=141;
    public static final int T__84=84;
    public static final int T__142=142;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__140=140;
    public static final int T__89=89;
    public static final int T__145=145;
    public static final int T__88=88;
    public static final int T__146=146;
    public static final int RULE_ML_COMMENT=12;
    public static final int T__143=143;
    public static final int T__144=144;
    public static final int T__126=126;
    public static final int T__125=125;
    public static final int T__128=128;
    public static final int RULE_STRING=5;
    public static final int T__127=127;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__129=129;
    public static final int T__70=70;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__130=130;
    public static final int T__73=73;
    public static final int T__131=131;
    public static final int T__132=132;
    public static final int T__79=79;
    public static final int T__133=133;
    public static final int T__78=78;
    public static final int T__134=134;
    public static final int T__77=77;
    public static final int T__135=135;
    public static final int T__213=213;
    public static final int T__118=118;
    public static final int T__119=119;
    public static final int T__116=116;
    public static final int T__117=117;
    public static final int T__114=114;
    public static final int T__115=115;
    public static final int T__124=124;
    public static final int T__123=123;
    public static final int T__122=122;
    public static final int T__121=121;
    public static final int T__120=120;
    public static final int T__202=202;
    public static final int T__203=203;
    public static final int T__204=204;
    public static final int T__205=205;
    public static final int T__206=206;
    public static final int T__207=207;
    public static final int T__208=208;
    public static final int T__209=209;
    public static final int T__107=107;
    public static final int T__108=108;
    public static final int T__109=109;
    public static final int T__103=103;
    public static final int T__104=104;
    public static final int T__105=105;
    public static final int T__106=106;
    public static final int T__111=111;
    public static final int T__110=110;
    public static final int T__113=113;
    public static final int T__112=112;
    public static final int T__210=210;
    public static final int T__212=212;
    public static final int RULE_NOBRACKET=9;
    public static final int T__211=211;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int RULE_SL_COMMENT=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__200=200;
    public static final int T__201=201;
    public static final int RULE_INTEGER=7;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__199=199;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__198=198;
    public static final int T__51=51;
    public static final int T__197=197;
    public static final int T__52=52;
    public static final int T__196=196;
    public static final int T__53=53;
    public static final int T__195=195;
    public static final int T__54=54;
    public static final int T__194=194;
    public static final int T__193=193;
    public static final int RULE_POINT=10;
    public static final int T__192=192;
    public static final int T__191=191;
    public static final int T__190=190;
    public static final int T__59=59;
    public static final int RULE_INT=8;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__184=184;
    public static final int T__43=43;
    public static final int T__183=183;
    public static final int T__40=40;
    public static final int T__186=186;
    public static final int T__41=41;
    public static final int T__185=185;
    public static final int T__46=46;
    public static final int T__188=188;
    public static final int T__47=47;
    public static final int T__187=187;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__189=189;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__180=180;
    public static final int T__182=182;
    public static final int T__181=181;
    public static final int T__175=175;
    public static final int T__30=30;
    public static final int T__174=174;
    public static final int T__31=31;
    public static final int T__173=173;
    public static final int T__32=32;
    public static final int T__172=172;
    public static final int T__33=33;
    public static final int T__179=179;
    public static final int T__34=34;
    public static final int T__178=178;
    public static final int T__35=35;
    public static final int T__177=177;
    public static final int T__36=36;
    public static final int T__176=176;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__171=171;
    public static final int T__170=170;
    public static final int RULE_WS=13;
    public static final int T__169=169;

    // delegates
    // delegators


        public InternalLLVMParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalLLVMParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalLLVMParser.tokenNames; }
    public String getGrammarFileName() { return "../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g"; }



     	private LLVMGrammarAccess grammarAccess;
     	
        public InternalLLVMParser(TokenStream input, LLVMGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "LLVM";	
       	}
       	
       	@Override
       	protected LLVMGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleLLVM"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:67:1: entryRuleLLVM returns [EObject current=null] : iv_ruleLLVM= ruleLLVM EOF ;
    public final EObject entryRuleLLVM() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLLVM = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:68:2: (iv_ruleLLVM= ruleLLVM EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:69:2: iv_ruleLLVM= ruleLLVM EOF
            {
             newCompositeNode(grammarAccess.getLLVMRule()); 
            pushFollow(FOLLOW_ruleLLVM_in_entryRuleLLVM75);
            iv_ruleLLVM=ruleLLVM();

            state._fsp--;

             current =iv_ruleLLVM; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLLVM85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLLVM"


    // $ANTLR start "ruleLLVM"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:76:1: ruleLLVM returns [EObject current=null] : ( (lv_elements_0_0= ruleAbstractElement ) )* ;
    public final EObject ruleLLVM() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:79:28: ( ( (lv_elements_0_0= ruleAbstractElement ) )* )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:80:1: ( (lv_elements_0_0= ruleAbstractElement ) )*
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:80:1: ( (lv_elements_0_0= ruleAbstractElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_VAR_TYPE && LA1_0<=RULE_INT)||LA1_0==15||LA1_0==17||LA1_0==21||LA1_0==25||LA1_0==28||LA1_0==32||LA1_0==36||(LA1_0>=38 && LA1_0<=47)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:81:1: (lv_elements_0_0= ruleAbstractElement )
            	    {
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:81:1: (lv_elements_0_0= ruleAbstractElement )
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:82:3: lv_elements_0_0= ruleAbstractElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLLVMAccess().getElementsAbstractElementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractElement_in_ruleLLVM130);
            	    lv_elements_0_0=ruleAbstractElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getLLVMRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"elements",
            	            		lv_elements_0_0, 
            	            		"AbstractElement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLLVM"


    // $ANTLR start "entryRuleAbstractElement"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:106:1: entryRuleAbstractElement returns [EObject current=null] : iv_ruleAbstractElement= ruleAbstractElement EOF ;
    public final EObject entryRuleAbstractElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractElement = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:107:2: (iv_ruleAbstractElement= ruleAbstractElement EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:108:2: iv_ruleAbstractElement= ruleAbstractElement EOF
            {
             newCompositeNode(grammarAccess.getAbstractElementRule()); 
            pushFollow(FOLLOW_ruleAbstractElement_in_entryRuleAbstractElement166);
            iv_ruleAbstractElement=ruleAbstractElement();

            state._fsp--;

             current =iv_ruleAbstractElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractElement176); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractElement"


    // $ANTLR start "ruleAbstractElement"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:115:1: ruleAbstractElement returns [EObject current=null] : ( (this_TopLevelEntity_0= ruleTopLevelEntity (this_SL_COMMENT_1= RULE_SL_COMMENT )? ) | (this_MainLevelEntity_2= ruleMainLevelEntity (this_SL_COMMENT_3= RULE_SL_COMMENT )? ) ) ;
    public final EObject ruleAbstractElement() throws RecognitionException {
        EObject current = null;

        Token this_SL_COMMENT_1=null;
        Token this_SL_COMMENT_3=null;
        EObject this_TopLevelEntity_0 = null;

        EObject this_MainLevelEntity_2 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:118:28: ( ( (this_TopLevelEntity_0= ruleTopLevelEntity (this_SL_COMMENT_1= RULE_SL_COMMENT )? ) | (this_MainLevelEntity_2= ruleMainLevelEntity (this_SL_COMMENT_3= RULE_SL_COMMENT )? ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:119:1: ( (this_TopLevelEntity_0= ruleTopLevelEntity (this_SL_COMMENT_1= RULE_SL_COMMENT )? ) | (this_MainLevelEntity_2= ruleMainLevelEntity (this_SL_COMMENT_3= RULE_SL_COMMENT )? ) )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:119:1: ( (this_TopLevelEntity_0= ruleTopLevelEntity (this_SL_COMMENT_1= RULE_SL_COMMENT )? ) | (this_MainLevelEntity_2= ruleMainLevelEntity (this_SL_COMMENT_3= RULE_SL_COMMENT )? ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15||LA4_0==17||LA4_0==21) ) {
                alt4=1;
            }
            else if ( ((LA4_0>=RULE_VAR_TYPE && LA4_0<=RULE_INT)||LA4_0==25||LA4_0==28||LA4_0==32||LA4_0==36||(LA4_0>=38 && LA4_0<=47)) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:119:2: (this_TopLevelEntity_0= ruleTopLevelEntity (this_SL_COMMENT_1= RULE_SL_COMMENT )? )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:119:2: (this_TopLevelEntity_0= ruleTopLevelEntity (this_SL_COMMENT_1= RULE_SL_COMMENT )? )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:120:5: this_TopLevelEntity_0= ruleTopLevelEntity (this_SL_COMMENT_1= RULE_SL_COMMENT )?
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractElementAccess().getTopLevelEntityParserRuleCall_0_0()); 
                        
                    pushFollow(FOLLOW_ruleTopLevelEntity_in_ruleAbstractElement224);
                    this_TopLevelEntity_0=ruleTopLevelEntity();

                    state._fsp--;

                     
                            current = this_TopLevelEntity_0; 
                            afterParserOrEnumRuleCall();
                        
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:128:1: (this_SL_COMMENT_1= RULE_SL_COMMENT )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==RULE_SL_COMMENT) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:128:2: this_SL_COMMENT_1= RULE_SL_COMMENT
                            {
                            this_SL_COMMENT_1=(Token)match(input,RULE_SL_COMMENT,FOLLOW_RULE_SL_COMMENT_in_ruleAbstractElement235); 
                             
                                newLeafNode(this_SL_COMMENT_1, grammarAccess.getAbstractElementAccess().getSL_COMMENTTerminalRuleCall_0_1()); 
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:133:6: (this_MainLevelEntity_2= ruleMainLevelEntity (this_SL_COMMENT_3= RULE_SL_COMMENT )? )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:133:6: (this_MainLevelEntity_2= ruleMainLevelEntity (this_SL_COMMENT_3= RULE_SL_COMMENT )? )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:134:5: this_MainLevelEntity_2= ruleMainLevelEntity (this_SL_COMMENT_3= RULE_SL_COMMENT )?
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractElementAccess().getMainLevelEntityParserRuleCall_1_0()); 
                        
                    pushFollow(FOLLOW_ruleMainLevelEntity_in_ruleAbstractElement266);
                    this_MainLevelEntity_2=ruleMainLevelEntity();

                    state._fsp--;

                     
                            current = this_MainLevelEntity_2; 
                            afterParserOrEnumRuleCall();
                        
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:142:1: (this_SL_COMMENT_3= RULE_SL_COMMENT )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==RULE_SL_COMMENT) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:142:2: this_SL_COMMENT_3= RULE_SL_COMMENT
                            {
                            this_SL_COMMENT_3=(Token)match(input,RULE_SL_COMMENT,FOLLOW_RULE_SL_COMMENT_in_ruleAbstractElement277); 
                             
                                newLeafNode(this_SL_COMMENT_3, grammarAccess.getAbstractElementAccess().getSL_COMMENTTerminalRuleCall_1_1()); 
                                

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractElement"


    // $ANTLR start "entryRuleTopLevelEntity"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:154:1: entryRuleTopLevelEntity returns [EObject current=null] : iv_ruleTopLevelEntity= ruleTopLevelEntity EOF ;
    public final EObject entryRuleTopLevelEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTopLevelEntity = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:155:2: (iv_ruleTopLevelEntity= ruleTopLevelEntity EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:156:2: iv_ruleTopLevelEntity= ruleTopLevelEntity EOF
            {
             newCompositeNode(grammarAccess.getTopLevelEntityRule()); 
            pushFollow(FOLLOW_ruleTopLevelEntity_in_entryRuleTopLevelEntity315);
            iv_ruleTopLevelEntity=ruleTopLevelEntity();

            state._fsp--;

             current =iv_ruleTopLevelEntity; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTopLevelEntity325); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTopLevelEntity"


    // $ANTLR start "ruleTopLevelEntity"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:163:1: ruleTopLevelEntity returns [EObject current=null] : ( (otherlv_0= 'module' otherlv_1= 'asm' ( (lv_module_2_0= RULE_STRING ) ) ) | (otherlv_3= 'target' (otherlv_4= 'datalayout' | otherlv_5= 'triple' ) otherlv_6= '=' ( (lv_target_7_0= RULE_STRING ) ) ) | (otherlv_8= 'deplibs' otherlv_9= '=' otherlv_10= '[' ( (lv_libs_11_0= RULE_STRING ) ) (otherlv_12= ',' ( (lv_libs_13_0= RULE_STRING ) ) )* otherlv_14= ']' ) ) ;
    public final EObject ruleTopLevelEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_module_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_target_7_0=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token lv_libs_11_0=null;
        Token otherlv_12=null;
        Token lv_libs_13_0=null;
        Token otherlv_14=null;

         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:166:28: ( ( (otherlv_0= 'module' otherlv_1= 'asm' ( (lv_module_2_0= RULE_STRING ) ) ) | (otherlv_3= 'target' (otherlv_4= 'datalayout' | otherlv_5= 'triple' ) otherlv_6= '=' ( (lv_target_7_0= RULE_STRING ) ) ) | (otherlv_8= 'deplibs' otherlv_9= '=' otherlv_10= '[' ( (lv_libs_11_0= RULE_STRING ) ) (otherlv_12= ',' ( (lv_libs_13_0= RULE_STRING ) ) )* otherlv_14= ']' ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:167:1: ( (otherlv_0= 'module' otherlv_1= 'asm' ( (lv_module_2_0= RULE_STRING ) ) ) | (otherlv_3= 'target' (otherlv_4= 'datalayout' | otherlv_5= 'triple' ) otherlv_6= '=' ( (lv_target_7_0= RULE_STRING ) ) ) | (otherlv_8= 'deplibs' otherlv_9= '=' otherlv_10= '[' ( (lv_libs_11_0= RULE_STRING ) ) (otherlv_12= ',' ( (lv_libs_13_0= RULE_STRING ) ) )* otherlv_14= ']' ) )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:167:1: ( (otherlv_0= 'module' otherlv_1= 'asm' ( (lv_module_2_0= RULE_STRING ) ) ) | (otherlv_3= 'target' (otherlv_4= 'datalayout' | otherlv_5= 'triple' ) otherlv_6= '=' ( (lv_target_7_0= RULE_STRING ) ) ) | (otherlv_8= 'deplibs' otherlv_9= '=' otherlv_10= '[' ( (lv_libs_11_0= RULE_STRING ) ) (otherlv_12= ',' ( (lv_libs_13_0= RULE_STRING ) ) )* otherlv_14= ']' ) )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt7=1;
                }
                break;
            case 17:
                {
                alt7=2;
                }
                break;
            case 21:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:167:2: (otherlv_0= 'module' otherlv_1= 'asm' ( (lv_module_2_0= RULE_STRING ) ) )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:167:2: (otherlv_0= 'module' otherlv_1= 'asm' ( (lv_module_2_0= RULE_STRING ) ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:167:4: otherlv_0= 'module' otherlv_1= 'asm' ( (lv_module_2_0= RULE_STRING ) )
                    {
                    otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleTopLevelEntity363); 

                        	newLeafNode(otherlv_0, grammarAccess.getTopLevelEntityAccess().getModuleKeyword_0_0());
                        
                    otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleTopLevelEntity375); 

                        	newLeafNode(otherlv_1, grammarAccess.getTopLevelEntityAccess().getAsmKeyword_0_1());
                        
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:175:1: ( (lv_module_2_0= RULE_STRING ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:176:1: (lv_module_2_0= RULE_STRING )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:176:1: (lv_module_2_0= RULE_STRING )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:177:3: lv_module_2_0= RULE_STRING
                    {
                    lv_module_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleTopLevelEntity392); 

                    			newLeafNode(lv_module_2_0, grammarAccess.getTopLevelEntityAccess().getModuleSTRINGTerminalRuleCall_0_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTopLevelEntityRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"module",
                            		lv_module_2_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:194:6: (otherlv_3= 'target' (otherlv_4= 'datalayout' | otherlv_5= 'triple' ) otherlv_6= '=' ( (lv_target_7_0= RULE_STRING ) ) )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:194:6: (otherlv_3= 'target' (otherlv_4= 'datalayout' | otherlv_5= 'triple' ) otherlv_6= '=' ( (lv_target_7_0= RULE_STRING ) ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:194:8: otherlv_3= 'target' (otherlv_4= 'datalayout' | otherlv_5= 'triple' ) otherlv_6= '=' ( (lv_target_7_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleTopLevelEntity417); 

                        	newLeafNode(otherlv_3, grammarAccess.getTopLevelEntityAccess().getTargetKeyword_1_0());
                        
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:198:1: (otherlv_4= 'datalayout' | otherlv_5= 'triple' )
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==18) ) {
                        alt5=1;
                    }
                    else if ( (LA5_0==19) ) {
                        alt5=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 0, input);

                        throw nvae;
                    }
                    switch (alt5) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:198:3: otherlv_4= 'datalayout'
                            {
                            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleTopLevelEntity430); 

                                	newLeafNode(otherlv_4, grammarAccess.getTopLevelEntityAccess().getDatalayoutKeyword_1_1_0());
                                

                            }
                            break;
                        case 2 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:203:7: otherlv_5= 'triple'
                            {
                            otherlv_5=(Token)match(input,19,FOLLOW_19_in_ruleTopLevelEntity448); 

                                	newLeafNode(otherlv_5, grammarAccess.getTopLevelEntityAccess().getTripleKeyword_1_1_1());
                                

                            }
                            break;

                    }

                    otherlv_6=(Token)match(input,20,FOLLOW_20_in_ruleTopLevelEntity461); 

                        	newLeafNode(otherlv_6, grammarAccess.getTopLevelEntityAccess().getEqualsSignKeyword_1_2());
                        
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:211:1: ( (lv_target_7_0= RULE_STRING ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:212:1: (lv_target_7_0= RULE_STRING )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:212:1: (lv_target_7_0= RULE_STRING )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:213:3: lv_target_7_0= RULE_STRING
                    {
                    lv_target_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleTopLevelEntity478); 

                    			newLeafNode(lv_target_7_0, grammarAccess.getTopLevelEntityAccess().getTargetSTRINGTerminalRuleCall_1_3_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTopLevelEntityRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"target",
                            		lv_target_7_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:230:6: (otherlv_8= 'deplibs' otherlv_9= '=' otherlv_10= '[' ( (lv_libs_11_0= RULE_STRING ) ) (otherlv_12= ',' ( (lv_libs_13_0= RULE_STRING ) ) )* otherlv_14= ']' )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:230:6: (otherlv_8= 'deplibs' otherlv_9= '=' otherlv_10= '[' ( (lv_libs_11_0= RULE_STRING ) ) (otherlv_12= ',' ( (lv_libs_13_0= RULE_STRING ) ) )* otherlv_14= ']' )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:230:8: otherlv_8= 'deplibs' otherlv_9= '=' otherlv_10= '[' ( (lv_libs_11_0= RULE_STRING ) ) (otherlv_12= ',' ( (lv_libs_13_0= RULE_STRING ) ) )* otherlv_14= ']'
                    {
                    otherlv_8=(Token)match(input,21,FOLLOW_21_in_ruleTopLevelEntity503); 

                        	newLeafNode(otherlv_8, grammarAccess.getTopLevelEntityAccess().getDeplibsKeyword_2_0());
                        
                    otherlv_9=(Token)match(input,20,FOLLOW_20_in_ruleTopLevelEntity515); 

                        	newLeafNode(otherlv_9, grammarAccess.getTopLevelEntityAccess().getEqualsSignKeyword_2_1());
                        
                    otherlv_10=(Token)match(input,22,FOLLOW_22_in_ruleTopLevelEntity527); 

                        	newLeafNode(otherlv_10, grammarAccess.getTopLevelEntityAccess().getLeftSquareBracketKeyword_2_2());
                        
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:242:1: ( (lv_libs_11_0= RULE_STRING ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:243:1: (lv_libs_11_0= RULE_STRING )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:243:1: (lv_libs_11_0= RULE_STRING )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:244:3: lv_libs_11_0= RULE_STRING
                    {
                    lv_libs_11_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleTopLevelEntity544); 

                    			newLeafNode(lv_libs_11_0, grammarAccess.getTopLevelEntityAccess().getLibsSTRINGTerminalRuleCall_2_3_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTopLevelEntityRule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"libs",
                            		lv_libs_11_0, 
                            		"STRING");
                    	    

                    }


                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:260:2: (otherlv_12= ',' ( (lv_libs_13_0= RULE_STRING ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==23) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:260:4: otherlv_12= ',' ( (lv_libs_13_0= RULE_STRING ) )
                    	    {
                    	    otherlv_12=(Token)match(input,23,FOLLOW_23_in_ruleTopLevelEntity562); 

                    	        	newLeafNode(otherlv_12, grammarAccess.getTopLevelEntityAccess().getCommaKeyword_2_4_0());
                    	        
                    	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:264:1: ( (lv_libs_13_0= RULE_STRING ) )
                    	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:265:1: (lv_libs_13_0= RULE_STRING )
                    	    {
                    	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:265:1: (lv_libs_13_0= RULE_STRING )
                    	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:266:3: lv_libs_13_0= RULE_STRING
                    	    {
                    	    lv_libs_13_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleTopLevelEntity579); 

                    	    			newLeafNode(lv_libs_13_0, grammarAccess.getTopLevelEntityAccess().getLibsSTRINGTerminalRuleCall_2_4_1_0()); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getTopLevelEntityRule());
                    	    	        }
                    	           		addWithLastConsumed(
                    	           			current, 
                    	           			"libs",
                    	            		lv_libs_13_0, 
                    	            		"STRING");
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,24,FOLLOW_24_in_ruleTopLevelEntity598); 

                        	newLeafNode(otherlv_14, grammarAccess.getTopLevelEntityAccess().getRightSquareBracketKeyword_2_5());
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTopLevelEntity"


    // $ANTLR start "entryRuleMainLevelEntity"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:294:1: entryRuleMainLevelEntity returns [EObject current=null] : iv_ruleMainLevelEntity= ruleMainLevelEntity EOF ;
    public final EObject entryRuleMainLevelEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMainLevelEntity = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:295:2: (iv_ruleMainLevelEntity= ruleMainLevelEntity EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:296:2: iv_ruleMainLevelEntity= ruleMainLevelEntity EOF
            {
             newCompositeNode(grammarAccess.getMainLevelEntityRule()); 
            pushFollow(FOLLOW_ruleMainLevelEntity_in_entryRuleMainLevelEntity635);
            iv_ruleMainLevelEntity=ruleMainLevelEntity();

            state._fsp--;

             current =iv_ruleMainLevelEntity; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMainLevelEntity645); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMainLevelEntity"


    // $ANTLR start "ruleMainLevelEntity"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:303:1: ruleMainLevelEntity returns [EObject current=null] : (this_FunctionHeader_0= ruleFunctionHeader | this_LocalVar_1= ruleLocalVar ) ;
    public final EObject ruleMainLevelEntity() throws RecognitionException {
        EObject current = null;

        EObject this_FunctionHeader_0 = null;

        EObject this_LocalVar_1 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:306:28: ( (this_FunctionHeader_0= ruleFunctionHeader | this_LocalVar_1= ruleLocalVar ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:307:1: (this_FunctionHeader_0= ruleFunctionHeader | this_LocalVar_1= ruleLocalVar )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:307:1: (this_FunctionHeader_0= ruleFunctionHeader | this_LocalVar_1= ruleLocalVar )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==25||LA8_0==28) ) {
                alt8=1;
            }
            else if ( ((LA8_0>=RULE_VAR_TYPE && LA8_0<=RULE_INT)||LA8_0==32||LA8_0==36||(LA8_0>=38 && LA8_0<=47)) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:308:5: this_FunctionHeader_0= ruleFunctionHeader
                    {
                     
                            newCompositeNode(grammarAccess.getMainLevelEntityAccess().getFunctionHeaderParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleFunctionHeader_in_ruleMainLevelEntity692);
                    this_FunctionHeader_0=ruleFunctionHeader();

                    state._fsp--;

                     
                            current = this_FunctionHeader_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:318:5: this_LocalVar_1= ruleLocalVar
                    {
                     
                            newCompositeNode(grammarAccess.getMainLevelEntityAccess().getLocalVarParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleLocalVar_in_ruleMainLevelEntity719);
                    this_LocalVar_1=ruleLocalVar();

                    state._fsp--;

                     
                            current = this_LocalVar_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMainLevelEntity"


    // $ANTLR start "entryRuleFunctionHeader"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:334:1: entryRuleFunctionHeader returns [EObject current=null] : iv_ruleFunctionHeader= ruleFunctionHeader EOF ;
    public final EObject entryRuleFunctionHeader() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionHeader = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:335:2: (iv_ruleFunctionHeader= ruleFunctionHeader EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:336:2: iv_ruleFunctionHeader= ruleFunctionHeader EOF
            {
             newCompositeNode(grammarAccess.getFunctionHeaderRule()); 
            pushFollow(FOLLOW_ruleFunctionHeader_in_entryRuleFunctionHeader754);
            iv_ruleFunctionHeader=ruleFunctionHeader();

            state._fsp--;

             current =iv_ruleFunctionHeader; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunctionHeader764); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionHeader"


    // $ANTLR start "ruleFunctionHeader"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:343:1: ruleFunctionHeader returns [EObject current=null] : ( (otherlv_0= 'define' ( ruleLINKAGE )? ( ruleVISIBILITY )? ( ruleCallingConv )? ( ruleRETURN_ATTRIBUTES )? ( (lv_returnType_5_0= ruleType ) ) ( (lv_name_6_0= RULE_VAR_TYPE ) ) ( (lv_pList_7_0= ruleParameterList ) ) (otherlv_8= 'unnamed_addr' )? ( ruleFUNCTION_ATTRIBUTES )? (otherlv_10= 'section ' this_STRING_11= RULE_STRING )? ( ruleALIGNMENT )? ( (lv_body_13_0= ruleFunctionBody ) ) ) | (otherlv_14= 'declare' ( ruleLINKAGE )? ( ruleVISIBILITY )? ( ruleCallingConv )? ( ruleRETURN_ATTRIBUTES )? ( (lv_returnType_19_0= ruleType ) ) ( (lv_name_20_0= RULE_VAR_TYPE ) ) ( ( (lv_tList_21_0= ruleTypeList ) ) | otherlv_22= '(...)' ) (otherlv_23= 'unnamed_addr' )? ( ruleFUNCTION_ATTRIBUTES )? (otherlv_25= 'section ' this_STRING_26= RULE_STRING )? ( ruleALIGNMENT )? ) ) ;
    public final EObject ruleFunctionHeader() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_6_0=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token this_STRING_11=null;
        Token otherlv_14=null;
        Token lv_name_20_0=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        Token this_STRING_26=null;
        AntlrDatatypeRuleToken lv_returnType_5_0 = null;

        EObject lv_pList_7_0 = null;

        EObject lv_body_13_0 = null;

        AntlrDatatypeRuleToken lv_returnType_19_0 = null;

        EObject lv_tList_21_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:346:28: ( ( (otherlv_0= 'define' ( ruleLINKAGE )? ( ruleVISIBILITY )? ( ruleCallingConv )? ( ruleRETURN_ATTRIBUTES )? ( (lv_returnType_5_0= ruleType ) ) ( (lv_name_6_0= RULE_VAR_TYPE ) ) ( (lv_pList_7_0= ruleParameterList ) ) (otherlv_8= 'unnamed_addr' )? ( ruleFUNCTION_ATTRIBUTES )? (otherlv_10= 'section ' this_STRING_11= RULE_STRING )? ( ruleALIGNMENT )? ( (lv_body_13_0= ruleFunctionBody ) ) ) | (otherlv_14= 'declare' ( ruleLINKAGE )? ( ruleVISIBILITY )? ( ruleCallingConv )? ( ruleRETURN_ATTRIBUTES )? ( (lv_returnType_19_0= ruleType ) ) ( (lv_name_20_0= RULE_VAR_TYPE ) ) ( ( (lv_tList_21_0= ruleTypeList ) ) | otherlv_22= '(...)' ) (otherlv_23= 'unnamed_addr' )? ( ruleFUNCTION_ATTRIBUTES )? (otherlv_25= 'section ' this_STRING_26= RULE_STRING )? ( ruleALIGNMENT )? ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:347:1: ( (otherlv_0= 'define' ( ruleLINKAGE )? ( ruleVISIBILITY )? ( ruleCallingConv )? ( ruleRETURN_ATTRIBUTES )? ( (lv_returnType_5_0= ruleType ) ) ( (lv_name_6_0= RULE_VAR_TYPE ) ) ( (lv_pList_7_0= ruleParameterList ) ) (otherlv_8= 'unnamed_addr' )? ( ruleFUNCTION_ATTRIBUTES )? (otherlv_10= 'section ' this_STRING_11= RULE_STRING )? ( ruleALIGNMENT )? ( (lv_body_13_0= ruleFunctionBody ) ) ) | (otherlv_14= 'declare' ( ruleLINKAGE )? ( ruleVISIBILITY )? ( ruleCallingConv )? ( ruleRETURN_ATTRIBUTES )? ( (lv_returnType_19_0= ruleType ) ) ( (lv_name_20_0= RULE_VAR_TYPE ) ) ( ( (lv_tList_21_0= ruleTypeList ) ) | otherlv_22= '(...)' ) (otherlv_23= 'unnamed_addr' )? ( ruleFUNCTION_ATTRIBUTES )? (otherlv_25= 'section ' this_STRING_26= RULE_STRING )? ( ruleALIGNMENT )? ) )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:347:1: ( (otherlv_0= 'define' ( ruleLINKAGE )? ( ruleVISIBILITY )? ( ruleCallingConv )? ( ruleRETURN_ATTRIBUTES )? ( (lv_returnType_5_0= ruleType ) ) ( (lv_name_6_0= RULE_VAR_TYPE ) ) ( (lv_pList_7_0= ruleParameterList ) ) (otherlv_8= 'unnamed_addr' )? ( ruleFUNCTION_ATTRIBUTES )? (otherlv_10= 'section ' this_STRING_11= RULE_STRING )? ( ruleALIGNMENT )? ( (lv_body_13_0= ruleFunctionBody ) ) ) | (otherlv_14= 'declare' ( ruleLINKAGE )? ( ruleVISIBILITY )? ( ruleCallingConv )? ( ruleRETURN_ATTRIBUTES )? ( (lv_returnType_19_0= ruleType ) ) ( (lv_name_20_0= RULE_VAR_TYPE ) ) ( ( (lv_tList_21_0= ruleTypeList ) ) | otherlv_22= '(...)' ) (otherlv_23= 'unnamed_addr' )? ( ruleFUNCTION_ATTRIBUTES )? (otherlv_25= 'section ' this_STRING_26= RULE_STRING )? ( ruleALIGNMENT )? ) )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==25) ) {
                alt26=1;
            }
            else if ( (LA26_0==28) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:347:2: (otherlv_0= 'define' ( ruleLINKAGE )? ( ruleVISIBILITY )? ( ruleCallingConv )? ( ruleRETURN_ATTRIBUTES )? ( (lv_returnType_5_0= ruleType ) ) ( (lv_name_6_0= RULE_VAR_TYPE ) ) ( (lv_pList_7_0= ruleParameterList ) ) (otherlv_8= 'unnamed_addr' )? ( ruleFUNCTION_ATTRIBUTES )? (otherlv_10= 'section ' this_STRING_11= RULE_STRING )? ( ruleALIGNMENT )? ( (lv_body_13_0= ruleFunctionBody ) ) )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:347:2: (otherlv_0= 'define' ( ruleLINKAGE )? ( ruleVISIBILITY )? ( ruleCallingConv )? ( ruleRETURN_ATTRIBUTES )? ( (lv_returnType_5_0= ruleType ) ) ( (lv_name_6_0= RULE_VAR_TYPE ) ) ( (lv_pList_7_0= ruleParameterList ) ) (otherlv_8= 'unnamed_addr' )? ( ruleFUNCTION_ATTRIBUTES )? (otherlv_10= 'section ' this_STRING_11= RULE_STRING )? ( ruleALIGNMENT )? ( (lv_body_13_0= ruleFunctionBody ) ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:347:4: otherlv_0= 'define' ( ruleLINKAGE )? ( ruleVISIBILITY )? ( ruleCallingConv )? ( ruleRETURN_ATTRIBUTES )? ( (lv_returnType_5_0= ruleType ) ) ( (lv_name_6_0= RULE_VAR_TYPE ) ) ( (lv_pList_7_0= ruleParameterList ) ) (otherlv_8= 'unnamed_addr' )? ( ruleFUNCTION_ATTRIBUTES )? (otherlv_10= 'section ' this_STRING_11= RULE_STRING )? ( ruleALIGNMENT )? ( (lv_body_13_0= ruleFunctionBody ) )
                    {
                    otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleFunctionHeader802); 

                        	newLeafNode(otherlv_0, grammarAccess.getFunctionHeaderAccess().getDefineKeyword_0_0());
                        
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:351:1: ( ruleLINKAGE )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( ((LA9_0>=198 && LA9_0<=213)) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:352:5: ruleLINKAGE
                            {
                             
                                    newCompositeNode(grammarAccess.getFunctionHeaderAccess().getLINKAGEParserRuleCall_0_1()); 
                                
                            pushFollow(FOLLOW_ruleLINKAGE_in_ruleFunctionHeader819);
                            ruleLINKAGE();

                            state._fsp--;

                             
                                    afterParserOrEnumRuleCall();
                                

                            }
                            break;

                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:359:3: ( ruleVISIBILITY )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( ((LA10_0>=195 && LA10_0<=197)) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:360:5: ruleVISIBILITY
                            {
                             
                                    newCompositeNode(grammarAccess.getFunctionHeaderAccess().getVISIBILITYParserRuleCall_0_2()); 
                                
                            pushFollow(FOLLOW_ruleVISIBILITY_in_ruleFunctionHeader837);
                            ruleVISIBILITY();

                            state._fsp--;

                             
                                    afterParserOrEnumRuleCall();
                                

                            }
                            break;

                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:367:3: ( ruleCallingConv )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( ((LA11_0>=91 && LA11_0<=105)) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:368:5: ruleCallingConv
                            {
                             
                                    newCompositeNode(grammarAccess.getFunctionHeaderAccess().getCallingConvParserRuleCall_0_3()); 
                                
                            pushFollow(FOLLOW_ruleCallingConv_in_ruleFunctionHeader855);
                            ruleCallingConv();

                            state._fsp--;

                             
                                    afterParserOrEnumRuleCall();
                                

                            }
                            break;

                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:375:3: ( ruleRETURN_ATTRIBUTES )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( ((LA12_0>=82 && LA12_0<=89)) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:376:5: ruleRETURN_ATTRIBUTES
                            {
                             
                                    newCompositeNode(grammarAccess.getFunctionHeaderAccess().getRETURN_ATTRIBUTESParserRuleCall_0_4()); 
                                
                            pushFollow(FOLLOW_ruleRETURN_ATTRIBUTES_in_ruleFunctionHeader873);
                            ruleRETURN_ATTRIBUTES();

                            state._fsp--;

                             
                                    afterParserOrEnumRuleCall();
                                

                            }
                            break;

                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:383:3: ( (lv_returnType_5_0= ruleType ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:384:1: (lv_returnType_5_0= ruleType )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:384:1: (lv_returnType_5_0= ruleType )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:385:3: lv_returnType_5_0= ruleType
                    {
                     
                    	        newCompositeNode(grammarAccess.getFunctionHeaderAccess().getReturnTypeTypeParserRuleCall_0_5_0()); 
                    	    
                    pushFollow(FOLLOW_ruleType_in_ruleFunctionHeader895);
                    lv_returnType_5_0=ruleType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getFunctionHeaderRule());
                    	        }
                           		set(
                           			current, 
                           			"returnType",
                            		lv_returnType_5_0, 
                            		"Type");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:401:2: ( (lv_name_6_0= RULE_VAR_TYPE ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:402:1: (lv_name_6_0= RULE_VAR_TYPE )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:402:1: (lv_name_6_0= RULE_VAR_TYPE )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:403:3: lv_name_6_0= RULE_VAR_TYPE
                    {
                    lv_name_6_0=(Token)match(input,RULE_VAR_TYPE,FOLLOW_RULE_VAR_TYPE_in_ruleFunctionHeader912); 

                    			newLeafNode(lv_name_6_0, grammarAccess.getFunctionHeaderAccess().getNameVAR_TYPETerminalRuleCall_0_6_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getFunctionHeaderRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_6_0, 
                            		"VAR_TYPE");
                    	    

                    }


                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:419:2: ( (lv_pList_7_0= ruleParameterList ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:420:1: (lv_pList_7_0= ruleParameterList )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:420:1: (lv_pList_7_0= ruleParameterList )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:421:3: lv_pList_7_0= ruleParameterList
                    {
                     
                    	        newCompositeNode(grammarAccess.getFunctionHeaderAccess().getPListParameterListParserRuleCall_0_7_0()); 
                    	    
                    pushFollow(FOLLOW_ruleParameterList_in_ruleFunctionHeader938);
                    lv_pList_7_0=ruleParameterList();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getFunctionHeaderRule());
                    	        }
                           		set(
                           			current, 
                           			"pList",
                            		lv_pList_7_0, 
                            		"ParameterList");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:437:2: (otherlv_8= 'unnamed_addr' )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==26) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:437:4: otherlv_8= 'unnamed_addr'
                            {
                            otherlv_8=(Token)match(input,26,FOLLOW_26_in_ruleFunctionHeader951); 

                                	newLeafNode(otherlv_8, grammarAccess.getFunctionHeaderAccess().getUnnamed_addrKeyword_0_8());
                                

                            }
                            break;

                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:441:3: ( ruleFUNCTION_ATTRIBUTES )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( ((LA14_0>=106 && LA14_0<=123)) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:442:5: ruleFUNCTION_ATTRIBUTES
                            {
                             
                                    newCompositeNode(grammarAccess.getFunctionHeaderAccess().getFUNCTION_ATTRIBUTESParserRuleCall_0_9()); 
                                
                            pushFollow(FOLLOW_ruleFUNCTION_ATTRIBUTES_in_ruleFunctionHeader970);
                            ruleFUNCTION_ATTRIBUTES();

                            state._fsp--;

                             
                                    afterParserOrEnumRuleCall();
                                

                            }
                            break;

                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:449:3: (otherlv_10= 'section ' this_STRING_11= RULE_STRING )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==27) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:449:5: otherlv_10= 'section ' this_STRING_11= RULE_STRING
                            {
                            otherlv_10=(Token)match(input,27,FOLLOW_27_in_ruleFunctionHeader984); 

                                	newLeafNode(otherlv_10, grammarAccess.getFunctionHeaderAccess().getSectionKeyword_0_10_0());
                                
                            this_STRING_11=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleFunctionHeader995); 
                             
                                newLeafNode(this_STRING_11, grammarAccess.getFunctionHeaderAccess().getSTRINGTerminalRuleCall_0_10_1()); 
                                

                            }
                            break;

                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:457:3: ( ruleALIGNMENT )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==78) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:458:5: ruleALIGNMENT
                            {
                             
                                    newCompositeNode(grammarAccess.getFunctionHeaderAccess().getALIGNMENTParserRuleCall_0_11()); 
                                
                            pushFollow(FOLLOW_ruleALIGNMENT_in_ruleFunctionHeader1013);
                            ruleALIGNMENT();

                            state._fsp--;

                             
                                    afterParserOrEnumRuleCall();
                                

                            }
                            break;

                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:465:3: ( (lv_body_13_0= ruleFunctionBody ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:466:1: (lv_body_13_0= ruleFunctionBody )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:466:1: (lv_body_13_0= ruleFunctionBody )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:467:3: lv_body_13_0= ruleFunctionBody
                    {
                     
                    	        newCompositeNode(grammarAccess.getFunctionHeaderAccess().getBodyFunctionBodyParserRuleCall_0_12_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFunctionBody_in_ruleFunctionHeader1035);
                    lv_body_13_0=ruleFunctionBody();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getFunctionHeaderRule());
                    	        }
                           		set(
                           			current, 
                           			"body",
                            		lv_body_13_0, 
                            		"FunctionBody");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:484:6: (otherlv_14= 'declare' ( ruleLINKAGE )? ( ruleVISIBILITY )? ( ruleCallingConv )? ( ruleRETURN_ATTRIBUTES )? ( (lv_returnType_19_0= ruleType ) ) ( (lv_name_20_0= RULE_VAR_TYPE ) ) ( ( (lv_tList_21_0= ruleTypeList ) ) | otherlv_22= '(...)' ) (otherlv_23= 'unnamed_addr' )? ( ruleFUNCTION_ATTRIBUTES )? (otherlv_25= 'section ' this_STRING_26= RULE_STRING )? ( ruleALIGNMENT )? )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:484:6: (otherlv_14= 'declare' ( ruleLINKAGE )? ( ruleVISIBILITY )? ( ruleCallingConv )? ( ruleRETURN_ATTRIBUTES )? ( (lv_returnType_19_0= ruleType ) ) ( (lv_name_20_0= RULE_VAR_TYPE ) ) ( ( (lv_tList_21_0= ruleTypeList ) ) | otherlv_22= '(...)' ) (otherlv_23= 'unnamed_addr' )? ( ruleFUNCTION_ATTRIBUTES )? (otherlv_25= 'section ' this_STRING_26= RULE_STRING )? ( ruleALIGNMENT )? )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:484:8: otherlv_14= 'declare' ( ruleLINKAGE )? ( ruleVISIBILITY )? ( ruleCallingConv )? ( ruleRETURN_ATTRIBUTES )? ( (lv_returnType_19_0= ruleType ) ) ( (lv_name_20_0= RULE_VAR_TYPE ) ) ( ( (lv_tList_21_0= ruleTypeList ) ) | otherlv_22= '(...)' ) (otherlv_23= 'unnamed_addr' )? ( ruleFUNCTION_ATTRIBUTES )? (otherlv_25= 'section ' this_STRING_26= RULE_STRING )? ( ruleALIGNMENT )?
                    {
                    otherlv_14=(Token)match(input,28,FOLLOW_28_in_ruleFunctionHeader1055); 

                        	newLeafNode(otherlv_14, grammarAccess.getFunctionHeaderAccess().getDeclareKeyword_1_0());
                        
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:488:1: ( ruleLINKAGE )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( ((LA17_0>=198 && LA17_0<=213)) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:489:5: ruleLINKAGE
                            {
                             
                                    newCompositeNode(grammarAccess.getFunctionHeaderAccess().getLINKAGEParserRuleCall_1_1()); 
                                
                            pushFollow(FOLLOW_ruleLINKAGE_in_ruleFunctionHeader1072);
                            ruleLINKAGE();

                            state._fsp--;

                             
                                    afterParserOrEnumRuleCall();
                                

                            }
                            break;

                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:496:3: ( ruleVISIBILITY )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( ((LA18_0>=195 && LA18_0<=197)) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:497:5: ruleVISIBILITY
                            {
                             
                                    newCompositeNode(grammarAccess.getFunctionHeaderAccess().getVISIBILITYParserRuleCall_1_2()); 
                                
                            pushFollow(FOLLOW_ruleVISIBILITY_in_ruleFunctionHeader1090);
                            ruleVISIBILITY();

                            state._fsp--;

                             
                                    afterParserOrEnumRuleCall();
                                

                            }
                            break;

                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:504:3: ( ruleCallingConv )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( ((LA19_0>=91 && LA19_0<=105)) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:505:5: ruleCallingConv
                            {
                             
                                    newCompositeNode(grammarAccess.getFunctionHeaderAccess().getCallingConvParserRuleCall_1_3()); 
                                
                            pushFollow(FOLLOW_ruleCallingConv_in_ruleFunctionHeader1108);
                            ruleCallingConv();

                            state._fsp--;

                             
                                    afterParserOrEnumRuleCall();
                                

                            }
                            break;

                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:512:3: ( ruleRETURN_ATTRIBUTES )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( ((LA20_0>=82 && LA20_0<=89)) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:513:5: ruleRETURN_ATTRIBUTES
                            {
                             
                                    newCompositeNode(grammarAccess.getFunctionHeaderAccess().getRETURN_ATTRIBUTESParserRuleCall_1_4()); 
                                
                            pushFollow(FOLLOW_ruleRETURN_ATTRIBUTES_in_ruleFunctionHeader1126);
                            ruleRETURN_ATTRIBUTES();

                            state._fsp--;

                             
                                    afterParserOrEnumRuleCall();
                                

                            }
                            break;

                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:520:3: ( (lv_returnType_19_0= ruleType ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:521:1: (lv_returnType_19_0= ruleType )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:521:1: (lv_returnType_19_0= ruleType )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:522:3: lv_returnType_19_0= ruleType
                    {
                     
                    	        newCompositeNode(grammarAccess.getFunctionHeaderAccess().getReturnTypeTypeParserRuleCall_1_5_0()); 
                    	    
                    pushFollow(FOLLOW_ruleType_in_ruleFunctionHeader1148);
                    lv_returnType_19_0=ruleType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getFunctionHeaderRule());
                    	        }
                           		set(
                           			current, 
                           			"returnType",
                            		lv_returnType_19_0, 
                            		"Type");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:538:2: ( (lv_name_20_0= RULE_VAR_TYPE ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:539:1: (lv_name_20_0= RULE_VAR_TYPE )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:539:1: (lv_name_20_0= RULE_VAR_TYPE )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:540:3: lv_name_20_0= RULE_VAR_TYPE
                    {
                    lv_name_20_0=(Token)match(input,RULE_VAR_TYPE,FOLLOW_RULE_VAR_TYPE_in_ruleFunctionHeader1165); 

                    			newLeafNode(lv_name_20_0, grammarAccess.getFunctionHeaderAccess().getNameVAR_TYPETerminalRuleCall_1_6_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getFunctionHeaderRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_20_0, 
                            		"VAR_TYPE");
                    	    

                    }


                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:556:2: ( ( (lv_tList_21_0= ruleTypeList ) ) | otherlv_22= '(...)' )
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==30) ) {
                        alt21=1;
                    }
                    else if ( (LA21_0==29) ) {
                        alt21=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 0, input);

                        throw nvae;
                    }
                    switch (alt21) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:556:3: ( (lv_tList_21_0= ruleTypeList ) )
                            {
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:556:3: ( (lv_tList_21_0= ruleTypeList ) )
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:557:1: (lv_tList_21_0= ruleTypeList )
                            {
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:557:1: (lv_tList_21_0= ruleTypeList )
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:558:3: lv_tList_21_0= ruleTypeList
                            {
                             
                            	        newCompositeNode(grammarAccess.getFunctionHeaderAccess().getTListTypeListParserRuleCall_1_7_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleTypeList_in_ruleFunctionHeader1192);
                            lv_tList_21_0=ruleTypeList();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getFunctionHeaderRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"tList",
                                    		lv_tList_21_0, 
                                    		"TypeList");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:575:7: otherlv_22= '(...)'
                            {
                            otherlv_22=(Token)match(input,29,FOLLOW_29_in_ruleFunctionHeader1210); 

                                	newLeafNode(otherlv_22, grammarAccess.getFunctionHeaderAccess().getLeftParenthesisFullStopFullStopFullStopRightParenthesisKeyword_1_7_1());
                                

                            }
                            break;

                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:579:2: (otherlv_23= 'unnamed_addr' )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==26) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:579:4: otherlv_23= 'unnamed_addr'
                            {
                            otherlv_23=(Token)match(input,26,FOLLOW_26_in_ruleFunctionHeader1224); 

                                	newLeafNode(otherlv_23, grammarAccess.getFunctionHeaderAccess().getUnnamed_addrKeyword_1_8());
                                

                            }
                            break;

                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:583:3: ( ruleFUNCTION_ATTRIBUTES )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( ((LA23_0>=106 && LA23_0<=123)) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:584:5: ruleFUNCTION_ATTRIBUTES
                            {
                             
                                    newCompositeNode(grammarAccess.getFunctionHeaderAccess().getFUNCTION_ATTRIBUTESParserRuleCall_1_9()); 
                                
                            pushFollow(FOLLOW_ruleFUNCTION_ATTRIBUTES_in_ruleFunctionHeader1243);
                            ruleFUNCTION_ATTRIBUTES();

                            state._fsp--;

                             
                                    afterParserOrEnumRuleCall();
                                

                            }
                            break;

                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:591:3: (otherlv_25= 'section ' this_STRING_26= RULE_STRING )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==27) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:591:5: otherlv_25= 'section ' this_STRING_26= RULE_STRING
                            {
                            otherlv_25=(Token)match(input,27,FOLLOW_27_in_ruleFunctionHeader1257); 

                                	newLeafNode(otherlv_25, grammarAccess.getFunctionHeaderAccess().getSectionKeyword_1_10_0());
                                
                            this_STRING_26=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleFunctionHeader1268); 
                             
                                newLeafNode(this_STRING_26, grammarAccess.getFunctionHeaderAccess().getSTRINGTerminalRuleCall_1_10_1()); 
                                

                            }
                            break;

                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:599:3: ( ruleALIGNMENT )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==78) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:600:5: ruleALIGNMENT
                            {
                             
                                    newCompositeNode(grammarAccess.getFunctionHeaderAccess().getALIGNMENTParserRuleCall_1_11()); 
                                
                            pushFollow(FOLLOW_ruleALIGNMENT_in_ruleFunctionHeader1286);
                            ruleALIGNMENT();

                            state._fsp--;

                             
                                    afterParserOrEnumRuleCall();
                                

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionHeader"


    // $ANTLR start "entryRuleTypeList"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:615:1: entryRuleTypeList returns [EObject current=null] : iv_ruleTypeList= ruleTypeList EOF ;
    public final EObject entryRuleTypeList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeList = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:616:2: (iv_ruleTypeList= ruleTypeList EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:617:2: iv_ruleTypeList= ruleTypeList EOF
            {
             newCompositeNode(grammarAccess.getTypeListRule()); 
            pushFollow(FOLLOW_ruleTypeList_in_entryRuleTypeList1324);
            iv_ruleTypeList=ruleTypeList();

            state._fsp--;

             current =iv_ruleTypeList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeList1334); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeList"


    // $ANTLR start "ruleTypeList"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:624:1: ruleTypeList returns [EObject current=null] : ( () otherlv_1= '(' ( ( (lv_types_2_0= ruleType ) ) (otherlv_3= ',' ( (lv_types_4_0= ruleType ) ) )* )? otherlv_5= ')' ) ;
    public final EObject ruleTypeList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_types_2_0 = null;

        AntlrDatatypeRuleToken lv_types_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:627:28: ( ( () otherlv_1= '(' ( ( (lv_types_2_0= ruleType ) ) (otherlv_3= ',' ( (lv_types_4_0= ruleType ) ) )* )? otherlv_5= ')' ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:628:1: ( () otherlv_1= '(' ( ( (lv_types_2_0= ruleType ) ) (otherlv_3= ',' ( (lv_types_4_0= ruleType ) ) )* )? otherlv_5= ')' )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:628:1: ( () otherlv_1= '(' ( ( (lv_types_2_0= ruleType ) ) (otherlv_3= ',' ( (lv_types_4_0= ruleType ) ) )* )? otherlv_5= ')' )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:628:2: () otherlv_1= '(' ( ( (lv_types_2_0= ruleType ) ) (otherlv_3= ',' ( (lv_types_4_0= ruleType ) ) )* )? otherlv_5= ')'
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:628:2: ()
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:629:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTypeListAccess().getTypeListAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,30,FOLLOW_30_in_ruleTypeList1380); 

                	newLeafNode(otherlv_1, grammarAccess.getTypeListAccess().getLeftParenthesisKeyword_1());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:638:1: ( ( (lv_types_2_0= ruleType ) ) (otherlv_3= ',' ( (lv_types_4_0= ruleType ) ) )* )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=RULE_VAR_TYPE && LA28_0<=RULE_INT)||LA28_0==32||LA28_0==36||(LA28_0>=38 && LA28_0<=47)) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:638:2: ( (lv_types_2_0= ruleType ) ) (otherlv_3= ',' ( (lv_types_4_0= ruleType ) ) )*
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:638:2: ( (lv_types_2_0= ruleType ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:639:1: (lv_types_2_0= ruleType )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:639:1: (lv_types_2_0= ruleType )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:640:3: lv_types_2_0= ruleType
                    {
                     
                    	        newCompositeNode(grammarAccess.getTypeListAccess().getTypesTypeParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleType_in_ruleTypeList1402);
                    lv_types_2_0=ruleType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTypeListRule());
                    	        }
                           		add(
                           			current, 
                           			"types",
                            		lv_types_2_0, 
                            		"Type");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:656:2: (otherlv_3= ',' ( (lv_types_4_0= ruleType ) ) )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==23) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:656:4: otherlv_3= ',' ( (lv_types_4_0= ruleType ) )
                    	    {
                    	    otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleTypeList1415); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getTypeListAccess().getCommaKeyword_2_1_0());
                    	        
                    	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:660:1: ( (lv_types_4_0= ruleType ) )
                    	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:661:1: (lv_types_4_0= ruleType )
                    	    {
                    	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:661:1: (lv_types_4_0= ruleType )
                    	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:662:3: lv_types_4_0= ruleType
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getTypeListAccess().getTypesTypeParserRuleCall_2_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleType_in_ruleTypeList1436);
                    	    lv_types_4_0=ruleType();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getTypeListRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"types",
                    	            		lv_types_4_0, 
                    	            		"Type");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,31,FOLLOW_31_in_ruleTypeList1452); 

                	newLeafNode(otherlv_5, grammarAccess.getTypeListAccess().getRightParenthesisKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeList"


    // $ANTLR start "entryRuleAggregate"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:690:1: entryRuleAggregate returns [EObject current=null] : iv_ruleAggregate= ruleAggregate EOF ;
    public final EObject entryRuleAggregate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAggregate = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:691:2: (iv_ruleAggregate= ruleAggregate EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:692:2: iv_ruleAggregate= ruleAggregate EOF
            {
             newCompositeNode(grammarAccess.getAggregateRule()); 
            pushFollow(FOLLOW_ruleAggregate_in_entryRuleAggregate1488);
            iv_ruleAggregate=ruleAggregate();

            state._fsp--;

             current =iv_ruleAggregate; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAggregate1498); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAggregate"


    // $ANTLR start "ruleAggregate"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:699:1: ruleAggregate returns [EObject current=null] : (otherlv_0= '{' ( (lv_agg_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_agg_3_0= ruleType ) ) ) otherlv_4= '}' ) ;
    public final EObject ruleAggregate() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_agg_1_0 = null;

        AntlrDatatypeRuleToken lv_agg_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:702:28: ( (otherlv_0= '{' ( (lv_agg_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_agg_3_0= ruleType ) ) ) otherlv_4= '}' ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:703:1: (otherlv_0= '{' ( (lv_agg_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_agg_3_0= ruleType ) ) ) otherlv_4= '}' )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:703:1: (otherlv_0= '{' ( (lv_agg_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_agg_3_0= ruleType ) ) ) otherlv_4= '}' )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:703:3: otherlv_0= '{' ( (lv_agg_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_agg_3_0= ruleType ) ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleAggregate1535); 

                	newLeafNode(otherlv_0, grammarAccess.getAggregateAccess().getLeftCurlyBracketKeyword_0());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:707:1: ( (lv_agg_1_0= ruleType ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:708:1: (lv_agg_1_0= ruleType )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:708:1: (lv_agg_1_0= ruleType )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:709:3: lv_agg_1_0= ruleType
            {
             
            	        newCompositeNode(grammarAccess.getAggregateAccess().getAggTypeParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleType_in_ruleAggregate1556);
            lv_agg_1_0=ruleType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAggregateRule());
            	        }
                   		add(
                   			current, 
                   			"agg",
                    		lv_agg_1_0, 
                    		"Type");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:725:2: (otherlv_2= ',' ( (lv_agg_3_0= ruleType ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:725:4: otherlv_2= ',' ( (lv_agg_3_0= ruleType ) )
            {
            otherlv_2=(Token)match(input,23,FOLLOW_23_in_ruleAggregate1569); 

                	newLeafNode(otherlv_2, grammarAccess.getAggregateAccess().getCommaKeyword_2_0());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:729:1: ( (lv_agg_3_0= ruleType ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:730:1: (lv_agg_3_0= ruleType )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:730:1: (lv_agg_3_0= ruleType )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:731:3: lv_agg_3_0= ruleType
            {
             
            	        newCompositeNode(grammarAccess.getAggregateAccess().getAggTypeParserRuleCall_2_1_0()); 
            	    
            pushFollow(FOLLOW_ruleType_in_ruleAggregate1590);
            lv_agg_3_0=ruleType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAggregateRule());
            	        }
                   		add(
                   			current, 
                   			"agg",
                    		lv_agg_3_0, 
                    		"Type");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }

            otherlv_4=(Token)match(input,33,FOLLOW_33_in_ruleAggregate1603); 

                	newLeafNode(otherlv_4, grammarAccess.getAggregateAccess().getRightCurlyBracketKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAggregate"


    // $ANTLR start "entryRuleLocalVar"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:759:1: entryRuleLocalVar returns [EObject current=null] : iv_ruleLocalVar= ruleLocalVar EOF ;
    public final EObject entryRuleLocalVar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocalVar = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:760:2: (iv_ruleLocalVar= ruleLocalVar EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:761:2: iv_ruleLocalVar= ruleLocalVar EOF
            {
             newCompositeNode(grammarAccess.getLocalVarRule()); 
            pushFollow(FOLLOW_ruleLocalVar_in_entryRuleLocalVar1639);
            iv_ruleLocalVar=ruleLocalVar();

            state._fsp--;

             current =iv_ruleLocalVar; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLocalVar1649); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLocalVar"


    // $ANTLR start "ruleLocalVar"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:768:1: ruleLocalVar returns [EObject current=null] : ( ( (lv_name_0_0= ruleType ) ) otherlv_1= '=' ( ( (lv_type_2_0= ruleLocalType ) ) | ( (lv_instr_3_0= ruleLocalInstruction ) ) | ( (lv_alias_4_0= ruleLocalAlias ) ) ) ) ;
    public final EObject ruleLocalVar() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_type_2_0 = null;

        EObject lv_instr_3_0 = null;

        EObject lv_alias_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:771:28: ( ( ( (lv_name_0_0= ruleType ) ) otherlv_1= '=' ( ( (lv_type_2_0= ruleLocalType ) ) | ( (lv_instr_3_0= ruleLocalInstruction ) ) | ( (lv_alias_4_0= ruleLocalAlias ) ) ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:772:1: ( ( (lv_name_0_0= ruleType ) ) otherlv_1= '=' ( ( (lv_type_2_0= ruleLocalType ) ) | ( (lv_instr_3_0= ruleLocalInstruction ) ) | ( (lv_alias_4_0= ruleLocalAlias ) ) ) )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:772:1: ( ( (lv_name_0_0= ruleType ) ) otherlv_1= '=' ( ( (lv_type_2_0= ruleLocalType ) ) | ( (lv_instr_3_0= ruleLocalInstruction ) ) | ( (lv_alias_4_0= ruleLocalAlias ) ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:772:2: ( (lv_name_0_0= ruleType ) ) otherlv_1= '=' ( ( (lv_type_2_0= ruleLocalType ) ) | ( (lv_instr_3_0= ruleLocalInstruction ) ) | ( (lv_alias_4_0= ruleLocalAlias ) ) )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:772:2: ( (lv_name_0_0= ruleType ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:773:1: (lv_name_0_0= ruleType )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:773:1: (lv_name_0_0= ruleType )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:774:3: lv_name_0_0= ruleType
            {
             
            	        newCompositeNode(grammarAccess.getLocalVarAccess().getNameTypeParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleType_in_ruleLocalVar1695);
            lv_name_0_0=ruleType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLocalVarRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"Type");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleLocalVar1707); 

                	newLeafNode(otherlv_1, grammarAccess.getLocalVarAccess().getEqualsSignKeyword_1());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:794:1: ( ( (lv_type_2_0= ruleLocalType ) ) | ( (lv_instr_3_0= ruleLocalInstruction ) ) | ( (lv_alias_4_0= ruleLocalAlias ) ) )
            int alt29=3;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt29=1;
                }
                break;
            case RULE_VAR_TYPE:
            case RULE_INTEGER:
            case RULE_INT:
            case 32:
            case 36:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 50:
            case 51:
            case 52:
            case 60:
            case 62:
            case 64:
            case 65:
            case 66:
            case 68:
            case 69:
            case 74:
            case 79:
            case 80:
            case 81:
            case 90:
            case 124:
            case 125:
            case 132:
            case 133:
            case 134:
            case 135:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 144:
            case 145:
            case 146:
            case 147:
            case 148:
            case 149:
            case 150:
            case 173:
            case 174:
            case 175:
            case 176:
            case 177:
            case 178:
            case 179:
            case 180:
            case 181:
            case 182:
            case 183:
            case 184:
            case 185:
            case 186:
            case 187:
            case 188:
            case 190:
            case 191:
            case 193:
                {
                alt29=2;
                }
                break;
            case 35:
                {
                alt29=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:794:2: ( (lv_type_2_0= ruleLocalType ) )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:794:2: ( (lv_type_2_0= ruleLocalType ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:795:1: (lv_type_2_0= ruleLocalType )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:795:1: (lv_type_2_0= ruleLocalType )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:796:3: lv_type_2_0= ruleLocalType
                    {
                     
                    	        newCompositeNode(grammarAccess.getLocalVarAccess().getTypeLocalTypeParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleLocalType_in_ruleLocalVar1729);
                    lv_type_2_0=ruleLocalType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLocalVarRule());
                    	        }
                           		set(
                           			current, 
                           			"type",
                            		lv_type_2_0, 
                            		"LocalType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:813:6: ( (lv_instr_3_0= ruleLocalInstruction ) )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:813:6: ( (lv_instr_3_0= ruleLocalInstruction ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:814:1: (lv_instr_3_0= ruleLocalInstruction )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:814:1: (lv_instr_3_0= ruleLocalInstruction )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:815:3: lv_instr_3_0= ruleLocalInstruction
                    {
                     
                    	        newCompositeNode(grammarAccess.getLocalVarAccess().getInstrLocalInstructionParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleLocalInstruction_in_ruleLocalVar1756);
                    lv_instr_3_0=ruleLocalInstruction();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLocalVarRule());
                    	        }
                           		set(
                           			current, 
                           			"instr",
                            		lv_instr_3_0, 
                            		"LocalInstruction");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:832:6: ( (lv_alias_4_0= ruleLocalAlias ) )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:832:6: ( (lv_alias_4_0= ruleLocalAlias ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:833:1: (lv_alias_4_0= ruleLocalAlias )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:833:1: (lv_alias_4_0= ruleLocalAlias )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:834:3: lv_alias_4_0= ruleLocalAlias
                    {
                     
                    	        newCompositeNode(grammarAccess.getLocalVarAccess().getAliasLocalAliasParserRuleCall_2_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleLocalAlias_in_ruleLocalVar1783);
                    lv_alias_4_0=ruleLocalAlias();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLocalVarRule());
                    	        }
                           		set(
                           			current, 
                           			"alias",
                            		lv_alias_4_0, 
                            		"LocalAlias");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLocalVar"


    // $ANTLR start "entryRuleLocalType"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:858:1: entryRuleLocalType returns [EObject current=null] : iv_ruleLocalType= ruleLocalType EOF ;
    public final EObject entryRuleLocalType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocalType = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:859:2: (iv_ruleLocalType= ruleLocalType EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:860:2: iv_ruleLocalType= ruleLocalType EOF
            {
             newCompositeNode(grammarAccess.getLocalTypeRule()); 
            pushFollow(FOLLOW_ruleLocalType_in_entryRuleLocalType1820);
            iv_ruleLocalType=ruleLocalType();

            state._fsp--;

             current =iv_ruleLocalType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLocalType1830); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLocalType"


    // $ANTLR start "ruleLocalType"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:867:1: ruleLocalType returns [EObject current=null] : (otherlv_0= 'type' ( (lv_type_1_0= ruleType ) ) ) ;
    public final EObject ruleLocalType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_type_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:870:28: ( (otherlv_0= 'type' ( (lv_type_1_0= ruleType ) ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:871:1: (otherlv_0= 'type' ( (lv_type_1_0= ruleType ) ) )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:871:1: (otherlv_0= 'type' ( (lv_type_1_0= ruleType ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:871:3: otherlv_0= 'type' ( (lv_type_1_0= ruleType ) )
            {
            otherlv_0=(Token)match(input,34,FOLLOW_34_in_ruleLocalType1867); 

                	newLeafNode(otherlv_0, grammarAccess.getLocalTypeAccess().getTypeKeyword_0());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:875:1: ( (lv_type_1_0= ruleType ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:876:1: (lv_type_1_0= ruleType )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:876:1: (lv_type_1_0= ruleType )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:877:3: lv_type_1_0= ruleType
            {
             
            	        newCompositeNode(grammarAccess.getLocalTypeAccess().getTypeTypeParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleType_in_ruleLocalType1888);
            lv_type_1_0=ruleType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLocalTypeRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_1_0, 
                    		"Type");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLocalType"


    // $ANTLR start "entryRuleLocalInstruction"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:901:1: entryRuleLocalInstruction returns [EObject current=null] : iv_ruleLocalInstruction= ruleLocalInstruction EOF ;
    public final EObject entryRuleLocalInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocalInstruction = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:902:2: (iv_ruleLocalInstruction= ruleLocalInstruction EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:903:2: iv_ruleLocalInstruction= ruleLocalInstruction EOF
            {
             newCompositeNode(grammarAccess.getLocalInstructionRule()); 
            pushFollow(FOLLOW_ruleLocalInstruction_in_entryRuleLocalInstruction1924);
            iv_ruleLocalInstruction=ruleLocalInstruction();

            state._fsp--;

             current =iv_ruleLocalInstruction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLocalInstruction1934); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLocalInstruction"


    // $ANTLR start "ruleLocalInstruction"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:910:1: ruleLocalInstruction returns [EObject current=null] : ( (lv_instr_0_0= ruleInstruction ) ) ;
    public final EObject ruleLocalInstruction() throws RecognitionException {
        EObject current = null;

        EObject lv_instr_0_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:913:28: ( ( (lv_instr_0_0= ruleInstruction ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:914:1: ( (lv_instr_0_0= ruleInstruction ) )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:914:1: ( (lv_instr_0_0= ruleInstruction ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:915:1: (lv_instr_0_0= ruleInstruction )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:915:1: (lv_instr_0_0= ruleInstruction )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:916:3: lv_instr_0_0= ruleInstruction
            {
             
            	        newCompositeNode(grammarAccess.getLocalInstructionAccess().getInstrInstructionParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleInstruction_in_ruleLocalInstruction1979);
            lv_instr_0_0=ruleInstruction();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLocalInstructionRule());
            	        }
                   		set(
                   			current, 
                   			"instr",
                    		lv_instr_0_0, 
                    		"Instruction");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLocalInstruction"


    // $ANTLR start "entryRuleLocalAlias"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:940:1: entryRuleLocalAlias returns [EObject current=null] : iv_ruleLocalAlias= ruleLocalAlias EOF ;
    public final EObject entryRuleLocalAlias() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocalAlias = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:941:2: (iv_ruleLocalAlias= ruleLocalAlias EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:942:2: iv_ruleLocalAlias= ruleLocalAlias EOF
            {
             newCompositeNode(grammarAccess.getLocalAliasRule()); 
            pushFollow(FOLLOW_ruleLocalAlias_in_entryRuleLocalAlias2014);
            iv_ruleLocalAlias=ruleLocalAlias();

            state._fsp--;

             current =iv_ruleLocalAlias; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLocalAlias2024); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLocalAlias"


    // $ANTLR start "ruleLocalAlias"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:949:1: ruleLocalAlias returns [EObject current=null] : (otherlv_0= 'alias' ( ruleALIAS_LINKAGE )? ( ruleVISIBILITY )? ( (lv_type_3_0= ruleTypeAndValue ) ) ( (lv_aliasee_4_0= ruleType ) ) ) ;
    public final EObject ruleLocalAlias() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_type_3_0 = null;

        AntlrDatatypeRuleToken lv_aliasee_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:952:28: ( (otherlv_0= 'alias' ( ruleALIAS_LINKAGE )? ( ruleVISIBILITY )? ( (lv_type_3_0= ruleTypeAndValue ) ) ( (lv_aliasee_4_0= ruleType ) ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:953:1: (otherlv_0= 'alias' ( ruleALIAS_LINKAGE )? ( ruleVISIBILITY )? ( (lv_type_3_0= ruleTypeAndValue ) ) ( (lv_aliasee_4_0= ruleType ) ) )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:953:1: (otherlv_0= 'alias' ( ruleALIAS_LINKAGE )? ( ruleVISIBILITY )? ( (lv_type_3_0= ruleTypeAndValue ) ) ( (lv_aliasee_4_0= ruleType ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:953:3: otherlv_0= 'alias' ( ruleALIAS_LINKAGE )? ( ruleVISIBILITY )? ( (lv_type_3_0= ruleTypeAndValue ) ) ( (lv_aliasee_4_0= ruleType ) )
            {
            otherlv_0=(Token)match(input,35,FOLLOW_35_in_ruleLocalAlias2061); 

                	newLeafNode(otherlv_0, grammarAccess.getLocalAliasAccess().getAliasKeyword_0());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:957:1: ( ruleALIAS_LINKAGE )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=210 && LA30_0<=213)) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:958:5: ruleALIAS_LINKAGE
                    {
                     
                            newCompositeNode(grammarAccess.getLocalAliasAccess().getALIAS_LINKAGEParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleALIAS_LINKAGE_in_ruleLocalAlias2078);
                    ruleALIAS_LINKAGE();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:965:3: ( ruleVISIBILITY )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=195 && LA31_0<=197)) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:966:5: ruleVISIBILITY
                    {
                     
                            newCompositeNode(grammarAccess.getLocalAliasAccess().getVISIBILITYParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleVISIBILITY_in_ruleLocalAlias2096);
                    ruleVISIBILITY();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:973:3: ( (lv_type_3_0= ruleTypeAndValue ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:974:1: (lv_type_3_0= ruleTypeAndValue )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:974:1: (lv_type_3_0= ruleTypeAndValue )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:975:3: lv_type_3_0= ruleTypeAndValue
            {
             
            	        newCompositeNode(grammarAccess.getLocalAliasAccess().getTypeTypeAndValueParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleTypeAndValue_in_ruleLocalAlias2118);
            lv_type_3_0=ruleTypeAndValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLocalAliasRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_3_0, 
                    		"TypeAndValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:991:2: ( (lv_aliasee_4_0= ruleType ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:992:1: (lv_aliasee_4_0= ruleType )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:992:1: (lv_aliasee_4_0= ruleType )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:993:3: lv_aliasee_4_0= ruleType
            {
             
            	        newCompositeNode(grammarAccess.getLocalAliasAccess().getAliaseeTypeParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleType_in_ruleLocalAlias2139);
            lv_aliasee_4_0=ruleType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLocalAliasRule());
            	        }
                   		set(
                   			current, 
                   			"aliasee",
                    		lv_aliasee_4_0, 
                    		"Type");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLocalAlias"


    // $ANTLR start "entryRuleType"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1017:1: entryRuleType returns [String current=null] : iv_ruleType= ruleType EOF ;
    public final String entryRuleType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleType = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1018:2: (iv_ruleType= ruleType EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1019:2: iv_ruleType= ruleType EOF
            {
             newCompositeNode(grammarAccess.getTypeRule()); 
            pushFollow(FOLLOW_ruleType_in_entryRuleType2176);
            iv_ruleType=ruleType();

            state._fsp--;

             current =iv_ruleType.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleType2187); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1026:1: ruleType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_StructType_0= ruleStructType | this_VAR_TYPE_1= RULE_VAR_TYPE | this_BType_2= ruleBType ) ;
    public final AntlrDatatypeRuleToken ruleType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_VAR_TYPE_1=null;
        AntlrDatatypeRuleToken this_StructType_0 = null;

        AntlrDatatypeRuleToken this_BType_2 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1029:28: ( (this_StructType_0= ruleStructType | this_VAR_TYPE_1= RULE_VAR_TYPE | this_BType_2= ruleBType ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1030:1: (this_StructType_0= ruleStructType | this_VAR_TYPE_1= RULE_VAR_TYPE | this_BType_2= ruleBType )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1030:1: (this_StructType_0= ruleStructType | this_VAR_TYPE_1= RULE_VAR_TYPE | this_BType_2= ruleBType )
            int alt32=3;
            switch ( input.LA(1) ) {
            case 32:
            case 36:
                {
                alt32=1;
                }
                break;
            case RULE_VAR_TYPE:
                {
                alt32=2;
                }
                break;
            case RULE_INTEGER:
            case RULE_INT:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
                {
                alt32=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1031:5: this_StructType_0= ruleStructType
                    {
                     
                            newCompositeNode(grammarAccess.getTypeAccess().getStructTypeParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleStructType_in_ruleType2234);
                    this_StructType_0=ruleStructType();

                    state._fsp--;


                    		current.merge(this_StructType_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1042:10: this_VAR_TYPE_1= RULE_VAR_TYPE
                    {
                    this_VAR_TYPE_1=(Token)match(input,RULE_VAR_TYPE,FOLLOW_RULE_VAR_TYPE_in_ruleType2260); 

                    		current.merge(this_VAR_TYPE_1);
                        
                     
                        newLeafNode(this_VAR_TYPE_1, grammarAccess.getTypeAccess().getVAR_TYPETerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1051:5: this_BType_2= ruleBType
                    {
                     
                            newCompositeNode(grammarAccess.getTypeAccess().getBTypeParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleBType_in_ruleType2293);
                    this_BType_2=ruleBType();

                    state._fsp--;


                    		current.merge(this_BType_2);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleTypeAndValue"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1069:1: entryRuleTypeAndValue returns [EObject current=null] : iv_ruleTypeAndValue= ruleTypeAndValue EOF ;
    public final EObject entryRuleTypeAndValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeAndValue = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1070:2: (iv_ruleTypeAndValue= ruleTypeAndValue EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1071:2: iv_ruleTypeAndValue= ruleTypeAndValue EOF
            {
             newCompositeNode(grammarAccess.getTypeAndValueRule()); 
            pushFollow(FOLLOW_ruleTypeAndValue_in_entryRuleTypeAndValue2338);
            iv_ruleTypeAndValue=ruleTypeAndValue();

            state._fsp--;

             current =iv_ruleTypeAndValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeAndValue2348); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeAndValue"


    // $ANTLR start "ruleTypeAndValue"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1078:1: ruleTypeAndValue returns [EObject current=null] : ( ( ( ( (lv_type_0_1= RULE_VAR_TYPE | lv_type_0_2= ruleBType ) ) ) ( (lv_value_1_0= ruleType ) ) ) | ( ( (lv_aggregate_2_0= ruleAggregate ) ) ( (lv_value_3_0= ruleType ) ) ) ) ;
    public final EObject ruleTypeAndValue() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_1=null;
        AntlrDatatypeRuleToken lv_type_0_2 = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;

        EObject lv_aggregate_2_0 = null;

        AntlrDatatypeRuleToken lv_value_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1081:28: ( ( ( ( ( (lv_type_0_1= RULE_VAR_TYPE | lv_type_0_2= ruleBType ) ) ) ( (lv_value_1_0= ruleType ) ) ) | ( ( (lv_aggregate_2_0= ruleAggregate ) ) ( (lv_value_3_0= ruleType ) ) ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1082:1: ( ( ( ( (lv_type_0_1= RULE_VAR_TYPE | lv_type_0_2= ruleBType ) ) ) ( (lv_value_1_0= ruleType ) ) ) | ( ( (lv_aggregate_2_0= ruleAggregate ) ) ( (lv_value_3_0= ruleType ) ) ) )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1082:1: ( ( ( ( (lv_type_0_1= RULE_VAR_TYPE | lv_type_0_2= ruleBType ) ) ) ( (lv_value_1_0= ruleType ) ) ) | ( ( (lv_aggregate_2_0= ruleAggregate ) ) ( (lv_value_3_0= ruleType ) ) ) )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0>=RULE_VAR_TYPE && LA34_0<=RULE_INT)||(LA34_0>=38 && LA34_0<=47)) ) {
                alt34=1;
            }
            else if ( (LA34_0==32) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1082:2: ( ( ( (lv_type_0_1= RULE_VAR_TYPE | lv_type_0_2= ruleBType ) ) ) ( (lv_value_1_0= ruleType ) ) )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1082:2: ( ( ( (lv_type_0_1= RULE_VAR_TYPE | lv_type_0_2= ruleBType ) ) ) ( (lv_value_1_0= ruleType ) ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1082:3: ( ( (lv_type_0_1= RULE_VAR_TYPE | lv_type_0_2= ruleBType ) ) ) ( (lv_value_1_0= ruleType ) )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1082:3: ( ( (lv_type_0_1= RULE_VAR_TYPE | lv_type_0_2= ruleBType ) ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1083:1: ( (lv_type_0_1= RULE_VAR_TYPE | lv_type_0_2= ruleBType ) )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1083:1: ( (lv_type_0_1= RULE_VAR_TYPE | lv_type_0_2= ruleBType ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1084:1: (lv_type_0_1= RULE_VAR_TYPE | lv_type_0_2= ruleBType )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1084:1: (lv_type_0_1= RULE_VAR_TYPE | lv_type_0_2= ruleBType )
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==RULE_VAR_TYPE) ) {
                        alt33=1;
                    }
                    else if ( ((LA33_0>=RULE_INTEGER && LA33_0<=RULE_INT)||(LA33_0>=38 && LA33_0<=47)) ) {
                        alt33=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 33, 0, input);

                        throw nvae;
                    }
                    switch (alt33) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1085:3: lv_type_0_1= RULE_VAR_TYPE
                            {
                            lv_type_0_1=(Token)match(input,RULE_VAR_TYPE,FOLLOW_RULE_VAR_TYPE_in_ruleTypeAndValue2393); 

                            			newLeafNode(lv_type_0_1, grammarAccess.getTypeAndValueAccess().getTypeVAR_TYPETerminalRuleCall_0_0_0_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getTypeAndValueRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"type",
                                    		lv_type_0_1, 
                                    		"VAR_TYPE");
                            	    

                            }
                            break;
                        case 2 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1100:8: lv_type_0_2= ruleBType
                            {
                             
                            	        newCompositeNode(grammarAccess.getTypeAndValueAccess().getTypeBTypeParserRuleCall_0_0_0_1()); 
                            	    
                            pushFollow(FOLLOW_ruleBType_in_ruleTypeAndValue2417);
                            lv_type_0_2=ruleBType();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getTypeAndValueRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"type",
                                    		lv_type_0_2, 
                                    		"BType");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }
                            break;

                    }


                    }


                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1118:2: ( (lv_value_1_0= ruleType ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1119:1: (lv_value_1_0= ruleType )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1119:1: (lv_value_1_0= ruleType )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1120:3: lv_value_1_0= ruleType
                    {
                     
                    	        newCompositeNode(grammarAccess.getTypeAndValueAccess().getValueTypeParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleType_in_ruleTypeAndValue2441);
                    lv_value_1_0=ruleType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTypeAndValueRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_1_0, 
                            		"Type");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1137:6: ( ( (lv_aggregate_2_0= ruleAggregate ) ) ( (lv_value_3_0= ruleType ) ) )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1137:6: ( ( (lv_aggregate_2_0= ruleAggregate ) ) ( (lv_value_3_0= ruleType ) ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1137:7: ( (lv_aggregate_2_0= ruleAggregate ) ) ( (lv_value_3_0= ruleType ) )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1137:7: ( (lv_aggregate_2_0= ruleAggregate ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1138:1: (lv_aggregate_2_0= ruleAggregate )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1138:1: (lv_aggregate_2_0= ruleAggregate )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1139:3: lv_aggregate_2_0= ruleAggregate
                    {
                     
                    	        newCompositeNode(grammarAccess.getTypeAndValueAccess().getAggregateAggregateParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAggregate_in_ruleTypeAndValue2470);
                    lv_aggregate_2_0=ruleAggregate();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTypeAndValueRule());
                    	        }
                           		set(
                           			current, 
                           			"aggregate",
                            		lv_aggregate_2_0, 
                            		"Aggregate");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1155:2: ( (lv_value_3_0= ruleType ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1156:1: (lv_value_3_0= ruleType )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1156:1: (lv_value_3_0= ruleType )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1157:3: lv_value_3_0= ruleType
                    {
                     
                    	        newCompositeNode(grammarAccess.getTypeAndValueAccess().getValueTypeParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleType_in_ruleTypeAndValue2491);
                    lv_value_3_0=ruleType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTypeAndValueRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_3_0, 
                            		"Type");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeAndValue"


    // $ANTLR start "entryRuleStructType"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1181:1: entryRuleStructType returns [String current=null] : iv_ruleStructType= ruleStructType EOF ;
    public final String entryRuleStructType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStructType = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1182:2: (iv_ruleStructType= ruleStructType EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1183:2: iv_ruleStructType= ruleStructType EOF
            {
             newCompositeNode(grammarAccess.getStructTypeRule()); 
            pushFollow(FOLLOW_ruleStructType_in_entryRuleStructType2529);
            iv_ruleStructType=ruleStructType();

            state._fsp--;

             current =iv_ruleStructType.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStructType2540); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStructType"


    // $ANTLR start "ruleStructType"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1190:1: ruleStructType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '{' ( (this_VAR_TYPE_1= RULE_VAR_TYPE | this_BType_2= ruleBType ) (kw= ',' (this_VAR_TYPE_4= RULE_VAR_TYPE | this_BType_5= ruleBType ) )* )? kw= '}' ) | (kw= '<' kw= '{' ( (this_VAR_TYPE_9= RULE_VAR_TYPE | this_BType_10= ruleBType ) (kw= ',' (this_VAR_TYPE_12= RULE_VAR_TYPE | this_BType_13= ruleBType ) )* )? kw= '}' kw= '>' ) ) ;
    public final AntlrDatatypeRuleToken ruleStructType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_VAR_TYPE_1=null;
        Token this_VAR_TYPE_4=null;
        Token this_VAR_TYPE_9=null;
        Token this_VAR_TYPE_12=null;
        AntlrDatatypeRuleToken this_BType_2 = null;

        AntlrDatatypeRuleToken this_BType_5 = null;

        AntlrDatatypeRuleToken this_BType_10 = null;

        AntlrDatatypeRuleToken this_BType_13 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1193:28: ( ( (kw= '{' ( (this_VAR_TYPE_1= RULE_VAR_TYPE | this_BType_2= ruleBType ) (kw= ',' (this_VAR_TYPE_4= RULE_VAR_TYPE | this_BType_5= ruleBType ) )* )? kw= '}' ) | (kw= '<' kw= '{' ( (this_VAR_TYPE_9= RULE_VAR_TYPE | this_BType_10= ruleBType ) (kw= ',' (this_VAR_TYPE_12= RULE_VAR_TYPE | this_BType_13= ruleBType ) )* )? kw= '}' kw= '>' ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1194:1: ( (kw= '{' ( (this_VAR_TYPE_1= RULE_VAR_TYPE | this_BType_2= ruleBType ) (kw= ',' (this_VAR_TYPE_4= RULE_VAR_TYPE | this_BType_5= ruleBType ) )* )? kw= '}' ) | (kw= '<' kw= '{' ( (this_VAR_TYPE_9= RULE_VAR_TYPE | this_BType_10= ruleBType ) (kw= ',' (this_VAR_TYPE_12= RULE_VAR_TYPE | this_BType_13= ruleBType ) )* )? kw= '}' kw= '>' ) )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1194:1: ( (kw= '{' ( (this_VAR_TYPE_1= RULE_VAR_TYPE | this_BType_2= ruleBType ) (kw= ',' (this_VAR_TYPE_4= RULE_VAR_TYPE | this_BType_5= ruleBType ) )* )? kw= '}' ) | (kw= '<' kw= '{' ( (this_VAR_TYPE_9= RULE_VAR_TYPE | this_BType_10= ruleBType ) (kw= ',' (this_VAR_TYPE_12= RULE_VAR_TYPE | this_BType_13= ruleBType ) )* )? kw= '}' kw= '>' ) )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==32) ) {
                alt43=1;
            }
            else if ( (LA43_0==36) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1194:2: (kw= '{' ( (this_VAR_TYPE_1= RULE_VAR_TYPE | this_BType_2= ruleBType ) (kw= ',' (this_VAR_TYPE_4= RULE_VAR_TYPE | this_BType_5= ruleBType ) )* )? kw= '}' )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1194:2: (kw= '{' ( (this_VAR_TYPE_1= RULE_VAR_TYPE | this_BType_2= ruleBType ) (kw= ',' (this_VAR_TYPE_4= RULE_VAR_TYPE | this_BType_5= ruleBType ) )* )? kw= '}' )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1195:2: kw= '{' ( (this_VAR_TYPE_1= RULE_VAR_TYPE | this_BType_2= ruleBType ) (kw= ',' (this_VAR_TYPE_4= RULE_VAR_TYPE | this_BType_5= ruleBType ) )* )? kw= '}'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleStructType2579); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getStructTypeAccess().getLeftCurlyBracketKeyword_0_0()); 
                        
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1200:1: ( (this_VAR_TYPE_1= RULE_VAR_TYPE | this_BType_2= ruleBType ) (kw= ',' (this_VAR_TYPE_4= RULE_VAR_TYPE | this_BType_5= ruleBType ) )* )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( ((LA38_0>=RULE_VAR_TYPE && LA38_0<=RULE_INT)||(LA38_0>=38 && LA38_0<=47)) ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1200:2: (this_VAR_TYPE_1= RULE_VAR_TYPE | this_BType_2= ruleBType ) (kw= ',' (this_VAR_TYPE_4= RULE_VAR_TYPE | this_BType_5= ruleBType ) )*
                            {
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1200:2: (this_VAR_TYPE_1= RULE_VAR_TYPE | this_BType_2= ruleBType )
                            int alt35=2;
                            int LA35_0 = input.LA(1);

                            if ( (LA35_0==RULE_VAR_TYPE) ) {
                                alt35=1;
                            }
                            else if ( ((LA35_0>=RULE_INTEGER && LA35_0<=RULE_INT)||(LA35_0>=38 && LA35_0<=47)) ) {
                                alt35=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 35, 0, input);

                                throw nvae;
                            }
                            switch (alt35) {
                                case 1 :
                                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1200:7: this_VAR_TYPE_1= RULE_VAR_TYPE
                                    {
                                    this_VAR_TYPE_1=(Token)match(input,RULE_VAR_TYPE,FOLLOW_RULE_VAR_TYPE_in_ruleStructType2596); 

                                    		current.merge(this_VAR_TYPE_1);
                                        
                                     
                                        newLeafNode(this_VAR_TYPE_1, grammarAccess.getStructTypeAccess().getVAR_TYPETerminalRuleCall_0_1_0_0()); 
                                        

                                    }
                                    break;
                                case 2 :
                                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1209:5: this_BType_2= ruleBType
                                    {
                                     
                                            newCompositeNode(grammarAccess.getStructTypeAccess().getBTypeParserRuleCall_0_1_0_1()); 
                                        
                                    pushFollow(FOLLOW_ruleBType_in_ruleStructType2629);
                                    this_BType_2=ruleBType();

                                    state._fsp--;


                                    		current.merge(this_BType_2);
                                        
                                     
                                            afterParserOrEnumRuleCall();
                                        

                                    }
                                    break;

                            }

                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1219:2: (kw= ',' (this_VAR_TYPE_4= RULE_VAR_TYPE | this_BType_5= ruleBType ) )*
                            loop37:
                            do {
                                int alt37=2;
                                int LA37_0 = input.LA(1);

                                if ( (LA37_0==23) ) {
                                    alt37=1;
                                }


                                switch (alt37) {
                            	case 1 :
                            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1220:2: kw= ',' (this_VAR_TYPE_4= RULE_VAR_TYPE | this_BType_5= ruleBType )
                            	    {
                            	    kw=(Token)match(input,23,FOLLOW_23_in_ruleStructType2649); 

                            	            current.merge(kw);
                            	            newLeafNode(kw, grammarAccess.getStructTypeAccess().getCommaKeyword_0_1_1_0()); 
                            	        
                            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1225:1: (this_VAR_TYPE_4= RULE_VAR_TYPE | this_BType_5= ruleBType )
                            	    int alt36=2;
                            	    int LA36_0 = input.LA(1);

                            	    if ( (LA36_0==RULE_VAR_TYPE) ) {
                            	        alt36=1;
                            	    }
                            	    else if ( ((LA36_0>=RULE_INTEGER && LA36_0<=RULE_INT)||(LA36_0>=38 && LA36_0<=47)) ) {
                            	        alt36=2;
                            	    }
                            	    else {
                            	        NoViableAltException nvae =
                            	            new NoViableAltException("", 36, 0, input);

                            	        throw nvae;
                            	    }
                            	    switch (alt36) {
                            	        case 1 :
                            	            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1225:6: this_VAR_TYPE_4= RULE_VAR_TYPE
                            	            {
                            	            this_VAR_TYPE_4=(Token)match(input,RULE_VAR_TYPE,FOLLOW_RULE_VAR_TYPE_in_ruleStructType2665); 

                            	            		current.merge(this_VAR_TYPE_4);
                            	                
                            	             
                            	                newLeafNode(this_VAR_TYPE_4, grammarAccess.getStructTypeAccess().getVAR_TYPETerminalRuleCall_0_1_1_1_0()); 
                            	                

                            	            }
                            	            break;
                            	        case 2 :
                            	            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1234:5: this_BType_5= ruleBType
                            	            {
                            	             
                            	                    newCompositeNode(grammarAccess.getStructTypeAccess().getBTypeParserRuleCall_0_1_1_1_1()); 
                            	                
                            	            pushFollow(FOLLOW_ruleBType_in_ruleStructType2698);
                            	            this_BType_5=ruleBType();

                            	            state._fsp--;


                            	            		current.merge(this_BType_5);
                            	                
                            	             
                            	                    afterParserOrEnumRuleCall();
                            	                

                            	            }
                            	            break;

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop37;
                                }
                            } while (true);


                            }
                            break;

                    }

                    kw=(Token)match(input,33,FOLLOW_33_in_ruleStructType2721); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getStructTypeAccess().getRightCurlyBracketKeyword_0_2()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1251:6: (kw= '<' kw= '{' ( (this_VAR_TYPE_9= RULE_VAR_TYPE | this_BType_10= ruleBType ) (kw= ',' (this_VAR_TYPE_12= RULE_VAR_TYPE | this_BType_13= ruleBType ) )* )? kw= '}' kw= '>' )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1251:6: (kw= '<' kw= '{' ( (this_VAR_TYPE_9= RULE_VAR_TYPE | this_BType_10= ruleBType ) (kw= ',' (this_VAR_TYPE_12= RULE_VAR_TYPE | this_BType_13= ruleBType ) )* )? kw= '}' kw= '>' )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1252:2: kw= '<' kw= '{' ( (this_VAR_TYPE_9= RULE_VAR_TYPE | this_BType_10= ruleBType ) (kw= ',' (this_VAR_TYPE_12= RULE_VAR_TYPE | this_BType_13= ruleBType ) )* )? kw= '}' kw= '>'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleStructType2742); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getStructTypeAccess().getLessThanSignKeyword_1_0()); 
                        
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleStructType2755); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getStructTypeAccess().getLeftCurlyBracketKeyword_1_1()); 
                        
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1263:1: ( (this_VAR_TYPE_9= RULE_VAR_TYPE | this_BType_10= ruleBType ) (kw= ',' (this_VAR_TYPE_12= RULE_VAR_TYPE | this_BType_13= ruleBType ) )* )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( ((LA42_0>=RULE_VAR_TYPE && LA42_0<=RULE_INT)||(LA42_0>=38 && LA42_0<=47)) ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1263:2: (this_VAR_TYPE_9= RULE_VAR_TYPE | this_BType_10= ruleBType ) (kw= ',' (this_VAR_TYPE_12= RULE_VAR_TYPE | this_BType_13= ruleBType ) )*
                            {
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1263:2: (this_VAR_TYPE_9= RULE_VAR_TYPE | this_BType_10= ruleBType )
                            int alt39=2;
                            int LA39_0 = input.LA(1);

                            if ( (LA39_0==RULE_VAR_TYPE) ) {
                                alt39=1;
                            }
                            else if ( ((LA39_0>=RULE_INTEGER && LA39_0<=RULE_INT)||(LA39_0>=38 && LA39_0<=47)) ) {
                                alt39=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 39, 0, input);

                                throw nvae;
                            }
                            switch (alt39) {
                                case 1 :
                                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1263:7: this_VAR_TYPE_9= RULE_VAR_TYPE
                                    {
                                    this_VAR_TYPE_9=(Token)match(input,RULE_VAR_TYPE,FOLLOW_RULE_VAR_TYPE_in_ruleStructType2772); 

                                    		current.merge(this_VAR_TYPE_9);
                                        
                                     
                                        newLeafNode(this_VAR_TYPE_9, grammarAccess.getStructTypeAccess().getVAR_TYPETerminalRuleCall_1_2_0_0()); 
                                        

                                    }
                                    break;
                                case 2 :
                                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1272:5: this_BType_10= ruleBType
                                    {
                                     
                                            newCompositeNode(grammarAccess.getStructTypeAccess().getBTypeParserRuleCall_1_2_0_1()); 
                                        
                                    pushFollow(FOLLOW_ruleBType_in_ruleStructType2805);
                                    this_BType_10=ruleBType();

                                    state._fsp--;


                                    		current.merge(this_BType_10);
                                        
                                     
                                            afterParserOrEnumRuleCall();
                                        

                                    }
                                    break;

                            }

                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1282:2: (kw= ',' (this_VAR_TYPE_12= RULE_VAR_TYPE | this_BType_13= ruleBType ) )*
                            loop41:
                            do {
                                int alt41=2;
                                int LA41_0 = input.LA(1);

                                if ( (LA41_0==23) ) {
                                    alt41=1;
                                }


                                switch (alt41) {
                            	case 1 :
                            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1283:2: kw= ',' (this_VAR_TYPE_12= RULE_VAR_TYPE | this_BType_13= ruleBType )
                            	    {
                            	    kw=(Token)match(input,23,FOLLOW_23_in_ruleStructType2825); 

                            	            current.merge(kw);
                            	            newLeafNode(kw, grammarAccess.getStructTypeAccess().getCommaKeyword_1_2_1_0()); 
                            	        
                            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1288:1: (this_VAR_TYPE_12= RULE_VAR_TYPE | this_BType_13= ruleBType )
                            	    int alt40=2;
                            	    int LA40_0 = input.LA(1);

                            	    if ( (LA40_0==RULE_VAR_TYPE) ) {
                            	        alt40=1;
                            	    }
                            	    else if ( ((LA40_0>=RULE_INTEGER && LA40_0<=RULE_INT)||(LA40_0>=38 && LA40_0<=47)) ) {
                            	        alt40=2;
                            	    }
                            	    else {
                            	        NoViableAltException nvae =
                            	            new NoViableAltException("", 40, 0, input);

                            	        throw nvae;
                            	    }
                            	    switch (alt40) {
                            	        case 1 :
                            	            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1288:6: this_VAR_TYPE_12= RULE_VAR_TYPE
                            	            {
                            	            this_VAR_TYPE_12=(Token)match(input,RULE_VAR_TYPE,FOLLOW_RULE_VAR_TYPE_in_ruleStructType2841); 

                            	            		current.merge(this_VAR_TYPE_12);
                            	                
                            	             
                            	                newLeafNode(this_VAR_TYPE_12, grammarAccess.getStructTypeAccess().getVAR_TYPETerminalRuleCall_1_2_1_1_0()); 
                            	                

                            	            }
                            	            break;
                            	        case 2 :
                            	            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1297:5: this_BType_13= ruleBType
                            	            {
                            	             
                            	                    newCompositeNode(grammarAccess.getStructTypeAccess().getBTypeParserRuleCall_1_2_1_1_1()); 
                            	                
                            	            pushFollow(FOLLOW_ruleBType_in_ruleStructType2874);
                            	            this_BType_13=ruleBType();

                            	            state._fsp--;


                            	            		current.merge(this_BType_13);
                            	                
                            	             
                            	                    afterParserOrEnumRuleCall();
                            	                

                            	            }
                            	            break;

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop41;
                                }
                            } while (true);


                            }
                            break;

                    }

                    kw=(Token)match(input,33,FOLLOW_33_in_ruleStructType2897); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getStructTypeAccess().getRightCurlyBracketKeyword_1_3()); 
                        
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleStructType2910); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getStructTypeAccess().getGreaterThanSignKeyword_1_4()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStructType"


    // $ANTLR start "entryRuleBType"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1327:1: entryRuleBType returns [String current=null] : iv_ruleBType= ruleBType EOF ;
    public final String entryRuleBType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBType = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1328:2: (iv_ruleBType= ruleBType EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1329:2: iv_ruleBType= ruleBType EOF
            {
             newCompositeNode(grammarAccess.getBTypeRule()); 
            pushFollow(FOLLOW_ruleBType_in_entryRuleBType2952);
            iv_ruleBType=ruleBType();

            state._fsp--;

             current =iv_ruleBType.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBType2963); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBType"


    // $ANTLR start "ruleBType"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1336:1: ruleBType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INTEGER_0= RULE_INTEGER | this_F_POINT_1= ruleF_POINT | this_BasicType_2= ruleBasicType | this_INT_3= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleBType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INTEGER_0=null;
        Token this_INT_3=null;
        AntlrDatatypeRuleToken this_F_POINT_1 = null;

        AntlrDatatypeRuleToken this_BasicType_2 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1339:28: ( (this_INTEGER_0= RULE_INTEGER | this_F_POINT_1= ruleF_POINT | this_BasicType_2= ruleBasicType | this_INT_3= RULE_INT ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1340:1: (this_INTEGER_0= RULE_INTEGER | this_F_POINT_1= ruleF_POINT | this_BasicType_2= ruleBasicType | this_INT_3= RULE_INT )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1340:1: (this_INTEGER_0= RULE_INTEGER | this_F_POINT_1= ruleF_POINT | this_BasicType_2= ruleBasicType | this_INT_3= RULE_INT )
            int alt44=4;
            switch ( input.LA(1) ) {
            case RULE_INTEGER:
                {
                alt44=1;
                }
                break;
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
                {
                alt44=2;
                }
                break;
            case 38:
            case 39:
            case 40:
            case 41:
                {
                alt44=3;
                }
                break;
            case RULE_INT:
                {
                alt44=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1340:6: this_INTEGER_0= RULE_INTEGER
                    {
                    this_INTEGER_0=(Token)match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_ruleBType3003); 

                    		current.merge(this_INTEGER_0);
                        
                     
                        newLeafNode(this_INTEGER_0, grammarAccess.getBTypeAccess().getINTEGERTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1349:5: this_F_POINT_1= ruleF_POINT
                    {
                     
                            newCompositeNode(grammarAccess.getBTypeAccess().getF_POINTParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleF_POINT_in_ruleBType3036);
                    this_F_POINT_1=ruleF_POINT();

                    state._fsp--;


                    		current.merge(this_F_POINT_1);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1361:5: this_BasicType_2= ruleBasicType
                    {
                     
                            newCompositeNode(grammarAccess.getBTypeAccess().getBasicTypeParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleBasicType_in_ruleBType3069);
                    this_BasicType_2=ruleBasicType();

                    state._fsp--;


                    		current.merge(this_BasicType_2);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1372:10: this_INT_3= RULE_INT
                    {
                    this_INT_3=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleBType3095); 

                    		current.merge(this_INT_3);
                        
                     
                        newLeafNode(this_INT_3, grammarAccess.getBTypeAccess().getINTTerminalRuleCall_3()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBType"


    // $ANTLR start "entryRuleBasicType"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1387:1: entryRuleBasicType returns [String current=null] : iv_ruleBasicType= ruleBasicType EOF ;
    public final String entryRuleBasicType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBasicType = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1388:2: (iv_ruleBasicType= ruleBasicType EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1389:2: iv_ruleBasicType= ruleBasicType EOF
            {
             newCompositeNode(grammarAccess.getBasicTypeRule()); 
            pushFollow(FOLLOW_ruleBasicType_in_entryRuleBasicType3141);
            iv_ruleBasicType=ruleBasicType();

            state._fsp--;

             current =iv_ruleBasicType.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBasicType3152); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBasicType"


    // $ANTLR start "ruleBasicType"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1396:1: ruleBasicType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'void' | kw= 'null' | kw= 'label' | kw= 'undef' ) ;
    public final AntlrDatatypeRuleToken ruleBasicType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1399:28: ( (kw= 'void' | kw= 'null' | kw= 'label' | kw= 'undef' ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1400:1: (kw= 'void' | kw= 'null' | kw= 'label' | kw= 'undef' )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1400:1: (kw= 'void' | kw= 'null' | kw= 'label' | kw= 'undef' )
            int alt45=4;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt45=1;
                }
                break;
            case 39:
                {
                alt45=2;
                }
                break;
            case 40:
                {
                alt45=3;
                }
                break;
            case 41:
                {
                alt45=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1401:2: kw= 'void'
                    {
                    kw=(Token)match(input,38,FOLLOW_38_in_ruleBasicType3190); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBasicTypeAccess().getVoidKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1408:2: kw= 'null'
                    {
                    kw=(Token)match(input,39,FOLLOW_39_in_ruleBasicType3209); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBasicTypeAccess().getNullKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1415:2: kw= 'label'
                    {
                    kw=(Token)match(input,40,FOLLOW_40_in_ruleBasicType3228); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBasicTypeAccess().getLabelKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1422:2: kw= 'undef'
                    {
                    kw=(Token)match(input,41,FOLLOW_41_in_ruleBasicType3247); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBasicTypeAccess().getUndefKeyword_3()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBasicType"


    // $ANTLR start "entryRuleF_POINT"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1435:1: entryRuleF_POINT returns [String current=null] : iv_ruleF_POINT= ruleF_POINT EOF ;
    public final String entryRuleF_POINT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleF_POINT = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1436:2: (iv_ruleF_POINT= ruleF_POINT EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1437:2: iv_ruleF_POINT= ruleF_POINT EOF
            {
             newCompositeNode(grammarAccess.getF_POINTRule()); 
            pushFollow(FOLLOW_ruleF_POINT_in_entryRuleF_POINT3288);
            iv_ruleF_POINT=ruleF_POINT();

            state._fsp--;

             current =iv_ruleF_POINT.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleF_POINT3299); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleF_POINT"


    // $ANTLR start "ruleF_POINT"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1444:1: ruleF_POINT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'half' | kw= 'float' | kw= 'double' | kw= 'x86_fp80' | kw= 'fp128' | kw= 'ppc_fp128' ) ;
    public final AntlrDatatypeRuleToken ruleF_POINT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1447:28: ( (kw= 'half' | kw= 'float' | kw= 'double' | kw= 'x86_fp80' | kw= 'fp128' | kw= 'ppc_fp128' ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1448:1: (kw= 'half' | kw= 'float' | kw= 'double' | kw= 'x86_fp80' | kw= 'fp128' | kw= 'ppc_fp128' )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1448:1: (kw= 'half' | kw= 'float' | kw= 'double' | kw= 'x86_fp80' | kw= 'fp128' | kw= 'ppc_fp128' )
            int alt46=6;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt46=1;
                }
                break;
            case 43:
                {
                alt46=2;
                }
                break;
            case 44:
                {
                alt46=3;
                }
                break;
            case 45:
                {
                alt46=4;
                }
                break;
            case 46:
                {
                alt46=5;
                }
                break;
            case 47:
                {
                alt46=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1449:2: kw= 'half'
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleF_POINT3337); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getF_POINTAccess().getHalfKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1456:2: kw= 'float'
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleF_POINT3356); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getF_POINTAccess().getFloatKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1463:2: kw= 'double'
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleF_POINT3375); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getF_POINTAccess().getDoubleKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1470:2: kw= 'x86_fp80'
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleF_POINT3394); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getF_POINTAccess().getX86_fp80Keyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1477:2: kw= 'fp128'
                    {
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleF_POINT3413); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getF_POINTAccess().getFp128Keyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1484:2: kw= 'ppc_fp128'
                    {
                    kw=(Token)match(input,47,FOLLOW_47_in_ruleF_POINT3432); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getF_POINTAccess().getPpc_fp128Keyword_5()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleF_POINT"


    // $ANTLR start "entryRuleGetElementPtr"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1497:1: entryRuleGetElementPtr returns [EObject current=null] : iv_ruleGetElementPtr= ruleGetElementPtr EOF ;
    public final EObject entryRuleGetElementPtr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGetElementPtr = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1498:2: (iv_ruleGetElementPtr= ruleGetElementPtr EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1499:2: iv_ruleGetElementPtr= ruleGetElementPtr EOF
            {
             newCompositeNode(grammarAccess.getGetElementPtrRule()); 
            pushFollow(FOLLOW_ruleGetElementPtr_in_entryRuleGetElementPtr3472);
            iv_ruleGetElementPtr=ruleGetElementPtr();

            state._fsp--;

             current =iv_ruleGetElementPtr; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGetElementPtr3482); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGetElementPtr"


    // $ANTLR start "ruleGetElementPtr"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1506:1: ruleGetElementPtr returns [EObject current=null] : (otherlv_0= 'getelementptr' (otherlv_1= 'inbounds' )? ( (lv_pointer_2_0= ruleTypeAndValue ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleTypeAndValue ) ) )* ) ;
    public final EObject ruleGetElementPtr() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_pointer_2_0 = null;

        EObject lv_params_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1509:28: ( (otherlv_0= 'getelementptr' (otherlv_1= 'inbounds' )? ( (lv_pointer_2_0= ruleTypeAndValue ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleTypeAndValue ) ) )* ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1510:1: (otherlv_0= 'getelementptr' (otherlv_1= 'inbounds' )? ( (lv_pointer_2_0= ruleTypeAndValue ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleTypeAndValue ) ) )* )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1510:1: (otherlv_0= 'getelementptr' (otherlv_1= 'inbounds' )? ( (lv_pointer_2_0= ruleTypeAndValue ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleTypeAndValue ) ) )* )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1510:3: otherlv_0= 'getelementptr' (otherlv_1= 'inbounds' )? ( (lv_pointer_2_0= ruleTypeAndValue ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleTypeAndValue ) ) )*
            {
            otherlv_0=(Token)match(input,48,FOLLOW_48_in_ruleGetElementPtr3519); 

                	newLeafNode(otherlv_0, grammarAccess.getGetElementPtrAccess().getGetelementptrKeyword_0());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1514:1: (otherlv_1= 'inbounds' )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==49) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1514:3: otherlv_1= 'inbounds'
                    {
                    otherlv_1=(Token)match(input,49,FOLLOW_49_in_ruleGetElementPtr3532); 

                        	newLeafNode(otherlv_1, grammarAccess.getGetElementPtrAccess().getInboundsKeyword_1());
                        

                    }
                    break;

            }

            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1518:3: ( (lv_pointer_2_0= ruleTypeAndValue ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1519:1: (lv_pointer_2_0= ruleTypeAndValue )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1519:1: (lv_pointer_2_0= ruleTypeAndValue )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1520:3: lv_pointer_2_0= ruleTypeAndValue
            {
             
            	        newCompositeNode(grammarAccess.getGetElementPtrAccess().getPointerTypeAndValueParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleTypeAndValue_in_ruleGetElementPtr3555);
            lv_pointer_2_0=ruleTypeAndValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getGetElementPtrRule());
            	        }
                   		add(
                   			current, 
                   			"pointer",
                    		lv_pointer_2_0, 
                    		"TypeAndValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1536:2: (otherlv_3= ',' ( (lv_params_4_0= ruleTypeAndValue ) ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==23) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1536:4: otherlv_3= ',' ( (lv_params_4_0= ruleTypeAndValue ) )
            	    {
            	    otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleGetElementPtr3568); 

            	        	newLeafNode(otherlv_3, grammarAccess.getGetElementPtrAccess().getCommaKeyword_3_0());
            	        
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1540:1: ( (lv_params_4_0= ruleTypeAndValue ) )
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1541:1: (lv_params_4_0= ruleTypeAndValue )
            	    {
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1541:1: (lv_params_4_0= ruleTypeAndValue )
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1542:3: lv_params_4_0= ruleTypeAndValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGetElementPtrAccess().getParamsTypeAndValueParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTypeAndValue_in_ruleGetElementPtr3589);
            	    lv_params_4_0=ruleTypeAndValue();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGetElementPtrRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"params",
            	            		lv_params_4_0, 
            	            		"TypeAndValue");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGetElementPtr"


    // $ANTLR start "entryRuleExtractValue"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1566:1: entryRuleExtractValue returns [EObject current=null] : iv_ruleExtractValue= ruleExtractValue EOF ;
    public final EObject entryRuleExtractValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtractValue = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1567:2: (iv_ruleExtractValue= ruleExtractValue EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1568:2: iv_ruleExtractValue= ruleExtractValue EOF
            {
             newCompositeNode(grammarAccess.getExtractValueRule()); 
            pushFollow(FOLLOW_ruleExtractValue_in_entryRuleExtractValue3627);
            iv_ruleExtractValue=ruleExtractValue();

            state._fsp--;

             current =iv_ruleExtractValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExtractValue3637); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExtractValue"


    // $ANTLR start "ruleExtractValue"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1575:1: ruleExtractValue returns [EObject current=null] : (otherlv_0= 'extractvalue' ( (lv_aggregate_1_0= ruleAggregate ) ) ( (lv_type_2_0= ruleType ) ) (otherlv_3= ',' ( (lv_index_4_0= RULE_INT ) ) )+ ) ;
    public final EObject ruleExtractValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token lv_index_4_0=null;
        EObject lv_aggregate_1_0 = null;

        AntlrDatatypeRuleToken lv_type_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1578:28: ( (otherlv_0= 'extractvalue' ( (lv_aggregate_1_0= ruleAggregate ) ) ( (lv_type_2_0= ruleType ) ) (otherlv_3= ',' ( (lv_index_4_0= RULE_INT ) ) )+ ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1579:1: (otherlv_0= 'extractvalue' ( (lv_aggregate_1_0= ruleAggregate ) ) ( (lv_type_2_0= ruleType ) ) (otherlv_3= ',' ( (lv_index_4_0= RULE_INT ) ) )+ )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1579:1: (otherlv_0= 'extractvalue' ( (lv_aggregate_1_0= ruleAggregate ) ) ( (lv_type_2_0= ruleType ) ) (otherlv_3= ',' ( (lv_index_4_0= RULE_INT ) ) )+ )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1579:3: otherlv_0= 'extractvalue' ( (lv_aggregate_1_0= ruleAggregate ) ) ( (lv_type_2_0= ruleType ) ) (otherlv_3= ',' ( (lv_index_4_0= RULE_INT ) ) )+
            {
            otherlv_0=(Token)match(input,50,FOLLOW_50_in_ruleExtractValue3674); 

                	newLeafNode(otherlv_0, grammarAccess.getExtractValueAccess().getExtractvalueKeyword_0());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1583:1: ( (lv_aggregate_1_0= ruleAggregate ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1584:1: (lv_aggregate_1_0= ruleAggregate )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1584:1: (lv_aggregate_1_0= ruleAggregate )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1585:3: lv_aggregate_1_0= ruleAggregate
            {
             
            	        newCompositeNode(grammarAccess.getExtractValueAccess().getAggregateAggregateParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleAggregate_in_ruleExtractValue3695);
            lv_aggregate_1_0=ruleAggregate();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExtractValueRule());
            	        }
                   		set(
                   			current, 
                   			"aggregate",
                    		lv_aggregate_1_0, 
                    		"Aggregate");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1601:2: ( (lv_type_2_0= ruleType ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1602:1: (lv_type_2_0= ruleType )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1602:1: (lv_type_2_0= ruleType )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1603:3: lv_type_2_0= ruleType
            {
             
            	        newCompositeNode(grammarAccess.getExtractValueAccess().getTypeTypeParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleType_in_ruleExtractValue3716);
            lv_type_2_0=ruleType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExtractValueRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_2_0, 
                    		"Type");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1619:2: (otherlv_3= ',' ( (lv_index_4_0= RULE_INT ) ) )+
            int cnt49=0;
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==23) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1619:4: otherlv_3= ',' ( (lv_index_4_0= RULE_INT ) )
            	    {
            	    otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleExtractValue3729); 

            	        	newLeafNode(otherlv_3, grammarAccess.getExtractValueAccess().getCommaKeyword_3_0());
            	        
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1623:1: ( (lv_index_4_0= RULE_INT ) )
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1624:1: (lv_index_4_0= RULE_INT )
            	    {
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1624:1: (lv_index_4_0= RULE_INT )
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1625:3: lv_index_4_0= RULE_INT
            	    {
            	    lv_index_4_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleExtractValue3746); 

            	    			newLeafNode(lv_index_4_0, grammarAccess.getExtractValueAccess().getIndexINTTerminalRuleCall_3_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getExtractValueRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"index",
            	            		lv_index_4_0, 
            	            		"INT");
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt49 >= 1 ) break loop49;
                        EarlyExitException eee =
                            new EarlyExitException(49, input);
                        throw eee;
                }
                cnt49++;
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExtractValue"


    // $ANTLR start "entryRuleInsertValue"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1649:1: entryRuleInsertValue returns [EObject current=null] : iv_ruleInsertValue= ruleInsertValue EOF ;
    public final EObject entryRuleInsertValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInsertValue = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1650:2: (iv_ruleInsertValue= ruleInsertValue EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1651:2: iv_ruleInsertValue= ruleInsertValue EOF
            {
             newCompositeNode(grammarAccess.getInsertValueRule()); 
            pushFollow(FOLLOW_ruleInsertValue_in_entryRuleInsertValue3789);
            iv_ruleInsertValue=ruleInsertValue();

            state._fsp--;

             current =iv_ruleInsertValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInsertValue3799); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInsertValue"


    // $ANTLR start "ruleInsertValue"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1658:1: ruleInsertValue returns [EObject current=null] : (otherlv_0= 'insertvalue' ( (lv_aggregate_1_0= ruleAggregate ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ',' ( (lv_value_4_0= ruleTypeAndValue ) ) (otherlv_5= ',' ( (lv_index_6_0= RULE_INT ) ) )+ ) ;
    public final EObject ruleInsertValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_index_6_0=null;
        EObject lv_aggregate_1_0 = null;

        AntlrDatatypeRuleToken lv_type_2_0 = null;

        EObject lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1661:28: ( (otherlv_0= 'insertvalue' ( (lv_aggregate_1_0= ruleAggregate ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ',' ( (lv_value_4_0= ruleTypeAndValue ) ) (otherlv_5= ',' ( (lv_index_6_0= RULE_INT ) ) )+ ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1662:1: (otherlv_0= 'insertvalue' ( (lv_aggregate_1_0= ruleAggregate ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ',' ( (lv_value_4_0= ruleTypeAndValue ) ) (otherlv_5= ',' ( (lv_index_6_0= RULE_INT ) ) )+ )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1662:1: (otherlv_0= 'insertvalue' ( (lv_aggregate_1_0= ruleAggregate ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ',' ( (lv_value_4_0= ruleTypeAndValue ) ) (otherlv_5= ',' ( (lv_index_6_0= RULE_INT ) ) )+ )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1662:3: otherlv_0= 'insertvalue' ( (lv_aggregate_1_0= ruleAggregate ) ) ( (lv_type_2_0= ruleType ) ) otherlv_3= ',' ( (lv_value_4_0= ruleTypeAndValue ) ) (otherlv_5= ',' ( (lv_index_6_0= RULE_INT ) ) )+
            {
            otherlv_0=(Token)match(input,51,FOLLOW_51_in_ruleInsertValue3836); 

                	newLeafNode(otherlv_0, grammarAccess.getInsertValueAccess().getInsertvalueKeyword_0());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1666:1: ( (lv_aggregate_1_0= ruleAggregate ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1667:1: (lv_aggregate_1_0= ruleAggregate )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1667:1: (lv_aggregate_1_0= ruleAggregate )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1668:3: lv_aggregate_1_0= ruleAggregate
            {
             
            	        newCompositeNode(grammarAccess.getInsertValueAccess().getAggregateAggregateParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleAggregate_in_ruleInsertValue3857);
            lv_aggregate_1_0=ruleAggregate();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInsertValueRule());
            	        }
                   		set(
                   			current, 
                   			"aggregate",
                    		lv_aggregate_1_0, 
                    		"Aggregate");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1684:2: ( (lv_type_2_0= ruleType ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1685:1: (lv_type_2_0= ruleType )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1685:1: (lv_type_2_0= ruleType )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1686:3: lv_type_2_0= ruleType
            {
             
            	        newCompositeNode(grammarAccess.getInsertValueAccess().getTypeTypeParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleType_in_ruleInsertValue3878);
            lv_type_2_0=ruleType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInsertValueRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_2_0, 
                    		"Type");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleInsertValue3890); 

                	newLeafNode(otherlv_3, grammarAccess.getInsertValueAccess().getCommaKeyword_3());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1706:1: ( (lv_value_4_0= ruleTypeAndValue ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1707:1: (lv_value_4_0= ruleTypeAndValue )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1707:1: (lv_value_4_0= ruleTypeAndValue )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1708:3: lv_value_4_0= ruleTypeAndValue
            {
             
            	        newCompositeNode(grammarAccess.getInsertValueAccess().getValueTypeAndValueParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleTypeAndValue_in_ruleInsertValue3911);
            lv_value_4_0=ruleTypeAndValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInsertValueRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_4_0, 
                    		"TypeAndValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1724:2: (otherlv_5= ',' ( (lv_index_6_0= RULE_INT ) ) )+
            int cnt50=0;
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==23) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1724:4: otherlv_5= ',' ( (lv_index_6_0= RULE_INT ) )
            	    {
            	    otherlv_5=(Token)match(input,23,FOLLOW_23_in_ruleInsertValue3924); 

            	        	newLeafNode(otherlv_5, grammarAccess.getInsertValueAccess().getCommaKeyword_5_0());
            	        
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1728:1: ( (lv_index_6_0= RULE_INT ) )
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1729:1: (lv_index_6_0= RULE_INT )
            	    {
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1729:1: (lv_index_6_0= RULE_INT )
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1730:3: lv_index_6_0= RULE_INT
            	    {
            	    lv_index_6_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleInsertValue3941); 

            	    			newLeafNode(lv_index_6_0, grammarAccess.getInsertValueAccess().getIndexINTTerminalRuleCall_5_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getInsertValueRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"index",
            	            		lv_index_6_0, 
            	            		"INT");
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt50 >= 1 ) break loop50;
                        EarlyExitException eee =
                            new EarlyExitException(50, input);
                        throw eee;
                }
                cnt50++;
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInsertValue"


    // $ANTLR start "entryRuleFence"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1754:1: entryRuleFence returns [EObject current=null] : iv_ruleFence= ruleFence EOF ;
    public final EObject entryRuleFence() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFence = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1755:2: (iv_ruleFence= ruleFence EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1756:2: iv_ruleFence= ruleFence EOF
            {
             newCompositeNode(grammarAccess.getFenceRule()); 
            pushFollow(FOLLOW_ruleFence_in_entryRuleFence3984);
            iv_ruleFence=ruleFence();

            state._fsp--;

             current =iv_ruleFence; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFence3994); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFence"


    // $ANTLR start "ruleFence"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1763:1: ruleFence returns [EObject current=null] : (otherlv_0= 'fence' (otherlv_1= 'singlethread' )? ( (lv_ordering_2_0= ruleATOMIC_ORDERING ) ) ) ;
    public final EObject ruleFence() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_ordering_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1766:28: ( (otherlv_0= 'fence' (otherlv_1= 'singlethread' )? ( (lv_ordering_2_0= ruleATOMIC_ORDERING ) ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1767:1: (otherlv_0= 'fence' (otherlv_1= 'singlethread' )? ( (lv_ordering_2_0= ruleATOMIC_ORDERING ) ) )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1767:1: (otherlv_0= 'fence' (otherlv_1= 'singlethread' )? ( (lv_ordering_2_0= ruleATOMIC_ORDERING ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1767:3: otherlv_0= 'fence' (otherlv_1= 'singlethread' )? ( (lv_ordering_2_0= ruleATOMIC_ORDERING ) )
            {
            otherlv_0=(Token)match(input,52,FOLLOW_52_in_ruleFence4031); 

                	newLeafNode(otherlv_0, grammarAccess.getFenceAccess().getFenceKeyword_0());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1771:1: (otherlv_1= 'singlethread' )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==53) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1771:3: otherlv_1= 'singlethread'
                    {
                    otherlv_1=(Token)match(input,53,FOLLOW_53_in_ruleFence4044); 

                        	newLeafNode(otherlv_1, grammarAccess.getFenceAccess().getSinglethreadKeyword_1());
                        

                    }
                    break;

            }

            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1775:3: ( (lv_ordering_2_0= ruleATOMIC_ORDERING ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1776:1: (lv_ordering_2_0= ruleATOMIC_ORDERING )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1776:1: (lv_ordering_2_0= ruleATOMIC_ORDERING )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1777:3: lv_ordering_2_0= ruleATOMIC_ORDERING
            {
             
            	        newCompositeNode(grammarAccess.getFenceAccess().getOrderingATOMIC_ORDERINGParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleATOMIC_ORDERING_in_ruleFence4067);
            lv_ordering_2_0=ruleATOMIC_ORDERING();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFenceRule());
            	        }
                   		set(
                   			current, 
                   			"ordering",
                    		lv_ordering_2_0, 
                    		"ATOMIC_ORDERING");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFence"


    // $ANTLR start "entryRuleATOMIC_ORDERING"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1801:1: entryRuleATOMIC_ORDERING returns [String current=null] : iv_ruleATOMIC_ORDERING= ruleATOMIC_ORDERING EOF ;
    public final String entryRuleATOMIC_ORDERING() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleATOMIC_ORDERING = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1802:2: (iv_ruleATOMIC_ORDERING= ruleATOMIC_ORDERING EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1803:2: iv_ruleATOMIC_ORDERING= ruleATOMIC_ORDERING EOF
            {
             newCompositeNode(grammarAccess.getATOMIC_ORDERINGRule()); 
            pushFollow(FOLLOW_ruleATOMIC_ORDERING_in_entryRuleATOMIC_ORDERING4104);
            iv_ruleATOMIC_ORDERING=ruleATOMIC_ORDERING();

            state._fsp--;

             current =iv_ruleATOMIC_ORDERING.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleATOMIC_ORDERING4115); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleATOMIC_ORDERING"


    // $ANTLR start "ruleATOMIC_ORDERING"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1810:1: ruleATOMIC_ORDERING returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'unordered' | kw= 'monotonic' | kw= 'aquire' | kw= 'release' | kw= 'acq_rel' | kw= 'seq_cst' ) ;
    public final AntlrDatatypeRuleToken ruleATOMIC_ORDERING() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1813:28: ( (kw= 'unordered' | kw= 'monotonic' | kw= 'aquire' | kw= 'release' | kw= 'acq_rel' | kw= 'seq_cst' ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1814:1: (kw= 'unordered' | kw= 'monotonic' | kw= 'aquire' | kw= 'release' | kw= 'acq_rel' | kw= 'seq_cst' )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1814:1: (kw= 'unordered' | kw= 'monotonic' | kw= 'aquire' | kw= 'release' | kw= 'acq_rel' | kw= 'seq_cst' )
            int alt52=6;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt52=1;
                }
                break;
            case 55:
                {
                alt52=2;
                }
                break;
            case 56:
                {
                alt52=3;
                }
                break;
            case 57:
                {
                alt52=4;
                }
                break;
            case 58:
                {
                alt52=5;
                }
                break;
            case 59:
                {
                alt52=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1815:2: kw= 'unordered'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleATOMIC_ORDERING4153); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getATOMIC_ORDERINGAccess().getUnorderedKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1822:2: kw= 'monotonic'
                    {
                    kw=(Token)match(input,55,FOLLOW_55_in_ruleATOMIC_ORDERING4172); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getATOMIC_ORDERINGAccess().getMonotonicKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1829:2: kw= 'aquire'
                    {
                    kw=(Token)match(input,56,FOLLOW_56_in_ruleATOMIC_ORDERING4191); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getATOMIC_ORDERINGAccess().getAquireKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1836:2: kw= 'release'
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleATOMIC_ORDERING4210); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getATOMIC_ORDERINGAccess().getReleaseKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1843:2: kw= 'acq_rel'
                    {
                    kw=(Token)match(input,58,FOLLOW_58_in_ruleATOMIC_ORDERING4229); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getATOMIC_ORDERINGAccess().getAcq_relKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1850:2: kw= 'seq_cst'
                    {
                    kw=(Token)match(input,59,FOLLOW_59_in_ruleATOMIC_ORDERING4248); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getATOMIC_ORDERINGAccess().getSeq_cstKeyword_5()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleATOMIC_ORDERING"


    // $ANTLR start "entryRuleCmpXchg"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1863:1: entryRuleCmpXchg returns [EObject current=null] : iv_ruleCmpXchg= ruleCmpXchg EOF ;
    public final EObject entryRuleCmpXchg() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCmpXchg = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1864:2: (iv_ruleCmpXchg= ruleCmpXchg EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1865:2: iv_ruleCmpXchg= ruleCmpXchg EOF
            {
             newCompositeNode(grammarAccess.getCmpXchgRule()); 
            pushFollow(FOLLOW_ruleCmpXchg_in_entryRuleCmpXchg4288);
            iv_ruleCmpXchg=ruleCmpXchg();

            state._fsp--;

             current =iv_ruleCmpXchg; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCmpXchg4298); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCmpXchg"


    // $ANTLR start "ruleCmpXchg"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1872:1: ruleCmpXchg returns [EObject current=null] : (otherlv_0= 'cmpxchg' (otherlv_1= 'volatile' )? ( (lv_adress_2_0= ruleTypeAndValue ) ) otherlv_3= ',' ( (lv_compare_val_4_0= ruleTypeAndValue ) ) otherlv_5= ',' ( (lv_new_val_6_0= ruleTypeAndValue ) ) (otherlv_7= 'singlethread' )? ( (lv_ordering_8_0= ruleATOMIC_ORDERING ) ) ) ;
    public final EObject ruleCmpXchg() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_adress_2_0 = null;

        EObject lv_compare_val_4_0 = null;

        EObject lv_new_val_6_0 = null;

        AntlrDatatypeRuleToken lv_ordering_8_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1875:28: ( (otherlv_0= 'cmpxchg' (otherlv_1= 'volatile' )? ( (lv_adress_2_0= ruleTypeAndValue ) ) otherlv_3= ',' ( (lv_compare_val_4_0= ruleTypeAndValue ) ) otherlv_5= ',' ( (lv_new_val_6_0= ruleTypeAndValue ) ) (otherlv_7= 'singlethread' )? ( (lv_ordering_8_0= ruleATOMIC_ORDERING ) ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1876:1: (otherlv_0= 'cmpxchg' (otherlv_1= 'volatile' )? ( (lv_adress_2_0= ruleTypeAndValue ) ) otherlv_3= ',' ( (lv_compare_val_4_0= ruleTypeAndValue ) ) otherlv_5= ',' ( (lv_new_val_6_0= ruleTypeAndValue ) ) (otherlv_7= 'singlethread' )? ( (lv_ordering_8_0= ruleATOMIC_ORDERING ) ) )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1876:1: (otherlv_0= 'cmpxchg' (otherlv_1= 'volatile' )? ( (lv_adress_2_0= ruleTypeAndValue ) ) otherlv_3= ',' ( (lv_compare_val_4_0= ruleTypeAndValue ) ) otherlv_5= ',' ( (lv_new_val_6_0= ruleTypeAndValue ) ) (otherlv_7= 'singlethread' )? ( (lv_ordering_8_0= ruleATOMIC_ORDERING ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1876:3: otherlv_0= 'cmpxchg' (otherlv_1= 'volatile' )? ( (lv_adress_2_0= ruleTypeAndValue ) ) otherlv_3= ',' ( (lv_compare_val_4_0= ruleTypeAndValue ) ) otherlv_5= ',' ( (lv_new_val_6_0= ruleTypeAndValue ) ) (otherlv_7= 'singlethread' )? ( (lv_ordering_8_0= ruleATOMIC_ORDERING ) )
            {
            otherlv_0=(Token)match(input,60,FOLLOW_60_in_ruleCmpXchg4335); 

                	newLeafNode(otherlv_0, grammarAccess.getCmpXchgAccess().getCmpxchgKeyword_0());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1880:1: (otherlv_1= 'volatile' )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==61) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1880:3: otherlv_1= 'volatile'
                    {
                    otherlv_1=(Token)match(input,61,FOLLOW_61_in_ruleCmpXchg4348); 

                        	newLeafNode(otherlv_1, grammarAccess.getCmpXchgAccess().getVolatileKeyword_1());
                        

                    }
                    break;

            }

            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1884:3: ( (lv_adress_2_0= ruleTypeAndValue ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1885:1: (lv_adress_2_0= ruleTypeAndValue )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1885:1: (lv_adress_2_0= ruleTypeAndValue )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1886:3: lv_adress_2_0= ruleTypeAndValue
            {
             
            	        newCompositeNode(grammarAccess.getCmpXchgAccess().getAdressTypeAndValueParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleTypeAndValue_in_ruleCmpXchg4371);
            lv_adress_2_0=ruleTypeAndValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCmpXchgRule());
            	        }
                   		set(
                   			current, 
                   			"adress",
                    		lv_adress_2_0, 
                    		"TypeAndValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleCmpXchg4383); 

                	newLeafNode(otherlv_3, grammarAccess.getCmpXchgAccess().getCommaKeyword_3());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1906:1: ( (lv_compare_val_4_0= ruleTypeAndValue ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1907:1: (lv_compare_val_4_0= ruleTypeAndValue )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1907:1: (lv_compare_val_4_0= ruleTypeAndValue )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1908:3: lv_compare_val_4_0= ruleTypeAndValue
            {
             
            	        newCompositeNode(grammarAccess.getCmpXchgAccess().getCompare_valTypeAndValueParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleTypeAndValue_in_ruleCmpXchg4404);
            lv_compare_val_4_0=ruleTypeAndValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCmpXchgRule());
            	        }
                   		set(
                   			current, 
                   			"compare_val",
                    		lv_compare_val_4_0, 
                    		"TypeAndValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,23,FOLLOW_23_in_ruleCmpXchg4416); 

                	newLeafNode(otherlv_5, grammarAccess.getCmpXchgAccess().getCommaKeyword_5());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1928:1: ( (lv_new_val_6_0= ruleTypeAndValue ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1929:1: (lv_new_val_6_0= ruleTypeAndValue )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1929:1: (lv_new_val_6_0= ruleTypeAndValue )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1930:3: lv_new_val_6_0= ruleTypeAndValue
            {
             
            	        newCompositeNode(grammarAccess.getCmpXchgAccess().getNew_valTypeAndValueParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_ruleTypeAndValue_in_ruleCmpXchg4437);
            lv_new_val_6_0=ruleTypeAndValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCmpXchgRule());
            	        }
                   		set(
                   			current, 
                   			"new_val",
                    		lv_new_val_6_0, 
                    		"TypeAndValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1946:2: (otherlv_7= 'singlethread' )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==53) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1946:4: otherlv_7= 'singlethread'
                    {
                    otherlv_7=(Token)match(input,53,FOLLOW_53_in_ruleCmpXchg4450); 

                        	newLeafNode(otherlv_7, grammarAccess.getCmpXchgAccess().getSinglethreadKeyword_7());
                        

                    }
                    break;

            }

            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1950:3: ( (lv_ordering_8_0= ruleATOMIC_ORDERING ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1951:1: (lv_ordering_8_0= ruleATOMIC_ORDERING )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1951:1: (lv_ordering_8_0= ruleATOMIC_ORDERING )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1952:3: lv_ordering_8_0= ruleATOMIC_ORDERING
            {
             
            	        newCompositeNode(grammarAccess.getCmpXchgAccess().getOrderingATOMIC_ORDERINGParserRuleCall_8_0()); 
            	    
            pushFollow(FOLLOW_ruleATOMIC_ORDERING_in_ruleCmpXchg4473);
            lv_ordering_8_0=ruleATOMIC_ORDERING();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCmpXchgRule());
            	        }
                   		set(
                   			current, 
                   			"ordering",
                    		lv_ordering_8_0, 
                    		"ATOMIC_ORDERING");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCmpXchg"


    // $ANTLR start "entryRuleAtomicRMW"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1976:1: entryRuleAtomicRMW returns [EObject current=null] : iv_ruleAtomicRMW= ruleAtomicRMW EOF ;
    public final EObject entryRuleAtomicRMW() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicRMW = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1977:2: (iv_ruleAtomicRMW= ruleAtomicRMW EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1978:2: iv_ruleAtomicRMW= ruleAtomicRMW EOF
            {
             newCompositeNode(grammarAccess.getAtomicRMWRule()); 
            pushFollow(FOLLOW_ruleAtomicRMW_in_entryRuleAtomicRMW4509);
            iv_ruleAtomicRMW=ruleAtomicRMW();

            state._fsp--;

             current =iv_ruleAtomicRMW; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAtomicRMW4519); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAtomicRMW"


    // $ANTLR start "ruleAtomicRMW"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1985:1: ruleAtomicRMW returns [EObject current=null] : (otherlv_0= 'atomicrmw' (otherlv_1= 'volatile' )? ruleBIN_OP ( (lv_adress_3_0= ruleTypeAndValue ) ) otherlv_4= ',' ( (lv_value_5_0= ruleTypeAndValue ) ) (otherlv_6= 'singlethread' )? ( (lv_ordering_7_0= ruleATOMIC_ORDERING ) ) ) ;
    public final EObject ruleAtomicRMW() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_adress_3_0 = null;

        EObject lv_value_5_0 = null;

        AntlrDatatypeRuleToken lv_ordering_7_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1988:28: ( (otherlv_0= 'atomicrmw' (otherlv_1= 'volatile' )? ruleBIN_OP ( (lv_adress_3_0= ruleTypeAndValue ) ) otherlv_4= ',' ( (lv_value_5_0= ruleTypeAndValue ) ) (otherlv_6= 'singlethread' )? ( (lv_ordering_7_0= ruleATOMIC_ORDERING ) ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1989:1: (otherlv_0= 'atomicrmw' (otherlv_1= 'volatile' )? ruleBIN_OP ( (lv_adress_3_0= ruleTypeAndValue ) ) otherlv_4= ',' ( (lv_value_5_0= ruleTypeAndValue ) ) (otherlv_6= 'singlethread' )? ( (lv_ordering_7_0= ruleATOMIC_ORDERING ) ) )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1989:1: (otherlv_0= 'atomicrmw' (otherlv_1= 'volatile' )? ruleBIN_OP ( (lv_adress_3_0= ruleTypeAndValue ) ) otherlv_4= ',' ( (lv_value_5_0= ruleTypeAndValue ) ) (otherlv_6= 'singlethread' )? ( (lv_ordering_7_0= ruleATOMIC_ORDERING ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1989:3: otherlv_0= 'atomicrmw' (otherlv_1= 'volatile' )? ruleBIN_OP ( (lv_adress_3_0= ruleTypeAndValue ) ) otherlv_4= ',' ( (lv_value_5_0= ruleTypeAndValue ) ) (otherlv_6= 'singlethread' )? ( (lv_ordering_7_0= ruleATOMIC_ORDERING ) )
            {
            otherlv_0=(Token)match(input,62,FOLLOW_62_in_ruleAtomicRMW4556); 

                	newLeafNode(otherlv_0, grammarAccess.getAtomicRMWAccess().getAtomicrmwKeyword_0());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1993:1: (otherlv_1= 'volatile' )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==61) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:1993:3: otherlv_1= 'volatile'
                    {
                    otherlv_1=(Token)match(input,61,FOLLOW_61_in_ruleAtomicRMW4569); 

                        	newLeafNode(otherlv_1, grammarAccess.getAtomicRMWAccess().getVolatileKeyword_1());
                        

                    }
                    break;

            }

             
                    newCompositeNode(grammarAccess.getAtomicRMWAccess().getBIN_OPParserRuleCall_2()); 
                
            pushFollow(FOLLOW_ruleBIN_OP_in_ruleAtomicRMW4587);
            ruleBIN_OP();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2005:1: ( (lv_adress_3_0= ruleTypeAndValue ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2006:1: (lv_adress_3_0= ruleTypeAndValue )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2006:1: (lv_adress_3_0= ruleTypeAndValue )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2007:3: lv_adress_3_0= ruleTypeAndValue
            {
             
            	        newCompositeNode(grammarAccess.getAtomicRMWAccess().getAdressTypeAndValueParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleTypeAndValue_in_ruleAtomicRMW4607);
            lv_adress_3_0=ruleTypeAndValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAtomicRMWRule());
            	        }
                   		set(
                   			current, 
                   			"adress",
                    		lv_adress_3_0, 
                    		"TypeAndValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,23,FOLLOW_23_in_ruleAtomicRMW4619); 

                	newLeafNode(otherlv_4, grammarAccess.getAtomicRMWAccess().getCommaKeyword_4());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2027:1: ( (lv_value_5_0= ruleTypeAndValue ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2028:1: (lv_value_5_0= ruleTypeAndValue )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2028:1: (lv_value_5_0= ruleTypeAndValue )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2029:3: lv_value_5_0= ruleTypeAndValue
            {
             
            	        newCompositeNode(grammarAccess.getAtomicRMWAccess().getValueTypeAndValueParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleTypeAndValue_in_ruleAtomicRMW4640);
            lv_value_5_0=ruleTypeAndValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAtomicRMWRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_5_0, 
                    		"TypeAndValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2045:2: (otherlv_6= 'singlethread' )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==53) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2045:4: otherlv_6= 'singlethread'
                    {
                    otherlv_6=(Token)match(input,53,FOLLOW_53_in_ruleAtomicRMW4653); 

                        	newLeafNode(otherlv_6, grammarAccess.getAtomicRMWAccess().getSinglethreadKeyword_6());
                        

                    }
                    break;

            }

            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2049:3: ( (lv_ordering_7_0= ruleATOMIC_ORDERING ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2050:1: (lv_ordering_7_0= ruleATOMIC_ORDERING )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2050:1: (lv_ordering_7_0= ruleATOMIC_ORDERING )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2051:3: lv_ordering_7_0= ruleATOMIC_ORDERING
            {
             
            	        newCompositeNode(grammarAccess.getAtomicRMWAccess().getOrderingATOMIC_ORDERINGParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_ruleATOMIC_ORDERING_in_ruleAtomicRMW4676);
            lv_ordering_7_0=ruleATOMIC_ORDERING();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAtomicRMWRule());
            	        }
                   		set(
                   			current, 
                   			"ordering",
                    		lv_ordering_7_0, 
                    		"ATOMIC_ORDERING");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAtomicRMW"


    // $ANTLR start "entryRuleBIN_OP"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2075:1: entryRuleBIN_OP returns [String current=null] : iv_ruleBIN_OP= ruleBIN_OP EOF ;
    public final String entryRuleBIN_OP() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBIN_OP = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2076:2: (iv_ruleBIN_OP= ruleBIN_OP EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2077:2: iv_ruleBIN_OP= ruleBIN_OP EOF
            {
             newCompositeNode(grammarAccess.getBIN_OPRule()); 
            pushFollow(FOLLOW_ruleBIN_OP_in_entryRuleBIN_OP4713);
            iv_ruleBIN_OP=ruleBIN_OP();

            state._fsp--;

             current =iv_ruleBIN_OP.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBIN_OP4724); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBIN_OP"


    // $ANTLR start "ruleBIN_OP"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2084:1: ruleBIN_OP returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'xchg' | kw= 'add' | kw= 'sub' | kw= 'and' | kw= 'nand' | kw= 'or' | kw= 'xor' | kw= 'max' | kw= 'min' | kw= 'umax' | kw= 'umin' ) ;
    public final AntlrDatatypeRuleToken ruleBIN_OP() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2087:28: ( (kw= 'xchg' | kw= 'add' | kw= 'sub' | kw= 'and' | kw= 'nand' | kw= 'or' | kw= 'xor' | kw= 'max' | kw= 'min' | kw= 'umax' | kw= 'umin' ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2088:1: (kw= 'xchg' | kw= 'add' | kw= 'sub' | kw= 'and' | kw= 'nand' | kw= 'or' | kw= 'xor' | kw= 'max' | kw= 'min' | kw= 'umax' | kw= 'umin' )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2088:1: (kw= 'xchg' | kw= 'add' | kw= 'sub' | kw= 'and' | kw= 'nand' | kw= 'or' | kw= 'xor' | kw= 'max' | kw= 'min' | kw= 'umax' | kw= 'umin' )
            int alt57=11;
            switch ( input.LA(1) ) {
            case 63:
                {
                alt57=1;
                }
                break;
            case 64:
                {
                alt57=2;
                }
                break;
            case 65:
                {
                alt57=3;
                }
                break;
            case 66:
                {
                alt57=4;
                }
                break;
            case 67:
                {
                alt57=5;
                }
                break;
            case 68:
                {
                alt57=6;
                }
                break;
            case 69:
                {
                alt57=7;
                }
                break;
            case 70:
                {
                alt57=8;
                }
                break;
            case 71:
                {
                alt57=9;
                }
                break;
            case 72:
                {
                alt57=10;
                }
                break;
            case 73:
                {
                alt57=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }

            switch (alt57) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2089:2: kw= 'xchg'
                    {
                    kw=(Token)match(input,63,FOLLOW_63_in_ruleBIN_OP4762); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBIN_OPAccess().getXchgKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2096:2: kw= 'add'
                    {
                    kw=(Token)match(input,64,FOLLOW_64_in_ruleBIN_OP4781); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBIN_OPAccess().getAddKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2103:2: kw= 'sub'
                    {
                    kw=(Token)match(input,65,FOLLOW_65_in_ruleBIN_OP4800); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBIN_OPAccess().getSubKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2110:2: kw= 'and'
                    {
                    kw=(Token)match(input,66,FOLLOW_66_in_ruleBIN_OP4819); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBIN_OPAccess().getAndKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2117:2: kw= 'nand'
                    {
                    kw=(Token)match(input,67,FOLLOW_67_in_ruleBIN_OP4838); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBIN_OPAccess().getNandKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2124:2: kw= 'or'
                    {
                    kw=(Token)match(input,68,FOLLOW_68_in_ruleBIN_OP4857); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBIN_OPAccess().getOrKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2131:2: kw= 'xor'
                    {
                    kw=(Token)match(input,69,FOLLOW_69_in_ruleBIN_OP4876); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBIN_OPAccess().getXorKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2138:2: kw= 'max'
                    {
                    kw=(Token)match(input,70,FOLLOW_70_in_ruleBIN_OP4895); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBIN_OPAccess().getMaxKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2145:2: kw= 'min'
                    {
                    kw=(Token)match(input,71,FOLLOW_71_in_ruleBIN_OP4914); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBIN_OPAccess().getMinKeyword_8()); 
                        

                    }
                    break;
                case 10 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2152:2: kw= 'umax'
                    {
                    kw=(Token)match(input,72,FOLLOW_72_in_ruleBIN_OP4933); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBIN_OPAccess().getUmaxKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2159:2: kw= 'umin'
                    {
                    kw=(Token)match(input,73,FOLLOW_73_in_ruleBIN_OP4952); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBIN_OPAccess().getUminKeyword_10()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBIN_OP"


    // $ANTLR start "entryRuleLoad"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2172:1: entryRuleLoad returns [EObject current=null] : iv_ruleLoad= ruleLoad EOF ;
    public final EObject entryRuleLoad() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoad = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2173:2: (iv_ruleLoad= ruleLoad EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2174:2: iv_ruleLoad= ruleLoad EOF
            {
             newCompositeNode(grammarAccess.getLoadRule()); 
            pushFollow(FOLLOW_ruleLoad_in_entryRuleLoad4992);
            iv_ruleLoad=ruleLoad();

            state._fsp--;

             current =iv_ruleLoad; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLoad5002); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLoad"


    // $ANTLR start "ruleLoad"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2181:1: ruleLoad returns [EObject current=null] : ( (otherlv_0= 'load' (otherlv_1= 'volatile' )? ( (lv_adress_2_0= ruleTypeAndValue ) ) (otherlv_3= ',' ( (lv_align_4_0= ruleALIGNMENT ) ) )? (otherlv_5= ',' otherlv_6= '!nontemporal' otherlv_7= '!' ( (lv_index_8_0= RULE_INT ) ) )? ) | (otherlv_9= 'load' otherlv_10= 'atomic' (otherlv_11= 'volatile' )? ( (lv_adress_12_0= ruleTypeAndValue ) ) (otherlv_13= 'singlethread' )? ( (lv_ordering_14_0= ruleATOMIC_ORDERING ) ) (otherlv_15= ',' otherlv_16= 'align' ( (lv_index_17_0= RULE_INT ) ) )? ) ) ;
    public final EObject ruleLoad() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_index_8_0=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token lv_index_17_0=null;
        EObject lv_adress_2_0 = null;

        AntlrDatatypeRuleToken lv_align_4_0 = null;

        EObject lv_adress_12_0 = null;

        AntlrDatatypeRuleToken lv_ordering_14_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2184:28: ( ( (otherlv_0= 'load' (otherlv_1= 'volatile' )? ( (lv_adress_2_0= ruleTypeAndValue ) ) (otherlv_3= ',' ( (lv_align_4_0= ruleALIGNMENT ) ) )? (otherlv_5= ',' otherlv_6= '!nontemporal' otherlv_7= '!' ( (lv_index_8_0= RULE_INT ) ) )? ) | (otherlv_9= 'load' otherlv_10= 'atomic' (otherlv_11= 'volatile' )? ( (lv_adress_12_0= ruleTypeAndValue ) ) (otherlv_13= 'singlethread' )? ( (lv_ordering_14_0= ruleATOMIC_ORDERING ) ) (otherlv_15= ',' otherlv_16= 'align' ( (lv_index_17_0= RULE_INT ) ) )? ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2185:1: ( (otherlv_0= 'load' (otherlv_1= 'volatile' )? ( (lv_adress_2_0= ruleTypeAndValue ) ) (otherlv_3= ',' ( (lv_align_4_0= ruleALIGNMENT ) ) )? (otherlv_5= ',' otherlv_6= '!nontemporal' otherlv_7= '!' ( (lv_index_8_0= RULE_INT ) ) )? ) | (otherlv_9= 'load' otherlv_10= 'atomic' (otherlv_11= 'volatile' )? ( (lv_adress_12_0= ruleTypeAndValue ) ) (otherlv_13= 'singlethread' )? ( (lv_ordering_14_0= ruleATOMIC_ORDERING ) ) (otherlv_15= ',' otherlv_16= 'align' ( (lv_index_17_0= RULE_INT ) ) )? ) )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2185:1: ( (otherlv_0= 'load' (otherlv_1= 'volatile' )? ( (lv_adress_2_0= ruleTypeAndValue ) ) (otherlv_3= ',' ( (lv_align_4_0= ruleALIGNMENT ) ) )? (otherlv_5= ',' otherlv_6= '!nontemporal' otherlv_7= '!' ( (lv_index_8_0= RULE_INT ) ) )? ) | (otherlv_9= 'load' otherlv_10= 'atomic' (otherlv_11= 'volatile' )? ( (lv_adress_12_0= ruleTypeAndValue ) ) (otherlv_13= 'singlethread' )? ( (lv_ordering_14_0= ruleATOMIC_ORDERING ) ) (otherlv_15= ',' otherlv_16= 'align' ( (lv_index_17_0= RULE_INT ) ) )? ) )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==74) ) {
                int LA64_1 = input.LA(2);

                if ( ((LA64_1>=RULE_VAR_TYPE && LA64_1<=RULE_INT)||LA64_1==32||(LA64_1>=38 && LA64_1<=47)||LA64_1==61) ) {
                    alt64=1;
                }
                else if ( (LA64_1==77) ) {
                    alt64=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 64, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2185:2: (otherlv_0= 'load' (otherlv_1= 'volatile' )? ( (lv_adress_2_0= ruleTypeAndValue ) ) (otherlv_3= ',' ( (lv_align_4_0= ruleALIGNMENT ) ) )? (otherlv_5= ',' otherlv_6= '!nontemporal' otherlv_7= '!' ( (lv_index_8_0= RULE_INT ) ) )? )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2185:2: (otherlv_0= 'load' (otherlv_1= 'volatile' )? ( (lv_adress_2_0= ruleTypeAndValue ) ) (otherlv_3= ',' ( (lv_align_4_0= ruleALIGNMENT ) ) )? (otherlv_5= ',' otherlv_6= '!nontemporal' otherlv_7= '!' ( (lv_index_8_0= RULE_INT ) ) )? )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2185:4: otherlv_0= 'load' (otherlv_1= 'volatile' )? ( (lv_adress_2_0= ruleTypeAndValue ) ) (otherlv_3= ',' ( (lv_align_4_0= ruleALIGNMENT ) ) )? (otherlv_5= ',' otherlv_6= '!nontemporal' otherlv_7= '!' ( (lv_index_8_0= RULE_INT ) ) )?
                    {
                    otherlv_0=(Token)match(input,74,FOLLOW_74_in_ruleLoad5040); 

                        	newLeafNode(otherlv_0, grammarAccess.getLoadAccess().getLoadKeyword_0_0());
                        
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2189:1: (otherlv_1= 'volatile' )?
                    int alt58=2;
                    int LA58_0 = input.LA(1);

                    if ( (LA58_0==61) ) {
                        alt58=1;
                    }
                    switch (alt58) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2189:3: otherlv_1= 'volatile'
                            {
                            otherlv_1=(Token)match(input,61,FOLLOW_61_in_ruleLoad5053); 

                                	newLeafNode(otherlv_1, grammarAccess.getLoadAccess().getVolatileKeyword_0_1());
                                

                            }
                            break;

                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2193:3: ( (lv_adress_2_0= ruleTypeAndValue ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2194:1: (lv_adress_2_0= ruleTypeAndValue )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2194:1: (lv_adress_2_0= ruleTypeAndValue )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2195:3: lv_adress_2_0= ruleTypeAndValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getLoadAccess().getAdressTypeAndValueParserRuleCall_0_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTypeAndValue_in_ruleLoad5076);
                    lv_adress_2_0=ruleTypeAndValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLoadRule());
                    	        }
                           		set(
                           			current, 
                           			"adress",
                            		lv_adress_2_0, 
                            		"TypeAndValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2211:2: (otherlv_3= ',' ( (lv_align_4_0= ruleALIGNMENT ) ) )?
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==23) ) {
                        int LA59_1 = input.LA(2);

                        if ( (LA59_1==78) ) {
                            alt59=1;
                        }
                    }
                    switch (alt59) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2211:4: otherlv_3= ',' ( (lv_align_4_0= ruleALIGNMENT ) )
                            {
                            otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleLoad5089); 

                                	newLeafNode(otherlv_3, grammarAccess.getLoadAccess().getCommaKeyword_0_3_0());
                                
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2215:1: ( (lv_align_4_0= ruleALIGNMENT ) )
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2216:1: (lv_align_4_0= ruleALIGNMENT )
                            {
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2216:1: (lv_align_4_0= ruleALIGNMENT )
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2217:3: lv_align_4_0= ruleALIGNMENT
                            {
                             
                            	        newCompositeNode(grammarAccess.getLoadAccess().getAlignALIGNMENTParserRuleCall_0_3_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleALIGNMENT_in_ruleLoad5110);
                            lv_align_4_0=ruleALIGNMENT();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getLoadRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"align",
                                    		lv_align_4_0, 
                                    		"ALIGNMENT");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2233:4: (otherlv_5= ',' otherlv_6= '!nontemporal' otherlv_7= '!' ( (lv_index_8_0= RULE_INT ) ) )?
                    int alt60=2;
                    int LA60_0 = input.LA(1);

                    if ( (LA60_0==23) ) {
                        alt60=1;
                    }
                    switch (alt60) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2233:6: otherlv_5= ',' otherlv_6= '!nontemporal' otherlv_7= '!' ( (lv_index_8_0= RULE_INT ) )
                            {
                            otherlv_5=(Token)match(input,23,FOLLOW_23_in_ruleLoad5125); 

                                	newLeafNode(otherlv_5, grammarAccess.getLoadAccess().getCommaKeyword_0_4_0());
                                
                            otherlv_6=(Token)match(input,75,FOLLOW_75_in_ruleLoad5137); 

                                	newLeafNode(otherlv_6, grammarAccess.getLoadAccess().getNontemporalKeyword_0_4_1());
                                
                            otherlv_7=(Token)match(input,76,FOLLOW_76_in_ruleLoad5149); 

                                	newLeafNode(otherlv_7, grammarAccess.getLoadAccess().getExclamationMarkKeyword_0_4_2());
                                
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2245:1: ( (lv_index_8_0= RULE_INT ) )
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2246:1: (lv_index_8_0= RULE_INT )
                            {
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2246:1: (lv_index_8_0= RULE_INT )
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2247:3: lv_index_8_0= RULE_INT
                            {
                            lv_index_8_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleLoad5166); 

                            			newLeafNode(lv_index_8_0, grammarAccess.getLoadAccess().getIndexINTTerminalRuleCall_0_4_3_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getLoadRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"index",
                                    		lv_index_8_0, 
                                    		"INT");
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2264:6: (otherlv_9= 'load' otherlv_10= 'atomic' (otherlv_11= 'volatile' )? ( (lv_adress_12_0= ruleTypeAndValue ) ) (otherlv_13= 'singlethread' )? ( (lv_ordering_14_0= ruleATOMIC_ORDERING ) ) (otherlv_15= ',' otherlv_16= 'align' ( (lv_index_17_0= RULE_INT ) ) )? )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2264:6: (otherlv_9= 'load' otherlv_10= 'atomic' (otherlv_11= 'volatile' )? ( (lv_adress_12_0= ruleTypeAndValue ) ) (otherlv_13= 'singlethread' )? ( (lv_ordering_14_0= ruleATOMIC_ORDERING ) ) (otherlv_15= ',' otherlv_16= 'align' ( (lv_index_17_0= RULE_INT ) ) )? )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2264:8: otherlv_9= 'load' otherlv_10= 'atomic' (otherlv_11= 'volatile' )? ( (lv_adress_12_0= ruleTypeAndValue ) ) (otherlv_13= 'singlethread' )? ( (lv_ordering_14_0= ruleATOMIC_ORDERING ) ) (otherlv_15= ',' otherlv_16= 'align' ( (lv_index_17_0= RULE_INT ) ) )?
                    {
                    otherlv_9=(Token)match(input,74,FOLLOW_74_in_ruleLoad5193); 

                        	newLeafNode(otherlv_9, grammarAccess.getLoadAccess().getLoadKeyword_1_0());
                        
                    otherlv_10=(Token)match(input,77,FOLLOW_77_in_ruleLoad5205); 

                        	newLeafNode(otherlv_10, grammarAccess.getLoadAccess().getAtomicKeyword_1_1());
                        
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2272:1: (otherlv_11= 'volatile' )?
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( (LA61_0==61) ) {
                        alt61=1;
                    }
                    switch (alt61) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2272:3: otherlv_11= 'volatile'
                            {
                            otherlv_11=(Token)match(input,61,FOLLOW_61_in_ruleLoad5218); 

                                	newLeafNode(otherlv_11, grammarAccess.getLoadAccess().getVolatileKeyword_1_2());
                                

                            }
                            break;

                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2276:3: ( (lv_adress_12_0= ruleTypeAndValue ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2277:1: (lv_adress_12_0= ruleTypeAndValue )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2277:1: (lv_adress_12_0= ruleTypeAndValue )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2278:3: lv_adress_12_0= ruleTypeAndValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getLoadAccess().getAdressTypeAndValueParserRuleCall_1_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTypeAndValue_in_ruleLoad5241);
                    lv_adress_12_0=ruleTypeAndValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLoadRule());
                    	        }
                           		set(
                           			current, 
                           			"adress",
                            		lv_adress_12_0, 
                            		"TypeAndValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2294:2: (otherlv_13= 'singlethread' )?
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==53) ) {
                        alt62=1;
                    }
                    switch (alt62) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2294:4: otherlv_13= 'singlethread'
                            {
                            otherlv_13=(Token)match(input,53,FOLLOW_53_in_ruleLoad5254); 

                                	newLeafNode(otherlv_13, grammarAccess.getLoadAccess().getSinglethreadKeyword_1_4());
                                

                            }
                            break;

                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2298:3: ( (lv_ordering_14_0= ruleATOMIC_ORDERING ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2299:1: (lv_ordering_14_0= ruleATOMIC_ORDERING )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2299:1: (lv_ordering_14_0= ruleATOMIC_ORDERING )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2300:3: lv_ordering_14_0= ruleATOMIC_ORDERING
                    {
                     
                    	        newCompositeNode(grammarAccess.getLoadAccess().getOrderingATOMIC_ORDERINGParserRuleCall_1_5_0()); 
                    	    
                    pushFollow(FOLLOW_ruleATOMIC_ORDERING_in_ruleLoad5277);
                    lv_ordering_14_0=ruleATOMIC_ORDERING();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLoadRule());
                    	        }
                           		set(
                           			current, 
                           			"ordering",
                            		lv_ordering_14_0, 
                            		"ATOMIC_ORDERING");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2316:2: (otherlv_15= ',' otherlv_16= 'align' ( (lv_index_17_0= RULE_INT ) ) )?
                    int alt63=2;
                    int LA63_0 = input.LA(1);

                    if ( (LA63_0==23) ) {
                        alt63=1;
                    }
                    switch (alt63) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2316:4: otherlv_15= ',' otherlv_16= 'align' ( (lv_index_17_0= RULE_INT ) )
                            {
                            otherlv_15=(Token)match(input,23,FOLLOW_23_in_ruleLoad5290); 

                                	newLeafNode(otherlv_15, grammarAccess.getLoadAccess().getCommaKeyword_1_6_0());
                                
                            otherlv_16=(Token)match(input,78,FOLLOW_78_in_ruleLoad5302); 

                                	newLeafNode(otherlv_16, grammarAccess.getLoadAccess().getAlignKeyword_1_6_1());
                                
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2324:1: ( (lv_index_17_0= RULE_INT ) )
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2325:1: (lv_index_17_0= RULE_INT )
                            {
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2325:1: (lv_index_17_0= RULE_INT )
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2326:3: lv_index_17_0= RULE_INT
                            {
                            lv_index_17_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleLoad5319); 

                            			newLeafNode(lv_index_17_0, grammarAccess.getLoadAccess().getIndexINTTerminalRuleCall_1_6_2_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getLoadRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"index",
                                    		lv_index_17_0, 
                                    		"INT");
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLoad"


    // $ANTLR start "entryRuleStore"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2350:1: entryRuleStore returns [EObject current=null] : iv_ruleStore= ruleStore EOF ;
    public final EObject entryRuleStore() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStore = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2351:2: (iv_ruleStore= ruleStore EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2352:2: iv_ruleStore= ruleStore EOF
            {
             newCompositeNode(grammarAccess.getStoreRule()); 
            pushFollow(FOLLOW_ruleStore_in_entryRuleStore5363);
            iv_ruleStore=ruleStore();

            state._fsp--;

             current =iv_ruleStore; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStore5373); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStore"


    // $ANTLR start "ruleStore"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2359:1: ruleStore returns [EObject current=null] : ( (otherlv_0= 'store' (otherlv_1= 'volatile' )? ( (lv_value_2_0= ruleTypeAndValue ) ) otherlv_3= ',' ( (lv_adress_4_0= ruleTypeAndValue ) ) (otherlv_5= ',' otherlv_6= 'align' this_INT_7= RULE_INT )? ) | (otherlv_8= 'store' otherlv_9= 'atomic' (otherlv_10= 'volatile' )? ( (lv_value_11_0= ruleTypeAndValue ) ) otherlv_12= ',' ( (lv_adress_13_0= ruleTypeAndValue ) ) (otherlv_14= 'singlethread' )? ( (lv_ordering_15_0= ruleATOMIC_ORDERING ) ) (otherlv_16= ',' otherlv_17= 'align' ( (lv_index_18_0= RULE_INT ) ) )? ) ) ;
    public final EObject ruleStore() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token this_INT_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token lv_index_18_0=null;
        EObject lv_value_2_0 = null;

        EObject lv_adress_4_0 = null;

        EObject lv_value_11_0 = null;

        EObject lv_adress_13_0 = null;

        AntlrDatatypeRuleToken lv_ordering_15_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2362:28: ( ( (otherlv_0= 'store' (otherlv_1= 'volatile' )? ( (lv_value_2_0= ruleTypeAndValue ) ) otherlv_3= ',' ( (lv_adress_4_0= ruleTypeAndValue ) ) (otherlv_5= ',' otherlv_6= 'align' this_INT_7= RULE_INT )? ) | (otherlv_8= 'store' otherlv_9= 'atomic' (otherlv_10= 'volatile' )? ( (lv_value_11_0= ruleTypeAndValue ) ) otherlv_12= ',' ( (lv_adress_13_0= ruleTypeAndValue ) ) (otherlv_14= 'singlethread' )? ( (lv_ordering_15_0= ruleATOMIC_ORDERING ) ) (otherlv_16= ',' otherlv_17= 'align' ( (lv_index_18_0= RULE_INT ) ) )? ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2363:1: ( (otherlv_0= 'store' (otherlv_1= 'volatile' )? ( (lv_value_2_0= ruleTypeAndValue ) ) otherlv_3= ',' ( (lv_adress_4_0= ruleTypeAndValue ) ) (otherlv_5= ',' otherlv_6= 'align' this_INT_7= RULE_INT )? ) | (otherlv_8= 'store' otherlv_9= 'atomic' (otherlv_10= 'volatile' )? ( (lv_value_11_0= ruleTypeAndValue ) ) otherlv_12= ',' ( (lv_adress_13_0= ruleTypeAndValue ) ) (otherlv_14= 'singlethread' )? ( (lv_ordering_15_0= ruleATOMIC_ORDERING ) ) (otherlv_16= ',' otherlv_17= 'align' ( (lv_index_18_0= RULE_INT ) ) )? ) )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2363:1: ( (otherlv_0= 'store' (otherlv_1= 'volatile' )? ( (lv_value_2_0= ruleTypeAndValue ) ) otherlv_3= ',' ( (lv_adress_4_0= ruleTypeAndValue ) ) (otherlv_5= ',' otherlv_6= 'align' this_INT_7= RULE_INT )? ) | (otherlv_8= 'store' otherlv_9= 'atomic' (otherlv_10= 'volatile' )? ( (lv_value_11_0= ruleTypeAndValue ) ) otherlv_12= ',' ( (lv_adress_13_0= ruleTypeAndValue ) ) (otherlv_14= 'singlethread' )? ( (lv_ordering_15_0= ruleATOMIC_ORDERING ) ) (otherlv_16= ',' otherlv_17= 'align' ( (lv_index_18_0= RULE_INT ) ) )? ) )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==79) ) {
                int LA70_1 = input.LA(2);

                if ( ((LA70_1>=RULE_VAR_TYPE && LA70_1<=RULE_INT)||LA70_1==32||(LA70_1>=38 && LA70_1<=47)||LA70_1==61) ) {
                    alt70=1;
                }
                else if ( (LA70_1==77) ) {
                    alt70=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 70, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2363:2: (otherlv_0= 'store' (otherlv_1= 'volatile' )? ( (lv_value_2_0= ruleTypeAndValue ) ) otherlv_3= ',' ( (lv_adress_4_0= ruleTypeAndValue ) ) (otherlv_5= ',' otherlv_6= 'align' this_INT_7= RULE_INT )? )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2363:2: (otherlv_0= 'store' (otherlv_1= 'volatile' )? ( (lv_value_2_0= ruleTypeAndValue ) ) otherlv_3= ',' ( (lv_adress_4_0= ruleTypeAndValue ) ) (otherlv_5= ',' otherlv_6= 'align' this_INT_7= RULE_INT )? )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2363:4: otherlv_0= 'store' (otherlv_1= 'volatile' )? ( (lv_value_2_0= ruleTypeAndValue ) ) otherlv_3= ',' ( (lv_adress_4_0= ruleTypeAndValue ) ) (otherlv_5= ',' otherlv_6= 'align' this_INT_7= RULE_INT )?
                    {
                    otherlv_0=(Token)match(input,79,FOLLOW_79_in_ruleStore5411); 

                        	newLeafNode(otherlv_0, grammarAccess.getStoreAccess().getStoreKeyword_0_0());
                        
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2367:1: (otherlv_1= 'volatile' )?
                    int alt65=2;
                    int LA65_0 = input.LA(1);

                    if ( (LA65_0==61) ) {
                        alt65=1;
                    }
                    switch (alt65) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2367:3: otherlv_1= 'volatile'
                            {
                            otherlv_1=(Token)match(input,61,FOLLOW_61_in_ruleStore5424); 

                                	newLeafNode(otherlv_1, grammarAccess.getStoreAccess().getVolatileKeyword_0_1());
                                

                            }
                            break;

                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2371:3: ( (lv_value_2_0= ruleTypeAndValue ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2372:1: (lv_value_2_0= ruleTypeAndValue )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2372:1: (lv_value_2_0= ruleTypeAndValue )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2373:3: lv_value_2_0= ruleTypeAndValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getStoreAccess().getValueTypeAndValueParserRuleCall_0_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTypeAndValue_in_ruleStore5447);
                    lv_value_2_0=ruleTypeAndValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getStoreRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_2_0, 
                            		"TypeAndValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleStore5459); 

                        	newLeafNode(otherlv_3, grammarAccess.getStoreAccess().getCommaKeyword_0_3());
                        
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2393:1: ( (lv_adress_4_0= ruleTypeAndValue ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2394:1: (lv_adress_4_0= ruleTypeAndValue )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2394:1: (lv_adress_4_0= ruleTypeAndValue )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2395:3: lv_adress_4_0= ruleTypeAndValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getStoreAccess().getAdressTypeAndValueParserRuleCall_0_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTypeAndValue_in_ruleStore5480);
                    lv_adress_4_0=ruleTypeAndValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getStoreRule());
                    	        }
                           		set(
                           			current, 
                           			"adress",
                            		lv_adress_4_0, 
                            		"TypeAndValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2411:2: (otherlv_5= ',' otherlv_6= 'align' this_INT_7= RULE_INT )?
                    int alt66=2;
                    int LA66_0 = input.LA(1);

                    if ( (LA66_0==23) ) {
                        alt66=1;
                    }
                    switch (alt66) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2411:4: otherlv_5= ',' otherlv_6= 'align' this_INT_7= RULE_INT
                            {
                            otherlv_5=(Token)match(input,23,FOLLOW_23_in_ruleStore5493); 

                                	newLeafNode(otherlv_5, grammarAccess.getStoreAccess().getCommaKeyword_0_5_0());
                                
                            otherlv_6=(Token)match(input,78,FOLLOW_78_in_ruleStore5505); 

                                	newLeafNode(otherlv_6, grammarAccess.getStoreAccess().getAlignKeyword_0_5_1());
                                
                            this_INT_7=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleStore5516); 
                             
                                newLeafNode(this_INT_7, grammarAccess.getStoreAccess().getINTTerminalRuleCall_0_5_2()); 
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2424:6: (otherlv_8= 'store' otherlv_9= 'atomic' (otherlv_10= 'volatile' )? ( (lv_value_11_0= ruleTypeAndValue ) ) otherlv_12= ',' ( (lv_adress_13_0= ruleTypeAndValue ) ) (otherlv_14= 'singlethread' )? ( (lv_ordering_15_0= ruleATOMIC_ORDERING ) ) (otherlv_16= ',' otherlv_17= 'align' ( (lv_index_18_0= RULE_INT ) ) )? )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2424:6: (otherlv_8= 'store' otherlv_9= 'atomic' (otherlv_10= 'volatile' )? ( (lv_value_11_0= ruleTypeAndValue ) ) otherlv_12= ',' ( (lv_adress_13_0= ruleTypeAndValue ) ) (otherlv_14= 'singlethread' )? ( (lv_ordering_15_0= ruleATOMIC_ORDERING ) ) (otherlv_16= ',' otherlv_17= 'align' ( (lv_index_18_0= RULE_INT ) ) )? )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2424:8: otherlv_8= 'store' otherlv_9= 'atomic' (otherlv_10= 'volatile' )? ( (lv_value_11_0= ruleTypeAndValue ) ) otherlv_12= ',' ( (lv_adress_13_0= ruleTypeAndValue ) ) (otherlv_14= 'singlethread' )? ( (lv_ordering_15_0= ruleATOMIC_ORDERING ) ) (otherlv_16= ',' otherlv_17= 'align' ( (lv_index_18_0= RULE_INT ) ) )?
                    {
                    otherlv_8=(Token)match(input,79,FOLLOW_79_in_ruleStore5537); 

                        	newLeafNode(otherlv_8, grammarAccess.getStoreAccess().getStoreKeyword_1_0());
                        
                    otherlv_9=(Token)match(input,77,FOLLOW_77_in_ruleStore5549); 

                        	newLeafNode(otherlv_9, grammarAccess.getStoreAccess().getAtomicKeyword_1_1());
                        
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2432:1: (otherlv_10= 'volatile' )?
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( (LA67_0==61) ) {
                        alt67=1;
                    }
                    switch (alt67) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2432:3: otherlv_10= 'volatile'
                            {
                            otherlv_10=(Token)match(input,61,FOLLOW_61_in_ruleStore5562); 

                                	newLeafNode(otherlv_10, grammarAccess.getStoreAccess().getVolatileKeyword_1_2());
                                

                            }
                            break;

                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2436:3: ( (lv_value_11_0= ruleTypeAndValue ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2437:1: (lv_value_11_0= ruleTypeAndValue )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2437:1: (lv_value_11_0= ruleTypeAndValue )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2438:3: lv_value_11_0= ruleTypeAndValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getStoreAccess().getValueTypeAndValueParserRuleCall_1_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTypeAndValue_in_ruleStore5585);
                    lv_value_11_0=ruleTypeAndValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getStoreRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_11_0, 
                            		"TypeAndValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_12=(Token)match(input,23,FOLLOW_23_in_ruleStore5597); 

                        	newLeafNode(otherlv_12, grammarAccess.getStoreAccess().getCommaKeyword_1_4());
                        
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2458:1: ( (lv_adress_13_0= ruleTypeAndValue ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2459:1: (lv_adress_13_0= ruleTypeAndValue )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2459:1: (lv_adress_13_0= ruleTypeAndValue )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2460:3: lv_adress_13_0= ruleTypeAndValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getStoreAccess().getAdressTypeAndValueParserRuleCall_1_5_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTypeAndValue_in_ruleStore5618);
                    lv_adress_13_0=ruleTypeAndValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getStoreRule());
                    	        }
                           		set(
                           			current, 
                           			"adress",
                            		lv_adress_13_0, 
                            		"TypeAndValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2476:2: (otherlv_14= 'singlethread' )?
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==53) ) {
                        alt68=1;
                    }
                    switch (alt68) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2476:4: otherlv_14= 'singlethread'
                            {
                            otherlv_14=(Token)match(input,53,FOLLOW_53_in_ruleStore5631); 

                                	newLeafNode(otherlv_14, grammarAccess.getStoreAccess().getSinglethreadKeyword_1_6());
                                

                            }
                            break;

                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2480:3: ( (lv_ordering_15_0= ruleATOMIC_ORDERING ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2481:1: (lv_ordering_15_0= ruleATOMIC_ORDERING )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2481:1: (lv_ordering_15_0= ruleATOMIC_ORDERING )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2482:3: lv_ordering_15_0= ruleATOMIC_ORDERING
                    {
                     
                    	        newCompositeNode(grammarAccess.getStoreAccess().getOrderingATOMIC_ORDERINGParserRuleCall_1_7_0()); 
                    	    
                    pushFollow(FOLLOW_ruleATOMIC_ORDERING_in_ruleStore5654);
                    lv_ordering_15_0=ruleATOMIC_ORDERING();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getStoreRule());
                    	        }
                           		set(
                           			current, 
                           			"ordering",
                            		lv_ordering_15_0, 
                            		"ATOMIC_ORDERING");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2498:2: (otherlv_16= ',' otherlv_17= 'align' ( (lv_index_18_0= RULE_INT ) ) )?
                    int alt69=2;
                    int LA69_0 = input.LA(1);

                    if ( (LA69_0==23) ) {
                        alt69=1;
                    }
                    switch (alt69) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2498:4: otherlv_16= ',' otherlv_17= 'align' ( (lv_index_18_0= RULE_INT ) )
                            {
                            otherlv_16=(Token)match(input,23,FOLLOW_23_in_ruleStore5667); 

                                	newLeafNode(otherlv_16, grammarAccess.getStoreAccess().getCommaKeyword_1_8_0());
                                
                            otherlv_17=(Token)match(input,78,FOLLOW_78_in_ruleStore5679); 

                                	newLeafNode(otherlv_17, grammarAccess.getStoreAccess().getAlignKeyword_1_8_1());
                                
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2506:1: ( (lv_index_18_0= RULE_INT ) )
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2507:1: (lv_index_18_0= RULE_INT )
                            {
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2507:1: (lv_index_18_0= RULE_INT )
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2508:3: lv_index_18_0= RULE_INT
                            {
                            lv_index_18_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleStore5696); 

                            			newLeafNode(lv_index_18_0, grammarAccess.getStoreAccess().getIndexINTTerminalRuleCall_1_8_2_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getStoreRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"index",
                                    		lv_index_18_0, 
                                    		"INT");
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStore"


    // $ANTLR start "entryRuleCall"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2532:1: entryRuleCall returns [EObject current=null] : iv_ruleCall= ruleCall EOF ;
    public final EObject entryRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCall = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2533:2: (iv_ruleCall= ruleCall EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2534:2: iv_ruleCall= ruleCall EOF
            {
             newCompositeNode(grammarAccess.getCallRule()); 
            pushFollow(FOLLOW_ruleCall_in_entryRuleCall5740);
            iv_ruleCall=ruleCall();

            state._fsp--;

             current =iv_ruleCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCall5750); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCall"


    // $ANTLR start "ruleCall"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2541:1: ruleCall returns [EObject current=null] : ( (otherlv_0= 'tail' )? otherlv_1= 'call' ( ruleCallingConv )? ( ruleRETURN_ATTRIBUTES )? ( (lv_pointer_4_0= ruleTypeAndValue ) ) ( (lv_plist_5_0= ruleParameterList ) ) ( ruleFUNCTION_ATTRIBUTES )? ) ;
    public final EObject ruleCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_pointer_4_0 = null;

        EObject lv_plist_5_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2544:28: ( ( (otherlv_0= 'tail' )? otherlv_1= 'call' ( ruleCallingConv )? ( ruleRETURN_ATTRIBUTES )? ( (lv_pointer_4_0= ruleTypeAndValue ) ) ( (lv_plist_5_0= ruleParameterList ) ) ( ruleFUNCTION_ATTRIBUTES )? ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2545:1: ( (otherlv_0= 'tail' )? otherlv_1= 'call' ( ruleCallingConv )? ( ruleRETURN_ATTRIBUTES )? ( (lv_pointer_4_0= ruleTypeAndValue ) ) ( (lv_plist_5_0= ruleParameterList ) ) ( ruleFUNCTION_ATTRIBUTES )? )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2545:1: ( (otherlv_0= 'tail' )? otherlv_1= 'call' ( ruleCallingConv )? ( ruleRETURN_ATTRIBUTES )? ( (lv_pointer_4_0= ruleTypeAndValue ) ) ( (lv_plist_5_0= ruleParameterList ) ) ( ruleFUNCTION_ATTRIBUTES )? )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2545:2: (otherlv_0= 'tail' )? otherlv_1= 'call' ( ruleCallingConv )? ( ruleRETURN_ATTRIBUTES )? ( (lv_pointer_4_0= ruleTypeAndValue ) ) ( (lv_plist_5_0= ruleParameterList ) ) ( ruleFUNCTION_ATTRIBUTES )?
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2545:2: (otherlv_0= 'tail' )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==80) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2545:4: otherlv_0= 'tail'
                    {
                    otherlv_0=(Token)match(input,80,FOLLOW_80_in_ruleCall5788); 

                        	newLeafNode(otherlv_0, grammarAccess.getCallAccess().getTailKeyword_0());
                        

                    }
                    break;

            }

            otherlv_1=(Token)match(input,81,FOLLOW_81_in_ruleCall5802); 

                	newLeafNode(otherlv_1, grammarAccess.getCallAccess().getCallKeyword_1());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2553:1: ( ruleCallingConv )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( ((LA72_0>=91 && LA72_0<=105)) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2554:5: ruleCallingConv
                    {
                     
                            newCompositeNode(grammarAccess.getCallAccess().getCallingConvParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleCallingConv_in_ruleCall5819);
                    ruleCallingConv();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2561:3: ( ruleRETURN_ATTRIBUTES )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( ((LA73_0>=82 && LA73_0<=89)) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2562:5: ruleRETURN_ATTRIBUTES
                    {
                     
                            newCompositeNode(grammarAccess.getCallAccess().getRETURN_ATTRIBUTESParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleRETURN_ATTRIBUTES_in_ruleCall5837);
                    ruleRETURN_ATTRIBUTES();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2569:3: ( (lv_pointer_4_0= ruleTypeAndValue ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2570:1: (lv_pointer_4_0= ruleTypeAndValue )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2570:1: (lv_pointer_4_0= ruleTypeAndValue )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2571:3: lv_pointer_4_0= ruleTypeAndValue
            {
             
            	        newCompositeNode(grammarAccess.getCallAccess().getPointerTypeAndValueParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleTypeAndValue_in_ruleCall5859);
            lv_pointer_4_0=ruleTypeAndValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCallRule());
            	        }
                   		set(
                   			current, 
                   			"pointer",
                    		lv_pointer_4_0, 
                    		"TypeAndValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2587:2: ( (lv_plist_5_0= ruleParameterList ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2588:1: (lv_plist_5_0= ruleParameterList )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2588:1: (lv_plist_5_0= ruleParameterList )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2589:3: lv_plist_5_0= ruleParameterList
            {
             
            	        newCompositeNode(grammarAccess.getCallAccess().getPlistParameterListParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleParameterList_in_ruleCall5880);
            lv_plist_5_0=ruleParameterList();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCallRule());
            	        }
                   		set(
                   			current, 
                   			"plist",
                    		lv_plist_5_0, 
                    		"ParameterList");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2605:2: ( ruleFUNCTION_ATTRIBUTES )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( ((LA74_0>=106 && LA74_0<=123)) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2606:5: ruleFUNCTION_ATTRIBUTES
                    {
                     
                            newCompositeNode(grammarAccess.getCallAccess().getFUNCTION_ATTRIBUTESParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_ruleFUNCTION_ATTRIBUTES_in_ruleCall5897);
                    ruleFUNCTION_ATTRIBUTES();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCall"


    // $ANTLR start "entryRuleRETURN_ATTRIBUTES"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2621:1: entryRuleRETURN_ATTRIBUTES returns [String current=null] : iv_ruleRETURN_ATTRIBUTES= ruleRETURN_ATTRIBUTES EOF ;
    public final String entryRuleRETURN_ATTRIBUTES() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRETURN_ATTRIBUTES = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2622:2: (iv_ruleRETURN_ATTRIBUTES= ruleRETURN_ATTRIBUTES EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2623:2: iv_ruleRETURN_ATTRIBUTES= ruleRETURN_ATTRIBUTES EOF
            {
             newCompositeNode(grammarAccess.getRETURN_ATTRIBUTESRule()); 
            pushFollow(FOLLOW_ruleRETURN_ATTRIBUTES_in_entryRuleRETURN_ATTRIBUTES5935);
            iv_ruleRETURN_ATTRIBUTES=ruleRETURN_ATTRIBUTES();

            state._fsp--;

             current =iv_ruleRETURN_ATTRIBUTES.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRETURN_ATTRIBUTES5946); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRETURN_ATTRIBUTES"


    // $ANTLR start "ruleRETURN_ATTRIBUTES"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2630:1: ruleRETURN_ATTRIBUTES returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'zeroext' | kw= 'signext' | kw= 'inreg' | kw= 'byval' | kw= 'sret' | kw= 'noalias' | kw= 'nocapture' | kw= 'nest' ) ;
    public final AntlrDatatypeRuleToken ruleRETURN_ATTRIBUTES() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2633:28: ( (kw= 'zeroext' | kw= 'signext' | kw= 'inreg' | kw= 'byval' | kw= 'sret' | kw= 'noalias' | kw= 'nocapture' | kw= 'nest' ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2634:1: (kw= 'zeroext' | kw= 'signext' | kw= 'inreg' | kw= 'byval' | kw= 'sret' | kw= 'noalias' | kw= 'nocapture' | kw= 'nest' )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2634:1: (kw= 'zeroext' | kw= 'signext' | kw= 'inreg' | kw= 'byval' | kw= 'sret' | kw= 'noalias' | kw= 'nocapture' | kw= 'nest' )
            int alt75=8;
            switch ( input.LA(1) ) {
            case 82:
                {
                alt75=1;
                }
                break;
            case 83:
                {
                alt75=2;
                }
                break;
            case 84:
                {
                alt75=3;
                }
                break;
            case 85:
                {
                alt75=4;
                }
                break;
            case 86:
                {
                alt75=5;
                }
                break;
            case 87:
                {
                alt75=6;
                }
                break;
            case 88:
                {
                alt75=7;
                }
                break;
            case 89:
                {
                alt75=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }

            switch (alt75) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2635:2: kw= 'zeroext'
                    {
                    kw=(Token)match(input,82,FOLLOW_82_in_ruleRETURN_ATTRIBUTES5984); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getRETURN_ATTRIBUTESAccess().getZeroextKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2642:2: kw= 'signext'
                    {
                    kw=(Token)match(input,83,FOLLOW_83_in_ruleRETURN_ATTRIBUTES6003); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getRETURN_ATTRIBUTESAccess().getSignextKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2649:2: kw= 'inreg'
                    {
                    kw=(Token)match(input,84,FOLLOW_84_in_ruleRETURN_ATTRIBUTES6022); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getRETURN_ATTRIBUTESAccess().getInregKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2656:2: kw= 'byval'
                    {
                    kw=(Token)match(input,85,FOLLOW_85_in_ruleRETURN_ATTRIBUTES6041); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getRETURN_ATTRIBUTESAccess().getByvalKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2663:2: kw= 'sret'
                    {
                    kw=(Token)match(input,86,FOLLOW_86_in_ruleRETURN_ATTRIBUTES6060); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getRETURN_ATTRIBUTESAccess().getSretKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2670:2: kw= 'noalias'
                    {
                    kw=(Token)match(input,87,FOLLOW_87_in_ruleRETURN_ATTRIBUTES6079); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getRETURN_ATTRIBUTESAccess().getNoaliasKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2677:2: kw= 'nocapture'
                    {
                    kw=(Token)match(input,88,FOLLOW_88_in_ruleRETURN_ATTRIBUTES6098); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getRETURN_ATTRIBUTESAccess().getNocaptureKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2684:2: kw= 'nest'
                    {
                    kw=(Token)match(input,89,FOLLOW_89_in_ruleRETURN_ATTRIBUTES6117); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getRETURN_ATTRIBUTESAccess().getNestKeyword_7()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRETURN_ATTRIBUTES"


    // $ANTLR start "entryRuleAlloc"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2697:1: entryRuleAlloc returns [EObject current=null] : iv_ruleAlloc= ruleAlloc EOF ;
    public final EObject entryRuleAlloc() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlloc = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2698:2: (iv_ruleAlloc= ruleAlloc EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2699:2: iv_ruleAlloc= ruleAlloc EOF
            {
             newCompositeNode(grammarAccess.getAllocRule()); 
            pushFollow(FOLLOW_ruleAlloc_in_entryRuleAlloc6157);
            iv_ruleAlloc=ruleAlloc();

            state._fsp--;

             current =iv_ruleAlloc; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlloc6167); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAlloc"


    // $ANTLR start "ruleAlloc"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2706:1: ruleAlloc returns [EObject current=null] : (otherlv_0= 'alloca' ( (lv_type_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_numElements_3_0= ruleTypeAndValue ) ) )? (otherlv_4= ',' ruleALIGNMENT )? ) ;
    public final EObject ruleAlloc() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_type_1_0 = null;

        EObject lv_numElements_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2709:28: ( (otherlv_0= 'alloca' ( (lv_type_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_numElements_3_0= ruleTypeAndValue ) ) )? (otherlv_4= ',' ruleALIGNMENT )? ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2710:1: (otherlv_0= 'alloca' ( (lv_type_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_numElements_3_0= ruleTypeAndValue ) ) )? (otherlv_4= ',' ruleALIGNMENT )? )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2710:1: (otherlv_0= 'alloca' ( (lv_type_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_numElements_3_0= ruleTypeAndValue ) ) )? (otherlv_4= ',' ruleALIGNMENT )? )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2710:3: otherlv_0= 'alloca' ( (lv_type_1_0= ruleType ) ) (otherlv_2= ',' ( (lv_numElements_3_0= ruleTypeAndValue ) ) )? (otherlv_4= ',' ruleALIGNMENT )?
            {
            otherlv_0=(Token)match(input,90,FOLLOW_90_in_ruleAlloc6204); 

                	newLeafNode(otherlv_0, grammarAccess.getAllocAccess().getAllocaKeyword_0());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2714:1: ( (lv_type_1_0= ruleType ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2715:1: (lv_type_1_0= ruleType )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2715:1: (lv_type_1_0= ruleType )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2716:3: lv_type_1_0= ruleType
            {
             
            	        newCompositeNode(grammarAccess.getAllocAccess().getTypeTypeParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleType_in_ruleAlloc6225);
            lv_type_1_0=ruleType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAllocRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_1_0, 
                    		"Type");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2732:2: (otherlv_2= ',' ( (lv_numElements_3_0= ruleTypeAndValue ) ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==23) ) {
                int LA76_1 = input.LA(2);

                if ( ((LA76_1>=RULE_VAR_TYPE && LA76_1<=RULE_INT)||LA76_1==32||(LA76_1>=38 && LA76_1<=47)) ) {
                    alt76=1;
                }
            }
            switch (alt76) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2732:4: otherlv_2= ',' ( (lv_numElements_3_0= ruleTypeAndValue ) )
                    {
                    otherlv_2=(Token)match(input,23,FOLLOW_23_in_ruleAlloc6238); 

                        	newLeafNode(otherlv_2, grammarAccess.getAllocAccess().getCommaKeyword_2_0());
                        
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2736:1: ( (lv_numElements_3_0= ruleTypeAndValue ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2737:1: (lv_numElements_3_0= ruleTypeAndValue )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2737:1: (lv_numElements_3_0= ruleTypeAndValue )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2738:3: lv_numElements_3_0= ruleTypeAndValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getAllocAccess().getNumElementsTypeAndValueParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTypeAndValue_in_ruleAlloc6259);
                    lv_numElements_3_0=ruleTypeAndValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAllocRule());
                    	        }
                           		set(
                           			current, 
                           			"numElements",
                            		lv_numElements_3_0, 
                            		"TypeAndValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2754:4: (otherlv_4= ',' ruleALIGNMENT )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==23) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2754:6: otherlv_4= ',' ruleALIGNMENT
                    {
                    otherlv_4=(Token)match(input,23,FOLLOW_23_in_ruleAlloc6274); 

                        	newLeafNode(otherlv_4, grammarAccess.getAllocAccess().getCommaKeyword_3_0());
                        
                     
                            newCompositeNode(grammarAccess.getAllocAccess().getALIGNMENTParserRuleCall_3_1()); 
                        
                    pushFollow(FOLLOW_ruleALIGNMENT_in_ruleAlloc6290);
                    ruleALIGNMENT();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAlloc"


    // $ANTLR start "entryRuleCallingConv"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2774:1: entryRuleCallingConv returns [String current=null] : iv_ruleCallingConv= ruleCallingConv EOF ;
    public final String entryRuleCallingConv() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCallingConv = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2775:2: (iv_ruleCallingConv= ruleCallingConv EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2776:2: iv_ruleCallingConv= ruleCallingConv EOF
            {
             newCompositeNode(grammarAccess.getCallingConvRule()); 
            pushFollow(FOLLOW_ruleCallingConv_in_entryRuleCallingConv6328);
            iv_ruleCallingConv=ruleCallingConv();

            state._fsp--;

             current =iv_ruleCallingConv.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCallingConv6339); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCallingConv"


    // $ANTLR start "ruleCallingConv"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2783:1: ruleCallingConv returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'ccc' | kw= 'fastcc' | kw= 'coldcc' | kw= 'x86_stdcallcc' | kw= 'x86_fastcallcc' | kw= 'x86_thiscallcc' | kw= 'arm_apcscc' | kw= 'arm_aapcscc' | kw= 'arm_aapcs_vfpcc' | kw= 'msp430_intrcc' | kw= 'ptx_kernel' | kw= 'ptx_device' | kw= 'spir_func' | kw= 'spir_kernel' | (kw= 'cc' kw= '<' this_INT_16= RULE_INT kw= '>' this_INT_18= RULE_INT ) ) ;
    public final AntlrDatatypeRuleToken ruleCallingConv() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_16=null;
        Token this_INT_18=null;

         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2786:28: ( (kw= 'ccc' | kw= 'fastcc' | kw= 'coldcc' | kw= 'x86_stdcallcc' | kw= 'x86_fastcallcc' | kw= 'x86_thiscallcc' | kw= 'arm_apcscc' | kw= 'arm_aapcscc' | kw= 'arm_aapcs_vfpcc' | kw= 'msp430_intrcc' | kw= 'ptx_kernel' | kw= 'ptx_device' | kw= 'spir_func' | kw= 'spir_kernel' | (kw= 'cc' kw= '<' this_INT_16= RULE_INT kw= '>' this_INT_18= RULE_INT ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2787:1: (kw= 'ccc' | kw= 'fastcc' | kw= 'coldcc' | kw= 'x86_stdcallcc' | kw= 'x86_fastcallcc' | kw= 'x86_thiscallcc' | kw= 'arm_apcscc' | kw= 'arm_aapcscc' | kw= 'arm_aapcs_vfpcc' | kw= 'msp430_intrcc' | kw= 'ptx_kernel' | kw= 'ptx_device' | kw= 'spir_func' | kw= 'spir_kernel' | (kw= 'cc' kw= '<' this_INT_16= RULE_INT kw= '>' this_INT_18= RULE_INT ) )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2787:1: (kw= 'ccc' | kw= 'fastcc' | kw= 'coldcc' | kw= 'x86_stdcallcc' | kw= 'x86_fastcallcc' | kw= 'x86_thiscallcc' | kw= 'arm_apcscc' | kw= 'arm_aapcscc' | kw= 'arm_aapcs_vfpcc' | kw= 'msp430_intrcc' | kw= 'ptx_kernel' | kw= 'ptx_device' | kw= 'spir_func' | kw= 'spir_kernel' | (kw= 'cc' kw= '<' this_INT_16= RULE_INT kw= '>' this_INT_18= RULE_INT ) )
            int alt78=15;
            switch ( input.LA(1) ) {
            case 91:
                {
                alt78=1;
                }
                break;
            case 92:
                {
                alt78=2;
                }
                break;
            case 93:
                {
                alt78=3;
                }
                break;
            case 94:
                {
                alt78=4;
                }
                break;
            case 95:
                {
                alt78=5;
                }
                break;
            case 96:
                {
                alt78=6;
                }
                break;
            case 97:
                {
                alt78=7;
                }
                break;
            case 98:
                {
                alt78=8;
                }
                break;
            case 99:
                {
                alt78=9;
                }
                break;
            case 100:
                {
                alt78=10;
                }
                break;
            case 101:
                {
                alt78=11;
                }
                break;
            case 102:
                {
                alt78=12;
                }
                break;
            case 103:
                {
                alt78=13;
                }
                break;
            case 104:
                {
                alt78=14;
                }
                break;
            case 105:
                {
                alt78=15;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }

            switch (alt78) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2788:2: kw= 'ccc'
                    {
                    kw=(Token)match(input,91,FOLLOW_91_in_ruleCallingConv6377); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCallingConvAccess().getCccKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2795:2: kw= 'fastcc'
                    {
                    kw=(Token)match(input,92,FOLLOW_92_in_ruleCallingConv6396); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCallingConvAccess().getFastccKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2802:2: kw= 'coldcc'
                    {
                    kw=(Token)match(input,93,FOLLOW_93_in_ruleCallingConv6415); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCallingConvAccess().getColdccKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2809:2: kw= 'x86_stdcallcc'
                    {
                    kw=(Token)match(input,94,FOLLOW_94_in_ruleCallingConv6434); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCallingConvAccess().getX86_stdcallccKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2816:2: kw= 'x86_fastcallcc'
                    {
                    kw=(Token)match(input,95,FOLLOW_95_in_ruleCallingConv6453); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCallingConvAccess().getX86_fastcallccKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2823:2: kw= 'x86_thiscallcc'
                    {
                    kw=(Token)match(input,96,FOLLOW_96_in_ruleCallingConv6472); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCallingConvAccess().getX86_thiscallccKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2830:2: kw= 'arm_apcscc'
                    {
                    kw=(Token)match(input,97,FOLLOW_97_in_ruleCallingConv6491); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCallingConvAccess().getArm_apcsccKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2837:2: kw= 'arm_aapcscc'
                    {
                    kw=(Token)match(input,98,FOLLOW_98_in_ruleCallingConv6510); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCallingConvAccess().getArm_aapcsccKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2844:2: kw= 'arm_aapcs_vfpcc'
                    {
                    kw=(Token)match(input,99,FOLLOW_99_in_ruleCallingConv6529); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCallingConvAccess().getArm_aapcs_vfpccKeyword_8()); 
                        

                    }
                    break;
                case 10 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2851:2: kw= 'msp430_intrcc'
                    {
                    kw=(Token)match(input,100,FOLLOW_100_in_ruleCallingConv6548); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCallingConvAccess().getMsp430_intrccKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2858:2: kw= 'ptx_kernel'
                    {
                    kw=(Token)match(input,101,FOLLOW_101_in_ruleCallingConv6567); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCallingConvAccess().getPtx_kernelKeyword_10()); 
                        

                    }
                    break;
                case 12 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2865:2: kw= 'ptx_device'
                    {
                    kw=(Token)match(input,102,FOLLOW_102_in_ruleCallingConv6586); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCallingConvAccess().getPtx_deviceKeyword_11()); 
                        

                    }
                    break;
                case 13 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2872:2: kw= 'spir_func'
                    {
                    kw=(Token)match(input,103,FOLLOW_103_in_ruleCallingConv6605); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCallingConvAccess().getSpir_funcKeyword_12()); 
                        

                    }
                    break;
                case 14 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2879:2: kw= 'spir_kernel'
                    {
                    kw=(Token)match(input,104,FOLLOW_104_in_ruleCallingConv6624); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCallingConvAccess().getSpir_kernelKeyword_13()); 
                        

                    }
                    break;
                case 15 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2885:6: (kw= 'cc' kw= '<' this_INT_16= RULE_INT kw= '>' this_INT_18= RULE_INT )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2885:6: (kw= 'cc' kw= '<' this_INT_16= RULE_INT kw= '>' this_INT_18= RULE_INT )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2886:2: kw= 'cc' kw= '<' this_INT_16= RULE_INT kw= '>' this_INT_18= RULE_INT
                    {
                    kw=(Token)match(input,105,FOLLOW_105_in_ruleCallingConv6644); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCallingConvAccess().getCcKeyword_14_0()); 
                        
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleCallingConv6657); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCallingConvAccess().getLessThanSignKeyword_14_1()); 
                        
                    this_INT_16=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleCallingConv6672); 

                    		current.merge(this_INT_16);
                        
                     
                        newLeafNode(this_INT_16, grammarAccess.getCallingConvAccess().getINTTerminalRuleCall_14_2()); 
                        
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleCallingConv6690); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCallingConvAccess().getGreaterThanSignKeyword_14_3()); 
                        
                    this_INT_18=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleCallingConv6705); 

                    		current.merge(this_INT_18);
                        
                     
                        newLeafNode(this_INT_18, grammarAccess.getCallingConvAccess().getINTTerminalRuleCall_14_4()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCallingConv"


    // $ANTLR start "entryRuleFUNCTION_ATTRIBUTES"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2925:1: entryRuleFUNCTION_ATTRIBUTES returns [String current=null] : iv_ruleFUNCTION_ATTRIBUTES= ruleFUNCTION_ATTRIBUTES EOF ;
    public final String entryRuleFUNCTION_ATTRIBUTES() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFUNCTION_ATTRIBUTES = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2926:2: (iv_ruleFUNCTION_ATTRIBUTES= ruleFUNCTION_ATTRIBUTES EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2927:2: iv_ruleFUNCTION_ATTRIBUTES= ruleFUNCTION_ATTRIBUTES EOF
            {
             newCompositeNode(grammarAccess.getFUNCTION_ATTRIBUTESRule()); 
            pushFollow(FOLLOW_ruleFUNCTION_ATTRIBUTES_in_entryRuleFUNCTION_ATTRIBUTES6752);
            iv_ruleFUNCTION_ATTRIBUTES=ruleFUNCTION_ATTRIBUTES();

            state._fsp--;

             current =iv_ruleFUNCTION_ATTRIBUTES.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFUNCTION_ATTRIBUTES6763); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFUNCTION_ATTRIBUTES"


    // $ANTLR start "ruleFUNCTION_ATTRIBUTES"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2934:1: ruleFUNCTION_ATTRIBUTES returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'address_safety' | (kw= 'alignstack' kw= '(' kw= '<' this_INT_4= RULE_INT kw= '>' kw= ')' ) | kw= 'alwaysinline' | kw= 'nonlazybind' | kw= 'inlinehint' | kw= 'naked' | kw= 'noimplicitfloat' | kw= 'noinline' | kw= 'noredzone' | kw= 'noreturn' | kw= 'nounwind' | kw= 'optsize' | kw= 'readnone' | kw= 'readonly' | kw= 'returns_twice' | kw= 'ssp' | kw= 'sspreq' | kw= 'uwtable' ) ;
    public final AntlrDatatypeRuleToken ruleFUNCTION_ATTRIBUTES() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_4=null;

         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2937:28: ( (kw= 'address_safety' | (kw= 'alignstack' kw= '(' kw= '<' this_INT_4= RULE_INT kw= '>' kw= ')' ) | kw= 'alwaysinline' | kw= 'nonlazybind' | kw= 'inlinehint' | kw= 'naked' | kw= 'noimplicitfloat' | kw= 'noinline' | kw= 'noredzone' | kw= 'noreturn' | kw= 'nounwind' | kw= 'optsize' | kw= 'readnone' | kw= 'readonly' | kw= 'returns_twice' | kw= 'ssp' | kw= 'sspreq' | kw= 'uwtable' ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2938:1: (kw= 'address_safety' | (kw= 'alignstack' kw= '(' kw= '<' this_INT_4= RULE_INT kw= '>' kw= ')' ) | kw= 'alwaysinline' | kw= 'nonlazybind' | kw= 'inlinehint' | kw= 'naked' | kw= 'noimplicitfloat' | kw= 'noinline' | kw= 'noredzone' | kw= 'noreturn' | kw= 'nounwind' | kw= 'optsize' | kw= 'readnone' | kw= 'readonly' | kw= 'returns_twice' | kw= 'ssp' | kw= 'sspreq' | kw= 'uwtable' )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2938:1: (kw= 'address_safety' | (kw= 'alignstack' kw= '(' kw= '<' this_INT_4= RULE_INT kw= '>' kw= ')' ) | kw= 'alwaysinline' | kw= 'nonlazybind' | kw= 'inlinehint' | kw= 'naked' | kw= 'noimplicitfloat' | kw= 'noinline' | kw= 'noredzone' | kw= 'noreturn' | kw= 'nounwind' | kw= 'optsize' | kw= 'readnone' | kw= 'readonly' | kw= 'returns_twice' | kw= 'ssp' | kw= 'sspreq' | kw= 'uwtable' )
            int alt79=18;
            switch ( input.LA(1) ) {
            case 106:
                {
                alt79=1;
                }
                break;
            case 107:
                {
                alt79=2;
                }
                break;
            case 108:
                {
                alt79=3;
                }
                break;
            case 109:
                {
                alt79=4;
                }
                break;
            case 110:
                {
                alt79=5;
                }
                break;
            case 111:
                {
                alt79=6;
                }
                break;
            case 112:
                {
                alt79=7;
                }
                break;
            case 113:
                {
                alt79=8;
                }
                break;
            case 114:
                {
                alt79=9;
                }
                break;
            case 115:
                {
                alt79=10;
                }
                break;
            case 116:
                {
                alt79=11;
                }
                break;
            case 117:
                {
                alt79=12;
                }
                break;
            case 118:
                {
                alt79=13;
                }
                break;
            case 119:
                {
                alt79=14;
                }
                break;
            case 120:
                {
                alt79=15;
                }
                break;
            case 121:
                {
                alt79=16;
                }
                break;
            case 122:
                {
                alt79=17;
                }
                break;
            case 123:
                {
                alt79=18;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }

            switch (alt79) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2939:2: kw= 'address_safety'
                    {
                    kw=(Token)match(input,106,FOLLOW_106_in_ruleFUNCTION_ATTRIBUTES6801); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFUNCTION_ATTRIBUTESAccess().getAddress_safetyKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2945:6: (kw= 'alignstack' kw= '(' kw= '<' this_INT_4= RULE_INT kw= '>' kw= ')' )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2945:6: (kw= 'alignstack' kw= '(' kw= '<' this_INT_4= RULE_INT kw= '>' kw= ')' )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2946:2: kw= 'alignstack' kw= '(' kw= '<' this_INT_4= RULE_INT kw= '>' kw= ')'
                    {
                    kw=(Token)match(input,107,FOLLOW_107_in_ruleFUNCTION_ATTRIBUTES6821); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFUNCTION_ATTRIBUTESAccess().getAlignstackKeyword_1_0()); 
                        
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleFUNCTION_ATTRIBUTES6834); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFUNCTION_ATTRIBUTESAccess().getLeftParenthesisKeyword_1_1()); 
                        
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleFUNCTION_ATTRIBUTES6847); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFUNCTION_ATTRIBUTESAccess().getLessThanSignKeyword_1_2()); 
                        
                    this_INT_4=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFUNCTION_ATTRIBUTES6862); 

                    		current.merge(this_INT_4);
                        
                     
                        newLeafNode(this_INT_4, grammarAccess.getFUNCTION_ATTRIBUTESAccess().getINTTerminalRuleCall_1_3()); 
                        
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleFUNCTION_ATTRIBUTES6880); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFUNCTION_ATTRIBUTESAccess().getGreaterThanSignKeyword_1_4()); 
                        
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleFUNCTION_ATTRIBUTES6893); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFUNCTION_ATTRIBUTESAccess().getRightParenthesisKeyword_1_5()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2984:2: kw= 'alwaysinline'
                    {
                    kw=(Token)match(input,108,FOLLOW_108_in_ruleFUNCTION_ATTRIBUTES6913); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFUNCTION_ATTRIBUTESAccess().getAlwaysinlineKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2991:2: kw= 'nonlazybind'
                    {
                    kw=(Token)match(input,109,FOLLOW_109_in_ruleFUNCTION_ATTRIBUTES6932); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFUNCTION_ATTRIBUTESAccess().getNonlazybindKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:2998:2: kw= 'inlinehint'
                    {
                    kw=(Token)match(input,110,FOLLOW_110_in_ruleFUNCTION_ATTRIBUTES6951); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFUNCTION_ATTRIBUTESAccess().getInlinehintKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3005:2: kw= 'naked'
                    {
                    kw=(Token)match(input,111,FOLLOW_111_in_ruleFUNCTION_ATTRIBUTES6970); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFUNCTION_ATTRIBUTESAccess().getNakedKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3012:2: kw= 'noimplicitfloat'
                    {
                    kw=(Token)match(input,112,FOLLOW_112_in_ruleFUNCTION_ATTRIBUTES6989); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFUNCTION_ATTRIBUTESAccess().getNoimplicitfloatKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3019:2: kw= 'noinline'
                    {
                    kw=(Token)match(input,113,FOLLOW_113_in_ruleFUNCTION_ATTRIBUTES7008); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFUNCTION_ATTRIBUTESAccess().getNoinlineKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3026:2: kw= 'noredzone'
                    {
                    kw=(Token)match(input,114,FOLLOW_114_in_ruleFUNCTION_ATTRIBUTES7027); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFUNCTION_ATTRIBUTESAccess().getNoredzoneKeyword_8()); 
                        

                    }
                    break;
                case 10 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3033:2: kw= 'noreturn'
                    {
                    kw=(Token)match(input,115,FOLLOW_115_in_ruleFUNCTION_ATTRIBUTES7046); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFUNCTION_ATTRIBUTESAccess().getNoreturnKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3040:2: kw= 'nounwind'
                    {
                    kw=(Token)match(input,116,FOLLOW_116_in_ruleFUNCTION_ATTRIBUTES7065); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFUNCTION_ATTRIBUTESAccess().getNounwindKeyword_10()); 
                        

                    }
                    break;
                case 12 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3047:2: kw= 'optsize'
                    {
                    kw=(Token)match(input,117,FOLLOW_117_in_ruleFUNCTION_ATTRIBUTES7084); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFUNCTION_ATTRIBUTESAccess().getOptsizeKeyword_11()); 
                        

                    }
                    break;
                case 13 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3054:2: kw= 'readnone'
                    {
                    kw=(Token)match(input,118,FOLLOW_118_in_ruleFUNCTION_ATTRIBUTES7103); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFUNCTION_ATTRIBUTESAccess().getReadnoneKeyword_12()); 
                        

                    }
                    break;
                case 14 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3061:2: kw= 'readonly'
                    {
                    kw=(Token)match(input,119,FOLLOW_119_in_ruleFUNCTION_ATTRIBUTES7122); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFUNCTION_ATTRIBUTESAccess().getReadonlyKeyword_13()); 
                        

                    }
                    break;
                case 15 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3068:2: kw= 'returns_twice'
                    {
                    kw=(Token)match(input,120,FOLLOW_120_in_ruleFUNCTION_ATTRIBUTES7141); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFUNCTION_ATTRIBUTESAccess().getReturns_twiceKeyword_14()); 
                        

                    }
                    break;
                case 16 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3075:2: kw= 'ssp'
                    {
                    kw=(Token)match(input,121,FOLLOW_121_in_ruleFUNCTION_ATTRIBUTES7160); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFUNCTION_ATTRIBUTESAccess().getSspKeyword_15()); 
                        

                    }
                    break;
                case 17 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3082:2: kw= 'sspreq'
                    {
                    kw=(Token)match(input,122,FOLLOW_122_in_ruleFUNCTION_ATTRIBUTES7179); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFUNCTION_ATTRIBUTESAccess().getSspreqKeyword_16()); 
                        

                    }
                    break;
                case 18 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3089:2: kw= 'uwtable'
                    {
                    kw=(Token)match(input,123,FOLLOW_123_in_ruleFUNCTION_ATTRIBUTES7198); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFUNCTION_ATTRIBUTESAccess().getUwtableKeyword_17()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFUNCTION_ATTRIBUTES"


    // $ANTLR start "entryRuleParameterList"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3102:1: entryRuleParameterList returns [EObject current=null] : iv_ruleParameterList= ruleParameterList EOF ;
    public final EObject entryRuleParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterList = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3103:2: (iv_ruleParameterList= ruleParameterList EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3104:2: iv_ruleParameterList= ruleParameterList EOF
            {
             newCompositeNode(grammarAccess.getParameterListRule()); 
            pushFollow(FOLLOW_ruleParameterList_in_entryRuleParameterList7238);
            iv_ruleParameterList=ruleParameterList();

            state._fsp--;

             current =iv_ruleParameterList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterList7248); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterList"


    // $ANTLR start "ruleParameterList"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3111:1: ruleParameterList returns [EObject current=null] : ( () otherlv_1= '(' ( ( (lv_params_2_0= ruleTypeAndValue ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleTypeAndValue ) ) )* )? otherlv_5= ')' ) ;
    public final EObject ruleParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_params_2_0 = null;

        EObject lv_params_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3114:28: ( ( () otherlv_1= '(' ( ( (lv_params_2_0= ruleTypeAndValue ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleTypeAndValue ) ) )* )? otherlv_5= ')' ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3115:1: ( () otherlv_1= '(' ( ( (lv_params_2_0= ruleTypeAndValue ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleTypeAndValue ) ) )* )? otherlv_5= ')' )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3115:1: ( () otherlv_1= '(' ( ( (lv_params_2_0= ruleTypeAndValue ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleTypeAndValue ) ) )* )? otherlv_5= ')' )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3115:2: () otherlv_1= '(' ( ( (lv_params_2_0= ruleTypeAndValue ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleTypeAndValue ) ) )* )? otherlv_5= ')'
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3115:2: ()
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3116:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getParameterListAccess().getParameterListAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,30,FOLLOW_30_in_ruleParameterList7294); 

                	newLeafNode(otherlv_1, grammarAccess.getParameterListAccess().getLeftParenthesisKeyword_1());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3125:1: ( ( (lv_params_2_0= ruleTypeAndValue ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleTypeAndValue ) ) )* )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( ((LA81_0>=RULE_VAR_TYPE && LA81_0<=RULE_INT)||LA81_0==32||(LA81_0>=38 && LA81_0<=47)) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3125:2: ( (lv_params_2_0= ruleTypeAndValue ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleTypeAndValue ) ) )*
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3125:2: ( (lv_params_2_0= ruleTypeAndValue ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3126:1: (lv_params_2_0= ruleTypeAndValue )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3126:1: (lv_params_2_0= ruleTypeAndValue )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3127:3: lv_params_2_0= ruleTypeAndValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getParameterListAccess().getParamsTypeAndValueParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTypeAndValue_in_ruleParameterList7316);
                    lv_params_2_0=ruleTypeAndValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getParameterListRule());
                    	        }
                           		add(
                           			current, 
                           			"params",
                            		lv_params_2_0, 
                            		"TypeAndValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3143:2: (otherlv_3= ',' ( (lv_params_4_0= ruleTypeAndValue ) ) )*
                    loop80:
                    do {
                        int alt80=2;
                        int LA80_0 = input.LA(1);

                        if ( (LA80_0==23) ) {
                            alt80=1;
                        }


                        switch (alt80) {
                    	case 1 :
                    	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3143:4: otherlv_3= ',' ( (lv_params_4_0= ruleTypeAndValue ) )
                    	    {
                    	    otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleParameterList7329); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getParameterListAccess().getCommaKeyword_2_1_0());
                    	        
                    	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3147:1: ( (lv_params_4_0= ruleTypeAndValue ) )
                    	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3148:1: (lv_params_4_0= ruleTypeAndValue )
                    	    {
                    	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3148:1: (lv_params_4_0= ruleTypeAndValue )
                    	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3149:3: lv_params_4_0= ruleTypeAndValue
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getParameterListAccess().getParamsTypeAndValueParserRuleCall_2_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleTypeAndValue_in_ruleParameterList7350);
                    	    lv_params_4_0=ruleTypeAndValue();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getParameterListRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"params",
                    	            		lv_params_4_0, 
                    	            		"TypeAndValue");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop80;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,31,FOLLOW_31_in_ruleParameterList7366); 

                	newLeafNode(otherlv_5, grammarAccess.getParameterListAccess().getRightParenthesisKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterList"


    // $ANTLR start "entryRulePHI"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3177:1: entryRulePHI returns [EObject current=null] : iv_rulePHI= rulePHI EOF ;
    public final EObject entryRulePHI() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePHI = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3178:2: (iv_rulePHI= rulePHI EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3179:2: iv_rulePHI= rulePHI EOF
            {
             newCompositeNode(grammarAccess.getPHIRule()); 
            pushFollow(FOLLOW_rulePHI_in_entryRulePHI7402);
            iv_rulePHI=rulePHI();

            state._fsp--;

             current =iv_rulePHI; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePHI7412); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePHI"


    // $ANTLR start "rulePHI"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3186:1: rulePHI returns [EObject current=null] : (otherlv_0= 'phi' ruleType otherlv_2= '[' ( (lv_values_3_0= ruleValuePair ) ) otherlv_4= ']' (otherlv_5= ',' otherlv_6= '[' ( (lv_values_7_0= ruleValuePair ) ) otherlv_8= ']' )* ) ;
    public final EObject rulePHI() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_values_3_0 = null;

        EObject lv_values_7_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3189:28: ( (otherlv_0= 'phi' ruleType otherlv_2= '[' ( (lv_values_3_0= ruleValuePair ) ) otherlv_4= ']' (otherlv_5= ',' otherlv_6= '[' ( (lv_values_7_0= ruleValuePair ) ) otherlv_8= ']' )* ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3190:1: (otherlv_0= 'phi' ruleType otherlv_2= '[' ( (lv_values_3_0= ruleValuePair ) ) otherlv_4= ']' (otherlv_5= ',' otherlv_6= '[' ( (lv_values_7_0= ruleValuePair ) ) otherlv_8= ']' )* )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3190:1: (otherlv_0= 'phi' ruleType otherlv_2= '[' ( (lv_values_3_0= ruleValuePair ) ) otherlv_4= ']' (otherlv_5= ',' otherlv_6= '[' ( (lv_values_7_0= ruleValuePair ) ) otherlv_8= ']' )* )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3190:3: otherlv_0= 'phi' ruleType otherlv_2= '[' ( (lv_values_3_0= ruleValuePair ) ) otherlv_4= ']' (otherlv_5= ',' otherlv_6= '[' ( (lv_values_7_0= ruleValuePair ) ) otherlv_8= ']' )*
            {
            otherlv_0=(Token)match(input,124,FOLLOW_124_in_rulePHI7449); 

                	newLeafNode(otherlv_0, grammarAccess.getPHIAccess().getPhiKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getPHIAccess().getTypeParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleType_in_rulePHI7465);
            ruleType();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,22,FOLLOW_22_in_rulePHI7476); 

                	newLeafNode(otherlv_2, grammarAccess.getPHIAccess().getLeftSquareBracketKeyword_2());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3206:1: ( (lv_values_3_0= ruleValuePair ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3207:1: (lv_values_3_0= ruleValuePair )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3207:1: (lv_values_3_0= ruleValuePair )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3208:3: lv_values_3_0= ruleValuePair
            {
             
            	        newCompositeNode(grammarAccess.getPHIAccess().getValuesValuePairParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleValuePair_in_rulePHI7497);
            lv_values_3_0=ruleValuePair();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPHIRule());
            	        }
                   		add(
                   			current, 
                   			"values",
                    		lv_values_3_0, 
                    		"ValuePair");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,24,FOLLOW_24_in_rulePHI7509); 

                	newLeafNode(otherlv_4, grammarAccess.getPHIAccess().getRightSquareBracketKeyword_4());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3228:1: (otherlv_5= ',' otherlv_6= '[' ( (lv_values_7_0= ruleValuePair ) ) otherlv_8= ']' )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==23) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3228:3: otherlv_5= ',' otherlv_6= '[' ( (lv_values_7_0= ruleValuePair ) ) otherlv_8= ']'
            	    {
            	    otherlv_5=(Token)match(input,23,FOLLOW_23_in_rulePHI7522); 

            	        	newLeafNode(otherlv_5, grammarAccess.getPHIAccess().getCommaKeyword_5_0());
            	        
            	    otherlv_6=(Token)match(input,22,FOLLOW_22_in_rulePHI7534); 

            	        	newLeafNode(otherlv_6, grammarAccess.getPHIAccess().getLeftSquareBracketKeyword_5_1());
            	        
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3236:1: ( (lv_values_7_0= ruleValuePair ) )
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3237:1: (lv_values_7_0= ruleValuePair )
            	    {
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3237:1: (lv_values_7_0= ruleValuePair )
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3238:3: lv_values_7_0= ruleValuePair
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPHIAccess().getValuesValuePairParserRuleCall_5_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValuePair_in_rulePHI7555);
            	    lv_values_7_0=ruleValuePair();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPHIRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"values",
            	            		lv_values_7_0, 
            	            		"ValuePair");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    otherlv_8=(Token)match(input,24,FOLLOW_24_in_rulePHI7567); 

            	        	newLeafNode(otherlv_8, grammarAccess.getPHIAccess().getRightSquareBracketKeyword_5_3());
            	        

            	    }
            	    break;

            	default :
            	    break loop82;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePHI"


    // $ANTLR start "entryRuleValuePair"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3266:1: entryRuleValuePair returns [EObject current=null] : iv_ruleValuePair= ruleValuePair EOF ;
    public final EObject entryRuleValuePair() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValuePair = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3267:2: (iv_ruleValuePair= ruleValuePair EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3268:2: iv_ruleValuePair= ruleValuePair EOF
            {
             newCompositeNode(grammarAccess.getValuePairRule()); 
            pushFollow(FOLLOW_ruleValuePair_in_entryRuleValuePair7605);
            iv_ruleValuePair=ruleValuePair();

            state._fsp--;

             current =iv_ruleValuePair; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValuePair7615); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValuePair"


    // $ANTLR start "ruleValuePair"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3275:1: ruleValuePair returns [EObject current=null] : ( ( (lv_value1_0_0= ruleType ) ) otherlv_1= ',' ( (lv_value2_2_0= ruleType ) ) ) ;
    public final EObject ruleValuePair() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value1_0_0 = null;

        AntlrDatatypeRuleToken lv_value2_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3278:28: ( ( ( (lv_value1_0_0= ruleType ) ) otherlv_1= ',' ( (lv_value2_2_0= ruleType ) ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3279:1: ( ( (lv_value1_0_0= ruleType ) ) otherlv_1= ',' ( (lv_value2_2_0= ruleType ) ) )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3279:1: ( ( (lv_value1_0_0= ruleType ) ) otherlv_1= ',' ( (lv_value2_2_0= ruleType ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3279:2: ( (lv_value1_0_0= ruleType ) ) otherlv_1= ',' ( (lv_value2_2_0= ruleType ) )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3279:2: ( (lv_value1_0_0= ruleType ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3280:1: (lv_value1_0_0= ruleType )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3280:1: (lv_value1_0_0= ruleType )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3281:3: lv_value1_0_0= ruleType
            {
             
            	        newCompositeNode(grammarAccess.getValuePairAccess().getValue1TypeParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleType_in_ruleValuePair7661);
            lv_value1_0_0=ruleType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getValuePairRule());
            	        }
                   		set(
                   			current, 
                   			"value1",
                    		lv_value1_0_0, 
                    		"Type");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleValuePair7673); 

                	newLeafNode(otherlv_1, grammarAccess.getValuePairAccess().getCommaKeyword_1());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3301:1: ( (lv_value2_2_0= ruleType ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3302:1: (lv_value2_2_0= ruleType )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3302:1: (lv_value2_2_0= ruleType )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3303:3: lv_value2_2_0= ruleType
            {
             
            	        newCompositeNode(grammarAccess.getValuePairAccess().getValue2TypeParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleType_in_ruleValuePair7694);
            lv_value2_2_0=ruleType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getValuePairRule());
            	        }
                   		set(
                   			current, 
                   			"value2",
                    		lv_value2_2_0, 
                    		"Type");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValuePair"


    // $ANTLR start "entryRuleLandingPad"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3327:1: entryRuleLandingPad returns [EObject current=null] : iv_ruleLandingPad= ruleLandingPad EOF ;
    public final EObject entryRuleLandingPad() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLandingPad = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3328:2: (iv_ruleLandingPad= ruleLandingPad EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3329:2: iv_ruleLandingPad= ruleLandingPad EOF
            {
             newCompositeNode(grammarAccess.getLandingPadRule()); 
            pushFollow(FOLLOW_ruleLandingPad_in_entryRuleLandingPad7730);
            iv_ruleLandingPad=ruleLandingPad();

            state._fsp--;

             current =iv_ruleLandingPad; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLandingPad7740); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLandingPad"


    // $ANTLR start "ruleLandingPad"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3336:1: ruleLandingPad returns [EObject current=null] : ( (otherlv_0= 'landingpad' ( (lv_type_1_0= ruleType ) ) otherlv_2= 'personality' ( (lv_personality_3_0= ruleTypeAndValue ) ) ( (otherlv_4= 'cleanup' ( (lv_clause_5_0= ruleClause ) )* ) | ( (lv_clause_6_0= ruleClause ) )+ ) ) | (otherlv_7= 'landingpad' ( (lv_type_8_0= ruleType ) ) otherlv_9= 'personality' ( (lv_personalitytype_10_0= ruleType ) ) ( (lv_personalityfunction_11_0= ruleCAST_TYPE ) ) otherlv_12= '(' ( (lv_value_13_0= ruleType ) ) otherlv_14= '(...)*' this_VAR_TYPE_15= RULE_VAR_TYPE otherlv_16= 'to' ( (lv_castto_17_0= ruleType ) ) otherlv_18= ')' ( (otherlv_19= 'cleanup' ( (lv_clause_20_0= ruleClause ) )* ) | ( (lv_clause_21_0= ruleClause ) )+ ) ) ) ;
    public final EObject ruleLandingPad() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token this_VAR_TYPE_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        AntlrDatatypeRuleToken lv_type_1_0 = null;

        EObject lv_personality_3_0 = null;

        EObject lv_clause_5_0 = null;

        EObject lv_clause_6_0 = null;

        AntlrDatatypeRuleToken lv_type_8_0 = null;

        AntlrDatatypeRuleToken lv_personalitytype_10_0 = null;

        AntlrDatatypeRuleToken lv_personalityfunction_11_0 = null;

        AntlrDatatypeRuleToken lv_value_13_0 = null;

        AntlrDatatypeRuleToken lv_castto_17_0 = null;

        EObject lv_clause_20_0 = null;

        EObject lv_clause_21_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3339:28: ( ( (otherlv_0= 'landingpad' ( (lv_type_1_0= ruleType ) ) otherlv_2= 'personality' ( (lv_personality_3_0= ruleTypeAndValue ) ) ( (otherlv_4= 'cleanup' ( (lv_clause_5_0= ruleClause ) )* ) | ( (lv_clause_6_0= ruleClause ) )+ ) ) | (otherlv_7= 'landingpad' ( (lv_type_8_0= ruleType ) ) otherlv_9= 'personality' ( (lv_personalitytype_10_0= ruleType ) ) ( (lv_personalityfunction_11_0= ruleCAST_TYPE ) ) otherlv_12= '(' ( (lv_value_13_0= ruleType ) ) otherlv_14= '(...)*' this_VAR_TYPE_15= RULE_VAR_TYPE otherlv_16= 'to' ( (lv_castto_17_0= ruleType ) ) otherlv_18= ')' ( (otherlv_19= 'cleanup' ( (lv_clause_20_0= ruleClause ) )* ) | ( (lv_clause_21_0= ruleClause ) )+ ) ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3340:1: ( (otherlv_0= 'landingpad' ( (lv_type_1_0= ruleType ) ) otherlv_2= 'personality' ( (lv_personality_3_0= ruleTypeAndValue ) ) ( (otherlv_4= 'cleanup' ( (lv_clause_5_0= ruleClause ) )* ) | ( (lv_clause_6_0= ruleClause ) )+ ) ) | (otherlv_7= 'landingpad' ( (lv_type_8_0= ruleType ) ) otherlv_9= 'personality' ( (lv_personalitytype_10_0= ruleType ) ) ( (lv_personalityfunction_11_0= ruleCAST_TYPE ) ) otherlv_12= '(' ( (lv_value_13_0= ruleType ) ) otherlv_14= '(...)*' this_VAR_TYPE_15= RULE_VAR_TYPE otherlv_16= 'to' ( (lv_castto_17_0= ruleType ) ) otherlv_18= ')' ( (otherlv_19= 'cleanup' ( (lv_clause_20_0= ruleClause ) )* ) | ( (lv_clause_21_0= ruleClause ) )+ ) ) )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3340:1: ( (otherlv_0= 'landingpad' ( (lv_type_1_0= ruleType ) ) otherlv_2= 'personality' ( (lv_personality_3_0= ruleTypeAndValue ) ) ( (otherlv_4= 'cleanup' ( (lv_clause_5_0= ruleClause ) )* ) | ( (lv_clause_6_0= ruleClause ) )+ ) ) | (otherlv_7= 'landingpad' ( (lv_type_8_0= ruleType ) ) otherlv_9= 'personality' ( (lv_personalitytype_10_0= ruleType ) ) ( (lv_personalityfunction_11_0= ruleCAST_TYPE ) ) otherlv_12= '(' ( (lv_value_13_0= ruleType ) ) otherlv_14= '(...)*' this_VAR_TYPE_15= RULE_VAR_TYPE otherlv_16= 'to' ( (lv_castto_17_0= ruleType ) ) otherlv_18= ')' ( (otherlv_19= 'cleanup' ( (lv_clause_20_0= ruleClause ) )* ) | ( (lv_clause_21_0= ruleClause ) )+ ) ) )
            int alt89=2;
            alt89 = dfa89.predict(input);
            switch (alt89) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3340:2: (otherlv_0= 'landingpad' ( (lv_type_1_0= ruleType ) ) otherlv_2= 'personality' ( (lv_personality_3_0= ruleTypeAndValue ) ) ( (otherlv_4= 'cleanup' ( (lv_clause_5_0= ruleClause ) )* ) | ( (lv_clause_6_0= ruleClause ) )+ ) )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3340:2: (otherlv_0= 'landingpad' ( (lv_type_1_0= ruleType ) ) otherlv_2= 'personality' ( (lv_personality_3_0= ruleTypeAndValue ) ) ( (otherlv_4= 'cleanup' ( (lv_clause_5_0= ruleClause ) )* ) | ( (lv_clause_6_0= ruleClause ) )+ ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3340:4: otherlv_0= 'landingpad' ( (lv_type_1_0= ruleType ) ) otherlv_2= 'personality' ( (lv_personality_3_0= ruleTypeAndValue ) ) ( (otherlv_4= 'cleanup' ( (lv_clause_5_0= ruleClause ) )* ) | ( (lv_clause_6_0= ruleClause ) )+ )
                    {
                    otherlv_0=(Token)match(input,125,FOLLOW_125_in_ruleLandingPad7778); 

                        	newLeafNode(otherlv_0, grammarAccess.getLandingPadAccess().getLandingpadKeyword_0_0());
                        
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3344:1: ( (lv_type_1_0= ruleType ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3345:1: (lv_type_1_0= ruleType )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3345:1: (lv_type_1_0= ruleType )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3346:3: lv_type_1_0= ruleType
                    {
                     
                    	        newCompositeNode(grammarAccess.getLandingPadAccess().getTypeTypeParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleType_in_ruleLandingPad7799);
                    lv_type_1_0=ruleType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLandingPadRule());
                    	        }
                           		set(
                           			current, 
                           			"type",
                            		lv_type_1_0, 
                            		"Type");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_2=(Token)match(input,126,FOLLOW_126_in_ruleLandingPad7811); 

                        	newLeafNode(otherlv_2, grammarAccess.getLandingPadAccess().getPersonalityKeyword_0_2());
                        
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3366:1: ( (lv_personality_3_0= ruleTypeAndValue ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3367:1: (lv_personality_3_0= ruleTypeAndValue )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3367:1: (lv_personality_3_0= ruleTypeAndValue )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3368:3: lv_personality_3_0= ruleTypeAndValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getLandingPadAccess().getPersonalityTypeAndValueParserRuleCall_0_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTypeAndValue_in_ruleLandingPad7832);
                    lv_personality_3_0=ruleTypeAndValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLandingPadRule());
                    	        }
                           		set(
                           			current, 
                           			"personality",
                            		lv_personality_3_0, 
                            		"TypeAndValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3384:2: ( (otherlv_4= 'cleanup' ( (lv_clause_5_0= ruleClause ) )* ) | ( (lv_clause_6_0= ruleClause ) )+ )
                    int alt85=2;
                    int LA85_0 = input.LA(1);

                    if ( (LA85_0==127) ) {
                        alt85=1;
                    }
                    else if ( ((LA85_0>=130 && LA85_0<=131)) ) {
                        alt85=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 85, 0, input);

                        throw nvae;
                    }
                    switch (alt85) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3384:3: (otherlv_4= 'cleanup' ( (lv_clause_5_0= ruleClause ) )* )
                            {
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3384:3: (otherlv_4= 'cleanup' ( (lv_clause_5_0= ruleClause ) )* )
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3384:5: otherlv_4= 'cleanup' ( (lv_clause_5_0= ruleClause ) )*
                            {
                            otherlv_4=(Token)match(input,127,FOLLOW_127_in_ruleLandingPad7846); 

                                	newLeafNode(otherlv_4, grammarAccess.getLandingPadAccess().getCleanupKeyword_0_4_0_0());
                                
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3388:1: ( (lv_clause_5_0= ruleClause ) )*
                            loop83:
                            do {
                                int alt83=2;
                                int LA83_0 = input.LA(1);

                                if ( ((LA83_0>=130 && LA83_0<=131)) ) {
                                    alt83=1;
                                }


                                switch (alt83) {
                            	case 1 :
                            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3389:1: (lv_clause_5_0= ruleClause )
                            	    {
                            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3389:1: (lv_clause_5_0= ruleClause )
                            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3390:3: lv_clause_5_0= ruleClause
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getLandingPadAccess().getClauseClauseParserRuleCall_0_4_0_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleClause_in_ruleLandingPad7867);
                            	    lv_clause_5_0=ruleClause();

                            	    state._fsp--;


                            	    	        if (current==null) {
                            	    	            current = createModelElementForParent(grammarAccess.getLandingPadRule());
                            	    	        }
                            	           		add(
                            	           			current, 
                            	           			"clause",
                            	            		lv_clause_5_0, 
                            	            		"Clause");
                            	    	        afterParserOrEnumRuleCall();
                            	    	    

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop83;
                                }
                            } while (true);


                            }


                            }
                            break;
                        case 2 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3407:6: ( (lv_clause_6_0= ruleClause ) )+
                            {
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3407:6: ( (lv_clause_6_0= ruleClause ) )+
                            int cnt84=0;
                            loop84:
                            do {
                                int alt84=2;
                                int LA84_0 = input.LA(1);

                                if ( ((LA84_0>=130 && LA84_0<=131)) ) {
                                    alt84=1;
                                }


                                switch (alt84) {
                            	case 1 :
                            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3408:1: (lv_clause_6_0= ruleClause )
                            	    {
                            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3408:1: (lv_clause_6_0= ruleClause )
                            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3409:3: lv_clause_6_0= ruleClause
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getLandingPadAccess().getClauseClauseParserRuleCall_0_4_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleClause_in_ruleLandingPad7896);
                            	    lv_clause_6_0=ruleClause();

                            	    state._fsp--;


                            	    	        if (current==null) {
                            	    	            current = createModelElementForParent(grammarAccess.getLandingPadRule());
                            	    	        }
                            	           		add(
                            	           			current, 
                            	           			"clause",
                            	            		lv_clause_6_0, 
                            	            		"Clause");
                            	    	        afterParserOrEnumRuleCall();
                            	    	    

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt84 >= 1 ) break loop84;
                                        EarlyExitException eee =
                                            new EarlyExitException(84, input);
                                        throw eee;
                                }
                                cnt84++;
                            } while (true);


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3426:6: (otherlv_7= 'landingpad' ( (lv_type_8_0= ruleType ) ) otherlv_9= 'personality' ( (lv_personalitytype_10_0= ruleType ) ) ( (lv_personalityfunction_11_0= ruleCAST_TYPE ) ) otherlv_12= '(' ( (lv_value_13_0= ruleType ) ) otherlv_14= '(...)*' this_VAR_TYPE_15= RULE_VAR_TYPE otherlv_16= 'to' ( (lv_castto_17_0= ruleType ) ) otherlv_18= ')' ( (otherlv_19= 'cleanup' ( (lv_clause_20_0= ruleClause ) )* ) | ( (lv_clause_21_0= ruleClause ) )+ ) )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3426:6: (otherlv_7= 'landingpad' ( (lv_type_8_0= ruleType ) ) otherlv_9= 'personality' ( (lv_personalitytype_10_0= ruleType ) ) ( (lv_personalityfunction_11_0= ruleCAST_TYPE ) ) otherlv_12= '(' ( (lv_value_13_0= ruleType ) ) otherlv_14= '(...)*' this_VAR_TYPE_15= RULE_VAR_TYPE otherlv_16= 'to' ( (lv_castto_17_0= ruleType ) ) otherlv_18= ')' ( (otherlv_19= 'cleanup' ( (lv_clause_20_0= ruleClause ) )* ) | ( (lv_clause_21_0= ruleClause ) )+ ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3426:8: otherlv_7= 'landingpad' ( (lv_type_8_0= ruleType ) ) otherlv_9= 'personality' ( (lv_personalitytype_10_0= ruleType ) ) ( (lv_personalityfunction_11_0= ruleCAST_TYPE ) ) otherlv_12= '(' ( (lv_value_13_0= ruleType ) ) otherlv_14= '(...)*' this_VAR_TYPE_15= RULE_VAR_TYPE otherlv_16= 'to' ( (lv_castto_17_0= ruleType ) ) otherlv_18= ')' ( (otherlv_19= 'cleanup' ( (lv_clause_20_0= ruleClause ) )* ) | ( (lv_clause_21_0= ruleClause ) )+ )
                    {
                    otherlv_7=(Token)match(input,125,FOLLOW_125_in_ruleLandingPad7918); 

                        	newLeafNode(otherlv_7, grammarAccess.getLandingPadAccess().getLandingpadKeyword_1_0());
                        
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3430:1: ( (lv_type_8_0= ruleType ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3431:1: (lv_type_8_0= ruleType )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3431:1: (lv_type_8_0= ruleType )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3432:3: lv_type_8_0= ruleType
                    {
                     
                    	        newCompositeNode(grammarAccess.getLandingPadAccess().getTypeTypeParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleType_in_ruleLandingPad7939);
                    lv_type_8_0=ruleType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLandingPadRule());
                    	        }
                           		set(
                           			current, 
                           			"type",
                            		lv_type_8_0, 
                            		"Type");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_9=(Token)match(input,126,FOLLOW_126_in_ruleLandingPad7951); 

                        	newLeafNode(otherlv_9, grammarAccess.getLandingPadAccess().getPersonalityKeyword_1_2());
                        
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3452:1: ( (lv_personalitytype_10_0= ruleType ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3453:1: (lv_personalitytype_10_0= ruleType )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3453:1: (lv_personalitytype_10_0= ruleType )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3454:3: lv_personalitytype_10_0= ruleType
                    {
                     
                    	        newCompositeNode(grammarAccess.getLandingPadAccess().getPersonalitytypeTypeParserRuleCall_1_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleType_in_ruleLandingPad7972);
                    lv_personalitytype_10_0=ruleType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLandingPadRule());
                    	        }
                           		set(
                           			current, 
                           			"personalitytype",
                            		lv_personalitytype_10_0, 
                            		"Type");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3470:2: ( (lv_personalityfunction_11_0= ruleCAST_TYPE ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3471:1: (lv_personalityfunction_11_0= ruleCAST_TYPE )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3471:1: (lv_personalityfunction_11_0= ruleCAST_TYPE )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3472:3: lv_personalityfunction_11_0= ruleCAST_TYPE
                    {
                     
                    	        newCompositeNode(grammarAccess.getLandingPadAccess().getPersonalityfunctionCAST_TYPEParserRuleCall_1_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleCAST_TYPE_in_ruleLandingPad7993);
                    lv_personalityfunction_11_0=ruleCAST_TYPE();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLandingPadRule());
                    	        }
                           		set(
                           			current, 
                           			"personalityfunction",
                            		lv_personalityfunction_11_0, 
                            		"CAST_TYPE");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_12=(Token)match(input,30,FOLLOW_30_in_ruleLandingPad8005); 

                        	newLeafNode(otherlv_12, grammarAccess.getLandingPadAccess().getLeftParenthesisKeyword_1_5());
                        
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3492:1: ( (lv_value_13_0= ruleType ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3493:1: (lv_value_13_0= ruleType )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3493:1: (lv_value_13_0= ruleType )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3494:3: lv_value_13_0= ruleType
                    {
                     
                    	        newCompositeNode(grammarAccess.getLandingPadAccess().getValueTypeParserRuleCall_1_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleType_in_ruleLandingPad8026);
                    lv_value_13_0=ruleType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLandingPadRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_13_0, 
                            		"Type");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_14=(Token)match(input,128,FOLLOW_128_in_ruleLandingPad8038); 

                        	newLeafNode(otherlv_14, grammarAccess.getLandingPadAccess().getLeftParenthesisFullStopFullStopFullStopRightParenthesisAsteriskKeyword_1_7());
                        
                    this_VAR_TYPE_15=(Token)match(input,RULE_VAR_TYPE,FOLLOW_RULE_VAR_TYPE_in_ruleLandingPad8049); 
                     
                        newLeafNode(this_VAR_TYPE_15, grammarAccess.getLandingPadAccess().getVAR_TYPETerminalRuleCall_1_8()); 
                        
                    otherlv_16=(Token)match(input,129,FOLLOW_129_in_ruleLandingPad8060); 

                        	newLeafNode(otherlv_16, grammarAccess.getLandingPadAccess().getToKeyword_1_9());
                        
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3522:1: ( (lv_castto_17_0= ruleType ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3523:1: (lv_castto_17_0= ruleType )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3523:1: (lv_castto_17_0= ruleType )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3524:3: lv_castto_17_0= ruleType
                    {
                     
                    	        newCompositeNode(grammarAccess.getLandingPadAccess().getCasttoTypeParserRuleCall_1_10_0()); 
                    	    
                    pushFollow(FOLLOW_ruleType_in_ruleLandingPad8081);
                    lv_castto_17_0=ruleType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLandingPadRule());
                    	        }
                           		set(
                           			current, 
                           			"castto",
                            		lv_castto_17_0, 
                            		"Type");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_18=(Token)match(input,31,FOLLOW_31_in_ruleLandingPad8093); 

                        	newLeafNode(otherlv_18, grammarAccess.getLandingPadAccess().getRightParenthesisKeyword_1_11());
                        
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3544:1: ( (otherlv_19= 'cleanup' ( (lv_clause_20_0= ruleClause ) )* ) | ( (lv_clause_21_0= ruleClause ) )+ )
                    int alt88=2;
                    int LA88_0 = input.LA(1);

                    if ( (LA88_0==127) ) {
                        alt88=1;
                    }
                    else if ( ((LA88_0>=130 && LA88_0<=131)) ) {
                        alt88=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 88, 0, input);

                        throw nvae;
                    }
                    switch (alt88) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3544:2: (otherlv_19= 'cleanup' ( (lv_clause_20_0= ruleClause ) )* )
                            {
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3544:2: (otherlv_19= 'cleanup' ( (lv_clause_20_0= ruleClause ) )* )
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3544:4: otherlv_19= 'cleanup' ( (lv_clause_20_0= ruleClause ) )*
                            {
                            otherlv_19=(Token)match(input,127,FOLLOW_127_in_ruleLandingPad8107); 

                                	newLeafNode(otherlv_19, grammarAccess.getLandingPadAccess().getCleanupKeyword_1_12_0_0());
                                
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3548:1: ( (lv_clause_20_0= ruleClause ) )*
                            loop86:
                            do {
                                int alt86=2;
                                int LA86_0 = input.LA(1);

                                if ( ((LA86_0>=130 && LA86_0<=131)) ) {
                                    alt86=1;
                                }


                                switch (alt86) {
                            	case 1 :
                            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3549:1: (lv_clause_20_0= ruleClause )
                            	    {
                            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3549:1: (lv_clause_20_0= ruleClause )
                            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3550:3: lv_clause_20_0= ruleClause
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getLandingPadAccess().getClauseClauseParserRuleCall_1_12_0_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleClause_in_ruleLandingPad8128);
                            	    lv_clause_20_0=ruleClause();

                            	    state._fsp--;


                            	    	        if (current==null) {
                            	    	            current = createModelElementForParent(grammarAccess.getLandingPadRule());
                            	    	        }
                            	           		add(
                            	           			current, 
                            	           			"clause",
                            	            		lv_clause_20_0, 
                            	            		"Clause");
                            	    	        afterParserOrEnumRuleCall();
                            	    	    

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop86;
                                }
                            } while (true);


                            }


                            }
                            break;
                        case 2 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3567:6: ( (lv_clause_21_0= ruleClause ) )+
                            {
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3567:6: ( (lv_clause_21_0= ruleClause ) )+
                            int cnt87=0;
                            loop87:
                            do {
                                int alt87=2;
                                int LA87_0 = input.LA(1);

                                if ( ((LA87_0>=130 && LA87_0<=131)) ) {
                                    alt87=1;
                                }


                                switch (alt87) {
                            	case 1 :
                            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3568:1: (lv_clause_21_0= ruleClause )
                            	    {
                            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3568:1: (lv_clause_21_0= ruleClause )
                            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3569:3: lv_clause_21_0= ruleClause
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getLandingPadAccess().getClauseClauseParserRuleCall_1_12_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleClause_in_ruleLandingPad8157);
                            	    lv_clause_21_0=ruleClause();

                            	    state._fsp--;


                            	    	        if (current==null) {
                            	    	            current = createModelElementForParent(grammarAccess.getLandingPadRule());
                            	    	        }
                            	           		add(
                            	           			current, 
                            	           			"clause",
                            	            		lv_clause_21_0, 
                            	            		"Clause");
                            	    	        afterParserOrEnumRuleCall();
                            	    	    

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt87 >= 1 ) break loop87;
                                        EarlyExitException eee =
                                            new EarlyExitException(87, input);
                                        throw eee;
                                }
                                cnt87++;
                            } while (true);


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLandingPad"


    // $ANTLR start "entryRuleClause"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3593:1: entryRuleClause returns [EObject current=null] : iv_ruleClause= ruleClause EOF ;
    public final EObject entryRuleClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClause = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3594:2: (iv_ruleClause= ruleClause EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3595:2: iv_ruleClause= ruleClause EOF
            {
             newCompositeNode(grammarAccess.getClauseRule()); 
            pushFollow(FOLLOW_ruleClause_in_entryRuleClause8196);
            iv_ruleClause=ruleClause();

            state._fsp--;

             current =iv_ruleClause; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleClause8206); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClause"


    // $ANTLR start "ruleClause"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3602:1: ruleClause returns [EObject current=null] : ( (otherlv_0= 'catch' this_TypeAndValue_1= ruleTypeAndValue ) | (otherlv_2= 'filter' ( (lv_filter_3_0= ruleTypeAndValue ) ) (otherlv_4= ',' ( (lv_filter_5_0= ruleTypeAndValue ) ) )* ) ) ;
    public final EObject ruleClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_TypeAndValue_1 = null;

        EObject lv_filter_3_0 = null;

        EObject lv_filter_5_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3605:28: ( ( (otherlv_0= 'catch' this_TypeAndValue_1= ruleTypeAndValue ) | (otherlv_2= 'filter' ( (lv_filter_3_0= ruleTypeAndValue ) ) (otherlv_4= ',' ( (lv_filter_5_0= ruleTypeAndValue ) ) )* ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3606:1: ( (otherlv_0= 'catch' this_TypeAndValue_1= ruleTypeAndValue ) | (otherlv_2= 'filter' ( (lv_filter_3_0= ruleTypeAndValue ) ) (otherlv_4= ',' ( (lv_filter_5_0= ruleTypeAndValue ) ) )* ) )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3606:1: ( (otherlv_0= 'catch' this_TypeAndValue_1= ruleTypeAndValue ) | (otherlv_2= 'filter' ( (lv_filter_3_0= ruleTypeAndValue ) ) (otherlv_4= ',' ( (lv_filter_5_0= ruleTypeAndValue ) ) )* ) )
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==130) ) {
                alt91=1;
            }
            else if ( (LA91_0==131) ) {
                alt91=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;
            }
            switch (alt91) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3606:2: (otherlv_0= 'catch' this_TypeAndValue_1= ruleTypeAndValue )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3606:2: (otherlv_0= 'catch' this_TypeAndValue_1= ruleTypeAndValue )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3606:4: otherlv_0= 'catch' this_TypeAndValue_1= ruleTypeAndValue
                    {
                    otherlv_0=(Token)match(input,130,FOLLOW_130_in_ruleClause8244); 

                        	newLeafNode(otherlv_0, grammarAccess.getClauseAccess().getCatchKeyword_0_0());
                        
                     
                            newCompositeNode(grammarAccess.getClauseAccess().getTypeAndValueParserRuleCall_0_1()); 
                        
                    pushFollow(FOLLOW_ruleTypeAndValue_in_ruleClause8266);
                    this_TypeAndValue_1=ruleTypeAndValue();

                    state._fsp--;

                     
                            current = this_TypeAndValue_1; 
                            afterParserOrEnumRuleCall();
                        

                    }


                    }
                    break;
                case 2 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3620:6: (otherlv_2= 'filter' ( (lv_filter_3_0= ruleTypeAndValue ) ) (otherlv_4= ',' ( (lv_filter_5_0= ruleTypeAndValue ) ) )* )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3620:6: (otherlv_2= 'filter' ( (lv_filter_3_0= ruleTypeAndValue ) ) (otherlv_4= ',' ( (lv_filter_5_0= ruleTypeAndValue ) ) )* )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3620:8: otherlv_2= 'filter' ( (lv_filter_3_0= ruleTypeAndValue ) ) (otherlv_4= ',' ( (lv_filter_5_0= ruleTypeAndValue ) ) )*
                    {
                    otherlv_2=(Token)match(input,131,FOLLOW_131_in_ruleClause8285); 

                        	newLeafNode(otherlv_2, grammarAccess.getClauseAccess().getFilterKeyword_1_0());
                        
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3624:1: ( (lv_filter_3_0= ruleTypeAndValue ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3625:1: (lv_filter_3_0= ruleTypeAndValue )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3625:1: (lv_filter_3_0= ruleTypeAndValue )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3626:3: lv_filter_3_0= ruleTypeAndValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getClauseAccess().getFilterTypeAndValueParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTypeAndValue_in_ruleClause8306);
                    lv_filter_3_0=ruleTypeAndValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getClauseRule());
                    	        }
                           		add(
                           			current, 
                           			"filter",
                            		lv_filter_3_0, 
                            		"TypeAndValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3642:2: (otherlv_4= ',' ( (lv_filter_5_0= ruleTypeAndValue ) ) )*
                    loop90:
                    do {
                        int alt90=2;
                        int LA90_0 = input.LA(1);

                        if ( (LA90_0==23) ) {
                            alt90=1;
                        }


                        switch (alt90) {
                    	case 1 :
                    	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3642:4: otherlv_4= ',' ( (lv_filter_5_0= ruleTypeAndValue ) )
                    	    {
                    	    otherlv_4=(Token)match(input,23,FOLLOW_23_in_ruleClause8319); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getClauseAccess().getCommaKeyword_1_2_0());
                    	        
                    	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3646:1: ( (lv_filter_5_0= ruleTypeAndValue ) )
                    	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3647:1: (lv_filter_5_0= ruleTypeAndValue )
                    	    {
                    	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3647:1: (lv_filter_5_0= ruleTypeAndValue )
                    	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3648:3: lv_filter_5_0= ruleTypeAndValue
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getClauseAccess().getFilterTypeAndValueParserRuleCall_1_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleTypeAndValue_in_ruleClause8340);
                    	    lv_filter_5_0=ruleTypeAndValue();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getClauseRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"filter",
                    	            		lv_filter_5_0, 
                    	            		"TypeAndValue");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop90;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClause"


    // $ANTLR start "entryRuleSelect"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3672:1: entryRuleSelect returns [EObject current=null] : iv_ruleSelect= ruleSelect EOF ;
    public final EObject entryRuleSelect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelect = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3673:2: (iv_ruleSelect= ruleSelect EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3674:2: iv_ruleSelect= ruleSelect EOF
            {
             newCompositeNode(grammarAccess.getSelectRule()); 
            pushFollow(FOLLOW_ruleSelect_in_entryRuleSelect8379);
            iv_ruleSelect=ruleSelect();

            state._fsp--;

             current =iv_ruleSelect; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelect8389); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSelect"


    // $ANTLR start "ruleSelect"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3681:1: ruleSelect returns [EObject current=null] : (otherlv_0= 'select' ( (lv_condition_1_0= ruleTypeAndValue ) ) otherlv_2= ',' ( (lv_val1_3_0= ruleTypeAndValue ) ) otherlv_4= ',' ( (lv_val2_5_0= ruleTypeAndValue ) ) ) ;
    public final EObject ruleSelect() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_condition_1_0 = null;

        EObject lv_val1_3_0 = null;

        EObject lv_val2_5_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3684:28: ( (otherlv_0= 'select' ( (lv_condition_1_0= ruleTypeAndValue ) ) otherlv_2= ',' ( (lv_val1_3_0= ruleTypeAndValue ) ) otherlv_4= ',' ( (lv_val2_5_0= ruleTypeAndValue ) ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3685:1: (otherlv_0= 'select' ( (lv_condition_1_0= ruleTypeAndValue ) ) otherlv_2= ',' ( (lv_val1_3_0= ruleTypeAndValue ) ) otherlv_4= ',' ( (lv_val2_5_0= ruleTypeAndValue ) ) )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3685:1: (otherlv_0= 'select' ( (lv_condition_1_0= ruleTypeAndValue ) ) otherlv_2= ',' ( (lv_val1_3_0= ruleTypeAndValue ) ) otherlv_4= ',' ( (lv_val2_5_0= ruleTypeAndValue ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3685:3: otherlv_0= 'select' ( (lv_condition_1_0= ruleTypeAndValue ) ) otherlv_2= ',' ( (lv_val1_3_0= ruleTypeAndValue ) ) otherlv_4= ',' ( (lv_val2_5_0= ruleTypeAndValue ) )
            {
            otherlv_0=(Token)match(input,132,FOLLOW_132_in_ruleSelect8426); 

                	newLeafNode(otherlv_0, grammarAccess.getSelectAccess().getSelectKeyword_0());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3689:1: ( (lv_condition_1_0= ruleTypeAndValue ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3690:1: (lv_condition_1_0= ruleTypeAndValue )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3690:1: (lv_condition_1_0= ruleTypeAndValue )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3691:3: lv_condition_1_0= ruleTypeAndValue
            {
             
            	        newCompositeNode(grammarAccess.getSelectAccess().getConditionTypeAndValueParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleTypeAndValue_in_ruleSelect8447);
            lv_condition_1_0=ruleTypeAndValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSelectRule());
            	        }
                   		set(
                   			current, 
                   			"condition",
                    		lv_condition_1_0, 
                    		"TypeAndValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,23,FOLLOW_23_in_ruleSelect8459); 

                	newLeafNode(otherlv_2, grammarAccess.getSelectAccess().getCommaKeyword_2());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3711:1: ( (lv_val1_3_0= ruleTypeAndValue ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3712:1: (lv_val1_3_0= ruleTypeAndValue )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3712:1: (lv_val1_3_0= ruleTypeAndValue )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3713:3: lv_val1_3_0= ruleTypeAndValue
            {
             
            	        newCompositeNode(grammarAccess.getSelectAccess().getVal1TypeAndValueParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleTypeAndValue_in_ruleSelect8480);
            lv_val1_3_0=ruleTypeAndValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSelectRule());
            	        }
                   		set(
                   			current, 
                   			"val1",
                    		lv_val1_3_0, 
                    		"TypeAndValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,23,FOLLOW_23_in_ruleSelect8492); 

                	newLeafNode(otherlv_4, grammarAccess.getSelectAccess().getCommaKeyword_4());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3733:1: ( (lv_val2_5_0= ruleTypeAndValue ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3734:1: (lv_val2_5_0= ruleTypeAndValue )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3734:1: (lv_val2_5_0= ruleTypeAndValue )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3735:3: lv_val2_5_0= ruleTypeAndValue
            {
             
            	        newCompositeNode(grammarAccess.getSelectAccess().getVal2TypeAndValueParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleTypeAndValue_in_ruleSelect8513);
            lv_val2_5_0=ruleTypeAndValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSelectRule());
            	        }
                   		set(
                   			current, 
                   			"val2",
                    		lv_val2_5_0, 
                    		"TypeAndValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSelect"


    // $ANTLR start "entryRuleVA_Arg"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3759:1: entryRuleVA_Arg returns [EObject current=null] : iv_ruleVA_Arg= ruleVA_Arg EOF ;
    public final EObject entryRuleVA_Arg() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVA_Arg = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3760:2: (iv_ruleVA_Arg= ruleVA_Arg EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3761:2: iv_ruleVA_Arg= ruleVA_Arg EOF
            {
             newCompositeNode(grammarAccess.getVA_ArgRule()); 
            pushFollow(FOLLOW_ruleVA_Arg_in_entryRuleVA_Arg8549);
            iv_ruleVA_Arg=ruleVA_Arg();

            state._fsp--;

             current =iv_ruleVA_Arg; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVA_Arg8559); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVA_Arg"


    // $ANTLR start "ruleVA_Arg"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3768:1: ruleVA_Arg returns [EObject current=null] : (otherlv_0= 'va_arg' ( (lv_list_1_0= ruleTypeAndValue ) ) otherlv_2= ',' ( (lv_argType_3_0= ruleType ) ) ) ;
    public final EObject ruleVA_Arg() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_list_1_0 = null;

        AntlrDatatypeRuleToken lv_argType_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3771:28: ( (otherlv_0= 'va_arg' ( (lv_list_1_0= ruleTypeAndValue ) ) otherlv_2= ',' ( (lv_argType_3_0= ruleType ) ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3772:1: (otherlv_0= 'va_arg' ( (lv_list_1_0= ruleTypeAndValue ) ) otherlv_2= ',' ( (lv_argType_3_0= ruleType ) ) )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3772:1: (otherlv_0= 'va_arg' ( (lv_list_1_0= ruleTypeAndValue ) ) otherlv_2= ',' ( (lv_argType_3_0= ruleType ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3772:3: otherlv_0= 'va_arg' ( (lv_list_1_0= ruleTypeAndValue ) ) otherlv_2= ',' ( (lv_argType_3_0= ruleType ) )
            {
            otherlv_0=(Token)match(input,133,FOLLOW_133_in_ruleVA_Arg8596); 

                	newLeafNode(otherlv_0, grammarAccess.getVA_ArgAccess().getVa_argKeyword_0());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3776:1: ( (lv_list_1_0= ruleTypeAndValue ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3777:1: (lv_list_1_0= ruleTypeAndValue )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3777:1: (lv_list_1_0= ruleTypeAndValue )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3778:3: lv_list_1_0= ruleTypeAndValue
            {
             
            	        newCompositeNode(grammarAccess.getVA_ArgAccess().getListTypeAndValueParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleTypeAndValue_in_ruleVA_Arg8617);
            lv_list_1_0=ruleTypeAndValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVA_ArgRule());
            	        }
                   		set(
                   			current, 
                   			"list",
                    		lv_list_1_0, 
                    		"TypeAndValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,23,FOLLOW_23_in_ruleVA_Arg8629); 

                	newLeafNode(otherlv_2, grammarAccess.getVA_ArgAccess().getCommaKeyword_2());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3798:1: ( (lv_argType_3_0= ruleType ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3799:1: (lv_argType_3_0= ruleType )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3799:1: (lv_argType_3_0= ruleType )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3800:3: lv_argType_3_0= ruleType
            {
             
            	        newCompositeNode(grammarAccess.getVA_ArgAccess().getArgTypeTypeParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleType_in_ruleVA_Arg8650);
            lv_argType_3_0=ruleType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVA_ArgRule());
            	        }
                   		set(
                   			current, 
                   			"argType",
                    		lv_argType_3_0, 
                    		"Type");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVA_Arg"


    // $ANTLR start "entryRuleExtractElement"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3824:1: entryRuleExtractElement returns [EObject current=null] : iv_ruleExtractElement= ruleExtractElement EOF ;
    public final EObject entryRuleExtractElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtractElement = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3825:2: (iv_ruleExtractElement= ruleExtractElement EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3826:2: iv_ruleExtractElement= ruleExtractElement EOF
            {
             newCompositeNode(grammarAccess.getExtractElementRule()); 
            pushFollow(FOLLOW_ruleExtractElement_in_entryRuleExtractElement8686);
            iv_ruleExtractElement=ruleExtractElement();

            state._fsp--;

             current =iv_ruleExtractElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExtractElement8696); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExtractElement"


    // $ANTLR start "ruleExtractElement"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3833:1: ruleExtractElement returns [EObject current=null] : (otherlv_0= 'extractelement' ( (lv_vector_1_0= ruleTypeAndValue ) ) otherlv_2= ',' ( (lv_index_3_0= ruleTypeAndValue ) ) ) ;
    public final EObject ruleExtractElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_vector_1_0 = null;

        EObject lv_index_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3836:28: ( (otherlv_0= 'extractelement' ( (lv_vector_1_0= ruleTypeAndValue ) ) otherlv_2= ',' ( (lv_index_3_0= ruleTypeAndValue ) ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3837:1: (otherlv_0= 'extractelement' ( (lv_vector_1_0= ruleTypeAndValue ) ) otherlv_2= ',' ( (lv_index_3_0= ruleTypeAndValue ) ) )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3837:1: (otherlv_0= 'extractelement' ( (lv_vector_1_0= ruleTypeAndValue ) ) otherlv_2= ',' ( (lv_index_3_0= ruleTypeAndValue ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3837:3: otherlv_0= 'extractelement' ( (lv_vector_1_0= ruleTypeAndValue ) ) otherlv_2= ',' ( (lv_index_3_0= ruleTypeAndValue ) )
            {
            otherlv_0=(Token)match(input,134,FOLLOW_134_in_ruleExtractElement8733); 

                	newLeafNode(otherlv_0, grammarAccess.getExtractElementAccess().getExtractelementKeyword_0());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3841:1: ( (lv_vector_1_0= ruleTypeAndValue ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3842:1: (lv_vector_1_0= ruleTypeAndValue )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3842:1: (lv_vector_1_0= ruleTypeAndValue )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3843:3: lv_vector_1_0= ruleTypeAndValue
            {
             
            	        newCompositeNode(grammarAccess.getExtractElementAccess().getVectorTypeAndValueParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleTypeAndValue_in_ruleExtractElement8754);
            lv_vector_1_0=ruleTypeAndValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExtractElementRule());
            	        }
                   		set(
                   			current, 
                   			"vector",
                    		lv_vector_1_0, 
                    		"TypeAndValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,23,FOLLOW_23_in_ruleExtractElement8766); 

                	newLeafNode(otherlv_2, grammarAccess.getExtractElementAccess().getCommaKeyword_2());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3863:1: ( (lv_index_3_0= ruleTypeAndValue ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3864:1: (lv_index_3_0= ruleTypeAndValue )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3864:1: (lv_index_3_0= ruleTypeAndValue )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3865:3: lv_index_3_0= ruleTypeAndValue
            {
             
            	        newCompositeNode(grammarAccess.getExtractElementAccess().getIndexTypeAndValueParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleTypeAndValue_in_ruleExtractElement8787);
            lv_index_3_0=ruleTypeAndValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExtractElementRule());
            	        }
                   		set(
                   			current, 
                   			"index",
                    		lv_index_3_0, 
                    		"TypeAndValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExtractElement"


    // $ANTLR start "entryRuleInsertElement"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3889:1: entryRuleInsertElement returns [EObject current=null] : iv_ruleInsertElement= ruleInsertElement EOF ;
    public final EObject entryRuleInsertElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInsertElement = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3890:2: (iv_ruleInsertElement= ruleInsertElement EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3891:2: iv_ruleInsertElement= ruleInsertElement EOF
            {
             newCompositeNode(grammarAccess.getInsertElementRule()); 
            pushFollow(FOLLOW_ruleInsertElement_in_entryRuleInsertElement8823);
            iv_ruleInsertElement=ruleInsertElement();

            state._fsp--;

             current =iv_ruleInsertElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInsertElement8833); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInsertElement"


    // $ANTLR start "ruleInsertElement"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3898:1: ruleInsertElement returns [EObject current=null] : (otherlv_0= 'insertelement' ( (lv_vector_1_0= ruleTypeAndValue ) ) otherlv_2= ',' ( (lv_scalar_3_0= ruleTypeAndValue ) ) otherlv_4= ',' ( (lv_index_5_0= ruleTypeAndValue ) ) ) ;
    public final EObject ruleInsertElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_vector_1_0 = null;

        EObject lv_scalar_3_0 = null;

        EObject lv_index_5_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3901:28: ( (otherlv_0= 'insertelement' ( (lv_vector_1_0= ruleTypeAndValue ) ) otherlv_2= ',' ( (lv_scalar_3_0= ruleTypeAndValue ) ) otherlv_4= ',' ( (lv_index_5_0= ruleTypeAndValue ) ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3902:1: (otherlv_0= 'insertelement' ( (lv_vector_1_0= ruleTypeAndValue ) ) otherlv_2= ',' ( (lv_scalar_3_0= ruleTypeAndValue ) ) otherlv_4= ',' ( (lv_index_5_0= ruleTypeAndValue ) ) )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3902:1: (otherlv_0= 'insertelement' ( (lv_vector_1_0= ruleTypeAndValue ) ) otherlv_2= ',' ( (lv_scalar_3_0= ruleTypeAndValue ) ) otherlv_4= ',' ( (lv_index_5_0= ruleTypeAndValue ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3902:3: otherlv_0= 'insertelement' ( (lv_vector_1_0= ruleTypeAndValue ) ) otherlv_2= ',' ( (lv_scalar_3_0= ruleTypeAndValue ) ) otherlv_4= ',' ( (lv_index_5_0= ruleTypeAndValue ) )
            {
            otherlv_0=(Token)match(input,135,FOLLOW_135_in_ruleInsertElement8870); 

                	newLeafNode(otherlv_0, grammarAccess.getInsertElementAccess().getInsertelementKeyword_0());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3906:1: ( (lv_vector_1_0= ruleTypeAndValue ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3907:1: (lv_vector_1_0= ruleTypeAndValue )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3907:1: (lv_vector_1_0= ruleTypeAndValue )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3908:3: lv_vector_1_0= ruleTypeAndValue
            {
             
            	        newCompositeNode(grammarAccess.getInsertElementAccess().getVectorTypeAndValueParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleTypeAndValue_in_ruleInsertElement8891);
            lv_vector_1_0=ruleTypeAndValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInsertElementRule());
            	        }
                   		set(
                   			current, 
                   			"vector",
                    		lv_vector_1_0, 
                    		"TypeAndValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,23,FOLLOW_23_in_ruleInsertElement8903); 

                	newLeafNode(otherlv_2, grammarAccess.getInsertElementAccess().getCommaKeyword_2());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3928:1: ( (lv_scalar_3_0= ruleTypeAndValue ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3929:1: (lv_scalar_3_0= ruleTypeAndValue )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3929:1: (lv_scalar_3_0= ruleTypeAndValue )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3930:3: lv_scalar_3_0= ruleTypeAndValue
            {
             
            	        newCompositeNode(grammarAccess.getInsertElementAccess().getScalarTypeAndValueParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleTypeAndValue_in_ruleInsertElement8924);
            lv_scalar_3_0=ruleTypeAndValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInsertElementRule());
            	        }
                   		set(
                   			current, 
                   			"scalar",
                    		lv_scalar_3_0, 
                    		"TypeAndValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,23,FOLLOW_23_in_ruleInsertElement8936); 

                	newLeafNode(otherlv_4, grammarAccess.getInsertElementAccess().getCommaKeyword_4());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3950:1: ( (lv_index_5_0= ruleTypeAndValue ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3951:1: (lv_index_5_0= ruleTypeAndValue )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3951:1: (lv_index_5_0= ruleTypeAndValue )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3952:3: lv_index_5_0= ruleTypeAndValue
            {
             
            	        newCompositeNode(grammarAccess.getInsertElementAccess().getIndexTypeAndValueParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleTypeAndValue_in_ruleInsertElement8957);
            lv_index_5_0=ruleTypeAndValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInsertElementRule());
            	        }
                   		set(
                   			current, 
                   			"index",
                    		lv_index_5_0, 
                    		"TypeAndValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInsertElement"


    // $ANTLR start "entryRuleShuffleVector"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3976:1: entryRuleShuffleVector returns [EObject current=null] : iv_ruleShuffleVector= ruleShuffleVector EOF ;
    public final EObject entryRuleShuffleVector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShuffleVector = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3977:2: (iv_ruleShuffleVector= ruleShuffleVector EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3978:2: iv_ruleShuffleVector= ruleShuffleVector EOF
            {
             newCompositeNode(grammarAccess.getShuffleVectorRule()); 
            pushFollow(FOLLOW_ruleShuffleVector_in_entryRuleShuffleVector8993);
            iv_ruleShuffleVector=ruleShuffleVector();

            state._fsp--;

             current =iv_ruleShuffleVector; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleShuffleVector9003); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleShuffleVector"


    // $ANTLR start "ruleShuffleVector"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3985:1: ruleShuffleVector returns [EObject current=null] : (otherlv_0= 'shufflevector' ( (lv_vector1_1_0= ruleTypeAndValue ) ) otherlv_2= ',' ( (lv_vector2_3_0= ruleTypeAndValue ) ) otherlv_4= ',' ( (lv_mask_5_0= ruleTypeAndValue ) ) ) ;
    public final EObject ruleShuffleVector() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_vector1_1_0 = null;

        EObject lv_vector2_3_0 = null;

        EObject lv_mask_5_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3988:28: ( (otherlv_0= 'shufflevector' ( (lv_vector1_1_0= ruleTypeAndValue ) ) otherlv_2= ',' ( (lv_vector2_3_0= ruleTypeAndValue ) ) otherlv_4= ',' ( (lv_mask_5_0= ruleTypeAndValue ) ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3989:1: (otherlv_0= 'shufflevector' ( (lv_vector1_1_0= ruleTypeAndValue ) ) otherlv_2= ',' ( (lv_vector2_3_0= ruleTypeAndValue ) ) otherlv_4= ',' ( (lv_mask_5_0= ruleTypeAndValue ) ) )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3989:1: (otherlv_0= 'shufflevector' ( (lv_vector1_1_0= ruleTypeAndValue ) ) otherlv_2= ',' ( (lv_vector2_3_0= ruleTypeAndValue ) ) otherlv_4= ',' ( (lv_mask_5_0= ruleTypeAndValue ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3989:3: otherlv_0= 'shufflevector' ( (lv_vector1_1_0= ruleTypeAndValue ) ) otherlv_2= ',' ( (lv_vector2_3_0= ruleTypeAndValue ) ) otherlv_4= ',' ( (lv_mask_5_0= ruleTypeAndValue ) )
            {
            otherlv_0=(Token)match(input,136,FOLLOW_136_in_ruleShuffleVector9040); 

                	newLeafNode(otherlv_0, grammarAccess.getShuffleVectorAccess().getShufflevectorKeyword_0());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3993:1: ( (lv_vector1_1_0= ruleTypeAndValue ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3994:1: (lv_vector1_1_0= ruleTypeAndValue )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3994:1: (lv_vector1_1_0= ruleTypeAndValue )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:3995:3: lv_vector1_1_0= ruleTypeAndValue
            {
             
            	        newCompositeNode(grammarAccess.getShuffleVectorAccess().getVector1TypeAndValueParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleTypeAndValue_in_ruleShuffleVector9061);
            lv_vector1_1_0=ruleTypeAndValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getShuffleVectorRule());
            	        }
                   		set(
                   			current, 
                   			"vector1",
                    		lv_vector1_1_0, 
                    		"TypeAndValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,23,FOLLOW_23_in_ruleShuffleVector9073); 

                	newLeafNode(otherlv_2, grammarAccess.getShuffleVectorAccess().getCommaKeyword_2());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4015:1: ( (lv_vector2_3_0= ruleTypeAndValue ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4016:1: (lv_vector2_3_0= ruleTypeAndValue )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4016:1: (lv_vector2_3_0= ruleTypeAndValue )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4017:3: lv_vector2_3_0= ruleTypeAndValue
            {
             
            	        newCompositeNode(grammarAccess.getShuffleVectorAccess().getVector2TypeAndValueParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleTypeAndValue_in_ruleShuffleVector9094);
            lv_vector2_3_0=ruleTypeAndValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getShuffleVectorRule());
            	        }
                   		set(
                   			current, 
                   			"vector2",
                    		lv_vector2_3_0, 
                    		"TypeAndValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,23,FOLLOW_23_in_ruleShuffleVector9106); 

                	newLeafNode(otherlv_4, grammarAccess.getShuffleVectorAccess().getCommaKeyword_4());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4037:1: ( (lv_mask_5_0= ruleTypeAndValue ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4038:1: (lv_mask_5_0= ruleTypeAndValue )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4038:1: (lv_mask_5_0= ruleTypeAndValue )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4039:3: lv_mask_5_0= ruleTypeAndValue
            {
             
            	        newCompositeNode(grammarAccess.getShuffleVectorAccess().getMaskTypeAndValueParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleTypeAndValue_in_ruleShuffleVector9127);
            lv_mask_5_0=ruleTypeAndValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getShuffleVectorRule());
            	        }
                   		set(
                   			current, 
                   			"mask",
                    		lv_mask_5_0, 
                    		"TypeAndValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleShuffleVector"


    // $ANTLR start "entryRuleCast"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4063:1: entryRuleCast returns [EObject current=null] : iv_ruleCast= ruleCast EOF ;
    public final EObject entryRuleCast() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCast = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4064:2: (iv_ruleCast= ruleCast EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4065:2: iv_ruleCast= ruleCast EOF
            {
             newCompositeNode(grammarAccess.getCastRule()); 
            pushFollow(FOLLOW_ruleCast_in_entryRuleCast9163);
            iv_ruleCast=ruleCast();

            state._fsp--;

             current =iv_ruleCast; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCast9173); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCast"


    // $ANTLR start "ruleCast"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4072:1: ruleCast returns [EObject current=null] : ( ruleCAST_TYPE ( (lv_value_1_0= ruleTypeAndValue ) ) otherlv_2= 'to' ( (lv_castto_3_0= ruleType ) ) ) ;
    public final EObject ruleCast() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_value_1_0 = null;

        AntlrDatatypeRuleToken lv_castto_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4075:28: ( ( ruleCAST_TYPE ( (lv_value_1_0= ruleTypeAndValue ) ) otherlv_2= 'to' ( (lv_castto_3_0= ruleType ) ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4076:1: ( ruleCAST_TYPE ( (lv_value_1_0= ruleTypeAndValue ) ) otherlv_2= 'to' ( (lv_castto_3_0= ruleType ) ) )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4076:1: ( ruleCAST_TYPE ( (lv_value_1_0= ruleTypeAndValue ) ) otherlv_2= 'to' ( (lv_castto_3_0= ruleType ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4077:5: ruleCAST_TYPE ( (lv_value_1_0= ruleTypeAndValue ) ) otherlv_2= 'to' ( (lv_castto_3_0= ruleType ) )
            {
             
                    newCompositeNode(grammarAccess.getCastAccess().getCAST_TYPEParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleCAST_TYPE_in_ruleCast9214);
            ruleCAST_TYPE();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4084:1: ( (lv_value_1_0= ruleTypeAndValue ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4085:1: (lv_value_1_0= ruleTypeAndValue )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4085:1: (lv_value_1_0= ruleTypeAndValue )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4086:3: lv_value_1_0= ruleTypeAndValue
            {
             
            	        newCompositeNode(grammarAccess.getCastAccess().getValueTypeAndValueParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleTypeAndValue_in_ruleCast9234);
            lv_value_1_0=ruleTypeAndValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCastRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"TypeAndValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,129,FOLLOW_129_in_ruleCast9246); 

                	newLeafNode(otherlv_2, grammarAccess.getCastAccess().getToKeyword_2());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4106:1: ( (lv_castto_3_0= ruleType ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4107:1: (lv_castto_3_0= ruleType )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4107:1: (lv_castto_3_0= ruleType )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4108:3: lv_castto_3_0= ruleType
            {
             
            	        newCompositeNode(grammarAccess.getCastAccess().getCasttoTypeParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleType_in_ruleCast9267);
            lv_castto_3_0=ruleType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCastRule());
            	        }
                   		set(
                   			current, 
                   			"castto",
                    		lv_castto_3_0, 
                    		"Type");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCast"


    // $ANTLR start "entryRuleCAST_TYPE"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4132:1: entryRuleCAST_TYPE returns [String current=null] : iv_ruleCAST_TYPE= ruleCAST_TYPE EOF ;
    public final String entryRuleCAST_TYPE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCAST_TYPE = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4133:2: (iv_ruleCAST_TYPE= ruleCAST_TYPE EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4134:2: iv_ruleCAST_TYPE= ruleCAST_TYPE EOF
            {
             newCompositeNode(grammarAccess.getCAST_TYPERule()); 
            pushFollow(FOLLOW_ruleCAST_TYPE_in_entryRuleCAST_TYPE9304);
            iv_ruleCAST_TYPE=ruleCAST_TYPE();

            state._fsp--;

             current =iv_ruleCAST_TYPE.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCAST_TYPE9315); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCAST_TYPE"


    // $ANTLR start "ruleCAST_TYPE"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4141:1: ruleCAST_TYPE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'trunc' | kw= 'zext' | kw= 'sext' | kw= 'fptrunc' | kw= 'fpext' | kw= 'fptoui' | kw= 'fptosi' | kw= 'uitofp' | kw= 'sitofp' | kw= 'ptrtoint' | kw= 'inttoptr' | kw= 'bitcast' ) ;
    public final AntlrDatatypeRuleToken ruleCAST_TYPE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4144:28: ( (kw= 'trunc' | kw= 'zext' | kw= 'sext' | kw= 'fptrunc' | kw= 'fpext' | kw= 'fptoui' | kw= 'fptosi' | kw= 'uitofp' | kw= 'sitofp' | kw= 'ptrtoint' | kw= 'inttoptr' | kw= 'bitcast' ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4145:1: (kw= 'trunc' | kw= 'zext' | kw= 'sext' | kw= 'fptrunc' | kw= 'fpext' | kw= 'fptoui' | kw= 'fptosi' | kw= 'uitofp' | kw= 'sitofp' | kw= 'ptrtoint' | kw= 'inttoptr' | kw= 'bitcast' )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4145:1: (kw= 'trunc' | kw= 'zext' | kw= 'sext' | kw= 'fptrunc' | kw= 'fpext' | kw= 'fptoui' | kw= 'fptosi' | kw= 'uitofp' | kw= 'sitofp' | kw= 'ptrtoint' | kw= 'inttoptr' | kw= 'bitcast' )
            int alt92=12;
            switch ( input.LA(1) ) {
            case 137:
                {
                alt92=1;
                }
                break;
            case 138:
                {
                alt92=2;
                }
                break;
            case 139:
                {
                alt92=3;
                }
                break;
            case 140:
                {
                alt92=4;
                }
                break;
            case 141:
                {
                alt92=5;
                }
                break;
            case 142:
                {
                alt92=6;
                }
                break;
            case 143:
                {
                alt92=7;
                }
                break;
            case 144:
                {
                alt92=8;
                }
                break;
            case 145:
                {
                alt92=9;
                }
                break;
            case 146:
                {
                alt92=10;
                }
                break;
            case 147:
                {
                alt92=11;
                }
                break;
            case 148:
                {
                alt92=12;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;
            }

            switch (alt92) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4146:2: kw= 'trunc'
                    {
                    kw=(Token)match(input,137,FOLLOW_137_in_ruleCAST_TYPE9353); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCAST_TYPEAccess().getTruncKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4153:2: kw= 'zext'
                    {
                    kw=(Token)match(input,138,FOLLOW_138_in_ruleCAST_TYPE9372); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCAST_TYPEAccess().getZextKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4160:2: kw= 'sext'
                    {
                    kw=(Token)match(input,139,FOLLOW_139_in_ruleCAST_TYPE9391); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCAST_TYPEAccess().getSextKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4167:2: kw= 'fptrunc'
                    {
                    kw=(Token)match(input,140,FOLLOW_140_in_ruleCAST_TYPE9410); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCAST_TYPEAccess().getFptruncKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4174:2: kw= 'fpext'
                    {
                    kw=(Token)match(input,141,FOLLOW_141_in_ruleCAST_TYPE9429); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCAST_TYPEAccess().getFpextKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4181:2: kw= 'fptoui'
                    {
                    kw=(Token)match(input,142,FOLLOW_142_in_ruleCAST_TYPE9448); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCAST_TYPEAccess().getFptouiKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4188:2: kw= 'fptosi'
                    {
                    kw=(Token)match(input,143,FOLLOW_143_in_ruleCAST_TYPE9467); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCAST_TYPEAccess().getFptosiKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4195:2: kw= 'uitofp'
                    {
                    kw=(Token)match(input,144,FOLLOW_144_in_ruleCAST_TYPE9486); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCAST_TYPEAccess().getUitofpKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4202:2: kw= 'sitofp'
                    {
                    kw=(Token)match(input,145,FOLLOW_145_in_ruleCAST_TYPE9505); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCAST_TYPEAccess().getSitofpKeyword_8()); 
                        

                    }
                    break;
                case 10 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4209:2: kw= 'ptrtoint'
                    {
                    kw=(Token)match(input,146,FOLLOW_146_in_ruleCAST_TYPE9524); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCAST_TYPEAccess().getPtrtointKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4216:2: kw= 'inttoptr'
                    {
                    kw=(Token)match(input,147,FOLLOW_147_in_ruleCAST_TYPE9543); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCAST_TYPEAccess().getInttoptrKeyword_10()); 
                        

                    }
                    break;
                case 12 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4223:2: kw= 'bitcast'
                    {
                    kw=(Token)match(input,148,FOLLOW_148_in_ruleCAST_TYPE9562); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCAST_TYPEAccess().getBitcastKeyword_11()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCAST_TYPE"


    // $ANTLR start "entryRuleCompare"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4236:1: entryRuleCompare returns [EObject current=null] : iv_ruleCompare= ruleCompare EOF ;
    public final EObject entryRuleCompare() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompare = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4237:2: (iv_ruleCompare= ruleCompare EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4238:2: iv_ruleCompare= ruleCompare EOF
            {
             newCompositeNode(grammarAccess.getCompareRule()); 
            pushFollow(FOLLOW_ruleCompare_in_entryRuleCompare9602);
            iv_ruleCompare=ruleCompare();

            state._fsp--;

             current =iv_ruleCompare; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCompare9612); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCompare"


    // $ANTLR start "ruleCompare"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4245:1: ruleCompare returns [EObject current=null] : ( (otherlv_0= 'icmp' ruleI_PREDICATES ruleType this_ValuePair_3= ruleValuePair ) | (otherlv_4= 'fcmp' ruleF_PREDICATES ruleType this_ValuePair_7= ruleValuePair ) ) ;
    public final EObject ruleCompare() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        EObject this_ValuePair_3 = null;

        EObject this_ValuePair_7 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4248:28: ( ( (otherlv_0= 'icmp' ruleI_PREDICATES ruleType this_ValuePair_3= ruleValuePair ) | (otherlv_4= 'fcmp' ruleF_PREDICATES ruleType this_ValuePair_7= ruleValuePair ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4249:1: ( (otherlv_0= 'icmp' ruleI_PREDICATES ruleType this_ValuePair_3= ruleValuePair ) | (otherlv_4= 'fcmp' ruleF_PREDICATES ruleType this_ValuePair_7= ruleValuePair ) )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4249:1: ( (otherlv_0= 'icmp' ruleI_PREDICATES ruleType this_ValuePair_3= ruleValuePair ) | (otherlv_4= 'fcmp' ruleF_PREDICATES ruleType this_ValuePair_7= ruleValuePair ) )
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==149) ) {
                alt93=1;
            }
            else if ( (LA93_0==150) ) {
                alt93=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;
            }
            switch (alt93) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4249:2: (otherlv_0= 'icmp' ruleI_PREDICATES ruleType this_ValuePair_3= ruleValuePair )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4249:2: (otherlv_0= 'icmp' ruleI_PREDICATES ruleType this_ValuePair_3= ruleValuePair )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4249:4: otherlv_0= 'icmp' ruleI_PREDICATES ruleType this_ValuePair_3= ruleValuePair
                    {
                    otherlv_0=(Token)match(input,149,FOLLOW_149_in_ruleCompare9650); 

                        	newLeafNode(otherlv_0, grammarAccess.getCompareAccess().getIcmpKeyword_0_0());
                        
                     
                            newCompositeNode(grammarAccess.getCompareAccess().getI_PREDICATESParserRuleCall_0_1()); 
                        
                    pushFollow(FOLLOW_ruleI_PREDICATES_in_ruleCompare9666);
                    ruleI_PREDICATES();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                     
                            newCompositeNode(grammarAccess.getCompareAccess().getTypeParserRuleCall_0_2()); 
                        
                    pushFollow(FOLLOW_ruleType_in_ruleCompare9681);
                    ruleType();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                     
                            newCompositeNode(grammarAccess.getCompareAccess().getValuePairParserRuleCall_0_3()); 
                        
                    pushFollow(FOLLOW_ruleValuePair_in_ruleCompare9702);
                    this_ValuePair_3=ruleValuePair();

                    state._fsp--;

                     
                            current = this_ValuePair_3; 
                            afterParserOrEnumRuleCall();
                        

                    }


                    }
                    break;
                case 2 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4279:6: (otherlv_4= 'fcmp' ruleF_PREDICATES ruleType this_ValuePair_7= ruleValuePair )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4279:6: (otherlv_4= 'fcmp' ruleF_PREDICATES ruleType this_ValuePair_7= ruleValuePair )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4279:8: otherlv_4= 'fcmp' ruleF_PREDICATES ruleType this_ValuePair_7= ruleValuePair
                    {
                    otherlv_4=(Token)match(input,150,FOLLOW_150_in_ruleCompare9721); 

                        	newLeafNode(otherlv_4, grammarAccess.getCompareAccess().getFcmpKeyword_1_0());
                        
                     
                            newCompositeNode(grammarAccess.getCompareAccess().getF_PREDICATESParserRuleCall_1_1()); 
                        
                    pushFollow(FOLLOW_ruleF_PREDICATES_in_ruleCompare9737);
                    ruleF_PREDICATES();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                     
                            newCompositeNode(grammarAccess.getCompareAccess().getTypeParserRuleCall_1_2()); 
                        
                    pushFollow(FOLLOW_ruleType_in_ruleCompare9752);
                    ruleType();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                     
                            newCompositeNode(grammarAccess.getCompareAccess().getValuePairParserRuleCall_1_3()); 
                        
                    pushFollow(FOLLOW_ruleValuePair_in_ruleCompare9773);
                    this_ValuePair_7=ruleValuePair();

                    state._fsp--;

                     
                            current = this_ValuePair_7; 
                            afterParserOrEnumRuleCall();
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompare"


    // $ANTLR start "entryRuleI_PREDICATES"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4316:1: entryRuleI_PREDICATES returns [String current=null] : iv_ruleI_PREDICATES= ruleI_PREDICATES EOF ;
    public final String entryRuleI_PREDICATES() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleI_PREDICATES = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4317:2: (iv_ruleI_PREDICATES= ruleI_PREDICATES EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4318:2: iv_ruleI_PREDICATES= ruleI_PREDICATES EOF
            {
             newCompositeNode(grammarAccess.getI_PREDICATESRule()); 
            pushFollow(FOLLOW_ruleI_PREDICATES_in_entryRuleI_PREDICATES9810);
            iv_ruleI_PREDICATES=ruleI_PREDICATES();

            state._fsp--;

             current =iv_ruleI_PREDICATES.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleI_PREDICATES9821); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleI_PREDICATES"


    // $ANTLR start "ruleI_PREDICATES"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4325:1: ruleI_PREDICATES returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'eq' | kw= 'ne' | kw= 'ugt' | kw= 'uge' | kw= 'ult' | kw= 'ule' | kw= 'sgt' | kw= 'sge' | kw= 'slt' | kw= 'sle' ) ;
    public final AntlrDatatypeRuleToken ruleI_PREDICATES() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4328:28: ( (kw= 'eq' | kw= 'ne' | kw= 'ugt' | kw= 'uge' | kw= 'ult' | kw= 'ule' | kw= 'sgt' | kw= 'sge' | kw= 'slt' | kw= 'sle' ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4329:1: (kw= 'eq' | kw= 'ne' | kw= 'ugt' | kw= 'uge' | kw= 'ult' | kw= 'ule' | kw= 'sgt' | kw= 'sge' | kw= 'slt' | kw= 'sle' )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4329:1: (kw= 'eq' | kw= 'ne' | kw= 'ugt' | kw= 'uge' | kw= 'ult' | kw= 'ule' | kw= 'sgt' | kw= 'sge' | kw= 'slt' | kw= 'sle' )
            int alt94=10;
            switch ( input.LA(1) ) {
            case 151:
                {
                alt94=1;
                }
                break;
            case 152:
                {
                alt94=2;
                }
                break;
            case 153:
                {
                alt94=3;
                }
                break;
            case 154:
                {
                alt94=4;
                }
                break;
            case 155:
                {
                alt94=5;
                }
                break;
            case 156:
                {
                alt94=6;
                }
                break;
            case 157:
                {
                alt94=7;
                }
                break;
            case 158:
                {
                alt94=8;
                }
                break;
            case 159:
                {
                alt94=9;
                }
                break;
            case 160:
                {
                alt94=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;
            }

            switch (alt94) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4330:2: kw= 'eq'
                    {
                    kw=(Token)match(input,151,FOLLOW_151_in_ruleI_PREDICATES9859); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getI_PREDICATESAccess().getEqKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4337:2: kw= 'ne'
                    {
                    kw=(Token)match(input,152,FOLLOW_152_in_ruleI_PREDICATES9878); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getI_PREDICATESAccess().getNeKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4344:2: kw= 'ugt'
                    {
                    kw=(Token)match(input,153,FOLLOW_153_in_ruleI_PREDICATES9897); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getI_PREDICATESAccess().getUgtKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4351:2: kw= 'uge'
                    {
                    kw=(Token)match(input,154,FOLLOW_154_in_ruleI_PREDICATES9916); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getI_PREDICATESAccess().getUgeKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4358:2: kw= 'ult'
                    {
                    kw=(Token)match(input,155,FOLLOW_155_in_ruleI_PREDICATES9935); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getI_PREDICATESAccess().getUltKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4365:2: kw= 'ule'
                    {
                    kw=(Token)match(input,156,FOLLOW_156_in_ruleI_PREDICATES9954); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getI_PREDICATESAccess().getUleKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4372:2: kw= 'sgt'
                    {
                    kw=(Token)match(input,157,FOLLOW_157_in_ruleI_PREDICATES9973); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getI_PREDICATESAccess().getSgtKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4379:2: kw= 'sge'
                    {
                    kw=(Token)match(input,158,FOLLOW_158_in_ruleI_PREDICATES9992); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getI_PREDICATESAccess().getSgeKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4386:2: kw= 'slt'
                    {
                    kw=(Token)match(input,159,FOLLOW_159_in_ruleI_PREDICATES10011); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getI_PREDICATESAccess().getSltKeyword_8()); 
                        

                    }
                    break;
                case 10 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4393:2: kw= 'sle'
                    {
                    kw=(Token)match(input,160,FOLLOW_160_in_ruleI_PREDICATES10030); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getI_PREDICATESAccess().getSleKeyword_9()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleI_PREDICATES"


    // $ANTLR start "entryRuleF_PREDICATES"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4406:1: entryRuleF_PREDICATES returns [String current=null] : iv_ruleF_PREDICATES= ruleF_PREDICATES EOF ;
    public final String entryRuleF_PREDICATES() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleF_PREDICATES = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4407:2: (iv_ruleF_PREDICATES= ruleF_PREDICATES EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4408:2: iv_ruleF_PREDICATES= ruleF_PREDICATES EOF
            {
             newCompositeNode(grammarAccess.getF_PREDICATESRule()); 
            pushFollow(FOLLOW_ruleF_PREDICATES_in_entryRuleF_PREDICATES10071);
            iv_ruleF_PREDICATES=ruleF_PREDICATES();

            state._fsp--;

             current =iv_ruleF_PREDICATES.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleF_PREDICATES10082); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleF_PREDICATES"


    // $ANTLR start "ruleF_PREDICATES"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4415:1: ruleF_PREDICATES returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'false' | kw= 'oeq' | kw= 'ogt' | kw= 'oge' | kw= 'olt' | kw= 'ole' | kw= 'one' | kw= 'ord' | kw= 'ueq' | kw= 'ugt' | kw= 'uge' | kw= 'ult' | kw= 'ule' | kw= 'une' | kw= 'uno' | kw= 'true' ) ;
    public final AntlrDatatypeRuleToken ruleF_PREDICATES() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4418:28: ( (kw= 'false' | kw= 'oeq' | kw= 'ogt' | kw= 'oge' | kw= 'olt' | kw= 'ole' | kw= 'one' | kw= 'ord' | kw= 'ueq' | kw= 'ugt' | kw= 'uge' | kw= 'ult' | kw= 'ule' | kw= 'une' | kw= 'uno' | kw= 'true' ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4419:1: (kw= 'false' | kw= 'oeq' | kw= 'ogt' | kw= 'oge' | kw= 'olt' | kw= 'ole' | kw= 'one' | kw= 'ord' | kw= 'ueq' | kw= 'ugt' | kw= 'uge' | kw= 'ult' | kw= 'ule' | kw= 'une' | kw= 'uno' | kw= 'true' )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4419:1: (kw= 'false' | kw= 'oeq' | kw= 'ogt' | kw= 'oge' | kw= 'olt' | kw= 'ole' | kw= 'one' | kw= 'ord' | kw= 'ueq' | kw= 'ugt' | kw= 'uge' | kw= 'ult' | kw= 'ule' | kw= 'une' | kw= 'uno' | kw= 'true' )
            int alt95=16;
            switch ( input.LA(1) ) {
            case 161:
                {
                alt95=1;
                }
                break;
            case 162:
                {
                alt95=2;
                }
                break;
            case 163:
                {
                alt95=3;
                }
                break;
            case 164:
                {
                alt95=4;
                }
                break;
            case 165:
                {
                alt95=5;
                }
                break;
            case 166:
                {
                alt95=6;
                }
                break;
            case 167:
                {
                alt95=7;
                }
                break;
            case 168:
                {
                alt95=8;
                }
                break;
            case 169:
                {
                alt95=9;
                }
                break;
            case 153:
                {
                alt95=10;
                }
                break;
            case 154:
                {
                alt95=11;
                }
                break;
            case 155:
                {
                alt95=12;
                }
                break;
            case 156:
                {
                alt95=13;
                }
                break;
            case 170:
                {
                alt95=14;
                }
                break;
            case 171:
                {
                alt95=15;
                }
                break;
            case 172:
                {
                alt95=16;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;
            }

            switch (alt95) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4420:2: kw= 'false'
                    {
                    kw=(Token)match(input,161,FOLLOW_161_in_ruleF_PREDICATES10120); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getF_PREDICATESAccess().getFalseKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4427:2: kw= 'oeq'
                    {
                    kw=(Token)match(input,162,FOLLOW_162_in_ruleF_PREDICATES10139); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getF_PREDICATESAccess().getOeqKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4434:2: kw= 'ogt'
                    {
                    kw=(Token)match(input,163,FOLLOW_163_in_ruleF_PREDICATES10158); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getF_PREDICATESAccess().getOgtKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4441:2: kw= 'oge'
                    {
                    kw=(Token)match(input,164,FOLLOW_164_in_ruleF_PREDICATES10177); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getF_PREDICATESAccess().getOgeKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4448:2: kw= 'olt'
                    {
                    kw=(Token)match(input,165,FOLLOW_165_in_ruleF_PREDICATES10196); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getF_PREDICATESAccess().getOltKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4455:2: kw= 'ole'
                    {
                    kw=(Token)match(input,166,FOLLOW_166_in_ruleF_PREDICATES10215); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getF_PREDICATESAccess().getOleKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4462:2: kw= 'one'
                    {
                    kw=(Token)match(input,167,FOLLOW_167_in_ruleF_PREDICATES10234); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getF_PREDICATESAccess().getOneKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4469:2: kw= 'ord'
                    {
                    kw=(Token)match(input,168,FOLLOW_168_in_ruleF_PREDICATES10253); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getF_PREDICATESAccess().getOrdKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4476:2: kw= 'ueq'
                    {
                    kw=(Token)match(input,169,FOLLOW_169_in_ruleF_PREDICATES10272); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getF_PREDICATESAccess().getUeqKeyword_8()); 
                        

                    }
                    break;
                case 10 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4483:2: kw= 'ugt'
                    {
                    kw=(Token)match(input,153,FOLLOW_153_in_ruleF_PREDICATES10291); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getF_PREDICATESAccess().getUgtKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4490:2: kw= 'uge'
                    {
                    kw=(Token)match(input,154,FOLLOW_154_in_ruleF_PREDICATES10310); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getF_PREDICATESAccess().getUgeKeyword_10()); 
                        

                    }
                    break;
                case 12 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4497:2: kw= 'ult'
                    {
                    kw=(Token)match(input,155,FOLLOW_155_in_ruleF_PREDICATES10329); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getF_PREDICATESAccess().getUltKeyword_11()); 
                        

                    }
                    break;
                case 13 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4504:2: kw= 'ule'
                    {
                    kw=(Token)match(input,156,FOLLOW_156_in_ruleF_PREDICATES10348); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getF_PREDICATESAccess().getUleKeyword_12()); 
                        

                    }
                    break;
                case 14 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4511:2: kw= 'une'
                    {
                    kw=(Token)match(input,170,FOLLOW_170_in_ruleF_PREDICATES10367); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getF_PREDICATESAccess().getUneKeyword_13()); 
                        

                    }
                    break;
                case 15 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4518:2: kw= 'uno'
                    {
                    kw=(Token)match(input,171,FOLLOW_171_in_ruleF_PREDICATES10386); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getF_PREDICATESAccess().getUnoKeyword_14()); 
                        

                    }
                    break;
                case 16 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4525:2: kw= 'true'
                    {
                    kw=(Token)match(input,172,FOLLOW_172_in_ruleF_PREDICATES10405); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getF_PREDICATESAccess().getTrueKeyword_15()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleF_PREDICATES"


    // $ANTLR start "entryRuleARITHMETIC_OP"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4538:1: entryRuleARITHMETIC_OP returns [String current=null] : iv_ruleARITHMETIC_OP= ruleARITHMETIC_OP EOF ;
    public final String entryRuleARITHMETIC_OP() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleARITHMETIC_OP = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4539:2: (iv_ruleARITHMETIC_OP= ruleARITHMETIC_OP EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4540:2: iv_ruleARITHMETIC_OP= ruleARITHMETIC_OP EOF
            {
             newCompositeNode(grammarAccess.getARITHMETIC_OPRule()); 
            pushFollow(FOLLOW_ruleARITHMETIC_OP_in_entryRuleARITHMETIC_OP10446);
            iv_ruleARITHMETIC_OP=ruleARITHMETIC_OP();

            state._fsp--;

             current =iv_ruleARITHMETIC_OP.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleARITHMETIC_OP10457); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleARITHMETIC_OP"


    // $ANTLR start "ruleARITHMETIC_OP"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4547:1: ruleARITHMETIC_OP returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'add' | kw= 'fadd' | kw= 'sub' | kw= 'fsub' | kw= 'mul' | kw= 'fmul' | kw= 'udiv' | kw= 'sdiv' | kw= 'fdiv' | kw= 'urem' | kw= 'srem' | kw= 'frem' ) ;
    public final AntlrDatatypeRuleToken ruleARITHMETIC_OP() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4550:28: ( (kw= 'add' | kw= 'fadd' | kw= 'sub' | kw= 'fsub' | kw= 'mul' | kw= 'fmul' | kw= 'udiv' | kw= 'sdiv' | kw= 'fdiv' | kw= 'urem' | kw= 'srem' | kw= 'frem' ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4551:1: (kw= 'add' | kw= 'fadd' | kw= 'sub' | kw= 'fsub' | kw= 'mul' | kw= 'fmul' | kw= 'udiv' | kw= 'sdiv' | kw= 'fdiv' | kw= 'urem' | kw= 'srem' | kw= 'frem' )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4551:1: (kw= 'add' | kw= 'fadd' | kw= 'sub' | kw= 'fsub' | kw= 'mul' | kw= 'fmul' | kw= 'udiv' | kw= 'sdiv' | kw= 'fdiv' | kw= 'urem' | kw= 'srem' | kw= 'frem' )
            int alt96=12;
            switch ( input.LA(1) ) {
            case 64:
                {
                alt96=1;
                }
                break;
            case 173:
                {
                alt96=2;
                }
                break;
            case 65:
                {
                alt96=3;
                }
                break;
            case 174:
                {
                alt96=4;
                }
                break;
            case 175:
                {
                alt96=5;
                }
                break;
            case 176:
                {
                alt96=6;
                }
                break;
            case 177:
                {
                alt96=7;
                }
                break;
            case 178:
                {
                alt96=8;
                }
                break;
            case 179:
                {
                alt96=9;
                }
                break;
            case 180:
                {
                alt96=10;
                }
                break;
            case 181:
                {
                alt96=11;
                }
                break;
            case 182:
                {
                alt96=12;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 96, 0, input);

                throw nvae;
            }

            switch (alt96) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4552:2: kw= 'add'
                    {
                    kw=(Token)match(input,64,FOLLOW_64_in_ruleARITHMETIC_OP10495); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getARITHMETIC_OPAccess().getAddKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4559:2: kw= 'fadd'
                    {
                    kw=(Token)match(input,173,FOLLOW_173_in_ruleARITHMETIC_OP10514); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getARITHMETIC_OPAccess().getFaddKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4566:2: kw= 'sub'
                    {
                    kw=(Token)match(input,65,FOLLOW_65_in_ruleARITHMETIC_OP10533); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getARITHMETIC_OPAccess().getSubKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4573:2: kw= 'fsub'
                    {
                    kw=(Token)match(input,174,FOLLOW_174_in_ruleARITHMETIC_OP10552); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getARITHMETIC_OPAccess().getFsubKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4580:2: kw= 'mul'
                    {
                    kw=(Token)match(input,175,FOLLOW_175_in_ruleARITHMETIC_OP10571); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getARITHMETIC_OPAccess().getMulKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4587:2: kw= 'fmul'
                    {
                    kw=(Token)match(input,176,FOLLOW_176_in_ruleARITHMETIC_OP10590); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getARITHMETIC_OPAccess().getFmulKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4594:2: kw= 'udiv'
                    {
                    kw=(Token)match(input,177,FOLLOW_177_in_ruleARITHMETIC_OP10609); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getARITHMETIC_OPAccess().getUdivKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4601:2: kw= 'sdiv'
                    {
                    kw=(Token)match(input,178,FOLLOW_178_in_ruleARITHMETIC_OP10628); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getARITHMETIC_OPAccess().getSdivKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4608:2: kw= 'fdiv'
                    {
                    kw=(Token)match(input,179,FOLLOW_179_in_ruleARITHMETIC_OP10647); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getARITHMETIC_OPAccess().getFdivKeyword_8()); 
                        

                    }
                    break;
                case 10 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4615:2: kw= 'urem'
                    {
                    kw=(Token)match(input,180,FOLLOW_180_in_ruleARITHMETIC_OP10666); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getARITHMETIC_OPAccess().getUremKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4622:2: kw= 'srem'
                    {
                    kw=(Token)match(input,181,FOLLOW_181_in_ruleARITHMETIC_OP10685); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getARITHMETIC_OPAccess().getSremKeyword_10()); 
                        

                    }
                    break;
                case 12 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4629:2: kw= 'frem'
                    {
                    kw=(Token)match(input,182,FOLLOW_182_in_ruleARITHMETIC_OP10704); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getARITHMETIC_OPAccess().getFremKeyword_11()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleARITHMETIC_OP"


    // $ANTLR start "entryRuleLOGICAL_OP"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4642:1: entryRuleLOGICAL_OP returns [String current=null] : iv_ruleLOGICAL_OP= ruleLOGICAL_OP EOF ;
    public final String entryRuleLOGICAL_OP() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLOGICAL_OP = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4643:2: (iv_ruleLOGICAL_OP= ruleLOGICAL_OP EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4644:2: iv_ruleLOGICAL_OP= ruleLOGICAL_OP EOF
            {
             newCompositeNode(grammarAccess.getLOGICAL_OPRule()); 
            pushFollow(FOLLOW_ruleLOGICAL_OP_in_entryRuleLOGICAL_OP10745);
            iv_ruleLOGICAL_OP=ruleLOGICAL_OP();

            state._fsp--;

             current =iv_ruleLOGICAL_OP.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLOGICAL_OP10756); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLOGICAL_OP"


    // $ANTLR start "ruleLOGICAL_OP"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4651:1: ruleLOGICAL_OP returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'shl' | kw= 'lshr' | kw= 'ashr' | kw= 'and' | kw= 'or' | kw= 'xor' ) ;
    public final AntlrDatatypeRuleToken ruleLOGICAL_OP() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4654:28: ( (kw= 'shl' | kw= 'lshr' | kw= 'ashr' | kw= 'and' | kw= 'or' | kw= 'xor' ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4655:1: (kw= 'shl' | kw= 'lshr' | kw= 'ashr' | kw= 'and' | kw= 'or' | kw= 'xor' )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4655:1: (kw= 'shl' | kw= 'lshr' | kw= 'ashr' | kw= 'and' | kw= 'or' | kw= 'xor' )
            int alt97=6;
            switch ( input.LA(1) ) {
            case 183:
                {
                alt97=1;
                }
                break;
            case 184:
                {
                alt97=2;
                }
                break;
            case 185:
                {
                alt97=3;
                }
                break;
            case 66:
                {
                alt97=4;
                }
                break;
            case 68:
                {
                alt97=5;
                }
                break;
            case 69:
                {
                alt97=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 97, 0, input);

                throw nvae;
            }

            switch (alt97) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4656:2: kw= 'shl'
                    {
                    kw=(Token)match(input,183,FOLLOW_183_in_ruleLOGICAL_OP10794); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLOGICAL_OPAccess().getShlKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4663:2: kw= 'lshr'
                    {
                    kw=(Token)match(input,184,FOLLOW_184_in_ruleLOGICAL_OP10813); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLOGICAL_OPAccess().getLshrKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4670:2: kw= 'ashr'
                    {
                    kw=(Token)match(input,185,FOLLOW_185_in_ruleLOGICAL_OP10832); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLOGICAL_OPAccess().getAshrKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4677:2: kw= 'and'
                    {
                    kw=(Token)match(input,66,FOLLOW_66_in_ruleLOGICAL_OP10851); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLOGICAL_OPAccess().getAndKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4684:2: kw= 'or'
                    {
                    kw=(Token)match(input,68,FOLLOW_68_in_ruleLOGICAL_OP10870); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLOGICAL_OPAccess().getOrKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4691:2: kw= 'xor'
                    {
                    kw=(Token)match(input,69,FOLLOW_69_in_ruleLOGICAL_OP10889); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLOGICAL_OPAccess().getXorKeyword_5()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLOGICAL_OP"


    // $ANTLR start "entryRuleArithmetic"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4704:1: entryRuleArithmetic returns [EObject current=null] : iv_ruleArithmetic= ruleArithmetic EOF ;
    public final EObject entryRuleArithmetic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArithmetic = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4705:2: (iv_ruleArithmetic= ruleArithmetic EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4706:2: iv_ruleArithmetic= ruleArithmetic EOF
            {
             newCompositeNode(grammarAccess.getArithmeticRule()); 
            pushFollow(FOLLOW_ruleArithmetic_in_entryRuleArithmetic10929);
            iv_ruleArithmetic=ruleArithmetic();

            state._fsp--;

             current =iv_ruleArithmetic; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArithmetic10939); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArithmetic"


    // $ANTLR start "ruleArithmetic"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4713:1: ruleArithmetic returns [EObject current=null] : ( ruleARITHMETIC_OP ruleType this_ValuePair_2= ruleValuePair ) ;
    public final EObject ruleArithmetic() throws RecognitionException {
        EObject current = null;

        EObject this_ValuePair_2 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4716:28: ( ( ruleARITHMETIC_OP ruleType this_ValuePair_2= ruleValuePair ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4717:1: ( ruleARITHMETIC_OP ruleType this_ValuePair_2= ruleValuePair )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4717:1: ( ruleARITHMETIC_OP ruleType this_ValuePair_2= ruleValuePair )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4718:5: ruleARITHMETIC_OP ruleType this_ValuePair_2= ruleValuePair
            {
             
                    newCompositeNode(grammarAccess.getArithmeticAccess().getARITHMETIC_OPParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleARITHMETIC_OP_in_ruleArithmetic10980);
            ruleARITHMETIC_OP();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
             
                    newCompositeNode(grammarAccess.getArithmeticAccess().getTypeParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleType_in_ruleArithmetic10995);
            ruleType();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
             
                    newCompositeNode(grammarAccess.getArithmeticAccess().getValuePairParserRuleCall_2()); 
                
            pushFollow(FOLLOW_ruleValuePair_in_ruleArithmetic11016);
            this_ValuePair_2=ruleValuePair();

            state._fsp--;

             
                    current = this_ValuePair_2; 
                    afterParserOrEnumRuleCall();
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArithmetic"


    // $ANTLR start "entryRuleLogical"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4750:1: entryRuleLogical returns [EObject current=null] : iv_ruleLogical= ruleLogical EOF ;
    public final EObject entryRuleLogical() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogical = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4751:2: (iv_ruleLogical= ruleLogical EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4752:2: iv_ruleLogical= ruleLogical EOF
            {
             newCompositeNode(grammarAccess.getLogicalRule()); 
            pushFollow(FOLLOW_ruleLogical_in_entryRuleLogical11051);
            iv_ruleLogical=ruleLogical();

            state._fsp--;

             current =iv_ruleLogical; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogical11061); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogical"


    // $ANTLR start "ruleLogical"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4759:1: ruleLogical returns [EObject current=null] : ( ruleLOGICAL_OP ruleType this_ValuePair_2= ruleValuePair ) ;
    public final EObject ruleLogical() throws RecognitionException {
        EObject current = null;

        EObject this_ValuePair_2 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4762:28: ( ( ruleLOGICAL_OP ruleType this_ValuePair_2= ruleValuePair ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4763:1: ( ruleLOGICAL_OP ruleType this_ValuePair_2= ruleValuePair )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4763:1: ( ruleLOGICAL_OP ruleType this_ValuePair_2= ruleValuePair )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4764:5: ruleLOGICAL_OP ruleType this_ValuePair_2= ruleValuePair
            {
             
                    newCompositeNode(grammarAccess.getLogicalAccess().getLOGICAL_OPParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleLOGICAL_OP_in_ruleLogical11102);
            ruleLOGICAL_OP();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
             
                    newCompositeNode(grammarAccess.getLogicalAccess().getTypeParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleType_in_ruleLogical11117);
            ruleType();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
             
                    newCompositeNode(grammarAccess.getLogicalAccess().getValuePairParserRuleCall_2()); 
                
            pushFollow(FOLLOW_ruleValuePair_in_ruleLogical11138);
            this_ValuePair_2=ruleValuePair();

            state._fsp--;

             
                    current = this_ValuePair_2; 
                    afterParserOrEnumRuleCall();
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogical"


    // $ANTLR start "entryRuleInstruction"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4796:1: entryRuleInstruction returns [EObject current=null] : iv_ruleInstruction= ruleInstruction EOF ;
    public final EObject entryRuleInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstruction = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4797:2: (iv_ruleInstruction= ruleInstruction EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4798:2: iv_ruleInstruction= ruleInstruction EOF
            {
             newCompositeNode(grammarAccess.getInstructionRule()); 
            pushFollow(FOLLOW_ruleInstruction_in_entryRuleInstruction11173);
            iv_ruleInstruction=ruleInstruction();

            state._fsp--;

             current =iv_ruleInstruction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstruction11183); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInstruction"


    // $ANTLR start "ruleInstruction"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4805:1: ruleInstruction returns [EObject current=null] : (this_Switch_0= ruleSwitch | this_IndirectBranch_1= ruleIndirectBranch | this_Branch_2= ruleBranch | this_Return_3= ruleReturn | this_Load_4= ruleLoad | this_Store_5= ruleStore | this_Fence_6= ruleFence | this_GetElementPtr_7= ruleGetElementPtr | this_Logical_8= ruleLogical | this_Arithmetic_9= ruleArithmetic | this_Compare_10= ruleCompare | this_Cast_11= ruleCast | this_ShuffleVector_12= ruleShuffleVector | this_InsertElement_13= ruleInsertElement | this_ExtractElement_14= ruleExtractElement | this_Invoke_15= ruleInvoke | this_Resume_16= ruleResume | this_InsertValue_17= ruleInsertValue | this_ExtractValue_18= ruleExtractValue | this_Alloc_19= ruleAlloc | this_CmpXchg_20= ruleCmpXchg | this_AtomicRMW_21= ruleAtomicRMW | this_PHI_22= rulePHI | this_Select_23= ruleSelect | this_Call_24= ruleCall | this_VA_Arg_25= ruleVA_Arg | this_LandingPad_26= ruleLandingPad | this_LocalVar_27= ruleLocalVar ) ;
    public final EObject ruleInstruction() throws RecognitionException {
        EObject current = null;

        EObject this_Switch_0 = null;

        EObject this_IndirectBranch_1 = null;

        EObject this_Branch_2 = null;

        EObject this_Return_3 = null;

        EObject this_Load_4 = null;

        EObject this_Store_5 = null;

        EObject this_Fence_6 = null;

        EObject this_GetElementPtr_7 = null;

        EObject this_Logical_8 = null;

        EObject this_Arithmetic_9 = null;

        EObject this_Compare_10 = null;

        EObject this_Cast_11 = null;

        EObject this_ShuffleVector_12 = null;

        EObject this_InsertElement_13 = null;

        EObject this_ExtractElement_14 = null;

        EObject this_Invoke_15 = null;

        EObject this_Resume_16 = null;

        EObject this_InsertValue_17 = null;

        EObject this_ExtractValue_18 = null;

        EObject this_Alloc_19 = null;

        EObject this_CmpXchg_20 = null;

        EObject this_AtomicRMW_21 = null;

        EObject this_PHI_22 = null;

        EObject this_Select_23 = null;

        EObject this_Call_24 = null;

        EObject this_VA_Arg_25 = null;

        EObject this_LandingPad_26 = null;

        EObject this_LocalVar_27 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4808:28: ( (this_Switch_0= ruleSwitch | this_IndirectBranch_1= ruleIndirectBranch | this_Branch_2= ruleBranch | this_Return_3= ruleReturn | this_Load_4= ruleLoad | this_Store_5= ruleStore | this_Fence_6= ruleFence | this_GetElementPtr_7= ruleGetElementPtr | this_Logical_8= ruleLogical | this_Arithmetic_9= ruleArithmetic | this_Compare_10= ruleCompare | this_Cast_11= ruleCast | this_ShuffleVector_12= ruleShuffleVector | this_InsertElement_13= ruleInsertElement | this_ExtractElement_14= ruleExtractElement | this_Invoke_15= ruleInvoke | this_Resume_16= ruleResume | this_InsertValue_17= ruleInsertValue | this_ExtractValue_18= ruleExtractValue | this_Alloc_19= ruleAlloc | this_CmpXchg_20= ruleCmpXchg | this_AtomicRMW_21= ruleAtomicRMW | this_PHI_22= rulePHI | this_Select_23= ruleSelect | this_Call_24= ruleCall | this_VA_Arg_25= ruleVA_Arg | this_LandingPad_26= ruleLandingPad | this_LocalVar_27= ruleLocalVar ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4809:1: (this_Switch_0= ruleSwitch | this_IndirectBranch_1= ruleIndirectBranch | this_Branch_2= ruleBranch | this_Return_3= ruleReturn | this_Load_4= ruleLoad | this_Store_5= ruleStore | this_Fence_6= ruleFence | this_GetElementPtr_7= ruleGetElementPtr | this_Logical_8= ruleLogical | this_Arithmetic_9= ruleArithmetic | this_Compare_10= ruleCompare | this_Cast_11= ruleCast | this_ShuffleVector_12= ruleShuffleVector | this_InsertElement_13= ruleInsertElement | this_ExtractElement_14= ruleExtractElement | this_Invoke_15= ruleInvoke | this_Resume_16= ruleResume | this_InsertValue_17= ruleInsertValue | this_ExtractValue_18= ruleExtractValue | this_Alloc_19= ruleAlloc | this_CmpXchg_20= ruleCmpXchg | this_AtomicRMW_21= ruleAtomicRMW | this_PHI_22= rulePHI | this_Select_23= ruleSelect | this_Call_24= ruleCall | this_VA_Arg_25= ruleVA_Arg | this_LandingPad_26= ruleLandingPad | this_LocalVar_27= ruleLocalVar )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4809:1: (this_Switch_0= ruleSwitch | this_IndirectBranch_1= ruleIndirectBranch | this_Branch_2= ruleBranch | this_Return_3= ruleReturn | this_Load_4= ruleLoad | this_Store_5= ruleStore | this_Fence_6= ruleFence | this_GetElementPtr_7= ruleGetElementPtr | this_Logical_8= ruleLogical | this_Arithmetic_9= ruleArithmetic | this_Compare_10= ruleCompare | this_Cast_11= ruleCast | this_ShuffleVector_12= ruleShuffleVector | this_InsertElement_13= ruleInsertElement | this_ExtractElement_14= ruleExtractElement | this_Invoke_15= ruleInvoke | this_Resume_16= ruleResume | this_InsertValue_17= ruleInsertValue | this_ExtractValue_18= ruleExtractValue | this_Alloc_19= ruleAlloc | this_CmpXchg_20= ruleCmpXchg | this_AtomicRMW_21= ruleAtomicRMW | this_PHI_22= rulePHI | this_Select_23= ruleSelect | this_Call_24= ruleCall | this_VA_Arg_25= ruleVA_Arg | this_LandingPad_26= ruleLandingPad | this_LocalVar_27= ruleLocalVar )
            int alt98=28;
            switch ( input.LA(1) ) {
            case 187:
                {
                alt98=1;
                }
                break;
            case 186:
                {
                alt98=2;
                }
                break;
            case 193:
                {
                alt98=3;
                }
                break;
            case 191:
                {
                alt98=4;
                }
                break;
            case 74:
                {
                alt98=5;
                }
                break;
            case 79:
                {
                alt98=6;
                }
                break;
            case 52:
                {
                alt98=7;
                }
                break;
            case 48:
                {
                alt98=8;
                }
                break;
            case 66:
            case 68:
            case 69:
            case 183:
            case 184:
            case 185:
                {
                alt98=9;
                }
                break;
            case 64:
            case 65:
            case 173:
            case 174:
            case 175:
            case 176:
            case 177:
            case 178:
            case 179:
            case 180:
            case 181:
            case 182:
                {
                alt98=10;
                }
                break;
            case 149:
            case 150:
                {
                alt98=11;
                }
                break;
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 144:
            case 145:
            case 146:
            case 147:
            case 148:
                {
                alt98=12;
                }
                break;
            case 136:
                {
                alt98=13;
                }
                break;
            case 135:
                {
                alt98=14;
                }
                break;
            case 134:
                {
                alt98=15;
                }
                break;
            case 188:
                {
                alt98=16;
                }
                break;
            case 190:
                {
                alt98=17;
                }
                break;
            case 51:
                {
                alt98=18;
                }
                break;
            case 50:
                {
                alt98=19;
                }
                break;
            case 90:
                {
                alt98=20;
                }
                break;
            case 60:
                {
                alt98=21;
                }
                break;
            case 62:
                {
                alt98=22;
                }
                break;
            case 124:
                {
                alt98=23;
                }
                break;
            case 132:
                {
                alt98=24;
                }
                break;
            case 80:
            case 81:
                {
                alt98=25;
                }
                break;
            case 133:
                {
                alt98=26;
                }
                break;
            case 125:
                {
                alt98=27;
                }
                break;
            case RULE_VAR_TYPE:
            case RULE_INTEGER:
            case RULE_INT:
            case 32:
            case 36:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
                {
                alt98=28;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 98, 0, input);

                throw nvae;
            }

            switch (alt98) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4810:5: this_Switch_0= ruleSwitch
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getSwitchParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSwitch_in_ruleInstruction11230);
                    this_Switch_0=ruleSwitch();

                    state._fsp--;

                     
                            current = this_Switch_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4820:5: this_IndirectBranch_1= ruleIndirectBranch
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getIndirectBranchParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleIndirectBranch_in_ruleInstruction11257);
                    this_IndirectBranch_1=ruleIndirectBranch();

                    state._fsp--;

                     
                            current = this_IndirectBranch_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4830:5: this_Branch_2= ruleBranch
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getBranchParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleBranch_in_ruleInstruction11284);
                    this_Branch_2=ruleBranch();

                    state._fsp--;

                     
                            current = this_Branch_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4840:5: this_Return_3= ruleReturn
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getReturnParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleReturn_in_ruleInstruction11311);
                    this_Return_3=ruleReturn();

                    state._fsp--;

                     
                            current = this_Return_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4850:5: this_Load_4= ruleLoad
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getLoadParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleLoad_in_ruleInstruction11338);
                    this_Load_4=ruleLoad();

                    state._fsp--;

                     
                            current = this_Load_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4860:5: this_Store_5= ruleStore
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getStoreParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleStore_in_ruleInstruction11365);
                    this_Store_5=ruleStore();

                    state._fsp--;

                     
                            current = this_Store_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4870:5: this_Fence_6= ruleFence
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getFenceParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_ruleFence_in_ruleInstruction11392);
                    this_Fence_6=ruleFence();

                    state._fsp--;

                     
                            current = this_Fence_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4880:5: this_GetElementPtr_7= ruleGetElementPtr
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getGetElementPtrParserRuleCall_7()); 
                        
                    pushFollow(FOLLOW_ruleGetElementPtr_in_ruleInstruction11419);
                    this_GetElementPtr_7=ruleGetElementPtr();

                    state._fsp--;

                     
                            current = this_GetElementPtr_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4890:5: this_Logical_8= ruleLogical
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getLogicalParserRuleCall_8()); 
                        
                    pushFollow(FOLLOW_ruleLogical_in_ruleInstruction11446);
                    this_Logical_8=ruleLogical();

                    state._fsp--;

                     
                            current = this_Logical_8; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 10 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4900:5: this_Arithmetic_9= ruleArithmetic
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getArithmeticParserRuleCall_9()); 
                        
                    pushFollow(FOLLOW_ruleArithmetic_in_ruleInstruction11473);
                    this_Arithmetic_9=ruleArithmetic();

                    state._fsp--;

                     
                            current = this_Arithmetic_9; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 11 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4910:5: this_Compare_10= ruleCompare
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getCompareParserRuleCall_10()); 
                        
                    pushFollow(FOLLOW_ruleCompare_in_ruleInstruction11500);
                    this_Compare_10=ruleCompare();

                    state._fsp--;

                     
                            current = this_Compare_10; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 12 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4920:5: this_Cast_11= ruleCast
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getCastParserRuleCall_11()); 
                        
                    pushFollow(FOLLOW_ruleCast_in_ruleInstruction11527);
                    this_Cast_11=ruleCast();

                    state._fsp--;

                     
                            current = this_Cast_11; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 13 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4930:5: this_ShuffleVector_12= ruleShuffleVector
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getShuffleVectorParserRuleCall_12()); 
                        
                    pushFollow(FOLLOW_ruleShuffleVector_in_ruleInstruction11554);
                    this_ShuffleVector_12=ruleShuffleVector();

                    state._fsp--;

                     
                            current = this_ShuffleVector_12; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 14 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4940:5: this_InsertElement_13= ruleInsertElement
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getInsertElementParserRuleCall_13()); 
                        
                    pushFollow(FOLLOW_ruleInsertElement_in_ruleInstruction11581);
                    this_InsertElement_13=ruleInsertElement();

                    state._fsp--;

                     
                            current = this_InsertElement_13; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 15 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4950:5: this_ExtractElement_14= ruleExtractElement
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getExtractElementParserRuleCall_14()); 
                        
                    pushFollow(FOLLOW_ruleExtractElement_in_ruleInstruction11608);
                    this_ExtractElement_14=ruleExtractElement();

                    state._fsp--;

                     
                            current = this_ExtractElement_14; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 16 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4960:5: this_Invoke_15= ruleInvoke
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getInvokeParserRuleCall_15()); 
                        
                    pushFollow(FOLLOW_ruleInvoke_in_ruleInstruction11635);
                    this_Invoke_15=ruleInvoke();

                    state._fsp--;

                     
                            current = this_Invoke_15; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 17 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4970:5: this_Resume_16= ruleResume
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getResumeParserRuleCall_16()); 
                        
                    pushFollow(FOLLOW_ruleResume_in_ruleInstruction11662);
                    this_Resume_16=ruleResume();

                    state._fsp--;

                     
                            current = this_Resume_16; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 18 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4980:5: this_InsertValue_17= ruleInsertValue
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getInsertValueParserRuleCall_17()); 
                        
                    pushFollow(FOLLOW_ruleInsertValue_in_ruleInstruction11689);
                    this_InsertValue_17=ruleInsertValue();

                    state._fsp--;

                     
                            current = this_InsertValue_17; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 19 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:4990:5: this_ExtractValue_18= ruleExtractValue
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getExtractValueParserRuleCall_18()); 
                        
                    pushFollow(FOLLOW_ruleExtractValue_in_ruleInstruction11716);
                    this_ExtractValue_18=ruleExtractValue();

                    state._fsp--;

                     
                            current = this_ExtractValue_18; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 20 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5000:5: this_Alloc_19= ruleAlloc
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getAllocParserRuleCall_19()); 
                        
                    pushFollow(FOLLOW_ruleAlloc_in_ruleInstruction11743);
                    this_Alloc_19=ruleAlloc();

                    state._fsp--;

                     
                            current = this_Alloc_19; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 21 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5010:5: this_CmpXchg_20= ruleCmpXchg
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getCmpXchgParserRuleCall_20()); 
                        
                    pushFollow(FOLLOW_ruleCmpXchg_in_ruleInstruction11770);
                    this_CmpXchg_20=ruleCmpXchg();

                    state._fsp--;

                     
                            current = this_CmpXchg_20; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 22 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5020:5: this_AtomicRMW_21= ruleAtomicRMW
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getAtomicRMWParserRuleCall_21()); 
                        
                    pushFollow(FOLLOW_ruleAtomicRMW_in_ruleInstruction11797);
                    this_AtomicRMW_21=ruleAtomicRMW();

                    state._fsp--;

                     
                            current = this_AtomicRMW_21; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 23 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5030:5: this_PHI_22= rulePHI
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getPHIParserRuleCall_22()); 
                        
                    pushFollow(FOLLOW_rulePHI_in_ruleInstruction11824);
                    this_PHI_22=rulePHI();

                    state._fsp--;

                     
                            current = this_PHI_22; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 24 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5040:5: this_Select_23= ruleSelect
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getSelectParserRuleCall_23()); 
                        
                    pushFollow(FOLLOW_ruleSelect_in_ruleInstruction11851);
                    this_Select_23=ruleSelect();

                    state._fsp--;

                     
                            current = this_Select_23; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 25 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5050:5: this_Call_24= ruleCall
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getCallParserRuleCall_24()); 
                        
                    pushFollow(FOLLOW_ruleCall_in_ruleInstruction11878);
                    this_Call_24=ruleCall();

                    state._fsp--;

                     
                            current = this_Call_24; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 26 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5060:5: this_VA_Arg_25= ruleVA_Arg
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getVA_ArgParserRuleCall_25()); 
                        
                    pushFollow(FOLLOW_ruleVA_Arg_in_ruleInstruction11905);
                    this_VA_Arg_25=ruleVA_Arg();

                    state._fsp--;

                     
                            current = this_VA_Arg_25; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 27 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5070:5: this_LandingPad_26= ruleLandingPad
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getLandingPadParserRuleCall_26()); 
                        
                    pushFollow(FOLLOW_ruleLandingPad_in_ruleInstruction11932);
                    this_LandingPad_26=ruleLandingPad();

                    state._fsp--;

                     
                            current = this_LandingPad_26; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 28 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5080:5: this_LocalVar_27= ruleLocalVar
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getLocalVarParserRuleCall_27()); 
                        
                    pushFollow(FOLLOW_ruleLocalVar_in_ruleInstruction11959);
                    this_LocalVar_27=ruleLocalVar();

                    state._fsp--;

                     
                            current = this_LocalVar_27; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInstruction"


    // $ANTLR start "entryRuleIndirectBranch"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5096:1: entryRuleIndirectBranch returns [EObject current=null] : iv_ruleIndirectBranch= ruleIndirectBranch EOF ;
    public final EObject entryRuleIndirectBranch() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndirectBranch = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5097:2: (iv_ruleIndirectBranch= ruleIndirectBranch EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5098:2: iv_ruleIndirectBranch= ruleIndirectBranch EOF
            {
             newCompositeNode(grammarAccess.getIndirectBranchRule()); 
            pushFollow(FOLLOW_ruleIndirectBranch_in_entryRuleIndirectBranch11994);
            iv_ruleIndirectBranch=ruleIndirectBranch();

            state._fsp--;

             current =iv_ruleIndirectBranch; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIndirectBranch12004); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIndirectBranch"


    // $ANTLR start "ruleIndirectBranch"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5105:1: ruleIndirectBranch returns [EObject current=null] : (otherlv_0= 'indirectbr' ( (lv_adress_1_0= ruleTypeAndValue ) ) otherlv_2= ',' otherlv_3= '[' ( (lv_lList_4_0= ruleLabelList ) )? otherlv_5= ']' ) ;
    public final EObject ruleIndirectBranch() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_adress_1_0 = null;

        EObject lv_lList_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5108:28: ( (otherlv_0= 'indirectbr' ( (lv_adress_1_0= ruleTypeAndValue ) ) otherlv_2= ',' otherlv_3= '[' ( (lv_lList_4_0= ruleLabelList ) )? otherlv_5= ']' ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5109:1: (otherlv_0= 'indirectbr' ( (lv_adress_1_0= ruleTypeAndValue ) ) otherlv_2= ',' otherlv_3= '[' ( (lv_lList_4_0= ruleLabelList ) )? otherlv_5= ']' )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5109:1: (otherlv_0= 'indirectbr' ( (lv_adress_1_0= ruleTypeAndValue ) ) otherlv_2= ',' otherlv_3= '[' ( (lv_lList_4_0= ruleLabelList ) )? otherlv_5= ']' )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5109:3: otherlv_0= 'indirectbr' ( (lv_adress_1_0= ruleTypeAndValue ) ) otherlv_2= ',' otherlv_3= '[' ( (lv_lList_4_0= ruleLabelList ) )? otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,186,FOLLOW_186_in_ruleIndirectBranch12041); 

                	newLeafNode(otherlv_0, grammarAccess.getIndirectBranchAccess().getIndirectbrKeyword_0());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5113:1: ( (lv_adress_1_0= ruleTypeAndValue ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5114:1: (lv_adress_1_0= ruleTypeAndValue )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5114:1: (lv_adress_1_0= ruleTypeAndValue )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5115:3: lv_adress_1_0= ruleTypeAndValue
            {
             
            	        newCompositeNode(grammarAccess.getIndirectBranchAccess().getAdressTypeAndValueParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleTypeAndValue_in_ruleIndirectBranch12062);
            lv_adress_1_0=ruleTypeAndValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIndirectBranchRule());
            	        }
                   		set(
                   			current, 
                   			"adress",
                    		lv_adress_1_0, 
                    		"TypeAndValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,23,FOLLOW_23_in_ruleIndirectBranch12074); 

                	newLeafNode(otherlv_2, grammarAccess.getIndirectBranchAccess().getCommaKeyword_2());
                
            otherlv_3=(Token)match(input,22,FOLLOW_22_in_ruleIndirectBranch12086); 

                	newLeafNode(otherlv_3, grammarAccess.getIndirectBranchAccess().getLeftSquareBracketKeyword_3());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5139:1: ( (lv_lList_4_0= ruleLabelList ) )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( ((LA99_0>=RULE_VAR_TYPE && LA99_0<=RULE_INT)||LA99_0==32||(LA99_0>=38 && LA99_0<=47)) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5140:1: (lv_lList_4_0= ruleLabelList )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5140:1: (lv_lList_4_0= ruleLabelList )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5141:3: lv_lList_4_0= ruleLabelList
                    {
                     
                    	        newCompositeNode(grammarAccess.getIndirectBranchAccess().getLListLabelListParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleLabelList_in_ruleIndirectBranch12107);
                    lv_lList_4_0=ruleLabelList();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getIndirectBranchRule());
                    	        }
                           		set(
                           			current, 
                           			"lList",
                            		lv_lList_4_0, 
                            		"LabelList");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,24,FOLLOW_24_in_ruleIndirectBranch12120); 

                	newLeafNode(otherlv_5, grammarAccess.getIndirectBranchAccess().getRightSquareBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIndirectBranch"


    // $ANTLR start "entryRuleLabelList"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5169:1: entryRuleLabelList returns [EObject current=null] : iv_ruleLabelList= ruleLabelList EOF ;
    public final EObject entryRuleLabelList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLabelList = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5170:2: (iv_ruleLabelList= ruleLabelList EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5171:2: iv_ruleLabelList= ruleLabelList EOF
            {
             newCompositeNode(grammarAccess.getLabelListRule()); 
            pushFollow(FOLLOW_ruleLabelList_in_entryRuleLabelList12156);
            iv_ruleLabelList=ruleLabelList();

            state._fsp--;

             current =iv_ruleLabelList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLabelList12166); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLabelList"


    // $ANTLR start "ruleLabelList"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5178:1: ruleLabelList returns [EObject current=null] : ( (lv_labels_0_0= ruleTypeAndValue ) )+ ;
    public final EObject ruleLabelList() throws RecognitionException {
        EObject current = null;

        EObject lv_labels_0_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5181:28: ( ( (lv_labels_0_0= ruleTypeAndValue ) )+ )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5182:1: ( (lv_labels_0_0= ruleTypeAndValue ) )+
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5182:1: ( (lv_labels_0_0= ruleTypeAndValue ) )+
            int cnt100=0;
            loop100:
            do {
                int alt100=2;
                int LA100_0 = input.LA(1);

                if ( ((LA100_0>=RULE_VAR_TYPE && LA100_0<=RULE_INT)||LA100_0==32||(LA100_0>=38 && LA100_0<=47)) ) {
                    alt100=1;
                }


                switch (alt100) {
            	case 1 :
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5183:1: (lv_labels_0_0= ruleTypeAndValue )
            	    {
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5183:1: (lv_labels_0_0= ruleTypeAndValue )
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5184:3: lv_labels_0_0= ruleTypeAndValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLabelListAccess().getLabelsTypeAndValueParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTypeAndValue_in_ruleLabelList12211);
            	    lv_labels_0_0=ruleTypeAndValue();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getLabelListRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"labels",
            	            		lv_labels_0_0, 
            	            		"TypeAndValue");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt100 >= 1 ) break loop100;
                        EarlyExitException eee =
                            new EarlyExitException(100, input);
                        throw eee;
                }
                cnt100++;
            } while (true);


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLabelList"


    // $ANTLR start "entryRuleSwitch"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5208:1: entryRuleSwitch returns [EObject current=null] : iv_ruleSwitch= ruleSwitch EOF ;
    public final EObject entryRuleSwitch() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitch = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5209:2: (iv_ruleSwitch= ruleSwitch EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5210:2: iv_ruleSwitch= ruleSwitch EOF
            {
             newCompositeNode(grammarAccess.getSwitchRule()); 
            pushFollow(FOLLOW_ruleSwitch_in_entryRuleSwitch12247);
            iv_ruleSwitch=ruleSwitch();

            state._fsp--;

             current =iv_ruleSwitch; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSwitch12257); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSwitch"


    // $ANTLR start "ruleSwitch"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5217:1: ruleSwitch returns [EObject current=null] : (otherlv_0= 'switch' ( (lv_value_1_0= ruleTypeAndValue ) ) otherlv_2= ',' ( (lv_default_3_0= ruleTypeAndValue ) ) otherlv_4= '[' ( (lv_jTable_5_0= ruleJumpTable ) )? otherlv_6= ']' ) ;
    public final EObject ruleSwitch() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_value_1_0 = null;

        EObject lv_default_3_0 = null;

        EObject lv_jTable_5_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5220:28: ( (otherlv_0= 'switch' ( (lv_value_1_0= ruleTypeAndValue ) ) otherlv_2= ',' ( (lv_default_3_0= ruleTypeAndValue ) ) otherlv_4= '[' ( (lv_jTable_5_0= ruleJumpTable ) )? otherlv_6= ']' ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5221:1: (otherlv_0= 'switch' ( (lv_value_1_0= ruleTypeAndValue ) ) otherlv_2= ',' ( (lv_default_3_0= ruleTypeAndValue ) ) otherlv_4= '[' ( (lv_jTable_5_0= ruleJumpTable ) )? otherlv_6= ']' )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5221:1: (otherlv_0= 'switch' ( (lv_value_1_0= ruleTypeAndValue ) ) otherlv_2= ',' ( (lv_default_3_0= ruleTypeAndValue ) ) otherlv_4= '[' ( (lv_jTable_5_0= ruleJumpTable ) )? otherlv_6= ']' )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5221:3: otherlv_0= 'switch' ( (lv_value_1_0= ruleTypeAndValue ) ) otherlv_2= ',' ( (lv_default_3_0= ruleTypeAndValue ) ) otherlv_4= '[' ( (lv_jTable_5_0= ruleJumpTable ) )? otherlv_6= ']'
            {
            otherlv_0=(Token)match(input,187,FOLLOW_187_in_ruleSwitch12294); 

                	newLeafNode(otherlv_0, grammarAccess.getSwitchAccess().getSwitchKeyword_0());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5225:1: ( (lv_value_1_0= ruleTypeAndValue ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5226:1: (lv_value_1_0= ruleTypeAndValue )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5226:1: (lv_value_1_0= ruleTypeAndValue )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5227:3: lv_value_1_0= ruleTypeAndValue
            {
             
            	        newCompositeNode(grammarAccess.getSwitchAccess().getValueTypeAndValueParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleTypeAndValue_in_ruleSwitch12315);
            lv_value_1_0=ruleTypeAndValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSwitchRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"TypeAndValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,23,FOLLOW_23_in_ruleSwitch12327); 

                	newLeafNode(otherlv_2, grammarAccess.getSwitchAccess().getCommaKeyword_2());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5247:1: ( (lv_default_3_0= ruleTypeAndValue ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5248:1: (lv_default_3_0= ruleTypeAndValue )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5248:1: (lv_default_3_0= ruleTypeAndValue )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5249:3: lv_default_3_0= ruleTypeAndValue
            {
             
            	        newCompositeNode(grammarAccess.getSwitchAccess().getDefaultTypeAndValueParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleTypeAndValue_in_ruleSwitch12348);
            lv_default_3_0=ruleTypeAndValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSwitchRule());
            	        }
                   		set(
                   			current, 
                   			"default",
                    		lv_default_3_0, 
                    		"TypeAndValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,22,FOLLOW_22_in_ruleSwitch12360); 

                	newLeafNode(otherlv_4, grammarAccess.getSwitchAccess().getLeftSquareBracketKeyword_4());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5269:1: ( (lv_jTable_5_0= ruleJumpTable ) )?
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( ((LA101_0>=RULE_VAR_TYPE && LA101_0<=RULE_INT)||LA101_0==32||(LA101_0>=38 && LA101_0<=47)) ) {
                alt101=1;
            }
            switch (alt101) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5270:1: (lv_jTable_5_0= ruleJumpTable )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5270:1: (lv_jTable_5_0= ruleJumpTable )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5271:3: lv_jTable_5_0= ruleJumpTable
                    {
                     
                    	        newCompositeNode(grammarAccess.getSwitchAccess().getJTableJumpTableParserRuleCall_5_0()); 
                    	    
                    pushFollow(FOLLOW_ruleJumpTable_in_ruleSwitch12381);
                    lv_jTable_5_0=ruleJumpTable();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSwitchRule());
                    	        }
                           		set(
                           			current, 
                           			"jTable",
                            		lv_jTable_5_0, 
                            		"JumpTable");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,24,FOLLOW_24_in_ruleSwitch12394); 

                	newLeafNode(otherlv_6, grammarAccess.getSwitchAccess().getRightSquareBracketKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSwitch"


    // $ANTLR start "entryRuleJumpTable"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5299:1: entryRuleJumpTable returns [EObject current=null] : iv_ruleJumpTable= ruleJumpTable EOF ;
    public final EObject entryRuleJumpTable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJumpTable = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5300:2: (iv_ruleJumpTable= ruleJumpTable EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5301:2: iv_ruleJumpTable= ruleJumpTable EOF
            {
             newCompositeNode(grammarAccess.getJumpTableRule()); 
            pushFollow(FOLLOW_ruleJumpTable_in_entryRuleJumpTable12430);
            iv_ruleJumpTable=ruleJumpTable();

            state._fsp--;

             current =iv_ruleJumpTable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJumpTable12440); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJumpTable"


    // $ANTLR start "ruleJumpTable"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5308:1: ruleJumpTable returns [EObject current=null] : ( ( (lv_values_0_0= ruleTypeAndValue ) ) otherlv_1= ',' ( (lv_destinations_2_0= ruleTypeAndValue ) ) )+ ;
    public final EObject ruleJumpTable() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_values_0_0 = null;

        EObject lv_destinations_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5311:28: ( ( ( (lv_values_0_0= ruleTypeAndValue ) ) otherlv_1= ',' ( (lv_destinations_2_0= ruleTypeAndValue ) ) )+ )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5312:1: ( ( (lv_values_0_0= ruleTypeAndValue ) ) otherlv_1= ',' ( (lv_destinations_2_0= ruleTypeAndValue ) ) )+
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5312:1: ( ( (lv_values_0_0= ruleTypeAndValue ) ) otherlv_1= ',' ( (lv_destinations_2_0= ruleTypeAndValue ) ) )+
            int cnt102=0;
            loop102:
            do {
                int alt102=2;
                int LA102_0 = input.LA(1);

                if ( ((LA102_0>=RULE_VAR_TYPE && LA102_0<=RULE_INT)||LA102_0==32||(LA102_0>=38 && LA102_0<=47)) ) {
                    alt102=1;
                }


                switch (alt102) {
            	case 1 :
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5312:2: ( (lv_values_0_0= ruleTypeAndValue ) ) otherlv_1= ',' ( (lv_destinations_2_0= ruleTypeAndValue ) )
            	    {
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5312:2: ( (lv_values_0_0= ruleTypeAndValue ) )
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5313:1: (lv_values_0_0= ruleTypeAndValue )
            	    {
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5313:1: (lv_values_0_0= ruleTypeAndValue )
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5314:3: lv_values_0_0= ruleTypeAndValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getJumpTableAccess().getValuesTypeAndValueParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTypeAndValue_in_ruleJumpTable12486);
            	    lv_values_0_0=ruleTypeAndValue();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getJumpTableRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"values",
            	            		lv_values_0_0, 
            	            		"TypeAndValue");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleJumpTable12498); 

            	        	newLeafNode(otherlv_1, grammarAccess.getJumpTableAccess().getCommaKeyword_1());
            	        
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5334:1: ( (lv_destinations_2_0= ruleTypeAndValue ) )
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5335:1: (lv_destinations_2_0= ruleTypeAndValue )
            	    {
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5335:1: (lv_destinations_2_0= ruleTypeAndValue )
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5336:3: lv_destinations_2_0= ruleTypeAndValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getJumpTableAccess().getDestinationsTypeAndValueParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTypeAndValue_in_ruleJumpTable12519);
            	    lv_destinations_2_0=ruleTypeAndValue();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getJumpTableRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"destinations",
            	            		lv_destinations_2_0, 
            	            		"TypeAndValue");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt102 >= 1 ) break loop102;
                        EarlyExitException eee =
                            new EarlyExitException(102, input);
                        throw eee;
                }
                cnt102++;
            } while (true);


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJumpTable"


    // $ANTLR start "entryRuleInvoke"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5360:1: entryRuleInvoke returns [EObject current=null] : iv_ruleInvoke= ruleInvoke EOF ;
    public final EObject entryRuleInvoke() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvoke = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5361:2: (iv_ruleInvoke= ruleInvoke EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5362:2: iv_ruleInvoke= ruleInvoke EOF
            {
             newCompositeNode(grammarAccess.getInvokeRule()); 
            pushFollow(FOLLOW_ruleInvoke_in_entryRuleInvoke12556);
            iv_ruleInvoke=ruleInvoke();

            state._fsp--;

             current =iv_ruleInvoke; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInvoke12566); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInvoke"


    // $ANTLR start "ruleInvoke"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5369:1: ruleInvoke returns [EObject current=null] : (otherlv_0= 'invoke' ( ruleCallingConv )? ( ruleRETURN_ATTRIBUTES )? ( (lv_function_3_0= ruleTypeAndValue ) ) ( (lv_pList_4_0= ruleParameterList ) ) ( ruleFUNCTION_ATTRIBUTES )? otherlv_6= 'to' ( (lv_to_7_0= ruleTypeAndValue ) ) otherlv_8= 'unwind' ( (lv_unwind_9_0= ruleTypeAndValue ) ) ) ;
    public final EObject ruleInvoke() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_function_3_0 = null;

        EObject lv_pList_4_0 = null;

        EObject lv_to_7_0 = null;

        EObject lv_unwind_9_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5372:28: ( (otherlv_0= 'invoke' ( ruleCallingConv )? ( ruleRETURN_ATTRIBUTES )? ( (lv_function_3_0= ruleTypeAndValue ) ) ( (lv_pList_4_0= ruleParameterList ) ) ( ruleFUNCTION_ATTRIBUTES )? otherlv_6= 'to' ( (lv_to_7_0= ruleTypeAndValue ) ) otherlv_8= 'unwind' ( (lv_unwind_9_0= ruleTypeAndValue ) ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5373:1: (otherlv_0= 'invoke' ( ruleCallingConv )? ( ruleRETURN_ATTRIBUTES )? ( (lv_function_3_0= ruleTypeAndValue ) ) ( (lv_pList_4_0= ruleParameterList ) ) ( ruleFUNCTION_ATTRIBUTES )? otherlv_6= 'to' ( (lv_to_7_0= ruleTypeAndValue ) ) otherlv_8= 'unwind' ( (lv_unwind_9_0= ruleTypeAndValue ) ) )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5373:1: (otherlv_0= 'invoke' ( ruleCallingConv )? ( ruleRETURN_ATTRIBUTES )? ( (lv_function_3_0= ruleTypeAndValue ) ) ( (lv_pList_4_0= ruleParameterList ) ) ( ruleFUNCTION_ATTRIBUTES )? otherlv_6= 'to' ( (lv_to_7_0= ruleTypeAndValue ) ) otherlv_8= 'unwind' ( (lv_unwind_9_0= ruleTypeAndValue ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5373:3: otherlv_0= 'invoke' ( ruleCallingConv )? ( ruleRETURN_ATTRIBUTES )? ( (lv_function_3_0= ruleTypeAndValue ) ) ( (lv_pList_4_0= ruleParameterList ) ) ( ruleFUNCTION_ATTRIBUTES )? otherlv_6= 'to' ( (lv_to_7_0= ruleTypeAndValue ) ) otherlv_8= 'unwind' ( (lv_unwind_9_0= ruleTypeAndValue ) )
            {
            otherlv_0=(Token)match(input,188,FOLLOW_188_in_ruleInvoke12603); 

                	newLeafNode(otherlv_0, grammarAccess.getInvokeAccess().getInvokeKeyword_0());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5377:1: ( ruleCallingConv )?
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( ((LA103_0>=91 && LA103_0<=105)) ) {
                alt103=1;
            }
            switch (alt103) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5378:5: ruleCallingConv
                    {
                     
                            newCompositeNode(grammarAccess.getInvokeAccess().getCallingConvParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleCallingConv_in_ruleInvoke12620);
                    ruleCallingConv();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5385:3: ( ruleRETURN_ATTRIBUTES )?
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( ((LA104_0>=82 && LA104_0<=89)) ) {
                alt104=1;
            }
            switch (alt104) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5386:5: ruleRETURN_ATTRIBUTES
                    {
                     
                            newCompositeNode(grammarAccess.getInvokeAccess().getRETURN_ATTRIBUTESParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleRETURN_ATTRIBUTES_in_ruleInvoke12638);
                    ruleRETURN_ATTRIBUTES();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5393:3: ( (lv_function_3_0= ruleTypeAndValue ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5394:1: (lv_function_3_0= ruleTypeAndValue )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5394:1: (lv_function_3_0= ruleTypeAndValue )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5395:3: lv_function_3_0= ruleTypeAndValue
            {
             
            	        newCompositeNode(grammarAccess.getInvokeAccess().getFunctionTypeAndValueParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleTypeAndValue_in_ruleInvoke12660);
            lv_function_3_0=ruleTypeAndValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInvokeRule());
            	        }
                   		set(
                   			current, 
                   			"function",
                    		lv_function_3_0, 
                    		"TypeAndValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5411:2: ( (lv_pList_4_0= ruleParameterList ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5412:1: (lv_pList_4_0= ruleParameterList )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5412:1: (lv_pList_4_0= ruleParameterList )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5413:3: lv_pList_4_0= ruleParameterList
            {
             
            	        newCompositeNode(grammarAccess.getInvokeAccess().getPListParameterListParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleParameterList_in_ruleInvoke12681);
            lv_pList_4_0=ruleParameterList();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInvokeRule());
            	        }
                   		set(
                   			current, 
                   			"pList",
                    		lv_pList_4_0, 
                    		"ParameterList");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5429:2: ( ruleFUNCTION_ATTRIBUTES )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( ((LA105_0>=106 && LA105_0<=123)) ) {
                alt105=1;
            }
            switch (alt105) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5430:5: ruleFUNCTION_ATTRIBUTES
                    {
                     
                            newCompositeNode(grammarAccess.getInvokeAccess().getFUNCTION_ATTRIBUTESParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleFUNCTION_ATTRIBUTES_in_ruleInvoke12698);
                    ruleFUNCTION_ATTRIBUTES();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            otherlv_6=(Token)match(input,129,FOLLOW_129_in_ruleInvoke12711); 

                	newLeafNode(otherlv_6, grammarAccess.getInvokeAccess().getToKeyword_6());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5441:1: ( (lv_to_7_0= ruleTypeAndValue ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5442:1: (lv_to_7_0= ruleTypeAndValue )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5442:1: (lv_to_7_0= ruleTypeAndValue )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5443:3: lv_to_7_0= ruleTypeAndValue
            {
             
            	        newCompositeNode(grammarAccess.getInvokeAccess().getToTypeAndValueParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_ruleTypeAndValue_in_ruleInvoke12732);
            lv_to_7_0=ruleTypeAndValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInvokeRule());
            	        }
                   		set(
                   			current, 
                   			"to",
                    		lv_to_7_0, 
                    		"TypeAndValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_8=(Token)match(input,189,FOLLOW_189_in_ruleInvoke12744); 

                	newLeafNode(otherlv_8, grammarAccess.getInvokeAccess().getUnwindKeyword_8());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5463:1: ( (lv_unwind_9_0= ruleTypeAndValue ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5464:1: (lv_unwind_9_0= ruleTypeAndValue )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5464:1: (lv_unwind_9_0= ruleTypeAndValue )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5465:3: lv_unwind_9_0= ruleTypeAndValue
            {
             
            	        newCompositeNode(grammarAccess.getInvokeAccess().getUnwindTypeAndValueParserRuleCall_9_0()); 
            	    
            pushFollow(FOLLOW_ruleTypeAndValue_in_ruleInvoke12765);
            lv_unwind_9_0=ruleTypeAndValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInvokeRule());
            	        }
                   		set(
                   			current, 
                   			"unwind",
                    		lv_unwind_9_0, 
                    		"TypeAndValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInvoke"


    // $ANTLR start "entryRuleResume"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5489:1: entryRuleResume returns [EObject current=null] : iv_ruleResume= ruleResume EOF ;
    public final EObject entryRuleResume() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResume = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5490:2: (iv_ruleResume= ruleResume EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5491:2: iv_ruleResume= ruleResume EOF
            {
             newCompositeNode(grammarAccess.getResumeRule()); 
            pushFollow(FOLLOW_ruleResume_in_entryRuleResume12801);
            iv_ruleResume=ruleResume();

            state._fsp--;

             current =iv_ruleResume; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResume12811); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleResume"


    // $ANTLR start "ruleResume"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5498:1: ruleResume returns [EObject current=null] : (otherlv_0= 'resume' this_TypeAndValue_1= ruleTypeAndValue ) ;
    public final EObject ruleResume() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_TypeAndValue_1 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5501:28: ( (otherlv_0= 'resume' this_TypeAndValue_1= ruleTypeAndValue ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5502:1: (otherlv_0= 'resume' this_TypeAndValue_1= ruleTypeAndValue )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5502:1: (otherlv_0= 'resume' this_TypeAndValue_1= ruleTypeAndValue )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5502:3: otherlv_0= 'resume' this_TypeAndValue_1= ruleTypeAndValue
            {
            otherlv_0=(Token)match(input,190,FOLLOW_190_in_ruleResume12848); 

                	newLeafNode(otherlv_0, grammarAccess.getResumeAccess().getResumeKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getResumeAccess().getTypeAndValueParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleTypeAndValue_in_ruleResume12870);
            this_TypeAndValue_1=ruleTypeAndValue();

            state._fsp--;

             
                    current = this_TypeAndValue_1; 
                    afterParserOrEnumRuleCall();
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleResume"


    // $ANTLR start "entryRuleReturn"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5523:1: entryRuleReturn returns [EObject current=null] : iv_ruleReturn= ruleReturn EOF ;
    public final EObject entryRuleReturn() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReturn = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5524:2: (iv_ruleReturn= ruleReturn EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5525:2: iv_ruleReturn= ruleReturn EOF
            {
             newCompositeNode(grammarAccess.getReturnRule()); 
            pushFollow(FOLLOW_ruleReturn_in_entryRuleReturn12905);
            iv_ruleReturn=ruleReturn();

            state._fsp--;

             current =iv_ruleReturn; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReturn12915); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReturn"


    // $ANTLR start "ruleReturn"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5532:1: ruleReturn returns [EObject current=null] : ( ( () otherlv_1= 'ret' otherlv_2= 'void' (otherlv_3= ',' otherlv_4= '!dbg' otherlv_5= '!' this_INT_6= RULE_INT )? ) | (otherlv_7= 'ret' ( (lv_value_8_0= ruleTypeAndValue ) ) (otherlv_9= ',' otherlv_10= '!dbg' otherlv_11= '!' this_INT_12= RULE_INT )? ) ) ;
    public final EObject ruleReturn() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token this_INT_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token this_INT_12=null;
        EObject lv_value_8_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5535:28: ( ( ( () otherlv_1= 'ret' otherlv_2= 'void' (otherlv_3= ',' otherlv_4= '!dbg' otherlv_5= '!' this_INT_6= RULE_INT )? ) | (otherlv_7= 'ret' ( (lv_value_8_0= ruleTypeAndValue ) ) (otherlv_9= ',' otherlv_10= '!dbg' otherlv_11= '!' this_INT_12= RULE_INT )? ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5536:1: ( ( () otherlv_1= 'ret' otherlv_2= 'void' (otherlv_3= ',' otherlv_4= '!dbg' otherlv_5= '!' this_INT_6= RULE_INT )? ) | (otherlv_7= 'ret' ( (lv_value_8_0= ruleTypeAndValue ) ) (otherlv_9= ',' otherlv_10= '!dbg' otherlv_11= '!' this_INT_12= RULE_INT )? ) )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5536:1: ( ( () otherlv_1= 'ret' otherlv_2= 'void' (otherlv_3= ',' otherlv_4= '!dbg' otherlv_5= '!' this_INT_6= RULE_INT )? ) | (otherlv_7= 'ret' ( (lv_value_8_0= ruleTypeAndValue ) ) (otherlv_9= ',' otherlv_10= '!dbg' otherlv_11= '!' this_INT_12= RULE_INT )? ) )
            int alt108=2;
            alt108 = dfa108.predict(input);
            switch (alt108) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5536:2: ( () otherlv_1= 'ret' otherlv_2= 'void' (otherlv_3= ',' otherlv_4= '!dbg' otherlv_5= '!' this_INT_6= RULE_INT )? )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5536:2: ( () otherlv_1= 'ret' otherlv_2= 'void' (otherlv_3= ',' otherlv_4= '!dbg' otherlv_5= '!' this_INT_6= RULE_INT )? )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5536:3: () otherlv_1= 'ret' otherlv_2= 'void' (otherlv_3= ',' otherlv_4= '!dbg' otherlv_5= '!' this_INT_6= RULE_INT )?
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5536:3: ()
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5537:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getReturnAccess().getReturnAction_0_0(),
                                current);
                        

                    }

                    otherlv_1=(Token)match(input,191,FOLLOW_191_in_ruleReturn12962); 

                        	newLeafNode(otherlv_1, grammarAccess.getReturnAccess().getRetKeyword_0_1());
                        
                    otherlv_2=(Token)match(input,38,FOLLOW_38_in_ruleReturn12974); 

                        	newLeafNode(otherlv_2, grammarAccess.getReturnAccess().getVoidKeyword_0_2());
                        
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5550:1: (otherlv_3= ',' otherlv_4= '!dbg' otherlv_5= '!' this_INT_6= RULE_INT )?
                    int alt106=2;
                    int LA106_0 = input.LA(1);

                    if ( (LA106_0==23) ) {
                        alt106=1;
                    }
                    switch (alt106) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5550:3: otherlv_3= ',' otherlv_4= '!dbg' otherlv_5= '!' this_INT_6= RULE_INT
                            {
                            otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleReturn12987); 

                                	newLeafNode(otherlv_3, grammarAccess.getReturnAccess().getCommaKeyword_0_3_0());
                                
                            otherlv_4=(Token)match(input,192,FOLLOW_192_in_ruleReturn12999); 

                                	newLeafNode(otherlv_4, grammarAccess.getReturnAccess().getDbgKeyword_0_3_1());
                                
                            otherlv_5=(Token)match(input,76,FOLLOW_76_in_ruleReturn13011); 

                                	newLeafNode(otherlv_5, grammarAccess.getReturnAccess().getExclamationMarkKeyword_0_3_2());
                                
                            this_INT_6=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleReturn13022); 
                             
                                newLeafNode(this_INT_6, grammarAccess.getReturnAccess().getINTTerminalRuleCall_0_3_3()); 
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5567:6: (otherlv_7= 'ret' ( (lv_value_8_0= ruleTypeAndValue ) ) (otherlv_9= ',' otherlv_10= '!dbg' otherlv_11= '!' this_INT_12= RULE_INT )? )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5567:6: (otherlv_7= 'ret' ( (lv_value_8_0= ruleTypeAndValue ) ) (otherlv_9= ',' otherlv_10= '!dbg' otherlv_11= '!' this_INT_12= RULE_INT )? )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5567:8: otherlv_7= 'ret' ( (lv_value_8_0= ruleTypeAndValue ) ) (otherlv_9= ',' otherlv_10= '!dbg' otherlv_11= '!' this_INT_12= RULE_INT )?
                    {
                    otherlv_7=(Token)match(input,191,FOLLOW_191_in_ruleReturn13043); 

                        	newLeafNode(otherlv_7, grammarAccess.getReturnAccess().getRetKeyword_1_0());
                        
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5571:1: ( (lv_value_8_0= ruleTypeAndValue ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5572:1: (lv_value_8_0= ruleTypeAndValue )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5572:1: (lv_value_8_0= ruleTypeAndValue )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5573:3: lv_value_8_0= ruleTypeAndValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getReturnAccess().getValueTypeAndValueParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTypeAndValue_in_ruleReturn13064);
                    lv_value_8_0=ruleTypeAndValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getReturnRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_8_0, 
                            		"TypeAndValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5589:2: (otherlv_9= ',' otherlv_10= '!dbg' otherlv_11= '!' this_INT_12= RULE_INT )?
                    int alt107=2;
                    int LA107_0 = input.LA(1);

                    if ( (LA107_0==23) ) {
                        alt107=1;
                    }
                    switch (alt107) {
                        case 1 :
                            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5589:4: otherlv_9= ',' otherlv_10= '!dbg' otherlv_11= '!' this_INT_12= RULE_INT
                            {
                            otherlv_9=(Token)match(input,23,FOLLOW_23_in_ruleReturn13077); 

                                	newLeafNode(otherlv_9, grammarAccess.getReturnAccess().getCommaKeyword_1_2_0());
                                
                            otherlv_10=(Token)match(input,192,FOLLOW_192_in_ruleReturn13089); 

                                	newLeafNode(otherlv_10, grammarAccess.getReturnAccess().getDbgKeyword_1_2_1());
                                
                            otherlv_11=(Token)match(input,76,FOLLOW_76_in_ruleReturn13101); 

                                	newLeafNode(otherlv_11, grammarAccess.getReturnAccess().getExclamationMarkKeyword_1_2_2());
                                
                            this_INT_12=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleReturn13112); 
                             
                                newLeafNode(this_INT_12, grammarAccess.getReturnAccess().getINTTerminalRuleCall_1_2_3()); 
                                

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReturn"


    // $ANTLR start "entryRuleBranch"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5613:1: entryRuleBranch returns [EObject current=null] : iv_ruleBranch= ruleBranch EOF ;
    public final EObject entryRuleBranch() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBranch = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5614:2: (iv_ruleBranch= ruleBranch EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5615:2: iv_ruleBranch= ruleBranch EOF
            {
             newCompositeNode(grammarAccess.getBranchRule()); 
            pushFollow(FOLLOW_ruleBranch_in_entryRuleBranch13150);
            iv_ruleBranch=ruleBranch();

            state._fsp--;

             current =iv_ruleBranch; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBranch13160); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBranch"


    // $ANTLR start "ruleBranch"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5622:1: ruleBranch returns [EObject current=null] : ( (otherlv_0= 'br' ( (lv_destination_1_0= ruleTypeAndValue ) ) ) | (otherlv_2= 'br' ( (lv_cond_3_0= ruleTypeAndValue ) ) otherlv_4= ',' ( (lv_labelTrue_5_0= ruleTypeAndValue ) ) otherlv_6= ',' ( (lv_labelFalse_7_0= ruleTypeAndValue ) ) ) ) ;
    public final EObject ruleBranch() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_destination_1_0 = null;

        EObject lv_cond_3_0 = null;

        EObject lv_labelTrue_5_0 = null;

        EObject lv_labelFalse_7_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5625:28: ( ( (otherlv_0= 'br' ( (lv_destination_1_0= ruleTypeAndValue ) ) ) | (otherlv_2= 'br' ( (lv_cond_3_0= ruleTypeAndValue ) ) otherlv_4= ',' ( (lv_labelTrue_5_0= ruleTypeAndValue ) ) otherlv_6= ',' ( (lv_labelFalse_7_0= ruleTypeAndValue ) ) ) ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5626:1: ( (otherlv_0= 'br' ( (lv_destination_1_0= ruleTypeAndValue ) ) ) | (otherlv_2= 'br' ( (lv_cond_3_0= ruleTypeAndValue ) ) otherlv_4= ',' ( (lv_labelTrue_5_0= ruleTypeAndValue ) ) otherlv_6= ',' ( (lv_labelFalse_7_0= ruleTypeAndValue ) ) ) )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5626:1: ( (otherlv_0= 'br' ( (lv_destination_1_0= ruleTypeAndValue ) ) ) | (otherlv_2= 'br' ( (lv_cond_3_0= ruleTypeAndValue ) ) otherlv_4= ',' ( (lv_labelTrue_5_0= ruleTypeAndValue ) ) otherlv_6= ',' ( (lv_labelFalse_7_0= ruleTypeAndValue ) ) ) )
            int alt109=2;
            alt109 = dfa109.predict(input);
            switch (alt109) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5626:2: (otherlv_0= 'br' ( (lv_destination_1_0= ruleTypeAndValue ) ) )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5626:2: (otherlv_0= 'br' ( (lv_destination_1_0= ruleTypeAndValue ) ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5626:4: otherlv_0= 'br' ( (lv_destination_1_0= ruleTypeAndValue ) )
                    {
                    otherlv_0=(Token)match(input,193,FOLLOW_193_in_ruleBranch13198); 

                        	newLeafNode(otherlv_0, grammarAccess.getBranchAccess().getBrKeyword_0_0());
                        
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5630:1: ( (lv_destination_1_0= ruleTypeAndValue ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5631:1: (lv_destination_1_0= ruleTypeAndValue )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5631:1: (lv_destination_1_0= ruleTypeAndValue )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5632:3: lv_destination_1_0= ruleTypeAndValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getBranchAccess().getDestinationTypeAndValueParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTypeAndValue_in_ruleBranch13219);
                    lv_destination_1_0=ruleTypeAndValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getBranchRule());
                    	        }
                           		set(
                           			current, 
                           			"destination",
                            		lv_destination_1_0, 
                            		"TypeAndValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5649:6: (otherlv_2= 'br' ( (lv_cond_3_0= ruleTypeAndValue ) ) otherlv_4= ',' ( (lv_labelTrue_5_0= ruleTypeAndValue ) ) otherlv_6= ',' ( (lv_labelFalse_7_0= ruleTypeAndValue ) ) )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5649:6: (otherlv_2= 'br' ( (lv_cond_3_0= ruleTypeAndValue ) ) otherlv_4= ',' ( (lv_labelTrue_5_0= ruleTypeAndValue ) ) otherlv_6= ',' ( (lv_labelFalse_7_0= ruleTypeAndValue ) ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5649:8: otherlv_2= 'br' ( (lv_cond_3_0= ruleTypeAndValue ) ) otherlv_4= ',' ( (lv_labelTrue_5_0= ruleTypeAndValue ) ) otherlv_6= ',' ( (lv_labelFalse_7_0= ruleTypeAndValue ) )
                    {
                    otherlv_2=(Token)match(input,193,FOLLOW_193_in_ruleBranch13239); 

                        	newLeafNode(otherlv_2, grammarAccess.getBranchAccess().getBrKeyword_1_0());
                        
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5653:1: ( (lv_cond_3_0= ruleTypeAndValue ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5654:1: (lv_cond_3_0= ruleTypeAndValue )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5654:1: (lv_cond_3_0= ruleTypeAndValue )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5655:3: lv_cond_3_0= ruleTypeAndValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getBranchAccess().getCondTypeAndValueParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTypeAndValue_in_ruleBranch13260);
                    lv_cond_3_0=ruleTypeAndValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getBranchRule());
                    	        }
                           		set(
                           			current, 
                           			"cond",
                            		lv_cond_3_0, 
                            		"TypeAndValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,23,FOLLOW_23_in_ruleBranch13272); 

                        	newLeafNode(otherlv_4, grammarAccess.getBranchAccess().getCommaKeyword_1_2());
                        
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5675:1: ( (lv_labelTrue_5_0= ruleTypeAndValue ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5676:1: (lv_labelTrue_5_0= ruleTypeAndValue )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5676:1: (lv_labelTrue_5_0= ruleTypeAndValue )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5677:3: lv_labelTrue_5_0= ruleTypeAndValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getBranchAccess().getLabelTrueTypeAndValueParserRuleCall_1_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTypeAndValue_in_ruleBranch13293);
                    lv_labelTrue_5_0=ruleTypeAndValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getBranchRule());
                    	        }
                           		set(
                           			current, 
                           			"labelTrue",
                            		lv_labelTrue_5_0, 
                            		"TypeAndValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_6=(Token)match(input,23,FOLLOW_23_in_ruleBranch13305); 

                        	newLeafNode(otherlv_6, grammarAccess.getBranchAccess().getCommaKeyword_1_4());
                        
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5697:1: ( (lv_labelFalse_7_0= ruleTypeAndValue ) )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5698:1: (lv_labelFalse_7_0= ruleTypeAndValue )
                    {
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5698:1: (lv_labelFalse_7_0= ruleTypeAndValue )
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5699:3: lv_labelFalse_7_0= ruleTypeAndValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getBranchAccess().getLabelFalseTypeAndValueParserRuleCall_1_5_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTypeAndValue_in_ruleBranch13326);
                    lv_labelFalse_7_0=ruleTypeAndValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getBranchRule());
                    	        }
                           		set(
                           			current, 
                           			"labelFalse",
                            		lv_labelFalse_7_0, 
                            		"TypeAndValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBranch"


    // $ANTLR start "entryRuleFunctionBody"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5723:1: entryRuleFunctionBody returns [EObject current=null] : iv_ruleFunctionBody= ruleFunctionBody EOF ;
    public final EObject entryRuleFunctionBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionBody = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5724:2: (iv_ruleFunctionBody= ruleFunctionBody EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5725:2: iv_ruleFunctionBody= ruleFunctionBody EOF
            {
             newCompositeNode(grammarAccess.getFunctionBodyRule()); 
            pushFollow(FOLLOW_ruleFunctionBody_in_entryRuleFunctionBody13363);
            iv_ruleFunctionBody=ruleFunctionBody();

            state._fsp--;

             current =iv_ruleFunctionBody; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunctionBody13373); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionBody"


    // $ANTLR start "ruleFunctionBody"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5732:1: ruleFunctionBody returns [EObject current=null] : (otherlv_0= '{' ( (lv_blocks_1_0= ruleBasicBlock ) )+ otherlv_2= '}' ) ;
    public final EObject ruleFunctionBody() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_blocks_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5735:28: ( (otherlv_0= '{' ( (lv_blocks_1_0= ruleBasicBlock ) )+ otherlv_2= '}' ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5736:1: (otherlv_0= '{' ( (lv_blocks_1_0= ruleBasicBlock ) )+ otherlv_2= '}' )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5736:1: (otherlv_0= '{' ( (lv_blocks_1_0= ruleBasicBlock ) )+ otherlv_2= '}' )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5736:3: otherlv_0= '{' ( (lv_blocks_1_0= ruleBasicBlock ) )+ otherlv_2= '}'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleFunctionBody13410); 

                	newLeafNode(otherlv_0, grammarAccess.getFunctionBodyAccess().getLeftCurlyBracketKeyword_0());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5740:1: ( (lv_blocks_1_0= ruleBasicBlock ) )+
            int cnt110=0;
            loop110:
            do {
                int alt110=2;
                int LA110_0 = input.LA(1);

                if ( (LA110_0==RULE_NOBRACKET) ) {
                    alt110=1;
                }


                switch (alt110) {
            	case 1 :
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5741:1: (lv_blocks_1_0= ruleBasicBlock )
            	    {
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5741:1: (lv_blocks_1_0= ruleBasicBlock )
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5742:3: lv_blocks_1_0= ruleBasicBlock
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getFunctionBodyAccess().getBlocksBasicBlockParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleBasicBlock_in_ruleFunctionBody13431);
            	    lv_blocks_1_0=ruleBasicBlock();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getFunctionBodyRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"blocks",
            	            		lv_blocks_1_0, 
            	            		"BasicBlock");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt110 >= 1 ) break loop110;
                        EarlyExitException eee =
                            new EarlyExitException(110, input);
                        throw eee;
                }
                cnt110++;
            } while (true);

            otherlv_2=(Token)match(input,33,FOLLOW_33_in_ruleFunctionBody13444); 

                	newLeafNode(otherlv_2, grammarAccess.getFunctionBodyAccess().getRightCurlyBracketKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionBody"


    // $ANTLR start "entryRuleBasicBlock"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5770:1: entryRuleBasicBlock returns [EObject current=null] : iv_ruleBasicBlock= ruleBasicBlock EOF ;
    public final EObject entryRuleBasicBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBasicBlock = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5771:2: (iv_ruleBasicBlock= ruleBasicBlock EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5772:2: iv_ruleBasicBlock= ruleBasicBlock EOF
            {
             newCompositeNode(grammarAccess.getBasicBlockRule()); 
            pushFollow(FOLLOW_ruleBasicBlock_in_entryRuleBasicBlock13480);
            iv_ruleBasicBlock=ruleBasicBlock();

            state._fsp--;

             current =iv_ruleBasicBlock; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBasicBlock13490); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBasicBlock"


    // $ANTLR start "ruleBasicBlock"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5779:1: ruleBasicBlock returns [EObject current=null] : ( ( (lv_label_0_0= RULE_NOBRACKET ) ) otherlv_1= ':' ( (lv_instructions_2_0= ruleInstruction ) )* ) ;
    public final EObject ruleBasicBlock() throws RecognitionException {
        EObject current = null;

        Token lv_label_0_0=null;
        Token otherlv_1=null;
        EObject lv_instructions_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5782:28: ( ( ( (lv_label_0_0= RULE_NOBRACKET ) ) otherlv_1= ':' ( (lv_instructions_2_0= ruleInstruction ) )* ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5783:1: ( ( (lv_label_0_0= RULE_NOBRACKET ) ) otherlv_1= ':' ( (lv_instructions_2_0= ruleInstruction ) )* )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5783:1: ( ( (lv_label_0_0= RULE_NOBRACKET ) ) otherlv_1= ':' ( (lv_instructions_2_0= ruleInstruction ) )* )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5783:2: ( (lv_label_0_0= RULE_NOBRACKET ) ) otherlv_1= ':' ( (lv_instructions_2_0= ruleInstruction ) )*
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5783:2: ( (lv_label_0_0= RULE_NOBRACKET ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5784:1: (lv_label_0_0= RULE_NOBRACKET )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5784:1: (lv_label_0_0= RULE_NOBRACKET )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5785:3: lv_label_0_0= RULE_NOBRACKET
            {
            lv_label_0_0=(Token)match(input,RULE_NOBRACKET,FOLLOW_RULE_NOBRACKET_in_ruleBasicBlock13532); 

            			newLeafNode(lv_label_0_0, grammarAccess.getBasicBlockAccess().getLabelNOBRACKETTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getBasicBlockRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"label",
                    		lv_label_0_0, 
                    		"NOBRACKET");
            	    

            }


            }

            otherlv_1=(Token)match(input,194,FOLLOW_194_in_ruleBasicBlock13549); 

                	newLeafNode(otherlv_1, grammarAccess.getBasicBlockAccess().getColonKeyword_1());
                
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5805:1: ( (lv_instructions_2_0= ruleInstruction ) )*
            loop111:
            do {
                int alt111=2;
                int LA111_0 = input.LA(1);

                if ( ((LA111_0>=RULE_VAR_TYPE && LA111_0<=RULE_INT)||LA111_0==32||LA111_0==36||(LA111_0>=38 && LA111_0<=48)||(LA111_0>=50 && LA111_0<=52)||LA111_0==60||LA111_0==62||(LA111_0>=64 && LA111_0<=66)||(LA111_0>=68 && LA111_0<=69)||LA111_0==74||(LA111_0>=79 && LA111_0<=81)||LA111_0==90||(LA111_0>=124 && LA111_0<=125)||(LA111_0>=132 && LA111_0<=150)||(LA111_0>=173 && LA111_0<=188)||(LA111_0>=190 && LA111_0<=191)||LA111_0==193) ) {
                    alt111=1;
                }


                switch (alt111) {
            	case 1 :
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5806:1: (lv_instructions_2_0= ruleInstruction )
            	    {
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5806:1: (lv_instructions_2_0= ruleInstruction )
            	    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5807:3: lv_instructions_2_0= ruleInstruction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getBasicBlockAccess().getInstructionsInstructionParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleInstruction_in_ruleBasicBlock13570);
            	    lv_instructions_2_0=ruleInstruction();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getBasicBlockRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"instructions",
            	            		lv_instructions_2_0, 
            	            		"Instruction");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop111;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBasicBlock"


    // $ANTLR start "entryRuleVISIBILITY"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5831:1: entryRuleVISIBILITY returns [String current=null] : iv_ruleVISIBILITY= ruleVISIBILITY EOF ;
    public final String entryRuleVISIBILITY() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVISIBILITY = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5832:2: (iv_ruleVISIBILITY= ruleVISIBILITY EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5833:2: iv_ruleVISIBILITY= ruleVISIBILITY EOF
            {
             newCompositeNode(grammarAccess.getVISIBILITYRule()); 
            pushFollow(FOLLOW_ruleVISIBILITY_in_entryRuleVISIBILITY13608);
            iv_ruleVISIBILITY=ruleVISIBILITY();

            state._fsp--;

             current =iv_ruleVISIBILITY.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVISIBILITY13619); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVISIBILITY"


    // $ANTLR start "ruleVISIBILITY"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5840:1: ruleVISIBILITY returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'default' | kw= 'hidden' | kw= 'protected' ) ;
    public final AntlrDatatypeRuleToken ruleVISIBILITY() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5843:28: ( (kw= 'default' | kw= 'hidden' | kw= 'protected' ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5844:1: (kw= 'default' | kw= 'hidden' | kw= 'protected' )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5844:1: (kw= 'default' | kw= 'hidden' | kw= 'protected' )
            int alt112=3;
            switch ( input.LA(1) ) {
            case 195:
                {
                alt112=1;
                }
                break;
            case 196:
                {
                alt112=2;
                }
                break;
            case 197:
                {
                alt112=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 112, 0, input);

                throw nvae;
            }

            switch (alt112) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5845:2: kw= 'default'
                    {
                    kw=(Token)match(input,195,FOLLOW_195_in_ruleVISIBILITY13657); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getVISIBILITYAccess().getDefaultKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5852:2: kw= 'hidden'
                    {
                    kw=(Token)match(input,196,FOLLOW_196_in_ruleVISIBILITY13676); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getVISIBILITYAccess().getHiddenKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5859:2: kw= 'protected'
                    {
                    kw=(Token)match(input,197,FOLLOW_197_in_ruleVISIBILITY13695); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getVISIBILITYAccess().getProtectedKeyword_2()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVISIBILITY"


    // $ANTLR start "entryRuleLINKAGE"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5872:1: entryRuleLINKAGE returns [String current=null] : iv_ruleLINKAGE= ruleLINKAGE EOF ;
    public final String entryRuleLINKAGE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLINKAGE = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5873:2: (iv_ruleLINKAGE= ruleLINKAGE EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5874:2: iv_ruleLINKAGE= ruleLINKAGE EOF
            {
             newCompositeNode(grammarAccess.getLINKAGERule()); 
            pushFollow(FOLLOW_ruleLINKAGE_in_entryRuleLINKAGE13736);
            iv_ruleLINKAGE=ruleLINKAGE();

            state._fsp--;

             current =iv_ruleLINKAGE.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLINKAGE13747); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLINKAGE"


    // $ANTLR start "ruleLINKAGE"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5881:1: ruleLINKAGE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'private' | kw= 'linker_private' | kw= 'linker_private_weak' | kw= 'available_externally' | kw= 'linkonce' | kw= 'common' | kw= 'appending' | kw= 'extern_weak' | kw= 'linkonce_odr' | kw= 'linkonce_odr_auto_hide' | kw= 'dllimport' | kw= 'dllexport' | this_ALIAS_LINKAGE_12= ruleALIAS_LINKAGE ) ;
    public final AntlrDatatypeRuleToken ruleLINKAGE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ALIAS_LINKAGE_12 = null;


         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5884:28: ( (kw= 'private' | kw= 'linker_private' | kw= 'linker_private_weak' | kw= 'available_externally' | kw= 'linkonce' | kw= 'common' | kw= 'appending' | kw= 'extern_weak' | kw= 'linkonce_odr' | kw= 'linkonce_odr_auto_hide' | kw= 'dllimport' | kw= 'dllexport' | this_ALIAS_LINKAGE_12= ruleALIAS_LINKAGE ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5885:1: (kw= 'private' | kw= 'linker_private' | kw= 'linker_private_weak' | kw= 'available_externally' | kw= 'linkonce' | kw= 'common' | kw= 'appending' | kw= 'extern_weak' | kw= 'linkonce_odr' | kw= 'linkonce_odr_auto_hide' | kw= 'dllimport' | kw= 'dllexport' | this_ALIAS_LINKAGE_12= ruleALIAS_LINKAGE )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5885:1: (kw= 'private' | kw= 'linker_private' | kw= 'linker_private_weak' | kw= 'available_externally' | kw= 'linkonce' | kw= 'common' | kw= 'appending' | kw= 'extern_weak' | kw= 'linkonce_odr' | kw= 'linkonce_odr_auto_hide' | kw= 'dllimport' | kw= 'dllexport' | this_ALIAS_LINKAGE_12= ruleALIAS_LINKAGE )
            int alt113=13;
            switch ( input.LA(1) ) {
            case 198:
                {
                alt113=1;
                }
                break;
            case 199:
                {
                alt113=2;
                }
                break;
            case 200:
                {
                alt113=3;
                }
                break;
            case 201:
                {
                alt113=4;
                }
                break;
            case 202:
                {
                alt113=5;
                }
                break;
            case 203:
                {
                alt113=6;
                }
                break;
            case 204:
                {
                alt113=7;
                }
                break;
            case 205:
                {
                alt113=8;
                }
                break;
            case 206:
                {
                alt113=9;
                }
                break;
            case 207:
                {
                alt113=10;
                }
                break;
            case 208:
                {
                alt113=11;
                }
                break;
            case 209:
                {
                alt113=12;
                }
                break;
            case 210:
            case 211:
            case 212:
            case 213:
                {
                alt113=13;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 113, 0, input);

                throw nvae;
            }

            switch (alt113) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5886:2: kw= 'private'
                    {
                    kw=(Token)match(input,198,FOLLOW_198_in_ruleLINKAGE13785); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLINKAGEAccess().getPrivateKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5893:2: kw= 'linker_private'
                    {
                    kw=(Token)match(input,199,FOLLOW_199_in_ruleLINKAGE13804); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLINKAGEAccess().getLinker_privateKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5900:2: kw= 'linker_private_weak'
                    {
                    kw=(Token)match(input,200,FOLLOW_200_in_ruleLINKAGE13823); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLINKAGEAccess().getLinker_private_weakKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5907:2: kw= 'available_externally'
                    {
                    kw=(Token)match(input,201,FOLLOW_201_in_ruleLINKAGE13842); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLINKAGEAccess().getAvailable_externallyKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5914:2: kw= 'linkonce'
                    {
                    kw=(Token)match(input,202,FOLLOW_202_in_ruleLINKAGE13861); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLINKAGEAccess().getLinkonceKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5921:2: kw= 'common'
                    {
                    kw=(Token)match(input,203,FOLLOW_203_in_ruleLINKAGE13880); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLINKAGEAccess().getCommonKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5928:2: kw= 'appending'
                    {
                    kw=(Token)match(input,204,FOLLOW_204_in_ruleLINKAGE13899); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLINKAGEAccess().getAppendingKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5935:2: kw= 'extern_weak'
                    {
                    kw=(Token)match(input,205,FOLLOW_205_in_ruleLINKAGE13918); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLINKAGEAccess().getExtern_weakKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5942:2: kw= 'linkonce_odr'
                    {
                    kw=(Token)match(input,206,FOLLOW_206_in_ruleLINKAGE13937); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLINKAGEAccess().getLinkonce_odrKeyword_8()); 
                        

                    }
                    break;
                case 10 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5949:2: kw= 'linkonce_odr_auto_hide'
                    {
                    kw=(Token)match(input,207,FOLLOW_207_in_ruleLINKAGE13956); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLINKAGEAccess().getLinkonce_odr_auto_hideKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5956:2: kw= 'dllimport'
                    {
                    kw=(Token)match(input,208,FOLLOW_208_in_ruleLINKAGE13975); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLINKAGEAccess().getDllimportKeyword_10()); 
                        

                    }
                    break;
                case 12 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5963:2: kw= 'dllexport'
                    {
                    kw=(Token)match(input,209,FOLLOW_209_in_ruleLINKAGE13994); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLINKAGEAccess().getDllexportKeyword_11()); 
                        

                    }
                    break;
                case 13 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5970:5: this_ALIAS_LINKAGE_12= ruleALIAS_LINKAGE
                    {
                     
                            newCompositeNode(grammarAccess.getLINKAGEAccess().getALIAS_LINKAGEParserRuleCall_12()); 
                        
                    pushFollow(FOLLOW_ruleALIAS_LINKAGE_in_ruleLINKAGE14022);
                    this_ALIAS_LINKAGE_12=ruleALIAS_LINKAGE();

                    state._fsp--;


                    		current.merge(this_ALIAS_LINKAGE_12);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLINKAGE"


    // $ANTLR start "entryRuleALIAS_LINKAGE"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5988:1: entryRuleALIAS_LINKAGE returns [String current=null] : iv_ruleALIAS_LINKAGE= ruleALIAS_LINKAGE EOF ;
    public final String entryRuleALIAS_LINKAGE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleALIAS_LINKAGE = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5989:2: (iv_ruleALIAS_LINKAGE= ruleALIAS_LINKAGE EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5990:2: iv_ruleALIAS_LINKAGE= ruleALIAS_LINKAGE EOF
            {
             newCompositeNode(grammarAccess.getALIAS_LINKAGERule()); 
            pushFollow(FOLLOW_ruleALIAS_LINKAGE_in_entryRuleALIAS_LINKAGE14068);
            iv_ruleALIAS_LINKAGE=ruleALIAS_LINKAGE();

            state._fsp--;

             current =iv_ruleALIAS_LINKAGE.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleALIAS_LINKAGE14079); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleALIAS_LINKAGE"


    // $ANTLR start "ruleALIAS_LINKAGE"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:5997:1: ruleALIAS_LINKAGE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'external' | kw= 'internal' | kw= 'weak' | kw= 'weak_odr' ) ;
    public final AntlrDatatypeRuleToken ruleALIAS_LINKAGE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:6000:28: ( (kw= 'external' | kw= 'internal' | kw= 'weak' | kw= 'weak_odr' ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:6001:1: (kw= 'external' | kw= 'internal' | kw= 'weak' | kw= 'weak_odr' )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:6001:1: (kw= 'external' | kw= 'internal' | kw= 'weak' | kw= 'weak_odr' )
            int alt114=4;
            switch ( input.LA(1) ) {
            case 210:
                {
                alt114=1;
                }
                break;
            case 211:
                {
                alt114=2;
                }
                break;
            case 212:
                {
                alt114=3;
                }
                break;
            case 213:
                {
                alt114=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 114, 0, input);

                throw nvae;
            }

            switch (alt114) {
                case 1 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:6002:2: kw= 'external'
                    {
                    kw=(Token)match(input,210,FOLLOW_210_in_ruleALIAS_LINKAGE14117); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getALIAS_LINKAGEAccess().getExternalKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:6009:2: kw= 'internal'
                    {
                    kw=(Token)match(input,211,FOLLOW_211_in_ruleALIAS_LINKAGE14136); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getALIAS_LINKAGEAccess().getInternalKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:6016:2: kw= 'weak'
                    {
                    kw=(Token)match(input,212,FOLLOW_212_in_ruleALIAS_LINKAGE14155); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getALIAS_LINKAGEAccess().getWeakKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:6023:2: kw= 'weak_odr'
                    {
                    kw=(Token)match(input,213,FOLLOW_213_in_ruleALIAS_LINKAGE14174); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getALIAS_LINKAGEAccess().getWeak_odrKeyword_3()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleALIAS_LINKAGE"


    // $ANTLR start "entryRuleALIGNMENT"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:6038:1: entryRuleALIGNMENT returns [String current=null] : iv_ruleALIGNMENT= ruleALIGNMENT EOF ;
    public final String entryRuleALIGNMENT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleALIGNMENT = null;


        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:6039:2: (iv_ruleALIGNMENT= ruleALIGNMENT EOF )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:6040:2: iv_ruleALIGNMENT= ruleALIGNMENT EOF
            {
             newCompositeNode(grammarAccess.getALIGNMENTRule()); 
            pushFollow(FOLLOW_ruleALIGNMENT_in_entryRuleALIGNMENT14217);
            iv_ruleALIGNMENT=ruleALIGNMENT();

            state._fsp--;

             current =iv_ruleALIGNMENT.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleALIGNMENT14228); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleALIGNMENT"


    // $ANTLR start "ruleALIGNMENT"
    // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:6047:1: ruleALIGNMENT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'align' this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleALIGNMENT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;

         enterRule(); 
            
        try {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:6050:28: ( (kw= 'align' this_INT_1= RULE_INT ) )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:6051:1: (kw= 'align' this_INT_1= RULE_INT )
            {
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:6051:1: (kw= 'align' this_INT_1= RULE_INT )
            // ../de.upb.llvm_parser/src-gen/de/upb/llvm_parser/parser/antlr/internal/InternalLLVM.g:6052:2: kw= 'align' this_INT_1= RULE_INT
            {
            kw=(Token)match(input,78,FOLLOW_78_in_ruleALIGNMENT14266); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getALIGNMENTAccess().getAlignKeyword_0()); 
                
            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleALIGNMENT14281); 

            		current.merge(this_INT_1);
                
             
                newLeafNode(this_INT_1, grammarAccess.getALIGNMENTAccess().getINTTerminalRuleCall_1()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleALIGNMENT"

    // Delegated rules


    protected DFA89 dfa89 = new DFA89(this);
    protected DFA108 dfa108 = new DFA108(this);
    protected DFA109 dfa109 = new DFA109(this);
    static final String DFA89_eotS =
        "\170\uffff";
    static final String DFA89_eofS =
        "\170\uffff";
    static final String DFA89_minS =
        "\1\175\2\6\1\40\15\176\15\27\1\176\3\6\15\27\1\45\1\6\1\uffff\15"+
        "\6\15\27\1\6\1\176\15\27\1\uffff\15\27\1\6\15\27\1\6";
    static final String DFA89_maxS =
        "\1\175\2\57\1\40\15\176\15\41\1\176\3\57\15\41\1\45\1\57\1\uffff"+
        "\15\u0094\15\41\1\57\1\176\15\41\1\uffff\15\41\1\57\15\41\1\u0094";
    static final String DFA89_acceptS =
        "\61\uffff\1\2\51\uffff\1\1\34\uffff";
    static final String DFA89_specialS =
        "\170\uffff}>";
    static final String[] DFA89_transitionS = {
            "\1\1",
            "\1\4\1\5\1\20\27\uffff\1\2\3\uffff\1\3\1\uffff\1\14\1\15\1"+
            "\16\1\17\1\6\1\7\1\10\1\11\1\12\1\13",
            "\1\21\1\22\1\35\30\uffff\1\36\4\uffff\1\31\1\32\1\33\1\34"+
            "\1\23\1\24\1\25\1\26\1\27\1\30",
            "\1\37",
            "\1\40",
            "\1\40",
            "\1\40",
            "\1\40",
            "\1\40",
            "\1\40",
            "\1\40",
            "\1\40",
            "\1\40",
            "\1\40",
            "\1\40",
            "\1\40",
            "\1\40",
            "\1\41\11\uffff\1\36",
            "\1\41\11\uffff\1\36",
            "\1\41\11\uffff\1\36",
            "\1\41\11\uffff\1\36",
            "\1\41\11\uffff\1\36",
            "\1\41\11\uffff\1\36",
            "\1\41\11\uffff\1\36",
            "\1\41\11\uffff\1\36",
            "\1\41\11\uffff\1\36",
            "\1\41\11\uffff\1\36",
            "\1\41\11\uffff\1\36",
            "\1\41\11\uffff\1\36",
            "\1\41\11\uffff\1\36",
            "\1\40",
            "\1\42\1\43\1\56\30\uffff\1\57\4\uffff\1\52\1\53\1\54\1\55"+
            "\1\44\1\45\1\46\1\47\1\50\1\51",
            "\1\62\1\63\1\76\27\uffff\1\60\3\uffff\1\61\1\uffff\1\72\1"+
            "\73\1\74\1\75\1\64\1\65\1\66\1\67\1\70\1\71",
            "\1\77\1\100\1\113\35\uffff\1\107\1\110\1\111\1\112\1\101\1"+
            "\102\1\103\1\104\1\105\1\106",
            "\1\114\11\uffff\1\57",
            "\1\114\11\uffff\1\57",
            "\1\114\11\uffff\1\57",
            "\1\114\11\uffff\1\57",
            "\1\114\11\uffff\1\57",
            "\1\114\11\uffff\1\57",
            "\1\114\11\uffff\1\57",
            "\1\114\11\uffff\1\57",
            "\1\114\11\uffff\1\57",
            "\1\114\11\uffff\1\57",
            "\1\114\11\uffff\1\57",
            "\1\114\11\uffff\1\57",
            "\1\114\11\uffff\1\57",
            "\1\115",
            "\1\116\1\117\1\132\27\uffff\1\133\1\61\2\uffff\1\133\1\uffff"+
            "\1\126\1\127\1\130\1\131\1\120\1\121\1\122\1\123\1\124\1\125",
            "",
            "\3\133\27\uffff\1\133\3\uffff\1\133\1\uffff\12\133\131\uffff"+
            "\14\61",
            "\3\133\27\uffff\1\133\3\uffff\1\133\1\uffff\12\133\131\uffff"+
            "\14\61",
            "\3\133\27\uffff\1\133\3\uffff\1\133\1\uffff\12\133\131\uffff"+
            "\14\61",
            "\3\133\27\uffff\1\133\3\uffff\1\133\1\uffff\12\133\131\uffff"+
            "\14\61",
            "\3\133\27\uffff\1\133\3\uffff\1\133\1\uffff\12\133\131\uffff"+
            "\14\61",
            "\3\133\27\uffff\1\133\3\uffff\1\133\1\uffff\12\133\131\uffff"+
            "\14\61",
            "\3\133\27\uffff\1\133\3\uffff\1\133\1\uffff\12\133\131\uffff"+
            "\14\61",
            "\3\133\27\uffff\1\133\3\uffff\1\133\1\uffff\12\133\131\uffff"+
            "\14\61",
            "\3\133\27\uffff\1\133\3\uffff\1\133\1\uffff\12\133\131\uffff"+
            "\14\61",
            "\3\133\27\uffff\1\133\3\uffff\1\133\1\uffff\12\133\131\uffff"+
            "\14\61",
            "\3\133\27\uffff\1\133\3\uffff\1\133\1\uffff\12\133\131\uffff"+
            "\14\61",
            "\3\133\27\uffff\1\133\3\uffff\1\133\1\uffff\12\133\131\uffff"+
            "\14\61",
            "\3\133\27\uffff\1\133\3\uffff\1\133\1\uffff\12\133\131\uffff"+
            "\14\61",
            "\1\41\11\uffff\1\36",
            "\1\41\11\uffff\1\36",
            "\1\41\11\uffff\1\36",
            "\1\41\11\uffff\1\36",
            "\1\41\11\uffff\1\36",
            "\1\41\11\uffff\1\36",
            "\1\41\11\uffff\1\36",
            "\1\41\11\uffff\1\36",
            "\1\41\11\uffff\1\36",
            "\1\41\11\uffff\1\36",
            "\1\41\11\uffff\1\36",
            "\1\41\11\uffff\1\36",
            "\1\41\11\uffff\1\36",
            "\1\134\1\135\1\150\35\uffff\1\144\1\145\1\146\1\147\1\136"+
            "\1\137\1\140\1\141\1\142\1\143",
            "\1\40",
            "\1\151\11\uffff\1\61",
            "\1\151\11\uffff\1\61",
            "\1\151\11\uffff\1\61",
            "\1\151\11\uffff\1\61",
            "\1\151\11\uffff\1\61",
            "\1\151\11\uffff\1\61",
            "\1\151\11\uffff\1\61",
            "\1\151\11\uffff\1\61",
            "\1\151\11\uffff\1\61",
            "\1\151\11\uffff\1\61",
            "\1\151\11\uffff\1\61",
            "\1\151\11\uffff\1\61",
            "\1\151\11\uffff\1\61",
            "",
            "\1\114\11\uffff\1\57",
            "\1\114\11\uffff\1\57",
            "\1\114\11\uffff\1\57",
            "\1\114\11\uffff\1\57",
            "\1\114\11\uffff\1\57",
            "\1\114\11\uffff\1\57",
            "\1\114\11\uffff\1\57",
            "\1\114\11\uffff\1\57",
            "\1\114\11\uffff\1\57",
            "\1\114\11\uffff\1\57",
            "\1\114\11\uffff\1\57",
            "\1\114\11\uffff\1\57",
            "\1\114\11\uffff\1\57",
            "\1\152\1\153\1\166\27\uffff\1\133\3\uffff\1\133\1\uffff\1"+
            "\162\1\163\1\164\1\165\1\154\1\155\1\156\1\157\1\160\1\161",
            "\1\61\11\uffff\1\167",
            "\1\61\11\uffff\1\167",
            "\1\61\11\uffff\1\167",
            "\1\61\11\uffff\1\167",
            "\1\61\11\uffff\1\167",
            "\1\61\11\uffff\1\167",
            "\1\61\11\uffff\1\167",
            "\1\61\11\uffff\1\167",
            "\1\61\11\uffff\1\167",
            "\1\61\11\uffff\1\167",
            "\1\61\11\uffff\1\167",
            "\1\61\11\uffff\1\167",
            "\1\61\11\uffff\1\167",
            "\3\133\27\uffff\1\133\3\uffff\1\133\1\uffff\12\133\131\uffff"+
            "\14\61"
    };

    static final short[] DFA89_eot = DFA.unpackEncodedString(DFA89_eotS);
    static final short[] DFA89_eof = DFA.unpackEncodedString(DFA89_eofS);
    static final char[] DFA89_min = DFA.unpackEncodedStringToUnsignedChars(DFA89_minS);
    static final char[] DFA89_max = DFA.unpackEncodedStringToUnsignedChars(DFA89_maxS);
    static final short[] DFA89_accept = DFA.unpackEncodedString(DFA89_acceptS);
    static final short[] DFA89_special = DFA.unpackEncodedString(DFA89_specialS);
    static final short[][] DFA89_transition;

    static {
        int numStates = DFA89_transitionS.length;
        DFA89_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA89_transition[i] = DFA.unpackEncodedString(DFA89_transitionS[i]);
        }
    }

    class DFA89 extends DFA {

        public DFA89(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 89;
            this.eot = DFA89_eot;
            this.eof = DFA89_eof;
            this.min = DFA89_min;
            this.max = DFA89_max;
            this.accept = DFA89_accept;
            this.special = DFA89_special;
            this.transition = DFA89_transition;
        }
        public String getDescription() {
            return "3340:1: ( (otherlv_0= 'landingpad' ( (lv_type_1_0= ruleType ) ) otherlv_2= 'personality' ( (lv_personality_3_0= ruleTypeAndValue ) ) ( (otherlv_4= 'cleanup' ( (lv_clause_5_0= ruleClause ) )* ) | ( (lv_clause_6_0= ruleClause ) )+ ) ) | (otherlv_7= 'landingpad' ( (lv_type_8_0= ruleType ) ) otherlv_9= 'personality' ( (lv_personalitytype_10_0= ruleType ) ) ( (lv_personalityfunction_11_0= ruleCAST_TYPE ) ) otherlv_12= '(' ( (lv_value_13_0= ruleType ) ) otherlv_14= '(...)*' this_VAR_TYPE_15= RULE_VAR_TYPE otherlv_16= 'to' ( (lv_castto_17_0= ruleType ) ) otherlv_18= ')' ( (otherlv_19= 'cleanup' ( (lv_clause_20_0= ruleClause ) )* ) | ( (lv_clause_21_0= ruleClause ) )+ ) ) )";
        }
    }
    static final String DFA108_eotS =
        "\116\uffff";
    static final String DFA108_eofS =
        "\3\uffff\1\4\3\uffff\15\2\15\uffff\1\2\36\uffff\1\2\15\uffff";
    static final String DFA108_minS =
        "\1\u00bf\1\6\1\uffff\1\4\1\uffff\1\6\1\40\15\4\15\27\1\4\2\6\15"+
        "\27\1\45\15\27\1\6\1\4\15\27";
    static final String DFA108_maxS =
        "\1\u00bf\1\57\1\uffff\1\u00c1\1\uffff\1\57\1\40\15\u00c1\15\41"+
        "\1\u00c1\2\57\15\41\1\45\15\41\1\57\1\u00c1\15\41";
    static final String DFA108_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\111\uffff";
    static final String DFA108_specialS =
        "\116\uffff}>";
    static final String[] DFA108_transitionS = {
            "\1\1",
            "\3\2\27\uffff\1\2\5\uffff\1\3\11\2",
            "",
            "\1\4\1\uffff\1\7\1\10\1\23\1\4\5\uffff\1\4\1\uffff\1\4\3\uffff"+
            "\1\4\1\uffff\1\4\1\uffff\1\4\2\uffff\1\4\3\uffff\1\5\1\4\2\uffff"+
            "\1\6\1\uffff\1\17\1\20\1\21\1\22\1\11\1\12\1\13\1\14\1\15\1"+
            "\16\1\4\1\uffff\3\4\7\uffff\1\4\1\uffff\1\4\1\uffff\3\4\1\uffff"+
            "\2\4\4\uffff\1\4\4\uffff\3\4\10\uffff\1\4\41\uffff\2\4\6\uffff"+
            "\23\4\26\uffff\20\4\1\uffff\2\4\1\uffff\1\4",
            "",
            "\1\24\1\25\1\40\30\uffff\1\41\4\uffff\1\34\1\35\1\36\1\37"+
            "\1\26\1\27\1\30\1\31\1\32\1\33",
            "\1\42",
            "\1\2\1\uffff\4\2\5\uffff\1\2\1\uffff\1\2\2\uffff\1\4\1\2\1"+
            "\uffff\1\2\1\uffff\1\2\2\uffff\1\2\3\uffff\2\2\2\uffff\1\2\1"+
            "\uffff\13\2\1\uffff\3\2\7\uffff\1\2\1\uffff\1\2\1\uffff\3\2"+
            "\1\uffff\2\2\4\uffff\1\2\4\uffff\3\2\10\uffff\1\2\41\uffff\2"+
            "\2\6\uffff\23\2\26\uffff\20\2\1\uffff\2\2\1\uffff\1\2",
            "\1\2\1\uffff\4\2\5\uffff\1\2\1\uffff\1\2\2\uffff\1\4\1\2\1"+
            "\uffff\1\2\1\uffff\1\2\2\uffff\1\2\3\uffff\2\2\2\uffff\1\2\1"+
            "\uffff\13\2\1\uffff\3\2\7\uffff\1\2\1\uffff\1\2\1\uffff\3\2"+
            "\1\uffff\2\2\4\uffff\1\2\4\uffff\3\2\10\uffff\1\2\41\uffff\2"+
            "\2\6\uffff\23\2\26\uffff\20\2\1\uffff\2\2\1\uffff\1\2",
            "\1\2\1\uffff\4\2\5\uffff\1\2\1\uffff\1\2\2\uffff\1\4\1\2\1"+
            "\uffff\1\2\1\uffff\1\2\2\uffff\1\2\3\uffff\2\2\2\uffff\1\2\1"+
            "\uffff\13\2\1\uffff\3\2\7\uffff\1\2\1\uffff\1\2\1\uffff\3\2"+
            "\1\uffff\2\2\4\uffff\1\2\4\uffff\3\2\10\uffff\1\2\41\uffff\2"+
            "\2\6\uffff\23\2\26\uffff\20\2\1\uffff\2\2\1\uffff\1\2",
            "\1\2\1\uffff\4\2\5\uffff\1\2\1\uffff\1\2\2\uffff\1\4\1\2\1"+
            "\uffff\1\2\1\uffff\1\2\2\uffff\1\2\3\uffff\2\2\2\uffff\1\2\1"+
            "\uffff\13\2\1\uffff\3\2\7\uffff\1\2\1\uffff\1\2\1\uffff\3\2"+
            "\1\uffff\2\2\4\uffff\1\2\4\uffff\3\2\10\uffff\1\2\41\uffff\2"+
            "\2\6\uffff\23\2\26\uffff\20\2\1\uffff\2\2\1\uffff\1\2",
            "\1\2\1\uffff\4\2\5\uffff\1\2\1\uffff\1\2\2\uffff\1\4\1\2\1"+
            "\uffff\1\2\1\uffff\1\2\2\uffff\1\2\3\uffff\2\2\2\uffff\1\2\1"+
            "\uffff\13\2\1\uffff\3\2\7\uffff\1\2\1\uffff\1\2\1\uffff\3\2"+
            "\1\uffff\2\2\4\uffff\1\2\4\uffff\3\2\10\uffff\1\2\41\uffff\2"+
            "\2\6\uffff\23\2\26\uffff\20\2\1\uffff\2\2\1\uffff\1\2",
            "\1\2\1\uffff\4\2\5\uffff\1\2\1\uffff\1\2\2\uffff\1\4\1\2\1"+
            "\uffff\1\2\1\uffff\1\2\2\uffff\1\2\3\uffff\2\2\2\uffff\1\2\1"+
            "\uffff\13\2\1\uffff\3\2\7\uffff\1\2\1\uffff\1\2\1\uffff\3\2"+
            "\1\uffff\2\2\4\uffff\1\2\4\uffff\3\2\10\uffff\1\2\41\uffff\2"+
            "\2\6\uffff\23\2\26\uffff\20\2\1\uffff\2\2\1\uffff\1\2",
            "\1\2\1\uffff\4\2\5\uffff\1\2\1\uffff\1\2\2\uffff\1\4\1\2\1"+
            "\uffff\1\2\1\uffff\1\2\2\uffff\1\2\3\uffff\2\2\2\uffff\1\2\1"+
            "\uffff\13\2\1\uffff\3\2\7\uffff\1\2\1\uffff\1\2\1\uffff\3\2"+
            "\1\uffff\2\2\4\uffff\1\2\4\uffff\3\2\10\uffff\1\2\41\uffff\2"+
            "\2\6\uffff\23\2\26\uffff\20\2\1\uffff\2\2\1\uffff\1\2",
            "\1\2\1\uffff\4\2\5\uffff\1\2\1\uffff\1\2\2\uffff\1\4\1\2\1"+
            "\uffff\1\2\1\uffff\1\2\2\uffff\1\2\3\uffff\2\2\2\uffff\1\2\1"+
            "\uffff\13\2\1\uffff\3\2\7\uffff\1\2\1\uffff\1\2\1\uffff\3\2"+
            "\1\uffff\2\2\4\uffff\1\2\4\uffff\3\2\10\uffff\1\2\41\uffff\2"+
            "\2\6\uffff\23\2\26\uffff\20\2\1\uffff\2\2\1\uffff\1\2",
            "\1\2\1\uffff\4\2\5\uffff\1\2\1\uffff\1\2\2\uffff\1\4\1\2\1"+
            "\uffff\1\2\1\uffff\1\2\2\uffff\1\2\3\uffff\2\2\2\uffff\1\2\1"+
            "\uffff\13\2\1\uffff\3\2\7\uffff\1\2\1\uffff\1\2\1\uffff\3\2"+
            "\1\uffff\2\2\4\uffff\1\2\4\uffff\3\2\10\uffff\1\2\41\uffff\2"+
            "\2\6\uffff\23\2\26\uffff\20\2\1\uffff\2\2\1\uffff\1\2",
            "\1\2\1\uffff\4\2\5\uffff\1\2\1\uffff\1\2\2\uffff\1\4\1\2\1"+
            "\uffff\1\2\1\uffff\1\2\2\uffff\1\2\3\uffff\2\2\2\uffff\1\2\1"+
            "\uffff\13\2\1\uffff\3\2\7\uffff\1\2\1\uffff\1\2\1\uffff\3\2"+
            "\1\uffff\2\2\4\uffff\1\2\4\uffff\3\2\10\uffff\1\2\41\uffff\2"+
            "\2\6\uffff\23\2\26\uffff\20\2\1\uffff\2\2\1\uffff\1\2",
            "\1\2\1\uffff\4\2\5\uffff\1\2\1\uffff\1\2\2\uffff\1\4\1\2\1"+
            "\uffff\1\2\1\uffff\1\2\2\uffff\1\2\3\uffff\2\2\2\uffff\1\2\1"+
            "\uffff\13\2\1\uffff\3\2\7\uffff\1\2\1\uffff\1\2\1\uffff\3\2"+
            "\1\uffff\2\2\4\uffff\1\2\4\uffff\3\2\10\uffff\1\2\41\uffff\2"+
            "\2\6\uffff\23\2\26\uffff\20\2\1\uffff\2\2\1\uffff\1\2",
            "\1\2\1\uffff\4\2\5\uffff\1\2\1\uffff\1\2\2\uffff\1\4\1\2\1"+
            "\uffff\1\2\1\uffff\1\2\2\uffff\1\2\3\uffff\2\2\2\uffff\1\2\1"+
            "\uffff\13\2\1\uffff\3\2\7\uffff\1\2\1\uffff\1\2\1\uffff\3\2"+
            "\1\uffff\2\2\4\uffff\1\2\4\uffff\3\2\10\uffff\1\2\41\uffff\2"+
            "\2\6\uffff\23\2\26\uffff\20\2\1\uffff\2\2\1\uffff\1\2",
            "\1\2\1\uffff\4\2\5\uffff\1\2\1\uffff\1\2\2\uffff\1\4\1\2\1"+
            "\uffff\1\2\1\uffff\1\2\2\uffff\1\2\3\uffff\2\2\2\uffff\1\2\1"+
            "\uffff\13\2\1\uffff\3\2\7\uffff\1\2\1\uffff\1\2\1\uffff\3\2"+
            "\1\uffff\2\2\4\uffff\1\2\4\uffff\3\2\10\uffff\1\2\41\uffff\2"+
            "\2\6\uffff\23\2\26\uffff\20\2\1\uffff\2\2\1\uffff\1\2",
            "\1\43\11\uffff\1\41",
            "\1\43\11\uffff\1\41",
            "\1\43\11\uffff\1\41",
            "\1\43\11\uffff\1\41",
            "\1\43\11\uffff\1\41",
            "\1\43\11\uffff\1\41",
            "\1\43\11\uffff\1\41",
            "\1\43\11\uffff\1\41",
            "\1\43\11\uffff\1\41",
            "\1\43\11\uffff\1\41",
            "\1\43\11\uffff\1\41",
            "\1\43\11\uffff\1\41",
            "\1\43\11\uffff\1\41",
            "\1\2\1\uffff\4\2\5\uffff\1\2\1\uffff\1\2\2\uffff\1\4\1\2\1"+
            "\uffff\1\2\1\uffff\1\2\2\uffff\1\2\3\uffff\2\2\2\uffff\1\2\1"+
            "\uffff\13\2\1\uffff\3\2\7\uffff\1\2\1\uffff\1\2\1\uffff\3\2"+
            "\1\uffff\2\2\4\uffff\1\2\4\uffff\3\2\10\uffff\1\2\41\uffff\2"+
            "\2\6\uffff\23\2\26\uffff\20\2\1\uffff\2\2\1\uffff\1\2",
            "\1\44\1\45\1\60\30\uffff\1\61\4\uffff\1\54\1\55\1\56\1\57"+
            "\1\46\1\47\1\50\1\51\1\52\1\53",
            "\1\62\1\63\1\76\35\uffff\1\72\1\73\1\74\1\75\1\64\1\65\1\66"+
            "\1\67\1\70\1\71",
            "\1\77\11\uffff\1\61",
            "\1\77\11\uffff\1\61",
            "\1\77\11\uffff\1\61",
            "\1\77\11\uffff\1\61",
            "\1\77\11\uffff\1\61",
            "\1\77\11\uffff\1\61",
            "\1\77\11\uffff\1\61",
            "\1\77\11\uffff\1\61",
            "\1\77\11\uffff\1\61",
            "\1\77\11\uffff\1\61",
            "\1\77\11\uffff\1\61",
            "\1\77\11\uffff\1\61",
            "\1\77\11\uffff\1\61",
            "\1\100",
            "\1\43\11\uffff\1\41",
            "\1\43\11\uffff\1\41",
            "\1\43\11\uffff\1\41",
            "\1\43\11\uffff\1\41",
            "\1\43\11\uffff\1\41",
            "\1\43\11\uffff\1\41",
            "\1\43\11\uffff\1\41",
            "\1\43\11\uffff\1\41",
            "\1\43\11\uffff\1\41",
            "\1\43\11\uffff\1\41",
            "\1\43\11\uffff\1\41",
            "\1\43\11\uffff\1\41",
            "\1\43\11\uffff\1\41",
            "\1\101\1\102\1\115\35\uffff\1\111\1\112\1\113\1\114\1\103"+
            "\1\104\1\105\1\106\1\107\1\110",
            "\1\2\1\uffff\4\2\5\uffff\1\2\1\uffff\1\2\2\uffff\1\4\1\2\1"+
            "\uffff\1\2\1\uffff\1\2\2\uffff\1\2\3\uffff\2\2\2\uffff\1\2\1"+
            "\uffff\13\2\1\uffff\3\2\7\uffff\1\2\1\uffff\1\2\1\uffff\3\2"+
            "\1\uffff\2\2\4\uffff\1\2\4\uffff\3\2\10\uffff\1\2\41\uffff\2"+
            "\2\6\uffff\23\2\26\uffff\20\2\1\uffff\2\2\1\uffff\1\2",
            "\1\77\11\uffff\1\61",
            "\1\77\11\uffff\1\61",
            "\1\77\11\uffff\1\61",
            "\1\77\11\uffff\1\61",
            "\1\77\11\uffff\1\61",
            "\1\77\11\uffff\1\61",
            "\1\77\11\uffff\1\61",
            "\1\77\11\uffff\1\61",
            "\1\77\11\uffff\1\61",
            "\1\77\11\uffff\1\61",
            "\1\77\11\uffff\1\61",
            "\1\77\11\uffff\1\61",
            "\1\77\11\uffff\1\61"
    };

    static final short[] DFA108_eot = DFA.unpackEncodedString(DFA108_eotS);
    static final short[] DFA108_eof = DFA.unpackEncodedString(DFA108_eofS);
    static final char[] DFA108_min = DFA.unpackEncodedStringToUnsignedChars(DFA108_minS);
    static final char[] DFA108_max = DFA.unpackEncodedStringToUnsignedChars(DFA108_maxS);
    static final short[] DFA108_accept = DFA.unpackEncodedString(DFA108_acceptS);
    static final short[] DFA108_special = DFA.unpackEncodedString(DFA108_specialS);
    static final short[][] DFA108_transition;

    static {
        int numStates = DFA108_transitionS.length;
        DFA108_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA108_transition[i] = DFA.unpackEncodedString(DFA108_transitionS[i]);
        }
    }

    class DFA108 extends DFA {

        public DFA108(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 108;
            this.eot = DFA108_eot;
            this.eof = DFA108_eof;
            this.min = DFA108_min;
            this.max = DFA108_max;
            this.accept = DFA108_accept;
            this.special = DFA108_special;
            this.transition = DFA108_transition;
        }
        public String getDescription() {
            return "5536:1: ( ( () otherlv_1= 'ret' otherlv_2= 'void' (otherlv_3= ',' otherlv_4= '!dbg' otherlv_5= '!' this_INT_6= RULE_INT )? ) | (otherlv_7= 'ret' ( (lv_value_8_0= ruleTypeAndValue ) ) (otherlv_9= ',' otherlv_10= '!dbg' otherlv_11= '!' this_INT_12= RULE_INT )? ) )";
        }
    }
    static final String DFA109_eotS =
        "\u0138\uffff";
    static final String DFA109_eofS =
        "\22\uffff\15\76\34\uffff\1\76\116\uffff\1\76\112\uffff\15\76\34"+
        "\uffff\1\76\53\uffff\1\76\15\uffff";
    static final String DFA109_minS =
        "\1\u00c1\20\6\1\40\15\4\1\6\1\40\32\27\1\4\1\6\2\uffff\16\27\3"+
        "\6\15\27\1\45\1\6\15\27\1\45\1\6\1\40\15\41\15\27\1\6\1\4\15\27"+
        "\1\6\16\27\1\41\2\6\32\27\1\6\15\27\1\45\1\6\1\40\15\4\15\27\1\6"+
        "\1\41\15\27\1\4\1\6\15\27\1\6\15\27\1\45\15\27\1\6\1\4\15\27";
    static final String DFA109_maxS =
        "\1\u00c1\20\57\1\40\15\u00c1\1\57\1\40\15\27\15\41\1\u00c1\1\57"+
        "\2\uffff\15\41\1\27\3\57\15\41\1\45\1\57\15\41\1\45\1\57\1\40\32"+
        "\41\1\57\1\u00c1\15\41\1\57\1\27\16\41\2\57\32\41\1\57\15\41\1\45"+
        "\1\57\1\40\15\u00c1\15\41\1\57\16\41\1\u00c1\1\57\15\41\1\57\15"+
        "\41\1\45\15\41\1\57\1\u00c1\15\41";
    static final String DFA109_acceptS =
        "\75\uffff\1\2\1\1\u00f9\uffff";
    static final String DFA109_specialS =
        "\u0138\uffff}>";
    static final String[] DFA109_transitionS = {
            "\1\1",
            "\1\2\1\3\1\16\27\uffff\1\17\5\uffff\1\12\1\13\1\14\1\15\1"+
            "\4\1\5\1\6\1\7\1\10\1\11",
            "\1\22\1\23\1\36\27\uffff\1\20\3\uffff\1\21\1\uffff\1\32\1"+
            "\33\1\34\1\35\1\24\1\25\1\26\1\27\1\30\1\31",
            "\1\22\1\23\1\36\27\uffff\1\20\3\uffff\1\21\1\uffff\1\32\1"+
            "\33\1\34\1\35\1\24\1\25\1\26\1\27\1\30\1\31",
            "\1\22\1\23\1\36\27\uffff\1\20\3\uffff\1\21\1\uffff\1\32\1"+
            "\33\1\34\1\35\1\24\1\25\1\26\1\27\1\30\1\31",
            "\1\22\1\23\1\36\27\uffff\1\20\3\uffff\1\21\1\uffff\1\32\1"+
            "\33\1\34\1\35\1\24\1\25\1\26\1\27\1\30\1\31",
            "\1\22\1\23\1\36\27\uffff\1\20\3\uffff\1\21\1\uffff\1\32\1"+
            "\33\1\34\1\35\1\24\1\25\1\26\1\27\1\30\1\31",
            "\1\22\1\23\1\36\27\uffff\1\20\3\uffff\1\21\1\uffff\1\32\1"+
            "\33\1\34\1\35\1\24\1\25\1\26\1\27\1\30\1\31",
            "\1\22\1\23\1\36\27\uffff\1\20\3\uffff\1\21\1\uffff\1\32\1"+
            "\33\1\34\1\35\1\24\1\25\1\26\1\27\1\30\1\31",
            "\1\22\1\23\1\36\27\uffff\1\20\3\uffff\1\21\1\uffff\1\32\1"+
            "\33\1\34\1\35\1\24\1\25\1\26\1\27\1\30\1\31",
            "\1\22\1\23\1\36\27\uffff\1\20\3\uffff\1\21\1\uffff\1\32\1"+
            "\33\1\34\1\35\1\24\1\25\1\26\1\27\1\30\1\31",
            "\1\22\1\23\1\36\27\uffff\1\20\3\uffff\1\21\1\uffff\1\32\1"+
            "\33\1\34\1\35\1\24\1\25\1\26\1\27\1\30\1\31",
            "\1\22\1\23\1\36\27\uffff\1\20\3\uffff\1\21\1\uffff\1\32\1"+
            "\33\1\34\1\35\1\24\1\25\1\26\1\27\1\30\1\31",
            "\1\22\1\23\1\36\27\uffff\1\20\3\uffff\1\21\1\uffff\1\32\1"+
            "\33\1\34\1\35\1\24\1\25\1\26\1\27\1\30\1\31",
            "\1\22\1\23\1\36\27\uffff\1\20\3\uffff\1\21\1\uffff\1\32\1"+
            "\33\1\34\1\35\1\24\1\25\1\26\1\27\1\30\1\31",
            "\1\41\1\42\1\55\27\uffff\1\37\3\uffff\1\40\1\uffff\1\51\1"+
            "\52\1\53\1\54\1\43\1\44\1\45\1\46\1\47\1\50",
            "\1\56\1\57\1\72\30\uffff\1\73\4\uffff\1\66\1\67\1\70\1\71"+
            "\1\60\1\61\1\62\1\63\1\64\1\65",
            "\1\74",
            "\1\76\1\uffff\4\76\5\uffff\1\76\1\uffff\1\76\3\uffff\1\76"+
            "\1\uffff\1\75\1\uffff\1\76\2\uffff\1\76\3\uffff\2\76\2\uffff"+
            "\1\76\1\uffff\13\76\1\uffff\3\76\7\uffff\1\76\1\uffff\1\76\1"+
            "\uffff\3\76\1\uffff\2\76\4\uffff\1\76\4\uffff\3\76\10\uffff"+
            "\1\76\41\uffff\2\76\6\uffff\23\76\26\uffff\20\76\1\uffff\2\76"+
            "\1\uffff\1\76",
            "\1\76\1\uffff\4\76\5\uffff\1\76\1\uffff\1\76\3\uffff\1\76"+
            "\1\uffff\1\75\1\uffff\1\76\2\uffff\1\76\3\uffff\2\76\2\uffff"+
            "\1\76\1\uffff\13\76\1\uffff\3\76\7\uffff\1\76\1\uffff\1\76\1"+
            "\uffff\3\76\1\uffff\2\76\4\uffff\1\76\4\uffff\3\76\10\uffff"+
            "\1\76\41\uffff\2\76\6\uffff\23\76\26\uffff\20\76\1\uffff\2\76"+
            "\1\uffff\1\76",
            "\1\76\1\uffff\4\76\5\uffff\1\76\1\uffff\1\76\3\uffff\1\76"+
            "\1\uffff\1\75\1\uffff\1\76\2\uffff\1\76\3\uffff\2\76\2\uffff"+
            "\1\76\1\uffff\13\76\1\uffff\3\76\7\uffff\1\76\1\uffff\1\76\1"+
            "\uffff\3\76\1\uffff\2\76\4\uffff\1\76\4\uffff\3\76\10\uffff"+
            "\1\76\41\uffff\2\76\6\uffff\23\76\26\uffff\20\76\1\uffff\2\76"+
            "\1\uffff\1\76",
            "\1\76\1\uffff\4\76\5\uffff\1\76\1\uffff\1\76\3\uffff\1\76"+
            "\1\uffff\1\75\1\uffff\1\76\2\uffff\1\76\3\uffff\2\76\2\uffff"+
            "\1\76\1\uffff\13\76\1\uffff\3\76\7\uffff\1\76\1\uffff\1\76\1"+
            "\uffff\3\76\1\uffff\2\76\4\uffff\1\76\4\uffff\3\76\10\uffff"+
            "\1\76\41\uffff\2\76\6\uffff\23\76\26\uffff\20\76\1\uffff\2\76"+
            "\1\uffff\1\76",
            "\1\76\1\uffff\4\76\5\uffff\1\76\1\uffff\1\76\3\uffff\1\76"+
            "\1\uffff\1\75\1\uffff\1\76\2\uffff\1\76\3\uffff\2\76\2\uffff"+
            "\1\76\1\uffff\13\76\1\uffff\3\76\7\uffff\1\76\1\uffff\1\76\1"+
            "\uffff\3\76\1\uffff\2\76\4\uffff\1\76\4\uffff\3\76\10\uffff"+
            "\1\76\41\uffff\2\76\6\uffff\23\76\26\uffff\20\76\1\uffff\2\76"+
            "\1\uffff\1\76",
            "\1\76\1\uffff\4\76\5\uffff\1\76\1\uffff\1\76\3\uffff\1\76"+
            "\1\uffff\1\75\1\uffff\1\76\2\uffff\1\76\3\uffff\2\76\2\uffff"+
            "\1\76\1\uffff\13\76\1\uffff\3\76\7\uffff\1\76\1\uffff\1\76\1"+
            "\uffff\3\76\1\uffff\2\76\4\uffff\1\76\4\uffff\3\76\10\uffff"+
            "\1\76\41\uffff\2\76\6\uffff\23\76\26\uffff\20\76\1\uffff\2\76"+
            "\1\uffff\1\76",
            "\1\76\1\uffff\4\76\5\uffff\1\76\1\uffff\1\76\3\uffff\1\76"+
            "\1\uffff\1\75\1\uffff\1\76\2\uffff\1\76\3\uffff\2\76\2\uffff"+
            "\1\76\1\uffff\13\76\1\uffff\3\76\7\uffff\1\76\1\uffff\1\76\1"+
            "\uffff\3\76\1\uffff\2\76\4\uffff\1\76\4\uffff\3\76\10\uffff"+
            "\1\76\41\uffff\2\76\6\uffff\23\76\26\uffff\20\76\1\uffff\2\76"+
            "\1\uffff\1\76",
            "\1\76\1\uffff\4\76\5\uffff\1\76\1\uffff\1\76\3\uffff\1\76"+
            "\1\uffff\1\75\1\uffff\1\76\2\uffff\1\76\3\uffff\2\76\2\uffff"+
            "\1\76\1\uffff\13\76\1\uffff\3\76\7\uffff\1\76\1\uffff\1\76\1"+
            "\uffff\3\76\1\uffff\2\76\4\uffff\1\76\4\uffff\3\76\10\uffff"+
            "\1\76\41\uffff\2\76\6\uffff\23\76\26\uffff\20\76\1\uffff\2\76"+
            "\1\uffff\1\76",
            "\1\76\1\uffff\4\76\5\uffff\1\76\1\uffff\1\76\3\uffff\1\76"+
            "\1\uffff\1\75\1\uffff\1\76\2\uffff\1\76\3\uffff\2\76\2\uffff"+
            "\1\76\1\uffff\13\76\1\uffff\3\76\7\uffff\1\76\1\uffff\1\76\1"+
            "\uffff\3\76\1\uffff\2\76\4\uffff\1\76\4\uffff\3\76\10\uffff"+
            "\1\76\41\uffff\2\76\6\uffff\23\76\26\uffff\20\76\1\uffff\2\76"+
            "\1\uffff\1\76",
            "\1\76\1\uffff\4\76\5\uffff\1\76\1\uffff\1\76\3\uffff\1\76"+
            "\1\uffff\1\75\1\uffff\1\76\2\uffff\1\76\3\uffff\2\76\2\uffff"+
            "\1\76\1\uffff\13\76\1\uffff\3\76\7\uffff\1\76\1\uffff\1\76\1"+
            "\uffff\3\76\1\uffff\2\76\4\uffff\1\76\4\uffff\3\76\10\uffff"+
            "\1\76\41\uffff\2\76\6\uffff\23\76\26\uffff\20\76\1\uffff\2\76"+
            "\1\uffff\1\76",
            "\1\76\1\uffff\4\76\5\uffff\1\76\1\uffff\1\76\3\uffff\1\76"+
            "\1\uffff\1\75\1\uffff\1\76\2\uffff\1\76\3\uffff\2\76\2\uffff"+
            "\1\76\1\uffff\13\76\1\uffff\3\76\7\uffff\1\76\1\uffff\1\76\1"+
            "\uffff\3\76\1\uffff\2\76\4\uffff\1\76\4\uffff\3\76\10\uffff"+
            "\1\76\41\uffff\2\76\6\uffff\23\76\26\uffff\20\76\1\uffff\2\76"+
            "\1\uffff\1\76",
            "\1\76\1\uffff\4\76\5\uffff\1\76\1\uffff\1\76\3\uffff\1\76"+
            "\1\uffff\1\75\1\uffff\1\76\2\uffff\1\76\3\uffff\2\76\2\uffff"+
            "\1\76\1\uffff\13\76\1\uffff\3\76\7\uffff\1\76\1\uffff\1\76\1"+
            "\uffff\3\76\1\uffff\2\76\4\uffff\1\76\4\uffff\3\76\10\uffff"+
            "\1\76\41\uffff\2\76\6\uffff\23\76\26\uffff\20\76\1\uffff\2\76"+
            "\1\uffff\1\76",
            "\1\76\1\uffff\4\76\5\uffff\1\76\1\uffff\1\76\3\uffff\1\76"+
            "\1\uffff\1\75\1\uffff\1\76\2\uffff\1\76\3\uffff\2\76\2\uffff"+
            "\1\76\1\uffff\13\76\1\uffff\3\76\7\uffff\1\76\1\uffff\1\76\1"+
            "\uffff\3\76\1\uffff\2\76\4\uffff\1\76\4\uffff\3\76\10\uffff"+
            "\1\76\41\uffff\2\76\6\uffff\23\76\26\uffff\20\76\1\uffff\2\76"+
            "\1\uffff\1\76",
            "\1\77\1\100\1\113\30\uffff\1\114\4\uffff\1\107\1\110\1\111"+
            "\1\112\1\101\1\102\1\103\1\104\1\105\1\106",
            "\1\115",
            "\1\116",
            "\1\116",
            "\1\116",
            "\1\116",
            "\1\116",
            "\1\116",
            "\1\116",
            "\1\116",
            "\1\116",
            "\1\116",
            "\1\116",
            "\1\116",
            "\1\116",
            "\1\117\11\uffff\1\73",
            "\1\117\11\uffff\1\73",
            "\1\117\11\uffff\1\73",
            "\1\117\11\uffff\1\73",
            "\1\117\11\uffff\1\73",
            "\1\117\11\uffff\1\73",
            "\1\117\11\uffff\1\73",
            "\1\117\11\uffff\1\73",
            "\1\117\11\uffff\1\73",
            "\1\117\11\uffff\1\73",
            "\1\117\11\uffff\1\73",
            "\1\117\11\uffff\1\73",
            "\1\117\11\uffff\1\73",
            "\1\76\1\uffff\4\76\5\uffff\1\76\1\uffff\1\76\3\uffff\1\76"+
            "\1\uffff\1\75\1\uffff\1\76\2\uffff\1\76\3\uffff\2\76\2\uffff"+
            "\1\76\1\uffff\13\76\1\uffff\3\76\7\uffff\1\76\1\uffff\1\76\1"+
            "\uffff\3\76\1\uffff\2\76\4\uffff\1\76\4\uffff\3\76\10\uffff"+
            "\1\76\41\uffff\2\76\6\uffff\23\76\26\uffff\20\76\1\uffff\2\76"+
            "\1\uffff\1\76",
            "\1\120\1\121\1\134\30\uffff\1\135\4\uffff\1\130\1\131\1\132"+
            "\1\133\1\122\1\123\1\124\1\125\1\126\1\127",
            "",
            "",
            "\1\136\11\uffff\1\114",
            "\1\136\11\uffff\1\114",
            "\1\136\11\uffff\1\114",
            "\1\136\11\uffff\1\114",
            "\1\136\11\uffff\1\114",
            "\1\136\11\uffff\1\114",
            "\1\136\11\uffff\1\114",
            "\1\136\11\uffff\1\114",
            "\1\136\11\uffff\1\114",
            "\1\136\11\uffff\1\114",
            "\1\136\11\uffff\1\114",
            "\1\136\11\uffff\1\114",
            "\1\136\11\uffff\1\114",
            "\1\116",
            "\1\137\1\140\1\153\30\uffff\1\154\4\uffff\1\147\1\150\1\151"+
            "\1\152\1\141\1\142\1\143\1\144\1\145\1\146",
            "\1\157\1\160\1\173\27\uffff\1\155\3\uffff\1\156\1\uffff\1"+
            "\167\1\170\1\171\1\172\1\161\1\162\1\163\1\164\1\165\1\166",
            "\1\174\1\175\1\u0088\35\uffff\1\u0084\1\u0085\1\u0086\1\u0087"+
            "\1\176\1\177\1\u0080\1\u0081\1\u0082\1\u0083",
            "\1\u0089\11\uffff\1\135",
            "\1\u0089\11\uffff\1\135",
            "\1\u0089\11\uffff\1\135",
            "\1\u0089\11\uffff\1\135",
            "\1\u0089\11\uffff\1\135",
            "\1\u0089\11\uffff\1\135",
            "\1\u0089\11\uffff\1\135",
            "\1\u0089\11\uffff\1\135",
            "\1\u0089\11\uffff\1\135",
            "\1\u0089\11\uffff\1\135",
            "\1\u0089\11\uffff\1\135",
            "\1\u0089\11\uffff\1\135",
            "\1\u0089\11\uffff\1\135",
            "\1\u008a",
            "\1\u008b\1\u008c\1\u0097\35\uffff\1\u0093\1\u0094\1\u0095"+
            "\1\u0096\1\u008d\1\u008e\1\u008f\1\u0090\1\u0091\1\u0092",
            "\1\u0098\11\uffff\1\154",
            "\1\u0098\11\uffff\1\154",
            "\1\u0098\11\uffff\1\154",
            "\1\u0098\11\uffff\1\154",
            "\1\u0098\11\uffff\1\154",
            "\1\u0098\11\uffff\1\154",
            "\1\u0098\11\uffff\1\154",
            "\1\u0098\11\uffff\1\154",
            "\1\u0098\11\uffff\1\154",
            "\1\u0098\11\uffff\1\154",
            "\1\u0098\11\uffff\1\154",
            "\1\u0098\11\uffff\1\154",
            "\1\u0098\11\uffff\1\154",
            "\1\u0099",
            "\1\u009a\1\u009b\1\u00a6\30\uffff\1\u00a7\4\uffff\1\u00a2"+
            "\1\u00a3\1\u00a4\1\u00a5\1\u009c\1\u009d\1\u009e\1\u009f\1\u00a0"+
            "\1\u00a1",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00a9",
            "\1\u00a9",
            "\1\u00a9",
            "\1\u00a9",
            "\1\u00a9",
            "\1\u00a9",
            "\1\u00a9",
            "\1\u00a9",
            "\1\u00a9",
            "\1\u00a9",
            "\1\u00a9",
            "\1\u00a9",
            "\1\117\11\uffff\1\73",
            "\1\117\11\uffff\1\73",
            "\1\117\11\uffff\1\73",
            "\1\117\11\uffff\1\73",
            "\1\117\11\uffff\1\73",
            "\1\117\11\uffff\1\73",
            "\1\117\11\uffff\1\73",
            "\1\117\11\uffff\1\73",
            "\1\117\11\uffff\1\73",
            "\1\117\11\uffff\1\73",
            "\1\117\11\uffff\1\73",
            "\1\117\11\uffff\1\73",
            "\1\117\11\uffff\1\73",
            "\1\u00aa\1\u00ab\1\u00b6\35\uffff\1\u00b2\1\u00b3\1\u00b4"+
            "\1\u00b5\1\u00ac\1\u00ad\1\u00ae\1\u00af\1\u00b0\1\u00b1",
            "\1\76\1\uffff\4\76\5\uffff\1\76\1\uffff\1\76\3\uffff\1\76"+
            "\1\uffff\1\75\1\uffff\1\76\2\uffff\1\76\3\uffff\2\76\2\uffff"+
            "\1\76\1\uffff\13\76\1\uffff\3\76\7\uffff\1\76\1\uffff\1\76\1"+
            "\uffff\3\76\1\uffff\2\76\4\uffff\1\76\4\uffff\3\76\10\uffff"+
            "\1\76\41\uffff\2\76\6\uffff\23\76\26\uffff\20\76\1\uffff\2\76"+
            "\1\uffff\1\76",
            "\1\136\11\uffff\1\114",
            "\1\136\11\uffff\1\114",
            "\1\136\11\uffff\1\114",
            "\1\136\11\uffff\1\114",
            "\1\136\11\uffff\1\114",
            "\1\136\11\uffff\1\114",
            "\1\136\11\uffff\1\114",
            "\1\136\11\uffff\1\114",
            "\1\136\11\uffff\1\114",
            "\1\136\11\uffff\1\114",
            "\1\136\11\uffff\1\114",
            "\1\136\11\uffff\1\114",
            "\1\136\11\uffff\1\114",
            "\1\u00b7\1\u00b8\1\u00c3\35\uffff\1\u00bf\1\u00c0\1\u00c1"+
            "\1\u00c2\1\u00b9\1\u00ba\1\u00bb\1\u00bc\1\u00bd\1\u00be",
            "\1\116",
            "\1\u00c4\11\uffff\1\u00a7",
            "\1\u00c4\11\uffff\1\u00a7",
            "\1\u00c4\11\uffff\1\u00a7",
            "\1\u00c4\11\uffff\1\u00a7",
            "\1\u00c4\11\uffff\1\u00a7",
            "\1\u00c4\11\uffff\1\u00a7",
            "\1\u00c4\11\uffff\1\u00a7",
            "\1\u00c4\11\uffff\1\u00a7",
            "\1\u00c4\11\uffff\1\u00a7",
            "\1\u00c4\11\uffff\1\u00a7",
            "\1\u00c4\11\uffff\1\u00a7",
            "\1\u00c4\11\uffff\1\u00a7",
            "\1\u00c4\11\uffff\1\u00a7",
            "\1\u00a9",
            "\1\u00c5\1\u00c6\1\u00d1\30\uffff\1\u00d2\4\uffff\1\u00cd"+
            "\1\u00ce\1\u00cf\1\u00d0\1\u00c7\1\u00c8\1\u00c9\1\u00ca\1\u00cb"+
            "\1\u00cc",
            "\1\u00d5\1\u00d6\1\u00e1\27\uffff\1\u00d3\3\uffff\1\u00d4"+
            "\1\uffff\1\u00dd\1\u00de\1\u00df\1\u00e0\1\u00d7\1\u00d8\1\u00d9"+
            "\1\u00da\1\u00db\1\u00dc",
            "\1\u0089\11\uffff\1\135",
            "\1\u0089\11\uffff\1\135",
            "\1\u0089\11\uffff\1\135",
            "\1\u0089\11\uffff\1\135",
            "\1\u0089\11\uffff\1\135",
            "\1\u0089\11\uffff\1\135",
            "\1\u0089\11\uffff\1\135",
            "\1\u0089\11\uffff\1\135",
            "\1\u0089\11\uffff\1\135",
            "\1\u0089\11\uffff\1\135",
            "\1\u0089\11\uffff\1\135",
            "\1\u0089\11\uffff\1\135",
            "\1\u0089\11\uffff\1\135",
            "\1\u0098\11\uffff\1\154",
            "\1\u0098\11\uffff\1\154",
            "\1\u0098\11\uffff\1\154",
            "\1\u0098\11\uffff\1\154",
            "\1\u0098\11\uffff\1\154",
            "\1\u0098\11\uffff\1\154",
            "\1\u0098\11\uffff\1\154",
            "\1\u0098\11\uffff\1\154",
            "\1\u0098\11\uffff\1\154",
            "\1\u0098\11\uffff\1\154",
            "\1\u0098\11\uffff\1\154",
            "\1\u0098\11\uffff\1\154",
            "\1\u0098\11\uffff\1\154",
            "\1\u00e2\1\u00e3\1\u00ee\35\uffff\1\u00ea\1\u00eb\1\u00ec"+
            "\1\u00ed\1\u00e4\1\u00e5\1\u00e6\1\u00e7\1\u00e8\1\u00e9",
            "\1\u00ef\11\uffff\1\u00d2",
            "\1\u00ef\11\uffff\1\u00d2",
            "\1\u00ef\11\uffff\1\u00d2",
            "\1\u00ef\11\uffff\1\u00d2",
            "\1\u00ef\11\uffff\1\u00d2",
            "\1\u00ef\11\uffff\1\u00d2",
            "\1\u00ef\11\uffff\1\u00d2",
            "\1\u00ef\11\uffff\1\u00d2",
            "\1\u00ef\11\uffff\1\u00d2",
            "\1\u00ef\11\uffff\1\u00d2",
            "\1\u00ef\11\uffff\1\u00d2",
            "\1\u00ef\11\uffff\1\u00d2",
            "\1\u00ef\11\uffff\1\u00d2",
            "\1\u00f0",
            "\1\u00f1\1\u00f2\1\u00fd\30\uffff\1\u00fe\4\uffff\1\u00f9"+
            "\1\u00fa\1\u00fb\1\u00fc\1\u00f3\1\u00f4\1\u00f5\1\u00f6\1\u00f7"+
            "\1\u00f8",
            "\1\u00ff",
            "\1\76\1\uffff\4\76\5\uffff\1\76\1\uffff\1\76\3\uffff\1\76"+
            "\1\uffff\1\75\1\uffff\1\76\2\uffff\1\76\3\uffff\2\76\2\uffff"+
            "\1\76\1\uffff\13\76\1\uffff\3\76\7\uffff\1\76\1\uffff\1\76\1"+
            "\uffff\3\76\1\uffff\2\76\4\uffff\1\76\4\uffff\3\76\10\uffff"+
            "\1\76\41\uffff\2\76\6\uffff\23\76\26\uffff\20\76\1\uffff\2\76"+
            "\1\uffff\1\76",
            "\1\76\1\uffff\4\76\5\uffff\1\76\1\uffff\1\76\3\uffff\1\76"+
            "\1\uffff\1\75\1\uffff\1\76\2\uffff\1\76\3\uffff\2\76\2\uffff"+
            "\1\76\1\uffff\13\76\1\uffff\3\76\7\uffff\1\76\1\uffff\1\76\1"+
            "\uffff\3\76\1\uffff\2\76\4\uffff\1\76\4\uffff\3\76\10\uffff"+
            "\1\76\41\uffff\2\76\6\uffff\23\76\26\uffff\20\76\1\uffff\2\76"+
            "\1\uffff\1\76",
            "\1\76\1\uffff\4\76\5\uffff\1\76\1\uffff\1\76\3\uffff\1\76"+
            "\1\uffff\1\75\1\uffff\1\76\2\uffff\1\76\3\uffff\2\76\2\uffff"+
            "\1\76\1\uffff\13\76\1\uffff\3\76\7\uffff\1\76\1\uffff\1\76\1"+
            "\uffff\3\76\1\uffff\2\76\4\uffff\1\76\4\uffff\3\76\10\uffff"+
            "\1\76\41\uffff\2\76\6\uffff\23\76\26\uffff\20\76\1\uffff\2\76"+
            "\1\uffff\1\76",
            "\1\76\1\uffff\4\76\5\uffff\1\76\1\uffff\1\76\3\uffff\1\76"+
            "\1\uffff\1\75\1\uffff\1\76\2\uffff\1\76\3\uffff\2\76\2\uffff"+
            "\1\76\1\uffff\13\76\1\uffff\3\76\7\uffff\1\76\1\uffff\1\76\1"+
            "\uffff\3\76\1\uffff\2\76\4\uffff\1\76\4\uffff\3\76\10\uffff"+
            "\1\76\41\uffff\2\76\6\uffff\23\76\26\uffff\20\76\1\uffff\2\76"+
            "\1\uffff\1\76",
            "\1\76\1\uffff\4\76\5\uffff\1\76\1\uffff\1\76\3\uffff\1\76"+
            "\1\uffff\1\75\1\uffff\1\76\2\uffff\1\76\3\uffff\2\76\2\uffff"+
            "\1\76\1\uffff\13\76\1\uffff\3\76\7\uffff\1\76\1\uffff\1\76\1"+
            "\uffff\3\76\1\uffff\2\76\4\uffff\1\76\4\uffff\3\76\10\uffff"+
            "\1\76\41\uffff\2\76\6\uffff\23\76\26\uffff\20\76\1\uffff\2\76"+
            "\1\uffff\1\76",
            "\1\76\1\uffff\4\76\5\uffff\1\76\1\uffff\1\76\3\uffff\1\76"+
            "\1\uffff\1\75\1\uffff\1\76\2\uffff\1\76\3\uffff\2\76\2\uffff"+
            "\1\76\1\uffff\13\76\1\uffff\3\76\7\uffff\1\76\1\uffff\1\76\1"+
            "\uffff\3\76\1\uffff\2\76\4\uffff\1\76\4\uffff\3\76\10\uffff"+
            "\1\76\41\uffff\2\76\6\uffff\23\76\26\uffff\20\76\1\uffff\2\76"+
            "\1\uffff\1\76",
            "\1\76\1\uffff\4\76\5\uffff\1\76\1\uffff\1\76\3\uffff\1\76"+
            "\1\uffff\1\75\1\uffff\1\76\2\uffff\1\76\3\uffff\2\76\2\uffff"+
            "\1\76\1\uffff\13\76\1\uffff\3\76\7\uffff\1\76\1\uffff\1\76\1"+
            "\uffff\3\76\1\uffff\2\76\4\uffff\1\76\4\uffff\3\76\10\uffff"+
            "\1\76\41\uffff\2\76\6\uffff\23\76\26\uffff\20\76\1\uffff\2\76"+
            "\1\uffff\1\76",
            "\1\76\1\uffff\4\76\5\uffff\1\76\1\uffff\1\76\3\uffff\1\76"+
            "\1\uffff\1\75\1\uffff\1\76\2\uffff\1\76\3\uffff\2\76\2\uffff"+
            "\1\76\1\uffff\13\76\1\uffff\3\76\7\uffff\1\76\1\uffff\1\76\1"+
            "\uffff\3\76\1\uffff\2\76\4\uffff\1\76\4\uffff\3\76\10\uffff"+
            "\1\76\41\uffff\2\76\6\uffff\23\76\26\uffff\20\76\1\uffff\2\76"+
            "\1\uffff\1\76",
            "\1\76\1\uffff\4\76\5\uffff\1\76\1\uffff\1\76\3\uffff\1\76"+
            "\1\uffff\1\75\1\uffff\1\76\2\uffff\1\76\3\uffff\2\76\2\uffff"+
            "\1\76\1\uffff\13\76\1\uffff\3\76\7\uffff\1\76\1\uffff\1\76\1"+
            "\uffff\3\76\1\uffff\2\76\4\uffff\1\76\4\uffff\3\76\10\uffff"+
            "\1\76\41\uffff\2\76\6\uffff\23\76\26\uffff\20\76\1\uffff\2\76"+
            "\1\uffff\1\76",
            "\1\76\1\uffff\4\76\5\uffff\1\76\1\uffff\1\76\3\uffff\1\76"+
            "\1\uffff\1\75\1\uffff\1\76\2\uffff\1\76\3\uffff\2\76\2\uffff"+
            "\1\76\1\uffff\13\76\1\uffff\3\76\7\uffff\1\76\1\uffff\1\76\1"+
            "\uffff\3\76\1\uffff\2\76\4\uffff\1\76\4\uffff\3\76\10\uffff"+
            "\1\76\41\uffff\2\76\6\uffff\23\76\26\uffff\20\76\1\uffff\2\76"+
            "\1\uffff\1\76",
            "\1\76\1\uffff\4\76\5\uffff\1\76\1\uffff\1\76\3\uffff\1\76"+
            "\1\uffff\1\75\1\uffff\1\76\2\uffff\1\76\3\uffff\2\76\2\uffff"+
            "\1\76\1\uffff\13\76\1\uffff\3\76\7\uffff\1\76\1\uffff\1\76\1"+
            "\uffff\3\76\1\uffff\2\76\4\uffff\1\76\4\uffff\3\76\10\uffff"+
            "\1\76\41\uffff\2\76\6\uffff\23\76\26\uffff\20\76\1\uffff\2\76"+
            "\1\uffff\1\76",
            "\1\76\1\uffff\4\76\5\uffff\1\76\1\uffff\1\76\3\uffff\1\76"+
            "\1\uffff\1\75\1\uffff\1\76\2\uffff\1\76\3\uffff\2\76\2\uffff"+
            "\1\76\1\uffff\13\76\1\uffff\3\76\7\uffff\1\76\1\uffff\1\76\1"+
            "\uffff\3\76\1\uffff\2\76\4\uffff\1\76\4\uffff\3\76\10\uffff"+
            "\1\76\41\uffff\2\76\6\uffff\23\76\26\uffff\20\76\1\uffff\2\76"+
            "\1\uffff\1\76",
            "\1\76\1\uffff\4\76\5\uffff\1\76\1\uffff\1\76\3\uffff\1\76"+
            "\1\uffff\1\75\1\uffff\1\76\2\uffff\1\76\3\uffff\2\76\2\uffff"+
            "\1\76\1\uffff\13\76\1\uffff\3\76\7\uffff\1\76\1\uffff\1\76\1"+
            "\uffff\3\76\1\uffff\2\76\4\uffff\1\76\4\uffff\3\76\10\uffff"+
            "\1\76\41\uffff\2\76\6\uffff\23\76\26\uffff\20\76\1\uffff\2\76"+
            "\1\uffff\1\76",
            "\1\u00c4\11\uffff\1\u00a7",
            "\1\u00c4\11\uffff\1\u00a7",
            "\1\u00c4\11\uffff\1\u00a7",
            "\1\u00c4\11\uffff\1\u00a7",
            "\1\u00c4\11\uffff\1\u00a7",
            "\1\u00c4\11\uffff\1\u00a7",
            "\1\u00c4\11\uffff\1\u00a7",
            "\1\u00c4\11\uffff\1\u00a7",
            "\1\u00c4\11\uffff\1\u00a7",
            "\1\u00c4\11\uffff\1\u00a7",
            "\1\u00c4\11\uffff\1\u00a7",
            "\1\u00c4\11\uffff\1\u00a7",
            "\1\u00c4\11\uffff\1\u00a7",
            "\1\u0100\1\u0101\1\u010c\35\uffff\1\u0108\1\u0109\1\u010a"+
            "\1\u010b\1\u0102\1\u0103\1\u0104\1\u0105\1\u0106\1\u0107",
            "\1\u00a9",
            "\1\u010d\11\uffff\1\u00fe",
            "\1\u010d\11\uffff\1\u00fe",
            "\1\u010d\11\uffff\1\u00fe",
            "\1\u010d\11\uffff\1\u00fe",
            "\1\u010d\11\uffff\1\u00fe",
            "\1\u010d\11\uffff\1\u00fe",
            "\1\u010d\11\uffff\1\u00fe",
            "\1\u010d\11\uffff\1\u00fe",
            "\1\u010d\11\uffff\1\u00fe",
            "\1\u010d\11\uffff\1\u00fe",
            "\1\u010d\11\uffff\1\u00fe",
            "\1\u010d\11\uffff\1\u00fe",
            "\1\u010d\11\uffff\1\u00fe",
            "\1\76\1\uffff\4\76\5\uffff\1\76\1\uffff\1\76\3\uffff\1\76"+
            "\1\uffff\1\75\1\uffff\1\76\2\uffff\1\76\3\uffff\2\76\2\uffff"+
            "\1\76\1\uffff\13\76\1\uffff\3\76\7\uffff\1\76\1\uffff\1\76\1"+
            "\uffff\3\76\1\uffff\2\76\4\uffff\1\76\4\uffff\3\76\10\uffff"+
            "\1\76\41\uffff\2\76\6\uffff\23\76\26\uffff\20\76\1\uffff\2\76"+
            "\1\uffff\1\76",
            "\1\u010e\1\u010f\1\u011a\30\uffff\1\u011b\4\uffff\1\u0116"+
            "\1\u0117\1\u0118\1\u0119\1\u0110\1\u0111\1\u0112\1\u0113\1\u0114"+
            "\1\u0115",
            "\1\u00ef\11\uffff\1\u00d2",
            "\1\u00ef\11\uffff\1\u00d2",
            "\1\u00ef\11\uffff\1\u00d2",
            "\1\u00ef\11\uffff\1\u00d2",
            "\1\u00ef\11\uffff\1\u00d2",
            "\1\u00ef\11\uffff\1\u00d2",
            "\1\u00ef\11\uffff\1\u00d2",
            "\1\u00ef\11\uffff\1\u00d2",
            "\1\u00ef\11\uffff\1\u00d2",
            "\1\u00ef\11\uffff\1\u00d2",
            "\1\u00ef\11\uffff\1\u00d2",
            "\1\u00ef\11\uffff\1\u00d2",
            "\1\u00ef\11\uffff\1\u00d2",
            "\1\u011c\1\u011d\1\u0128\35\uffff\1\u0124\1\u0125\1\u0126"+
            "\1\u0127\1\u011e\1\u011f\1\u0120\1\u0121\1\u0122\1\u0123",
            "\1\u0129\11\uffff\1\u011b",
            "\1\u0129\11\uffff\1\u011b",
            "\1\u0129\11\uffff\1\u011b",
            "\1\u0129\11\uffff\1\u011b",
            "\1\u0129\11\uffff\1\u011b",
            "\1\u0129\11\uffff\1\u011b",
            "\1\u0129\11\uffff\1\u011b",
            "\1\u0129\11\uffff\1\u011b",
            "\1\u0129\11\uffff\1\u011b",
            "\1\u0129\11\uffff\1\u011b",
            "\1\u0129\11\uffff\1\u011b",
            "\1\u0129\11\uffff\1\u011b",
            "\1\u0129\11\uffff\1\u011b",
            "\1\u012a",
            "\1\u010d\11\uffff\1\u00fe",
            "\1\u010d\11\uffff\1\u00fe",
            "\1\u010d\11\uffff\1\u00fe",
            "\1\u010d\11\uffff\1\u00fe",
            "\1\u010d\11\uffff\1\u00fe",
            "\1\u010d\11\uffff\1\u00fe",
            "\1\u010d\11\uffff\1\u00fe",
            "\1\u010d\11\uffff\1\u00fe",
            "\1\u010d\11\uffff\1\u00fe",
            "\1\u010d\11\uffff\1\u00fe",
            "\1\u010d\11\uffff\1\u00fe",
            "\1\u010d\11\uffff\1\u00fe",
            "\1\u010d\11\uffff\1\u00fe",
            "\1\u012b\1\u012c\1\u0137\35\uffff\1\u0133\1\u0134\1\u0135"+
            "\1\u0136\1\u012d\1\u012e\1\u012f\1\u0130\1\u0131\1\u0132",
            "\1\76\1\uffff\4\76\5\uffff\1\76\1\uffff\1\76\3\uffff\1\76"+
            "\1\uffff\1\75\1\uffff\1\76\2\uffff\1\76\3\uffff\2\76\2\uffff"+
            "\1\76\1\uffff\13\76\1\uffff\3\76\7\uffff\1\76\1\uffff\1\76\1"+
            "\uffff\3\76\1\uffff\2\76\4\uffff\1\76\4\uffff\3\76\10\uffff"+
            "\1\76\41\uffff\2\76\6\uffff\23\76\26\uffff\20\76\1\uffff\2\76"+
            "\1\uffff\1\76",
            "\1\u0129\11\uffff\1\u011b",
            "\1\u0129\11\uffff\1\u011b",
            "\1\u0129\11\uffff\1\u011b",
            "\1\u0129\11\uffff\1\u011b",
            "\1\u0129\11\uffff\1\u011b",
            "\1\u0129\11\uffff\1\u011b",
            "\1\u0129\11\uffff\1\u011b",
            "\1\u0129\11\uffff\1\u011b",
            "\1\u0129\11\uffff\1\u011b",
            "\1\u0129\11\uffff\1\u011b",
            "\1\u0129\11\uffff\1\u011b",
            "\1\u0129\11\uffff\1\u011b",
            "\1\u0129\11\uffff\1\u011b"
    };

    static final short[] DFA109_eot = DFA.unpackEncodedString(DFA109_eotS);
    static final short[] DFA109_eof = DFA.unpackEncodedString(DFA109_eofS);
    static final char[] DFA109_min = DFA.unpackEncodedStringToUnsignedChars(DFA109_minS);
    static final char[] DFA109_max = DFA.unpackEncodedStringToUnsignedChars(DFA109_maxS);
    static final short[] DFA109_accept = DFA.unpackEncodedString(DFA109_acceptS);
    static final short[] DFA109_special = DFA.unpackEncodedString(DFA109_specialS);
    static final short[][] DFA109_transition;

    static {
        int numStates = DFA109_transitionS.length;
        DFA109_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA109_transition[i] = DFA.unpackEncodedString(DFA109_transitionS[i]);
        }
    }

    class DFA109 extends DFA {

        public DFA109(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 109;
            this.eot = DFA109_eot;
            this.eof = DFA109_eof;
            this.min = DFA109_min;
            this.max = DFA109_max;
            this.accept = DFA109_accept;
            this.special = DFA109_special;
            this.transition = DFA109_transition;
        }
        public String getDescription() {
            return "5626:1: ( (otherlv_0= 'br' ( (lv_destination_1_0= ruleTypeAndValue ) ) ) | (otherlv_2= 'br' ( (lv_cond_3_0= ruleTypeAndValue ) ) otherlv_4= ',' ( (lv_labelTrue_5_0= ruleTypeAndValue ) ) otherlv_6= ',' ( (lv_labelFalse_7_0= ruleTypeAndValue ) ) ) )";
        }
    }
 

    public static final BitSet FOLLOW_ruleLLVM_in_entryRuleLLVM75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLLVM85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractElement_in_ruleLLVM130 = new BitSet(new long[]{0x0000FFD1122281C2L});
    public static final BitSet FOLLOW_ruleAbstractElement_in_entryRuleAbstractElement166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractElement176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTopLevelEntity_in_ruleAbstractElement224 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_SL_COMMENT_in_ruleAbstractElement235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMainLevelEntity_in_ruleAbstractElement266 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_SL_COMMENT_in_ruleAbstractElement277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTopLevelEntity_in_entryRuleTopLevelEntity315 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTopLevelEntity325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleTopLevelEntity363 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleTopLevelEntity375 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleTopLevelEntity392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleTopLevelEntity417 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_18_in_ruleTopLevelEntity430 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_19_in_ruleTopLevelEntity448 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleTopLevelEntity461 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleTopLevelEntity478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleTopLevelEntity503 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleTopLevelEntity515 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleTopLevelEntity527 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleTopLevelEntity544 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_23_in_ruleTopLevelEntity562 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleTopLevelEntity579 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_24_in_ruleTopLevelEntity598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMainLevelEntity_in_entryRuleMainLevelEntity635 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMainLevelEntity645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionHeader_in_ruleMainLevelEntity692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocalVar_in_ruleMainLevelEntity719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionHeader_in_entryRuleFunctionHeader754 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunctionHeader764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleFunctionHeader802 = new BitSet(new long[]{0x0000FFD1122281C0L,0x000003FFFBFC0000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleLINKAGE_in_ruleFunctionHeader819 = new BitSet(new long[]{0x0000FFD1122281C0L,0x000003FFFBFC0000L,0x0000000000000000L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleVISIBILITY_in_ruleFunctionHeader837 = new BitSet(new long[]{0x0000FFD1122281C0L,0x000003FFFBFC0000L});
    public static final BitSet FOLLOW_ruleCallingConv_in_ruleFunctionHeader855 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000003FC0000L});
    public static final BitSet FOLLOW_ruleRETURN_ATTRIBUTES_in_ruleFunctionHeader873 = new BitSet(new long[]{0x0000FFD1122281C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleFunctionHeader895 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_VAR_TYPE_in_ruleFunctionHeader912 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleParameterList_in_ruleFunctionHeader938 = new BitSet(new long[]{0x000000010C000000L,0x0FFFFC0000004000L});
    public static final BitSet FOLLOW_26_in_ruleFunctionHeader951 = new BitSet(new long[]{0x000000010C000000L,0x0FFFFC0000004000L});
    public static final BitSet FOLLOW_ruleFUNCTION_ATTRIBUTES_in_ruleFunctionHeader970 = new BitSet(new long[]{0x000000010C000000L,0x0FFFFC0000004000L});
    public static final BitSet FOLLOW_27_in_ruleFunctionHeader984 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleFunctionHeader995 = new BitSet(new long[]{0x000000010C000000L,0x0FFFFC0000004000L});
    public static final BitSet FOLLOW_ruleALIGNMENT_in_ruleFunctionHeader1013 = new BitSet(new long[]{0x000000010C000000L,0x0FFFFC0000004000L});
    public static final BitSet FOLLOW_ruleFunctionBody_in_ruleFunctionHeader1035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleFunctionHeader1055 = new BitSet(new long[]{0x0000FFD1122281C0L,0x000003FFFBFC0000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleLINKAGE_in_ruleFunctionHeader1072 = new BitSet(new long[]{0x0000FFD1122281C0L,0x000003FFFBFC0000L,0x0000000000000000L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleVISIBILITY_in_ruleFunctionHeader1090 = new BitSet(new long[]{0x0000FFD1122281C0L,0x000003FFFBFC0000L});
    public static final BitSet FOLLOW_ruleCallingConv_in_ruleFunctionHeader1108 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000003FC0000L});
    public static final BitSet FOLLOW_ruleRETURN_ATTRIBUTES_in_ruleFunctionHeader1126 = new BitSet(new long[]{0x0000FFD1122281C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleFunctionHeader1148 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_VAR_TYPE_in_ruleFunctionHeader1165 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_ruleTypeList_in_ruleFunctionHeader1192 = new BitSet(new long[]{0x000000000C000002L,0x0FFFFC0000004000L});
    public static final BitSet FOLLOW_29_in_ruleFunctionHeader1210 = new BitSet(new long[]{0x000000000C000002L,0x0FFFFC0000004000L});
    public static final BitSet FOLLOW_26_in_ruleFunctionHeader1224 = new BitSet(new long[]{0x0000000008000002L,0x0FFFFC0000004000L});
    public static final BitSet FOLLOW_ruleFUNCTION_ATTRIBUTES_in_ruleFunctionHeader1243 = new BitSet(new long[]{0x0000000008000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_27_in_ruleFunctionHeader1257 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleFunctionHeader1268 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_ruleALIGNMENT_in_ruleFunctionHeader1286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeList_in_entryRuleTypeList1324 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeList1334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleTypeList1380 = new BitSet(new long[]{0x0000FFD192A281C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleTypeList1402 = new BitSet(new long[]{0x0000000080800000L});
    public static final BitSet FOLLOW_23_in_ruleTypeList1415 = new BitSet(new long[]{0x0000FFD192A281C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleTypeList1436 = new BitSet(new long[]{0x0000000080800000L});
    public static final BitSet FOLLOW_31_in_ruleTypeList1452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAggregate_in_entryRuleAggregate1488 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAggregate1498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleAggregate1535 = new BitSet(new long[]{0x0000FFD112A281C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleAggregate1556 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleAggregate1569 = new BitSet(new long[]{0x0000FFD3122281C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleAggregate1590 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleAggregate1603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocalVar_in_entryRuleLocalVar1639 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLocalVar1649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleLocalVar1695 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleLocalVar1707 = new BitSet(new long[]{0x501DFFDD122281C0L,0x3000000004038437L,0xDFFFE000007FFFF0L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocalType_in_ruleLocalVar1729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocalInstruction_in_ruleLocalVar1756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocalAlias_in_ruleLocalVar1783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocalType_in_entryRuleLocalType1820 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLocalType1830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleLocalType1867 = new BitSet(new long[]{0x0000FFD1122281C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleLocalType1888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocalInstruction_in_entryRuleLocalInstruction1924 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLocalInstruction1934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_ruleLocalInstruction1979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocalAlias_in_entryRuleLocalAlias2014 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLocalAlias2024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleLocalAlias2061 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleALIAS_LINKAGE_in_ruleLocalAlias2078 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleVISIBILITY_in_ruleLocalAlias2096 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleLocalAlias2118 = new BitSet(new long[]{0x0000FFD1122281C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleLocalAlias2139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType2176 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType2187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStructType_in_ruleType2234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VAR_TYPE_in_ruleType2260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBType_in_ruleType2293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_entryRuleTypeAndValue2338 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeAndValue2348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_VAR_TYPE_in_ruleTypeAndValue2393 = new BitSet(new long[]{0x0000FFD1122281C0L});
    public static final BitSet FOLLOW_ruleBType_in_ruleTypeAndValue2417 = new BitSet(new long[]{0x0000FFD1122281C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleTypeAndValue2441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAggregate_in_ruleTypeAndValue2470 = new BitSet(new long[]{0x0000FFD1122281C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleTypeAndValue2491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStructType_in_entryRuleStructType2529 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStructType2540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleStructType2579 = new BitSet(new long[]{0x0000FFD312A281C0L});
    public static final BitSet FOLLOW_RULE_VAR_TYPE_in_ruleStructType2596 = new BitSet(new long[]{0x0000000200800000L});
    public static final BitSet FOLLOW_ruleBType_in_ruleStructType2629 = new BitSet(new long[]{0x0000000200800000L});
    public static final BitSet FOLLOW_23_in_ruleStructType2649 = new BitSet(new long[]{0x0000FFD312A281C0L});
    public static final BitSet FOLLOW_RULE_VAR_TYPE_in_ruleStructType2665 = new BitSet(new long[]{0x0000000200800000L});
    public static final BitSet FOLLOW_ruleBType_in_ruleStructType2698 = new BitSet(new long[]{0x0000000200800000L});
    public static final BitSet FOLLOW_33_in_ruleStructType2721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleStructType2742 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleStructType2755 = new BitSet(new long[]{0x0000FFD312A281C0L});
    public static final BitSet FOLLOW_RULE_VAR_TYPE_in_ruleStructType2772 = new BitSet(new long[]{0x0000000200800000L});
    public static final BitSet FOLLOW_ruleBType_in_ruleStructType2805 = new BitSet(new long[]{0x0000000200800000L});
    public static final BitSet FOLLOW_23_in_ruleStructType2825 = new BitSet(new long[]{0x0000FFD312A281C0L});
    public static final BitSet FOLLOW_RULE_VAR_TYPE_in_ruleStructType2841 = new BitSet(new long[]{0x0000000200800000L});
    public static final BitSet FOLLOW_ruleBType_in_ruleStructType2874 = new BitSet(new long[]{0x0000000200800000L});
    public static final BitSet FOLLOW_33_in_ruleStructType2897 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleStructType2910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBType_in_entryRuleBType2952 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBType2963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_ruleBType3003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleF_POINT_in_ruleBType3036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicType_in_ruleBType3069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleBType3095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicType_in_entryRuleBasicType3141 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBasicType3152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleBasicType3190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleBasicType3209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleBasicType3228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleBasicType3247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleF_POINT_in_entryRuleF_POINT3288 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleF_POINT3299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleF_POINT3337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleF_POINT3356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleF_POINT3375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleF_POINT3394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleF_POINT3413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleF_POINT3432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGetElementPtr_in_entryRuleGetElementPtr3472 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGetElementPtr3482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleGetElementPtr3519 = new BitSet(new long[]{0x0002FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_49_in_ruleGetElementPtr3532 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleGetElementPtr3555 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleGetElementPtr3568 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleGetElementPtr3589 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_ruleExtractValue_in_entryRuleExtractValue3627 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExtractValue3637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleExtractValue3674 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleAggregate_in_ruleExtractValue3695 = new BitSet(new long[]{0x0000FFD112A281C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleExtractValue3716 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleExtractValue3729 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleExtractValue3746 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_ruleInsertValue_in_entryRuleInsertValue3789 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInsertValue3799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleInsertValue3836 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleAggregate_in_ruleInsertValue3857 = new BitSet(new long[]{0x0000FFD112A281C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleInsertValue3878 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleInsertValue3890 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleInsertValue3911 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleInsertValue3924 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleInsertValue3941 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_ruleFence_in_entryRuleFence3984 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFence3994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleFence4031 = new BitSet(new long[]{0x0FE0000000000000L});
    public static final BitSet FOLLOW_53_in_ruleFence4044 = new BitSet(new long[]{0x0FE0000000000000L});
    public static final BitSet FOLLOW_ruleATOMIC_ORDERING_in_ruleFence4067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleATOMIC_ORDERING_in_entryRuleATOMIC_ORDERING4104 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleATOMIC_ORDERING4115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleATOMIC_ORDERING4153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleATOMIC_ORDERING4172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleATOMIC_ORDERING4191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleATOMIC_ORDERING4210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleATOMIC_ORDERING4229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleATOMIC_ORDERING4248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCmpXchg_in_entryRuleCmpXchg4288 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCmpXchg4298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleCmpXchg4335 = new BitSet(new long[]{0x2000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_61_in_ruleCmpXchg4348 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleCmpXchg4371 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleCmpXchg4383 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleCmpXchg4404 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleCmpXchg4416 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleCmpXchg4437 = new BitSet(new long[]{0x0FE0000000000000L});
    public static final BitSet FOLLOW_53_in_ruleCmpXchg4450 = new BitSet(new long[]{0x0FE0000000000000L});
    public static final BitSet FOLLOW_ruleATOMIC_ORDERING_in_ruleCmpXchg4473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomicRMW_in_entryRuleAtomicRMW4509 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAtomicRMW4519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleAtomicRMW4556 = new BitSet(new long[]{0xA000000000000000L,0x00000000000003FFL});
    public static final BitSet FOLLOW_61_in_ruleAtomicRMW4569 = new BitSet(new long[]{0xA000000000000000L,0x00000000000003FFL});
    public static final BitSet FOLLOW_ruleBIN_OP_in_ruleAtomicRMW4587 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleAtomicRMW4607 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleAtomicRMW4619 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleAtomicRMW4640 = new BitSet(new long[]{0x0FE0000000000000L});
    public static final BitSet FOLLOW_53_in_ruleAtomicRMW4653 = new BitSet(new long[]{0x0FE0000000000000L});
    public static final BitSet FOLLOW_ruleATOMIC_ORDERING_in_ruleAtomicRMW4676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBIN_OP_in_entryRuleBIN_OP4713 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBIN_OP4724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleBIN_OP4762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleBIN_OP4781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleBIN_OP4800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleBIN_OP4819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleBIN_OP4838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleBIN_OP4857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleBIN_OP4876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleBIN_OP4895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleBIN_OP4914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleBIN_OP4933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleBIN_OP4952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLoad_in_entryRuleLoad4992 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLoad5002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleLoad5040 = new BitSet(new long[]{0x2000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_61_in_ruleLoad5053 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleLoad5076 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleLoad5089 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_ruleALIGNMENT_in_ruleLoad5110 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleLoad5125 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_ruleLoad5137 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_ruleLoad5149 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleLoad5166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleLoad5193 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_ruleLoad5205 = new BitSet(new long[]{0x2000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_61_in_ruleLoad5218 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleLoad5241 = new BitSet(new long[]{0x0FE0000000000000L});
    public static final BitSet FOLLOW_53_in_ruleLoad5254 = new BitSet(new long[]{0x0FE0000000000000L});
    public static final BitSet FOLLOW_ruleATOMIC_ORDERING_in_ruleLoad5277 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleLoad5290 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_ruleLoad5302 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleLoad5319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStore_in_entryRuleStore5363 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStore5373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_ruleStore5411 = new BitSet(new long[]{0x2000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_61_in_ruleStore5424 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleStore5447 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleStore5459 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleStore5480 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleStore5493 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_ruleStore5505 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleStore5516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_ruleStore5537 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_ruleStore5549 = new BitSet(new long[]{0x2000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_61_in_ruleStore5562 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleStore5585 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleStore5597 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleStore5618 = new BitSet(new long[]{0x0FE0000000000000L});
    public static final BitSet FOLLOW_53_in_ruleStore5631 = new BitSet(new long[]{0x0FE0000000000000L});
    public static final BitSet FOLLOW_ruleATOMIC_ORDERING_in_ruleStore5654 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleStore5667 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_ruleStore5679 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleStore5696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_entryRuleCall5740 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCall5750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_ruleCall5788 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_ruleCall5802 = new BitSet(new long[]{0x0000FFD1122281C0L,0x000003FFFBFC0000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleCallingConv_in_ruleCall5819 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000003FC0000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleRETURN_ATTRIBUTES_in_ruleCall5837 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleCall5859 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleParameterList_in_ruleCall5880 = new BitSet(new long[]{0x0000000000000002L,0x0FFFFC0000000000L});
    public static final BitSet FOLLOW_ruleFUNCTION_ATTRIBUTES_in_ruleCall5897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRETURN_ATTRIBUTES_in_entryRuleRETURN_ATTRIBUTES5935 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRETURN_ATTRIBUTES5946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_ruleRETURN_ATTRIBUTES5984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_ruleRETURN_ATTRIBUTES6003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_ruleRETURN_ATTRIBUTES6022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_ruleRETURN_ATTRIBUTES6041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_ruleRETURN_ATTRIBUTES6060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_ruleRETURN_ATTRIBUTES6079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_ruleRETURN_ATTRIBUTES6098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_ruleRETURN_ATTRIBUTES6117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlloc_in_entryRuleAlloc6157 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlloc6167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_ruleAlloc6204 = new BitSet(new long[]{0x0000FFD112A281C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleAlloc6225 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleAlloc6238 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleAlloc6259 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleAlloc6274 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_ruleALIGNMENT_in_ruleAlloc6290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallingConv_in_entryRuleCallingConv6328 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCallingConv6339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_ruleCallingConv6377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_ruleCallingConv6396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_ruleCallingConv6415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_ruleCallingConv6434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_ruleCallingConv6453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_ruleCallingConv6472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_ruleCallingConv6491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_ruleCallingConv6510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_ruleCallingConv6529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_ruleCallingConv6548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_101_in_ruleCallingConv6567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_ruleCallingConv6586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_ruleCallingConv6605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_ruleCallingConv6624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_105_in_ruleCallingConv6644 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleCallingConv6657 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleCallingConv6672 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleCallingConv6690 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleCallingConv6705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFUNCTION_ATTRIBUTES_in_entryRuleFUNCTION_ATTRIBUTES6752 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFUNCTION_ATTRIBUTES6763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_106_in_ruleFUNCTION_ATTRIBUTES6801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_107_in_ruleFUNCTION_ATTRIBUTES6821 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleFUNCTION_ATTRIBUTES6834 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleFUNCTION_ATTRIBUTES6847 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFUNCTION_ATTRIBUTES6862 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleFUNCTION_ATTRIBUTES6880 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleFUNCTION_ATTRIBUTES6893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_ruleFUNCTION_ATTRIBUTES6913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_ruleFUNCTION_ATTRIBUTES6932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_ruleFUNCTION_ATTRIBUTES6951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_ruleFUNCTION_ATTRIBUTES6970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_ruleFUNCTION_ATTRIBUTES6989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_ruleFUNCTION_ATTRIBUTES7008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_ruleFUNCTION_ATTRIBUTES7027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_115_in_ruleFUNCTION_ATTRIBUTES7046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_116_in_ruleFUNCTION_ATTRIBUTES7065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_ruleFUNCTION_ATTRIBUTES7084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_ruleFUNCTION_ATTRIBUTES7103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_ruleFUNCTION_ATTRIBUTES7122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_ruleFUNCTION_ATTRIBUTES7141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_121_in_ruleFUNCTION_ATTRIBUTES7160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_122_in_ruleFUNCTION_ATTRIBUTES7179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_ruleFUNCTION_ATTRIBUTES7198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterList_in_entryRuleParameterList7238 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterList7248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleParameterList7294 = new BitSet(new long[]{0x0000FFD1922281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleParameterList7316 = new BitSet(new long[]{0x0000000080800000L});
    public static final BitSet FOLLOW_23_in_ruleParameterList7329 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleParameterList7350 = new BitSet(new long[]{0x0000000080800000L});
    public static final BitSet FOLLOW_31_in_ruleParameterList7366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePHI_in_entryRulePHI7402 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePHI7412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_rulePHI7449 = new BitSet(new long[]{0x0000FFD1126281C0L});
    public static final BitSet FOLLOW_ruleType_in_rulePHI7465 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_rulePHI7476 = new BitSet(new long[]{0x0000FFD112A281C0L});
    public static final BitSet FOLLOW_ruleValuePair_in_rulePHI7497 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_rulePHI7509 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_rulePHI7522 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_rulePHI7534 = new BitSet(new long[]{0x0000FFD112A281C0L});
    public static final BitSet FOLLOW_ruleValuePair_in_rulePHI7555 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_rulePHI7567 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_ruleValuePair_in_entryRuleValuePair7605 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValuePair7615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleValuePair7661 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleValuePair7673 = new BitSet(new long[]{0x0000FFD1122281C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleValuePair7694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLandingPad_in_entryRuleLandingPad7730 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLandingPad7740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_125_in_ruleLandingPad7778 = new BitSet(new long[]{0x0000FFD1122281C0L,0x4000000000000000L});
    public static final BitSet FOLLOW_ruleType_in_ruleLandingPad7799 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_126_in_ruleLandingPad7811 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleLandingPad7832 = new BitSet(new long[]{0x0000000000000000L,0x8000000000000000L,0x000000000000000CL});
    public static final BitSet FOLLOW_127_in_ruleLandingPad7846 = new BitSet(new long[]{0x0000000000000002L,0x8000000000000000L,0x000000000000000CL});
    public static final BitSet FOLLOW_ruleClause_in_ruleLandingPad7867 = new BitSet(new long[]{0x0000000000000002L,0x8000000000000000L,0x000000000000000CL});
    public static final BitSet FOLLOW_ruleClause_in_ruleLandingPad7896 = new BitSet(new long[]{0x0000000000000002L,0x8000000000000000L,0x000000000000000CL});
    public static final BitSet FOLLOW_125_in_ruleLandingPad7918 = new BitSet(new long[]{0x0000FFD1122281C0L,0x4000000000000000L});
    public static final BitSet FOLLOW_ruleType_in_ruleLandingPad7939 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_126_in_ruleLandingPad7951 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x00000000001FFE00L});
    public static final BitSet FOLLOW_ruleType_in_ruleLandingPad7972 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000001FFE00L});
    public static final BitSet FOLLOW_ruleCAST_TYPE_in_ruleLandingPad7993 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleLandingPad8005 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleType_in_ruleLandingPad8026 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_128_in_ruleLandingPad8038 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_VAR_TYPE_in_ruleLandingPad8049 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_129_in_ruleLandingPad8060 = new BitSet(new long[]{0x0000FFD1922281C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleLandingPad8081 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleLandingPad8093 = new BitSet(new long[]{0x0000000000000000L,0x8000000000000000L,0x000000000000000CL});
    public static final BitSet FOLLOW_127_in_ruleLandingPad8107 = new BitSet(new long[]{0x0000000000000002L,0x8000000000000000L,0x000000000000000CL});
    public static final BitSet FOLLOW_ruleClause_in_ruleLandingPad8128 = new BitSet(new long[]{0x0000000000000002L,0x8000000000000000L,0x000000000000000CL});
    public static final BitSet FOLLOW_ruleClause_in_ruleLandingPad8157 = new BitSet(new long[]{0x0000000000000002L,0x8000000000000000L,0x000000000000000CL});
    public static final BitSet FOLLOW_ruleClause_in_entryRuleClause8196 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClause8206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_130_in_ruleClause8244 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleClause8266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_131_in_ruleClause8285 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleClause8306 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleClause8319 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleClause8340 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_ruleSelect_in_entryRuleSelect8379 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelect8389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_132_in_ruleSelect8426 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleSelect8447 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleSelect8459 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleSelect8480 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleSelect8492 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleSelect8513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVA_Arg_in_entryRuleVA_Arg8549 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVA_Arg8559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_133_in_ruleVA_Arg8596 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleVA_Arg8617 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleVA_Arg8629 = new BitSet(new long[]{0x0000FFD1122281C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleVA_Arg8650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExtractElement_in_entryRuleExtractElement8686 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExtractElement8696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_134_in_ruleExtractElement8733 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleExtractElement8754 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleExtractElement8766 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleExtractElement8787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInsertElement_in_entryRuleInsertElement8823 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInsertElement8833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_135_in_ruleInsertElement8870 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleInsertElement8891 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleInsertElement8903 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleInsertElement8924 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleInsertElement8936 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleInsertElement8957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShuffleVector_in_entryRuleShuffleVector8993 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleShuffleVector9003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_136_in_ruleShuffleVector9040 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleShuffleVector9061 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleShuffleVector9073 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleShuffleVector9094 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleShuffleVector9106 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleShuffleVector9127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCast_in_entryRuleCast9163 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCast9173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCAST_TYPE_in_ruleCast9214 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleCast9234 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_129_in_ruleCast9246 = new BitSet(new long[]{0x0000FFD1122281C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleCast9267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCAST_TYPE_in_entryRuleCAST_TYPE9304 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCAST_TYPE9315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_137_in_ruleCAST_TYPE9353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_138_in_ruleCAST_TYPE9372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_139_in_ruleCAST_TYPE9391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_140_in_ruleCAST_TYPE9410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_141_in_ruleCAST_TYPE9429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_142_in_ruleCAST_TYPE9448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_143_in_ruleCAST_TYPE9467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_144_in_ruleCAST_TYPE9486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_145_in_ruleCAST_TYPE9505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_146_in_ruleCAST_TYPE9524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_147_in_ruleCAST_TYPE9543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_148_in_ruleCAST_TYPE9562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompare_in_entryRuleCompare9602 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCompare9612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_149_in_ruleCompare9650 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000001FF800000L});
    public static final BitSet FOLLOW_ruleI_PREDICATES_in_ruleCompare9666 = new BitSet(new long[]{0x0000FFD112A281C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleCompare9681 = new BitSet(new long[]{0x0000FFD112A281C0L});
    public static final BitSet FOLLOW_ruleValuePair_in_ruleCompare9702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_150_in_ruleCompare9721 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00001FFE1E000000L});
    public static final BitSet FOLLOW_ruleF_PREDICATES_in_ruleCompare9737 = new BitSet(new long[]{0x0000FFD112A281C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleCompare9752 = new BitSet(new long[]{0x0000FFD112A281C0L});
    public static final BitSet FOLLOW_ruleValuePair_in_ruleCompare9773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleI_PREDICATES_in_entryRuleI_PREDICATES9810 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleI_PREDICATES9821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_151_in_ruleI_PREDICATES9859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_152_in_ruleI_PREDICATES9878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_153_in_ruleI_PREDICATES9897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_154_in_ruleI_PREDICATES9916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_155_in_ruleI_PREDICATES9935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_156_in_ruleI_PREDICATES9954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_157_in_ruleI_PREDICATES9973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_158_in_ruleI_PREDICATES9992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_159_in_ruleI_PREDICATES10011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_160_in_ruleI_PREDICATES10030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleF_PREDICATES_in_entryRuleF_PREDICATES10071 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleF_PREDICATES10082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_161_in_ruleF_PREDICATES10120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_162_in_ruleF_PREDICATES10139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_163_in_ruleF_PREDICATES10158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_164_in_ruleF_PREDICATES10177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_165_in_ruleF_PREDICATES10196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_166_in_ruleF_PREDICATES10215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_167_in_ruleF_PREDICATES10234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_168_in_ruleF_PREDICATES10253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_169_in_ruleF_PREDICATES10272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_153_in_ruleF_PREDICATES10291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_154_in_ruleF_PREDICATES10310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_155_in_ruleF_PREDICATES10329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_156_in_ruleF_PREDICATES10348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_170_in_ruleF_PREDICATES10367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_171_in_ruleF_PREDICATES10386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_172_in_ruleF_PREDICATES10405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARITHMETIC_OP_in_entryRuleARITHMETIC_OP10446 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleARITHMETIC_OP10457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleARITHMETIC_OP10495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_173_in_ruleARITHMETIC_OP10514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleARITHMETIC_OP10533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_174_in_ruleARITHMETIC_OP10552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_175_in_ruleARITHMETIC_OP10571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_176_in_ruleARITHMETIC_OP10590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_177_in_ruleARITHMETIC_OP10609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_178_in_ruleARITHMETIC_OP10628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_179_in_ruleARITHMETIC_OP10647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_180_in_ruleARITHMETIC_OP10666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_181_in_ruleARITHMETIC_OP10685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_182_in_ruleARITHMETIC_OP10704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLOGICAL_OP_in_entryRuleLOGICAL_OP10745 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLOGICAL_OP10756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_183_in_ruleLOGICAL_OP10794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_184_in_ruleLOGICAL_OP10813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_185_in_ruleLOGICAL_OP10832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleLOGICAL_OP10851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleLOGICAL_OP10870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleLOGICAL_OP10889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArithmetic_in_entryRuleArithmetic10929 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArithmetic10939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARITHMETIC_OP_in_ruleArithmetic10980 = new BitSet(new long[]{0x0000FFD112A281C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleArithmetic10995 = new BitSet(new long[]{0x0000FFD112A281C0L});
    public static final BitSet FOLLOW_ruleValuePair_in_ruleArithmetic11016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogical_in_entryRuleLogical11051 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogical11061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLOGICAL_OP_in_ruleLogical11102 = new BitSet(new long[]{0x0000FFD112A281C0L});
    public static final BitSet FOLLOW_ruleType_in_ruleLogical11117 = new BitSet(new long[]{0x0000FFD112A281C0L});
    public static final BitSet FOLLOW_ruleValuePair_in_ruleLogical11138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_entryRuleInstruction11173 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstruction11183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitch_in_ruleInstruction11230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIndirectBranch_in_ruleInstruction11257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBranch_in_ruleInstruction11284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReturn_in_ruleInstruction11311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLoad_in_ruleInstruction11338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStore_in_ruleInstruction11365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFence_in_ruleInstruction11392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGetElementPtr_in_ruleInstruction11419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogical_in_ruleInstruction11446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArithmetic_in_ruleInstruction11473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompare_in_ruleInstruction11500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCast_in_ruleInstruction11527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShuffleVector_in_ruleInstruction11554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInsertElement_in_ruleInstruction11581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExtractElement_in_ruleInstruction11608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInvoke_in_ruleInstruction11635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResume_in_ruleInstruction11662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInsertValue_in_ruleInstruction11689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExtractValue_in_ruleInstruction11716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlloc_in_ruleInstruction11743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCmpXchg_in_ruleInstruction11770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomicRMW_in_ruleInstruction11797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePHI_in_ruleInstruction11824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelect_in_ruleInstruction11851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_ruleInstruction11878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVA_Arg_in_ruleInstruction11905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLandingPad_in_ruleInstruction11932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocalVar_in_ruleInstruction11959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIndirectBranch_in_entryRuleIndirectBranch11994 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIndirectBranch12004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_186_in_ruleIndirectBranch12041 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleIndirectBranch12062 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleIndirectBranch12074 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleIndirectBranch12086 = new BitSet(new long[]{0x0000FFD1132281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleLabelList_in_ruleIndirectBranch12107 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleIndirectBranch12120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLabelList_in_entryRuleLabelList12156 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLabelList12166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleLabelList12211 = new BitSet(new long[]{0x0000FFD1122281C2L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleSwitch_in_entryRuleSwitch12247 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSwitch12257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_187_in_ruleSwitch12294 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleSwitch12315 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleSwitch12327 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleSwitch12348 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleSwitch12360 = new BitSet(new long[]{0x0000FFD1132281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleJumpTable_in_ruleSwitch12381 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleSwitch12394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJumpTable_in_entryRuleJumpTable12430 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJumpTable12440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleJumpTable12486 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleJumpTable12498 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleJumpTable12519 = new BitSet(new long[]{0x0000FFD1122281C2L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleInvoke_in_entryRuleInvoke12556 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInvoke12566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_188_in_ruleInvoke12603 = new BitSet(new long[]{0x0000FFD1122281C0L,0x000003FFFBFC0000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleCallingConv_in_ruleInvoke12620 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000003FC0000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleRETURN_ATTRIBUTES_in_ruleInvoke12638 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleInvoke12660 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleParameterList_in_ruleInvoke12681 = new BitSet(new long[]{0x0000000000000000L,0x0FFFFC0000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFUNCTION_ATTRIBUTES_in_ruleInvoke12698 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_129_in_ruleInvoke12711 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleInvoke12732 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_189_in_ruleInvoke12744 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleInvoke12765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResume_in_entryRuleResume12801 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResume12811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_190_in_ruleResume12848 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleResume12870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReturn_in_entryRuleReturn12905 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReturn12915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_191_in_ruleReturn12962 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleReturn12974 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleReturn12987 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_192_in_ruleReturn12999 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_ruleReturn13011 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleReturn13022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_191_in_ruleReturn13043 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleReturn13064 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleReturn13077 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_192_in_ruleReturn13089 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_ruleReturn13101 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleReturn13112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBranch_in_entryRuleBranch13150 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBranch13160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_193_in_ruleBranch13198 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleBranch13219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_193_in_ruleBranch13239 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleBranch13260 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleBranch13272 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleBranch13293 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleBranch13305 = new BitSet(new long[]{0x0000FFD1122281C0L,0x0000000000000000L,0x0000000000000000L,0x00000000003FFFF8L});
    public static final BitSet FOLLOW_ruleTypeAndValue_in_ruleBranch13326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionBody_in_entryRuleFunctionBody13363 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunctionBody13373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleFunctionBody13410 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ruleBasicBlock_in_ruleFunctionBody13431 = new BitSet(new long[]{0x0000000200000200L});
    public static final BitSet FOLLOW_33_in_ruleFunctionBody13444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicBlock_in_entryRuleBasicBlock13480 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBasicBlock13490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NOBRACKET_in_ruleBasicBlock13532 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_194_in_ruleBasicBlock13549 = new BitSet(new long[]{0x501DFFD1122281C2L,0x3000000004038437L,0xDFFFE000007FFFF0L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_ruleBasicBlock13570 = new BitSet(new long[]{0x501DFFD1122281C2L,0x3000000004038437L,0xDFFFE000007FFFF0L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVISIBILITY_in_entryRuleVISIBILITY13608 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVISIBILITY13619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_195_in_ruleVISIBILITY13657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_196_in_ruleVISIBILITY13676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_197_in_ruleVISIBILITY13695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLINKAGE_in_entryRuleLINKAGE13736 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLINKAGE13747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_198_in_ruleLINKAGE13785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_199_in_ruleLINKAGE13804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_200_in_ruleLINKAGE13823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_201_in_ruleLINKAGE13842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_202_in_ruleLINKAGE13861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_203_in_ruleLINKAGE13880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_204_in_ruleLINKAGE13899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_205_in_ruleLINKAGE13918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_206_in_ruleLINKAGE13937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_207_in_ruleLINKAGE13956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_208_in_ruleLINKAGE13975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_209_in_ruleLINKAGE13994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleALIAS_LINKAGE_in_ruleLINKAGE14022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleALIAS_LINKAGE_in_entryRuleALIAS_LINKAGE14068 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleALIAS_LINKAGE14079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_210_in_ruleALIAS_LINKAGE14117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_211_in_ruleALIAS_LINKAGE14136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_212_in_ruleALIAS_LINKAGE14155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_213_in_ruleALIAS_LINKAGE14174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleALIGNMENT_in_entryRuleALIGNMENT14217 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleALIGNMENT14228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_ruleALIGNMENT14266 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleALIGNMENT14281 = new BitSet(new long[]{0x0000000000000002L});

}