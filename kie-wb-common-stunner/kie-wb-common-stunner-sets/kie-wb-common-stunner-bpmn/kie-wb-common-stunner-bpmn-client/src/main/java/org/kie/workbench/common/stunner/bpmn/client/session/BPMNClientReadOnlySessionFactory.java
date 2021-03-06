/*
 * Copyright 2018 Red Hat, Inc. and/or its affiliates.
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

package org.kie.workbench.common.stunner.bpmn.client.session;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import org.jboss.errai.ioc.client.api.ManagedInstance;
import org.kie.workbench.common.stunner.bpmn.client.workitem.WorkItemDefinitionClientRegistry;
import org.kie.workbench.common.stunner.bpmn.qualifiers.BPMN;
import org.kie.workbench.common.stunner.core.client.session.ClientReadOnlySession;
import org.kie.workbench.common.stunner.core.client.session.impl.ClientReadOnlySessionImpl;

@Dependent
@BPMN
public class BPMNClientReadOnlySessionFactory extends AbstractBPMNClientSessionFactory<ClientReadOnlySession> {

    private final WorkItemDefinitionClientRegistry workItemDefinitionClientService;
    private final ManagedInstance<ClientReadOnlySessionImpl> readOnlySessions;

    protected BPMNClientReadOnlySessionFactory() {
        this(null, null);
    }

    @Inject
    public BPMNClientReadOnlySessionFactory(final WorkItemDefinitionClientRegistry workItemDefinitionClientService,
                                            final ManagedInstance<ClientReadOnlySessionImpl> readOnlySessions) {
        this.workItemDefinitionClientService = workItemDefinitionClientService;
        this.readOnlySessions = readOnlySessions;
    }

    @Override
    protected WorkItemDefinitionClientRegistry getWorkItemDefinitionService() {
        return workItemDefinitionClientService;
    }

    @Override
    protected ClientReadOnlySession buildSessionInstance() {
        return readOnlySessions.get();
    }

    @Override
    public Class<ClientReadOnlySession> getSessionType() {
        return ClientReadOnlySession.class;
    }
}
