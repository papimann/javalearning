package com.kapil.java8.junit.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.kapil.java8.junit.TestJunit1;
import com.kapil.java8.junit.TestJunit2;

@RunWith(Suite.class)
@SuiteClasses({ TestJunit1.class, TestJunit2.class })
public class JavaTestSuite {

}
