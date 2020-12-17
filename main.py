import random
import datetime

# Generate random integer array
def gen_array(n):
  arr = [*range(n)]
  random.shuffle(arr)
  return arr

# Apply Comparison Count Sort on arr
def comparison_count_sort(arr):
  size = len(arr)
  sorted_array = [0] * size
  count = [0] * size

  for i in range(0, size):
    for j in range(i + 1, size):
      if(arr[i] < arr[j]):
        count[j] += 1
      else:
        count[i] += 1

  for i in range(0, size - 1):
    sorted_array[count[i]] = arr[i]

  return sorted_array

# Method that measures speed of the callback execution 
def measure_time(callback, *args):
  start = datetime.datetime.now()
  result = callback(*args)
  end = datetime.datetime.now()
  print("Elapsed time: " + str(end - start))
  return result

# Main demo
def main():
  # Set test scale
  scale = 1000
  arr = gen_array(scale)

  # Test comparison_count_sort speed
  print(arr[0])
  sarr = measure_time(comparison_count_sort, arr)
  print(sarr[0])

# Run main demo
if __name__ == "__main__":
  main()