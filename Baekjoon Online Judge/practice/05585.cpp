#include <iostream>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // Input
    int price;
    cin >> price;
    price = 1000 - price;

    // Solve
    int cnt = 0;
    int money_list[6] = {500, 100, 50, 10, 5, 1};
    for (int money : money_list)
    {
        if (price - money >= 0)
        {
            cnt += price / money;
            price %= money;
        }
    }

    // Output
    cout << cnt;
}
