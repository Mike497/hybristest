/**
 *
 */
package org.training.cachetest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import de.hybris.platform.core.PK;
import de.hybris.platform.regioncache.CacheController;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;

import javax.annotation.Resource;

import org.junit.Test;


/**
 *
 */
public class CacheTestImplTest extends ServicelayerTransactionalTest
{

	@Resource
	private CacheTest cacheTest;

	@Resource
	private CacheController cacheController;

	@Test
	public void cacheClearItemTest()
	{
		assertFalse(cacheTest.invalidateItem(null));

		// creating PK for product
		final PK key = PK.createCounterPK(1);
		assertTrue(cacheTest.invalidateItem(key));
	}

	@Test
	public void cacheClearRegionTest()
	{
		assertFalse(cacheTest.clearRegion(null));
		assertTrue(cacheTest.clearRegion(cacheController.getRegions().iterator().next()));
	}

	@Test
	public void cacheClearAllRegionsTest()
	{
		assertTrue(cacheTest.clearAllRegions());
	}

}
