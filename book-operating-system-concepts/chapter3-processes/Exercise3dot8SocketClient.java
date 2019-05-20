import java.net.*; 
import java.io.*;

public class Exercise3dot8SocketClient
{
	public static void main (String[] args)
	{
		try
		{
			Socket sock = new Socket("127.0.0.1", 6013);
			InputStream in = sock.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			
			String line; 
			while ((line = reader.readLine()) != null)
			{
				System.out.println(line);
			}
			sock.close();
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
	}
	
}