package org.astore.facades.feedback;

/**
 * Feedback Facade
 */
public interface FeedbackFacade
{
	boolean submitFeedback(String pageUrl, String message);
}