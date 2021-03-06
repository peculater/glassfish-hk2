/*
 * Copyright (c) 2013, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package org.glassfish.hk2.tests.locator.context;

import java.util.List;

import jakarta.inject.Inject;

import org.glassfish.hk2.api.IterableProvider;
import org.glassfish.hk2.api.PerLookup;

/**
 * @author jwells
 *
 */
@PerLookup
public class GetsRootServiceWithProvider {
    @SuppressWarnings("unused")
    @Inject
    private RootService1 r1;
    
    @Inject
    private IterableProvider<RootService2> r2Provider;
    
    @Inject
    private RootContext rootContext;
    
    public List<RootContext.Root> checkProvider() {
        rootContext.clear();
        
        r2Provider.get();
        
        return rootContext.getRoots();
        
    }
    
    public List<RootContext.Root> checkProviderWithIterator() {
        rootContext.clear();
        
        for (RootService2 r2 : r2Provider) {}
        
        return rootContext.getRoots();
        
    }

}
