/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Mar 30, 2016 2:16:43 PM                     ---
 * ----------------------------------------------------------------
 */
package org.astore.core.jalo.cms;

import de.hybris.platform.cms2.jalo.contents.components.SimpleCMSComponent;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.media.Media;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.astore.core.constants.AstoreCoreConstants;

/**
 * Generated class for type {@link org.astore.core.jalo.cms.FeedbackComponent FeedbackComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedFeedbackComponent extends SimpleCMSComponent
{
	/** Qualifier of the <code>FeedbackComponent.media</code> attribute **/
	public static final String MEDIA = "media";
	/** Qualifier of the <code>FeedbackComponent.confirmationMessage</code> attribute **/
	public static final String CONFIRMATIONMESSAGE = "confirmationMessage";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(SimpleCMSComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(MEDIA, AttributeMode.INITIAL);
		tmp.put(CONFIRMATIONMESSAGE, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>FeedbackComponent.confirmationMessage</code> attribute.
	 * @return the confirmationMessage
	 */
	public String getConfirmationMessage(final SessionContext ctx)
	{
		return (String)getProperty( ctx, CONFIRMATIONMESSAGE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>FeedbackComponent.confirmationMessage</code> attribute.
	 * @return the confirmationMessage
	 */
	public String getConfirmationMessage()
	{
		return getConfirmationMessage( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>FeedbackComponent.confirmationMessage</code> attribute. 
	 * @param value the confirmationMessage
	 */
	public void setConfirmationMessage(final SessionContext ctx, final String value)
	{
		setProperty(ctx, CONFIRMATIONMESSAGE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>FeedbackComponent.confirmationMessage</code> attribute. 
	 * @param value the confirmationMessage
	 */
	public void setConfirmationMessage(final String value)
	{
		setConfirmationMessage( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>FeedbackComponent.media</code> attribute.
	 * @return the media
	 */
	public Media getMedia(final SessionContext ctx)
	{
		return (Media)getProperty( ctx, MEDIA);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>FeedbackComponent.media</code> attribute.
	 * @return the media
	 */
	public Media getMedia()
	{
		return getMedia( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>FeedbackComponent.media</code> attribute. 
	 * @param value the media
	 */
	public void setMedia(final SessionContext ctx, final Media value)
	{
		setProperty(ctx, MEDIA,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>FeedbackComponent.media</code> attribute. 
	 * @param value the media
	 */
	public void setMedia(final Media value)
	{
		setMedia( getSession().getSessionContext(), value );
	}
	
}
