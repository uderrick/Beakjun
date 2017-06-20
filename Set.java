import java.util.Scanner;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Set {

	static ArrayList<String>resultset = new ArrayList<String>();
	static String[] set;
	
	public static void operation() {

		Scanner sc = new Scanner(System.in);
		String first = sc.nextLine();

		String [] op1 = first.split(" ");

		int setNum = Integer.parseInt(op1[0]);
		int opNum = Integer.parseInt(op1[1]);
		set = new String[setNum+1];
		
		for (int i = 0; i < setNum+1; i++) {
			set[i] = Integer.toString(i);
		}

		for (int i = 0; i < opNum; i++) {

							String exp = sc.nextLine();
							String [] op2 = exp.split(" ");
							
							if (  op2[0].equals("0")) {
								
								joinOp(set,op2[1], op2[2]);
				
							} else if (op2[0].equals("1")) {
								
								boolean check = false;
								check = sameplacecheck(set, op2[1], op2[2]);
								if (check == true) {
									resultset.add("YES");
				
								} else {
									resultset.add("NO");
								}
							} else {
				
								System.out.println("잘못된 입력");
							}
							exp = "";
		}

	}

	public static boolean sameplacecheck(String[] set, String op2, String op22) {

		boolean rt = false;

		for (int i = 0; i < set.length; i++) {
			if (set[i].indexOf(op2) != -1 && set[i].indexOf(op22) != -1) {
				rt = true;
				return rt;
			}
		}
		return rt;
	}
	public static void joinOp( String [] set , String op2 , String op22){
		 int a_idx = 0;
		 int b_idx = 0;
		 
		 String tmp = "";
		 
		 for( int i = 0 ; i<set.length ; i++){
			 if( set[i].indexOf(op2) != -1){
				 a_idx = i;
			 }
			 if( set[i].indexOf(op22)!=-1){
				 b_idx = i;
			 }
		 }
		 
		 tmp = set[b_idx];
		 set[b_idx] = "";
		 set[a_idx]+=tmp;
	}

	public static void main(String args[]) {

		operation();
		for( int i =0 ; i< resultset.size() ; i++){
			System.out.println(resultset.get(i));
		}
		
		
	}
}
