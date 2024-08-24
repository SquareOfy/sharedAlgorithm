dic = {'w':'chunbae', 'b':'nabi', 'g':'yeongcheol'}
def find():
    for i in range(15):
        for j in range(15):
            if arr[i][j] in ('w', 'b', 'g'):
                print(dic[arr[i][j]])
                return
arr = [input().split() for _ in range(15)]
find()