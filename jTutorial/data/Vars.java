package scripts.jTutorial.data;

import java.util.Properties;

public class Vars {
	
	// instance stuff
	
		private static Vars vars;
		
		public static Vars get() {
			return vars == null? vars = new Vars() : vars;
		}
		
		public static void reset() {
			vars = new Vars();
		}
		
		
		// Properties for loading/saving GUI settings
		public Properties prop = new Properties();
		
		// Script information
		public String status = "Initializing";
		public long runTime;
		public int howManyCatsILove = 100;
}