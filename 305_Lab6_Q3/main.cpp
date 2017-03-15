//main.cpp
#include<iostream>
#include<string>
#include "ArraySortedType.h"
using namespace std;
typedef int ItemType;

ArraySortedType merge(const ArraySortedType & list1, const ArraySortedType & list2);

int main() {
	ArraySortedType l1(5), l2(5), mergedList;
	cout << "Insert 5 items for array1: ";
	for (int i = 0; i < 5; i++) {
		ItemType item;
		cin >> item;
		l1.InsertItem(item);
	}
	cout << "Insert 5 items for array2: ";
	for (int i = 0; i < 5; i++) {
		ItemType item;
		cin >> item;
		l2.InsertItem(item);
	}
	cout << "Merged arrays member function: ";
	mergedList = l1.merge(l2);
	mergedList.printAllItems();

	cout << "\nMerged arrays application function: ";
	mergedList = merge(l1,l2);
	mergedList.printAllItems();

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
