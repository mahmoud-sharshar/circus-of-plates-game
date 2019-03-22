package view;



public enum Clown {
	
	clown1 ("/resources/crown2.png"),
	clown2("/resources/d.png"),
	clown3("/resources/clown2.png");
	
	private String urlClown;
	
	private Clown(String urlClown) {
		this.urlClown = urlClown;
	}

	public String getUrl() {
		return this.urlClown;
	}
}
