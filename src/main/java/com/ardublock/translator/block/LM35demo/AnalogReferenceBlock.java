package com.ardublock.translator.block.LM35demo;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class AnalogReferenceBlock extends TranslatorBlock {

    public AnalogReferenceBlock (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
	super(blockId, translator, codePrefix, codeSuffix, label);
    }    
    
    @Override
    public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
        String ret = "";
        ret += " analogReference ( ";	
        ret += this.getRequiredTranslatorBlockAtSocket( 0 ).toCode();
	ret += " ); ";
	return codePrefix + ret + codeSuffix;        
    }
}

