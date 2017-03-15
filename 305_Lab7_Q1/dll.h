#ifndef dll_h
#define dll_h
#include <iostream>
using namespace std;
template<class ItemType>
struct NodeType {
	ItemType info;
	NodeType* next;
	NodeType* back;
};
template<class ItemType>
class DoublyLinkedList {
public:
	DoublyLinkedList();     // Class constructor.
	~DoublyLinkedList();    // Class destructor.

	////////// implement these functions //////////
	DoublyLinkedList(DoublyLinkedList<ItemType>& rhs);
	void InsertItem(ItemType item);
	void DeleteItem(ItemType item);
	void print();
	void reverseDoublyLinkedList();

	void ResetList(const ItemType & item);
	void Rotate ();

	void FindItem(NodeType<ItemType>* listData, ItemType item,
			NodeType<ItemType>*& location, bool& found);
	int LengthIs() const;
	void MakeEmpty();
	void RetrieveItem(ItemType& item, bool& found);
	void ResetList();
	void GetNextItem(ItemType& item, bool &end = false);

private:
	NodeType<ItemType>* listData;
	int length;
	NodeType<ItemType>* currentPos;
};
#endif
