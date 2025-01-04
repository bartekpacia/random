# This must not run on Pico, but on the host computer!

import serial
import time
import sys

# open a serial connection
s = serial.Serial("/dev/cu.usbmodem1101", 115200)

# blink the led
while True:
    s.write(b"ping\n")
    print("sent 'ping'")
    time.sleep(1)
    response = s.readline()
    print(f"received '{response}'")
    time.sleep(1)


