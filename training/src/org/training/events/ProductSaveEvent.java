/**
 *
 */
package org.training.events;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.event.events.AbstractEvent;


/**
 *
 */
public class ProductSaveEvent extends AbstractEvent
{
	private final ProductModel product;

	public ProductSaveEvent(final ProductModel product)
	{
		super();
		this.product = product;
	}

	public ProductModel getProductModel()
	{
		return product;
	}

}
