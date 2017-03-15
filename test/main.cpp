#include <iostream>
using namespace std;
#define SIZE 4

struct NodeType{
	int info;
	NodeType *next;
};

int BSum (NodeType *node){
	int sum=0;
	NodeType *n = node;
	if (n == NULL)
		return 0;
	while (n->next != NULL){
		sum += n->info;
		n=n->next;
	}
	return sum;
}

int TSum (NodeType *node, int sum=0){
	NodeType *p = node;
	if (p == NULL){
		return sum;
	}
	else{
		sum += p->info;
		return TSum(p->next,sum);
	}
}

double TAvg (NodeType *node, int sum=0, double i=0){
	NodeType *p = node;
	if (p == NULL){
		if (i == 0) return 0;
		else return (sum/i);
	}
	else{
		sum += p->info;
		i = i + 1;
		return TAvg(p->next,sum,i);
	}
}

int ACount (NodeType *node, int sum=0, double i=0, double avg=0, int num=0){
	NodeType *p = node;
	if (p == NULL){
		if (i == 0) {
			avg = 0;
			return num;
		}
		else {
			avg = (sum/i);
			return num;
		}
	}
	else{
		sum += p->info;
		i = i + 1;
		num = ACount(p->next,sum,i,avg,num);
		if (p->info > avg){
			num++;
		}
		return num;
	}
}

int main(){
	int a[SIZE] = {1,2,3,4};
	NodeType *listData = new NodeType;
	listData->info = a[0];
	listData->next = NULL;
	NodeType *p = listData;
	for (int i=1; i<SIZE; i++){
		NodeType *nNode = new NodeType;
		nNode->info = a[i];
		nNode->next = NULL;
		p->next = nNode;
		p=p->next;
	}
	cout<<TSum(listData)<<" "<<TAvg(listData)<<" "<<ACount(listData);
	cout<<endl;
	return 0;
}
