#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<assert.h>
#include<string.h>


#if 0
//1.
//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
//示例 :
//给定 nums = [2, 7, 11, 15], target = 9
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回[0, 1]
int* twoSum(int* nums, int numsSize, int target, int* returnSize)
{
	int i = 0;
	int j = 0;
	for (i = 0; i < numsSize; i++)
	{
		for (j = i + 1; j < numsSize; j++)
		{
			if ((nums[i] + nums[j]) == target)
			{
				returnSize[0] = i;
				returnSize[1] = j;
				return returnSize;
			}
		}
	}
}

int main()
{
	int i = 0;
	int a[2] = { 0 };
	int nums[] = { 2, 7, 11, 15 };
	int target = 9;
	int sz = sizeof(nums) / sizeof(nums[0]);
	twoSum(nums, sz, target, a);
	for (i = 0; i < 2; i++)
	{
		printf("%d ", a[i]);
	}
	printf("\n");
	system("pause");
	return 0;
}

#endif

//771.给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
//
//J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
//
//示例 1:
//
//输入 : J = "aA", S = "aAAbbbb"
//输出 : 3
//

#if 0
int numJewelsInStones(char * J, char * S)
{
	int count = 0;
	char *p = J;
	char *q = S;
	while (*p != '\0'){
		q = S;
		while (*q != '\0'){
			if (*p == *q){
				count++;
			}
			q++;
		}
		p++;
	}
	return count;
}
int main()
{
	char arr1[] = "aA";
	char arr2[] = "aAAbbbn";
	printf("%d\n", numJewelsInStones(arr1, arr2));
	return 0;
}

#endif
//1108.给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
//
//所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
//
//
//
//示例 1：
//
//输入：address = "1.1.1.1"
//输出："1[.]1[.]1[.]1"


#if 0

char * defangIPaddr(char * address){
	assert(address != NULL);
	int count = 0;
	char *p = address;
	char *q = NULL;
	while (*p++ != '\0'){
		if (*p == '.'){
			count++;
		}
	}
	q = p + count * 2;
	while (q != p){
		if (*p != '.'){
			*q-- = *p--;
		}
		else{
			p--;
			*q-- = ']';
			*q-- = '.';
			*q-- = '[';
		}
	}
	return address;
}

int main(){
	char arr[50] = "1.1.1.1";
	printf("%s\n", defangIPaddr(arr));
	return 0;
}


#endif


//237.请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
//
//现有一个链表 -- head = [4,5,1,9]，它可以表示为:
//
//示例 1:
//输入 : head = [4, 5, 1, 9], node = 5
//输出 : [4, 1, 9]
// 解释 : 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.

#if 0
void deleteNode(struct ListNode* node) {
	node->val = node->next->val;
	node->next = node->next->next;

}


#endif

#if 0



#endif