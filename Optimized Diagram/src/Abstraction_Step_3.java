import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.lang.model.SourceVersion;

public class Abstraction_Step_3 extends Abstraction_Step_2
{
	int data_dynamic=0;
	String str10;
	String str_val;
	String strmethod2;
	String getconcat;
	Boolean flag_progress=false;
	Boolean flag_added=false;
	Boolean flag_exit=false;
	String main_func;
	String getmainval;
	static ArrayList<String> collect_linenumber = new ArrayList<String>();
	static ArrayList<String> source_collect = new ArrayList<String>();
	String include_str;
	String[] strvl1;
	String[] firstval;
	String strmethod10;
	
   void add_missing_methods() throws IOException
   {
	   // get the string from the datalist and compare it with the arraylist from the previous step, if both are same, get the linenumber
	   for(int g=0;g<=dataList.get(data_dynamic).size();g++)
	   {
		   strmethod10="";
		   
		
		   if(g==dataList.get(data_dynamic).size())
		   {
			   data_dynamic=data_dynamic+1;
			   g=0;
		   }
		   if(data_dynamic==dataList.size())
			 {
				 break;
			 }
		   str_val=dataList.get(data_dynamic).get(g);
		
		  
		   
		   String[] strmethod=str_val.split(" ");
		   for(int l=0;l<strmethod.length;l++)
		   {
			   String strmethod1=strmethod[l];
			   if(strmethod1.indexOf("(")>=0)
			   {
				   String[] strmethod2=strmethod1.split(":");
				   String strmethod7=strmethod2[1];
				   firstval=strmethod1.split("-->");
				   
				   strmethod10=strmethod7.substring(0, strmethod7.indexOf("("));
				   break;
			   }
		   }
		   
		   // extracting the linenumber of the sourcecode from the dummyplantntext 
		   if((strmethod10!=null)&&(str_val.indexOf(",")<=0)&&(str_val.indexOf(".")<=0))
		   {
		   for(int y=0;y<dummy_planntext.size();y++)
		   {
			   if((flag_exit==true)&&(flag_added==false))
				  {
					 flag_exit=false;
		//			 g=g+1;
					  break;
				  }
			   if((flag_exit==true)&&(flag_added==true))
				  {
					 flag_exit=false;
					 g=g+1;
					 flag_added=false;
					  break;
				  }
			   String dummyval=dummy_planntext.get(y);
			   String[] numextract=dummyval.split("_");
			   if(numextract.length>3)
			   {
				  String val1=numextract[2];
				  if(val1.equals(strmethod10)&&(numextract[0].equals(firstval[0])))
				  {
					  String source_linenumber=numextract[3];
					  collect_linenumber.add(source_linenumber);
					  for(int tp=0;tp<collect_linenumber.size()-1;tp++)
					  {
						  String num=collect_linenumber.get(tp);
//						  if(num.equals(source_linenumber))
//						  {
//							  flag_progress=true;
//							  flag_exit=true;
//							  break;
//						  }
					  }
						//  else
						  //{
					  //}
					  if(flag_progress==false)
					  {
					  String get_object=numextract[0];
					  
					  for(int u=0;u<sourcecode_methods.size();u++)
					  {
						  if(flag_exit==true)
						  {
							 // flag_exit=false;
							  break;
						  }
						  String src_method=sourcecode_methods.get(u);
						  String[] src_method1=src_method.split(" ");
						  for(int r=0;r<src_method1.length;r++)
						  {
							  if(flag_exit==true)
							  {
								 // flag_exit=false;
								  break;
							  }
							  String src1=src_method1[r];
							  if(src1.equals(source_linenumber))
							  {
								  for(int g1=r;g1<src_method1.length;g1++)
								  {
									  if(flag_exit==true)
									  {
										 // flag_exit=false;
										  break;
									  }
									  String val_mthd=src_method1[g1];
									  if(val_mthd.indexOf("(")>=0)
									  {
										  if(src_method1[r+1].indexOf("{")>=0)
										  {
											  break;
										  }
										  else
										  {
											  for(int p=u;p<sourcecode_methods.size();p--)
											  {
												  if(sourcecode_methods.get(p).indexOf("{")>=0)
												  {
													  main_func=sourcecode_methods.get(p-1);
													  String[] strmain=main_func.split(" ");
													  for(int t=0;t<strmain.length;t++)
													  {
														  String checkfunc=strmain[t];
														  if(checkfunc.indexOf("(")>=0)
														  {
															  getmainval=checkfunc.substring(0, checkfunc.indexOf("("));
															  getconcat=getmainval+"()";
															  include_str=get_object+"-->"+get_object+":"+getconcat;
															  
														  }
														  
													  }
													  break;
												  }
											  }
											  if(g==0)
											  {
												  String str_val_func=dataList.get(data_dynamic).get(g);
												  strvl1=str_val_func.split(":");
												  
												  if(strvl1[1]!=getconcat)
												  {
													  
													  dataList.get(data_dynamic).add(g,include_str); 
													  flag_exit=true;
													  flag_added=true;
													  break;
												  }
											  }
											  else
											  {
												  for(int j=g;j<dataList.get(data_dynamic).get(j).length();j--)
												  {
													  if((j==0)&&(flag_exit==false))
													  {
														  dataList.get(data_dynamic).add(g,include_str);
														  flag_exit=true;
													     flag_added=true;
													     break;
													  }
												  String str_val_func=dataList.get(data_dynamic).get(j-1);  
												  if(str_val_func.indexOf(":")>=0)
												  {
												  String[] strvl5=str_val_func.split(":");
												  String str5=strvl5[1];
//												  if((j==dataList.get(data_dynamic).size()-1)&&(flag_exit==true))
//												  {
//													  dataList.get(data_dynamic).add(g,include_str);
//													  flag_exit=true;
//												     flag_added=true;
//												     break;
//												  }
												  if(str5.equals(getconcat))
												  {
													  flag_exit=true;
													  flag_added=true;
													  break;
													  
//													  dataList.get(data_dynamic).add(g,include_str);
//													  flag_exit=true;
//													  flag_added=true;
//													  break;
												  }
//												  else
//												  {
//													  flag_exit=true;
//													  break;
//												  }
											  }
													//  }
											  }
											  }
										  }
									  }
								  }
							  }
						  }
					  }
				  }
			   }
		   }
		   }
		   }
	}
	   System.out.println("hello");
	  
	   merge_object merge=new merge_object();
	   FileInputStream fstream_trace1 = new FileInputStream("C:/Users/madhusudans/Desktop/textwrite3.txt");
       //Get the object of DataInputStream
       DataInputStream in_trace1 = new DataInputStream(fstream_trace1);
       BufferedReader br_trace1 = new BufferedReader(new InputStreamReader(in_trace1));
       
   	 while ((strLine_trace1 = br_trace1.readLine()) != null)
        {
   		source_collect.add(strLine_trace1);
        }
   	 br_trace1.close();
	   //merge.mergeobjects();
	   merge.mergeobjects();
	   System.exit(0);
}
   }
//}
  // }
//}
