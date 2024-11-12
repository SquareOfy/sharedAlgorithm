#include <iostream>
#include<string>
using namespace std;

string reverse_string(string s) {
	string answer = "";
	for (int i = s.size() - 1; i >= 0; i--) {
		answer += s[i];
	}
	return answer;
}

int main()
{
	ios::sync_with_stdio(0);
	
	string x, y;
	cin >> x >> y;
	string reverse_x = reverse_string(x);
	string reverse_y = reverse_string(y);
	
	int num_x = stoi(reverse_x);
	int num_y = stoi(reverse_y);
	
	cout << stoi(reverse_string(to_string(num_x + num_y)));
}
