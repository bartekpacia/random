import sys
import time
import threading

def print_logs():
    logs = [
        "w: This is a warning",
        "w: Another warning",
        "w: Yet another warning"
    ]
    for log in logs:
        sys.stdout.write(f'\r{log}\n')
        sys.stdout.flush()
        time.sleep(2)

def update_progress():
    for i in range(100):
        sys.stdout.write(f'\rProgress: [{i}%]')
        sys.stdout.flush()
        time.sleep(0.1)

# Run logging and progress bar concurrently
log_thread = threading.Thread(target=print_logs)
progress_thread = threading.Thread(target=update_progress)

log_thread.start()
progress_thread.start()

log_thread.join()
progress_thread.join()

sys.stdout.write('\nDone!\n')
