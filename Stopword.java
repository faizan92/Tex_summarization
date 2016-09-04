/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.io.*;
import java.util.StringTokenizer;

public class Stopword 
{       
   
   String stwd[];
   public Stopword ()
    {
        int cnt=0,sz=0;char bt[]=null;
       try {
         File fp=new File("C:/Users/Compaq/Desktop/FacebookIntegration/TextSummariationApp/src/textsummariationapp/stopwords.txt");	
         FileReader fis=new FileReader(fp);
         sz=(int)fp.length();
         bt=new  char [sz];
         fis.read(bt);
         fis.close();	  		
          }
      catch(IOException ex) {}       
      stwd=getTokens(new String(bt));		        	
   }

public void display () 
 {
            for (int i=0;i<stwd.length;i++)
	System.out.println(stwd[i]);	
   }

 public boolean  isStopword( String word) 
  {
         boolean flag=false;        
          for (int i =0;i<stwd.length;i++)  {
             if(stwd[i].equalsIgnoreCase(word) ) {
	  flag=true;
	   break;	
               }
            }
          return flag;	
   }

  public String[]  getTokens(String sen) 
      {
	 int sz=0,cnt=0;String words[]=null;
	StringTokenizer  stk=new StringTokenizer(sen) ;
	sz=stk.countTokens();
     	 words=new String[sz];	        	
     	 while ( stk.hasMoreTokens()) 
	{
           	words[cnt]=new String(stk.nextToken());	     				
           	cnt++;
       	}		
	return words;	        
    }
  
  public String remove(String sen) //used to remove the unnecessary information for a sentence
  {
     String  dsen="";
     String  words[]=getTokens(sen);	
      for (int j=0;j<words.length; j++) 
          { 	
               if ( ! isStopword(words[j] )  )  	
	dsen = dsen +words[j] +" ";              		
          }		
         return dsen;	         		
    }    

  public static void main(String str[])
   {
	Stopword sp=new Stopword();	
        System.out.println(sp.remove("Welcome to Text Summarization Application"));	
   }
   
}