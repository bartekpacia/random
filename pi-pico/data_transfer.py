import time
import sys

while True:
    # read a command from the host
    v = sys.stdin.readline().strip()
    print(f"received '{v}'")
    time.sleep(1)

    sys.stdout.print(b"pong\n")
    #  sys.stdout.write(b"pong\n")
    print("sent 'pong'")
