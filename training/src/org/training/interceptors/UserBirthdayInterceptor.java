/**
 *
 */
package org.training.interceptors;

import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.ValidateInterceptor;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 *
 */
public class UserBirthdayInterceptor implements ValidateInterceptor<UserModel>
{

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.servicelayer.interceptor.PrepareInterceptor#onPrepare(java.lang.Object,
	 * de.hybris.platform.servicelayer.interceptor.InterceptorContext)
	 */
	@Override
	public void onValidate(final UserModel model, final InterceptorContext ctx) throws InterceptorException
	{
		if (getDiffYears(model.getDateOfBirth(), new Date()) < 12)
		{
			throw new InterceptorException("User's date of birth is too small (less than 12 years)!");
		}
	}



	private static int getDiffYears(final Date first, final Date last)
	{
		final Calendar a = getCalendar(first);
		final Calendar b = getCalendar(last);
		int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
		if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH)
				|| (a.get(Calendar.MONTH) == b.get(Calendar.MONTH) && a.get(Calendar.DATE) > b.get(Calendar.DATE)))
		{
			diff--;
		}
		return diff;
	}

	private static Calendar getCalendar(final Date date)
	{
		final Calendar cal = Calendar.getInstance(Locale.ENGLISH);
		cal.setTime(date);
		return cal;
	}



}
