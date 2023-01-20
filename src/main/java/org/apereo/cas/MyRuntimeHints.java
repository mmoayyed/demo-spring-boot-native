package org.apereo.cas;

import org.apereo.cas.services.ServiceRegistry;
import org.apereo.cas.services.ServiceRegistryExecutionPlanConfigurer;

import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.aot.hint.TypeReference;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.cors.CorsConfigurationSource;

import java.lang.reflect.Member;

public class MyRuntimeHints implements RuntimeHintsRegistrar {
    public MyRuntimeHints() {
    }

    @Override
    public void registerHints(final RuntimeHints hints, final ClassLoader classLoader) {
        hints.resources().registerType(org.apereo.cas.util.CasVersion.class);

        hints.proxies().registerJdkProxy(ServiceRegistry.class);
        hints.proxies().registerJdkProxy(ServiceRegistryExecutionPlanConfigurer.class);
        hints.proxies().registerJdkProxy(CorsConfigurationSource.class);
        
        hints.proxies().registerJdkProxy(TypeReference.of("org.apereo.cas.persondir.PersonDirectoryAttributeRepositoryPlanConfigurer"));
        hints.proxies().registerJdkProxy(TypeReference.of("org.apereo.cas.authentication.AuthenticationMetaDataPopulator"));
        hints.proxies().registerJdkProxy(TypeReference.of("org.apereo.cas.authentication.adaptive.geo.GeoLocationService"));
        hints.proxies().registerJdkProxy(TypeReference.of("org.apereo.cas.authentication.MultifactorAuthenticationTrigger"));
        hints.proxies().registerJdkProxy(TypeReference.of("org.apereo.cas.services.ServiceRegistryInitializer"));

        hints.proxies().registerJdkProxy(TypeReference.of("org.apereo.cas.services.ServiceRegistryInitializerEventListener"));
        hints.proxies().registerJdkProxy(TypeReference.of("org.apereo.cas.services.ServiceRegistryInitializerEventListener"),
            TypeReference.of("java.io.Serializable"),
            TypeReference.of("org.springframework.aop.SpringProxy"),
            TypeReference.of("org.springframework.aop.framework.Advised"),
            TypeReference.of("org.springframework.core.DecoratingProxy"));
//        hints.proxies().registerJdkProxy(TypeReference.of("java.io.Serializable"));
        hints.proxies().registerJdkProxy(InitializingBean.class);

        hints.reflection().registerType(TypeReference.of("com.github.benmanes.caffeine.cache.PSW"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(TypeReference.of("com.github.benmanes.caffeine.cache.PSWMS"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(TypeReference.of("com.github.benmanes.caffeine.cache.PSAMS"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(TypeReference.of("com.github.benmanes.caffeine.cache.SSLA"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(TypeReference.of("com.github.benmanes.caffeine.cache.SSLMSW"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(TypeReference.of("com.github.benmanes.caffeine.cache.SSLMSA"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(TypeReference.of("com.github.benmanes.caffeine.cache.SSMSW"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);

        hints.reflection().registerType(TypeReference.of("org.apereo.cas.authentication.principal.resolvers.PersonDirectoryPrincipalResolver"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);

        hints.reflection().registerType(TypeReference.of("org.apereo.cas.util.cipher.TicketGrantingCookieCipherExecutor"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(TypeReference.of("org.apereo.cas.util.cipher.WebflowConversationStateCipherExecutor"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        
        hints.reflection().registerType(TypeReference.of("org.codehaus.groovy.runtime.InvokerHelper"));
    }
}
