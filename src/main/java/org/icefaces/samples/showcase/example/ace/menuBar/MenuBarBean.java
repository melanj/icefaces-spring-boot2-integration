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

package org.icefaces.samples.showcase.example.ace.menuBar;

import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.CustomScoped;
import javax.inject.Named;
import javax.faces.component.UIComponent;
import javax.faces.event.ActionEvent;

@Named(MenuBarBean.BEAN_NAME)
@CustomScoped(value = "#{window}")
public class MenuBarBean implements Serializable 
{

    public static final String BEAN_NAME = "menuBarBean";
	public String getBeanName() { return BEAN_NAME; }
    public final String MENU_BAR_ID = "menuBar";
    private final String PATH_SEPARATOR = " > ";
    private String message;
    private Format formatter;
    
    public MenuBarBean() {
        formatter = new SimpleDateFormat("HH:mm:ss");
        message = "please select any menu item";
    }
    
    public void fireAction(ActionEvent event)
    {
        
        boolean exitCondition = false;
        UIComponent childComponent = event.getComponent();
        UIComponent parentComponent = childComponent.getParent();
        
        String [] results = childComponent.getClientId().split(":");
        String revertedPath = results[results.length-1].toUpperCase() + PATH_SEPARATOR;
        //extract all component id's from current selection to menuBar component and save those results in the revertedPath variable
        //For example if we choose menu item with id="tab" the result will look like: TAB > NEW > FILE
        do
        {
            results = parentComponent.getClientId().split(":");
            
            if(results[results.length-1].toUpperCase().equals(MENU_BAR_ID.toUpperCase()))
            {
                exitCondition = true;
            }
            else
            {
                revertedPath += results[results.length-1].toUpperCase() + PATH_SEPARATOR;
                parentComponent = parentComponent.getParent();
            }
        }
        while(!exitCondition);
        
        //traverse revertedPath backwards and save final result in the message variable
        //TAB > NEW > FILE will become FILE > NEW > TAB
        results = revertedPath.split(PATH_SEPARATOR);
        message = new String();
        for(int index=results.length-1; index>=0; index--)
        {
            if(index>0) message += results[index]+ PATH_SEPARATOR; 
            else message += results[index]; 
        }
        message += " - selected @ "+formatter.format(new Date()) + " (server time)";
    }

    public String getMessage() {return message;}
    public String getMenuBarId() { return MENU_BAR_ID; }
    
    public void setMessage(String message) {this.message = message;}
    
    
    
}