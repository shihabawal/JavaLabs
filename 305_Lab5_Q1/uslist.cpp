// Implementation file for Unsorted.h

#include "uslist.h"

UnsortedType::UnsortedType(int maxItems) {
	currentPos = -1;
	length = 0;
	MAX_ITEMS = maxItems;
	info = new ItemType[MAX_ITEMS];
}
bool UnsortedType::IsFull() const {
	return (length == MAX_ITEMS);
}
int UnsortedType::GetLength() const {
	return length;
}

ItemType UnsortedType::RetrieveItem(ItemType item, bool& found)
// Pre:  Key member(s) of item is initialized.
// Post: If found, item's key matches an element's key in the
//       list and a copy of that element has been returned;
//       otherwise, item is returned.
		{
	bool moreToSearch;
	int location = 0;
	found = false;

	moreToSearch = (location < length);

	while (moreToSearch && !found) {
		switch (item.ComparedTo(info[location])) {
		case LESS:
		case GREATER:
			location++;
			moreToSearch = (location < length);
			break;
		case EQUAL:
			found = true;
			item = info[location];
			break;
		}
	}
	return item;
}
void UnsortedType::MakeEmpty()
// Post: list is empty.
{
	length = 0;
}
Error_code UnsortedType::InsertItem(ItemType item)
// Post: item is in the list.
		{
	if (IsFull())
		return Fail;
	info[length] = item;
	length++;
	return Success;
}
Error_code UnsortedType::DeleteItem(ItemType item)
// Pre:  item's key has been initialized.
//       An element in the list has a key that matches item's.
// Post: No element in the list has a key that matches item's.
		{
	int location = 0;

	while (item.ComparedTo(info[location]) != EQUAL)
		location++;
	if (location == length)
		return Fail;

	info[location] = info[length - 1];
	length--;
	return Success;
}
void UnsortedType::ResetList()
// Post: currentPos has been initialized.
{
	currentPos = -1;
}

ItemType UnsortedType::GetNextItem()
// Pre:  ResetList was called to initialized iteration.
//       No transformer has been executed since last call.
//       currentPos is defined.
// Post: item is current item.
//       Current position has been updated.
{
	currentPos++;
	return info[currentPos];
}

Error_code UnsortedType::Resize(int increaseSize) {
	if (increaseSize < length + 1 || increaseSize > MAX_ITEMS) {
		return Fail;
	}
	ItemType temp[length];
	for (int i = 0; i <= length; i++) {
		temp[i] = this->info[i];
	}
	delete[] info;
	info = new ItemType[increaseSize];
	for (int i = 0; i <= length; i++) {
		this->info[i] = temp[i];
	}
	return Success;
}

UnsortedType UnsortedType::operator=(const UnsortedType rhs) {
	if (this->length != rhs.length) {
		delete[] info;
		info = new ItemType[rhs.length];
	}
	this->MAX_ITEMS = rhs.MAX_ITEMS;
	this->currentPos = rhs.currentPos;
	this->length = rhs.length;
	for (int i = 0; i <= length; i++) {
		this->info[i] = rhs.info[i];
	}
	return *this;
}
