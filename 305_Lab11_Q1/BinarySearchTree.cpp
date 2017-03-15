#include "BinarySearchTree.h"
#include "Queue.h"
#include "Queue.cpp"

template<class T>
struct TreeNode {
	T info;
	TreeNode<T>* left;
	TreeNode<T>* right;
};

template<class T>
bool BinarySearchTree<T>::IsFull() const
// Returns true if the free store has no room for another node
//  and false otherwise.
{
	TreeNode<T> *location;
	try {
		location = new TreeNode<T>;
		delete location;
		return false;
	} catch (std::bad_alloc exception) {
		return true;
	}
}

template<class T>
bool BinarySearchTree<T>::IsEmpty() const
// Returns true if the tree is empty and false otherwise.
{
	return root == NULL;
}

template<class T>
int BinarySearchTree<T>::LengthIs() const
// Calls the recursive function CountNodes to count the
//  nodes in the tree.
{
	return CountNodes(root);
}

template<class T>
int CountNodes(TreeNode<T>* tree)
// Post: Returns the number of nodes in the tree.
		{
	if (tree == NULL)
		return 0;
	else
		return CountNodes(tree->left) + CountNodes(tree->right) + 1;
}

template<class T>
void BinarySearchTree<T>::RetrieveItem(T& item, bool& found) const
// Calls recursive function Retrieve to search the tree for item.
		{
	Retrieve(root, item, found);
}

template<class T>
void Retrieve(TreeNode<T>* tree, T& item, bool& found)
// Recursively searches tree for item.
// Post: If there is an element someItem whose key matches item's,
//       found is true and item is set to a copy of someItem;
//       otherwise, found is false and item is unchanged.
		{
	if (tree == NULL)
		found = false;                      // item is not found.
	else if (item < tree->info)
		Retrieve(tree->left, item, found); // Search left subtree.
	else if (item > tree->info)
		Retrieve(tree->right, item, found); // Search right subtree.
	else {
		item = tree->info;                 // item is found.
		found = true;
	}
}

template<class T>
void BinarySearchTree<T>::InsertItem(T item)
// Calls the recursive function Insert to insert item into tree.
		{
	Insert(root, item);
}

template<class T>
void Insert(TreeNode<T>*& tree, T item)
// Inserts item into tree.
// Post: item is in tree; search property is maintained.
		{
	if (tree == NULL) {                 // Insertion place found.
		tree = new TreeNode<T>;
		tree->right = NULL;
		tree->left = NULL;
		tree->info = item;
	} else if (item < tree->info)
		Insert(tree->left, item);     // Insert in left subtree.
	else
		Insert(tree->right, item);    // Insert in right subtree.
}

template<class T>
void BinarySearchTree<T>::DeleteItem(T item)
// Calls the recursive function Delete to delete item from tree.
		{
	Delete(root, item);
}

template<class T>
void Delete(TreeNode<T>*& tree, T item)
// Deletes item from tree.
// Post:  item is not in tree.
		{
	if (item < tree->info)
		Delete(tree->left, item);    // Look in left subtree.
	else if (item > tree->info)
		Delete(tree->right, item);   // Look in right subtree.
	else
		DeleteNode(tree);            // Node found; call DeleteNode.
}

template<class T>
void DeleteNode(TreeNode<T>*& tree)
// Deletes the node pointed to by tree.
// Post: The user's data in the node pointed to by tree is no
//       longer in the tree.  If tree is a leaf node or has only one
//       non-NULL child pointer, the node pointed to by tree is
//       deleted; otherwise, the user's data is replaced by its
//       logical predecessor and the predecessor's node is deleted.
		{
	T data;
	TreeNode<T>* tempPtr;

	tempPtr = tree;
	if (tree->left == NULL) {
		tree = tree->right;
		delete tempPtr;
	} else if (tree->right == NULL) {
		tree = tree->left;
		delete tempPtr;
	} else {
		GetPredecessor(tree->left, data);
		tree->info = data;
		Delete(tree->left, data);  // Delete predecessor node.
	}
}

template<class T>
void GetPredecessor(TreeNode<T>* tree, T& data)
// Sets data to the info member of the rightmost node in tree.
		{
	while (tree->right != NULL)
		tree = tree->right;
	data = tree->info;
}

template<class T>
BinarySearchTree<T>::BinarySearchTree() {
	root = NULL;
}

template<class T>
BinarySearchTree<T>::~BinarySearchTree()
// Calls recursive function Destroy to destroy the tree.
{
	Destroy(root);
}

template<class T>
void Destroy(TreeNode<T>*& tree)
// Post: tree is empty; nodes have been deallocated.
		{
	if (tree != NULL) {
		Destroy(tree->left);
		Destroy(tree->right);
		delete tree;
	}
}

template<class T>
BinarySearchTree<T>::BinarySearchTree(const BinarySearchTree<T>& originalTree)
// Calls the recursive function CopyTree to copy originalTree
//  into root.
		{
	CopyTree(root, originalTree.root);
}

template<class T>
void BinarySearchTree<T>::operator=(const BinarySearchTree<T>& originalTree)
// Calls the recursive function CopyTree to copy originalTree
// into root.
		{
	{
		if (&originalTree == this)
			return;              // Ignore assigning self to self.
		Destroy(root);         // Deallocate existing tree nodes.
		CopyTree(root, originalTree.root);
	}
}

