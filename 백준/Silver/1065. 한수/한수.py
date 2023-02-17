def check_seq(a):
        
        hansu_count = 0
        for i in range(1,a+1):
                if i < 100:
                        hansu_count += 1
                else:
                        check_list = list(map(int, str(i)))
                        diff_set = set()
                        for j in range(len(str(i))-1):
                                d = check_list[j]-check_list[j+1]
                                diff_set.add(d)
                        if len(diff_set) == 1:
                                hansu_count +=1
                
        return hansu_count
N = int(input())
print(check_seq(N))