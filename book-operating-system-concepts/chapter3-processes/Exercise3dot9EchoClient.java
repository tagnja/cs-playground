import java.io.*;
import java.net.*;
import java.nio.*;

public class Exercise3dot9EchoClient
{
	public static void main(String[] args)
	{
		try
		{
			Socket sock = new Socket("127.0.0.1", 6013);
			InputStream in = sock.getInputStream();
			OutputStream out = sock.getOutputStream();
			
			InputStream stdIn = System.in;
			byte[] buf = new byte[1024];
			while (stdIn.read(buf) != -1)
			{
				System.out.print("input: " + new String(buf));
			    out.write(buf);
				in.read(buf);
				System.out.print("echo: " + new String(buf));
				
				//System.out.print("in.read(buf): " + in.read(buf));
			}
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
	}
	
}