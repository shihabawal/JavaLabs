/*
 Define the queue class that implements the queue using
 linked structure
 */
#ifndef QueueType_H
#define QueueType_H

#include <iostream>
#include <string>
#include "Ticket.h"
using namespace std;
typedef Ticket ItemType;
enum Error_Code {
	Success, Overflow, Underflow
};

struct NodeType {
	ItemType info;
	NodeType* next;
};

class QueueType {
public:
	QueueType(int max);
	QueueType();
	QueueType(QueueType &q);
	~QueueType();
	void MakeEmpty();
	bool IsEmpty() const;
	bool IsFull() const;
	Error_Code Enqueue(ItemType newItem);
	Error_Code Dequeue(ItemType & item);
	QueueType(const QueueType & q);
	QueueType & operator=(const QueueType & q);
	bool operator==(const QueueType & q);
	int countItem(const ItemType& item); //Utility functions
	bool hasDuplicate(); //Utility functions
	int noOfItems(); //Utility Functions
	void printItems(ostream & os); //Utility Function

private:
	NodeType* front;
	NodeType* rear;
};

#endif

