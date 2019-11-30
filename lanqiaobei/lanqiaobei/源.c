#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<math.h>
#include<stdlib.h>
//企业发放的奖金根据利润提成。利润低于或等于100000元的，奖金可提10%;
//利润高于100000元，低于200000元（100000<i≤200000）时，低于100000元的部分按10％提成，高于100000元的部分，可提成 7.5%;
//200000<i≤400000时，低于200000元部分仍按上述办法提成，（下同），高于200000元的部分按5％提成；
//	400000<i≤600000元时，高于400000元的部分按3％提成；600000<i≤1000000时，高于600000元的部分按1.5%提成；
//	i>1000000时，超过1000000元的部分按1%提成。从键盘输入当月利润i, 求应发奖金总数。
//int main() {
//	int i = 0;
//	scanf("%d", &i);
//	int ret = 0;
//	if (i <= 100000) {
//		ret = i * 0.1;
//		printf("%d\n", ret);
//	}
//	else if (100000 < i && i <= 200000) {
//		printf("%d\n", 100000 * 0.1 + (i - 100000) * 0.075);
//	}
//	else if (200000 < i && i <= 400000) {
//		printf("%d\n", 100000 * 0.1 + (i - 100000) * 0.075 + (i - 200000) * 0.05);
//
//	}
//	else if (400000 < i && i <= 600000) {
//		printf("%d\n", 100000 * 0.1 + (i - 100000) * 0.075 + (i - 200000) * 0.05 + (i - 400000) * 0.03);
//
//	}
//	else if (600000 < i && i <= 1000000) {
//		printf("%d\n", 100000 * 0.1 + (i - 100000) * 0.075 + (i - 200000) * 0.05 + (i - 400000) * 0.03 + (i - 600000) * 0.015);
//
//	}
//	else {
//		printf("%d\n", 100000 * 0.1 + (i - 100000) * 0.075 + (i - 200000) * 0.05 + (i - 400000) * 0.03 + (i - 600000) * 0.015 + (i - 1000000) * 0.01);
//
//	}
//	return 0;
//}


//写一函数，输入一个四位数字，要求输出这四个数字字符，但每两个数字间空格。如输入1990，应输出"1 9 9 0"。

//int main() {
//	int n = 0;
//	scanf("%d", &n);
//	int arr[4] = {0};
//	for (int i = 0; i < 4; i++) {
//		arr[i] = n % 10;
//		n /= 10;
//	}
//	for (int i = 3; i >= 0; i--) {
//		printf("%d ", arr[i]);
//	}
//	return 0;
//}


//给定两个正整数a，b（1 <= a, b <= 100000000）, 计算他们公约数的个数。
//如给定正整数8和16，他们的公约数有：1、2、4、8，所以输出为4。


//int gcd(int a, int b)
//{
//	return b == 0 ? a : gcd(b, a % b);
//}
//
//
//int main()
//{
//	int m, n, c, ans, i;
//
//	while (~scanf("%d%d", &m, &n))
//	{
//		c = gcd(m, n);
//		ans = 0;
//
//		for (i = 1; i * i < c; i++)
//			if (c % i == 0)
//				ans += 2;//由于公约数在C两边是对称分布的，所以要加上2
//
//		if (c == i * i)
//			ans += 1;//如果c = i * i，则把这个i 也要加上
//
//		printf("%d\n", ans);
//	}
//	return 0;
//
//}



//给定一个N阶矩阵A，输出A的M次幂（M是非负整数）

//int main()
//{
//	int n, m, i, j, k = 0;
//	int  a[30][30], s[30][30], c[30][30];
//	scanf("%d%d", &n, &m);
//	if (n<1 || n>30 || m<0 || m>5)
//		return 0;
//	for (i = 0; i<n; i++)
//		for (j = 0; j<n; j++)
//		{
//		scanf("%d", &a[i][j]);
//		if (a[i][j]>10 || a[i][j]<0)
//			return 0;
//		s[i][j] = a[i][j];
//		c[i][j] = 0;
//		}
//	for (m = m - 1; m>0; m--)
//	{
//		for (i = 0; i<n; i++)
//		{
//			for (j = 0; j<n; j++)
//				for (k = 0; k<n; k++)
//					c[i][j] += s[i][k] * a[k][j];
//
//		}
//		for (i = 0; i<n; i++)
//			for (j = 0; j<n; j++)
//			{
//			s[i][j] = c[i][j];
//			c[i][j] = 0;
//			}
//	}
//	for (i = 0; i<n; i++)
//	{
//		for (j = 0; j < n; j++)
//		{
//			if (j != n - 1) {
//				printf("%d ", s[i][j]);
//
//			}
//			else {
//				printf("%d", s[i][j]);
//			}
//
//
//		}
//		printf("\n");
//	}
//	return 0;
//}





#define LEN sizeof(struct student)
struct student
{
	int num;
	int score;
	struct student *next;
};
struct student *create()
{
	struct student *head = NULL, *p1, *p2;
	int n = 0;
	p1 = p2 = (struct student *)malloc(LEN);

	scanf("%d %d", &p1->num, &p1->score);
	while (p1->num != 0)
	{
		n = n + 1;
		if (n == 1)
			head = p1;
		else
			p2->next = p1;
		p2 = p1;
		p1 = (struct student *)malloc(LEN);
		scanf("%d %d", &p1->num, &p1->score);
	}
	p2->next = NULL;
	return head;
}
void print(struct student *head)
{
	struct student *p;
	p = head;

	while (p != NULL)
	{
		printf("%d %d\n", p->num, p->score);
		p = p->next;
	}
	printf("\n");
}
int main()
{
	struct student *head_a, *head_b, *p1, *p2, *p3;
	int num0;
	int score0;
	head_a = create();
	head_b = create();
	p1 = head_a;
	while (p1->next != NULL)
		p1 = p1->next;
	p1->next = head_b;	
	for (p1 = head_a; p1->next != NULL; p1 = p1->next) 	
	{
		p3 = p1;
		for (p2 = p1->next; p2 != NULL; p2 = p2->next)
			if (p3->num>p2->num)
				p3 = p2;
		if (p1 != p3)
		{
			num0 = p1->num;
			p1->num = p3->num;
			p3->num = num0;
			score0 = p1->score;
			p1->score = p3->score;
			p3->score = score0;
		}
	}
	print(head_a);
	return 0;
}
