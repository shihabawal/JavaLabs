#ifndef q_h
#define q_h
const int MAX_ITEMS = 10;
typedef int ItemType;
enum Error_Code {
	Success, Overflow, Underflow
};
class QueueType {
public:
	QueueType(int max = MAX_ITEMS); //PARAMETERIZED CONSTRUCTOR

	void MakeEmpty();
	bool IsFull() const;
	bool IsEmpty() const;
	Error_Code Enqueue(ItemType item);
	Error_Code Dequeue(ItemType& item);
	QueueType(const QueueType & q);
	bool operator==(const QueueType & q);
	bool hasItem(const ItemType& item);
	~QueueType();

private:
	int count;
	int front, rear;
	int maxQueue;
	ItemType* items; // DYNAMIC ARRAY IMPLEMENTATION
};
#endif
