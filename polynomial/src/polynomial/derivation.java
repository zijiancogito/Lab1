//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : derivation.java
//  @ Date : 2016/12/1
//  @ Author : 
//
//


package polynomial;

public class derivation extends cal {
    public String cmd_pro(Object str_in, int flag) {
    	String s=null;
    	String[] temp=null;
		String[] str_temp = null;
		String tmp=null;
		String val_str = "";
		String temp0="**",temp1="*";
		String der_str = "";
		int constant = 0;
		int count=0;
		int coefficient = 1;
		String[] expre=((String) str_in).split("\\+");
		for(int i=0;i<expre.length;i++){
			count = 0;
			if(expre[i].contains(Var)){
				temp = expre[i].split("\\*");
				for(int j=0;j<temp.length;j++){
					if(temp[j].equalsIgnoreCase(Var)){
						count++;
					}
				}
				tmp = Integer.toString(count) + "*" + expre[i].replaceFirst(Var, "");
				try{
					tmp = tmp.replace(temp0, temp1);
				}catch (Exception e){
				}
				if(tmp.endsWith("*")){
					tmp=tmp.substring(0, tmp.length()-1);
				}
				der_str +=  tmp + "+";
			}
		}
		der_str = der_str.substring(0, der_str.length()-1);
		der_str = der_str.replace("-1*", "-");
		der_str = der_str.replace("1*", "");
		temp = der_str.split("\\+");
		der_str = "";
		for(int i=0;i<temp.length;i++){
			str_temp = temp[i].split("\\*");
			for(int j=0;j<str_temp.length;j++){
				try{
					count = Integer.valueOf(str_temp[j]);
					coefficient *= count;
				}catch (Exception e){
					val_str += "*" + str_temp[j];
				}
			}
			der_str += Integer.valueOf(coefficient)+val_str+"+";
			val_str = "";
			coefficient = 1;
		}
		der_str = der_str.substring(0, der_str.length()-1);
		temp = der_str.split("\\+");
		der_str = "";
		for(int i=0;i<temp.length;i++){
			try{
				count = Integer.valueOf(temp[i]);
				constant += count;
			}catch (Exception e){
				der_str += "+" + temp[i];
			}
		}
		if(constant!=0)
			der_str = Integer.toString(constant) + der_str;
		else
			der_str = der_str.substring(1);
		while(der_str.contains("+-")){
			der_str = der_str.replace("+-", "-");
		}
		while(der_str.contains("++")){
			der_str = der_str.replace("++", "+");
		}
		System.out.println(der_str);
		return der_str;
    }
}