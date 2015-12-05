/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.model.internal.core;

import org.gradle.model.internal.registry.ModelRegistry;

import java.util.List;

public class ExtractedModelAction implements ExtractedModelRule {

    private final ModelActionRole role;
    private final boolean transitive;
    private final ModelAction action;
    private final List<? extends Class<?>> dependencies;

    public ExtractedModelAction(ModelActionRole role, List<? extends Class<?>> dependencies, ModelAction action) {
        this(role, false, dependencies, action);
    }

    public ExtractedModelAction(ModelActionRole role, boolean transitive, List<? extends Class<?>> dependencies, ModelAction action) {
        this.role = role;
        this.transitive = transitive;
        this.action = action;
        this.dependencies = dependencies;
    }

    @Override
    public void apply(ModelRegistry modelRegistry, ModelPath scope) {
        if (transitive) {
            modelRegistry.applyToAllLinksTransitive(scope, role, action, ModelPath.ROOT);
        } else {
            modelRegistry.configure(role, action, scope);
        }
    }

    @Override
    public List<? extends Class<?>> getRuleDependencies() {
        return dependencies;
    }
}
