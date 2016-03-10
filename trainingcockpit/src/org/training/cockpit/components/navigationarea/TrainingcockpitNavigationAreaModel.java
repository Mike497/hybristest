/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2013 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 * 
 *  
 */
package org.training.cockpit.components.navigationarea;

import de.hybris.platform.cockpit.components.navigationarea.DefaultNavigationAreaModel;
import de.hybris.platform.cockpit.session.impl.AbstractUINavigationArea;

import org.training.cockpit.session.impl.TrainingcockpitNavigationArea;


/**
 * Trainingcockpit navigation area model.
 */
public class TrainingcockpitNavigationAreaModel extends DefaultNavigationAreaModel
{
	public TrainingcockpitNavigationAreaModel()
	{
		super();
	}

	public TrainingcockpitNavigationAreaModel(final AbstractUINavigationArea area)
	{
		super(area);
	}

	@Override
	public TrainingcockpitNavigationArea getNavigationArea()
	{
		return (TrainingcockpitNavigationArea) super.getNavigationArea();
	}
}
