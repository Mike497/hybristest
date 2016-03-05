/**
 *
 */
package org.training.services;

import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.core.model.media.MediaModel;
import de.hybris.platform.servicelayer.media.MediaService;

import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 */
public class ProductDefaultImageServiceImpl implements ProductDefaultImageService
{

	@Autowired
	private MediaService mediaService;

	@Autowired
	private CatalogVersionService catalogVersionService;

	/*
	 * (non-Javadoc)
	 *
	 * @see org.training.services.ProductDefaultImageService#getDefaultMedia()
	 */
	@Override
	public MediaModel getDefaultMedia()
	{
		catalogVersionService.setSessionCatalogVersion("Default", "Staged");
		// some media with id 1111 must be present
		return mediaService.getMedia(catalogVersionService.getCatalogVersion("Default", "Staged"), "1111");
	}

}
