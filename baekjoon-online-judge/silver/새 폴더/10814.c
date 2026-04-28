#include <stdio.h>
#include <stdlib.h>
typedef struct{
    char name[101];
    int age;
}Member;

int main(){
    int N, min, max;
    scanf("%d", &N);
    Member m[N];
    for (int i = 0; i < N; i++){
        scanf("%d %s", &m[i].age, m[i].name);
        if (!i)
            max = min = m[i].age;
        else if (min > m[i].age)
            min = m[i].age;
        else if (max < m[i].age)
            max = m[i].age;
    }
    for (int i = min; i <= max; i++)
        for (int j = 0; j < N; j++)
            if (m[j].age == i)
                printf("%d %s\n", m[j].age, m[j].name);
}