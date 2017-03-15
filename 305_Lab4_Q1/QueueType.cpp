#include "QueueType.h"

QueueType::QueueType(int max) {
	count = 0;
	maxQueue = max;
	front = 0;
	rear = maxQueue - 1;
	items = new ItemType[maxQueue];
}

QueueType::QueueType(const QueueType &q) {
	if (q.maxQueue != this->maxQueue) {
		this->maxQueue = q.maxQueue;
		items = new ItemType[this->maxQueue];
	}
	this->front = q.front;
	this->count = q.count;
	this->rear = q.rear;
	for (int i = 0; i < count - 1; i++) {
		items[(front + i) % maxQueue] = q.items[(front + i) % maxQueue];
	}
}

bool QueueType::operator==(const QueueType & q) {
	if (q.count != this->count)
		return false;
	for (int i = 0; i < count - 1; i++) {
		if (q.items[(q.front + i) % q.maxQueue]
				!= items[(front + i) % maxQueue])
			return false;
	}
	return true;
}

void QueueType::MakeEmpty() {
	count = 0;
	front = 0;
	rear = maxQueue - 1;
}

bool QueueType::IsEmpty() const {
	return count == 0;
}

bool QueueType::IsFull() const {
	return count == maxQueue;
}

Error_Code QueueType::Enqueue(ItemType item) {
	if (IsFull())
		return Overflow;
	count++;
	rear = (rear + 1) % maxQueue;
	;
	items[rear] = item;
	return Success;
}

Error_Code QueueType::Dequeue(ItemType & item) {
	if (IsEmpty())
		return Underflow;
	count--;
	item = items[front];
	front = (front + 1) % maxQueue;
	return Success;
}

bool QueueType::hasItem(const ItemType& item) {
	int p = front;
	for (int i = 0; i < count; i++) {
		if (items[p] == item) {
			return true;
		}
		p = (p + 1) % maxQueue;
	}
	return false;
}

QueueType::~QueueType() {
	delete[] items;
	items = 0;
}
