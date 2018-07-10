package scripts.jTutorial.graphics;

public class TutorialSettings {
	
	private final boolean getting;
	private final boolean banking;
	private final boolean erasing;
	private final boolean loving;
	private final String ids;

	public TutorialSettings( boolean get, boolean bank, boolean erase, boolean love, String ids) {
		this.getting = get;
		this.banking = bank;
		this.erasing = erase;
		this.loving = love;
		this.ids = "";
	}
	

	public boolean isgetting() {
		return getting;
	}
	
	public boolean isBanking() {
		return banking;
	}

	public boolean isErasing() {
		return erasing;
	}
	
	public boolean isLoving() {
		return loving;
	}

	public int[] getIDs() {
		String[] separatedIDs = ids.split(",",-1);
		int[] idsInt = new int[ids.length()];
		for (int i = 0; i < separatedIDs.length; i++) {
		    idsInt[i] = Integer.parseInt(separatedIDs[i]);
		}
		return idsInt;
	}
}