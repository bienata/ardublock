package com.ardublock.translator.block.LM35demo;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Cd4094SendBlock extends TranslatorBlock {

    private final String functionSourceCode = 
"                                                         \n" + 
"void cd4094sendByte( unsigned char data ) {              \n" + 
"    for (int bit = 0; bit < 8; bit++ ) {                 \n" + 
"        digitalWrite ( cd4094_dataPin,   data & 0x80 );  \n" + 
"        data <<= 1;                                      \n" + 
"        digitalWrite ( cd4094_clockPin,  HIGH );         \n" + 
"        digitalWrite ( cd4094_clockPin,  LOW );          \n" + 
"    }                                                    \n" + 
"    digitalWrite ( cd4094_strobePin,  HIGH );            \n" +     
"    digitalWrite ( cd4094_strobePin,  LOW );             \n" +         
"}                                                        \n" + 
"                                                         \n";
    
    public Cd4094SendBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
        super(blockId, translator, codePrefix, codeSuffix, label);
    }

    @Override
    public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
        translator.addDefinitionCommand ( functionSourceCode );         
        String ret = "";
        ret += "cd4094sendByte ( ";
        ret += this.getRequiredTranslatorBlockAtSocket(0).toCode(); // n
        ret += " ); \n";      
        // generuje:  cd4094sendByte ( n );
        return codePrefix + ret + codeSuffix;
    }       
}