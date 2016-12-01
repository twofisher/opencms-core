/*
 * This library is part of OpenCms -
 * the Open Source Content Management System
 *
 * Copyright (c) Alkacon Software GmbH & Co. KG (http://www.alkacon.com)
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * For further information about Alkacon Software, please see the
 * company website: http://www.alkacon.com
 *
 * For further information about OpenCms, please see the
 * project website: http://www.opencms.org
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package org.opencms.ui.components.fileselect;

import org.opencms.file.CmsObject;
import org.opencms.file.CmsResource;
import org.opencms.main.CmsException;
import org.opencms.main.CmsLog;
import org.opencms.main.OpenCms;
import org.opencms.site.CmsSite;
import org.opencms.ui.A_CmsUI;
import org.opencms.ui.CmsVaadinUtils;
import org.opencms.util.CmsStringUtil;

import org.apache.commons.logging.Log;

import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.server.UserError;
import com.vaadin.ui.HorizontalLayout;

/**
 * Resource select field. Uses {@link CmsResource} as value type. Will allow existing VFS resources only.<p>
 */
public class CmsResourceSelectField extends A_CmsFileSelectField<CmsResource> {

    /** Logger instance for this class. */
    private static final Log LOG = CmsLog.getLog(CmsResourceSelectField.class);

    /** Serial version id. */
    private static final long serialVersionUID = 1L;

    /** The resource value. */
    private CmsResource m_value;

    /**
     * Creates a new instance.<p>
     */
    public CmsResourceSelectField() {
        m_textField.setReadOnly(true);
        m_textField.addTextChangeListener(new TextChangeListener() {

            private static final long serialVersionUID = 1L;

            public void textChange(TextChangeEvent event) {

                updateValueFromInput(event.getText());
            }
        });
    }

    /**
     * @see com.vaadin.ui.AbstractField#getType()
     */
    @Override
    public Class<? extends CmsResource> getType() {

        return CmsResource.class;
    }

    /**
     * Gets the value.<p>
     *
     * @return the value
     */
    @Override
    public CmsResource getValue() {

        return m_value;
    }

    /**
     * Sets the value.<p>
     *
     * @param value the new value
     */
    @Override
    public void setValue(CmsResource value) {

        setValue(false, value);
    }

    /**
     * @see org.opencms.ui.components.fileselect.A_CmsFileSelectField#initContent()
     */
    @Override
    protected HorizontalLayout initContent() {

        HorizontalLayout result = super.initContent();
        result.addLayoutClickListener(new LayoutClickListener() {

            private static final long serialVersionUID = 1L;

            public void layoutClick(LayoutClickEvent event) {

                if (event.getClickedComponent() == m_textField) {
                    openFileSelector();
                }
            }

        });
        return result;

    }

    /**
     * @see org.opencms.ui.components.fileselect.A_CmsFileSelectField#setResourceValue(org.opencms.file.CmsResource)
     */
    @Override
    protected void setResourceValue(CmsResource resource) {

        setValue(true, resource);
    }

    /**
     * Sets the value.<p>
     *
     * @param fireChange <code>true</code> to fire the value change event
     * @param value the value to set
     */
    protected void setValue(boolean fireChange, CmsResource value) {

        m_value = value;

        m_textField.setComponentError(null);
        String path;
        if (m_value == null) {
            path = "";
        } else if (m_value.getRootPath().startsWith(A_CmsUI.getCmsObject().getRequestContext().getSiteRoot())) {
            path = A_CmsUI.getCmsObject().getSitePath(m_value);
        } else {
            path = m_value.getRootPath();
        }
        fireValueChange(fireChange);
        CmsVaadinUtils.setReadonlyValue(m_textField, path);
    }

    /**
     * Updates the resource value from the input field.<p>
     *
     * @param inputValue the input value
     */
    void updateValueFromInput(String inputValue) {

        m_textField.setComponentError(null);
        m_value = null;
        if (CmsStringUtil.isNotEmptyOrWhitespaceOnly(inputValue)) {
            try {
                CmsObject cms = A_CmsUI.getCmsObject();
                CmsSite site = OpenCms.getSiteManager().getSiteForRootPath(inputValue);

                if (site != null) {
                    CmsObject rootCms = OpenCms.initCmsObject(cms);
                    rootCms.getRequestContext().setSiteRoot("/");
                    m_value = rootCms.readResource(inputValue, m_filter);
                } else {
                    m_value = cms.readResource(inputValue, m_filter);
                }

            } catch (CmsException e) {
                LOG.trace("Could not read resource from input", e);
                m_textField.setComponentError(new UserError("The resource path is not valid"));
            }
        }
    }
}
