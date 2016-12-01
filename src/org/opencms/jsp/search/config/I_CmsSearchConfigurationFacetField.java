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

package org.opencms.jsp.search.config;

/** The interface a field facet configuration must implement. */
public interface I_CmsSearchConfigurationFacetField extends I_CmsSearchConfigurationFacet {

    /** Returns the index field that is used for the facet.
     * @return The index field that is used for the facet.
     */
    String getField();

    /** Returns the maximal number of entries that should be shown in the facet.
     * @return The maximal number of entries that should be shown in the facet. (Solr: facet.limit)
     */
    Integer getLimit();

    /** Returns the prefix all entries of a facet must match.
     * @return The prefix all entries of a facet must match. (Solr: facet.prefix)
     */
    String getPrefix();

    /** Returns the sort order that should be used for the facet entries (either "count" or "index").
     * @return The sort order that should be used for the facet entries (either "count" or "index"). (Solr: facet.sort)
     */
    SortOrder getSortOrder();

    /** Returns the (modified) filter query that should be send as filter query when a facet entry is checked.
     * @param facetValue The modifier that should be applied the each filter query appended when checking a facet entry.
     * The modifier can contain the macro "%(value)" that is substituted by the facet entry's value.
     * If the modifier is <code>null</code>, the unmodified filter query is returned.
     * @return The filter query's value.
     */
    String modifyFilterQuery(String facetValue);
}
