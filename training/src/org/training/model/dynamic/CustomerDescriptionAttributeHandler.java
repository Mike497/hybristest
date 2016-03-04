/**
 *
 */
package org.training.model.dynamic;

import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.model.attribute.AbstractDynamicAttributeHandler;

import java.util.Collection;


/**
 *
 */
public class CustomerDescriptionAttributeHandler extends AbstractDynamicAttributeHandler<String, CustomerModel>
{

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.servicelayer.model.attribute.AbstractDynamicAttributeHandler#get(de.hybris.platform.
	 * servicelayer.model.AbstractItemModel)
	 */
	@Override
	public String get(final CustomerModel model)
	{
		final String email = model.getEmail();
		final String name = model.getDisplayName();
		final Collection<OrderModel> orders = model.getOrders();
		if (email != null && orders != null && name != null)
		{
			return name + ":" + email + ". Order quantity is " + orders.size();
		}
		return "NULL:NULL. Order quantity is 0";
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.servicelayer.model.attribute.AbstractDynamicAttributeHandler#set(de.hybris.platform.
	 * servicelayer.model.AbstractItemModel, java.lang.Object)
	 */
	@Override
	public void set(final CustomerModel model, final String value)
	{
		throw new UnsupportedOperationException();
	}

}
