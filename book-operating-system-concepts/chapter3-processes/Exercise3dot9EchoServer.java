import java.io.*;
import java.net.*;

public class Exercise3dot9EchoServer
{
	public static void main(String[] args)
	{
		try
		{
			ServerSocket sock = new ServerSocket(6013);
				
			while (true)
			{
				Socket client = sock.accept();
				System.out.println("server accept...");
				OutputStream out = client.getOutputStream();
				InputStream in = client.getInputStream();
				byte[] buf = new byte[1024];
				while (in.read(buf) != -1)
				{
					out.write(buf);
				}
				out.close();
				in.close();
				client.close();
			}
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
	}
}