package scripts.jTutorial;

import java.awt.Color;
import java.awt.Graphics;
import java.net.MalformedURLException;
import java.net.URL;

import org.tribot.api.Timing;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;
import org.tribot.script.interfaces.Ending;
import org.tribot.script.interfaces.MessageListening07;
import org.tribot.script.interfaces.Painting;
import org.tribot.script.interfaces.Starting;

import scripts.framework.Task;
import scripts.framework.TaskSet;
import scripts.jTutorial.graphics.TutorialSettings;
import scripts.jTutorial.graphics.FXMLString;
import scripts.jTutorial.graphics.GUI;
import scripts.jTutorial.data.Vars;
import scripts.jTutorial.graphics.PaintInfoThread;
import scripts.jTutorial.tasks.CatsILove;
import scripts.paint.FluffeesPaint;
import scripts.paint.PaintInfo;

@ScriptManifest(authors = { "Jerminater" }, category = "Tools", 
	name = "JTutorial", version = 1.00, 
	description = "Script that introduces the basics.", gameMode = 1)

public class JTutorial extends Script implements MessageListening07, Starting, Ending, Painting, PaintInfo {
	
	private final FluffeesPaint Paint = new FluffeesPaint(this, FluffeesPaint.PaintLocations.BOTTOM_RIGHT_PLAY_SCREEN,
			new Color[]{new Color(255, 251, 255)}, "Tahoma", new Color[]{new Color(255, 218, 185, 127)},
            new Color[]{new Color(139, 119, 101)}, 1, false, 5, 3, 0);
	private URL stylesheet;
	private GUI gui;
	public TutorialSettings TutorialSettings;
	
	private boolean paintThreadStarted;
	
	public void onStart() {
		// Initializing GUI
		println("Opening GUI");
		try {
			stylesheet = new URL("https://raw.githubusercontent.com/Jerminater/jTears-Beta-/master/jTears/graphics/Styles.css");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		gui = new GUI(FXMLString.get, stylesheet);
		gui.show();
		while (gui.isOpen())
			sleep(500);
		
		TutorialSettings = gui.getController().TutorialSettings();
	}

	@Override
	public void run() {
		// Start paint data tracking thread
		new PaintInfoThread(this).start();
		paintThreadStarted = true;
		// initialize tasks and loop through them
		TaskSet tasks = new TaskSet(new CatsILove(TutorialSettings));
	    while (true) {
	    	sleep(100);
	       Task task = tasks.getValidTask();
	        if (task != null) {
	        	Vars.get().status = task.toString();
	            task.execute();
	        }
	    }	
	}
	
	@Override
	public void onEnd() {}
	
	@Override
    public void onPaint(Graphics g) {
		if (paintThreadStarted)
			Paint.paint(g);
	}
	
	@Override
    public String[] getPaintInfo() {
        return new String[] {"jTutorial v1.0", "Runtime: " + Timing.msToString(Vars.get().runTime),
        		"Status: " + Vars.get().status, "Other Info: " + Vars.get().howManyCatsILove};
    }

	@Override
	public void serverMessageReceived(String message) {}

	@Override
	public void clanMessageReceived(String arg0, String arg1) {}

	@Override
	public void duelRequestReceived(String arg0, String arg1) {}

	@Override
	public void personalMessageReceived(String arg0, String arg1) {}

	@Override
	public void playerMessageReceived(String arg0, String arg1) {}

	@Override
	public void tradeRequestReceived(String arg0) {}
}