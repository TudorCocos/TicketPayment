public class App {
	
	public static void main(String[] args)
	{
		Data data = new Data();
		data.read();
		Window gui = new Window();
		gui.setVisible(true);
	}
	public void exit()
	{
		System.exit(0);
	}
}

