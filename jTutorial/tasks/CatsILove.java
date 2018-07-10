package scripts.jTutorial.tasks;


import org.tribot.api.General;

import scripts.framework.Priority;
import scripts.framework.Task;
import scripts.jTutorial.data.Vars;
import scripts.jTutorial.graphics.TutorialSettings;

public class CatsILove implements Task {

	public static TutorialSettings settings;
	
	public CatsILove(TutorialSettings settings) {
		CatsILove.settings = settings;
	}
	
	@Override
	public String toString() {
	        return "Just gunna print some cat things.";
	    }
	
	@Override
	public Priority priority() {
		return Priority.LOW;
	}

	@Override
	public boolean validate() {
		return true;
	}

	@Override
	public void execute() {
	General.sleep(4000);
	if (settings.isLoving())
		General.println("I love cats too. This is how many I want: " + Vars.get().howManyCatsILove);
	else
		General.println("you are horrible human being.");
	General.println("Those ID's from the gui are: " + settings.getIDs());
	Vars.get().howManyCatsILove++;
	}
}
