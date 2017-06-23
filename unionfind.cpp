#include <iostream>
#include <Windows.h>
#include <stdlib.h>
#include <vector>
#include <string.h>

using namespace std;

int* list;
int* level;


int find(int n);
void merge(int a, int b);

int main() {

	int eleNum = 0;
	int opNum = 0;

	scanf("%d %d", &eleNum, &opNum);

	 list = (int*)malloc(sizeof(int)*( eleNum+1 ));
	 level = (int*)malloc(sizeof(int)*(eleNum + 1));

	for (int i = 0; i < eleNum + 1; i++) {
		list[i] = i;
		level[i] = 1;
	}//초기화 작업
	
	
	for (int i = 0; i < opNum; i++) {
		int ck = 0;
		int ele1=0, ele2 = 0;

		scanf("%d %d %d", &ck, &ele1, &ele2);

		if (ck == 0) {
			merge(ele1, ele2);
		}
		else if (ck == 1) {
			if (find(ele1) == find(ele2)) {
				printf("YES\n");
			}
			else
				printf("NO\n");

		}

	}
	//각각의 idx 는 각 원소들의 맨첨음 위치를 의미한다. 서로소 집합이므로...
	
	
	

	free(list);
	free(level);



	system("pause");
}

int find(int n) {

	if (list[n] == n)
		return n;
	else
		list[n] = find(list[n]);
		return list[n];
}

void merge(int a, int b) {

	int x = find(a);
	int y = find(b);

	if (x == y) {
		return;
	}

	if (level[x] > level[y])
		swap(x, y);
	list[x] = y;

	if (level[x] == level[y])
		++level[y];
}
