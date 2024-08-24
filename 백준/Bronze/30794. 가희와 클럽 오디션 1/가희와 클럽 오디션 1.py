lv, judge = input().split()
lv = int(lv)
dic = {'miss':0, 'bad':200, 'cool':400, 'great':600, 'perfect':1000}
print(dic[judge]*lv)