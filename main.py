import random
import time

# Generate random integer array
def gen_array(n):
  arr = [*range(n)]
  random.shuffle(arr)
  return arr

# Method that measures speed of the callback execution 
def measure_time(callback, *args):
  start = time.time()
  result = callback(*args)
  end = time.time()
  print("Elapsed time: " + str(end - start))
  return result

# Main demo
def main():
  # Set test scale
  scale = 10000
  arr = measure_time(gen_array, scale)
  print(arr[0])

# Run main demo
if __name__ == "__main__":
  main()