import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Data {

	protected static int[] seats = new int[Window.ROWS*Window.COLS];
	protected static int[] prices = new int[5];
	protected static Path filePath1 = Paths.get("D:\\FILES\\Java workspace\\TicketPayment\\src\\data.txt");
	protected static Path filePath2 = Paths.get("D:\\FILES\\Java workspace\\TicketPayment\\src\\prices.txt");
	protected static Path filePath3 = Paths.get(System.getProperty("user.home") + "/Desktop"+"/receipt.txt");
    App application = new App();
	public static void main(String [] args) {
    }
	public void read(){
		int nr=0;
		try {
			Scanner scanner = new Scanner(filePath1);
			while (scanner.hasNext()) {
			    if (scanner.hasNextInt()) {
			        seats[nr++]=scanner.nextInt();
			    } else {
			        scanner.next();
			    }
			}
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		nr=0;
		try {
			Scanner scanner = new Scanner(filePath2);
			while (scanner.hasNext()) {
			    if (scanner.hasNextInt()) {
			        prices[nr++]=scanner.nextInt();
			    } else {
			        scanner.next();
			    }
			}
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void write() {
		List<String> lines = new ArrayList<String>();
		StringBuilder line = new StringBuilder();
		
		lines.add("TicketPayment Receipt");
		lines.add("---------------------");
		lines.add("");
		if(Window.sel1.size()>0)
		{
			lines.add("Class I Tickets:");
			for(int i=0;i<Window.sel1.size();i++)
			{
				line.append(Window.sel1.get(i).getText());
				line.append(' ');
			}
			line.append("	"+Window.sel1.size()+"x"+prices[0]+"="
					 +Integer.toString(Window.sel1.size()*prices[0])+" RON");
			lines.add(line.toString());
			lines.add("");
		}
		
		if(Window.sel2.size()>0)
		{
			lines.add("Class II Tickets:");
			line.delete(0, line.length());
			for(int i=0;i<Window.sel2.size();i++)
			{
				line.append(Window.sel2.get(i).getText());
				line.append(' ');
			}
			line.append("	"+Window.sel2.size()+"x"+prices[1]+"="
					 +Integer.toString(Window.sel2.size()*prices[1])+" RON");
			lines.add(line.toString());
			lines.add("");
		}
		
		if(Window.sel3.size()>0)
		{
			lines.add("Class III Tickets:");
			line.delete(0, line.length());
			for(int i=0;i<Window.sel3.size();i++)
			{
				line.append(Window.sel3.get(i).getText());
				line.append(' ');
			}
			line.append("	"+Window.sel3.size()+"x"+prices[2]+"="
					  +Integer.toString(Window.sel3.size()*prices[2])+" RON");
			lines.add(line.toString());
			lines.add("");
		}
		
		if(Window.sel4.size()>0)
		{
			lines.add("Class IV Tickets:");
			line.delete(0, line.length());
			for(int i=0;i<Window.sel4.size();i++)
			{
				line.append(Window.sel4.get(i).getText());
				line.append(' ');
			}
			line.append("	"+Window.sel4.size()+"x"+prices[3]+"="
					 +Integer.toString(Window.sel4.size()*prices[3])+" RON");
			lines.add(line.toString());
			lines.add("");
		}
		
		if(Window.sel5.size()>0)
		{
			lines.add("Class V Tickets:");
			line.delete(0, line.length());
			for(int i=0;i<Window.sel5.size();i++)
			{
				line.append(Window.sel5.get(i).getText());
				line.append(' ');
			}
			line.append("	"+Window.sel5.size()+"x"+prices[4]+"="
					 +Integer.toString(Window.sel5.size()*prices[4])+" RON");
			lines.add(line.toString());
			lines.add("");
		}
		lines.add("---------------------");
		lines.add("Total cost: "+Window.sum+" RON");
		try {
			Files.write(filePath3, lines, Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		application.exit();
	}
}
