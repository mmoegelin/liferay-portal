/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ExportImportConfiguration;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.base.ExportImportConfigurationServiceBaseImpl;
import com.liferay.portal.service.permission.GroupPermissionUtil;

/**
 * @author Brian Wing Shun Chan
 * @author Levente Hudák
 */
public class ExportImportConfigurationServiceImpl
	extends ExportImportConfigurationServiceBaseImpl {

	@Override
	public void deleteExportImportConfiguration(
			long exportImportConfigurationId)
		throws PortalException, SystemException {

		ExportImportConfiguration exportImportConfiguration =
			exportImportConfigurationLocalService.getExportImportConfiguration(
				exportImportConfigurationId);

		GroupPermissionUtil.check(
			getPermissionChecker(), exportImportConfiguration.getGroupId(),
			ActionKeys.DELETE);

		exportImportConfigurationLocalService.deleteExportImportConfiguration(
			exportImportConfiguration);
	}

	@Override
	public ExportImportConfiguration moveExportImportConfigurationToTrash(
			long exportImportConfigurationId)
		throws PortalException, SystemException {

		ExportImportConfiguration exportImportConfiguration =
			exportImportConfigurationLocalService.getExportImportConfiguration(
				exportImportConfigurationId);

		GroupPermissionUtil.check(
			getPermissionChecker(), exportImportConfiguration.getGroupId(),
			ActionKeys.DELETE);

		return exportImportConfigurationLocalService.
			moveExportImportConfigurationToTrash(
				getUserId(), exportImportConfigurationId);
	}

	@Override
	public ExportImportConfiguration restoreExportImportConfigurationFromTrash(
			long exportImportConfigurationId)
		throws PortalException, SystemException {

		ExportImportConfiguration exportImportConfiguration =
			exportImportConfigurationLocalService.getExportImportConfiguration(
				exportImportConfigurationId);

		GroupPermissionUtil.check(
			getPermissionChecker(), exportImportConfiguration.getGroupId(),
			ActionKeys.DELETE);

		return exportImportConfigurationLocalService.
			restoreExportImportConfigurationFromTrash(
				getUserId(), exportImportConfigurationId);
	}

}