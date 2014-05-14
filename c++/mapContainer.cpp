#include<iostream>
#include<map>
#include<string>
using namespace std;

//define a map and add some values to it also
map<string, int> phone_book { { "gyani", 12121 }, { "rahul", 212121 }, {
		"deepak", 2121 } };

//a function which return the value of a map key
int get_number(const string& s) {
	return phone_book[s];
}

int main() {

    //get a value of key
	int n = get_number("gyani");
    cout<<"mr. gyani no is: "<<n;

	//add a element in map
	phone_book["elo"] = 12121;

	//iterator of a map
	map<string, int>::iterator dis;

	//display all elements
	for (dis = phone_book.begin(); dis != phone_book.end(); dis++) {
		cout << dis->first << " no is:" << dis->second << endl;
		//Should output 1 4 8
	}

	//check if one element is in the map
	if (phone_book.find("elo") == phone_book.end()) {
		cout << "not found";
	} else {
		cout << "found";
	}

	return 0;
}
