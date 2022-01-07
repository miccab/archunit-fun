package org.example.onion;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.onionArchitecture;

@AnalyzeClasses(packages = "org.example.onion")
public class MyArchitectureTest {
    @ArchTest
    public static final ArchRule RULE_FROM_ONION_ARCHITECTURE = onionArchitecture()
            .domainModels("org.example.onion.domain.model..")
            .domainServices("org.example.onion.domain.service..")
            .applicationServices("org.example.onion.application..")
            .adapter("kafka", "org.example.onion.kafka..");
}
