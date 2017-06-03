import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Abstraction_Step_1 extends Generate_Optimized_Sequence_Diagram
{
	 static String strLine_trace1;
	 String check_first;
	 String check_first1;
	 String strLine_trace2;
	 String val5;
	 String text3;
	 String final_val;
	 String strval2="";
	 String text5;
	 String text9;
	 int u;
	 int p1;
	 String val8;
	 int intialize=0;
	 static ArrayList<String> static_planttext = new ArrayList<String>();
	 static ArrayList<String> Dynamic_planttext = new ArrayList<String>();
	 static ArrayList<List> dataList1 = new ArrayList<List>();
void Remove_Duplicate_methods() throws IOException
{
	FileInputStream fstream_trace1 = new FileInputStream("C:/Users/madhusudans/Desktop/textwrite3_1.txt");
    //Get the object of DataInputStream
    DataInputStream in_trace1 = new DataInputStream(fstream_trace1);
    BufferedReader br_trace1 = new BufferedReader(new InputStreamReader(in_trace1));
    
	 while ((strLine_trace1 = br_trace1.readLine()) != null)
     {
         static_planttext.add(strLine_trace1);
     }	
	 br_trace1.close();
	 FileInputStream fstream_trace2= new FileInputStream("C:/Users/madhusudans/Desktop/textwrite1.txt");
	    //Get the object of DataInputStream
	    DataInputStream in_trace2 = new DataInputStream(fstream_trace2);
	    BufferedReader br_trace2 = new BufferedReader(new InputStreamReader(in_trace2));
	    
		 while ((strLine_trace2 = br_trace2.readLine()) != null)
	     {
	         Dynamic_planttext.add(strLine_trace2);
	     }	
	 // extracting the content of the main class from the static planttext 
	 for(int p=0;p<static_planttext.size();p++)
	 {
		 String val1=static_planttext.get(p);
		 String[] val13=val1.split(":");
		 String[] val14=val13[0].split("-->");
		 
		 String val15=static_planttext.get(p+1);
		 String[] objval=val15.split(":");
		 String[] objval1=objval[0].split("-->");
		 
//		 if(p==97)
//			 
//		 {
//			 String dynamicval2=final_planttext.get(u-1);
//			 String planttext2=dynamicval2+"_"+"ok";
//			 final_planttext.add(u, planttext2);
//		 }
		 // if the planttext contains startuml, loop, end it has to skip
		 if((objval1[0].indexOf(val14[0])<0))
		 {
			 if(objval1[0].indexOf("@startuml")>=0||(objval1[0].indexOf("loop")>=0)||(objval1[0].indexOf("end")>=0||val14[0].indexOf("@startuml")>=0||(val14[0].indexOf("loop")>=0)||(val14[0].indexOf("end")>=0)))
			 {
				 
			 }
				else
				{
					
					break;
				}
		 }

		 
		 // if the static planttext content from the main class matches with the dynamic planttext, then exttact the dynamic content
		 // this if statement for the planntext without methods, only create object
		 if((val1.indexOf(":")>=0)&&(val1.indexOf("<<")>=0))
		 {
			
			 String[] val2=val1.split(":");
			 String val5=val2[0];
			 for(u=intialize;u<final_planttext.size();u++)
			 {
				 String dynamicval1=final_planttext.get(u);
				 final_val=final_planttext.get(final_planttext.size()-1);
				 
				 if((dynamicval1.equals(val5))&&(dynamicval1.indexOf("ok")<0))
				 {
					 String plantxt=final_planttext.get(u);
					 String plantxt1=plantxt+"_"+"ok";
					 final_planttext.add(u, plantxt1);
					 final_planttext.remove(u+1);
					 intialize=u;
					 u=p1;
			          break;
				 }
//				 if(p==static_planttext.size()-1)
//					 
//				 {
//					 String dynamicval2=final_planttext.get(u-1);
//					 String planttext2=dynamicval2+"_"+"ok";
//					 final_planttext.add(u, planttext2);
//				 }
			 }
			 
		 }
		
			// }
		// }
		 // extracting plantext from the dynamic , if it contains methods
		 if((val1.indexOf(":")>=0)&&(val1.indexOf("(")>=0))
		{
			String[] objectname=val1.split(":");
			String methodname=objectname[1];
			String method1=methodname.substring(0,methodname.indexOf("("));
			String[] objectname1=objectname[0].split("-->");
			String object_ref1=objectname1[0];
			for(int u=intialize;u<final_planttext.size();u++)
		 {
				 String dynamicval=final_planttext.get(u);
				 if(dynamicval.indexOf(":")>=0)
				 {
				 String[] dynam2=dynamicval.split(":");
				 String val9=dynam2[1];
				 String val6=val9.substring(0, val9.indexOf("("));
				 String val3=dynam2[0];
				 String[] val10=val3.split("-->");
				 
				 if((val10[0].equals(object_ref1))&&(method1.equals(val6))&&(val9.indexOf("ok")<0))
				 {
					 String plantxt=final_planttext.get(u);
					 String plantxt1=plantxt+"_"+"ok";
					 final_planttext.add(u, plantxt1);
					 final_planttext.remove(u+1);
					 intialize=u;
			        // break;
				 }
				 }
			// }
			
		}
			
			 }
		// }
	 
	
		 }
	 String final_val1=final_val+"_"+"ok";
	 final_planttext.add(final_planttext.size()-1, final_val1);
	 final_planttext.remove(final_planttext.size()-1);
	 // contents from each final_Arraylist , is seperated into each seperate arraylist based on ok keyword
	// int tempList2=0;
	 int p1=0;
	 for(int g=0;g<final_planttext.size();g++)
	 {
		 String strval=final_planttext.get(g);
		 for(int j=g+1;j<final_planttext.size();j++)
		 {
			 String strval1=final_planttext.get(j);
			 strval2=strval2+","+strval1;
			 if(strval1.indexOf("ok")>=0)
			 {
				 
				 ArrayList<String> tempList1 = new ArrayList<String>();
				 
	              //  if(flag_add==true)
	                //{
	                    dataList.add(tempList1);
	                    String strval3=strval+""+strval2;
	                    dataList.get(p1).add(strval3);
	                    p1=p1+1;
	                    g=j;
	                    strval2="";
	     //               break;
	                  //  tempList1=tempList1+1;
	                   // flag_add=false;
	                //}
				 }
			 }
		 }
	 // removing the duplicate content from each datalist
	 int p2=0;
	 int array_list=0;
	 int t5=0;
	 int getval=0;
	 int t6=0;
	 int t7=0;
	 int p3=0;
	 for(int t=0;t<dataList.size();t++)
	 {
		 t5=0;
		 if(p2>dataList.size()-1)
		 {
			 break;
		 }
		 
		 String checkval=dataList.get(p2).get(t);
		 String[] commasplt=checkval.split(",");
		 for(int t3=0;t3<commasplt.length;t3++)
		 {
			 String val6=commasplt[t3];
			 dataList.get(p2).add(t5,val6);
			 t5=t5+1;
		 }
		 p2=p2+1;
		 t=-1;
	 }

	 for(int t1=0;t1<=dataList.get(array_list).size();t1++)
		 {
		
			 
			
			 String checkval1=dataList.get(array_list).get(t1);
			 if(checkval1.indexOf("_")>=0)
			 {
				 String[] check_split=checkval1.split("_");
				 checkval1=check_split[0];
			 }
			 for(int t9=t1+1;t9<dataList.get(array_list).size();t9++)
			 {
				 
				 if(t9>=dataList.get(array_list).size())
				 {
					 getval=getval+1;
					 break;
				 }
				 String checkval2=dataList.get(array_list).get(t9);
				 
				 if(checkval2.indexOf("_")>=0)
				 {
					 String[] check_split1=checkval2.split("_");
					 checkval2=check_split1[0]; 
				 }
				 
				 if(checkval1.equals(checkval2))
				 {
					 dataList.get(array_list).remove(t9);
					 t9--;
					// t1=t1-1;
					 
				 }
				
				
				 //}
				
			 }
			 if(t1==dataList.get(array_list).size()-1)
			 {
				 array_list=array_list+1;
				 t1=-1;
				// break;
			 }
			 
			// t6=t6+1;
			 if(array_list>dataList.size()-1)
			 {
				 break;
			 }
		 }
	 Abstraction_Step_2 absstep2=new Abstraction_Step_2();
	 absstep2.remove_dead_method();
	 
		 System.out.print("hello"); 	
		 String val1=dummy_planntext.get(0);
		 }

	 }
	 
	