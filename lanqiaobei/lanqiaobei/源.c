#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<math.h>
#include<stdlib.h>
//��ҵ���ŵĽ������������ɡ�������ڻ����100000Ԫ�ģ��������10%;
//�������100000Ԫ������200000Ԫ��100000<i��200000��ʱ������100000Ԫ�Ĳ��ְ�10����ɣ�����100000Ԫ�Ĳ��֣������ 7.5%;
//200000<i��400000ʱ������200000Ԫ�����԰������취��ɣ�����ͬ��������200000Ԫ�Ĳ��ְ�5����ɣ�
//	400000<i��600000Ԫʱ������400000Ԫ�Ĳ��ְ�3����ɣ�600000<i��1000000ʱ������600000Ԫ�Ĳ��ְ�1.5%��ɣ�
//	i>1000000ʱ������1000000Ԫ�Ĳ��ְ�1%��ɡ��Ӽ������뵱������i, ��Ӧ������������
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


//дһ����������һ����λ���֣�Ҫ��������ĸ������ַ�����ÿ�������ּ�ո�������1990��Ӧ���"1 9 9 0"��

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


//��������������a��b��1 <= a, b <= 100000000��, �������ǹ�Լ���ĸ�����
//�����������8��16�����ǵĹ�Լ���У�1��2��4��8���������Ϊ4��


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
//				ans += 2;//���ڹ�Լ����C�����ǶԳƷֲ��ģ�����Ҫ����2
//
//		if (c == i * i)
//			ans += 1;//���c = i * i��������i ҲҪ����
//
//		printf("%d\n", ans);
//	}
//	return 0;
//
//}



//����һ��N�׾���A�����A��M���ݣ�M�ǷǸ�������

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
