/**
 *
 */
package org.training.interceptors;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.event.EventService;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.ValidateInterceptor;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.training.events.ProductSaveEvent;


/**
 *
 */
public class ProductSaveInterceptor implements ValidateInterceptor<ProductModel>
{

	private static final Logger LOGGER = Logger.getLogger(ProductSaveInterceptor.class);

	@Autowired
	private EventService eventService;

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.servicelayer.interceptor.PrepareInterceptor#onPrepare(java.lang.Object,
	 * de.hybris.platform.servicelayer.interceptor.InterceptorContext)
	 */
	@Override
	public void onValidate(final ProductModel product, final InterceptorContext ctx) throws InterceptorException
	{
		LOGGER.info("SAVING NEW PRODUCT INTERCEPTOR!");
		LOGGER.info("FIRING EVENT TO TEST LISTENER...");
		// comment two lines below to make dao tests logs cleaner
		final ProductSaveEvent event = new ProductSaveEvent(product);
		eventService.publishEvent(event);

		LOGGER.info("END OF INTERCEPTOR");
	}

}
