package com.paracamplus.ilp1.ilp1tme1.test;

import java.io.File;

import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


import com.paracamplus.ilp1.interpreter.test.InterpreterRunner;
import com.paracamplus.ilp1.interpreter.test.InterpreterTest;

@RunWith(Parameterized.class)
public class InterpreterTestTME1 extends InterpreterTest {
    
    public InterpreterTestTME1(File file) {
		super(file);
	
	}

	protected static String[] samplesDirName = { "SamplesTME1" }; 
    protected static String pattern = ".*";
    
    @Parameters(name = "{0}")
    public static Collection<File[]> data() throws Exception {
    	return InterpreterRunner.getFileList(samplesDirName, pattern);
    }    	
    
}