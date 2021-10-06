package vo;

public class ActionForward {
	private String path;
	private boolean isRedirect;
	public void setPath(String path) {
		this.path = path;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	
}
