//main.cpp
#include<iostream>
#include<string>
#include "emp.h"
#include "ArraySortedType.h"
using namespace std;
typedef Employee ItemType;

bool  searchEmployee(const ArraySortedType & slist, int eid);
void printAllEmployees(const ArraySortedType & slist, int did);

int main() {
	ArraySortedType l(5);
	cout<<"Enter Employee details:\n";
	for (int i = 0; i < 5; i++) {
		int eid, did;
		string name;
		cin >> eid >> name >> did;
		ItemType item(eid, name, did);
		l.InsertItem(item);
	}
	cout<<"Enter Employee id to delete: ";
	int eid, did;
	cin>>eid;
	ItemType key1(eid, "", 0);
	l.DeleteItem(key1);
	cout<<"Enter Employee id to search: ";
	bool found;
	cin >> eid;
	ItemType key2(eid, "", 0);
	l.RetrieveItem(key2, found);
	if (!found) {
		cout << "Not found!" << endl;
	} else {
		cout << "Found: ";
		key2.printDetails();
	}
	cout<<"Enter Department id to search: ";
	cin>>did;

	cout<<"List after modification:\n";
	l.printAllItems();
	cout<<"Employee with department id "<<did<<":\n";
	printAllEmployees(l,50);
	return 0;
}

bool  searchEmployee(const ArraySortedType & slist, int eid){
	ItemType item(eid, "", 0);
	bool found;
	ArraySortedType a(slist);
	a.RetrieveItem(item, found);
	return found;
}

void printAllEmployees(const ArraySortedType & slist, int did){
	ArraySortedType a(slist);
	ItemType item;
	a.ResetList();
	for (int i=0; i<a.LengthIs(); i++){
		a.GetNextItem(item);
		if (item.getDID() == did)
			item.printDetails();
	}
}

/*
2 Shihab 50
6 Awal 20
1 Mohammad 50
3 Mustafa 40
5 Ahmed 60
*/
