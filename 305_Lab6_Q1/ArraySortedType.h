//ArraySortedType.h

#ifndef ArraySortedType_H
#define ArraySortedType_H

#include <iostream>
#include <string>
using namespace std;
typedef int ItemType;

enum Error_code {
	Success, Fail, Not_found
};

/*Define the class ArraySortedType with  essential
 member variables and member functions.
 */
class ArraySortedType {
public:
	ArraySortedType(int max_items = 100);
	ArraySortedType(const ArraySortedType & ust);
	~ArraySortedType();
	void ResetList();
	bool IsFull() const;
	bool IsEmpty() const;
	int LengthIs() const;
	Error_code GetNextItem(ItemType&);
	ArraySortedType& operator=(const ArraySortedType & ust);
	bool operator==(const ArraySortedType & ust);
	int size();
	void printAllItems();

	Error_code InsertItem(ItemType & item);
	Error_code DeleteItem(ItemType & item);
	Error_code RetrieveItem (ItemType & item , bool & found);
	Error_code DeleteItemsInRange(ItemType startKey, ItemType endKey);
	ArraySortedType RetrieveItemsInRange(ItemType startKey, ItemType endKey);

private:
	int length;
	ItemType * info;
	int currentPos;
	int MAX_ITEMS;

};
#endif
