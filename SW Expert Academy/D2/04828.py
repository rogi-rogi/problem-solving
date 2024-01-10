'''
[파이썬 S/W 문제해결 기본] 1일차 - min max
https://swexpertacademy.com/main/learn/course/lectureProblemViewer.do
'''
for TC in range(1, int(input()) + 1):
    input()
    nums = [*map(int, input().split())]
    print(f"#{TC} {max(nums) - min(nums)}")
