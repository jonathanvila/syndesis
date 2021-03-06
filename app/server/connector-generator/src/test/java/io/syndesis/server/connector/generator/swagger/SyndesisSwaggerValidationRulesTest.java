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
package io.syndesis.server.connector.generator.swagger;

import java.util.List;

import io.swagger.models.Operation;
import io.swagger.models.Path;
import io.swagger.models.Swagger;
import io.syndesis.common.model.Violation;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SyndesisSwaggerValidationRulesTest {

    @Test
    public void shouldValidateOperationUniqueness() {
        final Swagger swagger = new Swagger()
            .path("/path", new Path().get(new Operation().operationId("o1")).post(new Operation().operationId("o2")))
            .path("/other", new Path().patch(new Operation().operationId("o2")).put(new Operation().operationId("o3")))
            .path("/more", new Path().options(new Operation().operationId("o4")).delete(new Operation().operationId("o3")));
        final SwaggerModelInfo info = new SwaggerModelInfo.Builder().model(swagger).build();
        final SwaggerModelInfo validated = SyndesisSwaggerValidationRules.validateUniqueOperationIds(info);

        final List<Violation> warnings = validated.getWarnings();
        assertThat(warnings).hasSize(1);
        final Violation nonUniqueWarning = warnings.get(0);
        assertThat(nonUniqueWarning.error()).isEqualTo("non-unique-operation-ids");
        assertThat(nonUniqueWarning.property()).isNull();
        assertThat(nonUniqueWarning.message()).isEqualTo("Found operations with non unique operationIds: o2, o3");
    }
}
