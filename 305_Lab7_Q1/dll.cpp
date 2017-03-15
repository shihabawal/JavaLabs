#include "dll.h"
template<class ItemType>
DoublyLinkedList<ItemType>::DoublyLinkedList() {
	listData = NULL;
	length = 0;
	currentPos = NULL;

}
template<class ItemType>
void DoublyLinkedList<ItemType>::FindItem(NodeType<ItemType>* listData,
		ItemType item, NodeType<ItemType>*& location, bool& found)
// Assumption: ItemType is a type for which the operators "<" and
//  "==" are defined-either an appropriate built-in type or a
//  class that overloads these operations.
// Pre:  List is not empty.
// Post: If there is an element someItem whose key matches item's
//       key, then found = true; otherwise, found = false.
//       If found, location contains the address of someItem;
//       otherwise, location contains the address of the logical
//       successor of item.
		{
	bool moreToSearch = true;

	location = listData;
	found = false;
	while (moreToSearch && !found) {
		if (item < location->info)
			moreToSearch = false;
		else if (item == location->info)
			found = true;
		else {
			location = location->next;
			moreToSearch = (location != NULL);
		}
	}
}

template<class ItemType>
int DoublyLinkedList<ItemType>::LengthIs() const {
	return length;
}

template<class ItemType>
void DoublyLinkedList<ItemType>::MakeEmpty()
// Post: List is empty; all items have been deallocated.
{
	NodeType<ItemType>* tempPtr;

	while (listData != NULL) {
		tempPtr = listData;
		listData = listData->next;
		delete tempPtr;
	}
	length = 0;
}

template<class ItemType>
void DoublyLinkedList<ItemType>::ResetList() {
	currentPos = NULL;
}

template<class ItemType>
void DoublyLinkedList<ItemType>::GetNextItem(ItemType& item, bool& end) {
	if (currentPos == NULL)
		currentPos = listData;
	else
		currentPos = currentPos->next;
	if ((currentPos != NULL) && (currentPos->next == NULL))
		end = true;
	item = currentPos->info;
}

template<class ItemType>
void DoublyLinkedList<ItemType>::RetrieveItem(ItemType& item, bool& found) {
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

template<class ItemType>
DoublyLinkedList<ItemType>::~DoublyLinkedList()    // Class destructor.
{
	MakeEmpty();
}

template<class ItemType>
void DoublyLinkedList<ItemType>::InsertItem(ItemType item) {
	NodeType<ItemType> *location, *newNode;
	newNode = new NodeType<ItemType>;
	newNode->info = item;
	bool found;
	if (listData == NULL) {
		newNode->back = NULL;
		newNode->next = NULL;
		listData = newNode;
		length++;
	} else {
		FindItem(listData, item, location, found);
		if (found) {
			cout << "Item already exits!" << endl;
			return;
		}
		if (listData == location) {    //first node
			newNode->next = location;
			newNode->back = location->back;
			location->back = newNode;
			listData = newNode;
			length++;
			return;
		}
		newNode->next = location;
		newNode->back = location->back;
		location->back->next = newNode;
		location->back = newNode;
		length++;
	}
}

template<class ItemType>
void DoublyLinkedList<ItemType>::DeleteItem(ItemType item) {
	NodeType<ItemType> *location, *del;
	bool found;
	if (listData == NULL)
		return;
	FindItem(listData, item, location, found);
	if (!found) {
		cout << "Item not found!\n";
		return;
	} else {
		if (location == listData) {
			listData = location->next;
			delete location;
			length--;
		} else {
			location->next->back = location->back;
			location->back->next = location->next;
			delete location;
			length--;
		}
	}
}

template<class ItemType>
DoublyLinkedList<ItemType>::DoublyLinkedList(DoublyLinkedList<ItemType>& rhs) {
	length = rhs.length;
	currentPos = rhs.currentPos;
	if (rhs.listData == NULL) {
		listData = NULL;
	} else {
		//listData = new NodeType<ItemType>;
		//listData->info = rhs.listData->info;
		NodeType<ItemType> *p = rhs.listData;
		NodeType<ItemType> *n = new NodeType<ItemType>;
		listData = n;
		do {
			n->info = p->info;
			if (p->next != NULL) {
				n->next = new NodeType<ItemType>;
				n->next->back = n;
			}
			n = n->next;
			p = p->next;
		} while (p != NULL);
	}
}

template<class ItemType>
void DoublyLinkedList<ItemType>::print() {
	NodeType<ItemType> *p = listData;
	for (int i = 0; i < length; i++) {
		cout << p->info << " ";
		p = p->next;
	}
	cout << endl;
}

template<class ItemType>
void DoublyLinkedList<ItemType>::reverseDoublyLinkedList() {
	NodeType<ItemType> *first = listData, *last = listData;
	if (listData == NULL)
		return;
	for (int i = 0; i < length - 1; i++) {
		last = last->next;
	}
	for (int i = 0; i < length / 2; i++) {
		ItemType temp = first->info;
		first->info = last->info;
		last->info = temp;
		first = first->next;
		last = last->back;
	}
}

template<class ItemType>
void DoublyLinkedList<ItemType>::ResetList(const ItemType & item) {
	NodeType<ItemType> *location;
	bool found = false;
	for (int i = 0; i < length; i++) {
		FindItem(listData, item, location, found);
		if (!found) {
			cout << "Not found!\n";
			return;
		}
		currentPos = location->back;
	}
}

template<class ItemType>
void DoublyLinkedList<ItemType>::Rotate() {
	NodeType<ItemType> *last = listData;
	for (int i = 0; i < length - 1; i++)
		last = last->next;
	ItemType temp = last->info;
	for (int i = 0; i < length - 1; i++) {
		last->info = last->back->info;
		last = last->back;
	}
	listData->info = temp;
}
