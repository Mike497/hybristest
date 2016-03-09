/**
 *
 */
package org.training.daos;

import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.platform.servicelayer.user.UserService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 *
 */
@Component(value = "productDAO")
public class ProductDaoImpl implements ProductDAO
{

	@Autowired
	private FlexibleSearchService flexibleSearchService;

	@Autowired
	private CatalogVersionService catalogVersionService;

	@Autowired
	private UserService userService;

	/*
	 * (non-Javadoc)
	 *
	 * @see org.training.daos.ProductDAO#getProduct(java.lang.String, java.lang.String)
	 */
	@Override
	public ProductModel getProduct(final String code, final String catalogVersion)
	{
		userService.setCurrentUser(userService.getAdminUser());

		final ProductModel product = new ProductModel();
		product.setCode(code);
		final CatalogVersionModel vm = catalogVersionService.getCatalogVersion("Default", catalogVersion);
		vm.setActive(Boolean.TRUE);
		product.setCatalogVersion(vm);
		return flexibleSearchService.getModelByExample(product);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.training.daos.ProductDAO#getProductImageDescription(java.lang.String, java.lang.String)
	 */
	@Override
	public String getProductImageDescription(final String code, final String catalogVersion)
	{
		userService.setCurrentUser(userService.getAdminUser());

		final String queryStr = "select {m.description} from {Product as p}, {Media as m}, {CatalogVersion as cv} where {p.picture} = {m.pk} "
				+ "and {p.catalog} = {cv.catalog} and {p.code} = ?code and {cv.version} = ?version";
		final Map<String, Object> params = new HashMap<String, Object>();
		params.put("code", code);
		params.put("version", catalogVersion);
		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryStr, params);
		query.setResultClassList(Arrays.asList(String.class));
		final SearchResult<String> res = flexibleSearchService.search(query);
		if (res.getCount() == 0)
		{
			return "";
		}
		return res.getResult().get(0);
	}

}
