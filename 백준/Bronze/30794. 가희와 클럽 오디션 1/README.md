# [Bronze IV] 가희와 클럽 오디션 1 - 30794 

[문제 링크](https://www.acmicpc.net/problem/30794) 

### 성능 요약

메모리: 108080 KB, 시간: 92 ms

### 분류

사칙연산, 구현, 수학, 문자열

### 제출 일자

2024년 8월 24일 16:31:53

### 문제 설명

<p><strong>게임 클럽 오디션의 <code>scoring system</code>과 문제에서의 <code>scoring system</code>이 다름에 주의하세요.</strong></p>

<p>가희는 클럽 오디션을 하고 있습니다. 이 게임에는 여러 모드가 있는데 가희는 8키 모드를 하고 있습니다. 8키 모드에서는 레벨이 6 이상인 키 노트가 등장합니다. 레벨이 $lv$인 키 노트 안에는 $lv$개의 키가 있습니다.  키의 방향은 8 방향 중 (상, 하, 좌, 우, 좌상, 좌하, 우상, 우하) 하나입니다.</p>

<p style="text-align: center;"><img alt="" src="https://u.acmicpc.net/69cb163b-a407-4318-9ed8-f03847fba2e1/1%20-%20%EB%B3%B5%EC%82%AC%EB%B3%B8.png"></p>

<p style="text-align: center;"><strong>[그림 1]</strong> 레벨 6의 키 노트</p>

<p>[그림 1]은 4개의 그림으로 구성되어 있습니다. 노란색으로 칠해져 있는 것은 이미 친 키를, 파란색으로 칠해진 것은 쳐야 하는 키를 의미합니다. 예를 들어, 그림 1의 오른쪽 위의 경우 좌하, 우, 우상, 하 순서대로 쳐야 함을 의미합니다.</p>

<p>1번째 줄의 왼쪽 위는 레벨 6의 키 노트가 나타난 직후입니다. 오른쪽 위 그림은 키 노트가 나오고 나서 1/4 타이밍만큼 지났을 때를 나타냅니다. 왼쪽 아래 그림은 레벨 6의 키 노트가 나오고 1/2 타이밍만큼 지났을 때를 나타냅니다. 이 때 6개의 키를 모두 친 상태입니다. 오른쪽 아래 그림은 타이밍에 맞게 <code>Space</code>키를 눌러서 <code><span style="color:#e74c3c;">perfect</span> </code>판정을 획득한 것을 나타냅니다.</p>

<p>각 키 노트는 판정이 있습니다. 이 때 아래 2가지 경우는 <span style="color:#e74c3c;"><code>miss</code></span> 판정이 발생합니다.</p>

<ul>
	<li><code>lv</code>개의 방향을 올바르게 입력하지 않은 경우</li>
	<li><code>Space</code>를 누르지 않았거나 <code>Space</code>를 눌렀을 때 타이밍을 맞추지 못한 경우</li>
</ul>

<p>그렇지 않으면 <span style="color:#e74c3c;"><code>bad</code></span>, <span style="color:#e74c3c;"><code>cool</code></span>, <span style="color:#e74c3c;"><code>great</code></span>, <span style="color:#e74c3c;"><code>perfect</code></span> 판정 중 하나가 발생합니다. 또한 <span style="color:#e74c3c;"><code>perfect</code></span>는 한 가지 상태가 더 있습니다. 바로 $n$연팩. $n$번 연속 <span style="color:#e74c3c;"><code>perfect</code></span> 판정이 난 상태를 $n$연팩이라 합니다. 발생한 키 노트의 판정이 <span style="color:#e74c3c;"><code>perfect</code></span>일 때</p>

<ul>
	<li>이전 판정이 <span style="color:#e74c3c;"><code>perfect</code></span>가 아닌 경우 $1$연팩입니다.</li>
	<li>이전 판정이 <span style="color:#e74c3c;"><code>perfect</code></span>이고 $k$연팩 상태였다면 $k+1$연팩이 됩니다.</li>
</ul>

<p>레벨이 $lv$인 키 노트의 판정에 따른 점수 획득은 아래와 같습니다.</p>

<ul>
	<li><span style="color:#e74c3c;"><code>miss</code></span>일 때 $0$점을 받습니다.</li>
	<li><span style="color:#e74c3c;"><code>bad</code></span>일 때 $200$에 $lv$을 곱한 점수를 받습니다.</li>
	<li><span style="color:#e74c3c;"><code>cool</code></span>일 때 $400$에 $lv$을 곱한 점수를 받습니다.</li>
	<li><span style="color:#e74c3c;"><code>great</code></span>일 때 $600$에 $lv$을 곱한 점수를 받습니다.</li>
	<li><span style="color:#e74c3c;"><code>perfect</code></span>
	<ul>
		<li>$n$연팩일 때 $n \cdot lv$에 $1\,000$을 곱한 점수를 받습니다.</li>
	</ul>
	</li>
</ul>

<p>가희가 친 키 노트의 레벨 $lv$과 판정이 주어집니다. <strong>가희가 이전에 받은 판정과 다른 판정을 받았을 때</strong> 획득한 점수를 구해주세요.</p>

### 입력 

 <p>첫 줄에 키 노트의 $lv$과 판정이 공백으로 구분되어 주어집니다. 이때 판정은 <span style="color:#e74c3c;"><code>miss</code></span>, <span style="color:#e74c3c;"><code>bad</code></span>, <span style="color:#e74c3c;"><code>cool</code></span>, <span style="color:#e74c3c;"><code>great</code></span>, <span style="color:#e74c3c;"><code>perfect</code></span>중 하나로 주어집니다.</p>

### 출력 

 <p>가희가 획득한 점수를 출력해 주세요.</p>

