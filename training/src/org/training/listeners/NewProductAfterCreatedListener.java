/**
 *
 */
package org.training.listeners;

import de.hybris.platform.core.PK;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.event.events.AfterItemCreationEvent;
import de.hybris.platform.servicelayer.event.impl.AbstractEventListener;
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
public class NewProductAfterCreatedListener extends AbstractEventListener<AfterItemCreationEvent>
{

	private static final Logger LOGGER = Logger.getLogger(NewProductAfterCreatedListener.class);

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

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.hybris.platform.servicelayer.event.impl.AbstractEventListener#onEvent(de.hybris.platform.servicelayer.event.
	 * events.AbstractEvent)
	 */
	@Override
	protected void onEvent(final AfterItemCreationEvent event)
	{
		LOGGER.info("SAVING SOME NEW ITEM EVENT OCCURED!");
		if (event.getTypeCode().equalsIgnoreCase(ProductModel._TYPECODE))
		{
			LOGGER.info("SAVING PRODUCT EVENT OCCURED!");

			final ProductModel product = modelService.get(PK.parse(event.getSource().toString()));

			// need to intercept to call workflow for approving products by managers
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
	}

}
