/**
 *
 */
package org.training.listeners;

import de.hybris.platform.servicelayer.event.impl.AbstractEventListener;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.training.events.ProductSaveEvent;
import org.training.services.ProductDefaultImageService;


/**
 *
 */
public class ProductSaveEventListener extends AbstractEventListener<ProductSaveEvent>
{

	private static final Logger LOGGER = Logger.getLogger(ProductSaveEventListener.class);

	@Autowired
	private ProductDefaultImageService defaultImageService;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.hybris.platform.servicelayer.event.impl.AbstractEventListener#onEvent(de.hybris.platform.servicelayer.event.
	 * events.AbstractEvent)
	 */
	@Override
	protected void onEvent(final ProductSaveEvent event)
	{
		LOGGER.info("PRODUCT SAVE EVENT LISTENER FIRED!");
		event.getProductModel().setPicture(defaultImageService.getDefaultMedia());
		LOGGER.info("END OF LISTENER");
	}

}
