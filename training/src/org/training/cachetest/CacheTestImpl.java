/**
 *
 */
package org.training.cachetest;

import de.hybris.platform.core.PK;
import de.hybris.platform.regioncache.CacheController;
import de.hybris.platform.regioncache.region.CacheRegion;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 */
public class CacheTestImpl implements CacheTest
{

	private static final Logger LOGGER = Logger.getLogger(CacheTestImpl.class);

	@Autowired
	CacheController controller;

	/*
	 * (non-Javadoc)
	 *
	 * @see org.training.cachetest.CacheTest#invalidateItem(de.hybris.platform.core.PK)
	 */
	@Override
	public boolean invalidateItem(final PK key)
	{
		if (key == null)
		{
			return false;
		}
		de.hybris.platform.util.Utilities.invalidateCache(key);
		return true;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.training.cachetest.CacheTest#clearRegion(de.hybris.platform.regioncache.region.CacheRegion)
	 */
	@Override
	public boolean clearRegion(final CacheRegion cacheRegion)
	{
		if (cacheRegion == null)
		{
			return false;
		}
		cacheRegion.clearCache();
		return true;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.training.cachetest.CacheTest#clearAllRegions()
	 */
	@Override
	public boolean clearAllRegions()
	{
		for (final CacheRegion cacheRegion : controller.getRegions())
		{
			LOGGER.info("Clearing region: " + cacheRegion.getName());
			cacheRegion.clearCache();
		}
		return true;
	}

}
