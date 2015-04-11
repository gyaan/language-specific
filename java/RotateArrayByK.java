import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class RotateArrayByK {

	private ArrayList<Integer> arrayListForRatate;
	private int rotation;

	public RotateArrayByK(ArrayList<Integer> myArrayList, int numberOfRotation) {
		this.arrayListForRatate = myArrayList;
		this.rotation = numberOfRotation;
	}

	public ArrayList<Integer> rotatArray() {

		// define array list
		ArrayList<Integer> myArrayList1, myArrayList2;

		// initialize array list
		myArrayList1 = new ArrayList<Integer>();
		myArrayList2 = new ArrayList<Integer>();

		// take first kth element in first arrayList
		myArrayList1 = new ArrayList<Integer>(this.arrayListForRatate.subList(0, this.rotation));

		// take remaining array list
		myArrayList2 = new ArrayList<Integer>(this.arrayListForRatate.subList(this.rotation, this.arrayListForRatate.size() - 1));

		// reverse first array list
		myArrayList1 = (ArrayList<Integer>) this.reversArray(myArrayList1);
		// reverse second array list
		myArrayList2 = (ArrayList<Integer>) this.reversArray(myArrayList2);

		// add second array list to first array list
		myArrayList1.addAll(myArrayList2);

		// reverse complete array list and return
		return this.reversArray(myArrayList1);

	}

	private ArrayList<Integer> reversArray(ArrayList<Integer> arr) {

		ArrayList<Integer> reverse = new ArrayList<Integer>();
		Iterator<Integer> individualItem = arr.iterator();
		Stack<Integer> S = new Stack<Integer>();

		while (individualItem.hasNext()) {
			S.push(individualItem.next());
		}

		while (!S.empty()) {
			reverse.add(S.pop());
		}

		return reverse;
	}

	
	//this function can create in separate class 
	public static void main(String args[]) {

		ArrayList<Integer> myArrayList = new ArrayList<Integer>();

		for (int i = 12; i < 30; i++) {
			myArrayList.add(i);
		}

		RotateArrayByK rotateArrayByK = new RotateArrayByK(myArrayList, 3);
		myArrayList = (ArrayList<Integer>) rotateArrayByK.rotatArray();

		Iterator<Integer> individualItem = myArrayList.iterator();

		while (individualItem.hasNext()) {
			System.out.println(individualItem.next());
		}

	}

}
