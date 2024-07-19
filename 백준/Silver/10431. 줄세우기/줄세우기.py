import sys

input = sys.stdin.readline

p = int(input())

for _ in range(1,p+1):
    idx, *students = map(int, input().split())

    cnt = 0
    sorted_students = [students[0]]

    for i in range(1,20):
        flag = True
        for j in range(len(sorted_students)):
            if students[i]<sorted_students[j]:
                sorted_students.insert(j, students[i])
                cnt+= i-j
                flag = False
                break
        if(flag): sorted_students.append(students[i])

    print(f"{idx} {cnt}")


