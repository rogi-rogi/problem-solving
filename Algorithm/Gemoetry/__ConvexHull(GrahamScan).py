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
    def GrahamScan(self, P, N) :
        P = sorted(P, key = lambda p : p.y)
        stack = []
        pass
        return stack.size()

if __name__ == "__main__" :
    P = [Point(*map(int, input().split())) for _ in range(int(input()))]
    print(ConvexHull().GrahamScan(P, P.size()))
    
