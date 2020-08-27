// A simple example that uses RecursiveTask<V>.

package chapter28concurrencyutilities.forkjoinframework;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

// A RecursiveTask<V> that computes the summation of an array of doubles.
class Sum extends RecursiveTask<Double> {

    // The sequential threshold value.
    final int seqThreshold = 500;

    // Array to be accessed.
    double[] data;

    // Determines what part of data to process.
    int start, end;

    Sum(double[] vals, int s, int e) {
        data = vals;
        start = s;
        end = e;
    }

    // Find the summation of an array of doubles.

    @Override
    protected Double compute() {
        double sum = 0;

        // If number of elements is below the sequential threshold,
        // then process sequentially.
        if ((end - start) < seqThreshold) {
            // Sum the elements.
            for (int i = start; i < end; i++) {
                sum += data[i];
            }
        } else {
            // Otherwise, continue to break the data into smaller pieces.

            // Find the midpoint.
            int middle = (start + end) / 2;

            // Invoke new tasks, using the subdivided data.
            Sum subTaskA = new Sum(data, start, middle);
            Sum subTaskB = new Sum(data, middle, end);

            // Start each subtask by forking.
            subTaskA.fork();
            subTaskB.fork();

            // Wait for the subtasks to return, and aggregate the results.
            sum = subTaskA.join() + subTaskB.join();
        }
        // Return the final sum.
        return sum;
    }
}

// Demonstrate parallel execution.
class RecursiveTaskDemo {
    public static void main(String[] args) {
        // Create a task pool.
        ForkJoinPool fjp = new ForkJoinPool();

        double[] nums = new double[5000];

        // Initialize nums with values that alternate between positive and negative.
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ((i % 2) == 0) ? i : -i;
        }

        Sum task = new Sum(nums, 0, nums.length);

        // Start the ForkJoinTasks. Notice that, in this case, invoke() returns a result.
        double summation = fjp.invoke(task);

        System.out.println("Summation " + summation);
        
    }
}
