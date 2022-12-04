public class test_1 {
        int a = 1;
	    int b;
		try {
		    if(a >= 30){
		        throw new Exception("Число должно быть меньше 30");
		    }
		    if(a < 5){
		        throw new Exception("Число должно быть больше 5");
		    }
		    b = a;
		} catch(Exception e) {
		    System.out.print(e.getMessage());  
		}
    }