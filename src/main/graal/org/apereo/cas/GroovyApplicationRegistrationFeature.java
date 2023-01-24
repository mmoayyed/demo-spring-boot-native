package org.apereo.cas;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfoList;
import io.github.classgraph.ScanResult;
import org.graalvm.nativeimage.hosted.Feature;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class GroovyApplicationRegistrationFeature implements Feature {

    @Override
    public void beforeAnalysis(BeforeAnalysisAccess beforeAnalysisAccess) {
        ClassGraph gradleSourceRepackClassGraph = new ClassGraph()
            .enableClassInfo()
            .enableMethodInfo()
//            .verbose()
            .enableAnnotationInfo()
            .acceptPackages("org.apereo.cas");

        try (var scanResult = gradleSourceRepackClassGraph.scan()) {
            registerGeneratedClosureClasses(scanResult, true);
            registerAllApplicationClasses(scanResult, true);
        }
    }

    private static void registerGeneratedClosureClasses(ScanResult scanResult, boolean isVerboseOutputEnabled) {
        ClassInfoList generatedGroovyClosureClassInfoList = scanResult.getClassesImplementing("org.codehaus.groovy.runtime.GeneratedClosure");

//        org.apereo.cas.RegistrationFeatureUtils.printClassInfoList("application-registerGeneratedClosureClasses", generatedGroovyClosureClassInfoList);
        org.apereo.cas.RegistrationFeatureUtils.registerClasses(generatedGroovyClosureClassInfoList);
    }

    private static void registerAllApplicationClasses(ScanResult scanResult, boolean isVerboseOutputEnabled) {
        ClassInfoList generatedGroovyClosureClassInfoList = scanResult.getClassesImplementing("org.codehaus.groovy.runtime.GeneratedClosure");
        ClassInfoList allApplicationClasses = scanResult.getClassesImplementing("groovy.lang.GroovyObject");

        allApplicationClasses = allApplicationClasses.filter(classInfo -> {
            List<String> excludedClasses = Arrays.asList("groovy.lang.Closure", "groovy.lang.GroovyObjectSupport");
            if (excludedClasses.contains(classInfo.getName())) {
                return false;
            }

            //noinspection RedundantIfStatement
            if (generatedGroovyClosureClassInfoList.contains(classInfo)) {
                return false;
            }

            return true;
        });

//        org.apereo.cas.RegistrationFeatureUtils.printClassInfoList("application-registerAllApplicationClasses", allApplicationClasses);
        org.apereo.cas.RegistrationFeatureUtils.registerClasses(allApplicationClasses);
    }
}
