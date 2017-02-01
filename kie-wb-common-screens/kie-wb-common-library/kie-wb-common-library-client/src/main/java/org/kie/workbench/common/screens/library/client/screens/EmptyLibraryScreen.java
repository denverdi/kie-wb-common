/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.workbench.common.screens.library.client.screens;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.security.shared.api.identity.User;
import org.jboss.errai.ui.client.local.spi.TranslationService;
import org.kie.workbench.common.screens.examples.model.ExampleProject;
import org.kie.workbench.common.screens.library.client.resources.i18n.LibraryConstants;
import org.kie.workbench.common.screens.library.client.util.ExamplesUtils;
import org.kie.workbench.common.screens.library.client.util.LibraryPlaces;
import org.uberfire.client.annotations.WorkbenchPartTitle;
import org.uberfire.client.annotations.WorkbenchPartView;
import org.uberfire.client.annotations.WorkbenchScreen;
import org.uberfire.client.mvp.UberElement;

@WorkbenchScreen(identifier = LibraryPlaces.EMPTY_LIBRARY_SCREEN)
public class EmptyLibraryScreen {

    public interface View extends UberElement<EmptyLibraryScreen> {

        void setup( String username );

        void addProjectToImport( ExampleProject exampleProject );

        void clearImportProjectsContainer();
    }

    private View view;

    private User user;

    private LibraryPlaces libraryPlaces;

    private ExamplesUtils examplesUtils;

    @Inject
    public EmptyLibraryScreen( final View view,
                               final User user,
                               final LibraryPlaces libraryPlaces,
                               final ExamplesUtils examplesUtils ) {
        this.view = view;
        this.user = user;
        this.libraryPlaces = libraryPlaces;
        this.examplesUtils = examplesUtils;
    }

    @PostConstruct
    public void setup() {
        view.init( this );
        view.setup( user.getIdentifier() );
        examplesUtils.getExampleProjects( exampleProjects -> {
            view.clearImportProjectsContainer();
            for ( ExampleProject exampleProject : exampleProjects ) {
                view.addProjectToImport( exampleProject );
            }
        } );
    }

    public void newProject() {
        libraryPlaces.goToNewProject();
    }

    public void importProject( final ExampleProject exampleProject ) {
        examplesUtils.importProject( exampleProject );
    }

    @WorkbenchPartTitle
    public String getTitle() {
        return "Empty Library Screen";
    }

    @WorkbenchPartView
    public UberElement<EmptyLibraryScreen> getView() {
        return view;
    }
}