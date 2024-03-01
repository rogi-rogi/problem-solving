# 03 나이 계산.py
# https://school.programmers.co.kr/learn/courses/19274/lessons/240598

year = int(input())
age_type = input()

if age_type == 'Korea' :
    answer = 2030 - year + 1
elif age_type == "Year" :
    answer = 2030 - year

print(answer)
