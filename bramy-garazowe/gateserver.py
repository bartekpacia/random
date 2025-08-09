from http.server import BaseHTTPRequestHandler, HTTPServer
import RPi.GPIO as GPIO
import time

host = '0.0.0.0'
port = 8080

GPIO.setmode(GPIO.BCM)
GPIO.setwarnings(False)

# Piny dla bramy wjazdowej:
# GND -> Pin 6
# PRZYC -> Pin 8 (GPIO 14)
# 3V3 -> Pin 1

PIN_WJAZDOWA = 14
GPIO.setup(PIN_WJAZDOWA, GPIO.OUT)
GPIO.output(PIN_WJAZDOWA, GPIO.HIGH) # pilot bramy wjazdowej jest aktywowany stanem niskim

# Piny dla bramy garażowej:
# GND -> Pin 9
# 3V3 -> Pin 17
# ACTIVE HIGH -> Pin 12 (GPIO 18)

PIN_GARAZOWA = 18
GPIO.setup(PIN_GARAZOWA, GPIO.OUT)
GPIO.output(PIN_GARAZOWA, GPIO.LOW) # pilot bramy garażowej jest aktywowany stanem wysokim

class MyHandler(BaseHTTPRequestHandler):

    def do_GET(self):
        print('New request! path = %s' % self.path)

        if self.path.endswith('wjazdowa'):
            GPIO.output(PIN_WJAZDOWA, GPIO.LOW)
            print('--> wjazdowa: start naciskania przycisku')
            time.sleep(0.5)
            GPIO.output(PIN_WJAZDOWA, GPIO.HIGH)
            print('--> wjazdowa: stop naciskania przycisku')
        elif self.path.endswith('garazowa'):
            GPIO.output(PIN_GARAZOWA, GPIO.HIGH)
            print('--> garażowa: start naciskania przycisku')
            time.sleep(2)
            GPIO.output(PIN_GARAZOWA, GPIO.LOW)
            print('--> garażowa: stop naciskania przycisku')
        else:
            print('Nieznana brama!')

        self.send_response(200)
        self.send_header('Content-Type', 'text/plain')
        self.end_headers()

        self.wfile.write(bytes("This is response body. Hi!", encoding='utf8'))

server = HTTPServer((host, port), MyHandler)
print('Server is running at http://%s:%s' % (host, port))
server.serve_forever()
