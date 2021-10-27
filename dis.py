import dis


def func(a: int, b: int) -> bool:
    if a == 5 and b == 10:
        return True
    else:
        return False


dis.dis(func)
