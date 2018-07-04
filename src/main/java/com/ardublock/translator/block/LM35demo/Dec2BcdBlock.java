package com.ardublock.translator.block.LM35demo;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Dec2BcdBlock extends TranslatorBlock {
    
    private final String functionSourceCode = 
         "// wygenerowane automatycznie, nie zmieniaj tego!\n" +
         "unsigned char Dec2Bcd ( unsigned char n ) {      \n" +
         "    return ( n / 10 * 16 ) + ( n % 10 );         \n" +                        
         "}                                                \n" +            
         "                                                 \n";
    
    public Dec2BcdBlock (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
	super(blockId, translator, codePrefix, codeSuffix, label);
    }    
    
    @Override
    public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
        translator.addDefinitionCommand( functionSourceCode );
        String ret = "";
        ret += " Dec2Bcd ( ";	
        ret += this.getRequiredTranslatorBlockAtSocket( 0 ).toCode();
	ret += " )";
	return codePrefix + ret + codeSuffix;        
    }
}

