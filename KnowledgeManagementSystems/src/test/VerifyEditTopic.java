package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LaunchBrowser;

public class VerifyEditTopic extends LaunchBrowser {

	@Parameters({ "username", "password", "topicName", "editedTopicName" })
	@Test
	public void EditTopic(String username, String password, String topicName, String editedTopicName)
			throws InterruptedException {
		VerifyNewTopicCreated created = new VerifyNewTopicCreated();
		created.launch();
		created.NaviagteToHomePage(username, password, topicName);
		pages.EditTopic editTopic = new pages.EditTopic(created.verifyTopicCreated());
		editTopic.editTopicName(editedTopicName);

	}
}
