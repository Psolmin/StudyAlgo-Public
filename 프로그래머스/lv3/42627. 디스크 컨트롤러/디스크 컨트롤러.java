import java.util.*;

class Solution {
        private class Job {
        int start;
        int time;

        public Job(int start, int time) {
            this.start = start;
            this.time = time;
        }
    }
    
    public int solution(int[][] jobs) {
        List<Integer> answer = new ArrayList<>();

        PriorityQueue<Job> ready = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                if (o1.start == o2.start) {
                    return o1.time - o2.time;
                }
                return o1.start - o2.start;
            }
        });
        for (int[] job : jobs) {
            ready.add(new Job(job[0], job[1]));
        }

        int progress = 0;
        while (!ready.isEmpty()) {
            Job job = ready.poll();

            if (job.start >= progress) {
                answer.add(job.time);

                progress += (job.start - progress) + job.time;
            } else {
                ready.add(job);

                PriorityQueue<Job> pq = new PriorityQueue<>(new Comparator<Job>() {
                    @Override
                    public int compare(Job o1, Job o2) {
                        if (o1.time == o2.time) {
                            return o1.start - o2.start;
                        }
                        return o1.time - o2.time;
                    }
                });
                while (!ready.isEmpty()) {
                    Job temp = ready.poll();

                    if (temp.start >= progress) {
                        ready.add(temp);
                        break;
                    }

                    pq.add(temp);
                }

                job = pq.poll();
                while (!pq.isEmpty()) {
                    ready.add(pq.poll());
                }
                answer.add((progress - job.start) + job.time);

                progress += job.time;
            }
        }

        return answer.stream().mapToInt(i -> i).sum() / jobs.length;
    }
}