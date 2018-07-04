package com.ardublock.translator.block.LM35demo;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class DefaultConstBlock extends TranslatorBlock {

    public DefaultConstBlock (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
	super(blockId, translator, codePrefix, codeSuffix, label);
    }    
    
    @Override
    public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
	return codePrefix + " DEFAULT " + codeSuffix;        
    }
}
