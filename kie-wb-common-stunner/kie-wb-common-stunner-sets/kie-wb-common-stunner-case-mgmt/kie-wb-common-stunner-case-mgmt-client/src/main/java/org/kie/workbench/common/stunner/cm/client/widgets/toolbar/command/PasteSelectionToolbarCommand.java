/*
 * Copyright 2017 Red Hat, Inc. and/or its affiliates.
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

package org.kie.workbench.common.stunner.cm.client.widgets.toolbar.command;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import org.kie.workbench.common.stunner.cm.qualifiers.CaseManagementEditor;
import org.kie.workbench.common.stunner.core.client.i18n.ClientTranslationService;
import org.kie.workbench.common.stunner.core.client.session.command.impl.PasteSelectionSessionCommand;

@CaseManagementEditor
@Dependent
public class PasteSelectionToolbarCommand extends org.kie.workbench.common.stunner.client.widgets.toolbar.command.PasteToolbarCommand {

    @Inject
    public PasteSelectionToolbarCommand(@CaseManagementEditor PasteSelectionSessionCommand pasteSelectionSessionCommand, ClientTranslationService translationService) {
        super(pasteSelectionSessionCommand, translationService);
    }
}
