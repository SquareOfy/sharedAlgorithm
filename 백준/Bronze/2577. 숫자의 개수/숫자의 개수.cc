#include <iostream>
#include <string>
using namespace std;

int main()
{   
	int a, b, c;
	cin >> a >> b >> c;
	string str = to_string(a * b * c);
	int cntArr[10];
	for (int i = 0; i < 10; i++) {
		cntArr[i] = 0;
	}
	for (int i = 0; i < str.length(); i++) {
		cntArr[str[i] - '0'] += 1;
	}
	for (int i = 0; i < 10; i++) {
		cout << cntArr[i] << endl;
	}

}
