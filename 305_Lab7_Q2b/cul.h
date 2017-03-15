#include <iostream>
using namespace std;

#ifndef cul_h
#define cul_h
template<class ItemType>
struct NodeType {
	ItemType info;
	NodeType* next;
};
enum ERROR_CODE {
	SUCCESS, FAIL
};
template<class ItemType>
class CircularUnsortedList {
public:
	CircularUnsortedList();     // Class constructor.
	~CircularUnsortedList();    // Class destructor.

	void InsertItem(ItemType item);
	ERROR_CODE DeleteItem(ItemType item);
	int LengthIs() const;
	void MakeEmpty();
	void RetrieveItem(ItemType& item, bool & found);
	void ResetList();
	void GetNextItem(ItemType& item, bool& end=false);
	ERROR_CODE ResetList(const ItemType & item);
	void Rotate();
	void print();

private:
	NodeType<ItemType>* listData;
	int length;
	NodeType<ItemType>* currentPos;
};
#endif
