package org.rash.drools;

import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.rule.Package;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class MyRuleBase {

    public RuleBase readRuleBase(String ruleFileName) throws IOException, DroolsParserException {
        PackageBuilder packageBuilder = new PackageBuilder();
        InputStream resourceAsStream = getClass().getResourceAsStream("/org/rash/rules/" + ruleFileName);
        Reader reader = new InputStreamReader(resourceAsStream);
        packageBuilder.addPackageFromDrl(reader);

        RuleBase ruleBase = RuleBaseFactory.newRuleBase();
        Package rulePackage = packageBuilder.getPackage();
        ruleBase.addPackage(rulePackage);
        return ruleBase;
    }

}
