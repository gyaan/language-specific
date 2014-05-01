#include<iostream>
using namespace std;

int main() {
	int arr[100];
	int nElems = 0;
	int j;
	int searchKey;

	arr[0] = 77;
	arr[1] = 87;
	arr[2] = 67;
	arr[3] = 90;
	arr[4] = 79;
	arr[5] = 55;
	arr[6] = 78;
	arr[7] = 54;
	arr[8] = 23;
	arr[9] = 100;
	nElems = 10;

	//displaying  items
	for (j = 0; j < nElems; j++) {
		cout << arr[j] << "";
		cout << endl;
	}
	//search a key 55
	searchKey = 55;
	for (j = 0; j < nElems; j++) {
		if (searchKey == arr[j])
			break;
	}
	if (j == nElems)
		cout << "not found" << endl;
	else
		cout << searchKey << " found";

	//delete a element
	searchKey = 78;
	for (j = 0; j < nElems; j++) {

		if (searchKey == arr[j])
			break;
	}

	for (int k = j; k < nElems; k++) {
		arr[k] = arr[k + 1];
	}
	nElems--;
	cout << endl;
	cout << "after deletion";
	//displaying  items
	for (j = 0; j < nElems; j++) {
		cout << arr[j] << "";
		cout << endl;
	}

	cout<<endl;
	return 0;

}
