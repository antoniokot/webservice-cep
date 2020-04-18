import bd.core.*;
import bd.daos.*;
import bd.dbos.*; 
import bd.*;
import WindowCrud.WindowCrud;

import javax.swing.*;

public class Programa 
{
	public static void main(String[] args)
	{
		try
		{
			try 
			{
	            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	        } 
			catch (Exception ex)
			{
	            ex.printStackTrace();
	        }
			new WindowCrud();
		}
		catch(Exception erro)
		{
			System.err.println(erro.getMessage());
		}
	}
}
