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

  for i in range(0, size):
    sorted_array[count[i]] = arr[i]

  return sorted_array

# Apply Distribution Count Sort on arr from minm to maxm
def distribution_count_sort(arr, minm, maxm):
  size = len(arr)
  maxmin = maxm - minm + 1
  sorted_array = [0] * size
  freq = [0] * maxmin

  for i in range(0, size):
    freq[arr[i] - minm] += 1
  for j in range(1, maxmin):
    freq[j] += freq[j-1]

  i = size - 1
  while i >= 0:
      cindex = freq[arr[i] - minm]
      sorted_array[cindex - 1] = arr[i]
      freq[arr[i] - minm] -= 1
      i -= 1

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
  
  # Test distribution_count_sort speed
  print(arr[0])
  sarr = measure_time(distribution_count_sort, arr, min(arr), max(arr))
  print(sarr[0])

# Run main demo
if __name__ == "__main__":
  main()