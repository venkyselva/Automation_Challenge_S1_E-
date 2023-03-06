import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Comparator;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import io.netty.util.internal.ThreadLocalRandom;

public class Nallas_demo {

	public static String Set1 = "Yet to start";
	public static String Set2 = "Yet to start";
	public static JLabel Set_list1;
	public static JLabel Set_list2;
	public static JLabel Status;
	public static String user_status ="Yet to start";
	public static  String  Verification="";
	public static  int Guess_count=0;
	public static JTextField userEnt;
	public static JTextField userEnt1;
	public static  String  finalstring="";
	public static  String  finalstring1="";
	public static int length;
	public static  int count;  
	public static Integer [] int_array;
	public static JButton number;
	public static JButton reset;
	public static String finalvalue="empty";
	public static JPanel mainPanel, subPanel1, subPanel2;
	public static ArrayList<Integer> value = new ArrayList<Integer>();
	public static int a[][];
	public static void main(String[] args) 
	{
					
     try
     {

    	 final JFrame frame = new JFrame();
 		frame.setTitle("-----Welcome to NALLAS-----");
 		JPanel pane1 = new JPanel();

 		//---to identify system resolution----
 		int[] scrn_resln = system_resolution();
 		 int width = scrn_resln[0];
 		 int height = scrn_resln[1];
 		 frame.setSize(width/2,height/2);
 		//---Element initialization----
 		 JLabel list_label = new JLabel("Enter your input");
 		//JLabel list_label1 = new JLabel("Enter compare text");
          userEnt = new JTextField("", 15);
          //userEnt1 = new JTextField("", 10);
          number = new JButton("Submit");
          reset = new JButton("Reset");
          Set1 ="Yet to Start";
          Set_list1  = new JLabel("<html><br>"+"Longest Numeric sub-string is: **"+Set1+" --**</html>");
          pane1.add(list_label);
          pane1.add(userEnt);
          //pane1.add(list_label1);
          //pane1.add(userEnt1);
          pane1.add(number);
          pane1.add(reset);
          pane1.add(Set_list1);
          frame.add(pane1);
           frame.setVisible(true);
    	 
           number.addActionListener(new ActionListener(){  
 			  public void actionPerformed(ActionEvent e){
 				  reset.setEnabled(true);
 				  userEnt.setEditable(false);
 				  number.setEnabled(false);
 				 finalstring = userEnt.getText();
 				 Verification ="";
 				 System.out.println("print" + finalstring );
 				 if(!finalstring.equals(""))
 				 {
 					 String regex = "[0-9]+";
 			    	 Pattern p = Pattern.compile(regex);
 			    	 Matcher m = p.matcher(finalstring);
 			    	 Boolean status =  m.matches();
 			    	System.out.println("input regex status"+status);
 			    	 if(status==false || finalstring.length()==1)
 			    	 {
 			    		 Verification = "Given input is not valid. Kindly enter with valid data";
 			    		Set_list1.setText("<html><br>"+"Longest numeric sub-string is:-- "+ Verification+" --**</html>");
 			    		finalstring="";
 			    	 }
 			    	 else
 			    	 {
 					stringcomparison(finalstring);
 					Set_list1.setText("<html><br>"+"Longest numeric sub-string is:-- "+ Verification+" --**</html>");
 					finalstring="";
 			    	 }
 				 }
 				 else
 				 {
 					Set2 = "Required field cannot be blank";
 					Set_list1.setText("<html><br>"+"Longest numeric sub-string is: -- "+ Set2+" --**</html>");
 					finalstring="";
 				 }
 				   
 		}});  

           
          reset.addActionListener(new ActionListener(){  
 			  public void actionPerformed(ActionEvent e){
 				  number.setEnabled(true);
 				  userEnt.setEditable(true);
 				  userEnt.setText("");
 				  reset.setEnabled(false);
 				 Set1 = "Reset Completed";
					Set_list1.setText("<html><br>"+"Longest numeric sub-string is :-- "+ Set1+" --**</html>");
					finalstring ="";
 			  }});
          
          
	}
	catch(Exception g)
	{
		System.out.println(g.toString());
	}
	}
 	
     public static void stringcomparison(String value)
     {
    	
    	 System.out.println("final"+value);
    	 ArrayList<Integer> numlist = new ArrayList<Integer>();
    	 for (int i = 0; i < value.length(); i++)
    	 {
    	     int valdigit = value.charAt(i)- '0';
    	     System.out.println("finaldigit"+valdigit);
    	     numlist.add(valdigit);
    	 }
    	for(int digit:numlist)
    	{
    		System.out.println("number"+digit);
    	}
    	longestsubstr(value,numlist);
    	 
     }
	
