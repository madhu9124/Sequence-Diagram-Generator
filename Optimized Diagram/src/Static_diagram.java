

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.lang.invoke.MethodHandleInfo;
import java.util.ArrayList;

public class Static_diagram
{
	public static void main(String args[])throws Exception
	  {
	 String strLine;
	 String val2 = null;
	 String val1;
	 String obj_reference = null;
	 String each_line_text;
	 Boolean flag_for=true;
	 boolean flag_if=true;
	 int class_Set=0;
	 String classval = null;
	 boolean flag=false;
	 String Classname = null;
	 ArrayList<String>  list = new ArrayList<String>();
	 ArrayList<String> classname_list=new ArrayList<String>();
	 ArrayList<String> objref_objectname=new ArrayList<String>();
	 ArrayList<String> method_object=new ArrayList<String>();
	 // Open the file that is the first 
	  // command line parameter
	  FileInputStream fstream = new FileInputStream("C:/Users/madhusudans/Desktop/testtext1.txt");
	   //Get the object of DataInputStream
	  DataInputStream in = new DataInputStream(fstream);
	  BufferedReader br = new BufferedReader(new InputStreamReader(in));
	  BufferedWriter bw = new BufferedWriter(new FileWriter("E:/textwrite3.txt", true));
	  bw.newLine();
	  bw.write("@startuml");
	  bw.close();
	 // }
	  //BufferedWriter out1 = new BufferedWriter(fstream1);
	  //out1.write("@startuml");
	   
    //  String str;

      
	  
//--------------Read File Line By Line------------------------------------------
//--------------------------------------------------------------------------------	      
	  while ((strLine = br.readLine()) != null)
	  {
		  list.add(strLine);
	  }
	  String[] split_value = list.toArray(new String[list.size()]);
	  
	  // getting the class name
	  for(int k=0;k<split_value.length;k++)
	  {
		  
		  
		  // checking for "for loop	"
		  
		  each_line_text=split_value[k];
		   if((each_line_text.indexOf("for")>=0)&&(each_line_text.indexOf("(")>=0)&&(each_line_text.indexOf(" // ")<=0))
		  {
			  	 BufferedWriter bw7 = new BufferedWriter(new FileWriter("E:/textwrite3.txt", true));
				 bw7.newLine();
				 bw7.write("loop");
				 flag_for=false;
				 bw7.close();
		  }
		   // checking for end of for loop
		  if(each_line_text.indexOf("}")>0&&(flag_for==false)&&(each_line_text.indexOf("\t")<=0)&&(each_line_text.indexOf(" // ")<=0))
		  {
			     BufferedWriter bw8 = new BufferedWriter(new FileWriter("E:/textwrite3.txt", true));
				 bw8.newLine();
				 bw8.write("end");
				 flag_for=true;
				 bw8.close();
		  }
		  // checking for if statement
		  if((each_line_text.indexOf("if")>0)&&(each_line_text.indexOf("(")>=0)&&(each_line_text.indexOf(" // ")<=0))
		  {
			  BufferedWriter bw9= new BufferedWriter(new FileWriter("E:/textwrite3.txt", true));
			  bw9.newLine();
			  bw9.write("alt");
			  flag_if=false;
			  bw9.close();
		  }
		  // checking for end of if statement
		  if(each_line_text.indexOf("}")>0&&(flag_if==false)&&(each_line_text.indexOf("\t")<=0)&&(each_line_text.indexOf(" // ")<=0))
		  {
			  BufferedWriter bw10 = new BufferedWriter(new FileWriter("E:/textwrite3.txt", true));
			  bw10.newLine();
			  bw10.write("end");
			  flag_if=true;
			  bw10.close();
		  }
		  // extracting the class name by searching for class keyword
		  if((each_line_text.indexOf("class")>=0)&&(each_line_text.indexOf(";")<0)&&(each_line_text.indexOf("(")<0)&&(each_line_text.indexOf("//")<=0))
		  {
			 
				  String[] class_name=each_line_text.split(" ");
				  for(int v=0;v<class_name.length;v++)
				  {
					  String srch_val=class_name[v];
					  if((srch_val.indexOf("class")>=0)&&(srch_val.indexOf(";")<0)&&(srch_val.indexOf(" // ")<=0))
					  {
						  classval=class_name[v+1];
						  classname_list.add(classval);
						  break;
					  }
				  }
				  
				  
				  class_Set=class_Set+1;
			  }
			//  break;
		  //}
	 // }
	  //getting the object name and reference based on each class
	 
		  if((each_line_text.indexOf("new")>=0)&&(each_line_text.indexOf("=")>=0)&&((each_line_text.indexOf("(")>=0)||(each_line_text.indexOf("[")>=0)))
		  {
			  String[] object_ref_array=each_line_text.split(" ");
			  // searching for new and = keyword, extracting the text after new and =
			  for(int srch_txt=0;srch_txt<object_ref_array.length;srch_txt++)
			  {
				  String val_srch=object_ref_array[srch_txt];
				  if(val_srch.indexOf("=")>=0)
				{
					  obj_reference= val_srch.substring(0,val_srch.indexOf("="));
					  //obj_reference=object_ref_array[srch_txt-1];
				}
				  if(val_srch.indexOf("new")>=0)
				  {
					  String object_val=object_ref_array[srch_txt+1];
					  String concat_val=obj_reference+"aa"+object_val;
					  String[] referenceobjarr= concat_val.split("aa");
						 String objname=referenceobjarr[1];
						 if(objname.indexOf("[")>=0)
						 {

//							  FileWriter fstream1 = new FileWriter("C:/Users/madhusudans/Desktop/textwrite2.txt",true);
//							  BufferedWriter bufferedWriter = new BufferedWriter(fstream1);
							 
							 int ind_objname=objname.indexOf("[");
							 String substr_objname=objname.substring(0,ind_objname);
							 BufferedWriter bw3 = new BufferedWriter(new FileWriter("E:/textwrite3.txt", true));
							 bw3.newLine();
							 bw3.write(classval+"-->"+ substr_objname+":"+"<<create>>");
							bw3.close();
						 }
						 // extracting function after the . operator
						 if(objname.indexOf("(")>=0)
						 {
						
							 BufferedWriter bw1 = new BufferedWriter(new FileWriter("E:/textwrite3.txt", true));
							 int ind_objname=objname.indexOf("(");
							 String substr_objname=objname.substring(0,ind_objname);
							 bw1.newLine();
							 bw1.write(classval+"-->"+ substr_objname+":"+"<<create>>");
							 bw1.close();
						 }
					  objref_objectname.add(concat_val);
					  
				  }
				 
			  }
			 
		  }
		  // printing the methods inside the println function
			  if(each_line_text.indexOf("println")>=0)
			  {
				  String[] index_println_find=each_line_text.split(" ");
				  for(int t=0;t<index_println_find.length;t++)
				  {
					  String method_srch=index_println_find[t];
					  if((method_srch.indexOf("(")>0)&&(method_srch.indexOf("println")<0)&&(method_srch.indexOf(":")<0))
					  {
						  BufferedWriter bw9 = new BufferedWriter(new FileWriter("E:/textwrite3.txt", true));
							 bw9.newLine();
							 bw9.write(classval+"-->"+classval+":"+method_srch);
							// method_object.add(concat_method_object);
							// flag=true;
							 bw9.close();
					  }
				  }
			  }
			// search for . and () operator, to extract the function corresponding to object reference
			  if((each_line_text.indexOf(".")>=0)&&(each_line_text.indexOf("(")>=0)&&(each_line_text.indexOf("<")<0)&&(each_line_text.indexOf("println")<0))
				 
			  {
			// String[] srch_function_objref=each_line_text.split(".");
			 int dot_index=each_line_text.indexOf(".");
			 String str_objref=each_line_text.substring(0, dot_index);
			 String str_function=each_line_text.substring(dot_index+1,each_line_text.length());
			
			 for(int p=0;p<objref_objectname.size();p++)
			 {
				 String concat_objrefname=objref_objectname.get(p);
				 String[] split_ref_objname=concat_objrefname.split("aa");
				 String objref=split_ref_objname[0];
				 String objname=split_ref_objname[1];
				 String trim_str_objref=str_objref.trim();
				 // if the object reference before dot operator matches with the object reference stored in list
				 if(trim_str_objref.equals(objref))
				 {
					 String[] objectnamecapture=concat_objrefname.split("aa");
					 String objectreference=objectnamecapture[0];
					 String objectname2=objectnamecapture[1];
					 int ind_objname=objectname2.indexOf("(");
					 String subs_objectname=objectname2.substring(0, ind_objname);
					 String concat_method_object=objectname2+"aa"+str_function;
					// String concatrefmethod1=str_objref1+"_"+str_function1;
					 String[] splt_methd_objref1=concat_method_object.split("aa");
					 val1=splt_methd_objref1[1];
					// BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Users/madhusudans/Desktop/textwrite2.txt", true));
//					  FileWriter fstream1 = new FileWriter("C:/Users/madhusudans/Desktop/textwrite2.txt",true);
//					  BufferedWriter bufferedWriter = new BufferedWriter(fstream1);
					 // bw.write("@startuml");
					 BufferedWriter bw4 = new BufferedWriter(new FileWriter("E:/textwrite3.txt", true));
					 bw4.newLine();
					 bw4.write(classval+"-->"+subs_objectname+":"+val1);
					 method_object.add(concat_method_object);
					 flag=true;
					 bw4.close();
				 }
				
				 
			 }
			 // if the object reference does not match with the list
			 if(flag==false)
			 {
				 int dot_index1=each_line_text.indexOf(".");
				 String str_objref1=each_line_text.substring(0, dot_index1);
				 String str_function1=each_line_text.substring(dot_index1+1,each_line_text.length());
				 String concatrefmethod1=str_objref1+"aa"+str_function1;
				 String[] splt_methd_objref=concatrefmethod1.split("aa");
				 
				// BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Users/madhusudans/Desktop/textwrite2.txt", true));
//				  FileWriter fstream1 = new FileWriter("C:/Users/madhusudans/Desktop/textwrite2.txt",true);
//				  BufferedWriter bufferedWriter = new BufferedWriter(fstream1);
				//  bw.write("@startuml");
				 BufferedWriter bw5 = new BufferedWriter(new FileWriter("E:/textwrite3.txt", true));
				 bw5.newLine();
				 bw5.write(classval+"-->"+splt_methd_objref[0].trim()+":"+splt_methd_objref[1].trim());
				 
				 method_object.add(concatrefmethod1);
				 bw5.close();
			 }
				 
		}
		// extracting all the functions in the respective class
		  if((each_line_text.indexOf("(")>=0)&&(each_line_text.indexOf("=")<0)&&(each_line_text.indexOf("for")<0)&&(each_line_text.indexOf(".")<0)&&(each_line_text.indexOf("main")<0))
		  {
			  String[] method_splt=each_line_text.split(" ");
			  for(int j=0;j<method_splt.length;j++)
			  {
				  String func=method_splt[j];
				  if(func.indexOf("(")>=0)
				  {
					  val2=func.substring(0, func.indexOf("("));
					  BufferedWriter bw6 = new BufferedWriter(new FileWriter("E:/textwrite3.txt", true));
						 bw6.newLine();
						 bw6.write(classval+"-->"+classval+":"+val2+"()");
						 bw6.close();
					//  break;
				  }
			  }

		  }
			 
	}
		  
		  
	  }  
	  
    }
	 
//}
//}

