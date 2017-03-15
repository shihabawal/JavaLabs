//ArraySortedType.cpp
#include <cstdlib>
#include "ArraySortedType.h"
using namespace std;
/*
 Function Description: Construtor allocates memory dynamically for the list(array).
 Size if the array is decided by the function argument
 Precondition: Argument must be positive integer  > 0;
 Post condition: lenth, MAX_ITEMS are initialized and memory is allocated if available.
 */
ArraySortedType::ArraySortedType(int max_items) {
	length = 0;
	MAX_ITEMS = max_items;
	currentPos = -1;
	try {
		info = new ItemType[MAX_ITEMS];
	} catch (std::bad_alloc exception) {
		//Severe problem, do not keep program running
		cout << "Memory full " << endl;
		exit(1);
	}
}
/*
 Function Description: Destructor releases memory that is allocated dynamically for the list(array)
 Precondition:  info != NULL;
 Post condition: Memory released and info = NULL
 */
ArraySortedType::~ArraySortedType() {
	delete[] info;
	info = NULL;
}
/*
 Function Description: Resets the list
 Precondition:
 Post condition: CurrentPos = -1;
 */
void ArraySortedType::ResetList() {
	currentPos = -1;
}
/*
 Function Description: List grows by twice in size if length == MAX_ITEMS and if memory is available in heap.
 Funtion returns true if memory is is not available else returns false
 Precondition: length == MAX_ITEMS
 Post condition: Memory is doubled in size retaining original items in the new list.
 Original memory that is allocated for the list is released.
 */
bool ArraySortedType::IsFull() const {
	if (length == MAX_ITEMS) {
		try { //Check if memory allocation is fine
			ItemType * temp = new ItemType[2 * MAX_ITEMS];
			delete[] temp;
			return false;
		} catch (bad_alloc exception) {
			return true;
		}
	}
	return false;
}
/*
 Function Description: Checks if the list is empty. Returns true if list is empty else returns false.
 Precondition:   No items can be removed from the list(length == 0)
 Post condition:
 */
bool ArraySortedType::IsEmpty() const {
	return (length == 0);
}
/*
 Function Description: Returns the number of items in the list.
 Precondition:
 Post condition:
 */
int ArraySortedType::LengthIs() const {
	return length;
}

/*
 Function Description: Returns "Success" if  currentPos < length else returns "Fail"
 Precondition:  currentPos < length
 Post condition:  currentPos++; item = info[currentPos];
 */
Error_code ArraySortedType::GetNextItem(ItemType& item) {
	currentPos++;
	if (currentPos == length)
		return Fail;
	item = info[currentPos];
	return Success;
}
/*
 Function Description: Creates a copy of the list that is passed as argument
 Precondition:  Memory is not full
 Post condition:  Copy of ust is made.
 */
ArraySortedType::ArraySortedType(const ArraySortedType & ust) {

	MAX_ITEMS = ust.MAX_ITEMS;
	length = ust.length;
	try {
		info = new ItemType[MAX_ITEMS];
	} catch (std::bad_alloc exception) {
		//Severe problem, do not keep program running
		cout << "Memory full " << endl;
		exit(1);
	}
	for (int i = 0; i < length; i++)
		info[i] = ust.info[i];
	currentPos = ust.currentPos;

}

/*
 Function Description: List (passed as argument) is assigned to another existing list.
 Returns the current list  that is copy of the the list passed as argument
 Precondition:  Memory is not full
 Post condition:  Current list is copy of the list that is passed as argument.
 */
ArraySortedType& ArraySortedType::operator=(const ArraySortedType & ust) {
	if (this == &ust)
		return *this;

	if (MAX_ITEMS != ust.MAX_ITEMS) {
		delete[] info;
		MAX_ITEMS = ust.MAX_ITEMS;
		try {
			info = new ItemType[MAX_ITEMS];
		} catch (std::bad_alloc exception) {
			//Severe problem, do not keep program running
			cout << "Memory full " << endl;
			exit(1);
		}
	}
	currentPos = ust.currentPos;
	length = ust.length;
	for (int i = 0; i < length; i++)
		info[i] = ust.info[i];

	return *this;
}

/*
 Function Description:  Checks if the current list is a copy of the list that is passed as argument.
 Retusns true if current list is a copy of the list that is passed as argument else returns false;
 Precondition: Ids are unique
 Post condition:
 */
bool ArraySortedType::operator==(const ArraySortedType & ust) {
	if (this == &ust)
		return true;
	if (length != ust.length)
		return false;
	if (currentPos != ust.currentPos)
		return false;
	for (int i = 0; i < length; i++)
		if (info[i].ComparedTo(ust.info[i]) != EQUAL)
			return false;
	return true;

}
//Print all items in the list
void ArraySortedType::printAllItems() {
	ItemType item;
	ResetList();
	while (GetNextItem(item) == Success) {
		item.printDetails();
	}
}

//============================================================================================================

Error_code ArraySortedType::InsertItem(ItemType & item) {
	bool moreToSearch;
	int location = 0;
	if (IsFull())
		return Fail;
	moreToSearch = (location < length);
	while (moreToSearch) {
		switch (item.ComparedTo(info[location])) {
		case EQUAL:
		case LESS:
			moreToSearch = false;
			break;
		case GREATER:
			location++;
			moreToSearch = (location < length);
			break;
		}
	}
	for (int i = length; i > location; i--)
		info[i] = info[i - 1];
	info[location] = item;
	length++;
	return Success;
}
Error_code ArraySortedType::DeleteItem(ItemType & item) {
	if (IsEmpty())
		return Fail;
	bool moreToSearch;
	int location = 0;
	moreToSearch = (location < length);
	while (moreToSearch) {
		switch (item.ComparedTo(info[location])) {
		case EQUAL:
		case LESS:
			moreToSearch = false;
			break;
		case GREATER:
			location++;
			moreToSearch = (location < length);
			break;
		}
	}
	if (location < length) {
		for (int i = location; i < length - 1; i++) {
			info[i] = info[i + 1];
		}
	} else
		return Not_found;
	length--;
	return Success;
}
Error_code ArraySortedType::RetrieveItem(ItemType & item, bool & found) {
	if (IsEmpty())
		return Fail;
	int first = 0, last = length - 1;
	int midpoint;
	bool moreToSearch = first <= last;
	found = false;
	while (moreToSearch && !found) {
		midpoint = (first + last) / 2;
		switch (item.ComparedTo(info[midpoint])) {
		case EQUAL:
			found = true;
			item = info[midpoint];
			break;
		case LESS:
			last = midpoint - 1;
			moreToSearch = (first <= last);
			break;
		case GREATER:
			first = midpoint + 1;
			moreToSearch = (first <= last);
			break;
		}
	}
	if (!found)
		return Not_found;
	return Success;
}

