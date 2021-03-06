/*
 * Copyright 2004-2014 ICEsoft Technologies Canada Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS
 * IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

package org.icefaces.samples.showcase.example.ace.panelStack;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import java.lang.System;
import java.util.Iterator;
import org.icefaces.ace.util.ComponentUtils;

@Named("treeMonitor")
@SessionScoped
public class CompTreeMonitor implements java.io.Serializable {
    private String node1="panelStackForm:stack1";
    private String node2= "repeatForm";

    public int getTreeSize() {
        return getTreeSize(node1);
    }
    public int getTreeSize2(){
        return getTreeSize(node2);
    }

    private int getTreeSize(String nodeId){
        FacesContext context = FacesContext.getCurrentInstance();
        UIViewRoot root = context.getViewRoot();
        UIComponent element = root.findComponent(nodeId);
        if (null==element) {
            return -1;
        }
        return countChildComponents(element);
    }
    private static int countChildComponents(UIComponent uic) {
        int children = 1;
         if (uic.getChildCount() > 0 || uic.getFacetCount() > 0) {
            Iterator<UIComponent> iter = uic.getFacetsAndChildren();
            while (iter.hasNext()) {
                children += countChildComponents(iter.next());
            }
        }
        return children;
    }
}
