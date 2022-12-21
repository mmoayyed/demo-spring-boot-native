package org.apereo.cas;

import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.aot.hint.TypeReference;

public class MyRuntimeHints implements RuntimeHintsRegistrar {
    public MyRuntimeHints() {
    }

    @Override
    public void registerHints(final RuntimeHints hints, final ClassLoader classLoader) {
        hints.reflection()
            .registerType(TypeReference.of("org.apereo.cas.context.CasApplicationContextInitializer"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS)

            .registerType(TypeReference.of("org.springframework.boot.context.properties.migrator.PropertiesMigrationListener"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS)

            .registerType(TypeReference.of("org.springframework.cloud.util.random.CachedRandomPropertySourceEnvironmentPostProcessor"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS)

            .registerType(TypeReference.of("org.springframework.cloud.client.HostInfoEnvironmentPostProcessor"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS)

            .registerType(TypeReference.of("org.springframework.cloud.bootstrap.encrypt.DecryptEnvironmentPostProcessor"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS)
            .registerType(TypeReference.of("org.springframework.cloud.bootstrap.BootstrapConfigFileApplicationListener"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS)
            .registerType(TypeReference.of("org.springframework.cloud.bootstrap.LoggingSystemShutdownListener"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS)
            .registerType(TypeReference.of("org.springframework.cloud.bootstrap.TextEncryptorConfigBootstrapper"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS)
            .registerType(TypeReference.of("org.springframework.cloud.bootstrap.BootstrapApplicationListener"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS)
            .registerType(TypeReference.of("org.springframework.cloud.bootstrap.RefreshBootstrapRegistryInitializer"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS)

            .registerType(TypeReference.of("org.springframework.cloud.context.restart.RestartListener"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS)

            .registerType(TypeReference.of("org.springframework.cloud.config.client.ConfigServerConfigDataLoader"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS)
            .registerType(TypeReference.of("org.springframework.cloud.config.client.ConfigServerConfigDataLocationResolver"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS)
            .registerType(TypeReference.of("org.springframework.cloud.config.client.ConfigServerConfigDataMissingEnvironmentPostProcessor"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS)
            .registerType(TypeReference.of("org.springframework.cloud.config.client.ConfigClientRetryBootstrapper"), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
    }
}
