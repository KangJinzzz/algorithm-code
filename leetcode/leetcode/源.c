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

int* twoSum(int* nums, int numsSize, int target, int* returnSize){
	*returnSize = 0;
	for (int i = 0; i<numsSize; i++){
		for (int j = i + 1; j<numsSize; j++){
			if (nums[i] + nums[j] == target){
				int* ret = (int*)malloc(2 * sizeof(int));
				if (ret == NULL)
					return NULL;
				*returnSize = 2;
				ret[0] = i;
				ret[1] = j;
				return ret;
			}
		}
	}
	return NULL;
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
//709.实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
//示例 1：
//
//输入 : "Hello"
//出 : "hello"
#if 0

char * toLowerCase(char * str){
	assert(str != NULL);
	char *p = str;
	while (*p != '\0')
	{
		if (*p >= 'A' && *p <= 'Z')
		{
			*p = *p + 32;
		}
		p++;
	}
	return str;
}

int main()
{
	char str[] = "Hello";
	printf("%s\n", toLowerCase(str));
	return 0;
}

#endif

//国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。
//
//	为了方便，所有26个英文字母对应摩尔斯密码表如下：
//
//	[".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."]
//	给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。例如，"cab" 可以写成 "-.-..--..."，(即 "-.-." + "-..." + ".-"字符串的结合)。我们将这样一个连接过程称作单词翻译。
//
//		返回我们可以获得所有词不同单词翻译的数量。
//
//	例如 :
//输入 : words = ["gin", "zen", "gig", "msg"]
//输出 : 2
//	解释 :
//各单词翻译如下 :
//		"gin" -> "--...-."
//		"zen" -> "--...-."
//		"gig" -> "--...--."
//		"msg" -> "--...--."
// 2 种不同翻译, "--...-." 和 "--...--.".
#if 0

int uniqueMorseRepresentations(char ** words, int wordsSize){

}

int main()
{

	return 0;
}
#endif

//26.给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
//
//不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
//
//示例 1 :
//
//给定数组 nums = [1, 1, 2],
//
//函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
//
//你不需要考虑数组中超出新长度后面的元素。

#if 0

int removeDuplicates(int* nums, int numsSize){
	//if (numsSize == 0)
	//{
	//	return false;   //重要！！！
	//}
	int flag = nums[0];
	int count = 1;
	int i = 0;
	for (i = 0; i < numsSize; i++)
	{
		if (flag != nums[i])
		{
			nums[count++] = nums[i];
			flag = nums[i];
		}
	}
	return count;
	//int *p = nums;
	//int *q_head = nums;
	//int *q_end = nums;
	//int sz = numsSize;
	//while (*q_end != nums[numsSize])
	//{
	//	while (*q_head == *q_end)
	//	{
	//		q_end++;
	//		sz--;
	//	}
	//	sz++;
	//	p++;
	//	*p = *q_end;
	//	q_head = q_end;
	//}
	//p++;
	//*p = *q_end;
	//return sz;

}


int main()
{
	int arr[] = { 0,0,1,1, 1, 2 , 2, 3 ,3 , 4};
	int sz = sizeof(arr) / sizeof(arr[0]);
	int ret = removeDuplicates(arr, sz);
	printf("%d\n", ret);
	int i = 0;
	for (i = 0; i < ret; i++)
	{
		printf("%d", arr[i]);
	}
	printf("\n");
	return 0;
}
#endif

//27.给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
//
//不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
//
//元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
//
//示例 1:
//
//给定 nums = [3, 2, 2, 3], val = 3,
//
//函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
//
//你不需要考虑数组中超出新长度后面的元素。


#if 0

int removeElement(int* nums, int numsSize, int val){
	if (numsSize == 0)
	{
		return 0;
	}
	int i = 0;
	int k = 0;
	for (i = 0; i < numsSize; i++)
	{
		if (nums[i] != val)
		{
			nums[k++] = nums[i];
		}
	}
	return k;
}


int main()
{
	int arr[] = { 3, 2, 2, 3 };
	int sz = sizeof(arr) / sizeof(arr[0]);
	int ret = removeElement(arr, sz, 3);
	printf("%d\n", ret);
	int i = 0;
	for (i = 0; i < ret; i++)
	{
		printf("%d", arr[i]);
	}
	printf("\n");
	return 0;
}
#endif

//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
//你可以假设数组中无重复元素。
//
//示例 1:
//
//输入 : [1, 3, 5, 6], 5
//输出 : 2

#if 0
int searchInsert(int* nums, int numsSize, int target){
	//if (numsSize == 0)
	//{
	//	return false;
	//}
	int i = 0;
	int flag = 0;
	for (i = 0; i < numsSize; i++)
	{
		if (nums[i] == target)
		{
			return i;
		}
		if (target < nums[i])
		{
			return i;
		}
	}
	return numsSize;

}

int main()
{
	int arr[] = { 1, 3, 5, 6 };
	int sz = sizeof(arr) / sizeof(arr[0]);
	int ret = searchInsert(arr, sz, 7);
	printf("%d\n", ret);
	return 0;

}
#endif

//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//示例 :
//
//输入 : [-2, 1, -3, 4, -1, 2, 1, -5, 4],
//输出 : 6
// 解释 : 连续子数组 [4, -1, 2, 1] 的和最大，为 6。

int maxSubArray(int* nums, int numsSize){
	//if (numsSize == 0)
	//{
	//	return false;
	//}
	int sum = 0;
	int i = 0;
	int max = nums[0];
	for (i = 0; i < numsSize; i++)
	{
		if (sum < 0)
		{
			sum = nums[i];
		}
		else
		{
			sum += nums[i];
		}
		if (max < sum)
		{
			max = sum;
		}
	}
	return max;
	
}

#if 1


int main()
{
	int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
	int sz = sizeof(arr) / sizeof(arr[0]);
	int ret = maxSubArray(arr, sz);
	printf("%d\n", ret);

	return 0;
}
#endif





