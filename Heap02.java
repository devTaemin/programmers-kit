import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        
        int answer = 0;
        int end = 0;            // 수행 직후 시간
        int index = 0;          // jobs 배열의 인덱스
        int count = 0;          // 수행된 요청 갯수
        
        // 요청시간 기준 오름차순 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        // 처리시간 기준 오름차순 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        // 요청이 모두 수행될 때까지 반복
        while (count < jobs.length) {
            
            // 하나의 작업이 완료되는 시점(end)까지 들어온 요청을 큐에 넣기
            while (index < jobs.length && jobs[index][0] <= end) {
                pq.add(jobs[index++]);
            }
            
            // 큐가 비어있다면 현재 index의 요청 시간을 기준으로 완료 시점을 설정
            if (pq.isEmpty()) {
                end = jobs[index][0];
            }
            // 작업이 완료되는 시점(end) 들어온 요청 중 가장 수행시간이 짧은 요청을 수행
            else {
                int[] process = pq.poll();
                answer += process[1] + (end - process[0]);
                end += process[1];
                count++;
            }
        }

        return answer / jobs.length;
    }
}