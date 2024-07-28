money = int(input())
prices = list(map(int, input().split()))


jun = money//prices[0] if prices[0] <= money else money #모두 매수
sung = money #전략

jun_cnt = money//prices[0]
sung_cnt = 0

jun_result = 0
sung_result = 0

#up_cnt가 3이 되면 다음날 하락이므로 전량 매도
up_cnt = 1
#down_cnt가 3이 되면 다음날 상승이믈 전량 매수
#가격이 같다면 상승 하락 아님
down_cnt = 1

for i in range(1, len(prices)):
    p = prices[i]
    if p <= jun:
        jun_cnt += jun//p
        jun -= jun_cnt *p

    if prices[i-1] < prices[i]: #전보다 증가함
        down_cnt= 1
        up_cnt += 1
    elif prices[i-1] > prices[i]:
        down_cnt += 1
        up_cnt = 1
    else:
        down_cnt = 1
        up_cnt = 1
    if down_cnt >= 4:
        if p<=sung:
            sung_cnt += sung//p
            sung -= (sung//p)*p
    elif up_cnt >= 4:
        sung += p*sung_cnt;
        sung_cnt = 0

jun_result += jun+jun_cnt*prices[13]
sung_result += sung+sung_cnt*prices[13]


if jun_result > sung_result:
    print("BNP")
elif jun_result == sung_result:
    print("SAMESAME")
else:
    print("TIMING")