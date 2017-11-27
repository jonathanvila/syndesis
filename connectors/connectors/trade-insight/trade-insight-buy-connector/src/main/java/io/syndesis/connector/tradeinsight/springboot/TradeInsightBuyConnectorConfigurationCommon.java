/*
 * Copyright (C) 2016 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.syndesis.connector.tradeinsight.springboot;

import javax.annotation.Generated;

/**
 * Fetches buy recommendation from Trade Insight API server
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.maven.connector.SpringBootAutoConfigurationMojo")
public class TradeInsightBuyConnectorConfigurationCommon {

    /**
     * Host and port of HTTP service to use (override host in swagger schema)
     */
    private String host;
    /**
     * Delay in milli seconds between scheduling (executing)
     */
    private long schedulerPeriod = 5000L;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public long getSchedulerPeriod() {
        return schedulerPeriod;
    }

    public void setSchedulerPeriod(long schedulerPeriod) {
        this.schedulerPeriod = schedulerPeriod;
    }
}