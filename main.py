import random

# Generate random integer array
def gen_array(n):
  arr = [*range(n)]
  random.shuffle(arr)
  return arr

# Main demo
def main():
  # Set test scale
  scale = 10000
  arr = gen_array(scale)
  print(arr[0])

# Run main demo
if __name__ == "__main__":
  main()