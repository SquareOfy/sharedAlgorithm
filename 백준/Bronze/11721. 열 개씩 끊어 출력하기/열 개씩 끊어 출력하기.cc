#include <iostream>
#include <algorithm>
#include <string>

using namespace std;


int main()
{
	ios::sync_with_stdio(0);
	string s;
	cin >> s;
	int size_s = s.length();
	int time = size_s / 10;
	if (size_s % 10 != 0) time++;
	
	for (int i = 0; i < time; i++) {
		for (int j = i * 10; j < min(size_s, i * 10 + 10); j++) {
			cout << s[j];
		}
		cout << endl;
	}
	

}
