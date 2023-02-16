from functools import cmp_to_key
from sys import stdin
input = stdin.readline

class Point :
    def __init__(self, x, y) :
        self.x = x
        self.y = y

def CCW(std, A, B) :
    cross_product = (A.x - std.x)*(B.y - std.y) - (B.x - std.x)*(A.y - std.y);
    if cross_product == 0 : return 0
    return [-1, 1][cross_product > 0]
    
class ConvexHull :
    def __init__ (self) :
        self.std_point = None
    
    # order asc y asc x
    def orderASC_YX(self, P1, P2) : 
        if P1.y != P2.y : return [-1, 1][P1.y > P2.y]
        return [-1, 1][P1.x > P2.x]
    
    def orderCCW(self, P1, P2) :
        DIR = CCW(self.std_point, P1, P2)
        if DIR == 0 : return self.orderASC_YX(P1, P2)
        return [1, -1][DIR == 1]    # P1 !== P2
        
    def GrahamScan(self, P, N) :
        P.sort(key = lambda p : (p.y, p.x))
        self.std_point = P[0]
        P1 = P[0]
        del P[0]
        P.sort(key = cmp_to_key(self.orderCCW))
        P2 = P[0]
        del P[0]
        
        stack = [P1, P2]
        for p in P : 
            P3 = p
            while len(stack) > 1 :
                P2 = stack[-1]
                stack.pop()
                if (CCW(stack[-1], P2, P3) == 1) :
                    stack.append(P2)
                    break
            stack.append(P3)
        return len(stack)

if __name__ == "__main__" :
    P = [Point(*map(int, input().split())) for _ in range(int(input()))]
    print(ConvexHull().GrahamScan(P, len(P)))
