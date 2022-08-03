package com.minhcv.test;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.jupiter.api.Test;

public class ArchitectureTest {

    @Test
    public void notCallControllerInService() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.minhcv.java11.architectures_test.service");
        ArchRule rule = ArchRuleDefinition.classes().that().resideInAPackage("..controller..").should().resideInAnyPackage("..service..");
        rule.check(importedClasses);
    }
}
