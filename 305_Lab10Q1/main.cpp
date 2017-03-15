#include <iostream>
#include <fstream>
#include "student.h"
#include "BinarySearchTree.h"
#include "BinarySearchTree.cpp"

using namespace std;
int main()
{
	BinarySearchTree<int> b;
	cout<<b.singleChildCount();
	return 0;
}
