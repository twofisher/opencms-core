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

package org.opencms.ade.publish;

import org.opencms.ade.publish.shared.CmsProjectBean;
import org.opencms.ade.publish.shared.CmsPublishOptions;
import org.opencms.file.CmsObject;
import org.opencms.file.CmsResource;
import org.opencms.main.CmsException;
import org.opencms.util.CmsUUID;

import java.util.List;
import java.util.Map;

/**
 * This interface can be used to implement a new option in the publish dialog's project selector.
 *
 * Instead of reading the resources from a real project, the resource lists will be generated by the classes which implement this interface.
 */
public interface I_CmsVirtualProject {

    /**
     * Gets the project bean.<p>
     *
     * Should return null if the virtual project is not available or applicable for the given parameters.<p>
     *
     * @param cms the CMS context to use
     * @param params the publish parameters
     *
     * @return the project bean
     */
    CmsProjectBean getProjectBean(CmsObject cms, Map<String, String> params);

    /**
     * Gets the project id.<p>
     *
     * @return the project id
     */
    CmsUUID getProjectId();

    /**
     * Returns an object that can be queried for 'related' resources specific to this virtual project.<p>
     *
     * @param cmsObject the current CMS context
     * @param options the publish options
     *
     * @return the related resource provider
     */
    I_CmsPublishRelatedResourceProvider getRelatedResourceProvider(CmsObject cmsObject, CmsPublishOptions options);

    /**
     * Gets the resources of the virtual project.<p>
     *
     * @param cms the CMS context to use
     * @param params the publish parameters
     * @param workflowId the workflow id
     *
     * @return the generated list of resources
     *
     * @throws CmsException if something goes wrong
     */
    List<CmsResource> getResources(CmsObject cms, Map<String, String> params, String workflowId) throws CmsException;

    /**
     * Returns true if in this virtual project, resource groups should be able to be automatically selected by the GUI.<p>
     *
     * @return true if resource groups should be auto-selectable
     */
    boolean isAutoSelectable();
}
