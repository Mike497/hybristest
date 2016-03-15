/**
 *
 */
package org.training.transaction;

import static org.junit.Assert.assertEquals;

import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;


/**
 *
 */
public class ProductBulkManufacturerSetupServiceTest extends ServicelayerTransactionalTest
{

	@Resource
	private ProductBulkManufacturerSetupService defaultProductBulkManufacturerService;

	@Resource
	private ModelService modelService;

	@Resource
	private CatalogVersionService catalogVersionService;

	@Resource
	private UserService userService;

	private static final String MANUF_NAME = "Test manufacturer";

	/**
	 * Catalog version
	 */
	private static String CATALOG_VER = "Staged";

	/**
	 * Catalog id
	 */
	private static String CATALOG_ID = "Default";

	@Test
	public void updateProductsManufacturerTest()
	{
		// setting catalog to session
		catalogVersionService.setSessionCatalogVersion(CATALOG_ID, CATALOG_VER);
		// setting current user
		userService.setCurrentUser(userService.getAdminUser());

		final List<ProductModel> products = new ArrayList<ProductModel>();

		ProductModel prod1 = modelService.create(ProductModel.class);
		prod1.setCode("11111");
		prod1.setName("Some product name 1");
		prod1.setCatalogVersion(catalogVersionService.getCatalogVersion(CATALOG_ID, CATALOG_VER));
		modelService.save(prod1);
		products.add(prod1);
		ProductModel prod2 = modelService.create(ProductModel.class);
		prod2 = modelService.create(ProductModel.class);
		prod2.setCode("22222");
		prod2.setName("Some product name 2");
		prod2.setCatalogVersion(catalogVersionService.getCatalogVersion(CATALOG_ID, CATALOG_VER));
		modelService.save(prod2);
		products.add(prod2);
		ProductModel prod3 = modelService.create(ProductModel.class);
		prod3 = modelService.create(ProductModel.class);
		prod3.setCode("33333");
		prod3.setName("Some product name 3");
		prod3.setCatalogVersion(catalogVersionService.getCatalogVersion(CATALOG_ID, CATALOG_VER));
		products.add(prod3);
		modelService.save(prod3);

		// running method
		defaultProductBulkManufacturerService.updateManufacturerNameForProducts(MANUF_NAME, products);

		// testing if manufacturer updated successfully
		prod1 = defaultProductBulkManufacturerService.getProductForCode("11111");
		assertEquals(MANUF_NAME, prod1.getManufacturerName());
		prod2 = defaultProductBulkManufacturerService.getProductForCode("22222");
		assertEquals(MANUF_NAME, prod2.getManufacturerName());
		prod3 = defaultProductBulkManufacturerService.getProductForCode("33333");
		assertEquals(MANUF_NAME, prod3.getManufacturerName());
	}

}
