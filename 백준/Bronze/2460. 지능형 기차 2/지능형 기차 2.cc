#include <iostream>
#include <string>
using namespace std;

int main()
{   
    int answer = 0; int now = 0;
    int down, up;
    for (int i = 0; i < 10; i++) {
        cin >> down >> up;
        now -= down;
        now += up;
        answer = max(answer, now);
    }

    cout << answer;

}
