import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Abstraction_Step_2 extends Abstraction_Step_1
{
	Boolean Status=false;
	Boolean flag_escp=false;
  void remove_dead_method() throws IOException
  {
	  int datalist=0;
	  FileInputStream fstream_trace1 = new FileInputStream("C:/Users/madhusudans/Desktop/textwrite3.txt");
      //Get the object of DataInputStream
      DataInputStream in_trace1 = new DataInputStream(fstream_trace1);
      BufferedReader br_trace1 = new BufferedReader(new InputStreamReader(in_trace1));
      
  	 while ((strLine_trace1 = br_trace1.readLine()) != null)
       {
           sourcecode_methods.add(strLine_trace1);
       }
  	 // comparing the contents from the arraylist to the source code, if there is match in the function, then check for empty function
	  for(int g=0;g<=dataList.get(datalist).size();g++)
	  {
		  if(g==dataList.get(datalist).size())
		  {
			  datalist=datalist+1;
			  g=0;
		  }
		  String dynamic_val=dataList.get(datalist).get(g);
		  if(dynamic_val.indexOf("(")>=0)
		  {
			  
		    for(int y=0;y<sourcecode_methods.size();y++)
		  {
			  String src_func=sourcecode_methods.get(y);
			  String[] static_getval=src_func.split(" ");
			  for(int t=0;t<static_getval.length;t++)
			  {
				  if(flag_escp==true)
				  {
					  break;
				  }
				  String setsourceval=static_getval[t];
				  if(setsourceval.indexOf("(")>=0)
				  {
					  String sourcemethod=setsourceval.substring(0,  setsourceval.indexOf("("));
					  String[] dynamicval=dynamic_val.split(":");
					  String method=dynamicval[1].substring(0,dynamicval[1].indexOf("("));
					  
					  if(sourcemethod.equals(method))
					{
						  Boolean val=check_deadfunction(y);
						  if(val==true)
						  {
							  dataList.get(datalist).remove(g);
						  }
						  else
						  {
							  flag_escp=true;
							  break;
						  }
					}
					  
							  
				  }
			  }
			  
		  }
		  
	  }
		  Abstraction_Step_3 sbs3=new Abstraction_Step_3();
		  sbs3.add_missing_methods();
  }
	  String val2=dummy_planntext.get(0);	  	  
}

  // checking for functions which are empty
  Boolean check_deadfunction(int k)
  {
	  for(int n=k;n<sourcecode_methods.size();n++)
	  {
		  String src_val=sourcecode_methods.get(n);
		  String[] splt_source=src_val.split(" ");
		  if(splt_source.length<0)
		  {
			  Status=true;
		  }
		  else
		  {
			  Status=false;
		  }
		  if(src_val.indexOf("}")>=0)
		  {
			  break;
		  }

	  }
	return Status;
	
  }
  
}
//}
