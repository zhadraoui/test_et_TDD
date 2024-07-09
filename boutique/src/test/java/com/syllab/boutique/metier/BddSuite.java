package com.syllab.boutique.metier;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("com/syllab/boutique/metier")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.syllab.boutique.metier")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
public class BddSuite {

}