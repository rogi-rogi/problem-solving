class Node :
    def __init__(self, num, left, right) :
        self.num = num
        self.left = left
        self.right = right

def preorder(node) :
    print(node.num, end = '')
    if node.left != '.' :  preorder(tree[node.left])
    if node.right != '.' : preorder(tree[node.right])

def inorder(node) :
    if node.left != '.' :  inorder(tree[node.left])
    print(node.num, end = '')
    if node.right != '.' : inorder(tree[node.right])

def postorder(node) :
    if node.left != '.' :  postorder(tree[node.left])
    if node.right != '.' : postorder(tree[node.right])
    print(node.num, end = '')

if __name__ == "__main__" :
    tree = dict()
    for _ in range(int(input())) :
        node, left, right = input().split()
        tree[node] = Node(node, left, right)
    preorder(tree['A'])
    print()
    inorder(tree['A'])
    print()
    postorder(tree['A'])
        
