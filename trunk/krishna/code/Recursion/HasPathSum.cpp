#include "HasPathSum.h"

int main(int argc, char* argv[])
{
	Node<int>* head = BuildTree();

	HasPathSum<int>* path = new HasPathSum<int>();

	bool ret = path->FindPathSum(head, 7);

	std::cout << "Has Path Suma: " << ret;

	getchar();
}

