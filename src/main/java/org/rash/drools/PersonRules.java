package org.rash.drools;

import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;
import org.drools.core.rule.Package;
import org.rash.drools.model.Person;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class PersonRules {
    public static void main(String[] args) throws IOException, DroolsParserException {
        PersonRules personRules = new PersonRules();
        personRules.executeRule();
    }

    private void executeRule() throws IOException, DroolsParserException {
        InputStream inputStream = getClass().getResourceAsStream("/org/rash/rules/personrules.yml");
        Reader reader = new InputStreamReader(inputStream);
        PackageBuilder packageBuilder = new PackageBuilder();
        packageBuilder.addPackageFromDrl(reader);
        Package rulePackage = packageBuilder.getPackage();
        RuleBase ruleBase = RuleBaseFactory.newRuleBase();
        ruleBase.addPackage(rulePackage);
        WorkingMemory workingMemory = ruleBase.newStatefulSession();

        Person peron = new Person("Rasool", 23);
        workingMemory.insert(peron);
        workingMemory.fireAllRules();
        System.out.println(peron.getGreet());
    }
}
