package org.example.layer;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "org.example.layer")
public class MyArchitectureTest {
    public static final String DOMAIN = "Domain";
    public static final String SERVICE = "Service";
    public static final String DAO = "Dao";
    public static final String CONTROLLER = "Controller";
    @ArchTest
    public static final ArchRule RULE_FROM_LAYERED_ARCHITECTURE = layeredArchitecture()
            .layer(DOMAIN).definedBy("org.example.layer.domain..")
            .layer(SERVICE).definedBy("org.example.layer.service..")
            .layer(DAO).definedBy("org.example.layer.dao..")
            .layer(CONTROLLER).definedBy("org.example.layer.controller..")
            .whereLayer(CONTROLLER).mayNotBeAccessedByAnyLayer()
            .whereLayer(SERVICE).mayOnlyBeAccessedByLayers(CONTROLLER)
            .whereLayer(DAO).mayOnlyBeAccessedByLayers(SERVICE);
}
