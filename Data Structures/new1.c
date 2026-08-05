#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Product{
    int id;
    char name[50];
    int qty;
    struct Product *next;
};

struct Product *head=NULL;

void insert(int id,char name[],int qty){

    struct Product *newNode=(struct Product*)malloc(sizeof(struct Product));

    newNode->id=id;
    strcpy(newNode->name,name);
    newNode->qty=qty;
    newNode->next=NULL;

    if(head==NULL){
        head=newNode;
        return;
    }

    struct Product *temp=head;

    while(temp->next!=NULL)
        temp=temp->next;

    temp->next=newNode;
}

void display(){

    struct Product *temp=head;

    while(temp){
        printf("%d %s %d\n",temp->id,temp->name,temp->qty);
        temp=temp->next;
    }
}

void search(int id){

    struct Product *temp=head;

    while(temp){

        if(temp->id==id){
            printf("Product Found\n");
            printf("%d %s %d\n",temp->id,temp->name,temp->qty);
            return;
        }

        temp=temp->next;
    }

    printf("Product Not Found\n");
}

void deleteProduct(int id){

    struct Product *temp=head,*prev=NULL;

    while(temp && temp->id!=id){
        prev=temp;
        temp=temp->next;
    }

    if(temp==NULL){
        printf("Product Not Found\n");
        return;
    }

    if(prev==NULL)
        head=temp->next;
    else
        prev->next=temp->next;

    free(temp);
}

int main(){

    insert(1,"Laptop",20);
    insert(2,"Mouse",50);
    insert(3,"Keyboard",30);

    display();

    search(2);

    deleteProduct(1);

    printf("\nAfter Deletion\n");

    display();

    return 0;
}