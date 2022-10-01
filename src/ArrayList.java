import java.util.Arrays;
public class ArrayList <T> { //Generic Array-list class 
	
	private static Object arraylist[];
	private T object;
	private static int i = 0; 
	private static int length = 0;
	
	public ArrayList()
    {
        arraylist = new Object[30];
    }
	
	public void add(T object) {
	
		this.object = object;
	        if(i == length-1)
	        {
	            arraylist = Arrays.copyOf(arraylist, arraylist.length+1); //Enumerating static array as dynamic by increasing 50%
	        }
	        
	        arraylist[i] = this.object;
	        i++;

			length++; //Incrementing size of his array-list

	}
		
	public void remove(int index) throws ArrayIndexOutOfBoundsException{

        // check if the array is empty or index is out of bounds 
        if (arraylist == null || index < 0 || index > length) { 
        	 throw new ArrayIndexOutOfBoundsException();
        } 
        
        System.arraycopy(arraylist, index + 1, arraylist, index, length - 1 - index);
        

		length--; //Decrementing size of array
		
	}
	
	public void bubbleSort(int j) //Linked with function in General Menu to elicit indexes that need assortment 
    {
                    Object temp = arraylist[j];
                    arraylist[j] = arraylist[j+1];
                    arraylist[j+1] = temp; 
    }
	
	@SuppressWarnings("unchecked")
	public T get(int index){ //Array-list index getter 
        if(arraylist[index]!= null){
            return (T) arraylist[index];
        }
        else {
    		 throw new ArrayIndexOutOfBoundsException("Index:"+index);
        }
    }
	
	public int length() {
		return length;
	}

	public Object[] getArraylist() {
		return arraylist;
	}

	public void setArraylist(Object[] arraylist) {
		ArrayList.arraylist = arraylist;
	}

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		ArrayList.i = i;
	}

	public static int getLength() {
		return length;
	}

	public static void setLength(int length) {
		ArrayList.length = length;
	}
}