/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Mar 14, 2016 9:18:05 AM                     ---
 * ----------------------------------------------------------------
 */
package org.training.jalo;

import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.JaloInvalidParameterException;
import de.hybris.platform.jalo.JaloSystemException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.c2l.C2LManager;
import de.hybris.platform.jalo.c2l.Language;
import de.hybris.platform.jalo.extension.Extension;
import de.hybris.platform.jalo.product.Product;
import de.hybris.platform.jalo.security.Principal;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.JaloGenericCreationException;
import de.hybris.platform.jalo.user.Customer;
import de.hybris.platform.jalo.user.User;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.training.constants.TrainingConstants;
import org.training.jalo.ImageMedia;
import org.training.jalo.ProductBundle;
import org.training.jalo.Supplier;

/**
 * Generated class for type <code>TrainingManager</code>.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedTrainingManager extends Extension
{
	protected static final Map<String, Map<String, AttributeMode>> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, Map<String, AttributeMode>> ttmp = new HashMap();
		Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put("additionalDescription", AttributeMode.INITIAL);
		tmp.put("metaInfo", AttributeMode.INITIAL);
		tmp.put("productBundle", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.product.Product", Collections.unmodifiableMap(tmp));
		tmp = new HashMap<String, AttributeMode>();
		tmp.put("email", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.user.Customer", Collections.unmodifiableMap(tmp));
		tmp = new HashMap<String, AttributeMode>();
		tmp.put("dateOfBirth", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.user.User", Collections.unmodifiableMap(tmp));
		DEFAULT_INITIAL_ATTRIBUTES = ttmp;
	}
	@Override
	public Map<String, AttributeMode> getDefaultAttributeModes(final Class<? extends Item> itemClass)
	{
		Map<String, AttributeMode> ret = new HashMap<>();
		final Map<String, AttributeMode> attr = DEFAULT_INITIAL_ATTRIBUTES.get(itemClass.getName());
		if (attr != null)
		{
			ret.putAll(attr);
		}
		return ret;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.additionalDescription</code> attribute.
	 * @return the additionalDescription - Additional description for the product
	 */
	public String getAdditionalDescription(final SessionContext ctx, final Product item)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedProduct.getAdditionalDescription requires a session language", 0 );
		}
		return (String)item.getLocalizedProperty( ctx, TrainingConstants.Attributes.Product.ADDITIONALDESCRIPTION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.additionalDescription</code> attribute.
	 * @return the additionalDescription - Additional description for the product
	 */
	public String getAdditionalDescription(final Product item)
	{
		return getAdditionalDescription( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.additionalDescription</code> attribute. 
	 * @return the localized additionalDescription - Additional description for the product
	 */
	public Map<Language,String> getAllAdditionalDescription(final SessionContext ctx, final Product item)
	{
		return (Map<Language,String>)item.getAllLocalizedProperties(ctx,TrainingConstants.Attributes.Product.ADDITIONALDESCRIPTION,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.additionalDescription</code> attribute. 
	 * @return the localized additionalDescription - Additional description for the product
	 */
	public Map<Language,String> getAllAdditionalDescription(final Product item)
	{
		return getAllAdditionalDescription( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.additionalDescription</code> attribute. 
	 * @param value the additionalDescription - Additional description for the product
	 */
	public void setAdditionalDescription(final SessionContext ctx, final Product item, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedProduct.setAdditionalDescription requires a session language", 0 );
		}
		item.setLocalizedProperty(ctx, TrainingConstants.Attributes.Product.ADDITIONALDESCRIPTION,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.additionalDescription</code> attribute. 
	 * @param value the additionalDescription - Additional description for the product
	 */
	public void setAdditionalDescription(final Product item, final String value)
	{
		setAdditionalDescription( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.additionalDescription</code> attribute. 
	 * @param value the additionalDescription - Additional description for the product
	 */
	public void setAllAdditionalDescription(final SessionContext ctx, final Product item, final Map<Language,String> value)
	{
		item.setAllLocalizedProperties(ctx,TrainingConstants.Attributes.Product.ADDITIONALDESCRIPTION,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.additionalDescription</code> attribute. 
	 * @param value the additionalDescription - Additional description for the product
	 */
	public void setAllAdditionalDescription(final Product item, final Map<Language,String> value)
	{
		setAllAdditionalDescription( getSession().getSessionContext(), item, value );
	}
	
	public ImageMedia createImageMedia(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( TrainingConstants.TC.IMAGEMEDIA );
			return (ImageMedia)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ImageMedia : "+e.getMessage(), 0 );
		}
	}
	
	public ImageMedia createImageMedia(final Map attributeValues)
	{
		return createImageMedia( getSession().getSessionContext(), attributeValues );
	}
	
	public ProductBundle createProductBundle(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( TrainingConstants.TC.PRODUCTBUNDLE );
			return (ProductBundle)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ProductBundle : "+e.getMessage(), 0 );
		}
	}
	
	public ProductBundle createProductBundle(final Map attributeValues)
	{
		return createProductBundle( getSession().getSessionContext(), attributeValues );
	}
	
	public Supplier createSupplier(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( TrainingConstants.TC.SUPPLIER );
			return (Supplier)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating Supplier : "+e.getMessage(), 0 );
		}
	}
	
	public Supplier createSupplier(final Map attributeValues)
	{
		return createSupplier( getSession().getSessionContext(), attributeValues );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>User.dateOfBirth</code> attribute.
	 * @return the dateOfBirth - User birthday
	 */
	public Date getDateOfBirth(final SessionContext ctx, final User item)
	{
		return (Date)item.getProperty( ctx, TrainingConstants.Attributes.User.DATEOFBIRTH);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>User.dateOfBirth</code> attribute.
	 * @return the dateOfBirth - User birthday
	 */
	public Date getDateOfBirth(final User item)
	{
		return getDateOfBirth( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>User.dateOfBirth</code> attribute. 
	 * @param value the dateOfBirth - User birthday
	 */
	public void setDateOfBirth(final SessionContext ctx, final User item, final Date value)
	{
		item.setProperty(ctx, TrainingConstants.Attributes.User.DATEOFBIRTH,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>User.dateOfBirth</code> attribute. 
	 * @param value the dateOfBirth - User birthday
	 */
	public void setDateOfBirth(final User item, final Date value)
	{
		setDateOfBirth( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.email</code> attribute.
	 * @return the email - Customer email
	 */
	public String getEmail(final SessionContext ctx, final Customer item)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedCustomer.getEmail requires a session language", 0 );
		}
		return (String)item.getLocalizedProperty( ctx, TrainingConstants.Attributes.Customer.EMAIL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.email</code> attribute.
	 * @return the email - Customer email
	 */
	public String getEmail(final Customer item)
	{
		return getEmail( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.email</code> attribute. 
	 * @return the localized email - Customer email
	 */
	public Map<Language,String> getAllEmail(final SessionContext ctx, final Customer item)
	{
		return (Map<Language,String>)item.getAllLocalizedProperties(ctx,TrainingConstants.Attributes.Customer.EMAIL,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.email</code> attribute. 
	 * @return the localized email - Customer email
	 */
	public Map<Language,String> getAllEmail(final Customer item)
	{
		return getAllEmail( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.email</code> attribute. 
	 * @param value the email - Customer email
	 */
	public void setEmail(final SessionContext ctx, final Customer item, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedCustomer.setEmail requires a session language", 0 );
		}
		item.setLocalizedProperty(ctx, TrainingConstants.Attributes.Customer.EMAIL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.email</code> attribute. 
	 * @param value the email - Customer email
	 */
	public void setEmail(final Customer item, final String value)
	{
		setEmail( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.email</code> attribute. 
	 * @param value the email - Customer email
	 */
	public void setAllEmail(final SessionContext ctx, final Customer item, final Map<Language,String> value)
	{
		item.setAllLocalizedProperties(ctx,TrainingConstants.Attributes.Customer.EMAIL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.email</code> attribute. 
	 * @param value the email - Customer email
	 */
	public void setAllEmail(final Customer item, final Map<Language,String> value)
	{
		setAllEmail( getSession().getSessionContext(), item, value );
	}
	
	@Override
	public String getName()
	{
		return TrainingConstants.EXTENSIONNAME;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.metaInfo</code> attribute.
	 * @return the metaInfo - Product's meta info
	 */
	public String getMetaInfo(final SessionContext ctx, final Product item)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedProduct.getMetaInfo requires a session language", 0 );
		}
		return (String)item.getLocalizedProperty( ctx, TrainingConstants.Attributes.Product.METAINFO);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.metaInfo</code> attribute.
	 * @return the metaInfo - Product's meta info
	 */
	public String getMetaInfo(final Product item)
	{
		return getMetaInfo( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.metaInfo</code> attribute. 
	 * @return the localized metaInfo - Product's meta info
	 */
	public Map<Language,String> getAllMetaInfo(final SessionContext ctx, final Product item)
	{
		return (Map<Language,String>)item.getAllLocalizedProperties(ctx,TrainingConstants.Attributes.Product.METAINFO,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.metaInfo</code> attribute. 
	 * @return the localized metaInfo - Product's meta info
	 */
	public Map<Language,String> getAllMetaInfo(final Product item)
	{
		return getAllMetaInfo( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.metaInfo</code> attribute. 
	 * @param value the metaInfo - Product's meta info
	 */
	public void setMetaInfo(final SessionContext ctx, final Product item, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedProduct.setMetaInfo requires a session language", 0 );
		}
		item.setLocalizedProperty(ctx, TrainingConstants.Attributes.Product.METAINFO,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.metaInfo</code> attribute. 
	 * @param value the metaInfo - Product's meta info
	 */
	public void setMetaInfo(final Product item, final String value)
	{
		setMetaInfo( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.metaInfo</code> attribute. 
	 * @param value the metaInfo - Product's meta info
	 */
	public void setAllMetaInfo(final SessionContext ctx, final Product item, final Map<Language,String> value)
	{
		item.setAllLocalizedProperties(ctx,TrainingConstants.Attributes.Product.METAINFO,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.metaInfo</code> attribute. 
	 * @param value the metaInfo - Product's meta info
	 */
	public void setAllMetaInfo(final Product item, final Map<Language,String> value)
	{
		setAllMetaInfo( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.productBundle</code> attribute.
	 * @return the productBundle
	 */
	public ProductBundle getProductBundle(final SessionContext ctx, final Product item)
	{
		return (ProductBundle)item.getProperty( ctx, TrainingConstants.Attributes.Product.PRODUCTBUNDLE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.productBundle</code> attribute.
	 * @return the productBundle
	 */
	public ProductBundle getProductBundle(final Product item)
	{
		return getProductBundle( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.productBundle</code> attribute. 
	 * @param value the productBundle
	 */
	public void setProductBundle(final SessionContext ctx, final Product item, final ProductBundle value)
	{
		item.setProperty(ctx, TrainingConstants.Attributes.Product.PRODUCTBUNDLE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.productBundle</code> attribute. 
	 * @param value the productBundle
	 */
	public void setProductBundle(final Product item, final ProductBundle value)
	{
		setProductBundle( getSession().getSessionContext(), item, value );
	}
	
}
