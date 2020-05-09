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

package org.icefaces.samples.showcase.example.ace.chart;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.CustomScoped;
import javax.inject.Named;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(ChartExportBean.BEAN_NAME)
@CustomScoped(value = "#{window}")
public class ChartExportBean implements Serializable {
    public static final String BEAN_NAME = "chartExportBean";
	public String getBeanName() { return BEAN_NAME; }

    boolean requestOldIE;

    @PostConstruct
    public void init() {
        requestOldIE = false ;
    }

    public boolean isRequestOldIE() {
        return requestOldIE;
    }
	
	public void exportHandler(org.icefaces.ace.event.ChartImageExportEvent e) {
		try {
			java.io.FileOutputStream out = new java.io.FileOutputStream("asdf1.png");
			out.write(e.getBytes());
			out.close();
		} catch (Exception ex) {
		
		}
	}
}
