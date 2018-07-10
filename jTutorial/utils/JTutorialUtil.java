package scripts.jTutorial.utils;

import org.tribot.api2007.types.RSObject;

public class JTutorialUtil {	
	
	public static boolean areObjectsEqualPos(RSObject obj1, RSObject obj2) {
		if (obj1 == null || obj2 == null)
			return false;
		
		return obj1.getPosition().equals(obj2.getPosition());
	}
	
	public static RSObject getObjectWithName(RSObject[] objects, String name) {
		try {
			for (RSObject object : objects) 
				if (object.getDefinition().getName().equals(name))
					return object;
		}
		catch (NullPointerException e) {
		}
		return null;
	}
}
