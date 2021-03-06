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

package org.kie.workbench.common.stunner.client.widgets.presenters.session;

import org.kie.workbench.common.stunner.core.client.canvas.AbstractCanvasHandler;
import org.kie.workbench.common.stunner.core.client.session.ClientSession;
import org.kie.workbench.common.stunner.core.diagram.Diagram;

/**
 * A session's diagram editor type for Diagrams of type <code>Diagram</code>.
 * <p/>
 * This type reduces the number of bean instances resolved for a SessionEidtor type to the ones
 * specific only for Diagrams of type <code>Diagram</code>.
 * @param <S> The session type.
 * @param <H> The canvas handler type.
 */
public interface SessionDiagramEditor<S extends ClientSession, H extends AbstractCanvasHandler>
        extends SessionEditor<S, H, Diagram> {

}
