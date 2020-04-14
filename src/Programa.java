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
			
			//Clientes.incluir(new Cliente("Jeferson de Moraes", "(19) 99743-5467", "jefmor@gmail.com", "43125-123", 11, "Residencial Castelo Dourado"));
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
