#pragma once
#include "MyList.h"

template <class T>
class PrintAncestorBinaryTree
{
private: 
	IList<T>* s;
	void printQueue();

public:
	T value;
	Node<T>* Head;
	PrintAncestorBinaryTree(T val);
	~PrintAncestorBinaryTree();
	bool PrintAncestor(Node<T>* node);
	bool PrintAncestorOptimized(Node<T>* node);
};


template <class T>
PrintAncestorBinaryTree<T>::PrintAncestorBinaryTree(T val)
{
	value = val;
	s = new Stack<T>();
	Head = nullptr;
}

template <class T>
PrintAncestorBinaryTree<T>::~PrintAncestorBinaryTree()
{
}

template <class T>
bool PrintAncestorBinaryTree<T>::PrintAncestor(Node<T>* node)
{
	if(node == nullptr)
		return false;

	s->insert(node->item);

	bool ret = PrintAncestor(node->left);
	if(ret)
		s->top();

	if(node->item == value && !s->IsEmpty())
	{
		s->top();
		printQueue();
	}

	ret = PrintAncestor(node->right);
	if(ret)
		s->top();

	if(node->item == value && !s->IsEmpty())
	{
		s->top();
		printQueue();
	}

	return true;
}

template <class T>
void PrintAncestorBinaryTree<T>::printQueue()
{
	while(!s->IsEmpty())
	{
		std::cout << s->top() << " ";
	}
}

template <class T>
bool PrintAncestorBinaryTree<T>::PrintAncestorOptimized(Node<T>* node)
{
	// base case
	if(node == nullptr)
	{
		return false;
	}

	// value matched
	if(node->item == value)
	{
		return true;
	}

	bool ret = PrintAncestorOptimized(node->left);
	if(ret)
	{
		std::cout << node->item << " ";
		return true;
	}

	ret = PrintAncestorOptimized(node->right);
	if(ret)
	{
		std::cout << node->item << " ";
		return true;
	}
	return ret;
}
