/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Mar 9, 2016 4:49:51 PM                      ---
 * ----------------------------------------------------------------
 */
package org.training.jalo;

import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloInvalidParameterException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.c2l.C2LManager;
import de.hybris.platform.jalo.c2l.Language;
import de.hybris.platform.jalo.media.Media;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.training.constants.TrainingConstants;

/**
 * Generated class for type {@link org.training.jalo.ImageMedia ImageMedia}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedImageMedia extends Media
{
	/** Qualifier of the <code>ImageMedia.topic</code> attribute **/
	public static final String TOPIC = "topic";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(Media.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(TOPIC, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ImageMedia.topic</code> attribute.
	 * @return the topic - Topic for the media
	 */
	public String getTopic(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedImageMedia.getTopic requires a session language", 0 );
		}
		return (String)getLocalizedProperty( ctx, TOPIC);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ImageMedia.topic</code> attribute.
	 * @return the topic - Topic for the media
	 */
	public String getTopic()
	{
		return getTopic( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ImageMedia.topic</code> attribute. 
	 * @return the localized topic - Topic for the media
	 */
	public Map<Language,String> getAllTopic(final SessionContext ctx)
	{
		return (Map<Language,String>)getAllLocalizedProperties(ctx,TOPIC,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ImageMedia.topic</code> attribute. 
	 * @return the localized topic - Topic for the media
	 */
	public Map<Language,String> getAllTopic()
	{
		return getAllTopic( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ImageMedia.topic</code> attribute. 
	 * @param value the topic - Topic for the media
	 */
	public void setTopic(final SessionContext ctx, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedImageMedia.setTopic requires a session language", 0 );
		}
		setLocalizedProperty(ctx, TOPIC,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ImageMedia.topic</code> attribute. 
	 * @param value the topic - Topic for the media
	 */
	public void setTopic(final String value)
	{
		setTopic( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ImageMedia.topic</code> attribute. 
	 * @param value the topic - Topic for the media
	 */
	public void setAllTopic(final SessionContext ctx, final Map<Language,String> value)
	{
		setAllLocalizedProperties(ctx,TOPIC,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ImageMedia.topic</code> attribute. 
	 * @param value the topic - Topic for the media
	 */
	public void setAllTopic(final Map<Language,String> value)
	{
		setAllTopic( getSession().getSessionContext(), value );
	}
	
}
