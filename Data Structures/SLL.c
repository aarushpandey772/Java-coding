#include <stdio.h>
#include <stdlib.h>

struct Node
{
    int data;
    struct Node *next;
};

struct Node *head = NULL;

void traverse (struct NOde *head)
{
    struct Node *temp = head;

    if (head == NULL)
    {
        printf("List is empty");
        return;
    }
    while(temp != NULL)
    {
        printf("%d ->", temp -> data);
        temp = temp -> next;
    }
    printf("NULL\n");
}

struct Node* insertBeginning(struct Node *head, int value)
{
    struct Node *newNode;

    newNode= (struct Node *)malloc(sizeof(struct Node));

    newNode = (struct Node *)malloc(sizeof(struct Node));
    newNode->data = value;
    newNode ->next = head;

    return newNode;

}


struct Node* insertEnd(struct Node *head, int value)
{
    struct Node *newNode;
    struct Node *temp;


    newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode-> data = value;
    newNode->next = NULL;

    if(head == NULL)
    {
        return newNode;
    }

    temp = head;

    while(temp->next !=NULL)
    {
        temp = temp->next;

    }
    temp->next = newNode;
    return head;
}


struct Node* insertPosition(struct Node *head, int value, int position)
{
    struct Node *newNode;
    struct Node *temp;
    int i;

    if(position ==1)
    {
        return insertBeginning(head,value);

    }

    temp=head;

    //Move to the node before the required position
    for(i=1;i<position-1 && temp !=NULL; i++)
    {
        temp = temp ->next;
    }

if(temp == NULL)
{
    printf("Invalid Position.\n");
    return head;
}

newNode = (struct Node*)malloc(sizeof(struct Node));
newNode-> data = value;
newNode -> next = temp->next;
temp->next =newNode;
return head;
}

void deleteBeginning()
{
    struct Node *temp;

    if(head == NULL)
    {
        printf("\nList is Empty\n");
        return;
    }

    temp = head;
    head = head->next;
    free(temp);

    printf("\nFirst Node Deleted\n");
}

void deleteEnd()
{
    struct Node *temp,*prev;

    if(head == NULL)
    {
        printf("\nList is Empty\n");
        return;
    }

    if(head->next == NULL)
    {
        free(head);
        head = NULL;
        printf("\nOnly Node Deleted\n");
        return;
    }

    temp = head;

    while(temp->next != NULL)
    {
        prev = temp;
        temp = temp->next;
    }

    prev->next = NULL;
    free(temp);

    printf("\nLast Node Deleted\n");
}


void deleteSpecified(int pos)
{
    struct Node *temp,*prev;
    int i;

    if(head == NULL)
    {
        printf("\nList is Empty\n");
        return;
    }

    if(pos == 1)
    {
        temp = head;
        head = head->next;
        free(temp);
        printf("\nNode Deleted\n");
        return;
    }

    temp = head;

    for(i=1;i<pos;i++)
    {
        prev = temp;
        temp = temp->next;

        if(temp == NULL)
        {
            printf("\nInvalid Position\n");
            return;
        }
    }

    prev->next = temp->next;
    free(temp);

    printf("\nNode Deleted from Position %d\n",pos);
}



int main()
{
    head = insertEnd(head,10);
    head = insertEnd(head,20);
    head = insertEnd(head,30);
    head = insertEnd(head,40);

    printf("Initial Linked List:\n");
    traverse(head);

    head = insertBeginning(head,5);
    printf("\nAfter Insert at Beginning:\n");
    traverse(head);

    head = insertEnd(head,50);
    printf("\nAfter Insert at End:\n");
    traverse(head);

    head = insertPosition(head,25,4);
    printf("\nAfter Insert at Position 4:\n");
    traverse(head);

    deleteBeginning();
    printf("\nAfter Delete at Beginning:\n");
    traverse(head);

    deleteEnd();
    printf("\nAfter Delete at End:\n");
    traverse(head);

    deleteSpecified(3);
    printf("\nAfter Delete at Position 3:\n");
    traverse(head);
    

    return 0;
}
