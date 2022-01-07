package org.example.puml;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import java.nio.file.Path;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.plantuml.PlantUmlArchCondition.Configurations.consideringOnlyDependenciesInAnyPackage;
import static com.tngtech.archunit.library.plantuml.PlantUmlArchCondition.adhereToPlantUmlDiagram;

@AnalyzeClasses(packages = "org.example.puml")
public class MyArchitectureTest {
    @ArchTest
    public static final ArchRule RULE_FROM_PLANT_UML = classes()
            .should(adhereToPlantUmlDiagram(Path.of("src/main/plantuml/components.puml"), consideringOnlyDependenciesInAnyPackage("org.example.puml..")));
}
