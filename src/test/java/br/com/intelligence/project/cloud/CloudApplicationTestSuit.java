package br.com.intelligence.project.cloud;



import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages( { "br.com.intelligence.project.cloud.jwt" , "br.com.intelligence.project.cloud.service" } )
public class CloudApplicationTestSuit {

}
