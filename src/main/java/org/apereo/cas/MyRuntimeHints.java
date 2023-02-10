package org.apereo.cas;

import org.apereo.cas.audit.AuditTrailExecutionPlanConfigurer;
import org.apereo.cas.authentication.AuthenticationEventExecutionPlanConfigurer;
import org.apereo.cas.services.ServiceRegistry;
import org.apereo.cas.services.ServiceRegistryExecutionPlanConfigurer;
import org.apereo.cas.ticket.TicketFactoryExecutionPlanConfigurer;
import org.apereo.cas.ticket.serialization.TicketSerializationExecutionPlanConfigurer;
import org.apereo.cas.util.CasVersion;
import org.apereo.cas.util.serialization.ComponentSerializationPlanConfigurer;
import org.apereo.cas.web.flow.CasWebflowConfigurer;
import org.apereo.cas.web.flow.CasWebflowExecutionPlanConfigurer;

import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.aot.hint.TypeReference;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.cors.CorsConfigurationSource;
import org.thymeleaf.standard.StandardDialect;

import java.lang.module.Configuration;
import java.lang.module.ResolvedModule;
import java.util.List;

public class MyRuntimeHints implements RuntimeHintsRegistrar {
    public MyRuntimeHints() {
    }

    @Override
    public void registerHints(final RuntimeHints hints, final ClassLoader classLoader) {
        hints.resources().registerType(CasVersion.class);

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
        hints.proxies().registerJdkProxy(InitializingBean.class);
        hints.proxies().registerJdkProxy(CasWebflowConfigurer.class);
        hints.proxies().registerJdkProxy(CasWebflowExecutionPlanConfigurer.class);
        hints.proxies().registerJdkProxy(AuditTrailExecutionPlanConfigurer.class);
        hints.proxies().registerJdkProxy(AuthenticationEventExecutionPlanConfigurer.class);
        hints.proxies().registerJdkProxy(ComponentSerializationPlanConfigurer.class);
        hints.proxies().registerJdkProxy(TicketFactoryExecutionPlanConfigurer.class);
        hints.proxies().registerJdkProxy(TicketSerializationExecutionPlanConfigurer.class);

        hints.reflection().registerType(TypeReference.of("com.github.benmanes.caffeine.cache.PSW"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(TypeReference.of("com.github.benmanes.caffeine.cache.PSWMS"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(TypeReference.of("com.github.benmanes.caffeine.cache.PSAMS"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(TypeReference.of("com.github.benmanes.caffeine.cache.SSLA"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(TypeReference.of("com.github.benmanes.caffeine.cache.SSLMSW"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(TypeReference.of("com.github.benmanes.caffeine.cache.SSLMSA"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(TypeReference.of("com.github.benmanes.caffeine.cache.SSMSW"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);

        hints.reflection().registerType(Module.class, MemberCategory.INVOKE_DECLARED_METHODS);
        hints.reflection().registerType(Class.class, MemberCategory.INVOKE_DECLARED_METHODS);
        hints.reflection().registerType(ModuleLayer.class, MemberCategory.INVOKE_DECLARED_METHODS);
        hints.reflection().registerType(Configuration.class, MemberCategory.INVOKE_DECLARED_METHODS);
        hints.reflection().registerType(ResolvedModule.class, MemberCategory.INVOKE_DECLARED_METHODS);

        hints.reflection().registerType(TypeReference.of("nonapi.io.github.classgraph.classloaderhandler.AntClassLoaderHandler"), MemberCategory.INVOKE_DECLARED_METHODS);
        hints.reflection().registerType(TypeReference.of("nonapi.io.github.classgraph.classloaderhandler.URLClassLoaderHandler"), MemberCategory.INVOKE_DECLARED_METHODS);
        hints.reflection().registerType(TypeReference.of("nonapi.io.github.classgraph.classloaderhandler.ClassGraphClassLoaderHandler"), MemberCategory.INVOKE_DECLARED_METHODS);
        hints.reflection().registerType(TypeReference.of("nonapi.io.github.classgraph.classloaderhandler.FallbackClassLoaderHandler"), MemberCategory.INVOKE_DECLARED_METHODS);
        hints.reflection().registerType(TypeReference.of("nonapi.io.github.classgraph.classloaderhandler.SpringBootRestartClassLoaderHandler"), MemberCategory.INVOKE_DECLARED_METHODS);
        hints.reflection().registerType(TypeReference.of("nonapi.io.github.classgraph.classpath.ClasspathOrder"));
        hints.reflection().registerType(TypeReference.of("nonapi.io.github.classgraph.classpath.ClasspathOrder"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);

        List.of("nonapi.io.github.classgraph.classloaderhandler.AntClassLoaderHandler",
            "nonapi.io.github.classgraph.classloaderhandler.ClassGraphClassLoaderHandler",
            "nonapi.io.github.classgraph.classloaderhandler.ClassLoaderHandler",
            "nonapi.io.github.classgraph.classloaderhandler.ClassLoaderHandlerRegistry",
            "nonapi.io.github.classgraph.classloaderhandler.CxfContainerClassLoaderHandler",
            "nonapi.io.github.classgraph.classloaderhandler.EquinoxClassLoaderHandler",
            "nonapi.io.github.classgraph.classloaderhandler.EquinoxContextFinderClassLoaderHandler",
            "nonapi.io.github.classgraph.classloaderhandler.FallbackClassLoaderHandler",
            "nonapi.io.github.classgraph.classloaderhandler.FelixClassLoaderHandler",
            "nonapi.io.github.classgraph.classloaderhandler.JBossClassLoaderHandler",
            "nonapi.io.github.classgraph.classloaderhandler.JPMSClassLoaderHandler",
            "nonapi.io.github.classgraph.classloaderhandler.OSGiDefaultClassLoaderHandler",
            "nonapi.io.github.classgraph.classloaderhandler.ParentLastDelegationOrderTestClassLoaderHandler",
            "nonapi.io.github.classgraph.classloaderhandler.PlexusClassWorldsClassRealmClassLoaderHandler",
            "nonapi.io.github.classgraph.classloaderhandler.QuarkusClassLoaderHandler",
            "nonapi.io.github.classgraph.classloaderhandler.SpringBootRestartClassLoaderHandler",
            "nonapi.io.github.classgraph.classloaderhandler.TomcatWebappClassLoaderBaseHandler",
            "nonapi.io.github.classgraph.classloaderhandler.UnoOneJarClassLoaderHandler",
            "nonapi.io.github.classgraph.classloaderhandler.URLClassLoaderHandler",
            "nonapi.io.github.classgraph.classloaderhandler.WeblogicClassLoaderHandler",
            "nonapi.io.github.classgraph.classloaderhandler.WebsphereLibertyClassLoaderHandler",
            "nonapi.io.github.classgraph.classloaderhandler.WebsphereTraditionalClassLoaderHandler").forEach(
            clazz -> hints.reflection().registerTypeIfPresent(classLoader, clazz, MemberCategory.INVOKE_DECLARED_METHODS));


        hints.reflection().registerType(TypeReference.of("nz.net.ultraq.thymeleaf.layoutdialect.decorators.strategies.AppendingStrategy"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection()
            .registerType(TypeReference.of("nz.net.ultraq.thymeleaf.layoutdialect.PojoLoggerFactory"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS, MemberCategory.INVOKE_DECLARED_METHODS);
        hints.reflection().registerType(TypeReference.of("nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect"), MemberCategory.DECLARED_FIELDS);
        hints.reflection().registerType(TypeReference.of("org.thymeleaf.templatemode.TemplateMode"), MemberCategory.DECLARED_FIELDS);

        hints.reflection().registerType(TypeReference.of("org.thymeleaf.standard.processor.StandardXmlNsTagProcessor"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);

        hints.reflection().registerType(TypeReference.of("nz.net.ultraq.thymeleaf.layoutdialect.decorators.DecorateProcessor"),
            MemberCategory.INVOKE_DECLARED_CONSTRUCTORS, MemberCategory.INVOKE_DECLARED_METHODS, MemberCategory.INVOKE_PUBLIC_METHODS, MemberCategory.DECLARED_FIELDS);
        hints.reflection().registerType(TypeReference.of("nz.net.ultraq.thymeleaf.layoutdialect.decorators.TitlePatternProcessor"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS,
            MemberCategory.DECLARED_FIELDS);
        hints.reflection()
            .registerType(TypeReference.of("nz.net.ultraq.thymeleaf.layoutdialect.includes.IncludeProcessor"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS, MemberCategory.DECLARED_FIELDS);
        hints.reflection()
            .registerType(TypeReference.of("nz.net.ultraq.thymeleaf.layoutdialect.includes.InsertProcessor"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS, MemberCategory.DECLARED_FIELDS);
        hints.reflection()
            .registerType(TypeReference.of("nz.net.ultraq.thymeleaf.layoutdialect.includes.ReplaceProcessor"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS, MemberCategory.DECLARED_FIELDS);
        hints.reflection().registerType(TypeReference.of("nz.net.ultraq.thymeleaf.layoutdialect.fragments.CollectFragmentProcessor"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS,
            MemberCategory.DECLARED_FIELDS);
        hints.reflection()
            .registerType(TypeReference.of("nz.net.ultraq.thymeleaf.layoutdialect.fragments.FragmentProcessor"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS, MemberCategory.DECLARED_FIELDS);
        hints.reflection().registerType(TypeReference.of("nz.net.ultraq.thymeleaf.layoutdialect.models.TemplateModelFinder"),
            MemberCategory.INVOKE_DECLARED_METHODS, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(TypeReference.of("nz.net.ultraq.thymeleaf.layoutdialect.models.extensions.EventIterator"),
            MemberCategory.INVOKE_DECLARED_METHODS, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(TypeReference.of("org.thymeleaf.context.WebEngineContext"), MemberCategory.INVOKE_DECLARED_METHODS, MemberCategory.INVOKE_PUBLIC_METHODS);
        hints.reflection().registerType(TypeReference.of("org.thymeleaf.engine.TemplateData"), MemberCategory.INVOKE_DECLARED_METHODS, MemberCategory.INVOKE_PUBLIC_METHODS);
        hints.reflection().registerType(TypeReference.of("org.thymeleaf.EngineConfiguration"), MemberCategory.INVOKE_DECLARED_METHODS, MemberCategory.INVOKE_PUBLIC_METHODS);
        hints.reflection().registerType(TypeReference.of("org.thymeleaf.engine.TemplateManager"), MemberCategory.INVOKE_DECLARED_METHODS, MemberCategory.INVOKE_PUBLIC_METHODS);
        hints.reflection().registerType(TypeReference.of("org.thymeleaf.engine.TemplateModel"), MemberCategory.INVOKE_DECLARED_METHODS, MemberCategory.INVOKE_PUBLIC_METHODS);
        hints.reflection().registerType(TypeReference.of("org.thymeleaf.engine.Model"), MemberCategory.INVOKE_DECLARED_METHODS, MemberCategory.INVOKE_PUBLIC_METHODS);

        hints.reflection().registerType(TypeReference.of("org.apereo.cas.authentication.principal.resolvers.PersonDirectoryPrincipalResolver"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(TypeReference.of("org.apereo.cas.authentication.credential.UsernamePasswordCredential"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(TypeReference.of("org.apereo.cas.services.web.CasThymeleafOutputTemplateHandler"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);

        hints.reflection().registerType(TypeReference.of("org.apereo.cas.util.cipher.TicketGrantingCookieCipherExecutor"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(TypeReference.of("org.apereo.cas.util.cipher.WebflowConversationStateCipherExecutor"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);

        hints.reflection().registerType(TypeReference.of("org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(TypeReference.of("org.springframework.context.annotation.ConfigurationClassPostProcessor"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(TypeReference.of("org.springframework.context.event.EventListenerMethodProcessor"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(TypeReference.of("org.springframework.context.event.DefaultEventListenerFactory"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(TypeReference.of("org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(TypeReference.of("org.springframework.context.annotation.CommonAnnotationBeanPostProcessor"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
//        hints.reflection().registerType(TypeReference.of( "org.thymeleaf.standard.StandardDialect"),
//            MemberCategory.PUBLIC_FIELDS, MemberCategory.DECLARED_FIELDS);

        hints.reflection().registerType(TypeReference.of( "org.thymeleaf.standard.StandardDialect"),
            MemberCategory.INVOKE_DECLARED_METHODS, MemberCategory.INVOKE_PUBLIC_METHODS, MemberCategory.INTROSPECT_DECLARED_METHODS, MemberCategory.INTROSPECT_PUBLIC_METHODS);

        for (int i = 1; i <= 1500; i++) {
            var el =  "org.codehaus.groovy.runtime.dgm$" + i;
            hints.reflection().registerTypeIfPresent(classLoader, el,
                MemberCategory.INVOKE_DECLARED_CONSTRUCTORS, MemberCategory.INVOKE_PUBLIC_CONSTRUCTORS,
                MemberCategory.INVOKE_DECLARED_METHODS, MemberCategory.INVOKE_PUBLIC_METHODS,
                MemberCategory.DECLARED_FIELDS, MemberCategory.PUBLIC_FIELDS);
        }

        List.of(
            "org.springframework.webflow.engine.impl.RequestControlContextImpl",
                "nz.net.ultraq.thymeleaf.layoutdialect.decorators.DecorateProcessor$_doProcess_closure1",
                "nz.net.ultraq.thymeleaf.layoutdialect.decorators.DecorateProcessor$_doProcess_closure2",
                "nz.net.ultraq.thymeleaf.layoutdialect.context.extensions.IContextExtensions$_getPrefixForDialect_closure1$_closure2",
                "nz.net.ultraq.thymeleaf.layoutdialect.context.extensions.IContextExtensions$_getPrefixForDialect_closure1",
                "nz.net.ultraq.thymeleaf.expressionprocessor.ExpressionProcessor",
                "org.slf4j.LoggerFactory",
                "org.thymeleaf.engine.OpenElementTag",
                "org.thymeleaf.engine.CloseElementTag",
                "org.thymeleaf.engine.StandardModelFactory",
                "org.thymeleaf.DialectConfiguration"
            )
            .forEach(el -> {
                hints.reflection().registerType(TypeReference.of(el),
                    MemberCategory.INVOKE_DECLARED_CONSTRUCTORS, MemberCategory.INVOKE_PUBLIC_CONSTRUCTORS,
                    MemberCategory.INVOKE_DECLARED_METHODS, MemberCategory.INVOKE_PUBLIC_METHODS,
                    MemberCategory.DECLARED_FIELDS, MemberCategory.PUBLIC_FIELDS);
            });
    }
}
