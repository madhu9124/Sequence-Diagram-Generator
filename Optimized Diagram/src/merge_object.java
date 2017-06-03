import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class merge_object extends Abstraction_Step_3
{
	 
	 // static ArrayList<List> obj_collect = new ArrayList<List>();
	  static ArrayList<String> obj_collect = new ArrayList<String>();
	  static ArrayList<String> planntext_Collect = new ArrayList<String>();
	  static ArrayList<String> concat_collect = new ArrayList<String>();
	  ArrayList<ArrayList<String>> datalist3 = new ArrayList<ArrayList<String>>();
	  int data_dynamic=0;
	  String[] splt_obj;
	 // ArrayList<List> tempList1 = new ArrayList<List>();
	//  ArrayList<String> tempList1 = new ArrayList<String>();
	  
  void mergeobjects() throws IOException 
  {
	  
	  
	  
	  int data_dynamic=0;
	  String[] strval1 = null;
	  String[] str2 = null;
	  for(int r=0;r<source_collect.size();r++)
	  {
		  String get_checkobject=source_collect.get(r);
		  if((get_checkobject.indexOf("=")>=0)&&(get_checkobject.indexOf("new")>=0)&&((get_checkobject.indexOf("(")>=0)||(get_checkobject.indexOf("[")>=0)))
		  {
			  String[] getobj=get_checkobject.split(" ");
			  for(int u=0;u<getobj.length;u++)
			  {
				  String checkobj=getobj[u];
				  if(checkobj.indexOf("new")>=0)
				  {
					  String checkval2=getobj[u+1];
					  if(checkval2.indexOf("[")>=0)
					  {
					  String checkval3=checkval2.substring(0,checkval2.indexOf("["));
					  obj_collect.add(checkval3);
					  }
					  if(checkval2.indexOf("(")>=0)
					  {
						  String checkval3=checkval2.substring(0,checkval2.indexOf("("));
						  obj_collect.add(checkval3);
					  }
					  
					  
				  }
			  }
		  }
		  
				  
	  }
	  int count_list=0;
	  
	//  ArrayList<String> tempList1 = new ArrayList<String>();
	for(int h=0;h<obj_collect.size();h++)
	{
		String compare_obj=obj_collect.get(h);
	    ArrayList<String> tempList1 = new ArrayList<String>();
		 datalist3.add(tempList1);
		// count_list=count_list+1;
	  for(int g=0;g<=dataList.get(data_dynamic).size();g++)
	  {
		  if(g==dataList.get(data_dynamic).size())
		  {
			  data_dynamic=data_dynamic+1;
			  g=0;
		  }
		  if(data_dynamic==dataList.size())
		  {
			  count_list=count_list+1;
			  data_dynamic=0;
			  break;
		  }
		  String get_method=dataList.get(data_dynamic).get(g);
		  if(get_method.indexOf(":")>=0)
		  {
			  String[] splt_meth=get_method.split(":");
			  splt_obj=splt_meth[0].split("-->");
			  if(splt_obj[0].indexOf(compare_obj)>=0)
			  {
				 // dataList3.add(tempList1 );
				 datalist3.get(count_list).add(get_method);
		         //data
				  
			  
			  }
			  
		  }
		  
		  
	  }
  }
	// identify common methods across the objects and merge the objects
	int data_dynamic1=0;
	int data_dynamic2=0;
	String[] strval3 = null;
	String[] strval2=null;
	Boolean check_once=true;
	 for(int g1=0;g1<datalist3.get(data_dynamic1).size();g1++)
	 {
		 if(g1==datalist3.get(data_dynamic1).size()-1)
		 {
			 data_dynamic1=data_dynamic1+1;
			 g1=0;
			 check_once=true;
			// break;
		 }
		 
		 String strval=datalist3.get(data_dynamic1).get(g1);
		 if(strval.indexOf(":")>=0)
		 {
			 strval1=strval.split(":");
			 strval2=strval1[0].split("-->");
			 
		 }
		 if(check_once==true)
		 {
			 data_dynamic2=data_dynamic2+1;
			 check_once=false;
		 }
		 for(int g2=0;g2<=datalist3.get(data_dynamic2).size();g2++)
		 {
			 
			 if(data_dynamic2==datalist3.size())
			 {
				 break;
			 }
			 String str1=datalist3.get(data_dynamic2).get(g2);
			 if(str1.indexOf(":")>=0)
			 {
				 str2=str1.split(":");
				 strval3=str2[0].split("-->");
			 }
//			 for(int h=0;h<concat_collect.size();h++)
//			 {
//				 String concaval=concat_collect.get(h);
//				 if((concaval.indexOf(strval2[0])>=0)||(concaval.indexOf(strval3[0])>=0))
//				{
//					 data_dynamic2=data_dynamic2+1;
//					 break;
//				}
//			 }
			 if(strval1[1].equals(str2[1]))
			 {
				 String concat_val=strval3[0]+"_"+strval2[0];
				 concat_collect.add(concat_val);
			 }
			 if(g2==datalist3.get(data_dynamic2).size()-1)
			 {
				 g2=0;
				 data_dynamic2=data_dynamic2+1;
				 if((data_dynamic2==datalist3.size()))//&&(data_dynamic1+1<=datalist3.size()-1))
				 {
					 if(data_dynamic1+1<datalist3.size()-1)
					 {

					// data_dynamic1=data_dynamic1+1;
					 
					// g1=0;
					 data_dynamic2=data_dynamic1+1;
					// data_dynamic2=0;
					 break;
					 }
				 }
			  }
			 
			 if(data_dynamic1+1==datalist3.size()-1)
			 {
				g1=datalist3.get(data_dynamic1).size();
				break;
				// data_dynamic1=datalist3.size()-1;
			 }
			
			
		 }
	 }
	 // removing duplicate values from the collected datalist3
	 for(int y=0;y<concat_collect.size();y++)
	 {
		 String concaval=concat_collect.get(y);
		 for(int k=y+1;k<concat_collect.size();k++)
		 {
			 String concaval1=concat_collect.get(k);
			 if(concaval.equals(concaval1))
			 {
				 concat_collect.remove(k);
			 }
		 }
		 
	 }
	 String reverseconcat="";
	 for(int y1=0;y1<concat_collect.size();y1++)
	 {
		 String concaval1=concat_collect.get(y1);
		 
		 String[] concaval2=concaval1.split("_");
		 for(int u=0;u<concaval2.length;u++)
		 {
			 
			 String concaval3=concaval2[u];
			 
			 
			 if((concaval2[1]!=concaval2[0])||(u==0))
			 {
				 if((reverseconcat.indexOf(concaval3)<=0))
				 {
			 
			 reverseconcat=reverseconcat+"_"+concaval3;
			 
			 }
			 }
			// }
		 }
	 }
	 // replacing the each object in planttext with the concatenated object
	 String strreverse=reverseconcat.substring(1,reverseconcat.length());
	 int data_dynamic_last=0;
	 String concatsplt = null;
	 for(int f=0;f<=dataList.get(data_dynamic_last).size();f++)
	 {
		 String str_val=dataList.get(data_dynamic_last).get(f);
		 if(str_val.indexOf("ok")>=0)
		 {
			 str_val=str_val.substring(0,str_val.indexOf("ok")-1);
		 }
		 if((str_val.indexOf(":")<=0)&&(str_val.indexOf(",")<=0))
		 {
			 String[] strsplt=str_val.split("-->");
			 if(strsplt[1].indexOf("_")>=0)
			 {
			 String strspltval=strsplt[1].substring(0,strsplt[1].indexOf("_"));
			 strsplt[1]=strspltval;
			 }
		//	 if(strsplt[0].indexOf(reverseconcat)>=0)
			 if(strreverse.indexOf(strsplt[0])>=0)
			 {
				 strsplt[0]=strreverse;
			//	 flag_match=true;
			 }
			// if(strsplt[1].indexOf(reverseconcat)>=0)
			 if(strreverse.indexOf(strsplt[1])>=0)
			 {
				 if(strsplt[1].indexOf("_")>=0)
				 {
					 concatsplt=strsplt[1].substring(0, strsplt[1].indexOf("_"));
					 concatsplt=strreverse;
				 }
				 else
				 {
				 strsplt[1]=concatsplt;
				 concatsplt=strreverse;
				 }
				// flag_match1=true;
				 
			 }
			 else
			 {
				 if(strsplt[1].indexOf("_")>=0)
				 {
					 concatsplt=strsplt[1].substring(0, strsplt[1].indexOf("_"));
					// concatsplt=strreverse;
				 }
				 else
				 {
					 concatsplt=strsplt[1];
				// concatsplt=strreverse;
				 }
			 }
		//	if(flag_match1==true)
			
				String planttext1=strsplt[0]+"-->"+concatsplt+":"+"<<create>>";
				 planntext_Collect.add(planttext1);
			
			 
		 }
		 if((str_val.indexOf(":")>=0)&&(str_val.indexOf(",")<=0))
		 {
			 String[] strsplt=str_val.split(":");
			 String[] strsplt1=strsplt[0].split("-->");
			 
		//	 if(strsplt1[0].indexOf(reverseconcat)>=0)
			 if(strreverse.indexOf(strsplt1[0])>=0)
			 {
				 strsplt1[0]=strreverse;
			 }
		//(strsplt1[1].indexOf(reverseconcat)>=0)
			 if(strreverse.indexOf(strsplt1[1])>=0)
			 {
				 strsplt1[1]=strreverse;
			 }
     		 if(strsplt[1].equals("()"))
     		 {
     			 strsplt[1]="main()";
             }
			 
			 String planttext2=strsplt1[0]+"-->"+strsplt1[1]+":"+strsplt[1];
			 planntext_Collect.add(planttext2);
		 }
		 if(f==dataList.get(data_dynamic_last).size()-1)
		 {
			 data_dynamic_last=data_dynamic_last+1;
			 f=0;
		 }
		 if(data_dynamic_last==dataList.size()-1)
		 {
			 break;
		 }
	 }
	 // writing the final output to the notepad
	 int s3=0;
	// planntext_Collect.add(0,"@startuml");
	planntext_Collect.add(planntext_Collect.size(),"@enduml");
	 FileWriter fstream1 = new FileWriter("C:/Users/madhusudans/Desktop/output_planntext.txt",true);
     BufferedWriter out = new BufferedWriter(fstream1);
     for(int s=0;s<planntext_Collect.size();s++)
     {
    	 if(s3==0)
    	 {
    		 out.newLine();
    		 out.write("@startuml"); 
    		 
    		
    		 s3=1;
    	 }
    	 String s1=planntext_Collect.get(s);
    	 out.newLine();
    	 out.write(s1);
    	 
    	 if(s1.equals("@enduml"))
    	 {
    		 out.newLine();
    		 out.write(s1); 
    		 break;
    	 }
     }
     out.close();
	System.out.println("hello");
	System.exit(0);
	
	
}
}

