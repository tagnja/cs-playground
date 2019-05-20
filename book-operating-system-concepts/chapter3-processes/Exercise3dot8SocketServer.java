import java.net.*;
import java.io.*;

public class Exercise3dot8SocketServer
{
    public static void main(String[] args)
	{
		try
		{
			ServerSocket sock = new ServerSocket(6013);
			
			// listen for connection
			while(true)
			{
				Socket client = sock.accept();
				System.out.println("server socket accept...");
				
				/*
				PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
				pout.println("hello \nworld!");
				pout.close();
				*/
				// multiple line write using BufferedWriter
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
				bw.write("hello\r\n");
				bw.write(new java.util.Date().toString());
				bw.close();
				
				// close the socket and resume listening for connection.
				client.close();
			}
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
	}
}