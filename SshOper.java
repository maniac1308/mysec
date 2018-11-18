import java.io.FileNotFoundException;
import java.io.IOException;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class SshOper {

	 static String user = "rajeev";
	    static String host = "192.168.0.109";
	    static String password = "jumbo123";
	    static String rfile = "/home/rajeev/Desktop/abc.txt";
	    public static void main(String[] args) throws Exception
	    {
	    	java.util.Properties config = new java.util.Properties(); 
	    	config.put("StrictHostKeyChecking", "no");
	    	
	    	
	        JSch jsch=new JSch();
	        Session session=jsch.getSession(user, host, 22);
	        session.setPassword(password);
	        session.setConfig(config);
	        session.connect();
	      
	        Channel channel = session.openChannel("sftp");
	        channel.connect();
	        ChannelSftp sftpChannel = (ChannelSftp) channel;

	        sftpChannel.get("/home/rajeev/Desktop/abc.txt" , "/Users/rajeevakotkar/Desktop/abc.txt");
	        System.out.println("Heyy");
	        sftpChannel.exit();
	        session.disconnect();
	        
		
		}
	
}
