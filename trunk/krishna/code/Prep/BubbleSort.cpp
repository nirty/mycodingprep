//#include <stdio.h>
//
//int* createArray(int len)
//{
//	int* arr = new int[len];
//	for(int i=0; i < len; ++i)
//	{
//		arr[i] = len-i;
//	}
//
//	return arr;
//}
//
//void swap(int* a, int* b)
//{
//	int t = *a;
//	*a = *b;
//	*b = t;
//}
//
//void printArray(int* arr, int len)
//{
//	printf("\n\n");
//	for(int i=0; i < len; ++i)
//	{
//		printf("%d ", arr[i]);
//	}
//}
//
//void bubbleSort(int* array, int len)
//{
//	bool noSwap = false;
//	int index = len-1;
//
//	while(!noSwap)
//	{
//		noSwap = true;
//		for(int i=0; i < index; ++i)
//		{
//			if(array[i] > array[i+1])
//			{
//				swap(array + i, array + (i+1));
//				noSwap = false;
//			}
//		}
//	}
//}
//
//void main(int argc, char* argv[])
//{
//	int len = 5;
//	int* bubble = createArray(len);
//
//	printArray(bubble, len);
//	bubbleSort(bubble, len);
//	printArray(bubble, len);
//
//	getchar();
//
//}