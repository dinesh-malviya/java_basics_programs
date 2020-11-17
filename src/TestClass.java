import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class TestClass {

	public static void main(String[] args) {
		
		String s = "Dinesh";
		System.out.println("subtring from 0 :"+s.substring(0));
		System.out.println("Dinesh Malviya");
		System.out.println("10%10: "+10%10);
		System.out.println("11%10: "+11%10);
		System.out.println("10%11: "+10%11);
		int arr[] = {2,3,6,1,5,9};
		for(int i=0; i<arr.length;i++) {
			System.out.println("i: "+arr[i]);
		}
		
		HashSet<Integer> set = new HashSet<>();
		int array[] = {1,5,4,7,1,9,4};
		for (int i : array) {
			if(set.add(i)) {
				System.out.println("Adding number: "+i);
			}else {
				System.out.println("duplicate number: "+i);
			}
		}
		Iterator<Integer> iterator  = set.iterator();
		while(iterator.hasNext()) {
			System.out.println("printing: "+iterator.next());
		}
		String str = "dinesh";
		System.out.println("substring:"+str.substring(0, str.length()-1));

	}
	
	
	    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
	        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
	      
	        int size = A.size();
	        if(size==0){
	            return resultList;
	        }
	        for(int col=0; col<size; col++){
	            int startCol = col, startRow= 0;
	            while(startCol>=0 && startRow<size){
	                ArrayList<Integer> tempList = new ArrayList<Integer>();
	                tempList.add(A.get(startRow).get(startCol));
	                resultList.add(tempList);
	                //System.out.println("a.getrow"+A.get(startRow).get(startCol));
	                //System.out.println(i);
	                startCol--;
	                startRow++;
	            }
	        }
	        
	        for(int row=0; row<size; row++){
	            int startCol = size-1, startRow= row;
	            while(startRow<size && startCol>=0){
	                ArrayList<Integer> tempList = new ArrayList<Integer>();
	                tempList.add(A.get(startRow).get(startCol));
	                resultList.add(tempList);
	                //System.out.println("a.getrow"+A.get(startRow).get(startCol));
	                //System.out.println(i);
	                startCol--;
	                startRow++;
	            }
	        }
	        
	        return resultList;
	    }
	

}

