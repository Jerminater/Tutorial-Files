package scripts.jTutorial.graphics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;
import java.util.ResourceBundle;

import org.tribot.api.General;
import org.tribot.util.Util;

import com.allatori.annotations.DoNotRename;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import scripts.jTutorial.graphics.TutorialSettings;

public class GUIController implements Initializable {

	private GUI gui;
	
	private File directory = new File(Util.getWorkingDirectory() + "\\jTutorial\\scripts\\jTutorial\\graphics\\settings"); //change this to what you named your package at the top.
	
	// The @FXML annotation is used to tag nonpublic controller member fields and handler methods for use by FXML markup.
	// These private declarations are defined in scene builder. They are placed here for use in events for getting information
	// and performing actions from your GUI to the script that does your bidding.
	
	//The @DoNotRename annotation is necessary so that the reposity will be able to read the GUI correctly.
	
	// Inits
	@FXML @DoNotRename private Button saveButton;
	@FXML @DoNotRename private Button loadButton;
	@FXML @DoNotRename private Button startScriptButton;
	
	@FXML @DoNotRename private CheckBox shouldLoveCats;
	@FXML @DoNotRename private CheckBox shouldErase;
	@FXML @DoNotRename private CheckBox shouldBank;
	@FXML @DoNotRename private CheckBox getThis;
	
	@FXML @DoNotRename private ComboBox<String> availableSettingsBox;
	
	@FXML @DoNotRename private TextField itemID;
	@FXML @DoNotRename private TextField saveSettingsName;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		//Put anything that you need the GUI to do when it is loaded.
		availableSettingsBox.setItems(FXCollections.observableArrayList(getSaveFiles())); //loads previous saved settings to setting selection box.
	}
	
	// All events go here
	
	//once you click start script button on GUI, call this method.
	@FXML @DoNotRename public void startScript() {
		General.println("Enjoy Jerm's Tutorial!");
		gui.close();
	}
	
	// you will call this method in your main class with the run().
	// It will pass all of your settings to the other classes where they are needed.
	public TutorialSettings TutorialSettings() {
		return new TutorialSettings(getThis.isSelected(), shouldBank.isSelected(),
				shouldErase.isSelected(), shouldLoveCats.isSelected(), itemID.getText());
	}
	
	@FXML @DoNotRename public void saveSettings() {
		if (!directory.exists())
			directory.mkdirs();

		OutputStream output;

		try {
			Properties prop = new Properties();
			
			// Properties to save from GUI. Only change these.
			prop.setProperty("Get This", String.valueOf(getThis.isSelected()));
			prop.setProperty("Should Bank", String.valueOf(shouldBank.isSelected()));
			prop.setProperty("Should Erase", String.valueOf(shouldErase.isSelected()));
			prop.setProperty("Should Love Cats", String.valueOf(shouldLoveCats.isSelected()));
			prop.setProperty("Item ID", String.valueOf(itemID.getText()));
			
			String saveFilePath = directory.getAbsolutePath() + "\\" + saveSettingsName.getText();
			General.println(saveFilePath);
			output = new FileOutputStream(saveFilePath);
			prop.store(output, null);
			General.println("Settings saved successfully.");
			
		} catch (IOException e) {
			General.println("Error attempting to save settings.");
			e.printStackTrace();
		}
	}
	
	@FXML @DoNotRename public void loadSettings() {
		String settingsFileName = availableSettingsBox.getValue();
		String settingsFilePath = directory.getAbsolutePath() + "\\" + settingsFileName;
		General.println(settingsFilePath);
		if (settingsFileName != "No Saved Settings Found") {
			try {
				Properties prop = new Properties();
				prop.load(new FileInputStream(settingsFilePath));
				
				//Properties to load to GUI. Only change these
				getThis.setSelected(Boolean.valueOf(prop.getProperty("Get This")));
				shouldBank.setSelected(Boolean.valueOf(prop.getProperty("Should Bank")));
				shouldErase.setSelected(Boolean.valueOf(prop.getProperty("Should Erase")));
				shouldLoveCats.setSelected(Boolean.valueOf(prop.getProperty("Should love Cats")));
				itemID.setText(prop.getProperty("Item ID"));
				
				
				General.println("Settings loaded sucessfully.");
			} catch (IOException e) {
				General.println("Error loading settings.");
				e.printStackTrace();
			}
		}
		else
			General.println("Could not find any settings.");
	}
	
	
	private String[] getSaveFiles() {
		ArrayList<String> settings = new ArrayList<String>();
		if (!directory.exists())
			return new String[] {"No Saved Settings Found"};
		else {
			for (File f : directory.listFiles()) {
				if (f.isFile()) 
					settings.add(f.getName());
			}
			return settings.toArray(new String[settings.size()]);
		}
	}
	
	public void setGUI(GUI gui) {
        this.gui = gui;
    }

    public GUI getGUI() {
        return this.gui;
    }
}
