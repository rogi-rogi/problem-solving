from sys import stdin
from math import gcd
input = stdin.readline

def list_mul(input_list) :
    return int(eval('*'.join([i for i in input_list])))
    
if __name__ == "__main__" : 
    N = input()
    mul_n_list = list_mul(list(map(str, input().split())))
    M = input()
    mul_m_list = list_mul(list(map(str, input().split())))
    print(str(gcd(mul_n_list, mul_m_list))[-9:])
