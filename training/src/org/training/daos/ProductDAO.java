/**
 *
 */
package org.training.daos;

import de.hybris.platform.core.model.product.ProductModel;


/**
 * Gets the product by code for certain catalog version
 */
public interface ProductDAO
{
	/**
	 * Gets the product
	 *
	 * @param code
	 * @param catalogVersion
	 * @return product
	 */
	ProductModel getProduct(String code, String catalogVersion);

	String getProductImageDescription(String code, String catalogVersion);
}
