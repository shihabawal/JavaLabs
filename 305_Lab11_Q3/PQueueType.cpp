#include "PQueueType.h"
#define int ItemType

PQueueType::PQueueType(int max) {
	maxQueue = max;
	count = 0;
	items = new ItemType[maxQueue];
}

Error_code PQueueType::Enqueue(ItemType item) {
	if (IsFull())
		return Overflow;
	if (count == 0)
		items[0] = item;
	else {
		items[count] = item;
		ReheapUp(0, count);
	}
	count++;
	return Success;
}

Error_code PQueueType::Dequeue(ItemType& item) {
	int index = RetrieveItem(item);
	if (index == -1) {
		return Not_found;
	}
	items[index] = items[count - 1];
	ReheapDown(index, count);
	count--;
	return Success;
}

int PQueueType::RetrieveItem(ItemType &item, int i) { // linear traversal for retrieving
	if (item == items[i]){
		return i;
		item = items[i];
	}
	else if (i >= count)
		return -1;
	else
		return RetrieveItem(item, i + 1);
}

void PQueueType::printPQueueItems(ostream & out) {
	for (int i = 0; i < count; i++) {
		out << items[i] << " ";
	}
	out << endl;
}

void PQueueType::ReheapDown(int root, int bottom) {
	if (root >= bottom)
		return;
	if (items[root] < items[root * 2 + 1]
			|| items[root] < items[root * 2 + 2]) {

		if (items[root * 2 + 1] > items[root * 2 + 2]) { // if left child is bigger swap with left child
			int temp = items[root];
			items[root] = items[root * 2 + 1];
			items[root * 2 + 1] = temp;
			ReheapDown(root * 2 + 1, bottom);
		} else { // else swap with right child
			int temp = items[root];
			items[root] = items[root * 2 + 2];
			items[root * 2 + 2] = temp;
			ReheapDown(root * 2 + 2, bottom);
		}
	} else {
		return;
	}
}

void PQueueType::ReheapUp(int root, int bottom) {
	if (bottom == root)
		return;
	if (items[bottom] > items[(bottom - 1) / 2]) {
		int temp = items[bottom];
		items[bottom] = items[(bottom - 1) / 2];
		items[(bottom - 1) / 2] = temp;
		ReheapUp(root, (bottom - 1) / 2);
	}
}
