import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Generate_Optimized_Sequence_Diagram
{
	static ArrayList<String> sourcecode_methods = new ArrayList<String>();
	static ArrayList<String> dummy_planntext = new ArrayList<String>();
	static ArrayList<String> list_linenumber = new ArrayList<String>();
	static ArrayList<String> final_planttext = new ArrayList<String>();
	static ArrayList<String> planttext = new ArrayList<String>();
	static ArrayList<String> list = new ArrayList<String>();
    static ArrayList<String> list_trace = new ArrayList<String>();
    static ArrayList<String> list_source = new ArrayList<String>();
    static ArrayList<String> parsetree_info = new ArrayList<String>();
    static ArrayList<String> function_collection = new ArrayList<String>();
    static ArrayList<String> function_list_master = new ArrayList<String>();
    static ArrayList<String> object_collection = new ArrayList<String>();
    static ArrayList<String> sourcecode_info = new ArrayList<String>();
    static ArrayList<Integer>Ref_Id = new ArrayList<Integer>();
    static ArrayList<Integer>Ref_Id1 = new ArrayList<Integer>();
   // static ArrayList<Integer>line_number = new ArrayList<Integer>();
    static List<List<String>> dataList = new ArrayList<List<String>>();
    static ArrayList<String> compare_classnames = new ArrayList<String>();
   // static List<String>> compare_classnames = new ArrayList<List<String>>();
    
    static int counter_arraylist=0;
   // static String set_function;
    
    static int m=1;
    static String line_number;
    static Boolean flag_linenumber=false;
    static boolean planntext_break=false;
    
    //static ArrayList<Integer> ref_idcollection = new ArrayList<Integer>();
    static int counter_ref=1;
    static int obj_ref=0;
    static String tr_linenum;
    static Boolean flag_srch=true;
    static Boolean source_flag_break=false;
    static String strLine_trace1;
    static String trim_line;
    
	 public static void main(String args[])throws Exception
	    {
	        FileInputStream fstream = new FileInputStream("C:/Users/madhusudans/Desktop/testtext1.txt");
	        ArrayList<String> list_trace = new ArrayList<String>();
	        //Get the object of DataInputStream
	        DataInputStream in = new DataInputStream(fstream);
	        BufferedReader br = new BufferedReader(new InputStreamReader(in));
	        ArrayList<String> list = new ArrayList<String>();
	        
	        
	        String str;
	        String strLine;
	        String info_line;
	        int count_ref=1;
	        
	        while ((strLine = br.readLine()) != null)
	        {
	            list.add(strLine);
	        }
	        String[] split_value = list.toArray(new String[list.size()]);
	        int i=0;
	        // providing line number to the source code 
	        for (int program_content=0;program_content<split_value.length-1;program_content++)
	            
	        {
	            i=i+1;
	            info_line=split_value[program_content];
	            String info_line_next=split_value[program_content+1];
	            
	            FileWriter fstream1 = new FileWriter("C:/Users/madhusudans/Desktop/textwrite3.txt",true);
	            BufferedWriter out = new BufferedWriter(fstream1);
	            out.write(i+" "+info_line);
	            out.newLine();
	            out.close();
	            
	        }
	    	FileInputStream fstream_trace1 = new FileInputStream("C:/Users/madhusudans/Desktop/textwrite3.txt");
	        //Get the object of DataInputStream
	        DataInputStream in_trace1 = new DataInputStream(fstream_trace1);
	        BufferedReader br_trace1 = new BufferedReader(new InputStreamReader(in_trace1));
	        
        	 while ((strLine_trace1 = br_trace1.readLine()) != null)
 	        {
 	            sourcecode_methods.add(strLine_trace1);
 	        }
	        
	        // reading the trace file and extracting the functions and class.
	        FileInputStream fstream_trace = new FileInputStream("C:/Users/madhusudans/Desktop/poly_trace.txt");
	        //Get the object of DataInputStream
	        DataInputStream in_trace = new DataInputStream(fstream_trace);
	        BufferedReader br_trace = new BufferedReader(new InputStreamReader(in_trace));
	        
	        String str_trace;
	        String strLine_trace;
	        String sourcecode = null;
	        String info_line_trace;
	        int escpe = 0;
	        String capturelinenumber = null;
	        String getmethod = "";
	        String capture_class = null;
	        String p2 = null;
	        String classname_object=null;
	        String get_linenumber = null;
	        Boolean flag_srchcomlpleted=false;
	        Boolean flagfound=false;
	        Boolean flag_subfunction=false;
	        int cls_reference = 0;
	        String clsname = null;
	        String sourcecode2=null;
	        String sourceclassname=null;
	        String destinationclass=null;
	        String source_destination=null;
	        int intval = 0;
	        String flag_srchcomlpleted1=null;
	        String sourcecode_next=null;
	        String getfunc=null;
	        String linenumb = null;
	        String getfunction=null;
	        String get_destination=null;
	        String subsg2=null;
	        String funccapture=null;
	        String destinationclassname=null;
	        String strval=null;
	        Boolean flag_class=true;
	        Boolean flag_findclass=false;
	        Boolean flag_classfind=false;
	        Boolean status_find_funcdef=true;
	        String subsval=null;
	        String trim_linenumber = null;
	        int xz = 0;
	        String trim_linenumber1 = null;
	        boolean flag_execute=false;
	        
	        while ((strLine_trace = br_trace.readLine()) != null)
	        {
	            list_trace.add(strLine_trace);
	        }
	        String[] split_value_trace = list_trace.toArray(new String[list_trace.size()]);
	        // extracting the line number from the trace file
	        try {
	        for(int srch_val=0;srch_val<split_value_trace.length;srch_val++)
	        {
	 
					
			
				
	        	flag_linenumber=false;
	        	planntext_break=false;
	        	if(planttext.size()>0)
	        	{
	        	for(int k=0;k<planttext.size();k++)
	        	{
	        	String r=planttext.get(k);
	        	}
	        	}
	        	String srch_lineno_function=split_value_trace[srch_val];
	        	if((srch_lineno_function.indexOf("line")>=0)&&(srch_lineno_function.indexOf("_")<=0))
	        	{
	        	  String[] line_number=srch_lineno_function.split(":");
	        	  get_linenumber=line_number[1];
	        	  flag_linenumber=true;
	        	 
	        	}

	        
	        	 // reading the source file and getting the functions/methods based on the line number captured from the execution trace
	        	if(flag_linenumber==true)
	        	{
	        	 for(int k=0;k<sourcecode_methods.size();k++)
	        	 {
	        		 if(escpe==1)
	        		 {
	        			 escpe=0;
	        			 break;
	        		 }
	        		 sourcecode= sourcecode_methods.get(k);
	        		// sourcecode_next= sourcecode_methods.get(k+1);
	        		 
	        		 if(k>0)
	        		 {
	        		 sourcecode2= sourcecode_methods.get(k-1);
	        		 }
	        		 String[] find_number=sourcecode.split(" ");
	        		 for(int p1=0;p1<find_number.length;p1++)
	        		 {
	        		    String b1=find_number[p1];
	        		    if(b1!=null)
	        		    {
	        		    	capturelinenumber=find_number[p1];
	        		    }
	        		    int ind_comma=get_linenumber.indexOf(",");
	        		    String c=get_linenumber.substring(0,ind_comma );
	        		   trim_linenumber=c.trim();
	        		   if(capturelinenumber.equals(trim_linenumber))
	        		   {
	        			   escpe=1;
	        			   break;
	        		   }
	        		 }
	        	 }
	        	 // if source code line number and execution trace line number matches then
	        		 if(capturelinenumber.equals(trim_linenumber))
	        		 {
	        			 intval=Integer.parseInt(trim_linenumber);
	        			 // to retrieve the class name 
	        			 for(int x=intval;x<sourcecode_methods.size();x--)
	        			 {
	        				 if(xz==1)
	        				 {
	        					 xz=0;
	        					 break;
	        				 }
	        				 String retrieve_class=sourcecode_methods.get(x);
	        				 // checking for the class keyword in the source code and retrieving it
	        				 if(retrieve_class.indexOf("class")>=0)
	        				 {
	        					 String[] arr_retrive_class=retrieve_class.split(" ");
	        					 for(int p=0;p<arr_retrive_class.length;p++)
	        					 {
	        						 if(arr_retrive_class[p].indexOf("class")>=0)
	        						 {
	        							 capture_class=arr_retrive_class[p+1];
	        							 compare_classnames.add(capture_class);
	        							 list_linenumber.add(trim_linenumber);
	        							 xz=1;
	        							 break;
	        						 }
	        					 }
	        				 }
	        			 }
	        		}
	        		 
	        			 // retrieving the object name based on keyword new
	        			 if((sourcecode.indexOf("new")>=0)&&(sourcecode.indexOf("=")>=0)&&((sourcecode.indexOf("(")>=0)||(sourcecode.indexOf("[")>=0)))
	        			 {
	        				 String[] get_new_function=sourcecode.split(" ");
	        				 for(int j=0;j<get_new_function.length;j++)
	        				 {
	        					 String check_new=get_new_function[j];
	        					 if(check_new.indexOf("new")>=0)
	        					 {
	        						 String object_name=get_new_function[j+1];
	        						 classname_object= capture_class+"_"+object_name;
	        						 String classname_object_1= capture_class+"_"+object_name+"_"+trim_linenumber;
	        						  planttext.add(classname_object);
	        						  dummy_planntext.add(classname_object_1);
	        						 break;
	        					 }
	        				 }
	        			 }
	        			 // retrieving the function if it is in the format "object[]. function()"
	        			 
	        				 // to retrieve the classname for the line  containing . and [ operator
	        				 if((sourcecode.indexOf("[")>=0)&&(sourcecode.indexOf(".")>=0)&&(sourcecode.indexOf("(")>=0)&&(sourcecode.indexOf("for")<=0)&&(sourcecode.indexOf("println")<=0))
	        				 {
	        					//int dot=sourcecode.indexOf("");
	        					 flag_findclass=false;
	        					 String[] src=sourcecode.split(" ");
	        					 for(int y=0;y<src.length;y++)
	        					 {
	        						 String src1=src[y];
	        						 if(src1.indexOf(".")>=0)
	        						 {
	        							 int dot=sourcecode.indexOf("]");
	        							 int len=sourcecode.length();
	    	        					// int dot1=sourcecode.indexOf(len);
	    	        					 funccapture=sourcecode.substring(dot+2, len);
// fetch the variable inside the array index and use it search in the execution trace, if it matches, retrieve the array refernce and corresponding object
	        							 String src2=src1.substring(src1.indexOf("[")+1, src1.indexOf("]"));
	        							// String subsval1=Character.toString(src2);
	        							 for(int y1=srch_val ;y1<split_value_trace.length;y1++)
	        							 {
	        								 if(flag_findclass==true)
     										{
     											break;
     										}

	        								 String get_variable=split_value_trace[y1];
	        								 String[] srch_semi=get_variable.split(" ");
	        								 for(int p=0;p<srch_semi.length;p++)
	        								 {
	        									 if(flag_findclass==true)
	        										{
	        											break;
	        										}
	        									 String p1=srch_semi[p];
	        									// String subsval1=p1.substring(0,p1.indexOf(":"));
	        									 if(p1.isEmpty()!=true)
	        									 {
	        									//  subsval=p1.substring(0,p1.indexOf(":"));
	        										 if(p1.indexOf(":")>=0)
	        										 {
	        											 String p4=p1.substring(0, p1.indexOf(":"));
	        											 String p6=p4.substring(1, p4.length()-1);
	        											// String p6=p4.substring(p4.indexOf(""),p4.indexOf("")) ;
	        											 if(p<srch_semi.length-1)
	        											 {
	        											 p2=srch_semi[p+1];
	        											 }
	        											 else
	        											 {
	        												 break;
	        											 }
	        											  if(src2.indexOf(p6)>=0)
	 		        									 {
	 	        										  String[] squarebrack=sourcecode.split(" ");
	 	        										  String p3=p2.substring(0,p2.indexOf(","));
	 	        										  for(int u=0;u<squarebrack.length;u++)
	 	        										  {
	 	        											  if(squarebrack[u].indexOf("(")>=0)
	 	        											  {
	 	        												 strval=squarebrack[u].substring(0,squarebrack[u].indexOf("["));
	 	        											  }
	 	        										  }
	 		        										//String strval=sourcecode.substring(0,sourcecode.indexOf("["));
	 		 	        									String strconcat1=strval+"["+p3+"]";
	 		 	        									for(int t=intval;t<sourcecode_methods.size();t--)
	 		 	        									{
	 		 	        										if(flag_findclass==true)
	 		 	        										{
	 		 	        											break;
	 		 	        										}
	 		 	        										String strvl=sourcecode_methods.get(t);
	 		 	        										if(strvl.indexOf(strconcat1)>=0)
	 		 	        										{
	 		 	        											String[] strvl1=strvl.split(" ");
	 		 	        											for(int g=0;g<strvl1.length;g++)
	 		 	        											{
	 		 	        												if(strvl1[g].indexOf("new")>=0)
	 		 	        												{
	 		 	        													String g2=strvl1[g+1];
	 		 	        													subsg2=g2.substring(0, g2.indexOf("("));
	 		 	        													flag_findclass=true;
	 		 	        													break;
	 		 	        													
	 		 	        												}
	 		 	        											}
	 		 	        											
	 		 	        										}
	 		 	        									}
	 		        									 } 
	        										 }
	        									 // char subsval2=subsval.charAt(1);
	        									
	        									 }

	        									 }

	        							 }
	        						 }
	        					 }
	        					
	        					 String[] srchclasss=sourcecode.split(" ");
	        					 String lnenumber=srchclasss[0];
	        					 flag_class=true;
	        					 for(int e=Integer.parseInt(lnenumber);e<sourcecode_methods.size();e--)
	        					 {
	        						
	        						 if(flag_class==false)
	        						 {
	        							 break;
	        						 }
	        						 if(sourcecode_methods.get(e).indexOf("class")>=0)
	        						 {
	        							String[] getline= sourcecode_methods.get(e).split(" ");
	        							for(int getlineclass=0;getlineclass<getline.length;getlineclass++)
	        							{
	        								if(getline[getlineclass].indexOf("class")>=0)
	        								{
	        									sourceclassname=getline[getlineclass+1];
	        									 String concat=sourceclassname+"_"+subsg2+"_"+ funccapture;
	        									 String concat1=sourceclassname+"_"+subsg2+"_"+ funccapture+"_"+trim_linenumber;
	            	        					 planttext.add(concat); 
	            	        					 dummy_planntext.add(concat1);
	            	        					 
	        									flag_class=false;
	        									break;
	        								}
	        							}
	        							//sourceclassname=getline[1];
	        						 }
	        						
	        					 }

	        						 }
	        					 
	        					 // to capture the function if in this format "object.function()"
		        				 if((sourcecode.indexOf("(")>=0)&&(sourcecode.indexOf(".")>=0)&&(sourcecode.indexOf("[")<=0)&&(sourcecode.indexOf("for")<=0)&&(sourcecode.indexOf("println")<=0))
		        				 {
		        					 String[] getobjectname=classname_object.split("_");
		        					 for(int t=0;t<getobjectname.length;t++)
		        					 {
			        						 String b=getobjectname[t];
			        						 if(b.indexOf("(")>=0)
		        						 {
			        							 get_destination=b.substring(0,b.indexOf("("));
		        						 }
		        					 }
		        					 String[] src1=sourcecode.split(" ");
		        					 for(int k=0;k<src1.length;k++)
		        					 {
		        						 String getmeth=src1[k];
		        						 if(getmeth.indexOf("(")>=0)
		        						 {
		        							 getfunc=getmeth.substring(getmeth.indexOf(".")+1,  getmeth.indexOf("("));
		        						 }
		        					 }
		        					 String concat1=getobjectname[0]+"_"+get_destination+"_"+getfunc;
		        					 String concat2=getobjectname[0]+"_"+get_destination+"_"+getfunc+"_"+trim_linenumber;
        							 planttext.add(concat1);
        							 dummy_planntext.add(concat2);
		        				 }

		        				 
		        				 // to check for the sub functions within the function
		        				 if((sourcecode.indexOf("(")>=0)&&(sourcecode.indexOf("for")<=0)&&(sourcecode.indexOf("=")<=0)&&(sourcecode.indexOf("println")<=0)&&(sourcecode.indexOf(".")<=0))
			        			 {
		        					 flag_subfunction=false;
		        					 flag_srchcomlpleted1="no";
		        				 String[] findmethod=sourcecode.split(" ");
		        				 for(int e=0;e<findmethod.length;e++)
		        				 {
		        					 flag_srchcomlpleted1="no";
		        					 flag_subfunction=false;

		        					 
		        					 getfunc=findmethod[e];
		        					 if(getfunc.indexOf("(")>=0)
		        					 {
		        						
		        						getfunction=getfunc.substring(0,getfunc.indexOf("(")); 
		        						 // retrieving the class name corresponding to the function
			        					 for(int f=Integer.parseInt(trim_linenumber)-1;f<sourcecode_methods.size();f--)
			        					 {
			        						 String srchbackclass=sourcecode_methods.get(f);
			        						 String srchbackclass2=sourcecode_methods.get(f-1);
			        						 if(flag_srchcomlpleted1=="yes")
		        							 {
		        								 break;
		        							 }
			        						 if( flag_srchcomlpleted==true)
			        						 {
			        							 flag_srchcomlpleted=false;
			        							 break;
			        						 }
			        						 if((srchbackclass.indexOf("{")>=0)&&(flag_subfunction==false))
			        						 {
			        							 if(srchbackclass2.indexOf("(")>=0)
			        							 {
			        								 flag_subfunction=true;
			        							 }
			        						// }
			        						 for(int t1=f;t1<sourcecode_methods.size();t1--)
			        						 {
			        							 if(flag_srchcomlpleted1=="yes")
			        							 {
			        								 break;
			        							 }
			        							 String cls1=sourcecode_methods.get(t1);
			        								 if(cls1.indexOf("class")>=0)
					        						 {
					        							 String[] srchbackclass1= cls1.split(" ");
					        							 for(int t=0;t<srchbackclass1.length;t++)
					        							 {
					        								 String getclass=srchbackclass1[t];
					        								 if(getclass.indexOf("class")>=0)
					        								 {
					        									 source_destination=srchbackclass1[t+1];
					        									 if(flag_subfunction==true)
					        									 {
					        									 String concat1=source_destination+"_"+source_destination+"_"+getfunction;
					        									 String concat2=source_destination+"_"+source_destination+"_"+getfunction+"_"+trim_linenumber;
					        									 planttext.add(concat1);
					        									 dummy_planntext.add(concat2);
					        									 flag_srchcomlpleted1="yes";
					        									 break;
					        									 }
					        									 
					        								 }
					        							 }
					        						 }
			        								// break;
			        						 }
			        						 }
			        							 }
			        						 }
			        						
			        					 }
		        					 }
		        					
		        					 
		        				 //}
			        			 //}
	        		// check the println() and find if there are any functions inside the println for capture	
	        				 if(sourcecode.indexOf("println")>=0)
	        				 {
	        					 flag_srchcomlpleted1="no";
	        					 String[] check_println=sourcecode.split(" ");
	        					 for(int g=0;g<check_println.length;g++)
	        					 {
	        						 flag_srchcomlpleted1="no";
//	        						 if(flag_srchcomlpleted1=="yes")
//        							 {
//        								 break;
//        							 }
	        						 String checkprintlnbracket=check_println[g];
	        						 if((checkprintlnbracket.indexOf("(")>=0)&&(checkprintlnbracket.indexOf("println")<=0)&&(checkprintlnbracket.length()>1)&&(checkprintlnbracket.indexOf(":")<=0))
	        						 {
	        							 String get_println_method=checkprintlnbracket.substring(0,checkprintlnbracket.indexOf("("));
	        							 for(int t1=Integer.parseInt(trim_linenumber);t1<sourcecode_methods.size();t1--)
		        						 {
		        							 if(flag_srchcomlpleted1=="yes")
		        							 {
		        								 break;
		        							 }
		        							 String cls1=sourcecode_methods.get(t1);
		        								 if(cls1.indexOf("class")>=0)
				        						 {
				        							 String[] srchbackclass1= cls1.split(" ");
				        							 // searching for the class and extends to retrieve class
				        							 for(int t=0;t<srchbackclass1.length;t++)
				        							 {
				        								 String getclass=srchbackclass1[t];
				        								 if(getclass.indexOf("class")>=0)
				        								 {
				        									 String getclass1=srchbackclass1[t+1];
				        									 if(srchbackclass1[t+2].indexOf("extends")>=0)
				        									 {
				        										 destinationclass=srchbackclass1[t+3];
				        									 }
				        									 // search for the function from the top of the class, if the function definition is found, then function belong to the same class, other wise it belongs to different class
				        									 for(int p=t1+1;p<sourcecode_methods.size();p++)
				        									 {
				        										 int control=0;
				        										 String catchmethod=sourcecode_methods.get(p);
				        										 if(catchmethod.indexOf(get_println_method)>=0)
				        										 {
				        											 String methoddef=sourcecode_methods.get(p+1);
				        											 if(methoddef.indexOf("{")>=0)
				        											 {
				        												 String concat1=getclass1+"_"+getclass1+"_"+get_println_method;
				        												 String concat2=getclass1+"_"+getclass1+"_"+get_println_method+"_"+trim_linenumber;
							        									 planttext.add(concat1);
							        									 dummy_planntext.add(concat2);
							        									 flag_srchcomlpleted1="yes";
							        									 control=1;
							        									 break;
				        											 }
				        										 }
				        										 if((catchmethod.indexOf("class")>=0)||(p==sourcecode_methods.size()-1)&&(control==0))
				        										 {
				        											 status_find_funcdef=false;
				        											 break;
				        										 }
				        									 }
				        									 if(status_find_funcdef==false)
				        									 {
				        										 String concat2=getclass1+"_"+destinationclass+"_"+get_println_method;
				        										 String concat3=getclass1+"_"+destinationclass+"_"+get_println_method+"_"+line_number;
				        										 planttext.add(concat2);
				        										 dummy_planntext.add(concat3);
				        										 flag_srchcomlpleted1="yes";
					        									 status_find_funcdef=true;
					        									 break;
				        									 }
				        									 
				        									
				        									 
				        								 }
				        							 }
				        						 }
		        								// break;
		        						 }
	        							 
	        						//	 String concat_printlnmethod=source_destination+"_"+source_destination+"_"+get_println_method;
	        							// planttext.add(concat_printlnmethod);
	        						 }
	        					 }
	        					
	        				 }
	        				 if(sourcecode.indexOf("if")>=0)
	        				 {
	        					 for(int t=Integer.parseInt(line_number);t<sourcecode_methods.size();t++)
	        					 {
	        						 String ifmethod=sourcecode_methods.get(t);
	        						 if((ifmethod.indexOf("(")>=0)&&(ifmethod.indexOf("for")<=0))
									{
	        							 String[] strmethd=ifmethod.split(" ");
	        							 for(int p=0;p<strmethd.length;p++)
	        							 {
	        								 String iffunc=strmethd[p];
	        								 if(iffunc.indexOf("(")>=0)
	        								 {
	        									 String funcmathod=iffunc.substring(0, iffunc.indexOf("("));
	        									 for(int k=t;k<sourcecode_methods.size();k--)
	        									 {
	        										 String srchclass=sourcecode_methods.get(k);
	        										 if(srchclass.indexOf("class")>=0)
	        										 {
	        											 String[] strclass1=srchclass.split(" ");
	        											 for(int j=0;j<strclass1.length;j++)
	        											 {
	        												 if(strclass1[j].indexOf("class")>=0)
	        												 {
	        													 clsname=strclass1[j];
	        													 String funcstr=clsname+"_"+clsname+ifmethod;
	        													 String funcstr1=clsname+"_"+clsname+ifmethod+"_"+line_number;
	        													 planttext.add(funcstr);
	        													 dummy_planntext.add(funcstr1);
	        												 }
	        											 }
	        										 }
	        									 }
	        									 
	        								 }
	        							 }
										
										
									}
	        						 if((ifmethod.indexOf("else")>=0))
	        						 {
	        							 for(int u=t;u<sourcecode_methods.size();u++)
	        							 {
	        								 String elsemethod=sourcecode_methods.get(u);
	        								 if((elsemethod.indexOf("(")>=0)&&(elsemethod.indexOf("for")<=0))
	        								 {
	        									 String[] strelsefunc=elsemethod.split(" ");
	        									 for(int y=0;y<strelsefunc.length;y++)
	        									 {
	        										 String strelseval=strelsefunc[y];
	        										 if(strelseval.indexOf("(")>=0)
	        										 {
	        											 String captureelse=strelseval.substring(0, strelseval.indexOf("("));
	        											 String funcstr1=clsname+"_"+clsname+"_"+captureelse;
	        											 String funcstr2=clsname+"_"+clsname+"_"+captureelse+"_"+trim_linenumber;
	        											 planttext.add(funcstr1);
	        											 dummy_planntext.add(funcstr2);
	        											 
	        										 }
	        									 }
	        								 }
	        							 }
	        						 }
	        						 

	        						 
	        					 }
	        					// sourcecode_next.in 
	        				 }

	        				 }
	        
	        }
	        }
	        catch (IndexOutOfBoundsException e) {
			    System.err.println("IndexOutOfBoundsException: " + e.getMessage());
	        }
	
	        
			//bw.newLine();
			for(int z=0;z<planttext.size();z++)
			{
				String get_planttextval=planttext.get(z);
				String[] splt_planttext=get_planttextval.split("_");
				//for(int t=0;t<splt_planttext.length;t++)
				//{
					if(splt_planttext.length>=3)
					{
						BufferedWriter bw1 = new BufferedWriter(new FileWriter("C:/Users/madhusudans/Desktop/textwrite1.txt", true));
						bw1.newLine();
						if((splt_planttext[2].indexOf("(")>=0))
						{
							String val1=splt_planttext[2].substring(0, splt_planttext[2].indexOf("("));
							String val2=splt_planttext[0]+"-->"+splt_planttext[1]+":"+val1+"()";
							//String val2=splt_planttext[2].substring(splt_planttext[2].indexOf(".")+1, splt_planttext[2].indexOf("("));
							bw1.write(splt_planttext[0]+"-->"+splt_planttext[1]+":"+val1+"()");
							final_planttext.add(val2);
							
						}
						if((splt_planttext[2].indexOf("(")<=0))
						{
							//String val1=splt_planttext[2].substring(0, splt_planttext[2].indexOf("("));
							String val3=splt_planttext[0]+"-->"+splt_planttext[1]+":"+splt_planttext[2]+"()";
							bw1.write(splt_planttext[0]+"-->"+splt_planttext[1]+":"+splt_planttext[2]+"()");
							final_planttext.add(val3);
						}
					//	String val1=splt_planttext[0];
						bw1.close();
					}
					if(splt_planttext.length<3)
					{
						BufferedWriter bw2 = new BufferedWriter(new FileWriter("C:/Users/madhusudans/Desktop/textwrite1.txt", true));
						bw2.newLine();
						if(splt_planttext[1].indexOf("(")>=0)
						{
							String val1=splt_planttext[1].substring(0, splt_planttext[1].indexOf("("));
							String val4=splt_planttext[0]+"-->"+val1;
							bw2.write(splt_planttext[0]+"-->"+val1);
							final_planttext.add(val4);
						}
						if(splt_planttext[1].indexOf("[")>=0)
						{
							String val2=splt_planttext[1].substring(0, splt_planttext[1].indexOf("["));
							bw2.write(splt_planttext[0]+"-->"+val2);
							String val5=splt_planttext[0]+"-->"+val2;
							final_planttext.add(val5);
						}
					//	String val1=splt_planttext[0];
						bw2.close();
					}

					
			}
	    Abstraction_Step_1 abs=new Abstraction_Step_1();
	    abs.Remove_Duplicate_methods();
	//    int b=10;
//}
	    }
}

//} 



	