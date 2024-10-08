# [Gold I] Every? Only One's Marble - 28457 

[문제 링크](https://www.acmicpc.net/problem/28457) 

### 성능 요약

메모리: 108080 KB, 시간: 92 ms

### 분류

구현, 시뮬레이션

### 제출 일자

2024년 10월 3일 11:22:11

### 문제 설명

<p>유틸은 오늘도 혼자 집에 있다. 심심해서 같이 부루마불 게임을 할 사람을 찾아봤지만 아무도 없었다. 그렇게 한 시간, 두 시간... 도저히 참을 수 없었던 유틸은 부루마불 게임을 혼자 할 방법을 생각해 냈다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/83f83ab4-1f43-46fd-bfd0-c7fed32fcd7d/-/preview/" style="height: 405px; width: 400px;"></p>

<p>혼자 하는 부루마불 게임에 적용되는 규칙은 다음과 같다.</p>

<ul>
	<li>일반 칸은 두 종류다.
	<ul>
		<li>도시 칸: 돈을 내고 땅을 사야 하는 칸</li>
		<li>황금 열쇠 칸: 특정한 효과가 있는 카드가 발동되는 칸</li>
	</ul>
	</li>
	<li>특수 칸은 네 종류다.
	<ul>
		<li>시작 칸: 이 칸에 정확히 멈추거나 지나가게 되면, <strong>월급</strong>을 받게 된다.</li>
		<li>무인도 칸: 이 칸에 정확히 멈추게 되면, 다음 <strong>세 턴</strong> 동안 갇히게 된다.
		<ul>
			<li>갇혀 있는 동안, 두 주사위를 던졌을 때 눈이 <strong>같은 수</strong>로 나오면 무인도를 <strong>탈출</strong>하게 되며 <strong>두 주사위를 한 번 더 던져서 나온 수만큼 이동한다</strong>.</li>
		</ul>
		</li>
		<li>사회복지기금 칸: 이 칸에 정확히 멈추게 되면, 지금까지 모인 사회복지기금을 받게 된다. <strong>사회복지기금을 받고 나면, 기부금은 0원이 된다.</strong></li>
		<li>우주여행 칸: 이 칸에 정확히 멈추게 되면, 다음 턴에 <strong>시작</strong> 칸으로 이동한 뒤 주사위를 굴린다.</li>
	</ul>
	</li>
	<li>칸은 총 $4n-4$개가 존재하며, 이 중 정확히 네 개의 칸이 특수 칸이고, 나머지 칸은 일반 칸이다. $1$번째 칸은 시작 칸이고, 처음에 이곳에서 시작한다. $n$번째 칸은 무인도 칸이고, $2n-1$번째 칸은 사회복지기금 칸이다. $3n-2$번째 칸은 우주여행 칸이다. $4n-4$번째 칸과 $1$번째 칸이 연결되어 있음에 유의해야 한다.</li>
	<li>유틸은 매 턴 다음 순서로 행동한다.
	<ul>
		<li>두 주사위 던지기</li>
		<li>두 주사위의 눈만큼 이동하기</li>
		<li>도착한 칸에 따른 행동 수행하기</li>
	</ul>
	</li>
	<li>도시 칸에 도착했을 때 가지고 있는 돈이 땅의 가격보다 많거나 같다면, <strong>반드시</strong> 땅을 구매해야 한다.
	<ul>
		<li>도시 칸의 땅을 이미 구매했거나 현금이 부족해서 땅을 구매할 수 없는 경우에는 아무것도 구매하지 않은 것으로 간주하고 게임을 계속 진행한다.</li>
	</ul>
	</li>
	<li>황금 열쇠는 다음과 같은 종류로 이루어져 있다.
	<ul>
		<li>은행에서 돈 받기</li>
		<li>은행에 돈 주기</li>
		<li>사회복지기금에 돈 기부하기</li>
		<li>특정 칸으로 이동</li>
	</ul>
	</li>
	<li>황금 열쇠에서 특정 칸으로 이동하게 되는 경우
	<ul>
		<li>항상 <strong>정방향($1$ → $2$ → $3$ → ...)</strong>으로 이동한다.</li>
		<li>이동하는 동안 지나치는 칸에서는 아무 일도 일어나지 않는다.</li>
		<li>이동하고 나서 특정 칸에서 일어나야 할 일들(땅 구매, 우주여행 등)이 그대로 일어남에 유의해야 한다.</li>
		<li>시작 칸을 지나는 경우에는 월급도 받게 된다.</li>
		<li><strong>황금 열쇠로 인해서 황금 열쇠 칸으로 이동하는 경우는 없음이 보장된다.</strong></li>
	</ul>
	</li>
	<li>모든 턴이 지났을 때 구매하지 않은 도시 칸이 남아 있지 않다면 유틸이 <strong>승리</strong>하고, 그렇지 않다면 <strong>패배</strong>한다.</li>
	<li>황금 열쇠에서 돈을 지불하거나 기부해야 하는데 현금이 부족한 경우, 유틸이 <strong>패배</strong>한다. <strong>도시 칸의 땅을 모두 구매했더라도 모든 턴이 지나기 전에 현금이 부족하면 패배할 수 있음을 유의하라.</strong></li>
</ul>

<p>각 칸에 대한 정보와 황금 열쇠 리스트는, 게임 시작 시점에 주어지고, 정확히 그 순서대로 뽑히게 된다. 모든 황금 열쇠를 사용한 경우에는 리스트의 처음부터 다시 뽑게 된다.</p>

### 입력 

 <p>첫 번째 줄에는 보드의 크기 $n$, 시작 시 가지는 돈 $S$, 시작점을 지나면 받게 되는 월급 $W$, 황금 열쇠 카드의 개수 $G$가 주어진다. ($3\leq n\leq 10$, $1\leq G\leq 4n-8$, $1\leq S,W\leq 10^7$)</p>

<p>그다음 $G$개의 줄에는 다음과 같이 황금 열쇠 카드의 정보가 주어진다. 먼저 입력되는 카드일수록 먼저 뽑히게 된다. ($1\leq x \leq 10^7$, $1\leq y \leq 4n-5$)</p>

<ul>
	<li><code>1</code> $x$: 은행에서 $x$원을 받는다.</li>
	<li><code>2</code> $x$: 은행에 $x$원을 준다.</li>
	<li><code>3</code> $x$: 사회복지기금에 $x$원을 기부한다.</li>
	<li><code>4</code> $y$: 앞으로 $y$칸 이동한다.</li>
</ul>

<p>그다음 $4n-8$개의 줄에는 차례대로 특수 칸이 아닌 것들의 정보가 입력된다. 황금 열쇠 칸이면 <code>G</code>가, 아닌 경우에는 <code>L</code>과 땅 가격 $p$가 공백을 사이에 두고 주어진다. ($1\leq p \leq 100\ 000$)</p>

<p>그다음으로 게임을 하는 동안 던지는 주사위의 횟수 $I$가 주어진다. ($1\leq I\leq 60$)</p>

<p>그다음 $I$개의 줄에는 차례대로 주사위 두 개의 눈이 공백을 두고 주어진다. 주사위의 눈은 $1$에서 $6$ 사이이다.</p>

### 출력 

 <p>유틸이 혼자 하는 부루마불에서 이겼다면 <code>WIN</code>을, 졌다면 <code>LOSE</code>를 출력한다.</p>

