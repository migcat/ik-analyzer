package org.wltea.analyzer.solr;


import java.io.IOException;
import java.io.Reader;
import java.util.Map;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.ResourceLoader;
import org.apache.lucene.analysis.util.ResourceLoaderAware;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeSource.AttributeFactory;
import org.wltea.analyzer.lucene.IKTokenizer;

/**
 * 主要用于Solr分词使用
 * 
 * @author niko
 * @date 2012-12-25
 * @version
 */
public class IKTokenizerFactory extends TokenizerFactory {
     
	
	public IKTokenizerFactory(Map<String, String> args) {
		super(args);
		assureMatchVersion();
		useSmart = getBoolean(args, "useSmart", false);
	}

	private boolean useSmart;

	
	 public void init(Map<String, String> args) { 
		 
		 assureMatchVersion(); 
	 }
	 
	

	@Override
	public Tokenizer create(AttributeFactory attributeFactory, Reader input) {
		IKTokenizer ikTokenizer = new IKTokenizer(input, useSmart);
		return ikTokenizer;
	}

	

}