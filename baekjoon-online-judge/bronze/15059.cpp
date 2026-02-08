#include <iostream>
using namespace std;

int main()
{
    int Ca, Ba, Pa, Cr, Br, Pr;
    cin >> Ca >> Ba >> Pa >> Cr >> Br >> Pr;
    int cnt = 0;
    if (Ca < Cr) cnt += Cr - Ca;
    if (Ba < Br) cnt += Br - Ba;
    if (Pa < Pr) cnt += Pr - Pa;
    cout << cnt;
}
