/**
 *
 */
package org.training.cronjobs;

import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.impex.constants.ImpExConstants;
import de.hybris.platform.impex.jalo.ImpExException;
import de.hybris.platform.impex.jalo.ImpExManager;
import de.hybris.platform.impex.jalo.ImpExMedia;
import de.hybris.platform.impex.jalo.cronjob.ImpExExportCronJob;
import de.hybris.platform.impex.jalo.exp.ExportConfiguration;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;


/**
 *
 */
public class OfflineProductExportJob extends AbstractJobPerformable<CronJobModel>
{

	private static final Logger LOG = Logger.getLogger(OfflineProductExportJob.class);

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable#perform(de.hybris.platform.cronjob.model.
	 * CronJobModel)
	 */
	@SuppressWarnings("deprecation")
	@Override
	public PerformResult perform(final CronJobModel cronJobModel)
	{
		final ImpExManager impexManager = ImpExManager.getInstance();

		// creating impex media as wrapper for script
		ImpExMedia impexScript = null;
		try
		{
			impexScript = impexManager.createImpExMedia("offlineProductsExportScript", "UTF-8");
		}
		catch (final UnsupportedEncodingException e)
		{
			LOG.warn("Error initializing export script");
			return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
		}
		final InputStream exportScriptFileStream = ImpExManager.class.getResourceAsStream("/offlineProductsExportScript.impex");
		impexScript.setData(exportScriptFileStream, impexScript.getCode() + "." + ImpExConstants.File.EXTENSION_CSV,
				ImpExConstants.File.MIME_TYPE_CSV);

		// configuring for export script
		ExportConfiguration config = null;
		try
		{
			config = new ExportConfiguration(impexScript, ImpExManager.getExportOnlyMode());
		}
		catch (final ImpExException e)
		{
			LOG.warn("Error initializing export configuration");
			return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
		}
		config.setFieldSeparator(";");
		config.setQuoteCharacter("\"");

		// creating export cronjob
		final ImpExExportCronJob cronJob = impexManager.createDefaultExportCronJob(config);

		// export
		cronJob.getJob().perform(cronJob);

		LOG.info("Finished exporting offline products...");
		return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
	}

}
