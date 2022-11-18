package com.bootcamp.it.demo2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.bootcamp.it.demo2.tests.GoogleSearchEngineIT;
import com.bootcamp.it.demo2.tests.YahooSearchEngineIT;

@RunWith(Suite.class)
@Suite.SuiteClasses({ GoogleSearchEngineIT.class, YahooSearchEngineIT.class })
public class SearchEngineTest {

}
