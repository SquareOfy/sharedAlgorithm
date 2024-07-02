import sys

input = sys.stdin.readline

grade_dic = dict()
grade_dic['A+'] = 4.3
grade_dic['A0'] = 4.0
grade_dic['A-'] = 3.7
grade_dic['B+'] = 3.3
grade_dic['B0'] = 3.0
grade_dic['B-'] = 2.7
grade_dic['C+'] = 2.3
grade_dic['C0'] = 2.0
grade_dic['C-'] = 1.7
grade_dic['D+'] = 1.3
grade_dic['D0'] = 1.0
grade_dic['D-'] = 0.7
grade_dic['F'] = 0.0

grade = input().rstrip()

print(grade_dic[grade])