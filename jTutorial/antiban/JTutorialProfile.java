package scripts.jTutorial.antiban;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.tribot.util.Util;

/** Thanks Nate!
 * Allows certain script patterns to persist based on account username.
 * 
 * Allows for easy implementation of other patterns in the future.
 */
public class JTutorialProfile {
	
	// Save/Load
	private String username;
	private File directory = new File(Util.getWorkingDirectory() + "\\jTutorialAntibanProfile");
	private Properties prop = new Properties();
	
	// Patterns
	//private Inventory.DROPPING_PATTERN DROPPING_PATTERN;
	
	public JTutorialProfile(String username) {
		this.username = username;
	}
	
	public void loadProfile() {
		
		loadFromFile();
		
		setPatterns();
		
	}
	
	private void loadFromFile() {
		// Load patterns from file to this object, or create a new pattern file
		try {
			prop.load(new FileInputStream(directory.getAbsolutePath() + "/" + this.username));
			
			//this.DROPPING_PATTERN = Inventory.DROPPING_PATTERN.valueOf(prop.getProperty("dropping"));
		}
		catch (IOException e) {
			generateNewProfile();
		}
		catch (NullPointerException e) {
			updateCurrentProfile();
		}
	}
	
	// if not profile is found, generate one.
	private void generateNewProfile() {
		saveProfile();
	}
	
	private void saveProfile() {
		
		if (!directory.exists())
			directory.mkdirs();
		
		prop.clear();
		
		try {
			prop.store(new FileOutputStream(directory + "/" + this.username), "Unique JTears Antiban Profile");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void updateCurrentProfile() {
		// Add in logic when more patterns are added in
	}
	
	private void setPatterns() {
		// Set patterns
	}

}