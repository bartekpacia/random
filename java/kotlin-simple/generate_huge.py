#!/usr/bin/env python3

import sys

def generate_kotlin_file(n):
    kotlin_code = 'fun main() {\n'
    kotlin_code += '    val name = "Kotlin"\n'
    
    for i in range(n):
        kotlin_code += '    println("Hello, " + name + "!")\n'
    
    kotlin_code += '}\n'
    
    return kotlin_code


def main():
    n = int(sys.argv[1])
    
    kotlin_code = generate_kotlin_file(n)
    
    with open("src/main/kotlin/Huge.kt", 'w') as f:
        f.write(kotlin_code)
    
    print(kotlin_code)


if __name__ == "__main__":
    main()
