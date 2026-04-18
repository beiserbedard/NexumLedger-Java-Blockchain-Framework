import hashlib
import time

class PythonBlockchain:
    def __init__(self):
        self.chain = []
        self.create_genesis()

    def create_genesis(self):
        genesis = {
            "index": 0,
            "prev_hash": "0",
            "time": time.time(),
            "data": "Python Genesis"
        }
        genesis["hash"] = self.compute_hash(genesis)
        self.chain.append(genesis)

    def compute_hash(self, block):
        raw = str(block).encode()
        return hashlib.sha256(raw).hexdigest()

    def add_block(self, data):
        last = self.chain[-1]
        new_block = {
            "index": last["index"] + 1,
            "prev_hash": last["hash"],
            "time": time.time(),
            "data": data
        }
        new_block["hash"] = self.compute_hash(new_block)
        self.chain.append(new_block)

if __name__ == "__main__":
    bc = PythonBlockchain()
    bc.add_block("Python Block 1")
    print("Python Blockchain Ready")
