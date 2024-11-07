#include <iostream>
#include <map>
using namespace std;

int main()
{   
	ios::sync_with_stdio(0);
	map<int, int> numMap;
	int t;
	cin >> t;
	for (int i = 0; i < t; i++) {
		int num;
		cin >> num;
		numMap[num]++;
	}
	int ans;
	cin >> ans;
	cout << numMap[ans];

}
