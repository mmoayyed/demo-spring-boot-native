package org.apereo.cas;

import io.github.classgraph.ClassInfo;
import io.github.classgraph.ClassInfoList;
import org.graalvm.nativeimage.hosted.RuntimeReflection;

public class RegistrationFeatureUtils {

    public static void registerClasses(ClassInfoList classInfoToRegisterList) {
        classInfoToRegisterList
            .forEach((ClassInfo classInfo) -> {
                try {
                    Class<?> someClass = Class.forName(classInfo.getName());
                    RuntimeReflection.register(someClass);
                    RuntimeReflection.register(someClass.getDeclaredConstructors());
                    RuntimeReflection.register(someClass.getDeclaredMethods());
                    RuntimeReflection.register(someClass.getDeclaredFields());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            });
    }

    public static void printClassInfoList(String classInfoListName, ClassInfoList classInfoList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("---------- ").append(classInfoListName).append("- start\n");

        for (ClassInfo classInfo : classInfoList) {
            stringBuilder.append(classInfo.toString()).append("\n");
        }

        stringBuilder.append("---------- ").append(classInfoListName).append(" - end\n");
        System.err.println(stringBuilder);
    }
}
