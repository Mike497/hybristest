/**
 *
 */
package org.training.cachetest;

import de.hybris.platform.core.PK;
import de.hybris.platform.regioncache.region.CacheRegion;


/**
 *
 */
public interface CacheTest
{
	boolean invalidateItem(PK key);

	boolean clearRegion(CacheRegion cacheRegion);

	boolean clearAllRegions();
}
