#include <iostream>
#include <string>
using namespace std;

int main()
{   
	ios::sync_with_stdio(0);
	int t;
	cin >> t;
	for (int tc = 0; tc < t; tc++) {
		int idx; string str;
		cin >> idx >> str;
		for (int i = 0; i < str.length(); i++) {
			if (i == idx-1) continue;
			cout << str[i];
		}
		cout << endl;
	}
}
