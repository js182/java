package connect4;

import javax.swing.*;

import java.net.*;
import java.util.Scanner;
import java.awt.event.*;
import java.io.*;

public class Client
{
  public static void main( String[] args )
  {
    Socket server = null;

    try
    {
      server = new Socket( "localhost", 3141 );
      Scanner  in  = new Scanner( server.getInputStream() );
      PrintWriter out = new PrintWriter( server.getOutputStream(), true );

      out.println( "2" );
      out.println( "4" );
      System.out.println( in.nextLine() );

      server = new Socket( "localhost", 3141 );
      in  = new Scanner( server.getInputStream() );
      out = new PrintWriter( server.getOutputStream(), true );

      out.println( "3´z" );
      out.println( "4" );
      System.out.println( in.nextLine() );
    }
    catch ( UnknownHostException e ) {
      e.printStackTrace();
    }
    catch ( IOException e ) {
      e.printStackTrace();
    }
    finally {
      if ( server != null )
        try { server.close(); } catch ( IOException e ) { }
    }
  }
}