#ifndef BinarySearchTree_H
#define BinarySearchTree_H

#include <iostream>
#include "Queue.h"
#include <cmath>
using namespace std;

template<class T>
struct TreeNode;

enum OrderType {
	PRE_ORDER, IN_ORDER, POST_ORDER
};

template<class T>
class BinarySearchTree {
public:
	BinarySearchTree();                     // Constructor.
	~BinarySearchTree();                    // Destructor.
	BinarySearchTree(const BinarySearchTree& originalTree); // Copy constructor.
	void operator=(const BinarySearchTree& originalTree);
	void MakeEmpty();
	bool IsEmpty() const;
	bool IsFull() const;
	int LengthIs() const;
	void RetrieveItem(T& item, bool& found) const;
	void InsertItem(T item);
	void DeleteItem(T item);
	void ResetTree(OrderType order);
	void GetNextItem(T& item, OrderType order, bool& finished);
	void Print(std::ostream& outFile, OrderType order) const;
	int countMaxDepth();
	void arrayBST(T * a);
	bool isComplete();

private:
	TreeNode<T>* root;
	Queue<T> preQue;
	Queue<T> inQue;
	Queue<T> postQue;

};

template<class T>
int CountNodes(TreeNode<T>* tree);

template<class T>
void GetPredecessor(TreeNode<T>* tree, T& data);

template<class T>
void Destroy(TreeNode<T>*& tree);

template<class T>
void CopyTree(TreeNode<T>*& copy, const TreeNode<T>* originalTree);

template<class T>
void PreOrder(TreeNode<T>*, Queue<T>&);

template<class T>
void InOrder(TreeNode<T>*, Queue<T>&);

template<class T>
void PostOrder(TreeNode<T>*, Queue<T>&);

template<class T>
void PrintTree(TreeNode<T>* tree, std::ostream& outFile);

template<class T>
int maxDepth(TreeNode<T>* tree);

template<class T>
void arrayBSTHelper(TreeNode<T>* t, T * a, int i);

template<class T>
bool isCompleteHelper(TreeNode<T>* t, int length, int i);

#endif
