#include <stdio.h>

int main()
{
  int num[3];
  while (1) {
    for (int i = 0; i < 3; ++i) {
      scanf("%d", &num[i]);
      if (!num[i]) return 0;
    }
    int max = 0, temp = 0;
    for (int i = 0; i < 3; ++i)
      if (num[i] > max)
        max = num[i];
    for (int i = 0; i < 3; ++i)
      if (num[i] != max)
        temp += num[i] * num[i];
      puts(max * max == temp ? "right" : "wrong"); 
  }
}
