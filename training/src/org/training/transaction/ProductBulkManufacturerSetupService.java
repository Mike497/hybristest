/**
 *
 */
package org.training.transaction;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.impl.DefaultProductService;
import de.hybris.platform.tx.Transaction;

import java.util.List;


/**
 *
 */
public class ProductBulkManufacturerSetupService extends DefaultProductService
{

	public void updateManufacturerNameForProducts(final String manufacturerName, final List<ProductModel> products)
	{
		final Transaction tx = Transaction.current();
		tx.begin();
		boolean success = false;
		try
		{
			for (final ProductModel product : products)
			{
				product.setManufacturerName(manufacturerName);
			}
			success = true;
		}
		catch (final Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if (success)
			{
				tx.commit();
			}
			else
			{
				tx.rollback();
			}
		}
	}

}
