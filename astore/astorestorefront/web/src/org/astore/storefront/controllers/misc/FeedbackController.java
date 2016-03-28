package org.astore.storefront.controllers.misc;


import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;

import org.apache.log4j.Logger;
import org.astore.facades.feedback.FeedbackFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Controller for submitting feedback
 */
@Controller
@RequestMapping("/feedback")
public class FeedbackController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(FeedbackController.class);

	@Autowired
	private FeedbackFacade feedbackFacade;

	@ResponseBody
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public boolean postFeedback(@RequestParam("page") final String path, @RequestParam("message") final String message)
	{
		LOG.info("Feedback request catched!");
		return feedbackFacade.submitFeedback(path, message);
	}
}