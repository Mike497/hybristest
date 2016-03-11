/**
 *
 */
package org.training.interceptors;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.servicelayer.event.EventService;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.workflow.WorkflowProcessingService;
import de.hybris.platform.workflow.WorkflowService;
import de.hybris.platform.workflow.WorkflowTemplateService;
import de.hybris.platform.workflow.model.WorkflowActionModel;
import de.hybris.platform.workflow.model.WorkflowModel;
import de.hybris.platform.workflow.model.WorkflowTemplateModel;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 */
public class ProductSaveInterceptor implements PrepareInterceptor<ProductModel>
{

	private static final Logger LOGGER = Logger.getLogger(ProductSaveInterceptor.class);

	@Autowired
	private EventService eventService;

	@Autowired
	private WorkflowService workflowService;
	@Autowired
	private WorkflowTemplateService workflowTemplateService;
	@Autowired
	private WorkflowProcessingService workflowProcessingService;

	@Autowired
	private UserService userService;

	@Autowired
	private ModelService modelService;

	private ProductService dd;

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.servicelayer.interceptor.PrepareInterceptor#onPrepare(java.lang.Object,
	 * de.hybris.platform.servicelayer.interceptor.InterceptorContext)
	 */
	@Override
	public void onPrepare(final ProductModel product, final InterceptorContext ctx) throws InterceptorException
	{
		LOGGER.info("SAVING NEW PRODUCT INTERCEPTOR!");
		LOGGER.info("FIRING EVENT TO TEST LISTENER...");
		// comment two lines below to make dao tests logs cleaner
		// final ProductSaveEvent event = new ProductSaveEvent(product);
		// eventService.publishEvent(event);

		// need to intercept to call workflow for approving products by managers
		if (ctx.isNew(product))
		{
			final WorkflowTemplateModel workflowTemplate = this.workflowTemplateService
					.getWorkflowTemplateForCode("NewProductCreation");

			final WorkflowModel workflow = this.workflowService.createWorkflow(workflowTemplate, product,
					userService.getAdminUser());
			modelService.save(workflow);
			for (final WorkflowActionModel action : workflow.getActions())
			{
				modelService.save(action);
			}

			this.workflowProcessingService.startWorkflow(workflow);
		}

		LOGGER.info("END OF INTERCEPTOR");
	}

}
