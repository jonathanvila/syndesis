/*
 * Copyright (C) 2016 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.syndesis.server.openshift;

import io.fabric8.openshift.client.OpenShiftConfig;
import io.fabric8.openshift.client.OpenShiftConfigBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties("openshift")
@Validated
public class OpenShiftConfigurationProperties {

    public static final String SERVICE_CA_CERT_FILE = "/var/run/secrets/kubernetes.io/serviceaccount/service-ca.crt";

    private boolean enabled;

    private String openShiftHost = "https://openshift.default.svc";

    private final OpenShiftConfig openShiftClientConfig = new OpenShiftConfigBuilder().withMasterUrl(openShiftHost).withCaCertFile(SERVICE_CA_CERT_FILE).build();

    private String builderImageStreamTag = "s2i-java:2.0";

    private String deploymentMemoryRequestMi = "280";
    private String deploymentMemoryLimitMi = "512";
    private String mavenOptions = "-XX:+UseG1GC -XX:+UseStringDeduplication -Xmx300m";

    private String apiBaseUrl;

    private String namespace;
    private String imageStreamNamespace;

    private String integrationDataPath = "${JAVA_DATA_DIR}/syndesis/loader";

    private boolean debug;

    private int maximumRetries = 3;
    private long pollingInterval = 5000;

    public void setDebug(final boolean debug) {
        this.debug = debug;
    }

    public boolean isDebug() {
        return debug;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getOpenShiftHost() {
        return openShiftHost;
    }

    public void setOpenShiftHost(String openShiftHost) {
        this.openShiftHost = openShiftHost;
    }

    public OpenShiftConfig getOpenShiftClientConfiguration() {
        return openShiftClientConfig;
    }

    public String getBuilderImageStreamTag() {
        return builderImageStreamTag;
    }

    public void setBuilderImageStreamTag(String builderImageStreamTag) {
        this.builderImageStreamTag = builderImageStreamTag;
    }

    public String getApiBaseUrl() {
        return apiBaseUrl;
    }

    public void setApiBaseUrl(String apiBaseUrl) {
        this.apiBaseUrl = apiBaseUrl;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getImageStreamNamespace() {
        return imageStreamNamespace;
    }

    public void setImageStreamNamespace(String imageStreamNamespace) {
        this.imageStreamNamespace = imageStreamNamespace;
    }

    public String getDeploymentMemoryRequestMi() {
        return deploymentMemoryRequestMi;
    }

    public void setDeploymentMemoryRequestMi(String deploymentMemoryRequestMi) {
        this.deploymentMemoryRequestMi = deploymentMemoryRequestMi;
    }

    public String getDeploymentMemoryLimitMi() {
        return deploymentMemoryLimitMi;
    }

    public void setDeploymentMemoryLimitMi(String deploymentMemoryLimitMi) {
        this.deploymentMemoryLimitMi = deploymentMemoryLimitMi;
    }

    public String getMavenOptions() {
        return mavenOptions;
    }

    public void setMavenOptions(String mavenOptions) {
        this.mavenOptions = mavenOptions;
    }

    public String getIntegrationDataPath() {
        return integrationDataPath;
    }

    public void setIntegrationDataPath(String integrationDataPath) {
        this.integrationDataPath = integrationDataPath;
    }

    public int getMaximumRetries() {
        return maximumRetries;
    }

    public void setMaximumRetries(int maximumRetries) {
        this.maximumRetries = maximumRetries;
    }

    public long getPollingInterval() {
        return pollingInterval;
    }

    public void setPollingInterval(long pollingInterval) {
        this.pollingInterval = pollingInterval;
    }
}
