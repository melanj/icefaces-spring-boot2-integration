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

package org.icefaces.samples.showcase.example.ace.checkboxButton;

import java.io.Serializable;

import javax.faces.bean.CustomScoped;
import javax.inject.Named;

@Named(CheckboxButtonBean.BEAN_NAME)
@CustomScoped(value = "#{window}")
public class CheckboxButtonBean implements Serializable {

    public static final String BEAN_NAME = "checkboxButton";
	public String getBeanName() { return BEAN_NAME; }
    private boolean selected = true;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
    public String getBoxValueDescription() {
        if(selected)
            return "selected";
        else
            return "unselected";
    }
}
