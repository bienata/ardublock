/* tasza */
package com.ardublock.translator.block.LM35demo;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Cd4094InitBlock extends TranslatorBlock {

    private final String functionSourceCode = 
"                                          \n" + 
"#define CD4094_STROBE   2                 \n" + 
"#define CD4094_DATA     3                 \n" + 
"#define CD4094_CLOCK    4                 \n" + 
"int cd4094_strobePin = CD4094_STROBE;     \n" + 
"int cd4094_dataPin = CD4094_DATA;         \n" + 
"int cd4094_clockPin = CD4094_CLOCK;       \n" + 
"                                          \n" + 
"void cd4094setup ( int s, int d, int c ) {\n" + 
"  cd4094_strobePin = s;                   \n" + 
"  cd4094_dataPin = d;                     \n" + 
"  cd4094_clockPin = c;                    \n" + 
"  pinMode ( cd4094_strobePin,  OUTPUT );  \n" + 
"  pinMode ( cd4094_dataPin,    OUTPUT );  \n" + 
"  pinMode ( cd4094_clockPin,   OUTPUT );  \n" + 
"  digitalWrite ( cd4094_strobePin, LOW ); \n" + 
"  digitalWrite ( cd4094_dataPin,   LOW ); \n" + 
"  digitalWrite ( cd4094_clockPin,  LOW ); \n" + 
"}                                         \n" + 
"                                          \n";
    
    public Cd4094InitBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
	super(blockId, translator, codePrefix, codeSuffix, label);
    }

    @Override
    public String toCode() throws SocketNullException, SubroutineNotDeclaredException {        
        translator.addDefinitionCommand ( functionSourceCode );     
        String ret =  "";
        ret += "cd4094setup ( ";	 
	ret += this.getRequiredTranslatorBlockAtSocket(0).toCode(); // strobe 
        ret += ", ";
        ret += this.getRequiredTranslatorBlockAtSocket(1).toCode(); // data 
        ret += ", ";
        ret += this.getRequiredTranslatorBlockAtSocket(2).toCode(); // clock
	ret += " ); \n";	    
	// generuje:        cd4094setup ( x,y,z );
	return codePrefix + ret + codeSuffix;
    }		
}
