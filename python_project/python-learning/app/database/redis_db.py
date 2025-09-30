import redis


def redis_connect(hostname: str, port: int):
    try:
        r = redis.Redis(host=hostname, port=port, db=0, decode_responses=True)
        r.ping()
        print("Python: Successfully connected to Redis!")

        return r
    except Exception as e:
        print(f"Python: Could not connect to Redis: {e}")
        exit()


def set_value(r: redis.Redis, key: str, value: str, ttl: int):
    r.set(key, value, ex=ttl)
    print(f"redis set value: [key={key}, value={value}, ttl={ttl}]")


def get_value(r: redis.Redis, key: str):
    obj = r.get(key)
    print(f"redis get value: [key={key}, value={obj}]")

    return obj


def get_ttl(r: redis.Redis, key: str):
    remaining_ttl = r.ttl(key)
    print(f"remaining ttl={remaining_ttl} for key={key}")

    return remaining_ttl


def delete_value(r: redis.Redis, key: str):
    r.delete(key)
    print(f"redis the key={key} data is deleted")
