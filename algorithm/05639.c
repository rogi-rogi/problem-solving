#include <stdio.h>
#include <stdlib.h>

typedef struct _node {
    int data;
    struct _node *left, *right;
}*pNode;

void postorder(pNode root)
{
    if (root == NULL) return;
    postorder(root->left);
    postorder(root->right);
    printf("%d\n", root->data);
}

pNode make_tree(pNode root, int data)
{
    if (root == NULL) {
        root = (pNode)malloc(sizeof(pNode));
		root->data = data;
		root->left = NULL;
		root->right = NULL;
		return root;
	} else if (data < root->data)
		root->left = make_tree(root->left, data);
	else if (data > root->data)
		root->right = make_tree(root->right, data);
	return root;
}

int main()
{
	int data;
	pNode tree = NULL;
	while (scanf("%d", &data) != EOF)
		tree = make_tree(tree, data); 
	postorder(tree);
}
