#include <stdio.h>
#include <stdlib.h>

struct Node
{
    int data;
    struct Node *prev;
    struct Node *next;
};

//Funtion to create a new NOde 
struct Node* createNode(int value)
{
    struct Node *newNode;
    // Allocate memory for one node
    newNode = (struct Node *)malloc(sizeof(struct Node));

    //Store data and initialize both links as well
    newNode->data = value;
    newNode->prev = NULL;
    newNode->next = NULL;
    return newNode;

}
struct Node* insertBeginning(struct Node *head, int value)
{
    struct Node *newNode;
    newNode = createNode(value);
    //Newnode points to current first Node
    newNode->next = head;
    //If list is not exmpty, old head prev points to new node
    if(head != NULL)
    {
        head->prev = newNode;
    }
    // New Node becomes head
    head = newNode;

    return head;
}
struct Node* insertEnd(struct Node *head, int value)
{
    struct Node *newNode;
    struct Node *temp;
    newNode = createNode(value);
    // If list is empty, new node becomes first node
    if(head == NULL)
    {
        return newNode;
    }
    // Move temp to last node
    temp = head;
    while(temp->next != NULL)
    {
        temp = temp->next;
    }
    // COnnect last node with new node
    temp->next = newNode;
    newNode->prev = temp;
    return head;
}

struct Node* insertspecific(struct Node *head, int value, int position)
{
    struct Node *newNode = createNode(value);
    struct Node *temp = head;
    int i;

    if(position == 1)
    {
        return insertBeginning(head, value);
    }

    for(i = 1; i < position - 1 && temp != NULL; i++)
    {
        temp = temp->next;
    }

    if(temp == NULL)
    {
        printf("Invalid Position.\n");
        free(newNode);
        return head;
    }

    newNode->next = temp->next;
    newNode->prev = temp;

    if(temp->next != NULL)
    {
        temp->next->prev = newNode;
    }

    temp->next = newNode;

    return head;
}


void traverseForward(struct Node *head)
{
    struct Node *temp= head;

    if(head == NULL)
    {
        printf("List is empty");
        return;
    }

    printf("Forward traversal:");

    while (temp != NULL)
    {
      printf("%d <->", temp-> data);
      temp = temp-> next;
    }

    printf("NULL\n");
    
}



void traversebackward(struct Node *head)
{
    struct Node *temp = head;
    if(head == NULL)
    {
        printf("List is empty.\n");
        return;
    }

    while(temp->next != NULL)
    {
        temp = temp->next;
    }
    printf("Backward Traversal");
    while(temp != NULL)
    {
        printf("%d <->", temp-> data);
      temp = temp-> prev;
    }
    printf("NULL/n");
}

int main()
{
    struct Node *head = NULL;

    // Insert nodes at the end
    head = insertEnd(head, 10);
    head = insertEnd(head, 20);
    head = insertEnd(head, 30);

    // Insert a node at the beginning
    head = insertBeginning(head, 5);

    // Display the list
    traverseForward(head);
    traversebackward(head);

    return 0;
}

