# [Bronze I] 수면 패턴 - 19843 

[문제 링크](https://www.acmicpc.net/problem/19843) 

### 성능 요약

메모리: 108080 KB, 시간: 108 ms

### 분류

구현

### 제출 일자

2023년 12월 31일 19:25:05

### 문제 설명

<p>사회적 거리두기와 휴학으로 인해 집콕 생활에 익숙해진 민티는 수면 패턴이 자꾸 깨져서 걱정이다.</p>

<p>민티는 건강을 위해 앞으로는 꼭 일주일에 <span style="font-style: italic;">T</span>시간 이상 잠을 자기로 결심했다. 매일 같은 시간 자고 일어나는 것은 아직 너무 힘들기 때문에, 평일에 자고 일어난 시각을 기록해 두고 주말에 모자란 만큼 몰아서 자기로 했다. 민티는 한번 잠들면 최소 1시간 이상 잠을 자며, 가끔은 일어나자마자 너무 졸려서 바로 다시 잠들기도 한다.</p>

<p>평일이 다 지나고, 민티에게 마음껏 잘 수 있는 48시간의 주말이 주어졌다. 민티는 평일에 자신이 적어 놓은 기록을 보고 주말 동안 몇 시간을 자야 하는지 계산하려고 한다.</p>

<p>민티가 평일 동안 잠든 시간과 일어난 시간이 주어질 때, 주말에 자야 할 최소 시간을 출력하라.</p>

### 입력 

 <p>일주일에 자야 할 시간을 나타내는 정수 <span style="font-style: italic;">T</span>와 민티가 평일 동안 잠든 횟수를 나타내는 정수 <span style="font-style: italic;">N</span>이 주어진다.</p>

<p>다음 줄부터 <span style="font-style: italic;">N</span>개의 줄에 민티가 잠든 시간이 주어진다. 각 줄에 <span style="font-style: italic;">D</span><sub>1</sub>, <span style="font-style: italic;">H</span><sub>1</sub>, <span style="font-style: italic;">D</span><sub>2</sub>, <span style="font-style: italic;">H</span><sub>2</sub>의 순서로 민티가 잠든 시각과 일어난 시각이 주어진다. <span style="font-style: italic;">D</span><sub>1</sub>은 잠든 요일, <span style="font-style: italic;">H</span><sub>1</sub>은 잠든 시각, <span style="font-style: italic;">D</span><sub>2</sub>는 일어난 요일, <span style="font-style: italic;">H</span><sub>2</sub>는 일어난 시각을 의미한다. 요일은 <code>Mon</code>, <code>Tue</code>, <code>Wed</code>, <code>Thu</code>, <code>Fri</code> 중 하나이며, 각각 월요일, 화요일, 수요일, 목요일, 금요일을 의미한다. 시각은 0 이상 23 이하의 정수로 주어지며, 각각 0시부터 23시까지의 시각을 의미한다.</p>

<p>각 수면은 서로 겹치지 않지만, 민티가 일어났다가 바로 잠들 수 있기 때문에 한 수면의 잠든 시각과 다른 수면의 일어난 시각이 동일한 경우가 있을 수 있다. 수면의 시작과 끝은 항상 평일이며, 입력은 잠든 시각이 빠른 순으로 정렬된 상태로 주어진다. 민티가 평일 동안 잠을 아예 자지 않는 경우가 존재할 수 있음에 유의하라.</p>

### 출력 

 <p>민티가 주말에 더 자야 할 시간을 출력한다. 만약 주말에 잠을 자지 않아도 충분할 경우 <code>0</code>을, 주말 내내 자도 부족할 경우 <code>-1</code>을 출력한다.</p>

