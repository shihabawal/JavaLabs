// This file contains the linked implementation of class
// UnsortedType.

#include "uslist.h"
struct NodeType {
	ItemType info;
	NodeType* next;
};

UnsortedType::UnsortedType()  // Class constructor
{
	length = 0;
	listData = NULL;
	currentPos = NULL;
}
bool UnsortedType::IsFull() const
// Returns true if there is no room for another ItemType
//  on the free store; false otherwise.
{
	NodeType* location;
	try {
		location = new NodeType;
		delete location;
		return false;
	} catch (std::bad_alloc exception) {
		return true;
	}
}

int UnsortedType::LengthIs() const
// Post: Number of items in the list is returned.
{
	return length;
}

void UnsortedType::MakeEmpty()
// Post: List is empty; all items have been deallocated.
{
	NodeType* tempPtr;

	while (listData != NULL) {
		tempPtr = listData;
		listData = listData->next;
		delete tempPtr;
	}
	length = 0;
}
Error_code UnsortedType::InsertItem(ItemType item)
// item is in the list; length has been incremented.
		{
	if (IsFull())
		return Fail;

	NodeType* location;			// Declare a pointer to a node

	location = new NodeType;		// Get a new node
	location->info = item;		// Store the item in the node
	location->next = listData;	// Store address of first node
	//   in next field of new node
	listData = location;		// Store address of new node into
	//   external pointer
	length++;	  // Increment length of the list
	return Success;
}

ItemType UnsortedType::RetrieveItem(ItemType& item, bool& found)
// Pre:  Key member(s) of item is initialized.
// Post: If found, item's key matches an element's key in the
//       list and a copy of that element has been stored in item;
//       otherwise, item is unchanged.
		{
	bool moreToSearch;
	NodeType* location;

	location = listData;
	found = false;
	moreToSearch = (location != NULL);

	while (moreToSearch && !found) {
		switch (item.ComparedTo(location->info)) {
		case LESS:
		case GREATER:
			location = location->next;
			moreToSearch = (location != NULL);
			break;
		case EQUAL:
			found = true;
			item = location->info;
			break;
		}
	}
	return item;
}

Error_code UnsortedType::DeleteItem(ItemType item)
// Pre:  item's key has been initialized.
//       An element in the list has a key that matches item's.
// Post: No element in the list has a key that matches item's.
		{
	if (IsEmpty())
		return Fail;
	NodeType* location = listData;
	NodeType* tempLocation;

	// Locate node to be deleted.
	if (item.ComparedTo(listData->info) == EQUAL) {
		tempLocation = location;
		listData = listData->next;		// Delete first node.
	} else {
		while (item.ComparedTo((location->next)->info) != EQUAL)
			location = location->next;

		// Delete node at location->next
		tempLocation = location->next;
		location->next = (location->next)->next;
	}
	delete tempLocation;
	length--;

	return Success;
}

void UnsortedType::ResetList()
// Post: Current position has been initialized.
{
	currentPos = NULL;
}

void UnsortedType::GetNextItem(ItemType & item)
// Post:  A copy of the next item in the list is returned.
//        When the end of the list is reached, currentPos
//        is reset to begin again.
		{
	if (currentPos == NULL)
		currentPos = listData;
	else
		currentPos = currentPos->next;
	item = currentPos->info;

}

UnsortedType::~UnsortedType()
// Post: List is empty; all items have been deallocated.
{
	NodeType* tempPtr;

	while (listData != NULL) {
		tempPtr = listData;
		listData = listData->next;
		delete tempPtr;
	}
}

bool UnsortedType::IsEmpty() {
	//Returns true if no elements in the list
	return length == 0;
}

void UnsortedType::delDuplicates() {
	NodeType *ptr1, *ptr2, *dup;
	ptr1 = listData;

	while (ptr1 != NULL && ptr1->next != NULL) {
		ptr2 = ptr1;

		while (ptr2->next != NULL) {
			if (ptr1->info.ComparedTo(ptr2->next->info) == EQUAL) {
				dup = ptr2->next;
				ptr2->next = ptr2->next->next;
				delete dup;
				length--;
			} else {
				ptr2 = ptr2->next;
			}
		}
		ptr1 = ptr1->next;
	}
}

UnsortedType operator &(const UnsortedType &list1, const UnsortedType &list2) {
	UnsortedType ans;
	UnsortedType l2;
	NodeType *p1 = list1.listData;
	l2 = list2;
	ItemType item;
	l2.ResetList();
	bool found = false;
	while (p1->next != NULL) {
		item = p1->info;
		item = l2.RetrieveItem(item, found);
		if (found) {
			ans.InsertItem(item);
		}
		p1 = p1->next;
	}
	l2.ResetList();
	return ans;
}

UnsortedType operator|(const UnsortedType &list1, const UnsortedType &list2) {
	UnsortedType ans;
	NodeType *lp1 = list1.listData;
	NodeType *lp2 = list2.listData;
	while (lp1->next != NULL) {
		ans.InsertItem(lp1->info);
		lp1 = lp1->next;
	}
	while (lp2->next != NULL) {
		ans.InsertItem(lp2->info);
		lp2 = lp2->next;
	}
	ans.delDuplicates();
	return ans;
}

UnsortedType& UnsortedType::operator=(const UnsortedType &rhs) {
	if (length != rhs.length) {
		MakeEmpty();
	}
	currentPos = NULL;
	length = rhs.length;
	NodeType *p = rhs.listData;
	while (p->next != NULL) {
		InsertItem(p->info);
		p = p->next;
	}
	return *this;
}
