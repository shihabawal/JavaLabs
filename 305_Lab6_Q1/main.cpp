//main.cpp
#include<iostream>
#include<string>
#include "ArraySortedType.h"
using namespace std;
typedef int ItemType;

int main() {
	ArraySortedType l(10);
	cout << "Insert 10 items: ";
	for (int i = 0; i < 10; i++) {
		ItemType item;
		cin >> item;
		l.InsertItem(item);
	}
	ItemType key, key1;
	cout << "Retrieve Items in range: ";
	cin >> key >> key1;
	bool found;
	ArraySortedType items;
	items = l.RetrieveItemsInRange(key, key1);
	if (items.LengthIs() == 0)
		cout << "Not found" << endl;
	else {
		cout << "Found items: ";
		items.printAllItems();
		cout << endl;
	}
	cout << "Delete Items in range: ";
	cin >> key >> key1;
	l.DeleteItemsInRange(key, key1);
	cout << "All items: ";
	l.printAllItems();
	cout << endl;
	return 0;
}

ArraySortedType merge(const ArraySortedType & list1,
		const ArraySortedType & list2) {
	ArraySortedType l1(list1), l2(list2);
	ArraySortedType merge(l1.LengthIs() + l2.LengthIs());
	ItemType item;
	l1.ResetList();
	for (int i = 0; i < l1.LengthIs(); i++) {
		l1.GetNextItem(item);
		merge.InsertItem(item);
	}
	l2.ResetList();
	for (int i = 0; i < l2.LengthIs(); i++) {
		l2.GetNextItem(item);
		merge.InsertItem(item);
	}
	return merge;
}

/*
 2 Shihab 50
 6 Awal 20
 1 Mohammad 55
 3 Mustafa 43
 5 Ahmed 62
 */
