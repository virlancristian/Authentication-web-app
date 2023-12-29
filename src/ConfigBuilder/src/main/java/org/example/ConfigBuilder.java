package org.example;

public class ConfigBuilder {
    private final InternalIPConfigurer internalIPConfigurer;
    private final BackendPropsConfigurer backendPropsConfigurer;

    public ConfigBuilder() {
        internalIPConfigurer = new InternalIPConfigurer();
        backendPropsConfigurer = new BackendPropsConfigurer();
    }

    public void start() {
        internalIPConfigurer.copyInternalIP();
        internalIPConfigurer.writeInternalIP();

        backendPropsConfigurer.readBackendProperties();
        backendPropsConfigurer.readDbCredentials();
        backendPropsConfigurer.overwriteBackendProperties();
    }
}
