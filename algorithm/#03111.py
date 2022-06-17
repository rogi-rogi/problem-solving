from collections import deque 

if __name__ == "__main__" :
    A = input()
    T = input()
    A_first_chr = A[0]
    A_last_chr = A[-1]
    len_A = len(A)
    queue = deque([*T])
    left_stack, right_stack = [], []
    reverse = False
    while queue :
        if reverse :
            right_stack.append(queue.pop())
            if right_stack[-1] == A_first_chr and ''.join(right_stack[-len_A:]) == A[::-1] :
                del right_stack[-len_A:]
                reverse = not reverse
        else :
            left_stack.append(queue.popleft())
            if left_stack[-1] == A_last_chr and ''.join(left_stack[-len_A:]) == A :
                del left_stack[-len_A:]
                reverse = not reverse
    stack = []
    for s in left_stack + right_stack[::-1] :
        stack.append(s)
        if s == A_last_chr and ''.join(stack[-len_A:]) == A :
            del stack[-len_A:]
    print(''.join(stack))
