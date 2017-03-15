#include "cul.h"
/*
 Default constructor implementation
 */
template<class ItemType>
CircularUnsortedList<ItemType>::CircularUnsortedList() {
	listData = NULL;
	currentPos = NULL;
	length = 0;
}
/*
 Destructor implementation
 Post Condition: Realease all th e memory allocated to circule list
 */
template<class ItemType>
CircularUnsortedList<ItemType>::~CircularUnsortedList() {
	NodeType<ItemType>* tempPtr1 = listData->next, *tempPtr2;

	while (tempPtr1 != listData) {
		tempPtr2 = tempPtr1;
		tempPtr1 = tempPtr1->next;
		delete tempPtr2;

	}
	if (listData != NULL) {
		delete listData;
		listData = NULL;
	}
}

/*
 Insert and ite of type ItemType in circule list
 Assuption: ItemType has comparedTo function
 Precondition: item is initalised with at least key value
 Post Condition: Item is insserted
 */
template<class ItemType>
void CircularUnsortedList<ItemType>::InsertItem(ItemType item) {
//Insert item at the front
	NodeType<ItemType>* newNode;

	newNode = new NodeType<ItemType>;
	newNode->info = item;
	if (listData != NULL) {
		newNode->next = listData->next;
		listData->next = newNode;

	} else // Inserting into an empty list.
	{
		listData = newNode;
		newNode->next = newNode;
	}
	length++;
}
/*
 item is deleted from the list if it exists
 Precondition: item is initialised with its key value at least
 Post Condition: Returms SUCCESS if item is deleted else returns FAIL
 */
template<class ItemType>
ERROR_CODE CircularUnsortedList<ItemType>::DeleteItem(ItemType item) {
	NodeType<ItemType>* location;
	NodeType<ItemType>* predLoc;
	bool found;

//No nodes in the list
	if (listData == NULL)
		return FAIL;
//Single node
	if (listData == listData->next && item == listData->info) {
		delete listData;
		listData = NULL;
		return SUCCESS;
	}

//The list has multiple nodes
	location = listData;
	found = false;
	do {
		predLoc = location;
		location = location->next;
		if (location->info == item) {
			found = true;
			break;
		}

	} while (location != listData);

	if (!found)
		return FAIL;

	predLoc->next = location->next;
// Deleting last node in list?
	if (location == listData)
		listData = predLoc;

	delete location;
	length--;

	return SUCCESS;
}

template<class ItemType>
void CircularUnsortedList<ItemType>::MakeEmpty()
// Post: List is empty; memory is released
{
	NodeType<ItemType>* tempPtr1 = listData->next, *tempPtr2;

	while (tempPtr1 != listData) {
		tempPtr2 = tempPtr1;
		tempPtr1 = tempPtr1->next;
		delete tempPtr2;

	}
	if (listData != NULL) {
		delete listData;
	}
	length = 0;
}

//Reset list
template<class ItemType>
void CircularUnsortedList<ItemType>::ResetList() {
	currentPos = NULL;
}

/*
 Retrieves an item from the list based on the item's key value
 Precondition: item is initialised with the key value
 Post condtion: if item's(argument) key is matched with the item's key in the list copy
 of the item in the list is made to item(argument)
 */
template<class ItemType>
void CircularUnsortedList<ItemType>::RetrieveItem(ItemType& item, bool& found) {
	bool moreToSearch;
	NodeType<ItemType>* location;

	location = listData;
	found = false;
	moreToSearch = (location != NULL);

	while (moreToSearch && !found) {
		if (location->info < item) {
			location = location->next;
			moreToSearch = (location != NULL);
		} else if (item == location->info) {
			found = true;
			item = location->info;
		} else
			moreToSearch = false;
	}
}

//Returns number of items in the list.
template<class ItemType>
int CircularUnsortedList<ItemType>::LengthIs() const {
	return length;
}

template<class ItemType>
ERROR_CODE CircularUnsortedList<ItemType>::ResetList(const ItemType & item) {
	NodeType<ItemType> *p = listData->next;
	currentPos = NULL;
	for (int i = 0; i < length; i++) {
		if (p->info == item) {
			currentPos = p;
			return SUCCESS;
		}
		p = p->next;
	}
	cout<<"Not found!\n";
	return FAIL;
}

template<class ItemType>
void CircularUnsortedList<ItemType>::print() {
	NodeType<ItemType> *p = listData->next;
	for (int i = 0; i < length; i++) {
		cout << p->info << "|  ";
		p = p->next;
	}
	cout << endl;
}

/*
 Gets next item from the list from the location currentPos->next
 Post condition: item = currentPosition->next-info;
 */
template<class ItemType>
void CircularUnsortedList<ItemType>::GetNextItem(ItemType& item, bool& end) {
	if (currentPos == NULL)
		currentPos = listData->next;
	else
		currentPos = currentPos->next;
	if (currentPos == listData)
		end = true;
	item = currentPos->info;
}

template<class ItemType>
void CircularUnsortedList<ItemType>::Rotate() {
	NodeType<ItemType> *p = listData->next;
	if (length == 1 || length == 0)
		return;
	for (int i = 0; i < length - 2; i++) {
		p = p->next;
	}
	listData = p;
}
