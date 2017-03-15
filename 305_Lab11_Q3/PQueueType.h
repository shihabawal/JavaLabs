#ifndef q_h
#define q_h
#include <iostream>
using namespace std;
const int MAX_ITEMS = 10;
typedef int ItemType;
enum Error_code {
	Success, Overflow, Underflow, Not_found
};
class PQueueType {
public:
	PQueueType(int max = MAX_ITEMS); //PARAMETERIZED CONSTRUCTOR
	bool IsFull() const {
		return maxQueue == count;
	}
	bool IsEmpty() const {
		return count == 0;
	}
	Error_code Enqueue(ItemType item);
	Error_code Dequeue(ItemType& item);
	void printPQueueItems(ostream & out);
	int RetrieveItem(ItemType &item, int i = 0);
private:
	int count;
	int maxQueue;
	ItemType* items; // DYNAMIC ARRAY IMPLEMENTATION
	void ReheapDown(int root, int bottom);
	void ReheapUp(int root, int bottom);
};


#endif
