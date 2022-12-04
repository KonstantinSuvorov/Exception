public class test_2 {
    public static int getFactorial(int num) throws Exception{
        if(num < 0) throw new Exception("число меньше нуля");
        int res = 1;
        for (int i = 1;i <= num;i++ ){
            res*=i;
        } 
        return res;
        
    }
	public static void main(String[] args) {
		try {
		    int a = getFactorial(-1);
		    System.out.print(a);
		} catch(Exception e) {
		    System.out.print(e.getMessage());  
		}
		
	}

}
