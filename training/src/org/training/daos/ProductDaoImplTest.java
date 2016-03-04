/**
 *
 */
package org.training.daos;

import static org.junit.Assert.assertEquals;

import de.hybris.platform.catalog.CatalogService;
import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.core.model.media.MediaModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.model.ModelService;

import javax.annotation.Resource;

import org.junit.Test;


/**
 * Integration test for product DAO
 */
public class ProductDaoImplTest extends ServicelayerTransactionalTest
{
	@Resource
	private ProductDAO productDAO;

	@Resource
	private ModelService modelService;

	@Resource
	private CatalogService catalogService;

	@Resource
	private CatalogVersionService catalogVersionService;

	/**
	 * Product code to test
	 */
	private static String CODE = "1234567";

	/**
	 * Catalog version
	 */
	private static String CATALOG_VER = "Staged";

	/**
	 * Catalog id
	 */
	private static String CATALOG_ID = "Default";

	@Test
	public void productDaoImageDescrTest()
	{
		// setting catalog to session
		catalogVersionService.setSessionCatalogVersion(CATALOG_ID, CATALOG_VER);

		// first we save an example product
		final ProductModel product = modelService.create(ProductModel.class);
		product.setCode(CODE);
		product.setCatalogVersion(catalogVersionService.getCatalogVersion(CATALOG_ID, CATALOG_VER));
		// creating media
		final MediaModel media = modelService.create(MediaModel.class);
		media.setCode(CODE);
		media.setCatalogVersion(catalogVersionService.getCatalogVersion(CATALOG_ID, CATALOG_VER));
		media.setDescription("Some description");
		product.setPicture(media);
		modelService.save(product);

		// then we try to get this product via our dao
		assertEquals("Some description", productDAO.getProductImageDescription("1111", "Online"));
	}

	@Test
	public void productDaoTest()
	{
		// setting catalog to session
		catalogVersionService.setSessionCatalogVersion(CATALOG_ID, CATALOG_VER);

		// first we save an example product
		final ProductModel product = modelService.create(ProductModel.class);
		product.setCode(CODE);
		product.setCatalogVersion(catalogVersionService.getCatalogVersion(CATALOG_ID, CATALOG_VER));
		modelService.save(product);

		// then we try to get this product via our dao
		assertEquals(product, productDAO.getProduct(CODE, CATALOG_VER));
	}
}
