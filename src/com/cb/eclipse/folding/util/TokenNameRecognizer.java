/*
 * $Id$
 * $Date: Oct 12, 2004 7:28:22 PM $
 */
package com.cb.eclipse.folding.util;

import org.eclipse.jdt.core.compiler.ITerminalSymbols;


/**
 * Class usage XXX
 * 
 * @version $Revision: 1.2 $
 */
public abstract class TokenNameRecognizer {
	public static final String dumpToken(int token) {
		switch(token) {
			case ITerminalSymbols.TokenNameWHITESPACE :
				return "WHITESPACE";
			case ITerminalSymbols.TokenNameCOMMENT_LINE :
				return "COMMENT_LINE";
			case ITerminalSymbols.TokenNameCOMMENT_BLOCK :
				return "TokenNameCOMMENT_BLOCK";
			case ITerminalSymbols.TokenNameCOMMENT_JAVADOC :
				return "COMMENT_JAVADOC";
			
			case ITerminalSymbols.TokenNameIdentifier :
				return "NameIdentifier";
			case ITerminalSymbols.TokenNameabstract :
				return "abstract";
			
		    /**
		     * "assert" token (added in J2SE 1.4).
		     */
			case ITerminalSymbols.TokenNameassert :
				return "assert";
			case ITerminalSymbols.TokenNameboolean :
				return "boolean";
			case ITerminalSymbols.TokenNamebreak :
				return "";
			case ITerminalSymbols.TokenNamebyte :
				return "";
			case ITerminalSymbols.TokenNamecase :
				return "";
			case ITerminalSymbols.TokenNamecatch :
				return "";
			case ITerminalSymbols.TokenNamechar :
				return "";
			case ITerminalSymbols.TokenNameclass :
				return "class";
			case ITerminalSymbols.TokenNamecontinue :
				return "";
			case ITerminalSymbols.TokenNamedefault :
				return "";
			case ITerminalSymbols.TokenNamedo :
				return "";
			case ITerminalSymbols.TokenNamedouble :
				return "";
			case ITerminalSymbols.TokenNameelse :
				return "";
			case ITerminalSymbols.TokenNameextends :
				return "extends";
			case ITerminalSymbols.TokenNamefalse :
				return "false";
			case ITerminalSymbols.TokenNamefinal :
				return "final";
			case ITerminalSymbols.TokenNamefinally :
				return "";
			case ITerminalSymbols.TokenNamefloat :
				return "";
			case ITerminalSymbols.TokenNamefor :
				return "";
			case ITerminalSymbols.TokenNameif :
				return "";
			case ITerminalSymbols.TokenNameimplements :
				return "implements";
			case ITerminalSymbols.TokenNameimport :
				return "import";
			case ITerminalSymbols.TokenNameinstanceof :
				return "";
			case ITerminalSymbols.TokenNameint :
				return "";
			case ITerminalSymbols.TokenNameinterface :
				return "interface";
			case ITerminalSymbols.TokenNamelong :
				return "";
			case ITerminalSymbols.TokenNamenative :
				return "";
			case ITerminalSymbols.TokenNamenew :
				return "";
			case ITerminalSymbols.TokenNamenull :
				return "";
			case ITerminalSymbols.TokenNamepackage :
				return "package";
			case ITerminalSymbols.TokenNameprivate :
				return "private";
			case ITerminalSymbols.TokenNameprotected :
				return "protected";
			case ITerminalSymbols.TokenNamepublic :
				return "public";
			case ITerminalSymbols.TokenNamereturn :
				return "";
			case ITerminalSymbols.TokenNameshort :
				return "";
			case ITerminalSymbols.TokenNamestatic :
				return "";
			case ITerminalSymbols.TokenNamestrictfp :
				return "";
			case ITerminalSymbols.TokenNamesuper :
				return "";
			case ITerminalSymbols.TokenNameswitch :
				return "";
			case ITerminalSymbols.TokenNamesynchronized :
				return "";
			case ITerminalSymbols.TokenNamethis :
				return "";
			case ITerminalSymbols.TokenNamethrow :
				return "";
			case ITerminalSymbols.TokenNamethrows :
				return "";
			case ITerminalSymbols.TokenNametransient :
				return "";
			case ITerminalSymbols.TokenNametrue :
				return "";
			case ITerminalSymbols.TokenNametry :
				return "";
			case ITerminalSymbols.TokenNamevoid :
				return "";
			case ITerminalSymbols.TokenNamevolatile :
				return "";
			case ITerminalSymbols.TokenNamewhile :
				return "";
			case ITerminalSymbols.TokenNameIntegerLiteral :
				return "IntegerLiteral";
			case ITerminalSymbols.TokenNameLongLiteral :
				return "LongLiteral";
			case ITerminalSymbols.TokenNameFloatingPointLiteral :
				return "FloatingPointLiteral";
			case ITerminalSymbols.TokenNameDoubleLiteral :
				return "DoubleLiteral";
			case ITerminalSymbols.TokenNameCharacterLiteral :
				return "CharacterLiteral";
			case ITerminalSymbols.TokenNameStringLiteral :
				return "StringLiteral";
			case ITerminalSymbols.TokenNamePLUS_PLUS :
				return "";
			case ITerminalSymbols.TokenNameMINUS_MINUS :
				return "";
			case ITerminalSymbols.TokenNameEQUAL_EQUAL :
				return "";
			case ITerminalSymbols.TokenNameLESS_EQUAL :
				return "";
			case ITerminalSymbols.TokenNameGREATER_EQUAL :
				return "";
			case ITerminalSymbols.TokenNameNOT_EQUAL :
				return "";
			case ITerminalSymbols.TokenNameLEFT_SHIFT :
				return "";
			case ITerminalSymbols.TokenNameRIGHT_SHIFT :
				return "";
			case ITerminalSymbols.TokenNameUNSIGNED_RIGHT_SHIFT :
				return "";
			case ITerminalSymbols.TokenNamePLUS_EQUAL :
				return "";
			case ITerminalSymbols.TokenNameMINUS_EQUAL :
				return "";
			case ITerminalSymbols.TokenNameMULTIPLY_EQUAL :
				return "";
			case ITerminalSymbols.TokenNameDIVIDE_EQUAL :
				return "";
			case ITerminalSymbols.TokenNameAND_EQUAL :
				return "";
			case ITerminalSymbols.TokenNameOR_EQUAL :
				return "";
			case ITerminalSymbols.TokenNameXOR_EQUAL :
				return "";
			case ITerminalSymbols.TokenNameREMAINDER_EQUAL :
				return "";
			case ITerminalSymbols.TokenNameLEFT_SHIFT_EQUAL :
				return "";
			case ITerminalSymbols.TokenNameRIGHT_SHIFT_EQUAL :
				return "";
			case ITerminalSymbols.TokenNameUNSIGNED_RIGHT_SHIFT_EQUAL :
				return "";
			case ITerminalSymbols.TokenNameOR_OR :
				return "";
			case ITerminalSymbols.TokenNameAND_AND :
				return "";
			case ITerminalSymbols.TokenNamePLUS :
				return "";
			case ITerminalSymbols.TokenNameMINUS :
				return "";
			case ITerminalSymbols.TokenNameNOT :
				return "";
			case ITerminalSymbols.TokenNameREMAINDER :
				return "";
			case ITerminalSymbols.TokenNameXOR :
				return "";
			case ITerminalSymbols.TokenNameAND :
				return "";
			case ITerminalSymbols.TokenNameMULTIPLY :
				return "";
			case ITerminalSymbols.TokenNameOR :
				return "";
			case ITerminalSymbols.TokenNameTWIDDLE :
				return "";
			case ITerminalSymbols.TokenNameDIVIDE :
				return "";
			case ITerminalSymbols.TokenNameGREATER :
				return "";
			case ITerminalSymbols.TokenNameLESS :
				return "";
			case ITerminalSymbols.TokenNameLPAREN :
				return "LPAREN";
			case ITerminalSymbols.TokenNameRPAREN :
				return "RPAREN";
			case ITerminalSymbols.TokenNameLBRACE :
				return "LBRACE";
			case ITerminalSymbols.TokenNameRBRACE :
				return "RBRACE";
			case ITerminalSymbols.TokenNameLBRACKET :
				return "";
			case ITerminalSymbols.TokenNameRBRACKET :
				return "";
			case ITerminalSymbols.TokenNameSEMICOLON :
				return "";
			case ITerminalSymbols.TokenNameQUESTION :
				return "";
			case ITerminalSymbols.TokenNameCOLON :
				return "";
			case ITerminalSymbols.TokenNameCOMMA :
				return "";
			case ITerminalSymbols.TokenNameDOT :
				return "";
			case ITerminalSymbols.TokenNameEQUAL :
				return "";
			case ITerminalSymbols.TokenNameEOF :
				return "";
			case ITerminalSymbols.TokenNameERROR :
				return "ERROR";
		     
		    /**
		     * "enum" keyword (added in J2SE 1.5).
		     * @since 3.0
		     */
			case ITerminalSymbols.TokenNameenum :
				return "";
		    /**
		     * "@" ITerminalSymbols.Token (added in J2SE 1.5).
		     * @since 3.0
		     */
			case ITerminalSymbols.TokenNameAT :
				return "";
		    /**
		     * "..." token (added in J2SE 1.5).
		     * @since 3.0
		     */
			case ITerminalSymbols.TokenNameELLIPSIS :
				return "elipsis";
		   default:
		   	return "";
		}
	}
}
