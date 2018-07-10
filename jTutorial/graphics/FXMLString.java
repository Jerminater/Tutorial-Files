package scripts.jTutorial.graphics;

public class FXMLString {
	
public static String get = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
		"\r\n" + 
		"<?import javafx.scene.control.Button?>\r\n" + 
		"<?import javafx.scene.control.ButtonBar?>\r\n" + 
		"<?import javafx.scene.control.CheckBox?>\r\n" + 
		"<?import javafx.scene.control.ComboBox?>\r\n" + 
		"<?import javafx.scene.control.TextField?>\r\n" + 
		"<?import javafx.scene.layout.AnchorPane?>\r\n" + 
		"<?import javafx.scene.layout.BorderPane?>\r\n" + 
		"<?import javafx.scene.text.Font?>\r\n" + 
		"\r\n" + 
		"<BorderPane maxHeight=\"-Infinity\" maxWidth=\"-Infinity\" minHeight=\"-Infinity\" minWidth=\"-Infinity\" prefHeight=\"400.0\" prefWidth=\"600.0\" styleClass=\"pic\" stylesheets=\"@Styles.css\" xmlns=\"http://javafx.com/javafx/10.0.1\" xmlns:fx=\"http://javafx.com/fxml/1\" fx:controller=\"scripts.jTutorial.graphics.GUIController\">\r\n" + 
		"   <bottom>\r\n" + 
		"      <ButtonBar prefHeight=\"40.0\" prefWidth=\"200.0\" BorderPane.alignment=\"CENTER\">\r\n" + 
		"        <buttons>\r\n" + 
		"            <ComboBox fx:id=\"availableSettingsBox\" prefHeight=\"25.0\" prefWidth=\"150.0\" promptText=\"Settings\" />\r\n" + 
		"          <Button fx:id=\"loadButton\" mnemonicParsing=\"false\" onAction=\"#loadSettings\" text=\"Load\" />\r\n" + 
		"            <TextField fx:id=\"saveSettingsName\" promptText=\"Settings Name\" />\r\n" + 
		"            <Button fx:id=\"saveButton\" mnemonicParsing=\"false\" onAction=\"#saveSettings\" prefHeight=\"33.0\" text=\"Save\" />\r\n" + 
		"            <Button fx:id=\"startScriptButton\" mnemonicParsing=\"false\" onAction=\"#startScript\" prefHeight=\"33.0\" text=\"Start Script\" />\r\n" + 
		"        </buttons>\r\n" + 
		"      </ButtonBar>\r\n" + 
		"   </bottom>\r\n" + 
		"   <center>\r\n" + 
		"      <AnchorPane prefHeight=\"200.0\" prefWidth=\"200.0\" BorderPane.alignment=\"CENTER\">\r\n" + 
		"         <children>\r\n" + 
		"            <CheckBox fx:id=\"getThis\" layoutX=\"14.0\" layoutY=\"221.0\" mnemonicParsing=\"false\" text=\"Get these Items?\" textFill=\"WHITE\">\r\n" + 
		"               <font>\r\n" + 
		"                  <Font size=\"18.0\" />\r\n" + 
		"               </font>\r\n" + 
		"            </CheckBox>\r\n" + 
		"            <CheckBox fx:id=\"shouldBank\" layoutX=\"14.0\" layoutY=\"260.0\" mnemonicParsing=\"false\" text=\"Should Bank\" textFill=\"WHITE\">\r\n" + 
		"               <font>\r\n" + 
		"                  <Font size=\"18.0\" />\r\n" + 
		"               </font>\r\n" + 
		"            </CheckBox>\r\n" + 
		"            <CheckBox fx:id=\"shouldErase\" layoutX=\"14.0\" layoutY=\"296.0\" mnemonicParsing=\"false\" text=\"Should erase all your files?\" textFill=\"WHITE\">\r\n" + 
		"               <font>\r\n" + 
		"                  <Font size=\"18.0\" />\r\n" + 
		"               </font>\r\n" + 
		"            </CheckBox>\r\n" + 
		"            <CheckBox fx:id=\"shouldLoveCats\" layoutX=\"14.0\" layoutY=\"329.0\" mnemonicParsing=\"false\" text=\"Should love on cats?\" textFill=\"WHITE\">\r\n" + 
		"               <font>\r\n" + 
		"                  <Font size=\"18.0\" />\r\n" + 
		"               </font>\r\n" + 
		"            </CheckBox>\r\n" + 
		"            <TextField fx:id=\"itemID\" layoutX=\"348.0\" layoutY=\"284.0\" promptText=\"Item ID's\" />\r\n" + 
		"         </children>\r\n" + 
		"      </AnchorPane>\r\n" + 
		"   </center>\r\n" + 
		"</BorderPane>\r\n" + 
		"";

}
