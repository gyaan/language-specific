#include<iostream>
using namespace std;
int main() {

   //normal for loop
	int a[] = { 1, 2, 3, 4, 5, 5, 6, 7, 8, 10 };
	cout << "using normal for loop \n";
	for (int i = 0; i < ((sizeof(a) / sizeof(a[0]))); i++) {
		cout << a[i];
	}

	//using rang for loop
	cout << "\n using range for loop \n";
	for (auto x : a)
		cout << x;
	return 0;

}
