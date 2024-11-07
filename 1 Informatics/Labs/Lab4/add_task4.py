import time

start = time.time()
for i in range(100):
    import main
end = time.time()
print(f"Time for main.py - {end-start} seconds")

start = time.time()
for i in range(100):
    import add_task1
end = time.time()
print(f"Time for add_task1.py - {end-start} seconds")

start = time.time()
for i in range(100):
    import add_task2
end = time.time()
print(f"Time for add_task2.py - {end-start} seconds")

start = time.time()
for i in range(100):
    import add_task3
end = time.time()
print(f"Time for add_task3.py - {end-start} seconds")