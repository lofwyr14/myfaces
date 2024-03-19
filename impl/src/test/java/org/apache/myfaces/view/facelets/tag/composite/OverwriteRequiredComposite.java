/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.myfaces.view.facelets.tag.composite;

import jakarta.faces.component.FacesComponent;
import jakarta.faces.component.NamingContainer;
import jakarta.faces.component.UIInput;
import jakarta.faces.component.UINamingContainer;
import jakarta.faces.context.FacesContext;

import java.io.Serializable;

@FacesComponent("OverwriteRequiredComposite")
public class OverwriteRequiredComposite extends UIInput implements NamingContainer, Serializable {

    public OverwriteRequiredComposite() {
        super();
    }

    @Override
    public String getFamily() {
        return UINamingContainer.COMPONENT_FAMILY;
    }

    @Override
    public void decode(FacesContext context) {
        var submittedValue = getValue();
        if (submittedValue == null) {
            submittedValue = "";
        }

        setSubmittedValue(submittedValue);
        super.decode(context);
    }

    @Override
    public boolean isRequired() {
        return (Boolean) getStateHelper().eval("required", false);
    }

    @Override
    public void setRequired(boolean required)
    {
        getStateHelper().put("required", required );
    }

}
