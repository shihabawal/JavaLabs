/*
 Implementation of queue using linked structure
 */
#include <cstddef>
#include <new>
#include "queuetype.h"

QueueType::QueueType() {      // Default class constructor.
	front = NULL;
	rear = NULL;
}

QueueType::QueueType(QueueType &q) {
	front = NULL;
	rear = NULL;
	NodeType *ptr;
	ptr = q.front;
	while (ptr->next != NULL) {
		this->Enqueue(ptr->info);
		ptr = ptr->next;
	}
	this->Enqueue(ptr->info);
}

QueueType::~QueueType()     // Class destructor.
{
	MakeEmpty();

}
//Removes all items from the queue
void QueueType::MakeEmpty() {
	NodeType* tempPtr;

	while (front != NULL) {
		tempPtr = front;
		front = front->next;
		delete tempPtr;
	}
	rear = NULL;
}

//Checks if queue is empty
bool QueueType::IsEmpty() const {
	return (rear == NULL);
}
//Checks if queue is full
bool QueueType::IsFull() const {
	NodeType* location;
	try {
		location = new NodeType;
		delete location;
		return false;
	} catch (std::bad_alloc exception) {
		return true;
	}
}
/*
 Adds item from the queue pointed by rear and advances
 rear to point to the next location.
 */
Error_Code QueueType::Enqueue(ItemType newItem) {
	if (IsFull())
		return Overflow;
	else {
		NodeType* newNode;

		newNode = new NodeType;
		newNode->info = newItem;
		newNode->next = NULL;
		if (rear == NULL)
			front = newNode;
		else
			rear->next = newNode;
		rear = newNode;
	}
	return Success;
}

/*
 Removes item from the queue pointed by front and advances
 front to point to the next location
 */
Error_Code QueueType::Dequeue(ItemType & item) {
	if (IsEmpty())
		return Underflow;
	else {
		NodeType* tempPtr;
		tempPtr = front;
		item = front->info;
		front = front->next;
		if (front == NULL)
			rear = NULL;
		delete tempPtr;
	}
	return Success;
}

QueueType & QueueType::operator=(const QueueType & q) {
	this->MakeEmpty();
	front = NULL;
	rear = NULL;
	NodeType *ptr;
	ptr = q.front;
	while (ptr->next != NULL) {
		this->Enqueue(ptr->info);
		ptr = ptr->next;
	}
	this->Enqueue(ptr->info);
	return *this;
}

bool QueueType::operator==(const QueueType & q) {
	NodeType *ptrrhs, *ptrlhs;
	ptrlhs = front;
	ptrrhs = q.front;
	while (ptrrhs->next != NULL && ptrlhs->next != NULL) {
		if (ptrrhs->info != ptrlhs->info)
			return false;
		ptrrhs = ptrrhs->next;
		ptrlhs = ptrlhs->next;
	}
	if (ptrrhs->next != NULL && ptrlhs->next != NULL)
		return false;
	if (ptrrhs->info != ptrlhs->info)
		return false;
	return true;
}

bool QueueType::hasDuplicate() {
	NodeType *p, *np;
	for (p = front; p->next != NULL; p = p->next) {
		for (np = p->next; np->next != NULL; np = np->next) {
			if (p->info == np->info)
				return true;
		}
		if (p->info == np->info)
			return true;
	}
	if (p->info == np->info)
		return true;
	return false;
}

int QueueType::noOfItems() {
	int count = 0;
	NodeType *ptr;
	ptr = front;
	while (ptr->next != NULL) {
		count++;
		ptr = ptr->next;
	}
	return count;
}

void QueueType::printItems(ostream & os) {
	NodeType *ptr;
	ptr = front;
	os<<"Ticket Counter"<<endl;
	os<<"------ -------"<<endl;
	while(ptr->next != NULL){
		os<<ptr->info.getTicket_no()<<"\t"
				<<ptr->info.getCounter_no()<<endl;
		ptr = ptr->next;
	}
	os<<ptr->info.getTicket_no()<<"\t"
			<<ptr->info.getCounter_no()<<endl;
}
