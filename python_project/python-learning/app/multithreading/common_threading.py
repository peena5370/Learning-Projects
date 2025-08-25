import time

class CommonThreading:
    def __init__(self, shared_list):
        self.shared_list = shared_list

    def append_message(self, thread_id, num_of_iteration):
        for i in range(num_of_iteration):
            message = f"Thread {thread_id} appended message {i}"
            self.shared_list.append(message)
            # Add a small delay to simulate work
            time.sleep(0.001)
            print(message)