template<class T>
void CopyTree(TreeNode<T>*& copy, const TreeNode<T>* originalTree)
// Post: copy is the root of a tree that is a duplicate
//       of originalTree.
		{
	if (originalTree == NULL)
		copy = NULL;
	else {
		copy = new TreeNode<T>;
		copy->info = originalTree->info;
		CopyTree(copy->left, originalTree->left);
		CopyTree(copy->right, originalTree->right);
	}
}

template<class T>
void BinarySearchTree<T>::ResetTree(OrderType order)
// Calls a function to create a queue of the tree elements in
// the desired order.
		{
	switch (order) {
	case PRE_ORDER:
		PreOrder(root, preQue);
		break;
	case IN_ORDER:
		InOrder(root, inQue);
		break;
	case POST_ORDER:
		PostOrder(root, postQue);
		break;
	}
}

template<class T>
void PreOrder(TreeNode<T>* tree, Queue<T>& preQue)
// Post: preQue contains the tree items in preorder.
		{
	if (tree != NULL) {
		preQue.Enqueue(tree->info);
		PreOrder(tree->left, preQue);
		PreOrder(tree->right, preQue);
	}
}

template<class T>
void InOrder(TreeNode<T>* tree, Queue<T>& inQue)
// Post: inQue contains the tree items in inorder.
		{
	if (tree != NULL) {
		InOrder(tree->left, inQue);
		inQue.Enqueue(tree->info);
		InOrder(tree->right, inQue);
	}
}

template<class T>
void PostOrder(TreeNode<T>* tree, Queue<T>& postQue)
// Post: postQue contains the tree items in postorder.
		{
	if (tree != NULL) {
		PostOrder(tree->left, postQue);
		PostOrder(tree->right, postQue);
		postQue.Enqueue(tree->info);
	}
}

template<class T>
void BinarySearchTree<T>::GetNextItem(T& item, OrderType order, bool& finished)
// Returns the next item in the desired order.
// Post: For the desired order, item is the next item in the queue.
//       If item is the last one in the queue, finished is true;
//       otherwise, finished is false.
		{
	finished = false;
	switch (order) {
	case PRE_ORDER:
		preQue.Dequeue(item);
		if (preQue.IsEmpty())
			finished = true;
		break;
	case IN_ORDER:
		inQue.Dequeue(item);
		if (inQue.IsEmpty())
			finished = true;
		break;
	case POST_ORDER:
		postQue.Dequeue(item);
		if (postQue.IsEmpty())
			finished = true;
		break;
	}
}

template<class T>
void PrintTree(TreeNode<T>* tree, std::ostream& outFile, OrderType order)
// Prints info member of items in tree in sorted order on outFile.
		{
	switch (order) {
	case PRE_ORDER:
		if (tree != NULL) {
			outFile << tree->info;
			PrintTree(tree->left, outFile, order);   // Print left subtree.
			PrintTree(tree->right, outFile, order);  // Print right subtree.
		}
		break;
	case IN_ORDER:
		if (tree != NULL) {

			PrintTree(tree->left, outFile, order);   // Print left subtree.
			outFile << tree->info;
			PrintTree(tree->right, outFile, order);  // Print right subtree.
		}
		break;
	case POST_ORDER:
		if (tree != NULL) {

			PrintTree(tree->left, outFile, order);   // Print left subtree.
			PrintTree(tree->right, outFile, order);  // Print right subtree.
			outFile << tree->info;
		}
		break;
	default:
		;
	}

}

template<class T>
void BinarySearchTree<T>::Print(std::ostream& outFile, OrderType order) const
// Calls recursive function Print to print items in the tree.
		{
	PrintTree(root, outFile, order);
	outFile << endl;
}

template<class T>
int BinarySearchTree<T>::countMaxDepth() {
	return maxDepth(root) - 1;
}

template<class T>
int maxDepth(TreeNode<T>* tree) {
	if (tree == NULL)
		return 0;
	else {
		int lDepth = maxDepth(tree->left);
		int rDepth = maxDepth(tree->right);
		if (lDepth > rDepth)
			return lDepth + 1;
		else
			return rDepth + 1;
	}

}

template<class T>
void BinarySearchTree<T>::arrayBST(T * a) {
	arrayBSTHelper(root, a, 0);
}

template<class T>
void arrayBSTHelper(TreeNode<T>* t, T * a, int i) {
	if (t != NULL) {
		a[i] = t->info;
		arrayBSTHelper(t->left, a, (2 * i) + 1);
		arrayBSTHelper(t->right, a, (2 * i) + 2);
	}
}

template<class T>
bool BinarySearchTree<T>::isComplete() {
	return isCompleteHelper(root, LengthIs(), 0);
}

template<class T>
bool isCompleteHelper(TreeNode<T>* t, int length, int i) {
	if (t == NULL)
		return true;
	if (i >= length)
		return false;
	return (isCompleteHelper(t->left, length, (2 * i) + 1)
			&& isCompleteHelper(t->right, length, (2 * i) + 2));
}