     public static void longestsubstr(String value,ArrayList<Integer> findinteger)
     {
    	 int size = findinteger.size();
    	 String valcom="";
    	 for(int a=0; a<size; a++)
    	 {
    		 int aryint = findinteger.get(a);
    		 if (aryint % 2 == 0)
    		 {
    			 System.out.println("Number is even");
    			 valcom+="0";
    		 }
    		 
    		 else
    		 {
    			 System.out.println("Number is odd");
    			 valcom+="1";
    		 }
    	 }
    	 
    	 findlongest_number(value,valcom);
    	 
    	 System.out.println("Number comparison"+valcom);
    	 
    	 int leng = valcom.length();
    	 String vall ="";
    	 String valstr ="";
    	 int c=0;
    	 String valc;
    	 for(int b =0;b<leng; b++)
    	 {
    		 System.out.println("Number comparison"+b);
    		 if(c==leng)
    		 {
    			 break;
    		 }
    		 int aryinter = findinteger.get(b);
    		 int vala;
    		 vala = valcom.charAt(b) -'0';
    		 int valb;
    		 String vald = null;
    		 if(c==leng-1 || b==leng-1)
    		 {
    			  vala= valcom.charAt(b) -'0';
    			  valb = valcom.charAt(b-1) -'0';
    		 }
    		 else
    		 {
    			 valb = valcom.charAt(b+1) -'0';
    		 }
    		 if(vala==valb)
    		 {
    			  valc = String.valueOf(vala);
    			  vald = String.valueOf(aryinter);
    			 vall+=valc;
    			 valstr+=vald;
    			 vall+=";";
    			 valstr+=";";
    			 System.out.println("Number comparison: current position and next position is same");
    		     b=leng-1;
    		 }
    		 else
    		 {
    			  valc = String.valueOf(vala);
    			  vald = String.valueOf(aryinter);
    			 vall+=valc;
    			 valstr+=vald;
    		 }
    		 if(b==leng-1)
    		 {
    			 c=c+1;
    			 b=c;
    			 vall+=";";
    			 valstr+=";";
    			 System.out.println("test comp");
    		 }
    		 
    	 }
    	 System.out.println("test result"+vall);
    	 System.out.println("test resulta"+valstr);
    	 if(valstr=="")
    	 {
    		 System.out.println("no matching found");
    	 }
    	 else
    	 {
    		 findinteger(valstr);
    	 }
    	 
     }
     
     public static void findlongest_number(String vals,String findinteger)
     {
    	 System.out.println("Final valuw"+vals);
    	 int b =0;
    	 int c=0;
    	 String vall = "";
    	 for(int a=0;a<findinteger.length();a++)
    	 {
    		 System.out.println("Final a"+a);
    		 if(c!=findinteger.length()-1)
    		 {
    		 if(findinteger.charAt(c)!=findinteger.charAt(c+1)) 
    		 {
    			 char st = findinteger.charAt(c);
    			 char st1 = vals.charAt(c);
    			 vall+=String.valueOf(st1);
    		 }
    		 else
    		 {
    			 char st = findinteger.charAt(c);
    			 char st1 = vals.charAt(c);
    			 vall+=String.valueOf(st1);
    			 vall+=";";
    		 }
    		 c++;
    		 }
    	 }
    	 System.out.println("Final Stre"+vall);
    	
    	 
     }
    
    public static void findinteger(String finalstr)
    {
    	ArrayList<Integer> intindex = new ArrayList<Integer>();
    	int a =0;
    	String[] resultstr = finalstr.split(";");
    	
    	if(resultstr.length==1)
    	{
    		System.out.println("Single matching found");
    		Verification = resultstr[0];
    	}
    	else
    	{
    		
    		int maxLength = 0;
    	      String longestString = null;
    	      for (String s : resultstr) 
    	      {
    	    	  a++;
    	          if (s.length() > maxLength) 
    	          {
    	        	 if(s.length() != maxLength)
    	        	 {
    	        		 longestString = s;
    	        	 }
    	              maxLength = s.length();
    	          }
    	      }
    	      System.out.println("final longest string"+longestString);
    	      
    	      if(longestString.length()==1)
    	      {
    	    	  Verification = "There is no alternating substring in the given input";
    	      }
    	      else
    	      {
    	      Verification =longestString;
    	      }
    	}
    	
    	
    }
	
public static int[] system_resolution()
{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenSize.getWidth();
		
		int height = (int)screenSize.getHeight();
		int[] val = {width,height};
		return val;
		
}
	
	
	

}
