#pragma once
#include "MyList.h"

template <class T>
class HasPathSum
{
public:
	HasPathSum();
	~HasPathSum();
	bool FindPathSum(Node<T>* node, T value);
};

template <class T>
HasPathSum<T>::HasPathSum()
{
}

template <class T>
HasPathSum<T>::~HasPathSum()
{
}

template <class T>
bool HasPathSum<T>::FindPathSum(Node<T>* node, T value)
{
	// handle base case
	if(node == nullptr)
		return false;

	// the tree has path sum, so return true
	if(node != nullptr && node->left == nullptr && node->right == nullptr && value == 0)
		return true;

	T currentValue = value - node->item;

	bool left = FindPathSum(node->left, currentValue);
	bool right = FindPathSum(node->right, currentValue);

	return left || right;
}
