package org.apereo.cas;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ClassInfoList;
import io.github.classgraph.ScanResult;
import org.graalvm.nativeimage.hosted.Feature;

public class GroovyDgmClassesRegistrationFeature implements Feature {
    @Override
    public void beforeAnalysis(BeforeAnalysisAccess beforeAnalysisAccess) {
        String groovyRuntimePackage = "org.codehaus.groovy.runtime";

        ClassGraph groovyRuntimeClassGraph = new ClassGraph()
            .enableClassInfo()
//            .verbose()
            .acceptPackages(groovyRuntimePackage);

        try (var scanResult = groovyRuntimeClassGraph.scan()) {
            registerDefaultGroovyMethods(scanResult);
            registerClosureExtendingClasses(scanResult);
        }
    }

    protected void registerDefaultGroovyMethods(ScanResult scanResult) {
        ClassInfoList defaultGroovyMethodClassInfoCandidateList = scanResult.getSubclasses("org.codehaus.groovy.reflection.GeneratedMetaMethod");
        ClassInfoList defaultGroovyMethodClassInfoFilteredList =
            defaultGroovyMethodClassInfoCandidateList
                .filter((ClassInfo defaultGroovyMethodClassInfoCandidate) -> defaultGroovyMethodClassInfoCandidate.getName().matches("^org.codehaus.groovy.runtime.dgm\\$[0-9]+$"));
//        RegistrationFeatureUtils.printClassInfoList("dgm-registerDefaultGroovyMethods", defaultGroovyMethodClassInfoFilteredList);
        RegistrationFeatureUtils.registerClasses(defaultGroovyMethodClassInfoFilteredList);
    }

    protected void registerClosureExtendingClasses(ScanResult scanResult) {
        ClassInfoList groovyRuntimeClosureExtendingClassList = scanResult.getSubclasses("groovy.lang.Closure");
//        RegistrationFeatureUtils.printClassInfoList("dgm-registerClosureExtendingClasses", groovyRuntimeClosureExtendingClassList);
        RegistrationFeatureUtils.registerClasses(groovyRuntimeClosureExtendingClassList);
    }
}
