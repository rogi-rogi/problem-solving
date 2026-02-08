#include <cmath>
#include <iostream>
using namespace std;

int main()
{
    double area;
    cin >> area;
    cout.setf(ios::fixed);
    cout.precision(7);
    cout << sqrt(area) * 4;
}
