/*
 * Copyright 2013 the original author or authors.
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
package org.gradle.api.internal.artifacts.ivyservice.ivyresolve;

import org.gradle.api.artifacts.component.ModuleComponentIdentifier;
import org.gradle.internal.component.model.*;
import org.gradle.api.internal.component.ArtifactType;
import org.gradle.internal.resolve.result.BuildableArtifactResolveResult;
import org.gradle.internal.resolve.result.BuildableArtifactSetResolveResult;
import org.gradle.internal.resolve.result.BuildableModuleComponentMetadataResolveResult;
import org.gradle.internal.resolve.result.BuildableModuleVersionListingResolveResult;

public class BaseModuleComponentRepositoryAccess implements ModuleComponentRepositoryAccess {
    private final ModuleComponentRepositoryAccess delegate;

    public BaseModuleComponentRepositoryAccess(ModuleComponentRepositoryAccess delegate) {
        this.delegate = delegate;
    }

    public ModuleComponentRepositoryAccess getDelegate() {
        return delegate;
    }

    public void listModuleVersions(DependencyMetadata dependency, BuildableModuleVersionListingResolveResult result) {
        delegate.listModuleVersions(dependency, result);
    }

    public void resolveComponentMetaData(ModuleComponentIdentifier moduleComponentIdentifier, ComponentOverrideMetadata requestMetaData, BuildableModuleComponentMetadataResolveResult result) {
        delegate.resolveComponentMetaData(moduleComponentIdentifier, requestMetaData, result);
    }

    public void resolveModuleArtifacts(ComponentResolveMetadata component, ArtifactType artifactType, BuildableArtifactSetResolveResult result) {
        delegate.resolveModuleArtifacts(component, artifactType, result);
    }

    public void resolveModuleArtifacts(ComponentResolveMetadata component, ComponentUsage componentUsage, BuildableArtifactSetResolveResult result) {
        delegate.resolveModuleArtifacts(component, componentUsage, result);
    }

    public void resolveArtifact(ComponentArtifactMetadata artifact, ModuleSource moduleSource, BuildableArtifactResolveResult result) {
        delegate.resolveArtifact(artifact, moduleSource, result);
    }
}
