#include <iostream>
#include <string>
using namespace std;

int main()
{   
    string a; string b;
    cin >> a >> b;
    string reversedA, reversedB;
    for (int i=a.length()-1; i >= 0; i--) {
        reversedA += a[i];
        reversedB += b[i];
    }
    cout << max(stoi(reversedA), stoi(reversedB));
}
